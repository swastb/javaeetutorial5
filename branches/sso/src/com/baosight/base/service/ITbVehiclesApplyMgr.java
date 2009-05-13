package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbVehiclesApply;;

public interface ITbVehiclesApplyMgr 
{
	//更新
	public void update(TbVehiclesApply model);

	//删除
	public void delete(String id);

	//插入
	public void save(TbVehiclesApply model);

	//全查询
	public List findAll();
	
	public List findByProperty(String propertyName, Object value);
	//根据ID查询
	public TbVehiclesApply findById(String id);
	
	public List findByLicense(String License);
}
