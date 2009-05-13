package com.baosight.base.function.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.IAppSysMgr;
import com.baosight.base.service.IFunctionMgr;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;

public class ForwardFunctionAction extends DispatchAction {
	private IFunctionMgr functionMgr;
	private IAppSysMgr appSysMgr;

	public IAppSysMgr getAppSysMgr() {
		return appSysMgr;
	}

	public void setAppSysMgr(IAppSysMgr appSysMgr) {
		this.appSysMgr = appSysMgr;
	}

	public IFunctionMgr getFunctionMgr() {
		return functionMgr;
	}

	public void setFunctionMgr(IFunctionMgr functionMgr) {
		this.functionMgr = functionMgr;
	}
	
	

	public ActionForward inputShowFunTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("inputShowFunTree");
	}

	public ActionForward showFunTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fid = request.getParameter("fid");
		StringBuffer xml = new StringBuffer();
		List funList = functionMgr.findAllForTree(fid);
		Iterator iterator = funList.iterator();

		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<functions>\r\n");
		if (fid.equals("0")) {
			xml.append("<isFirst>\r\n");
			xml.append("<first>" + "true" + "</first>");
			xml.append("</isFirst>");
		} else {
			xml.append("<isFirst>");
			xml.append("<first>" + "false" + "</first>");
			xml.append("</isFirst>");
		}
		while (iterator.hasNext()) {
			xml.append("<function>\r\n");
			TbFunction function = (TbFunction) iterator.next();
			xml.append("<id>" + function.getId() + "</id>\r\n");
			xml.append("<title><![CDATA[" + function.getName() + "]]></title>\r\n");
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

	public ActionForward inputAddFun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String root = request.getParameter("root");
		if (root != null && root.equals("true")) {
			request.setAttribute("root", "true");
			request.setAttribute("appSysList", functionMgr.findAllAppSys());
			request.setAttribute("rightTypeList", functionMgr.findAllRightType());
		}
		if (root != null && root.equals("false")) {
			request.setAttribute("root", "false");
			request.setAttribute("fid", request.getParameter("id"));
			String sysid = request.getParameter("sid");
			TbAppsys appsys = this.appSysMgr.find(sysid);
			int newDeforder = this.functionMgr.getDeforderByParId(request.getParameter("id"))+1;
			String sysname = appsys.getName();
			request.setAttribute("newDeforder", newDeforder);
			request.setAttribute("sysname", sysname);
			request.setAttribute("sys", appsys);
			request.setAttribute("sysid", request.getParameter("sid"));
			request.setAttribute("appSysList", functionMgr.findAllAppSys());
			request.setAttribute("rightTypeList", functionMgr.findAllRightType());
		}
		
		return mapping.findForward("inputAddFun");
	}

	public ActionForward addFun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm funForm = (DynaValidatorForm) form;
		String root = request.getParameter("root");
		functionMgr.save(funForm, root);
		if (root != null && root.equals("true")) {
			request.setAttribute("op", "addRoot");
		} else if (root != null && root.equals("false")) {
			request.setAttribute("op", "add");
		}
		return mapping.findForward("addFun");
	}

	public ActionForward inputUpdateFun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm funForm = (DynaValidatorForm) form;
		String id = request.getParameter("id");
		if (id != null && id != "") {
			TbFunction tbFunction = functionMgr.findById(id);
			request.setAttribute("tbFunction", tbFunction);
			request.setAttribute("appSysList", functionMgr.findAllAppSys());
			request.setAttribute("rightTypeList", functionMgr.findAllRightType());
			request.setAttribute("rightTypeListByFun", functionMgr.findRightTypeByFunction(tbFunction));
			String sysid = request.getParameter("sid");
			
			if(sysid==null ||sysid.length()==0){
				sysid = funForm.getString("sys_key");
			}
			TbAppsys appsys = this.appSysMgr.find(sysid);
			String sysname ="";
			if(appsys!=null){
				sysname = appsys.getName();
			}
			String insure = tbFunction.getInuse().toString();
			
			//1 启用 0 未启用
			
			//((DynaValidatorForm) form).set("insure", insure);
			
			//System.out.println("------insure-----"+insure);
			request.setAttribute("newDeforder", functionMgr.getDeforderByParId(tbFunction.getParId()));
			request.setAttribute("insure", insure);
			request.setAttribute("sysname", sysname);
			request.setAttribute("sys", appsys);
			request.setAttribute("sysid", request.getParameter("sid"));
			
		}
		return mapping.findForward("inputUpdateFun");
	}

	public ActionForward updateFun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaValidatorForm funForm = (DynaValidatorForm) form;
		String insure =(String) funForm.get("insure");
		functionMgr.update(funForm, insure);
		request.setAttribute("op", "update");
		
		return inputUpdateFun(mapping,form,request,response);
		//mapping.findForward("inputUpdateFun");
		//mapping.findForward("updateFun");
	}

	public ActionForward deleteFun(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		functionMgr.delete(id);
		request.setAttribute("op", "delete");
		return mapping.findForward("deleteFun");
	}
/*cheng begin*/
	public ActionForward resListByUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String parId=request.getParameter("parId");
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		Map functionMap = (Map)session.getAttribute("functionMap");
		//List allSetRes = (List)functionMap.get(parId);
		List allSetRes = this.functionMgr.findAllSetByUser(user);
		List allRes = (List)this.functionMgr.findAllRes(user);
		TbFunction item1 = new TbFunction();
		TbFunction item2 = new TbFunction();
		if(allSetRes!=null){
			for(int i=0;i<allSetRes.size();i++){
				item1=(TbFunction)allSetRes.get(i);
				for(int j=0;j<allRes.size();j++){
					item2=(TbFunction)allRes.get(j);
					if(item1.getId().equals(item2.getId()))
						allRes.remove(item2);
				}
			}
		}
		
		request.setAttribute("allSetRes", allSetRes);
		request.setAttribute("allRes", allRes);
		return mapping.findForward("listSet");
	}
	//个性化设置保存
	public ActionForward saveResSet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String parId=request.getParameter("parId");
		String sysId=request.getParameter("sysId");
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String[] resIds=request.getParameterValues("resIds");
		
		List newSetRes=null;
		newSetRes=this.functionMgr.saveResSet(user,resIds,sysId);
		
		//更新session
		Map functionMap = (Map)session.getAttribute("functionMap");
		functionMap.remove(parId);
		functionMap.put(parId, newSetRes);
		//session.removeAttribute(parId);
		session.setAttribute("functionMap", functionMap);
		return new ActionForward("/base/function/forwardFunction.do?method=resListByUser");
	}

}
