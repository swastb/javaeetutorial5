package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbArchivesApplyDAO;
import com.baosight.mode.TbArchivesApply;
import com.baosight.mode.TbVehiclesApply;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbArchivesApply entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.baosight.mode.TbArchivesApply
 * @author MyEclipse Persistence Tools
 */

public class TbArchivesApplyDAOImpl extends HibernateDaoSupport implements ITbArchivesApplyDAO{
	private static final Log log = LogFactory.getLog(TbArchivesApplyDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbArchivesApply transientInstance) {
		log.debug("saving TbArchivesApply instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbArchivesApply transientInstance) {
		log.debug("updating TbArchivesApply instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(TbArchivesApply persistentInstance) {
		log.debug("deleting TbArchivesApply instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbArchivesApply findById(java.lang.String id) {
		log.debug("getting TbArchivesApply instance with id: " + id);
		try {
			TbArchivesApply instance = (TbArchivesApply) getHibernateTemplate()
					.get("com.baosight.mode.TbArchivesApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbArchivesApply instance) {
		log.debug("finding TbArchivesApply instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbArchivesApply instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbArchivesApply as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbArchivesApply instances");
		try {
			String queryString = "from TbArchivesApply";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbArchivesApply merge(TbArchivesApply detachedInstance) {
		log.debug("merging TbArchivesApply instance");
		try {
			TbArchivesApply result = (TbArchivesApply) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbArchivesApply instance) {
		log.debug("attaching dirty TbArchivesApply instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbArchivesApply instance) {
		log.debug("attaching clean TbArchivesApply instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public static TbArchivesApplyDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbArchivesApplyDAOImpl) ctx.getBean("tbArchivesApplyDAO");
	}
}