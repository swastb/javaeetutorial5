package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class AppealWaitListAction extends BaseDispatchAction {
	public ITbAppealOnlineMgr tbAppealOnlineMgr;

	public void setTbAppealOnlineMgr(
			ITbAppealOnlineMgr tbAppealOnlineMgr) {
		this.tbAppealOnlineMgr = tbAppealOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List appealWaitList = null;
		String type = request.getParameter("type");
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();	
		long count=0;
		appealWaitList = this.tbAppealOnlineMgr
				.findAppealWaitList(subject,userId,type);
		count= appealWaitList.size();
		startPagingCount(null, request,count);
		startPaging(appealWaitList, null, request);
		return mapping.findForward("appealwaitlist");
	}
}
