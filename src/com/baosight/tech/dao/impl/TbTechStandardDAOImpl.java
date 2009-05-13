package com.baosight.tech.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.tech.dao.ITbTechStandardDAO;
import com.baosight.tech.mode.TbTechStandard;

/**
 * Data access object (DAO) for domain model class TbTechStandard.
 * 
 * @see com.baosight.tech.dao.impl.TbTechStandard
 * @author MyEclipse Persistence Tools
 */

public class TbTechStandardDAOImpl extends DAOHelperImpl implements ITbTechStandardDAO {
	private static final Log log = LogFactory.getLog(TbTechStandardDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbTechStandard transientInstance) {
		log.debug("saving TbTechStandard instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTechStandard persistentInstance) {
		log.debug("deleting TbTechStandard instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTechStandard findById(java.lang.String id) {
		log.debug("getting TbTechStandard instance with id: " + id);
		try {
			TbTechStandard instance = (TbTechStandard) getHibernateTemplate()
					.get("com.baosight.tech.mode.TbTechStandard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTechStandard instance) {
		log.debug("finding TbTechStandard instance by example");
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
		log.debug("finding TbTechStandard instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTechStandard as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbTechStandard instances");
		try {
			String queryString = "from TbTechStandard";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTechStandard merge(TbTechStandard detachedInstance) {
		log.debug("merging TbTechStandard instance");
		try {
			TbTechStandard result = (TbTechStandard) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTechStandard instance) {
		log.debug("attaching dirty TbTechStandard instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTechStandard instance) {
		log.debug("attaching clean TbTechStandard instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbTechStandardDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbTechStandardDAO) ctx.getBean("TbTechStandardDAO");
	}
}