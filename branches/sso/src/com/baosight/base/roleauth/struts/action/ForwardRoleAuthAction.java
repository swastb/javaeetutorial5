package com.baosight.base.roleauth.struts.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.baosight.base.service.IFunctionMgr;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbRole;

public class ForwardRoleAuthAction extends DispatchAction {
	private IFunctionMgr functionMgr;

	public IFunctionMgr getFunctionMgr() {
		return functionMgr;
	}

	public void setFunctionMgr(IFunctionMgr functionMgr) {
		this.functionMgr = functionMgr;
	}

	public ActionForward inputShowRoleTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("inputShowRoleTree");
	}

	public ActionForward showRoleAuthTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String rid = request.getParameter("rid");
		StringBuffer xml = new StringBuffer();
		List roleList = functionMgr.findAllRole();
		Iterator iterator = roleList.iterator();

		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<roles>\r\n");
		if (rid.equals("0")) {
			xml.append("<isFirst>\r\n");
			xml.append("<first>" + "true" + "</first>");
			xml.append("</isFirst>");
		} else {
			xml.append("<isFirst>");
			xml.append("<first>" + "false" + "</first>");
			xml.append("</isFirst>");
		}
		while (iterator.hasNext()) {
			xml.append("<role>\r\n");
			TbRole tbRole = (TbRole) iterator.next();
			xml.append("<id>" + tbRole.getId() + "</id>\r\n");
			xml.append("<title>" + tbRole.getName() + "</title>\r\n");
			xml.append("</role>\r\n");
		}
		xml.append("</roles>");
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

	public ActionForward inputShowFunTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.println(request.getParameter("rid")+"?????????????????????????????????????????????????????????????????????");
		request.setAttribute("rid", request.getParameter("rid"));
		return mapping.findForward("inputShowFunTree");
//		return null;
	}

	public ActionForward showFunTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fid = request.getParameter("fid");
		String rid = request.getParameter("rid");
		log.debug("ForwardRoleAuthAction.showFunTree++++++++++++++++++++++++fid="+fid+" ++++++rid="+rid);
		System.out.println("ForwardRoleAuthAction.showFunTree++++++++++++++++++++++++fid="+fid+" ++++++rid="+rid);
		StringBuffer xml = new StringBuffer();
		//Map funList = functionMgr.findFunByRid(rid);
		List allFunList = functionMgr.findAllForTreeInsure(fid);
		Iterator iterator = allFunList.iterator();

		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<functions>\r\n");
		xml.append("<isFirst>");
		xml.append("<first>" + "false" + "</first>");
		xml.append("</isFirst>");
		while (iterator.hasNext()) {
			xml.append("<function>\r\n");
			TbFunction function = (TbFunction) iterator.next();
			xml.append("<id>" + function.getId() + "</id>\r\n");
			xml.append("<title>" + function.getName() + "</title>\r\n");
			xml.append("<funKey>" + function.getFunKey() + "</funKey>\r\n");
			xml.append("<sysId>" + function.getSysId() + "</sysId>\r\n");
			xml.append("<parId>" + function.getParId() + "</parId>\r\n");
			xml.append("<isnode>" + (function.getNode() > 0) + "</isnode>\r\n");
			xml.append("<insure>" + function.getInuse() + "</insure>\r\n");
			if(functionMgr.isChecked(function,rid)){
				xml.append("<isCheck>" + "true" + "</isCheck>\r\n");
			}else{
				xml.append("<isCheck>" + "false" + "</isCheck>\r\n");
			}			
/*			if(funList.containsKey(function.getId())){
				xml.append("<isCheck>" + "true" + "</isCheck>\r\n");
			}else{
				xml.append("<isCheck>" + "false" + "</isCheck>\r\n");
			}*/
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
	
	public ActionForward toAuth(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String rid = request.getParameter("rid");
		String [] funList = request.getParameterValues("fun"); 
		String[] isDefList = request.getParameterValues("isDef");
		if(funList!=null){
			for(int i=0;i<funList.length;i++){
				System.out.println("------------"+funList[i]);
			}
			functionMgr.toAuth(rid, funList,isDefList);
			request.setAttribute("op", "toAuth");		
		}
		return mapping.findForward("toAuth");
	}
	
	public ActionForward showDetailFun(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fid = request.getParameter("fid");
		String rid = request.getParameter("rid");
		if(fid!=null && !fid.equals("")){
			TbFunction tbFunction = functionMgr.findById(fid);
			if(tbFunction!=null){
				request.setAttribute("tbFunction", tbFunction);
				request.setAttribute("rightTypeListByFun", functionMgr.findRightTypeByFunction(tbFunction));
				request.setAttribute("rightTypeListSelect", functionMgr.findRightTypeByRidAndFid(fid,rid));
			}	
		}	
		return mapping.findForward("showDetailFun");
	}
		
}
