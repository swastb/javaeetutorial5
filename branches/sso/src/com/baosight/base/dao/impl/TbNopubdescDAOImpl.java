package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbNopubdescDAO;
import com.baosight.mode.TbNopubdesc;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbNopubdesc entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.baosight.mode.TbNopubdesc
 * @author MyEclipse Persistence Tools
 */

public class TbNopubdescDAOImpl extends HibernateDaoSupport implements ITbNopubdescDAO {
	private static final Log log = LogFactory.getLog(TbNopubdescDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbNopubdesc transientInstance) {
		log.debug("saving TbNopubdesc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbNopubdesc persistentInstance) {
		log.debug("deleting TbNopubdesc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbNopubdesc findById(java.lang.String id) {
		log.debug("getting TbNopubdesc instance with id: " + id);
		try {
			TbNopubdesc instance = (TbNopubdesc) getHibernateTemplate().get(
					"com.baosight.mode.TbNopubdesc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbNopubdesc instance) {
		log.debug("finding TbNopubdesc instance by example");
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
		log.debug("finding TbNopubdesc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbNopubdesc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbNopubdesc instances");
		try {
			String queryString = "from TbNopubdesc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbNopubdesc merge(TbNopubdesc detachedInstance) {
		log.debug("merging TbNopubdesc instance");
		try {
			TbNopubdesc result = (TbNopubdesc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbNopubdesc instance) {
		log.debug("attaching dirty TbNopubdesc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbNopubdesc instance) {
		log.debug("attaching clean TbNopubdesc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbNopubdescDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbNopubdescDAOImpl) ctx.getBean("TbNopubdescDAO");
	}
}