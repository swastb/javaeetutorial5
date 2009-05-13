package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUserinfo;

public interface ITbUserinfoDAO {

	public abstract void save(TbUserinfo transientInstance);

	public abstract void delete(TbUserinfo persistentInstance);

	public abstract TbUserinfo findById(java.lang.String id);

	public abstract List findByExample(TbUserinfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByBirthday(Object birthday);

	public abstract List findByEmail(Object email);

	public abstract List findByLinkaddress(Object linkaddress);

	public abstract List findByHandset(Object handset);

	public abstract List findByPhone(Object phone);

	public abstract List findAll();

	public abstract TbUserinfo merge(TbUserinfo detachedInstance);

	public abstract void attachDirty(TbUserinfo instance);

	public abstract void attachClean(TbUserinfo instance);

	public abstract void update(TbUserinfo item);
	
	public abstract List findByNativeSql(String sql, Class entity);

}