package com.baosight.tech.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.tech.mode.TbTechResult;

public interface ITbTechResultDAO extends DAOHelper{

	public abstract void save(TbTechResult transientInstance);

	public abstract void delete(TbTechResult persistentInstance);

	public abstract TbTechResult findById(java.lang.String id);

	public abstract List findByExample(TbTechResult instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract TbTechResult merge(TbTechResult detachedInstance);

	public abstract void attachDirty(TbTechResult instance);

	public abstract void attachClean(TbTechResult instance);

}