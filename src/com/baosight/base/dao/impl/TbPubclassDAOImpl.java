package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbPubclassDAO;
import com.baosight.mode.TbPubclass;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbPubclass entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.baosight.mode.TbPubclass
 * @author MyEclipse Persistence Tools
 */

public class TbPubclassDAOImpl extends HibernateDaoSupport implements ITbPubclassDAO {
	private static final Log log = LogFactory.getLog(TbPubclassDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbPubclass transientInstance) {
		log.debug("saving TbPubclass instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbPubclass persistentInstance) {
		log.debug("deleting TbPubclass instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbPubclass findById(java.lang.String id) {
		log.debug("getting TbPubclass instance with id: " + id);
		try {
			TbPubclass instance = (TbPubclass) getHibernateTemplate().get(
					"com.baosight.mode.TbPubclass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbPubclass instance) {
		log.debug("finding TbPubclass instance by example");
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
		log.debug("finding TbPubclass instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbPubclass as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbPubclass instances");
		try {
			String queryString = "from TbPubclass";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbPubclass merge(TbPubclass detachedInstance) {
		log.debug("merging TbPubclass instance");
		try {
			TbPubclass result = (TbPubclass) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbPubclass instance) {
		log.debug("attaching dirty TbPubclass instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbPubclass instance) {
		log.debug("attaching clean TbPubclass instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbPubclassDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbPubclassDAOImpl) ctx.getBean("TbPubclassDAO");
	}
}