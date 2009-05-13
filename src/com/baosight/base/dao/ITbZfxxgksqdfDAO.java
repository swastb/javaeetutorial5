package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgksqdf;


public interface ITbZfxxgksqdfDAO {

	public void save(TbZfxxgksqdf transientInstance);

	public void delete(TbZfxxgksqdf persistentInstance);

	public void update(TbZfxxgksqdf persistentInstance);

	public TbZfxxgksqdf findById(java.lang.String id);

	public List findByExample(TbZfxxgksqdf instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findByAttr2(Object attr2);

	public List findByAttr3(Object attr3);

	public List findAll();

	public TbZfxxgksqdf merge(TbZfxxgksqdf detachedInstance);

	public void attachDirty(TbZfxxgksqdf instance);

	public void attachClean(TbZfxxgksqdf instance);

}