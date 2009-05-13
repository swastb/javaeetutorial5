package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserOpeation;

public interface ITbUserOpeationDAO {
	
	public void save(TbUserOpeation transientInstance);
	
	public void update(TbUserOpeation transientInstance) ;

	public void delete(TbUserOpeation persistentInstance);

	public TbUserOpeation findById(java.lang.String id) ;

	public List findByExample(TbUserOpeation instance) ;

	public List findByProperty(String propertyName, Object value) ;

	public List findAll();
	
	public List findByParam(String userid, String operation);
}
