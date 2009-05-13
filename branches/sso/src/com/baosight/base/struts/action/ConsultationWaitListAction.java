package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class ConsultationWaitListAction extends BaseDispatchAction {
	public ITbConsultationOnlineMgr tbConsultationOnlineMgr;

	public void setTbConsultationOnlineMgr(
			ITbConsultationOnlineMgr tbConsultationOnlineMgr) {
		this.tbConsultationOnlineMgr = tbConsultationOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List consultationWaitList = null;
		String type = request.getParameter("type");
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();	
		long count=0;
		consultationWaitList = this.tbConsultationOnlineMgr
				.findConsultationWaitList(subject,userId,type);
		count=consultationWaitList.size();
		startPagingCount(null, request,count);
		startPaging(consultationWaitList, null, request);
		return mapping.findForward("consultationwaitlist");
	}
}
