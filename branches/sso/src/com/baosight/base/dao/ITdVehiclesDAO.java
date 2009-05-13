package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbVehicles;

public interface ITdVehiclesDAO {
	//	È«²éÑ¯
	public abstract List findAll();
	
	public  abstract List findListByLicense(String license);
	
	public  abstract TbVehicles findById(String id);
	
	public abstract void delete(TbVehicles persistentInstance);
	
	public abstract void save(TbVehicles transientInstance);
	
	public abstract void update(TbVehicles transientInstance);
}
