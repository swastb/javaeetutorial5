package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgksqdfs3;


public interface ITbZfxxgksqdfs3DAO {

	public void save(TbZfxxgksqdfs3 transientInstance);

	public void delete(TbZfxxgksqdfs3 persistentInstance);

	public void update(TbZfxxgksqdfs3 persistentInstance);

	public TbZfxxgksqdfs3 findById(java.lang.String id);

	public List findByExample(TbZfxxgksqdfs3 instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findAll();

	public TbZfxxgksqdfs3 merge(TbZfxxgksqdfs3 detachedInstance);

	public void attachDirty(TbZfxxgksqdfs3 instance);

	public void attachClean(TbZfxxgksqdfs3 instance);

}