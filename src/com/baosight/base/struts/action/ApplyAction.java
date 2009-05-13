package com.baosight.base.struts.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IApplyMgr;
import com.baosight.struts.action.BaseDispatchAction;

public class ApplyAction extends BaseDispatchAction {

	protected IApplyMgr applyMgr;

	public ActionForward wsbs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		//查询结果放入list中
		List apply=this.applyMgr.findByView();
		List list=new ArrayList();
		if(apply!=null && apply.size()>5){
		for(int index=0;index<5;index++){
			list.add(apply.get(index));
		}
		request.setAttribute("apply", list);
		}else{
			request.setAttribute("apply", apply);
		}
		
		return mapping.findForward("wsbs");
	}

	public ActionForward wsbs_login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		//查询结果放入list中
		String name=request.getParameter("name");
		List apply=this.applyMgr.findByViewAll();
		request.setAttribute("apply", apply);
		request.setAttribute("name",name);
		long count=apply.size();
		startPaging(apply, null, request);
		startPagingCount(null, request,count);
		return mapping.findForward("wsbs_login");
	}

	public ActionForward wshs_more(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List apply=this.applyMgr.findByViewAll();
		request.setAttribute("apply",apply);
		return null;
	}
	public void setApplyMgr(IApplyMgr applyMgr) {
		this.applyMgr = applyMgr;
	}

}
