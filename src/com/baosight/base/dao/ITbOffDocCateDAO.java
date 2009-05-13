package com.baosight.base.dao;

import java.util.List;
import com.baosight.mode.TbOffDocCate;



public interface ITbOffDocCateDAO{

	public void save(TbOffDocCate transientInstance);

	public void delete(TbOffDocCate persistentInstance);
	
	public TbOffDocCate findById(java.lang.String id);

	public List findByExample(TbOffDocCate instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}