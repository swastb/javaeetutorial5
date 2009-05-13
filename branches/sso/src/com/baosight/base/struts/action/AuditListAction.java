package com.baosight.base.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbArchivesApply;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class AuditListAction extends BaseDispatchAction {
	public ActionForward auditList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List auditList = null;
		auditList = super.tbArchivesMgr.findAuditList();
		long count=0;
		count=auditList.size();
		startPagingCount(null, request,count);
		startPaging(auditList, null, request);
		return mapping.findForward("auditList");
	}

	// 批准与驳回
	public ActionForward auditApply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String result = request.getParameter("result");
		String applyId = request.getParameter("applyId");
		TbArchivesApply tbArchivesApply = super.tbArchivesApplyMgr
				.findById(applyId);
		TbUser user = (TbUser) request.getSession().getAttribute(
				"SYSTEM_USER_SESSION");
		String userId = user.getId();
		tbArchivesApply.setAuditor(userId);
		tbArchivesApply.setAuditTime(new Date());
		tbArchivesApply.setResult(result);
		super.tbArchivesApplyMgr.update(tbArchivesApply);
		super.tbUserOpeationMgr.archiveApplySaveOrUpdate("minus");
		return mapping.findForward("success");
	}
}
