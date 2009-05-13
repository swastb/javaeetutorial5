package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGroupRole;

public interface ITbGroupRoleDAO {

	public abstract void save(TbGroupRole transientInstance);

	public abstract void delete(TbGroupRole persistentInstance);

	public abstract TbGroupRole findById(java.lang.String id);

	public abstract List findByExample(TbGroupRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGroupCode(Object groupCode);

	public abstract List findByGroupid(Object groupid);

	public abstract List findByRoleid(Object roleid);

	public abstract List findAll();

	public abstract TbGroupRole merge(TbGroupRole detachedInstance);

	public abstract void attachDirty(TbGroupRole instance);

	public abstract void attachClean(TbGroupRole instance);

}