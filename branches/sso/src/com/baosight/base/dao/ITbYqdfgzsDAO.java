package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbYqdfgzs;


public interface ITbYqdfgzsDAO {

	public void save(TbYqdfgzs transientInstance);

	public void delete(TbYqdfgzs persistentInstance);

	public void update(TbYqdfgzs persistentInstance);

	public TbYqdfgzs findById(java.lang.String id);

	public List findByExample(TbYqdfgzs instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findAll();

	public TbYqdfgzs merge(TbYqdfgzs detachedInstance);

	public void attachDirty(TbYqdfgzs instance);

	public void attachClean(TbYqdfgzs instance);

}