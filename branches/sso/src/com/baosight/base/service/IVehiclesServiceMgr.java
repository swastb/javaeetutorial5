package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbVehicles;

public interface IVehiclesServiceMgr {
	//	È«²éÑ¯
	public List findAll();
	
	public List findListByLicense(String license);
	
	public TbVehicles findById(String id);
	
	public void delete(String id);
	
	public void save(TbVehicles item);
	
	public void updte(TbVehicles item);
}
