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
import com.baosight.struts.action.BaseDispatchAction;

public class OpinionSLOverListAction extends BaseDispatchAction {
	public ITbOpinionOnlineMgr tbOpinionOnlineMgr;

	public void setTbOpinionOnlineMgr(
			ITbOpinionOnlineMgr tbOpinionOnlineMgr) {
		this.tbOpinionOnlineMgr = tbOpinionOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List opinionSLOverList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		opinionSLOverList = this.tbOpinionOnlineMgr
				.findOpinionSLOverList(subject);
		long count=opinionSLOverList.size();
		startPagingCount(null, request,count);
		startPaging(opinionSLOverList, null, request);
		return mapping.findForward("opinionsloverlist");
	}
}
