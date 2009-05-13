package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbPublicAffairTransact;;

public interface ITbPublicAffairTransactDAO {
	public void save(TbPublicAffairTransact transientInstance);

	public void update(TbPublicAffairTransact transientInstance) ;
	
	public void delete(TbPublicAffairTransact persistentInstance);

	public TbPublicAffairTransact findById(java.lang.String id);

	public List findByExample(TbPublicAffairTransact instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
	
	public List getPublicAffairTransactById(String id,Long affairType,Long type);
}
