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
import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbConsultationOnline;
import com.baosight.mode.TbOpinionOnline;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class OpinionSLWaitListAction extends BaseDispatchAction {
	public ITbOpinionOnlineMgr tbOpinionOnlineMgr;

	public void setTbOpinionOnlineMgr(
			ITbOpinionOnlineMgr tbOpinionOnlineMgr) {
		this.tbOpinionOnlineMgr = tbOpinionOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List opinionSLWaitList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		opinionSLWaitList = this.tbOpinionOnlineMgr
				.findOpinionSLWaitList(subject);
		long count=opinionSLWaitList.size();
		startPagingCount(null, request,count);
		startPaging(opinionSLWaitList, null, request);
		return mapping.findForward("opinionslwaitlist");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		TbOpinionOnline tbOpinionOnline = this.tbOpinionOnlineMgr.findById(id);
		this.tbOpinionOnlineMgr.delete(tbOpinionOnline);
		super.tbUserOpeationMgr.SaveOrUpdate("","40","minus");
		return new ActionForward("/opinionSLWaitListAction.do?method=list&subject="+subject);
	}

}
