package com.baosight.base.dao;

import java.util.List;
import com.baosight.mode.TbFormat;



public interface ITbFormatDAO  {
	
	public void save(TbFormat transientInstance);

	public void delete(TbFormat persistentInstance);
	
	public TbFormat findById(java.lang.String id);

	public List findByExample(TbFormat instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}