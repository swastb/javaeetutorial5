package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;


import com.baosight.mode.TbIndividual;
import com.baosight.mode.TbIndividualComm;
import com.baosight.mode.TbUser;

import com.baosight.struts.action.BaseDispatchAction;

public class IndividualCommAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String groupname = request.getParameter("groupname");
		List allindividualcomm = this.individualCommMgr.findAll(user);
		request.setAttribute("groupname", groupname);
		long count = allindividualcomm.size();
		startPagingCount(null, request,count);
		startPaging(allindividualcomm, null, request);
		return mapping.findForward("list");
	}
	
	public ActionForward listSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String groupname = request.getParameter("groupname");
		List selectindividualcomm = this.individualCommMgr.findSelectName(groupname, user);
		long count=selectindividualcomm.size();
		request.setAttribute("groupname", groupname);
		startPagingCount(null, request,count);
		startPaging(selectindividualcomm, null, request);
		return mapping.findForward("list");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String name = (String) ((DynaValidatorForm) form).get("name");
			Long inuse =  (Long)((DynaValidatorForm) form).get("inuse");
			String remark = (String) ((DynaValidatorForm) form).get("remark");
			TbIndividualComm item = this.individualCommMgr.findById(id);
			item.setName(name);
			item.setInuse(inuse);
			item.setRemark(remark);
			this.individualCommMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				String groupname = request.getParameter("groupname");
				TbIndividualComm item = this.individualCommMgr.findById(id);
				((DynaValidatorForm) form).set("name", item.getName());
				((DynaValidatorForm) form).set("inuse", item.getInuse());
				((DynaValidatorForm) form).set("remark", item.getRemark());
				request.setAttribute("groupname", groupname);
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		
		if (id != null && !id.equals("")) {

			List individualid = this.individualMgr.findindividualid(id);
			if(individualid.size()>0){
			}
			else{
			individualCommMgr.delete(id);
			}
		}
		
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				String groupname = request.getParameter("groupname");
				long inuse = 0;
				((DynaValidatorForm) form).set("inuse",inuse);
				request.setAttribute("groupname", groupname);
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				HttpSession session = request.getSession();
				TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
				
				String name = (String) ((DynaValidatorForm) form).get("name");
				Long inuse = (Long) ((DynaValidatorForm) form).get("inuse");
				String remark = (String) ((DynaValidatorForm) form).get("remark");
				TbIndividualComm item = new TbIndividualComm(name,inuse,remark,user.getId());
				this.individualCommMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("success");
	}
}
