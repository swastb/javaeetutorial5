package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;


import com.baosight.base.service.IVehiclesServiceMgr;
import com.baosight.mode.TbVehicles;
import com.baosight.struts.action.BaseDispatchAction;

public class VehiclesAction extends BaseDispatchAction{
	
	protected IVehiclesServiceMgr vehiclesServiceMgr;
	
	
	public IVehiclesServiceMgr getVehiclesServiceMgr() {
		return vehiclesServiceMgr;
	}


	public void setVehiclesServiceMgr(IVehiclesServiceMgr vehiclesServiceMgr) {
		this.vehiclesServiceMgr = vehiclesServiceMgr;
	}


	public ActionForward findVehiclesList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		//查询结果
		List vehicles=this.vehiclesServiceMgr.findAll();
		//request.getSession().setAttribute("vehiclesList",vehicles);

		//分页
		long count=vehicles.size();
		startPagingCount(null, request,count);
		startPaging(vehicles, null, request);

		return mapping.findForward("list");
	}
	
	public ActionForward findVehiclesByLicense(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//查询结果
		String license = request.getParameter("license");
		List vehicles=this.vehiclesServiceMgr.findListByLicense(license);
		request.getSession().setAttribute("vehiclesList",vehicles);

		//分页
		long count=vehicles.size();
		startPagingCount(null, request,count);
		startPaging(vehicles, null, request);

		return mapping.findForward("list");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		vehiclesServiceMgr.delete(id);
		
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
				String license1 = (String) ((DynaValidatorForm) form).get("license1");
				String license2 = (String) ((DynaValidatorForm) form).get("license2");
				String license = "沪-"+license1+"-"+license2;
				String model = (String) ((DynaValidatorForm) form).get("model");
				Long capacity = (Long) ((DynaValidatorForm) form).get("capacity");
				Long status = (Long) ((DynaValidatorForm) form).get("status");
				String rem = (String) ((DynaValidatorForm) form).get("rem");
				TbVehicles item = new TbVehicles(license, model, capacity, status, rem);
				this.vehiclesServiceMgr.save(item);
				
				return mapping.findForward("success");
			}
		}
		return mapping.findForward("success");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String license1 = (String) ((DynaValidatorForm) form).get("license1");
			String license2 = (String) ((DynaValidatorForm) form).get("license2");
			String license = "沪-"+license1+"-"+license2;
			String model = (String) ((DynaValidatorForm) form).get("model");
			Long capacity = (Long) ((DynaValidatorForm) form).get("capacity");
			Long status = (Long) ((DynaValidatorForm) form).get("status");
			String rem = (String) ((DynaValidatorForm) form).get("rem");

			TbVehicles item = this.vehiclesServiceMgr.findById(id);
			item.setLicense(license);
			item.setModel(model);
			item.setCapacity(capacity);
			item.setStatus(status);
			item.setRem(rem);
			this.vehiclesServiceMgr.updte(item);
			
			return mapping.findForward("success");
		} else {
			if (id != null && !id.equals("")) {
				TbVehicles item = this.vehiclesServiceMgr.findById(id);
				((DynaValidatorForm) form).set("id", item.getId());
				((DynaValidatorForm) form).set("license1", item.getLicense().substring(2, 3));
				((DynaValidatorForm) form).set("license2", item.getLicense().substring(4));
				((DynaValidatorForm) form).set("license", item.getLicense());
				((DynaValidatorForm) form).set("model", item.getModel());
				((DynaValidatorForm) form).set("capacity", item.getCapacity());
				((DynaValidatorForm) form).set("status", item.getStatus());
				((DynaValidatorForm) form).set("rem", item.getRem());

				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	
}
