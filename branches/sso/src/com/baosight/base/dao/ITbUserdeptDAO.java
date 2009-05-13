package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserdept;

public interface ITbUserdeptDAO {

	public abstract void save(TbUserdept transientInstance);

	public abstract void delete(TbUserdept persistentInstance);

	public abstract TbUserdept findById(java.lang.String id);

	public abstract List findByExample(TbUserdept instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findAll();

	public abstract TbUserdept merge(TbUserdept detachedInstance);

	public abstract void attachDirty(TbUserdept instance);

	public abstract void attachClean(TbUserdept instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
}