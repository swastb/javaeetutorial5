package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserAuthDAO;
import com.baosight.mode.TbUserAuth;

/**
 * Data access object (DAO) for domain model class TbUserAuth.
 * 
 * @see com.baosight.mode.TbUserAuth
 * @author MyEclipse Persistence Tools
 */

public class TbUserAuthDAOImpl extends HibernateDaoSupport implements ITbUserAuthDAO {
	private static final Log log = LogFactory.getLog(TbUserAuthDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String AUTHID = "authid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#save(com.baosight.mode.TbUserAuth)
	 */
	public void save(TbUserAuth transientInstance) {
		log.debug("saving TbUserAuth instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#delete(com.baosight.mode.TbUserAuth)
	 */
	public void delete(TbUserAuth persistentInstance) {
		log.debug("deleting TbUserAuth instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findById(java.lang.String)
	 */
	public TbUserAuth findById(java.lang.String id) {
		log.debug("getting TbUserAuth instance with id: " + id);
		try {
			TbUserAuth instance = (TbUserAuth) getHibernateTemplate().get(
					"com.baosight.mode.TbUserAuth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findByExample(com.baosight.mode.TbUserAuth)
	 */
	public List findByExample(TbUserAuth instance) {
		log.debug("finding TbUserAuth instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserAuth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserAuth as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findByAuthid(java.lang.Object)
	 */
	public List findByAuthid(Object authid) {
		return findByProperty(AUTHID, authid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserAuth instances");
		try {
			String queryString = "from TbUserAuth";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#merge(com.baosight.mode.TbUserAuth)
	 */
	public TbUserAuth merge(TbUserAuth detachedInstance) {
		log.debug("merging TbUserAuth instance");
		try {
			TbUserAuth result = (TbUserAuth) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#attachDirty(com.baosight.mode.TbUserAuth)
	 */
	public void attachDirty(TbUserAuth instance) {
		log.debug("attaching dirty TbUserAuth instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAuthDAO#attachClean(com.baosight.mode.TbUserAuth)
	 */
	public void attachClean(TbUserAuth instance) {
		log.debug("attaching clean TbUserAuth instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserAuthDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbUserAuthDAO) ctx.getBean("tbUserAuthDAO");
	}
}