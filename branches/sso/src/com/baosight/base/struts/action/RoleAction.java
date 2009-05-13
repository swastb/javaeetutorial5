package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbRole;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class RoleAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String action = request.getParameter("action");
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		
		List allRole=null;
		long count=0;
		if(action!=null&&action.equals("selectByName"))
		{
			allRole=this.roleMgr.findByName(name, code);
			request.setAttribute("name", name);
			request.setAttribute("code", code);
			count=allRole.size();
		}
		else
		{
			allRole = this.roleMgr.findAll();
			count=allRole.size();
//			request.setAttribute("name", "");
//			request.setAttribute("code", "");
		}
		startPagingCount(null, request,count);
		startPaging(allRole, null, request);
		return mapping.findForward("list");
	}
	public ActionForward listForUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		List allRole = this.roleMgr.findAll();
		request.setAttribute("allrole", allRole);
		return mapping.findForward("list");
	}
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String name = (String) ((DynaValidatorForm) form).get("name");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			String code = (String) ((DynaValidatorForm) form).get("code");
			Long insure = (Long) ((DynaValidatorForm) form).get("insure");
			TbRole item = this.roleMgr.find(id);
			item.setName(name);
			item.setCode(code);
			item.setRem(rem);
			item.setInsure(insure);
			this.roleMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbRole item = this.roleMgr.find(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("rem", item.getRem());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("insure", item.getInsure());
				request.setAttribute("insureOn", item.getInsure()==1?"isontrue":"isonfalse");
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			roleMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String name = (String) ((DynaValidatorForm) form).get("name");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				String code = (String) ((DynaValidatorForm) form).get("code");
				Long insure = (Long) ((DynaValidatorForm) form).get("insure");
				TbRole item = new TbRole(name, rem,insure,code);
				this.roleMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
	/**
	 * 用户所属角色列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward roleOfUserList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session=request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		List userroleList = this.userRoleMgr.getUserRoleList(user);
		request.setAttribute("userroleList", userroleList);
		return mapping.findForward("success");
	}
}
