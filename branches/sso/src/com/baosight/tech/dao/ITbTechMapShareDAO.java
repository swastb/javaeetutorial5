package com.baosight.tech.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.tech.mode.TbTechMapShare;

public interface ITbTechMapShareDAO extends DAOHelper{

	public abstract void save(TbTechMapShare transientInstance);

	public abstract void delete(TbTechMapShare persistentInstance);

	public abstract TbTechMapShare findById(java.lang.String id);

	public abstract List findByExample(TbTechMapShare instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract TbTechMapShare merge(TbTechMapShare detachedInstance);

	public abstract void attachDirty(TbTechMapShare instance);

	public abstract void attachClean(TbTechMapShare instance);

}