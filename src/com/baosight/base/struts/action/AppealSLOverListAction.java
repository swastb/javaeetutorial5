package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.struts.action.BaseDispatchAction;

public class AppealSLOverListAction extends BaseDispatchAction {
	public ITbAppealOnlineMgr tbAppealOnlineMgr;

	public void setTbAppealOnlineMgr(
			ITbAppealOnlineMgr tbAppealOnlineMgr) {
		this.tbAppealOnlineMgr = tbAppealOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List appealSLOverList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		long count=0;
		appealSLOverList = this.tbAppealOnlineMgr
				.findAppealSLOverList(subject);
		count=appealSLOverList.size();
		startPagingCount(null, request,count);
		startPaging(appealSLOverList, null, request);
		return mapping.findForward("appealsloverlist");
	}
}
