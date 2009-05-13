package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbOffDocCateDAO;
import com.baosight.mode.TbOffDocCate;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbOffDocCate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.baosight.mode.TbOffDocCate
 * @author MyEclipse Persistence Tools
 */

public class TbOffDocCateDAOImpl extends HibernateDaoSupport implements ITbOffDocCateDAO{
	private static final Log log = LogFactory.getLog(TbOffDocCateDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbOffDocCate transientInstance) {
		log.debug("saving TbOffDocCate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbOffDocCate persistentInstance) {
		log.debug("deleting TbOffDocCate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbOffDocCate findById(java.lang.String id) {
		log.debug("getting TbOffDocCate instance with id: " + id);
		try {
			TbOffDocCate instance = (TbOffDocCate) getHibernateTemplate().get(
					"com.baosight.mode.TbOffDocCate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbOffDocCate instance) {
		log.debug("finding TbOffDocCate instance by example");
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
		log.debug("finding TbOffDocCate instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbOffDocCate as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbOffDocCate instances");
		try {
			String queryString = "from TbOffDocCate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbOffDocCate merge(TbOffDocCate detachedInstance) {
		log.debug("merging TbOffDocCate instance");
		try {
			TbOffDocCate result = (TbOffDocCate) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbOffDocCate instance) {
		log.debug("attaching dirty TbOffDocCate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbOffDocCate instance) {
		log.debug("attaching clean TbOffDocCate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbOffDocCateDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbOffDocCateDAOImpl) ctx.getBean("TbOffDocCateDAO");
	}
}