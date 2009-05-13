package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGroup;

public interface ITbGroupDAO {

	public abstract void save(TbGroup transientInstance);

	public abstract void delete(TbGroup persistentInstance);

	public abstract TbGroup findById(java.lang.String id);

	public abstract List findByExample(TbGroup instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCode(Object code);

	public abstract List findByName(Object name);

	public abstract List findByDeptCode(Object deptCode);

	public abstract List findByLvl(Object lvl);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbGroup merge(TbGroup detachedInstance);

	public abstract void attachDirty(TbGroup instance);

	public abstract void attachClean(TbGroup instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
}