package com.baosight.base.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.baosight.mode.TbCommission;

/**
 * Data access object (DAO) for domain model class TbCommission.
 * 
 * @see com.baosight.mode.TbCommission
 * @author MyEclipse Persistence Tools
 */

public interface ITbCommissionDAO {
	
	public void save(TbCommission transientInstance);

	public void delete(TbCommission persistentInstance);

	public TbCommission findById(java.lang.String id);

	public List findByExample(TbCommission instance);

	public List findByProperty(String propertyName, Object value);

	public List findByCommId(Object commId);

	public List findByCommName(Object commName);

	public List findByBecommedId(Object becommedId);

	public List findByBecommedName(Object becommedName);

	public List findByCommMatters(Object commMatters);

	public List findByCommFlag(Object commFlag);
	
	public void update(TbCommission item);

	public List findByAttr1(Object attr1);

	public List findByAttr2(Object attr2);

	public List findByAttr3(Object attr3);

	public List findAll();

	public TbCommission merge(TbCommission detachedInstance);

	public void attachDirty(TbCommission instance);

	public void attachClean(TbCommission instance);
	/**
	 * 根据hql找委托或被委托列表
	 * @param hql
	 * @return
	 */
	public List findCommissionListByHql(String hql);
}