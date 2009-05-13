package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocsendControl;

public interface ITbDocsendControlDAO {

	public abstract void save(TbDocsendControl transientInstance);

	public abstract void delete(TbDocsendControl persistentInstance);

	public abstract TbDocsendControl findById(java.lang.String id);

	public abstract List findByExample(TbDocsendControl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStateName(Object stateName);

	public abstract List findByUserId(Object userId);

	public abstract List findByUserName(Object userName);

	public abstract List findByState(Object state);

	public abstract List findByStateType(Object stateType);

	public abstract List findAll();

	public abstract TbDocsendControl merge(TbDocsendControl detachedInstance);

	public abstract void attachDirty(TbDocsendControl instance);

	public abstract void attachClean(TbDocsendControl instance);

}