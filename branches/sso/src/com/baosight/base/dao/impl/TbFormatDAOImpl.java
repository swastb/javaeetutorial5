package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbFormatDAO;
import com.baosight.mode.TbFormat;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbFormat entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.baosight.mode.TbFormat
 * @author MyEclipse Persistence Tools
 */

public class TbFormatDAOImpl extends HibernateDaoSupport implements  ITbFormatDAO{
	private static final Log log = LogFactory.getLog(TbFormatDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbFormat transientInstance) {
		log.debug("saving TbFormat instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbFormat persistentInstance) {
		log.debug("deleting TbFormat instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbFormat findById(java.lang.String id) {
		log.debug("getting TbFormat instance with id: " + id);
		try {
			TbFormat instance = (TbFormat) getHibernateTemplate().get(
					"com.baosight.mode.TbFormat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbFormat instance) {
		log.debug("finding TbFormat instance by example");
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
		log.debug("finding TbFormat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbFormat as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbFormat instances");
		try {
			String queryString = "from TbFormat";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbFormat merge(TbFormat detachedInstance) {
		log.debug("merging TbFormat instance");
		try {
			TbFormat result = (TbFormat) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbFormat instance) {
		log.debug("attaching dirty TbFormat instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbFormat instance) {
		log.debug("attaching clean TbFormat instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbFormatDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbFormatDAOImpl) ctx.getBean("TbFormatDAO");
	}
}