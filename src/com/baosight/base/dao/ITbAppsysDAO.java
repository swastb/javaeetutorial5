package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthlvl;

public interface ITbAppsysDAO {

	public abstract void save(TbAppsys transientInstance);

	public abstract void delete(TbAppsys persistentInstance);

	public abstract TbAppsys findById(java.lang.String id);

	public abstract List findByExample(TbAppsys instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByUrl(Object url);

	public abstract List findByCode(Object code);

	public abstract List findByRem(Object rem);

	public abstract List findAll();

	public abstract TbAppsys merge(TbAppsys detachedInstance);

	public abstract void attachDirty(TbAppsys instance);

	public abstract void attachClean(TbAppsys instance);
	
	public abstract void update(TbAppsys item);
	
	public List checkCode(Object id,Object value);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);	

}