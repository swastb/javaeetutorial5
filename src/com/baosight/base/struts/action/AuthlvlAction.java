package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbAuthlvl;
import com.baosight.struts.action.BaseDispatchAction;

public class AuthlvlAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List allauthlvl = this.authlvlMgr.findAll();
		request.setAttribute("allauthlvl", allauthlvl);
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String name = (String) ((DynaValidatorForm) form).get("name");
			String code = (String) ((DynaValidatorForm) form).get("code");
			String ename = (String) ((DynaValidatorForm) form).get("ename");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			TbAuthlvl item = this.authlvlMgr.find(id);
			item.setCode(code);
			item.setName(name);
			item.setEname(ename);
			item.setRem(rem);
			this.authlvlMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbAuthlvl item = this.authlvlMgr.find(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("ename", item.getEname());
				((DynaValidatorForm) form).set("rem", item.getRem());
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			authlvlMgr.delete(id);
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
				String code = (String) ((DynaValidatorForm) form).get("code");
				String ename = (String) ((DynaValidatorForm) form).get("ename");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				TbAuthlvl item = new TbAuthlvl(name, ename, code, rem);
				this.authlvlMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
}
