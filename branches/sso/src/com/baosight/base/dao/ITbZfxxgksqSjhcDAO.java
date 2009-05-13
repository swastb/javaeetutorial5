package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgksqSjhc;

/**
 * Data access object (DAO) for domain model class TbZfxxgksqSjhc.
 * 
 * @see com.baosight.mode.TbZfxxgksqSjhc
 * @author MyEclipse Persistence Tools
 */

public interface ITbZfxxgksqSjhcDAO {
	
	public void save(TbZfxxgksqSjhc transientInstance) ;

	public void delete(TbZfxxgksqSjhc persistentInstance) ;

	public TbZfxxgksqSjhc findById(java.lang.String id) ;

	public List findByExample(TbZfxxgksqSjhc instance) ;

	public List findByProperty(String propertyName, Object value) ;

	public List findByLsNo(Object lsNo) ;

	public List findByAppliName(Object appliName) ;

	public List findByInfoName(Object infoName) ;

	public List findByAttr1(Object attr1) ;

	public List findAll() ;

	public TbZfxxgksqSjhc merge(TbZfxxgksqSjhc detachedInstance) ;

	public void attachDirty(TbZfxxgksqSjhc instance) ;

	public void attachClean(TbZfxxgksqSjhc instance) ;
	
	public List queryContent(String docNum);

}