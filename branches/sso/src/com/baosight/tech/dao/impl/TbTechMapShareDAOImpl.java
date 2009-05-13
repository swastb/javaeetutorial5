package com.baosight.tech.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.tech.dao.ITbTechMapShareDAO;
import com.baosight.tech.mode.TbTechMapShare;

/**
 * Data access object (DAO) for domain model class TbTechMapShare.
 * 
 * @see com.baosight.tech.dao.impl.TbTechMapShare
 * @author MyEclipse Persistence Tools
 */

public class TbTechMapShareDAOImpl extends DAOHelperImpl implements ITbTechMapShareDAO {
	private static final Log log = LogFactory.getLog(TbTechMapShareDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbTechMapShare transientInstance) {
		log.debug("saving TbTechMapShare instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTechMapShare persistentInstance) {
		log.debug("deleting TbTechMapShare instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTechMapShare findById(java.lang.String id) {
		log.debug("getting TbTechMapShare instance with id: " + id);
		try {
			TbTechMapShare instance = (TbTechMapShare) getHibernateTemplate()
					.get("com.baosight.tech.mode.TbTechMapShare", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTechMapShare instance) {
		log.debug("finding TbTechMapShare instance by example");
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
		log.debug("finding TbTechMapShare instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTechMapShare as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbTechMapShare instances");
		try {
			String queryString = "from TbTechMapShare";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTechMapShare merge(TbTechMapShare detachedInstance) {
		log.debug("merging TbTechMapShare instance");
		try {
			TbTechMapShare result = (TbTechMapShare) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTechMapShare instance) {
		log.debug("attaching dirty TbTechMapShare instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTechMapShare instance) {
		log.debug("attaching clean TbTechMapShare instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbTechMapShareDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbTechMapShareDAO) ctx.getBean("TbTechMapShareDAO");
	}
}