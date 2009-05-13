package com.baosight.base.struts.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbShareFileMgr;
import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbFilesendAttachment;
import com.baosight.mode.TbShareFile;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class ShareFileListAction extends BaseDispatchAction {
	public ITbShareFileMgr tbShareFileMgr;

	public void setTbShareFileMgr(ITbShareFileMgr tbShareFileMgr) {
		this.tbShareFileMgr = tbShareFileMgr;
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List shareFileList = null;
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		String type = request.getParameter("type");
		shareFileList = this.tbShareFileMgr
				.findShareFileList(type, userId);
		long count=shareFileList.size();
		startPagingCount(null, request,count);
		startPaging(shareFileList, null, request);
		return mapping.findForward("sharefilelist");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		TbShareFile tbShareFile = this.tbShareFileMgr.findById(id);
		this.tbShareFileMgr.delete(tbShareFile);
		return new ActionForward("/shareFileListAction.do?method=list&type="+type);
	}	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id=(String)request.getParameter("id");
		TbShareFile tbShareFile  = this.tbShareFileMgr.findById(id);
	    String fullPath = this.getServlet().getServletContext().getRealPath("/")+"UploadFile\\"+tbShareFile.getServerName();    
	    FileInputStream file = new FileInputStream(fullPath);   
	    //解决中文文件名下载问题
	    String filename = new String(tbShareFile.getOriginallyName().getBytes("GBK"),"ISO_8859_1");
	    response.setContentType("application/octet-stream;charset=GBK");      
	    response.setHeader("Content-Disposition", "attachment;filename="+ filename);   
	    ServletOutputStream out = response.getOutputStream();   
	    out.flush();   
	    byte buffer[] = new byte[1024];   
	    int size;   
	    while ((size = file.read(buffer)) != -1) {   
	        out.write(buffer, 0, size);   
	        out.flush();   
	    }
	    file.close();   
	    out.close();
		return null;
	}	
}
