package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbPstlvl;

public interface ITbPstlvlDAO {

	public abstract void save(TbPstlvl transientInstance);

	public abstract void delete(TbPstlvl persistentInstance);

	public abstract TbPstlvl findById(java.lang.String id);

	public abstract List findByExample(TbPstlvl instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByCode(Object code);

	public abstract List findAll();

	public abstract TbPstlvl merge(TbPstlvl detachedInstance);

	public abstract void attachDirty(TbPstlvl instance);

	public abstract void attachClean(TbPstlvl instance);

	public abstract void update(TbPstlvl item);
	
	//职务等级重复验证
	public List checkPstlvl(String id,String value,String flag);

}