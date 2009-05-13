package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbAuthInfo;

public interface ITbAuthInfoDAO {

	public abstract void save(TbAuthInfo transientInstance);

	public abstract void delete(TbAuthInfo persistentInstance);

	public abstract TbAuthInfo findById(java.lang.String id);

	public abstract List findByExample(TbAuthInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByFunid(Object funid);

	public abstract List findByName(Object name);

	public abstract List findByHasChild(Object hasChild);

	public abstract List findByRighttypeid(Object righttypeid);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbAuthInfo merge(TbAuthInfo detachedInstance);

	public abstract void attachDirty(TbAuthInfo instance);

	public abstract void attachClean(TbAuthInfo instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

}