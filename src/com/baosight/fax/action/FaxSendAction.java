package com.baosight.fax.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.impl.DocAttachMgrImpl;
import com.baosight.fax.mode.TbFaxSchedule;
import com.baosight.fax.service.ScheduleMgr;

public class FaxSendAction extends TimerTask  {
	private ScheduleMgr scheduleMgr;
	private DocAttachMgrImpl docAttachMgr;
	private static final String REMOTE_PATH="Z:\\FI_TO_TC\\";
	private static final String LOCAL_PATH="E:\\FI_TO_TC\\";
	public ActionForward senFax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 得到所有的传真信息
		// System.out.println("schedulemgr===="+scheduleMgr);
		List list = scheduleMgr.findAll();
		// System.out.println("list size====="+list.size());
		for (int index = 0; index < list.size(); index++) {
			try {
				TbFaxSchedule tbFaxSchedule = new TbFaxSchedule();
				tbFaxSchedule = (TbFaxSchedule) list.get(index);
				// 向传真服务器共享目录写文件
				long curratetime = System.currentTimeMillis();
				FileWriter fileread = new FileWriter(LOCAL_PATH + curratetime
						+ index + ".txt", false);
				fileread
						.write("SUBJECT=”TOPCALL Open Message Format Description”, NF=ALL\n");
				fileread.write("FROM: SERVICE=TCFI, NUMBER=XXZX\n");
				copy("D:/workspace/sso/WebRoot/UploadFile/fax/aa.txt",
						LOCAL_PATH + curratetime + index + ".do");

				// 记录传真发送

				fileread.write("TO: C1=" + tbFaxSchedule.getSenderid()
						+ ", C2=" + tbFaxSchedule.getFax() + ", C3="
						+ "记录插入发送纪录的返回值" + ", C4=, SERVICE=FAX, NUMBER="
						+ tbFaxSchedule.getFax() + "\n");
				fileread.write("TXT:\n");
				fileread.write("" + "\n");
				fileread.write(":ATT:NAME=" + curratetime + ".do, APPLICATION="
						+ curratetime + "\n");
				fileread.close();
			} catch (Exception ex) {
				System.out.println("ex====" + ex);
			}
		}
		return null;
	}

	public static void copy(String from, String to) throws IOException {
		int BUFF_SIZE = 100000;
		byte[] buffer = new byte[BUFF_SIZE];
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(from);
			out = new FileOutputStream(to);

			while (true) {
				synchronized (buffer) {
					int amountRead = in.read(buffer);

					if (amountRead == -1) {
						break;
					}

					out.write(buffer, 0, amountRead);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}

			if (out != null) {
				out.close();
			}
		}
	}

	public void setScheduleMgr(ScheduleMgr scheduleMgr) {
		this.scheduleMgr = scheduleMgr;
	}

	@Override
	public void run() {
		
//		System.out.println("test============");
		// 得到所有的传真信息
		List list=scheduleMgr.findByStatus();
		for(int index=0;index<list.size();index++){
//			System.out.println("test==ee==========");
			TbFaxSchedule tbFaxSchedule = null;
			tbFaxSchedule=(TbFaxSchedule) list.get(index);
			if(tbFaxSchedule==null || tbFaxSchedule.getId()==null){
				continue;
			}
			try{
				// 向传真服务器共享目录写文件
				long curratetime=System.currentTimeMillis();
				FileWriter fileread=new FileWriter(REMOTE_PATH+curratetime+index+".txt",false);
				fileread.write("SUBJECT=”TOPCALL Open Message Format Description”, NF=ALL\n");
				fileread.write("FROM: SERVICE=TCFI, NUMBER=XXZX\n");
				String[] end=tbFaxSchedule.getFileName().split(".");
				copy(PathgetAction.url+"/UploadFile/fax/"+tbFaxSchedule.getFileid()+end[1],REMOTE_PATH+curratetime+index+".do");
				//copy("D:/workspace/sso/WebRoot/UploadFile/fax/aa.txt","E:\\FI_TO_TC\\"+curratetime+index+".do");
				//记录传真发送
				tbFaxSchedule.setState("001");
				this.scheduleMgr.update(tbFaxSchedule);
				fileread.write("TO: C1="+tbFaxSchedule.getSenderid()+", C2="+tbFaxSchedule.getFax()+", C3="+tbFaxSchedule.getId()+", C4=, SERVICE=FAX, NUMBER="+tbFaxSchedule.getFax()+"\n");
				fileread.write("TXT:\n");
				fileread.write(tbFaxSchedule.getContent()+"\n");
				fileread.write(":ATT:NAME="+curratetime+index+".do, APPLICATION="+curratetime+index+".txt\n");
				fileread.close();
			}catch (Exception ex){
				tbFaxSchedule.setState("002");
				tbFaxSchedule.setFaxflag(ex.getMessage());
				scheduleMgr.update(tbFaxSchedule);
			}
		}
		
	}

	public void setDocAttachMgr(DocAttachMgrImpl docAttachMgr) {
		this.docAttachMgr = docAttachMgr;
	}
}
