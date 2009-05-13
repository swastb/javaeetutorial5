package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgkdfOne;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfOne.
 * 
 * @see com.baosight.mode.TbZfxxgkdfOne
 * @author MyEclipse Persistence Tools
 */

public interface ITbZfxxgkdfOneDAO {

	public void save(TbZfxxgkdfOne transientInstance);

	public void delete(TbZfxxgkdfOne persistentInstance) ;

	public TbZfxxgkdfOne findById(java.lang.String id) ;

	public List findByExample(TbZfxxgkdfOne instance);

	public List findByProperty(String propertyName, Object value) ;

	public List findByAppliName(Object appliName) ;
	
	public List findByIfnoName(Object ifnoName);
	
	public List findByOfferWay1(Object offerWay1) ;

	public List findByOfferWay2(Object offerWay2) ;

	public List findByLsNo(Object lsNo) ;

	public List findByAttr1(Object attr1) ;

	public List findAll() ;

	public TbZfxxgkdfOne merge(TbZfxxgkdfOne detachedInstance) ;

	public void attachDirty(TbZfxxgkdfOne instance) ;

	public void attachClean(TbZfxxgkdfOne instance) ;

}