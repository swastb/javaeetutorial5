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

public class ConsultationOverListAction extends BaseDispatchAction {
	public ITbConsultationOnlineMgr tbConsultationOnlineMgr;

	public void setTbConsultationOnlineMgr(
			ITbConsultationOnlineMgr tbConsultationOnlineMgr) {
		this.tbConsultationOnlineMgr = tbConsultationOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List consultationOverList = null;
		String type = request.getParameter("type");
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();	
		long count=0;
		consultationOverList = this.tbConsultationOnlineMgr
				.findConsultationOverList(subject,userId,type);
		count=consultationOverList.size();
		startPagingCount(null, request,count);
		startPaging(consultationOverList, null, request);
		return mapping.findForward("consultationoverlist");
	}
}
