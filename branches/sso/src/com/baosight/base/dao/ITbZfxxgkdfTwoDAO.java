package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZfxxgkdfTwo;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfTwo.
 * 
 * @see com.baosight.mode.TbZfxxgkdfTwo
 * @author MyEclipse Persistence Tools
 */

public interface ITbZfxxgkdfTwoDAO {
	
	public void save(TbZfxxgkdfTwo transientInstance) ;

	public void delete(TbZfxxgkdfTwo persistentInstance) ;

	public TbZfxxgkdfTwo findById(java.lang.String id) ;

	public List findByExample(TbZfxxgkdfTwo instance) ;

	public List findByProperty(String propertyName, Object value);

	public List findByLsNo(Object lsNo) ;
	
	public List findByAppliName(Object appliName) ;

	public List findByInfoName(Object infoName);

	public List findByInfoRank(Object infoRank) ;

	public List findByAttr1(Object attr1) ;

	public List findAll() ;

	public TbZfxxgkdfTwo merge(TbZfxxgkdfTwo detachedInstance) ;

	public void attachDirty(TbZfxxgkdfTwo instance) ;

	public void attachClean(TbZfxxgkdfTwo instance) ;
}