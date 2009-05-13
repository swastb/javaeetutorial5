package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocAttach;

/**
 * <p>Decription:IDocAttachMgr</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-4</p>
 */
public interface IDocAttachMgr {

	public abstract void save(TbDocAttach transientInstance);

	public abstract void delete(TbDocAttach persistentInstance);

	public abstract TbDocAttach findById(java.lang.String id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByForeignId(String foreignId);

	public abstract List findByType(String type);

	public abstract List findAll();

	public abstract List findByIdAndType(String foreignId,String type);

}