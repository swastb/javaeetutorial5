package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbApplyDAO;
import com.baosight.mode.TbApply;

/**
 * Data access object (DAO) for domain model class TbApply.
 * 
 * @see com.baosight.mode.TbApply
 * @author MyEclipse Persistence Tools
 */

public class TbApplyDAOImpl extends HibernateDaoSupport
		implements ITbApplyDAO {
	private static final Log log = LogFactory.getLog(TbApplyDAOImpl.class);

	private String queryCacheRegion = null;

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbApplyDAO#save(com.baosight.mode.TbApply)
	 */
	public void save(TbApply transientInstance) {
		log.debug("saving TbApply instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbApplyDAO#save(com.baosight.mode.TbApply)
	 */
	public void update(TbApply transientInstance) {
		log.debug("updating TbApply instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbApplyDAO#delete(com.baosight.mode.TbApply)
	 */
	public void delete(TbApply persistentInstance) {
		log.debug("deleting TbApply instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbApplyDAO#findById(java.lang.String)
	 */
	public TbApply findById(java.lang.String id) {
		log.debug("getting TbApply instance with id: " + id);
		try {
			TbApply instance = (TbApply) getHibernateTemplate().get(
					"com.baosight.mode.TbApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbApplyDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbApply instances");
		try {
			String queryString = "select t.applyNo,t.projectName,t.dealDate, t.isover from TbApply t where t.projectName is not null and rownum<5";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public List findBySql(final String sql) {
				Query query = getSession().createSQLQuery(sql);
				return query.list();
	}

}