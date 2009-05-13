package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbRighttype;

public interface ITbRighttypeDAO {

	public abstract void save(TbRighttype transientInstance);

	public abstract void delete(TbRighttype persistentInstance);

	public abstract TbRighttype findById(java.lang.String id);

	public abstract List findByExample(TbRighttype instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCode(Object code);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract TbRighttype merge(TbRighttype detachedInstance);

	public abstract void attachDirty(TbRighttype instance);

	public abstract void attachClean(TbRighttype instance);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

	public abstract void update(TbRighttype item);
	
	//权限类型管理代码重复验证
	public List checkRighttypeCode(String id,String value,String funid);

}