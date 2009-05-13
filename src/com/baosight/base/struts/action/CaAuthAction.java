package com.baosight.base.struts.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.baosight.base.service.ITbUserMgr;
import com.baosight.mode.TbUser;

public class CaAuthAction extends DispatchAction {
	private ITbUserMgr userMgr;

	public ITbUserMgr getUserMgr() {
		return userMgr;
	}
	public void setUserMgr(ITbUserMgr userMgr) {
		this.userMgr = userMgr;
	}

	public ActionForward caAuth(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=GBK");
		String detail = request.getParameter("detail");
		String result = "false";		
		try {
			HttpSession session = request.getSession();
			TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
			if(user!=null){
				result = this.userMgr.caAuth(user.getUserAcc(),detail);
			}			
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	

}
