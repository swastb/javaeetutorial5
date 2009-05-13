package com.baosight.infocenter.docsend.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;

/**
 * Data access object (DAO) for domain model class TbDocsendControlXxzx.
 * 
 * @see com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx
 * @author MyEclipse Persistence Tools
 */

public interface ITbDocsendControlXxzxDAO {
	
	public void save(TbDocsendControlXxzx transientInstance);

	public void delete(TbDocsendControlXxzx persistentInstance);

	public TbDocsendControlXxzx findById(java.lang.String id);

	public List findByExample(TbDocsendControlXxzx instance);

	public List findByProperty(String propertyName, Object value);

	public List findByStateName(Object stateName);

	public List findByUserId(Object userId);

	public List findByUserName(Object userName);

	public List findByState(Object state);

	public List findByStateType(Object stateType);

	public List findAll();

	public TbDocsendControlXxzx merge(TbDocsendControlXxzx detachedInstance);

	public void attachDirty(TbDocsendControlXxzx instance);

	public void attachClean(TbDocsendControlXxzx instance);;
}