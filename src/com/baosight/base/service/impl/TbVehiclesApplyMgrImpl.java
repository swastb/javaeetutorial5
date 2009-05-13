package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbVehiclesApplyDAO;
import com.baosight.base.service.ITbVehiclesApplyMgr;
import com.baosight.mode.TbVehiclesApply;

public class TbVehiclesApplyMgrImpl implements ITbVehiclesApplyMgr {

	private ITbVehiclesApplyDAO tbVehiclesApplyDAO;

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbVehiclesApplyDAO.findAll();
	}

	public TbVehiclesApply findById(String id) {
		// TODO Auto-generated method stub
		return this.tbVehiclesApplyDAO.findById(id);
	}

	public void save(TbVehiclesApply model) {
		// TODO Auto-generated method stub
		this.tbVehiclesApplyDAO.save(model);
	}

	public void update(TbVehiclesApply model) {
		// TODO Auto-generated method stub
		this.tbVehiclesApplyDAO.update(model);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbVehiclesApplyDAO.delete(this.findById(id));
	}
	public List findByLicense(String License) { 
		return this.tbVehiclesApplyDAO.findByProperty("license", License);
		
	}

	public List findByProperty(String propertyName, Object value){
		return this.tbVehiclesApplyDAO.findByProperty(propertyName, value);
	}
	
	public void setTbVehiclesApplyDAO(ITbVehiclesApplyDAO tbVehiclesApplyDAO) {
		this.tbVehiclesApplyDAO = tbVehiclesApplyDAO;
	}


}
