package com.baosight.tech.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.tech.mode.TbTechStandard;

public interface ITbTechStandardDAO extends DAOHelper{

	public abstract void save(TbTechStandard transientInstance);

	public abstract void delete(TbTechStandard persistentInstance);

	public abstract TbTechStandard findById(java.lang.String id);

	public abstract List findByExample(TbTechStandard instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract TbTechStandard merge(TbTechStandard detachedInstance);

	public abstract void attachDirty(TbTechStandard instance);

	public abstract void attachClean(TbTechStandard instance);

}