package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbPublicAffairTransact;

public interface ITbPublicAffairTransactMgr {

	public void save(TbPublicAffairTransact transientInstance);

	public void update(TbPublicAffairTransact transientInstance);
	
	public void delete(TbPublicAffairTransact persistentInstance) ;

	public TbPublicAffairTransact findById(java.lang.String id) ;

	public List findByExample(TbPublicAffairTransact instance);
	
	public List findByProperty(String propertyName, Object value) ;
	
	public List findAll();
	
	public List getPublicAffairTransactById(String id,Long type,Long affairType);
}
