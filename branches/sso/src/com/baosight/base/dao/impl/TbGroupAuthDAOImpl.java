package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbGroupAuthDAO;
import com.baosight.mode.TbGroupAuth;

/**
 * Data access object (DAO) for domain model class TbGroupAuth.
 * 
 * @see com.baosight.mode.TbGroupAuth
 * @author MyEclipse Persistence Tools
 */

public class TbGroupAuthDAOImpl extends HibernateDaoSupport implements ITbGroupAuthDAO {
	private static final Log log = LogFactory.getLog(TbGroupAuthDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbGroupAuth transientInstance) {
		log.debug("saving TbGroupAuth instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbGroupAuth persistentInstance) {
		log.debug("deleting TbGroupAuth instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbGroupAuth findById(java.lang.String id) {
		log.debug("getting TbGroupAuth instance with id: " + id);
		try {
			TbGroupAuth instance = (TbGroupAuth) getHibernateTemplate().get(
					"com.baosight.mode.TbGroupAuth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbGroupAuth instance) {
		log.debug("finding TbGroupAuth instance by example");
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
		log.debug("finding TbGroupAuth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbGroupAuth as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGroupid(Object groupid) {
		return findByProperty(GROUPID, groupid);
	}

	public List findByAuthid(Object authid) {
		return findByProperty(AUTHID, authid);
	}

	public List findAll() {
		log.debug("finding all TbGroupAuth instances");
		try {
			String queryString = "from TbGroupAuth";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbGroupAuth merge(TbGroupAuth detachedInstance) {
		log.debug("merging TbGroupAuth instance");
		try {
			TbGroupAuth result = (TbGroupAuth) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbGroupAuth instance) {
		log.debug("attaching dirty TbGroupAuth instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbGroupAuth instance) {
		log.debug("attaching clean TbGroupAuth instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbGroupAuthDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbGroupAuthDAO) ctx.getBean("tbGroupAuthDAO");
	}
}