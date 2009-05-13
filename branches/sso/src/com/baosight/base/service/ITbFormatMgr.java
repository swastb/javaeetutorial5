package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbFormat;



public interface ITbFormatMgr  {
	
	public void save(TbFormat transientInstance);

	public void delete(TbFormat persistentInstance);
	
	public TbFormat findById(java.lang.String id);

	public List findByExample(TbFormat instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}