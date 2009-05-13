package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.INotiesMgr;
import com.baosight.mode.TbNoties;
import com.baosight.mode.TbNotiesId;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class NotiesAction extends BaseDispatchAction{
	private INotiesMgr notiesMgr;

	public void setNotiesMgr(INotiesMgr notiesMgr) {
		this.notiesMgr = notiesMgr;
	}

	public ActionForward findNoties(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getName();
		//List notiesList=this.notiesMgr.findByParam(receiversId);
		
		List notiesList=this.notiesMgr.findByParam("");
		request.setAttribute("notiesList",notiesList);
		
		
		
		
		return mapping.findForward("list");
	}
}
