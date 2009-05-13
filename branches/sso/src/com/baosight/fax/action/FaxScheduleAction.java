package com.baosight.fax.action;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;

import com.baosight.base.service.ICommonalityMgr;
import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.struts.action.DocAttachAction;
import com.baosight.fax.bean.ListSearchBean;
import com.baosight.fax.mode.TbFaxSchedule;
import com.baosight.fax.service.ScheduleMgr;
import com.baosight.mode.TbDocAttach;
import com.baosight.mode.TbSmsSchedule;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:发送传真</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-15</p>
 */
public class FaxScheduleAction extends BaseDispatchAction{

	private ScheduleMgr scheduleMgr;
	protected DocAttachAction attachAction;
	public ActionForward input(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
//		String id = request.getParameter("id");
//		if(id!=null && !"".equals(id)){
//			TbFaxSchedule item = scheduleMgr.findById(id);
//			setBaseInfo((DynaActionForm) form,info);
//		}
		return mapping.findForward("goInput");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		TbFaxSchedule item = new TbFaxSchedule();
		scheduleMgr.save(item);
		String type = null;
		String filePath = "";
		String fileName = null;
		String fileId="";
		String coutentCenter=request.getParameter("bodyContent");
		String senderIds=request.getParameter("senderIds");
		String sendSM=request.getParameter("sendSM");
		MultipartRequestHandler multipartRequestHandler=form.getMultipartRequestHandler();
		Hashtable files =multipartRequestHandler.getFileElements();
		if(files.size()>0){
			for (Enumeration e = files.keys(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				FormFile file = (FormFile) files.get(key);
				if("fileUpload".equals(key)){
					type=IDocServiceMgr.UPLOAD_TYPE_FAX_CONTENT;
					fileName = file.getFileName().trim();
					fileId = getAttachAction().saveAttachFile(file, type, item.getId(), IDocServiceMgr.UPLOAD_PATH_FAX);
					filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
					filePath += "/docAttach.do?method=download&id="+fileId;
					item.setContent(filePath);
				}else{
					type=IDocServiceMgr.UPLOAD_TYPE_FAX_ATTACH;
					getAttachAction().saveAttachFile(file, type, item.getId(), IDocServiceMgr.UPLOAD_PATH_FAX);
				}
			}
		}
		TbUser user = getCurrentUser(request);
		String faxNum = request.getParameter("faxNum");
		if(faxNum!=null && !"".equals(faxNum)){
			String[] faxs = faxNum.split(";");
			
			for(int i=0;i<faxs.length;i++){
				if(i>0){
					item = new TbFaxSchedule();
				}
				item.setContent(filePath);
				item.setFax(faxs[i]);
				item.setState("000");
				item.setSender(user.getName());
				item.setSenderid(user.getId());
				item.setSenddeptid(user.getDeptCode());
				item.setFileName(fileName);
				item.setContent1(coutentCenter);
				item.setIssms(sendSM);
				item.setFileid(fileId);
				item.setSenddate(new Date(System.currentTimeMillis()));
				item.setMphone(this.commonalityMgr.checkMphone(null, faxs[i]));
				scheduleMgr.save(item);
				//传真发送完毕，给传真接受者短信提示
				if(sendSM!=null && !"".equals(sendSM)){
					TbSmsSchedule tbSms = new TbSmsSchedule();
					tbSms.setDestNumber(this.commonalityMgr.checkMphone(null, faxs[i]));
					tbSms.setScheduletime(new Date());
					tbSms.setSenduserid(user.getId());
					tbSms.setSenddepartid(user.getDeptCode());
					tbSms.setMessageContent("接收传真号为："+faxs[i]+"的传真已经发出，请注意查收，"+user.getName());
					tbSms.setDepartid("");
					tbSms.setSystype("SMS_SYSTEM");
					tbSms.setSendBy("MAS_XXZX");
					this.smsScheduleMgr.save(tbSms);
				}
			}
			
		}
		return mapping.findForward("goInput");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String state = request.getParameter("state");
		if(state==null || "".equals(state)){
			state="000";
		}
		ListSearchBean searchBean = new ListSearchBean();
		searchBean.setState(state);
		searchBean.setStartTime(request.getParameter("startTime"));
		searchBean.setEndTime(request.getParameter("endTime"));
		searchBean.setFaxNum(request.getParameter("faxNum"));
		request.setAttribute("list", scheduleMgr.findByCondition(searchBean));
		return mapping.findForward("list");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		scheduleMgr.delete(scheduleMgr.findById(id));
		return mapping.findForward("list");
	}

	public ActionForward deleteAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String allId = request.getParameter("allId");
		if(allId!=null && !"".equals(allId)){
			String[] ids = allId.split(",");
			for(int i=0;i<ids.length;i++){
				scheduleMgr.delete(scheduleMgr.findById(ids[i]));
			}
		}
		return mapping.findForward("list");
	}

	protected DocAttachAction getAttachAction(){
		if(attachAction==null){
			attachAction = new DocAttachAction();
			attachAction.setDocAttachMgr(docAttachMgr);
			attachAction.setServlet(this.getServlet());
		}
		return attachAction;		
	}

	public void setScheduleMgr(ScheduleMgr scheduleMgr) {
		this.scheduleMgr = scheduleMgr;
	}


}
