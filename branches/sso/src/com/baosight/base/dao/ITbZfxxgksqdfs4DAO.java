package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgksqdfs4;


public interface ITbZfxxgksqdfs4DAO {

	public void save(TbZfxxgksqdfs4 transientInstance);

	public void delete(TbZfxxgksqdfs4 persistentInstance);

	public void update(TbZfxxgksqdfs4 persistentInstance);

	public TbZfxxgksqdfs4 findById(java.lang.String id);

	public List findByExample(TbZfxxgksqdfs4 instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findAll();

	public TbZfxxgksqdfs4 merge(TbZfxxgksqdfs4 detachedInstance);

	public void attachDirty(TbZfxxgksqdfs4 instance);

	public void attachClean(TbZfxxgksqdfs4 instance);

}