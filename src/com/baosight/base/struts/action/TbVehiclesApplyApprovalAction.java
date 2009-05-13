package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbUser;
import com.baosight.mode.TbVehiclesApply;
import com.baosight.struts.action.BaseDispatchAction;

public class TbVehiclesApplyApprovalAction extends BaseDispatchAction {
	
	/*读取用车审批列表*/
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List tbVehiclesApplyList=this.tbVehiclesApplyMgr.findByProperty("status", new Long(2));
		
		String userName;
		for (Object object : tbVehiclesApplyList) {
			TbVehiclesApply record=(TbVehiclesApply)object;
			userName=userMgr.find(record.getApplyer()).getName();
			record.setApplyer(userName);
		}
		long count=tbVehiclesApplyList.size();
		startPagingCount(null, request,count);
		startPaging(tbVehiclesApplyList, null, request);
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)  {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String auditor = user.getId();
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		TbVehiclesApply tbVehiclesApply = tbVehiclesApplyMgr.findById(id);
		tbVehiclesApply.setAuditor(auditor);
		tbVehiclesApply.setStatus(new Long(action));
		this.tbVehiclesApplyMgr.update(tbVehiclesApply);
		return mapping.findForward("success");
	}
}
