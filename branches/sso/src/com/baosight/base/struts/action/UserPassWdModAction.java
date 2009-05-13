package com.baosight.base.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class UserPassWdModAction extends BaseDispatchAction {
	public ActionForward passwdModReq(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		return mapping.findForward("passwdmod");
	}
	
	public ActionForward passwdModDo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String newpw = request.getParameter("newpwd");
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		user.setPwd(newpw);
		this.userMgr.update(user);
		
		request.setAttribute("success", "true");
		
		return mapping.findForward("success");
	}
}
