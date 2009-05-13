package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbType;



public interface ITbTypeMgr {

	public void save(TbType transientInstance);

	public void delete(TbType persistentInstance);
	
	public TbType findById(java.lang.String id);

	public List findByExample(TbType instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}