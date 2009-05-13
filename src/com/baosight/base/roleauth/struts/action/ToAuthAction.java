package com.baosight.base.roleauth.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IFunctionMgr;

public class ToAuthAction extends Action {
	private IFunctionMgr functionMgr;

	public IFunctionMgr getFunctionMgr() {
		return functionMgr;
	}

	public void setFunctionMgr(IFunctionMgr functionMgr) {
		this.functionMgr = functionMgr;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String role = request.getParameter("role");
		String[] funList = request.getParameterValues("fun");
		String[] isDefList = request.getParameterValues("isDef");
		functionMgr.toAuth(role, funList,isDefList);
		request.setAttribute("op", "toAuth");

		return mapping.findForward("success");
	}

}
