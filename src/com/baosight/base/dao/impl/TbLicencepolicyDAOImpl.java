package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbLicencepolicyDAO;
import com.baosight.mode.TbLicencepolicy;

/**
 * Data access object (DAO) for domain model class TbLicencepolicy.
 * 
 * @see com.baosight.mode.TbLicencepolicy
 * @author MyEclipse Persistence Tools
 */

public class TbLicencepolicyDAOImpl extends HibernateDaoSupport implements ITbLicencepolicyDAO {
	private static final Log log = LogFactory.getLog(TbLicencepolicyDAOImpl.class);

	// property constants
	public static final String RESOURCEID = "resourceid";

	public static final String BYRESOURCEID = "byresourceid";

	public static final String TIGHTTYPEID = "tighttypeid";

	public static final String BYRES_HASCHILD = "byresHaschild";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#save(com.baosight.mode.TbLicencepolicy)
	 */
	public void save(TbLicencepolicy transientInstance) {
		log.debug("saving TbLicencepolicy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#delete(com.baosight.mode.TbLicencepolicy)
	 */
	public void delete(TbLicencepolicy persistentInstance) {
		log.debug("deleting TbLicencepolicy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findById(java.lang.String)
	 */
	public TbLicencepolicy findById(java.lang.String id) {
		log.debug("getting TbLicencepolicy instance with id: " + id);
		try {
			TbLicencepolicy instance = (TbLicencepolicy) getHibernateTemplate()
					.get("com.baosight.mode.TbLicencepolicy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByExample(com.baosight.mode.TbLicencepolicy)
	 */
	public List findByExample(TbLicencepolicy instance) {
		log.debug("finding TbLicencepolicy instance by example");
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

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbLicencepolicy instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbLicencepolicy as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByResourceid(java.lang.Object)
	 */
	public List findByResourceid(Object resourceid) {
		return findByProperty(RESOURCEID, resourceid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByByresourceid(java.lang.Object)
	 */
	public List findByByresourceid(Object byresourceid) {
		return findByProperty(BYRESOURCEID, byresourceid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByTighttypeid(java.lang.Object)
	 */
	public List findByTighttypeid(Object tighttypeid) {
		return findByProperty(TIGHTTYPEID, tighttypeid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findByByresHaschild(java.lang.Object)
	 */
	public List findByByresHaschild(Object byresHaschild) {
		return findByProperty(BYRES_HASCHILD, byresHaschild);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbLicencepolicy instances");
		try {
			String queryString = "from TbLicencepolicy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#merge(com.baosight.mode.TbLicencepolicy)
	 */
	public TbLicencepolicy merge(TbLicencepolicy detachedInstance) {
		log.debug("merging TbLicencepolicy instance");
		try {
			TbLicencepolicy result = (TbLicencepolicy) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#attachDirty(com.baosight.mode.TbLicencepolicy)
	 */
	public void attachDirty(TbLicencepolicy instance) {
		log.debug("attaching dirty TbLicencepolicy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbLicencepolicyDAO#attachClean(com.baosight.mode.TbLicencepolicy)
	 */
	public void attachClean(TbLicencepolicy instance) {
		log.debug("attaching clean TbLicencepolicy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbLicencepolicyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbLicencepolicyDAO) ctx.getBean("tbLicencepolicyDAO");
	}
}