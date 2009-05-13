package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbGroup;
import com.baosight.struts.action.BaseDispatchAction;

public class GroupAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List allGroup = this.groupMgr.findAll();
		request.setAttribute("allgroup", allGroup);
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String code = (String) ((DynaValidatorForm) form).get("code");
			String name = (String) ((DynaValidatorForm) form).get("name");
			String deptCode = (String) ((DynaValidatorForm) form).get("deptcode");
			String lvl = (String) ((DynaValidatorForm) form).get("lvl");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			TbGroup item = this.groupMgr.find(id);
			item.setCode(code);
			item.setName(name);
			item.setDeptCode(deptCode);
			item.setLvl(lvl);
			item.setRem(rem);
			this.groupMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbGroup item = this.groupMgr.find(id);
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("deptcode", item.getDeptCode());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("lvl", item.getLvl());
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
			groupMgr.delete(id);
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
				String code = (String) ((DynaValidatorForm) form).get("code");
				String name = (String) ((DynaValidatorForm) form).get("name");
				String deptCode = (String) ((DynaValidatorForm) form).get("deptcode");
				String lvl = (String) ((DynaValidatorForm) form).get("lvl");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				TbGroup item = new TbGroup(code, name, deptCode, lvl, rem);
				this.groupMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
}
