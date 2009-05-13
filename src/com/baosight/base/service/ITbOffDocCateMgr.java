package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbOffDocCate;



public interface ITbOffDocCateMgr{

	public void save(TbOffDocCate transientInstance);

	public void delete(TbOffDocCate persistentInstance);
	
	public TbOffDocCate findById(java.lang.String id);

	public List findByExample(TbOffDocCate instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}