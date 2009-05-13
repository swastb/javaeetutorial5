package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbDeptlvl;

public interface ITbDeptlvlDAO {

	public abstract void save(TbDeptlvl transientInstance);

	public abstract void delete(TbDeptlvl persistentInstance);

	public abstract TbDeptlvl findById(java.lang.String id);

	public abstract List findByExample(TbDeptlvl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByEname(Object ename);

	public abstract List findByCode(Object code);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbDeptlvl merge(TbDeptlvl detachedInstance);

	public abstract void attachDirty(TbDeptlvl instance);

	public abstract void attachClean(TbDeptlvl instance);
	
	public abstract void update(TbDeptlvl item);
	
	//部门级别管理重复验证
	public List checkDeptlvl(String id,String value,String flag);

}