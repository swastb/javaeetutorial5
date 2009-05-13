package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserlvl;

public interface ITbUserlvlDAO {

	public abstract void save(TbUserlvl transientInstance);

	public abstract void delete(TbUserlvl persistentInstance);

	public abstract TbUserlvl findById(java.lang.String id);

	public abstract List findByExample(TbUserlvl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByEname(Object ename);

	public abstract List findByCode(Object code);

	public abstract List findByRm(Object rm);

	public abstract List findAll();

	public abstract TbUserlvl merge(TbUserlvl detachedInstance);

	public abstract void attachDirty(TbUserlvl instance);

	public abstract void attachClean(TbUserlvl instance);

	public abstract void update(TbUserlvl item);
	
	//用户级别管理重复验证
	public List checkUserlvl(String id,String value,String flag);

}