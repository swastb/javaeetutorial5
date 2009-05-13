package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbUser;

public interface ITbAuthlvlDAO {

	public abstract void save(TbAuthlvl transientInstance);

	public abstract void delete(TbAuthlvl persistentInstance);

	public abstract TbAuthlvl findById(java.lang.String id);

	public abstract List findByExample(TbAuthlvl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByEname(Object ename);

	public abstract List findByCode(Object code);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbAuthlvl merge(TbAuthlvl detachedInstance);

	public abstract void attachDirty(TbAuthlvl instance);

	public abstract void attachClean(TbAuthlvl instance);
	
	public abstract void update(TbAuthlvl item);
	
	//权限级别管理重复验证
	public List checkAuthlvl(String id,String value,String flag);

}