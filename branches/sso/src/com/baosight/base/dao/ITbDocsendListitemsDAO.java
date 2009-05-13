package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocsendListitems;

public interface ITbDocsendListitemsDAO {

	public abstract void save(TbDocsendListitems transientInstance);

	public abstract void delete(TbDocsendListitems persistentInstance);

	public abstract TbDocsendListitems findById(java.lang.String id);

	public abstract List findByExample(TbDocsendListitems instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStyle(Object style);

	public abstract List findByCode(Object code);

	public abstract List findByTitle(Object title);

	public abstract List findByInfo(Object info);

	public abstract List findAll();

	public abstract TbDocsendListitems merge(TbDocsendListitems detachedInstance);

	public abstract void attachDirty(TbDocsendListitems instance);

	public abstract void attachClean(TbDocsendListitems instance);

}