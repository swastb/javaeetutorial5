package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbVehiclesApply;;


public interface ITbVehiclesApplyDAO {


	public void save(TbVehiclesApply transientInstance) ;

	public void delete(TbVehiclesApply persistentInstance);
	
	public void update(TbVehiclesApply persistentInstance);
	
	public TbVehiclesApply findById(java.lang.String id);
	
	public List findByExample(TbVehiclesApply instance);

	public List findByProperty(String propertyName, Object value);

    public List findAll();

	


}