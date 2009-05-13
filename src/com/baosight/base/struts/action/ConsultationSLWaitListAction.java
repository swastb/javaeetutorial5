package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbConsultationOnline;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class ConsultationSLWaitListAction extends BaseDispatchAction {
	public ITbConsultationOnlineMgr tbConsultationOnlineMgr;

	public void setTbConsultationOnlineMgr(
			ITbConsultationOnlineMgr tbConsultationOnlineMgr) {
		this.tbConsultationOnlineMgr = tbConsultationOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List consultationSLWaitList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		long count=0;
		consultationSLWaitList = this.tbConsultationOnlineMgr
				.findConsultationSLWaitList(subject);
		count=consultationSLWaitList.size();
		startPagingCount(null, request,count);
		startPaging(consultationSLWaitList, null, request);
		return mapping.findForward("consultationslwaitlist");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		TbConsultationOnline tbConsultationOnline = this.tbConsultationOnlineMgr.findById(id);
		this.tbConsultationOnlineMgr.delete(tbConsultationOnline);
		
		super.tbUserOpeationMgr.SaveOrUpdate("","10","minus");
		return new ActionForward("/consultationSLWaitListAction.do?method=list&subject="+subject);
	}

}
