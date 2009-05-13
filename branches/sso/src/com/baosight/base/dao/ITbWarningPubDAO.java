package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbWarningPub;

public interface ITbWarningPubDAO {

	public abstract void save(TbWarningPub transientInstance);

	public abstract void delete(TbWarningPub persistentInstance);

	public abstract TbWarningPub findById(java.lang.String id);

	public abstract List findByExample(TbWarningPub instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySignal(Object signal);

	public abstract List findByResp(Object resp);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findAll();

	public abstract TbWarningPub merge(TbWarningPub detachedInstance);

	public abstract void attachDirty(TbWarningPub instance);

	public abstract void attachClean(TbWarningPub instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

}