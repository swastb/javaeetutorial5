package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbTypeDAO;
import com.baosight.mode.TbType;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.baosight.base.dao.impl.TbType
 * @author MyEclipse Persistence Tools
 */

public class TbTypeDAOImpl extends HibernateDaoSupport  implements ITbTypeDAO{
	
	private static final Log log = LogFactory.getLog(TbTypeDAOImpl.class);


	public void save(TbType transientInstance) {
		log.debug("saving TbType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbType persistentInstance) {
		log.debug("deleting TbType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbType findById(java.lang.String id) {
		log.debug("getting TbType instance with id: " + id);
		try {
			TbType instance = (TbType) getHibernateTemplate().get(
					"com.baosight.mode.TbType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbType instance) {
		log.debug("finding TbType instance by example");
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
		log.debug("finding TbType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbType instances");
		try {
			String queryString = "from TbType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbType merge(TbType detachedInstance) {
		log.debug("merging TbType instance");
		try {
			TbType result = (TbType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbType instance) {
		log.debug("attaching dirty TbType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbType instance) {
		log.debug("attaching clean TbType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbTypeDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbTypeDAOImpl) ctx.getBean("TbTypeDAO");
	}
}