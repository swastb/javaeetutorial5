package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbNopubdesc;


public interface ITbNopubdescMgr  {
	
	public void save(TbNopubdesc transientInstance);

	public void delete(TbNopubdesc persistentInstance);
	
	public TbNopubdesc findById(java.lang.String id);

	public List findByExample(TbNopubdesc instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}