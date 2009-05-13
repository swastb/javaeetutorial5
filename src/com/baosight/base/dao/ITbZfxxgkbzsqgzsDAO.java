package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgkbzsqgzs;


public interface ITbZfxxgkbzsqgzsDAO {

	public void save(TbZfxxgkbzsqgzs transientInstance);

	public void delete(TbZfxxgkbzsqgzs persistentInstance);

	public void update(TbZfxxgkbzsqgzs persistentInstance);

	public TbZfxxgkbzsqgzs findById(java.lang.String id);

	public List findByExample(TbZfxxgkbzsqgzs instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findAll();

	public TbZfxxgkbzsqgzs merge(TbZfxxgkbzsqgzs detachedInstance);

	public void attachDirty(TbZfxxgkbzsqgzs instance);

	public void attachClean(TbZfxxgkbzsqgzs instance);

}