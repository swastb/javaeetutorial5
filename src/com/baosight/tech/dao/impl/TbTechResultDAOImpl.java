package com.baosight.tech.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.tech.dao.ITbTechResultDAO;
import com.baosight.tech.mode.TbTechResult;

/**
 * Data access object (DAO) for domain model class TbTechResult.
 * 
 * @see com.baosight.tech.dao.impl.TbTechResult
 * @author MyEclipse Persistence Tools
 */

public class TbTechResultDAOImpl extends DAOHelperImpl implements ITbTechResultDAO {
	private static final Log log = LogFactory.getLog(TbTechResultDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbTechResult transientInstance) {
		log.debug("saving TbTechResult instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTechResult persistentInstance) {
		log.debug("deleting TbTechResult instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTechResult findById(java.lang.String id) {
		log.debug("getting TbTechResult instance with id: " + id);
		try {
			TbTechResult instance = (TbTechResult) getHibernateTemplate().get(
					"com.baosight.tech.mode.TbTechResult", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTechResult instance) {
		log.debug("finding TbTechResult instance by example");
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
		log.debug("finding TbTechResult instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTechResult as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbTechResult instances");
		try {
			String queryString = "from TbTechResult";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTechResult merge(TbTechResult detachedInstance) {
		log.debug("merging TbTechResult instance");
		try {
			TbTechResult result = (TbTechResult) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTechResult instance) {
		log.debug("attaching dirty TbTechResult instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTechResult instance) {
		log.debug("attaching clean TbTechResult instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbTechResultDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbTechResultDAO) ctx.getBean("TbTechResultDAO");
	}
}