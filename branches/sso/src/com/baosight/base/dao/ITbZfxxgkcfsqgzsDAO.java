package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgkcfsqgzs;


public interface ITbZfxxgkcfsqgzsDAO {

	public void save(TbZfxxgkcfsqgzs transientInstance);

	public void delete(TbZfxxgkcfsqgzs persistentInstance);

	public void update(TbZfxxgkcfsqgzs persistentInstance);

	public TbZfxxgkcfsqgzs findById(java.lang.String id);

	public List findByExample(TbZfxxgkcfsqgzs instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findAll();

	public TbZfxxgkcfsqgzs merge(TbZfxxgkcfsqgzs detachedInstance);

	public void attachDirty(TbZfxxgkcfsqgzs instance);

	public void attachClean(TbZfxxgkcfsqgzs instance);

}