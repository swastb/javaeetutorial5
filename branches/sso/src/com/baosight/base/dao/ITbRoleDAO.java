package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbRole;

public interface ITbRoleDAO {

	public abstract void save(TbRole transientInstance);

	public abstract void delete(TbRole persistentInstance);

	public abstract TbRole findById(java.lang.String id);

	public abstract List findByExample(TbRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbRole merge(TbRole detachedInstance);

	public abstract void attachDirty(TbRole instance);

	public abstract void attachClean(TbRole instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

	public abstract void update(TbRole item);
	
	public List checkName(Object id,Object value,String field);

}