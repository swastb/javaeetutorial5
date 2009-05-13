package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.base.service.ITbOpinionOnlineMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class OpinionWaitListAction extends BaseDispatchAction {
	public ITbOpinionOnlineMgr tbOpinionOnlineMgr;

	public void setTbOpinionOnlineMgr(
			ITbOpinionOnlineMgr tbOpinionOnlineMgr) {
		this.tbOpinionOnlineMgr = tbOpinionOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List opinionWaitList = null;
		String type = request.getParameter("type");
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();		
		opinionWaitList = this.tbOpinionOnlineMgr
				.findOpinionWaitList(subject,userId,type);
		long count=opinionWaitList.size();
		startPagingCount(null, request,count);
		startPaging(opinionWaitList, null, request);
		return mapping.findForward("opinionwaitlist");
	}
}
