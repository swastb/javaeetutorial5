package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserAuth;

public interface ITbUserAuthDAO {

	public abstract void save(TbUserAuth transientInstance);

	public abstract void delete(TbUserAuth persistentInstance);

	public abstract TbUserAuth findById(java.lang.String id);

	public abstract List findByExample(TbUserAuth instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByAuthid(Object authid);

	public abstract List findAll();

	public abstract TbUserAuth merge(TbUserAuth detachedInstance);

	public abstract void attachDirty(TbUserAuth instance);

	public abstract void attachClean(TbUserAuth instance);

}