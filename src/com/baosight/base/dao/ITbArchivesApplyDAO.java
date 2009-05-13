package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbArchivesApply;


public interface ITbArchivesApplyDAO {


	public void save(TbArchivesApply transientInstance);

	public void delete(TbArchivesApply persistentInstance);

	public TbArchivesApply findById(java.lang.String id);

	public List findByExample(TbArchivesApply instance);

	public List findByProperty(String propertyName, Object value);
	
	public List findAll();
	public void update(TbArchivesApply transientInstance);
}