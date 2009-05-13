package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserGroup;

public interface ITbUserGroupDAO {

	public abstract void save(TbUserGroup transientInstance);

	public abstract void delete(TbUserGroup persistentInstance);

	public abstract TbUserGroup findById(java.lang.String id);

	public abstract List findByExample(TbUserGroup instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGroupCode(Object groupCode);

	public abstract List findByUserId(Object userId);

	public abstract List findByGroupid(Object groupid);

	public abstract List findAll();

	public abstract TbUserGroup merge(TbUserGroup detachedInstance);

	public abstract void attachDirty(TbUserGroup instance);

	public abstract void attachClean(TbUserGroup instance);

}