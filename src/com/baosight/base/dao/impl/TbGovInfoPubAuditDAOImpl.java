package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbGovInfoPubAuditDAO;
import com.baosight.mode.TbGovInfoPubAudit;

/**
 * Data access object (DAO) for domain model class TbGovInfoPubAudit.
 * 
 * @see com.baosight.base.dao.impl.TbGovInfoPubAudit
 * @author MyEclipse Persistence Tools
 */

public class TbGovInfoPubAuditDAOImpl extends HibernateDaoSupport implements ITbGovInfoPubAuditDAO {
	private static final Log log = LogFactory
			.getLog(TbGovInfoPubAuditDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbGovInfoPubAudit transientInstance) {
		log.debug("saving TbGovInfoPubAudit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbGovInfoPubAudit persistentInstance) {
		log.debug("update TbGovInfoPubAudit instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(TbGovInfoPubAudit persistentInstance) {
		log.debug("deleting TbGovInfoPubAudit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbGovInfoPubAudit findById(java.lang.String id) {
		log.debug("getting TbGovInfoPubAudit instance with id: " + id);
		try {
			TbGovInfoPubAudit instance = (TbGovInfoPubAudit) getHibernateTemplate()
					.get("com.baosight.mode.TbGovInfoPubAudit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbGovInfoPubAudit instance) {
		log.debug("finding TbGovInfoPubAudit instance by example");
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
		log.debug("finding TbGovInfoPubAudit instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbGovInfoPubAudit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbGovInfoPubAudit instances");
		try {
			String queryString = "from TbGovInfoPubAudit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbGovInfoPubAudit merge(TbGovInfoPubAudit detachedInstance) {
		log.debug("merging TbGovInfoPubAudit instance");
		try {
			TbGovInfoPubAudit result = (TbGovInfoPubAudit) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbGovInfoPubAudit instance) {
		log.debug("attaching dirty TbGovInfoPubAudit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbGovInfoPubAudit instance) {
		log.debug("attaching clean TbGovInfoPubAudit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbGovInfoPubAuditDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbGovInfoPubAuditDAOImpl) ctx.getBean("tbGovInfoPubAuditDAO");
	}

	
}