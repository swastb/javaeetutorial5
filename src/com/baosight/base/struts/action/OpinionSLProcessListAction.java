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

public class OpinionSLProcessListAction extends BaseDispatchAction {
	public ITbOpinionOnlineMgr tbOpinionOnlineMgr;

	public void setTbOpinionOnlineMgr(
			ITbOpinionOnlineMgr tbOpinionOnlineMgr) {
		this.tbOpinionOnlineMgr = tbOpinionOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List opinionSLProcessList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		opinionSLProcessList = this.tbOpinionOnlineMgr
				.findOpinionSLProcessList(subject);
		long count=opinionSLProcessList.size();
		startPagingCount(null, request,count);
		startPaging(opinionSLProcessList, null, request);
		return mapping.findForward("opinionslprocesslist");
	}
}
