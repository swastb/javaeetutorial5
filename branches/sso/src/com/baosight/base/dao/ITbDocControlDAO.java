package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocControl;

public interface ITbDocControlDAO {

	public abstract void save(TbDocControl transientInstance);

	public abstract void delete(TbDocControl persistentInstance);

	public abstract TbDocControl findById(java.lang.String id);

	public abstract List findByExample(TbDocControl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStateName(Object stateName);

	public abstract List findByUserId(Object userId);

	public abstract List findByUserName(Object userName);

	public abstract List findByState(Object state);

	public abstract List findAll();

	public abstract TbDocControl merge(TbDocControl detachedInstance);

	public abstract void attachDirty(TbDocControl instance);

	public abstract void attachClean(TbDocControl instance);

}