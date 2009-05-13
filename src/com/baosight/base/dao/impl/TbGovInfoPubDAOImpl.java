package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbGovInfoPubDAO;
import com.baosight.mode.TbGovInfoPub;

/**
 * Data access object (DAO) for domain model class TbGovInfoPub.
 * 
 * @see com.baosight.base.dao.impl.TbGovInfoPub
 * @author MyEclipse Persistence Tools
 */

public class TbGovInfoPubDAOImpl extends HibernateDaoSupport implements  ITbGovInfoPubDAO {
	private static final Log log = LogFactory.getLog(TbGovInfoPubDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbGovInfoPub transientInstance) {
		log.debug("saving TbGovInfoPub instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbGovInfoPub persistentInstance) {
		log.debug("update TbGovInfoPub instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(TbGovInfoPub persistentInstance) {
		log.debug("deleting TbGovInfoPub instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbGovInfoPub findById(java.lang.String id) {
		log.debug("getting TbGovInfoPub instance with id: " + id);
		try {
			TbGovInfoPub instance = (TbGovInfoPub) getHibernateTemplate().get(
					"com.baosight.mode.TbGovInfoPub", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbGovInfoPub instance) {
		log.debug("finding TbGovInfoPub instance by example");
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
		log.debug("finding TbGovInfoPub instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbGovInfoPub as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public List findAll() {
		log.debug("finding all TbGovInfoPub instances");
		try {
			String queryString = "from TbGovInfoPub";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbGovInfoPub merge(TbGovInfoPub detachedInstance) {
		log.debug("merging TbGovInfoPub instance");
		try {
			TbGovInfoPub result = (TbGovInfoPub) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbGovInfoPub instance) {
		log.debug("attaching dirty TbGovInfoPub instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbGovInfoPub instance) {
		log.debug("attaching clean TbGovInfoPub instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbGovInfoPubDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbGovInfoPubDAOImpl) ctx.getBean("tbGovInfoPubDAO");
	}
	
	
}