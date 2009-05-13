package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class AppsysAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List allappSys = this.appSysMgr.findAll();
		request.setAttribute("allappSys", allappSys);
		return mapping.findForward("list");
	}
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String name = (String) ((DynaValidatorForm) form).get("name");
			String url = (String) ((DynaValidatorForm) form).get("url");
			String code = (String) ((DynaValidatorForm) form).get("code");
			String rem = (String) ((DynaValidatorForm) form).get("rem");
			Long ischild = (Long) ((DynaValidatorForm) form).get("ischild");
			Long insure = (Long) ((DynaValidatorForm) form).get("insure");

			TbAppsys item = this.appSysMgr.find(id);
			item.setName(name);
			item.setUrl(url);
			item.setCode(code);
			item.setRem(rem);
			item.setIschild(ischild);
			item.setInsure(insure);

			this.appSysMgr.updte(item);
			((DynaValidatorForm) form).set("ischild", item.getIschild());
			((DynaValidatorForm) form).set("insure", item.getInsure());

			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbAppsys item = this.appSysMgr.find(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("url", item.getUrl());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("rem", item.getRem());
				((DynaValidatorForm) form).set("ischild", item.getIschild());
				((DynaValidatorForm) form).set("insure", item.getInsure());

				String insureflag = "";
				// £±∆Ù”√ £∞≤ª∆Ù”√
				if (1 == item.getInsure()) {
					insureflag = "true";
				} else {
					insureflag = "false";
				}
				request.setAttribute("insureflag", insureflag);

				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			appSysMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				// ((DynaValidatorForm) form).set("insure",
				// Long.parseLong("0"));
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String name = (String) ((DynaValidatorForm) form).get("name");
				String url = (String) ((DynaValidatorForm) form).get("url");
				String code = (String) ((DynaValidatorForm) form).get("code");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				Long ischild = (Long) ((DynaValidatorForm) form).get("ischild");
				Long insure = (Long) ((DynaValidatorForm) form).get("insure");

				TbAppsys item = new TbAppsys(name, url, code, rem, ischild,
						insure);
				this.appSysMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
}
