package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbFilesendMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class FileSendInListAction extends BaseDispatchAction {
public ITbFilesendMgr tbFilesendMgr;


public void setTbFilesendMgr(ITbFilesendMgr tbFilesendMgr) {
	this.tbFilesendMgr = tbFilesendMgr;
}

public ActionForward list(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {	
	List fileSendInList=null;
	long count=0;
	TbUser user = (TbUser) request.getSession().getAttribute(
			"SYSTEM_USER_SESSION");
	String userId = user.getId();
	fileSendInList=this.tbFilesendMgr.findFileSendIn(userId);	
	count=fileSendInList.size();
	startPagingCount(null, request,count);
	startPaging(fileSendInList, null, request);
	return mapping.findForward("fileSendInList");
}
public ActionForward delete(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {	
	TbUser user = (TbUser) request.getSession().getAttribute(
			"SYSTEM_USER_SESSION");
	String userId = user.getId();
	String id = request.getParameter("id");
	this.tbFilesendMgr.update(id, userId);
	return mapping.findForward("success");
}
}
