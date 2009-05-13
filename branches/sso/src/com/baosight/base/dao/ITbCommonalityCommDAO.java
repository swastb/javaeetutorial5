package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbCommonalityComm;

public interface ITbCommonalityCommDAO {

	public abstract void save(TbCommonalityComm transientInstance);
	
	public abstract void update(TbCommonalityComm transientInstance);

	public abstract void delete(TbCommonalityComm persistentInstance);

	public abstract TbCommonalityComm findById(java.lang.String id);

	public abstract List findByExample(TbCommonalityComm instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByParentId(Object parentId);

	public abstract List findByName(Object name);

	public abstract List findByInuse(Object inuse);

	public abstract List findByBelong(Object belong);

	public abstract List findByRemark(Object remark);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findByAttr4(Object attr4);

	public abstract List findByAttr5(Object attr5);

	public abstract List findAll();

	public abstract TbCommonalityComm merge(TbCommonalityComm detachedInstance);

	public abstract void attachDirty(TbCommonalityComm instance);

	public abstract void attachClean(TbCommonalityComm instance);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	
	public List findByIdAndName();
	
	public abstract List findBySql(String sql);


}