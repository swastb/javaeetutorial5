package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITdVehiclesDAO;
import com.baosight.base.service.IVehiclesServiceMgr;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbVehicles;

public class VehiclesServiceImpl implements IVehiclesServiceMgr{

	private ITdVehiclesDAO tdVehiclesDAO;

	public void setTdVehiclesDAO(ITdVehiclesDAO tdVehiclesDAO) {
		this.tdVehiclesDAO = tdVehiclesDAO;
	}


	public List findAll() {
		List vehicles=tdVehiclesDAO.findAll();
		
		return vehicles;
	}

	public List findListByLicense(String license) {
		List vehicles=tdVehiclesDAO.findListByLicense(license);
		
		return vehicles;
	}

	public TbVehicles findById(String id) {
		TbVehicles vehicles=tdVehiclesDAO.findById(id);
		
		return vehicles;
	}

	public void delete(String id) {
		tdVehiclesDAO.delete(this.findById(id));
		findAll();
	}
	
	public void save(TbVehicles item) {
		this.tdVehiclesDAO.save(item);
	}
	
	public void updte(TbVehicles item) {
		this.tdVehiclesDAO.update(item);
	}
}
