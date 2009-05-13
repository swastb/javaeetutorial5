package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbRoleAuth;

public interface ITbRoleAuthDAO {

	public abstract void save(TbRoleAuth transientInstance);

	public abstract void delete(TbRoleAuth persistentInstance);

	public abstract TbRoleAuth findById(java.lang.String id);

	public abstract List findByExample(TbRoleAuth instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRoleid(Object roleid);

	public abstract List findByAuthid(Object authid);

	public abstract List findAll();

	public abstract TbRoleAuth merge(TbRoleAuth detachedInstance);

	public abstract void attachDirty(TbRoleAuth instance);

	public abstract void attachClean(TbRoleAuth instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

}