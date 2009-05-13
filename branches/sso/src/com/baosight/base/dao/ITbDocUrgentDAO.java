package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocUrgent;

/**
 * Data access object (DAO) for domain model class TbDocUrgent.
 * 
 * @see com.baosight.mode.TbDocUrgent
 * @author MyEclipse Persistence Tools
 */

public interface ITbDocUrgentDAO {

	public abstract void save(TbDocUrgent transientInstance);
	
	public abstract void delete(TbDocUrgent persistentInstance);

	public abstract TbDocUrgent findById(java.lang.String id);

	public abstract List findByExample(TbDocUrgent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUrgentCon(Object urgentCon);
	
	public abstract List findByUrgentObj(Object urgentObj);

	public abstract List findByUrgentWay(Object urgentWay);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findAll() ;
	
	public abstract TbDocUrgent merge(TbDocUrgent detachedInstance);

	public abstract void attachDirty(TbDocUrgent instance);

	public abstract void attachClean(TbDocUrgent instance);


}