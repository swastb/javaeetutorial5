package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbFzfxxgksqgzs;


public interface ITbFzfxxgksqgzsDAO {

	public void save(TbFzfxxgksqgzs transientInstance);

	public void delete(TbFzfxxgksqgzs persistentInstance);

	public void update(TbFzfxxgksqgzs persistentInstance);

	public TbFzfxxgksqgzs findById(java.lang.String id);

	public List findByExample(TbFzfxxgksqgzs instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoId(Object infoId);

	public List findByLsNo(Object lsNo);

	public List findByApplicant(Object applicant);

	public List findByAttr1(Object attr1);

	public List findByAttr2(Object attr2);

	public List findAll();

	public TbFzfxxgksqgzs merge(TbFzfxxgksqgzs detachedInstance);

	public void attachDirty(TbFzfxxgksqgzs instance);

	public void attachClean(TbFzfxxgksqgzs instance);

}