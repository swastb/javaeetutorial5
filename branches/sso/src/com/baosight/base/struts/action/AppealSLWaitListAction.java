package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbConsultationOnline;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class AppealSLWaitListAction extends BaseDispatchAction {
	public ITbAppealOnlineMgr tbAppealOnlineMgr;

	public void setTbAppealOnlineMgr(
			ITbAppealOnlineMgr tbAppealOnlineMgr) {
		this.tbAppealOnlineMgr = tbAppealOnlineMgr;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List appealSLWaitList = null;
		String subject = request.getParameter("subject");
		if (subject == null) {
			subject = "";
		}
		long count=0;
		appealSLWaitList = this.tbAppealOnlineMgr
				.findAppealSLWaitList(subject);
		count=appealSLWaitList.size();
		//count=this.tbAppealOnlineMgr.findCountAppealOverList(subject);
		startPagingCount(null, request,count);
		startPaging(appealSLWaitList, null, request);
		return mapping.findForward("appealslwaitlist");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		TbAppealOnline tbAppealOnline = this.tbAppealOnlineMgr.findById(id);
		this.tbAppealOnlineMgr.delete(tbAppealOnline);
		super.tbUserOpeationMgr.SaveOrUpdate("","20","minus");
		return new ActionForward("/appealSLWaitListAction.do?method=list&subject="+subject);
	}

}
