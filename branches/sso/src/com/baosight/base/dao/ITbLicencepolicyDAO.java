package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbLicencepolicy;

public interface ITbLicencepolicyDAO {

	public abstract void save(TbLicencepolicy transientInstance);

	public abstract void delete(TbLicencepolicy persistentInstance);

	public abstract TbLicencepolicy findById(java.lang.String id);

	public abstract List findByExample(TbLicencepolicy instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByResourceid(Object resourceid);

	public abstract List findByByresourceid(Object byresourceid);

	public abstract List findByTighttypeid(Object tighttypeid);

	public abstract List findByByresHaschild(Object byresHaschild);

	public abstract List findAll();

	public abstract TbLicencepolicy merge(TbLicencepolicy detachedInstance);

	public abstract void attachDirty(TbLicencepolicy instance);

	public abstract void attachClean(TbLicencepolicy instance);

}