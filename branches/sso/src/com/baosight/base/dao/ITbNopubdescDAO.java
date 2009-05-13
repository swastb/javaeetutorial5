package com.baosight.base.dao;

import java.util.List;
import com.baosight.mode.TbNopubdesc;


public interface ITbNopubdescDAO  {
	
	public void save(TbNopubdesc transientInstance);

	public void delete(TbNopubdesc persistentInstance);
	
	public TbNopubdesc findById(java.lang.String id);

	public List findByExample(TbNopubdesc instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}