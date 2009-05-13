package com.baosight.base.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.IFunctionMgr;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbPstlvl;
import com.baosight.mode.TbRighttype;
import com.baosight.struts.action.BaseDispatchAction;

public class RightTypeAction extends BaseDispatchAction {

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String appsysID = request.getParameter("strappsysID");
		String functionID = request.getParameter("strfunctionID");

		// if(appsysID==null)
		// {
		// appsysID="402881e4196f861e01196f91dbcc0004";
		// }
		// if(functionID==null)
		// {
		// functionID="402881e919758e2a011975969a030004";
		// }

		// 所属应用系统列表
		List tb_appsys = this.appSysMgr.findForAppSys();

		// 所属资源列表
		if (appsysID == null) {
			if (tb_appsys.size() > 0) {
				TbAppsys objtbappsys = (TbAppsys) tb_appsys.get(0);
				appsysID = objtbappsys.getId();
			}
		}
		List tb_function = this.functionMgr.findFunBySysId(appsysID);

		if (functionID == null) {
			if (tb_function.size() > 0) {
				TbFunction objtbfunction = (TbFunction) tb_function.get(0);
				functionID = objtbfunction.getId();
			}
		}

		// 资源实体
		TbFunction tbfunction = new TbFunction();
		tbfunction.setId(functionID);
		tbfunction.setSysId(appsysID);

		// 查询应用系统列表 和 所属资源列表是否匹配
		List flaglist = this.functionMgr.findRightTypeByFunction(tbfunction);

		// 所说资源实体
		TbRighttype instance = new TbRighttype();
		instance.setAppsysid(appsysID);

		if (flaglist.size() > 0) {
			instance.setFunid(functionID);
		} else {

			if ("".equals(functionID)) {
				if (tb_function.size() > 0) {
					TbFunction objtbfunction = (TbFunction) tb_function.get(0);
					instance.setFunid(objtbfunction.getId());
				} else {
					instance.setFunid("");
				}
			} else {
				instance.setFunid(functionID);
			}
		}

		List allRighttype = new ArrayList();
		if (appsysID != null) {
			allRighttype = this.rightTypeMgr.findByExample(instance);
		}

		request.setAttribute("strappsysID", appsysID);
		request.setAttribute("strfunctionID", functionID);

		request.setAttribute("allrighttype", allRighttype);

		request.setAttribute("tb_appsys", tb_appsys);
		request.setAttribute("tb_function", tb_function);

		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String name = (String) ((DynaValidatorForm) form).get("name");
			Long code = (Long) ((DynaValidatorForm) form).get("code");
			String appsysid = (String) ((DynaValidatorForm) form)
					.get("appsysid");
			String funid = (String) ((DynaValidatorForm) form).get("funid");
			Long insure=(Long) ((DynaValidatorForm) form).get("insure");
			
			
			TbRighttype item = this.rightTypeMgr.find(id);
			item.setCode(code);
			item.setName(name);
			item.setAppsysid(appsysid);
			item.setFunid(funid);
			item.setInsure(insure);

			this.rightTypeMgr.updte(item);
			return new ActionForward("/righttypeaction.do?method=list&action=list&strappsysID="+appsysid+"&strfunctionID="+funid);
			
		} else {
			if (id != null && !id.equals("")) {
				TbRighttype item = this.rightTypeMgr.find(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("code", item.getCode());
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("insure", item.getInsure());

				String insureflag = "";
				// １启用 ０不启用
				if (1 == item.getInsure()) {
					insureflag = "true";
				} else {
					insureflag = "false";
				}
				request.setAttribute("insureflag", insureflag);
				
				request.setAttribute("item", item);

				// 从页面接受系统id 和 资源id
				String appsysID = (String) request.getParameter("appsysID");
				String functionID = (String) request.getParameter("functionID");

				List appSysList = new ArrayList();
				TbAppsys tbappsys = this.appSysMgr.find(appsysID);
				appSysList.add(tbappsys);

				// List appSysList = functionMgr.findAllAppSys();
				if (appSysList != null && appSysList.size() != 0) {
					request.setAttribute("appSysList", appSysList);

					TbFunction tbfunction = functionMgr.findById(functionID);
					List firFunList = new ArrayList();
					firFunList.add(tbfunction);

					// List firFunList = functionMgr.findFunBySysId(item
					// .getAppsysid());
					request.setAttribute("firFunList", firFunList);
				}
				request.setAttribute("modifyflag", "modify");
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id != null && !id.equals("")) {
			rightTypeMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				// 从页面接受系统id 和 资源id
				String appsysID = (String) request.getParameter("appsysID");
				String functionID = (String) request.getParameter("functionID");

				// List appSysList = functionMgr.findAllAppSys();
				List appSysList = new ArrayList();
				TbAppsys tbappsys = this.appSysMgr.find(appsysID);
				appSysList.add(tbappsys);

				if (appSysList != null && appSysList.size() != 0) {
					request.setAttribute("appSysList", appSysList);
					TbAppsys tbAppsys = (TbAppsys) appSysList.get(0);

					TbFunction tbfunction = functionMgr.findById(functionID);
					List firFunList = new ArrayList();
					firFunList.add(tbfunction);
					// List firFunList =
					// functionMgr.findFunBySysId(tbAppsys.getId());
					request.setAttribute("firFunList", firFunList);
				}
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String name = (String) ((DynaValidatorForm) form).get("name");
				Long code = (Long) ((DynaValidatorForm) form).get("code");
				String appsysid = (String) ((DynaValidatorForm) form)
						.get("appsysid");
				String funid = (String) ((DynaValidatorForm) form).get("funid");
				Long insure = (Long) ((DynaValidatorForm) form).get("insure");

				TbRighttype item = new TbRighttype();
				item.setCode(code);
				item.setName(name);
				item.setAppsysid(appsysid);
				item.setFunid(funid);
				item.setInsure(insure);
				this.rightTypeMgr.save(item);
				return new ActionForward("/righttypeaction.do?method=list&action=list&strappsysID="+appsysid+"&strfunctionID="+funid);
			}
		}
		return mapping.findForward("list");
	}

	public ActionForward getFunction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sysId = request.getParameter("sysId");
		StringBuffer xml = new StringBuffer();
		List funList = functionMgr.findFunBySysId(sysId);
		Iterator iterator = funList.iterator();

		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<functions>\r\n");
		while (iterator.hasNext()) {
			xml.append("<function>\r\n");
			TbFunction function = (TbFunction) iterator.next();
			xml.append("<id>" + function.getId() + "</id>\r\n");
			xml.append("<name>" + function.getName() + "</name>\r\n");
			xml.append("<funKey>" + function.getFunKey() + "</funKey>\r\n");
			xml.append("<sysId>" + function.getSysId() + "</sysId>\r\n");
			xml.append("<parId>" + function.getParId() + "</parId>\r\n");
			xml.append("<isnode>" + (function.getNode() > 0) + "</isnode>\r\n");
			xml.append("<insure>" + function.getInuse() + "</insure>\r\n");
			xml.append("</function>\r\n");
		}
		xml.append("</functions>");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/xml;charset=GBK");
		System.out.println("------------" + xml.toString());
		try {
			response.getWriter().print(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
