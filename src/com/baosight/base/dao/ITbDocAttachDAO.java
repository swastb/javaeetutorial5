package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocAttach;

public interface ITbDocAttachDAO {
	public abstract void save(TbDocAttach transientInstance);

	public abstract void delete(TbDocAttach persistentInstance);

	public abstract TbDocAttach findById(java.lang.String id);

	public abstract List findByExample(TbDocAttach instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByForeignId(Object foreignId);

	public abstract List findByPath(Object path);

	public abstract List findByOriginallyName(Object originallyName);

	public abstract List findByServerName(Object serverName);

	public abstract List findByType(Object type);

	public abstract List findAll();

	public abstract TbDocAttach merge(TbDocAttach detachedInstance);

	public abstract void attachDirty(TbDocAttach instance);

	public abstract void attachClean(TbDocAttach instance);

	public List findByHQL(String hql, int startIndex,int maxResultCount);
}