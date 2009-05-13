package com.baosight.base.struts.action;

import java.util.ArrayList;
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
import com.baosight.mode.TbMeetingroom;
import com.baosight.mode.TbUser;

import com.baosight.struts.action.BaseDispatchAction;

public class IndividualAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String pername = request.getParameter("pername");
		String perphone = request.getParameter("perphone");
		List allindividual = this.individualMgr.findSelect(pername, perphone,user);
		long count=allindividual.size();
		startPagingCount(null, request,count);
		startPaging(allindividual, null, request);

		request.setAttribute("pername", pername);
		request.setAttribute("perphone", perphone);
		return mapping.findForward("list");
	}
	
	public ActionForward listSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String pername = request.getParameter("pername");
		String perphone = request.getParameter("perphone");
	
		List allindividual = this.individualMgr.findSelect(pername, perphone,user);
		long count = allindividual.size();
		startPagingCount(null, request,count);
		startPaging(allindividual, null, request);

		request.setAttribute("pername", pername);
		request.setAttribute("perphone", perphone);
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String individualId = (String) ((DynaValidatorForm) form).get("individualId");
			String name = (String) ((DynaValidatorForm) form).get("name");
			String duty = (String) ((DynaValidatorForm) form).get("duty");
			String department = (String) ((DynaValidatorForm) form).get("department");
			String fax = (String) ((DynaValidatorForm) form).get("fax");
			String post = (String) ((DynaValidatorForm) form).get("post");
			String address = (String) ((DynaValidatorForm) form).get("address");
			String partmentPhone = (String) ((DynaValidatorForm) form).get("partmentPhone");
			String movePhone = (String) ((DynaValidatorForm) form).get("movePhone");
			String homePhone = (String) ((DynaValidatorForm) form).get("homePhone");
			String email = (String) ((DynaValidatorForm) form).get("email");
			String qq = (String) ((DynaValidatorForm) form).get("qq");
			String msn = (String) ((DynaValidatorForm) form).get("msn");
			String remark = (String) ((DynaValidatorForm) form).get("remark");
			TbIndividual item = this.individualMgr.findById(id);
			item.setIndividualId(individualId);
			item.setName(name);
			item.setDuty(duty);
			item.setDepartment(department);
			item.setFax(fax);
			item.setPost(post);
			item.setAddress(address);
			item.setPartmentPhone(partmentPhone);
			item.setMovePhone(movePhone);
			item.setHomePhone(homePhone);
			item.setEmail(email);
			item.setQq(qq);
			item.setMsn(msn);
			item.setRemark(remark);
			this.individualMgr.updte(item);
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				String pername = request.getParameter("pername");
				String perphone = request.getParameter("perphone");
				HttpSession session = request.getSession();
				TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
				List allIndividualCoom = this.individualCommMgr.findStatus(user);
				TbIndividual item = this.individualMgr.findById(id);
				((DynaValidatorForm) form).set("individualId",item.getIndividualId());
				((DynaValidatorForm) form).set("name",item.getName());
				((DynaValidatorForm) form).set("duty",item.getDuty());
				((DynaValidatorForm) form).set("department",item.getDepartment());
				((DynaValidatorForm) form).set("fax",item.getFax());
				((DynaValidatorForm) form).set("post",item.getPost());
				((DynaValidatorForm) form).set("address",item.getAddress());
				((DynaValidatorForm) form).set("partmentPhone",item.getPartmentPhone());
				((DynaValidatorForm) form).set("movePhone",item.getMovePhone());
				((DynaValidatorForm) form).set("homePhone",item.getHomePhone());
				((DynaValidatorForm) form).set("email",item.getEmail());
				((DynaValidatorForm) form).set("qq",item.getQq());
				((DynaValidatorForm) form).set("msn",item.getMsn());
				((DynaValidatorForm) form).set("remark",item.getRemark());
				request.setAttribute("pername", pername);
				request.setAttribute("perphone", perphone);
				request.setAttribute("allIndividualCoom", allIndividualCoom);
				request.setAttribute("individualId", item.getIndividualId());
				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		
		if (id != null && !id.equals("")) {
			individualMgr.delete(id);
		}
		
		return mapping.findForward("success");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				String pername = request.getParameter("pername");
				String perphone = request.getParameter("perphone");

				List allIndividualCoom = this.individualCommMgr.findStatus(user);
				
				request.setAttribute("pername", pername);
				request.setAttribute("perphone", perphone);
				request.setAttribute("allIndividualCoom", allIndividualCoom);
				
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String individualId = (String) ((DynaValidatorForm) form).get("individualId");
				String name = (String) ((DynaValidatorForm) form).get("name");
				String duty = (String) ((DynaValidatorForm) form).get("duty");
				String department = (String) ((DynaValidatorForm) form).get("department");
				String fax = (String) ((DynaValidatorForm) form).get("fax");
				String post = (String) ((DynaValidatorForm) form).get("post");
				String address = (String) ((DynaValidatorForm) form).get("address");
				String partmentPhone = (String) ((DynaValidatorForm) form).get("partmentPhone");
				String movePhone = (String) ((DynaValidatorForm) form).get("movePhone");
				String homePhone = (String) ((DynaValidatorForm) form).get("homePhone");
				String email = (String) ((DynaValidatorForm) form).get("email");
				String qq = (String) ((DynaValidatorForm) form).get("qq");
				String msn = (String) ((DynaValidatorForm) form).get("msn");
				String remark = (String) ((DynaValidatorForm) form).get("remark");


				TbIndividual item = new TbIndividual(individualId, name, duty,
						department, fax, post, address,
						partmentPhone, movePhone, homePhone,
						email, qq, msn, remark,user.getId());
				this.individualMgr.save(item);
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("list");
	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
	
			if (id != null && !id.equals("")) {
				String pername = request.getParameter("pername");
				String perphone = request.getParameter("perphone");
				TbIndividual item = this.individualMgr.findById(id);
				
				((DynaValidatorForm) form).set("name",item.getName());
				((DynaValidatorForm) form).set("duty",item.getDuty());
				((DynaValidatorForm) form).set("department",item.getDepartment());
				((DynaValidatorForm) form).set("fax",item.getFax());
				((DynaValidatorForm) form).set("post",item.getPost());
				((DynaValidatorForm) form).set("address",item.getAddress());
				((DynaValidatorForm) form).set("partmentPhone",item.getPartmentPhone());
				((DynaValidatorForm) form).set("movePhone",item.getMovePhone());
				((DynaValidatorForm) form).set("homePhone",item.getHomePhone());
				((DynaValidatorForm) form).set("email",item.getEmail());
				((DynaValidatorForm) form).set("qq",item.getQq());
				((DynaValidatorForm) form).set("msn",item.getMsn());
				((DynaValidatorForm) form).set("remark",item.getRemark());
				TbIndividualComm items = this.individualCommMgr.findById(item.getIndividualId());
				request.setAttribute("pername", pername);
				request.setAttribute("perphone", perphone);
				request.setAttribute("individualId", items.getName());
				return mapping.findForward("view");
			}
	
		return mapping.findForward("success");
	}

}
