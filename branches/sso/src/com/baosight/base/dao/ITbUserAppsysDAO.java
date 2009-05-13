package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserAppsys;

public interface ITbUserAppsysDAO {

	public abstract void save(TbUserAppsys transientInstance);

	public abstract void delete(TbUserAppsys persistentInstance);

	public abstract TbUserAppsys findById(java.lang.String id);

	public abstract List findByExample(TbUserAppsys instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByAppid(Object appid);

	public abstract List findByFunid(Object funid);

	public abstract List findAll();

	public abstract TbUserAppsys merge(TbUserAppsys detachedInstance);

	public abstract void attachDirty(TbUserAppsys instance);

	public abstract void attachClean(TbUserAppsys instance);

}