package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGovInfoPub;

public interface ITbGovInfoPubDAO{

	public void save(TbGovInfoPub transientInstance) ;

	public void delete(TbGovInfoPub persistentInstance);
	
	public void update(TbGovInfoPub persistentInstance);
	
	public TbGovInfoPub findById(java.lang.String id);
	
	public List findByExample(TbGovInfoPub instance);

	public List findByProperty(String propertyName, Object value);

    public List findAll();

	public TbGovInfoPub merge(TbGovInfoPub detachedInstance);

	public void attachDirty(TbGovInfoPub instance);

	public void attachClean(TbGovInfoPub instance) ;

}