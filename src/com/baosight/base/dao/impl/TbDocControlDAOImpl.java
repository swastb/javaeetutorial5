package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocControlDAO;
import com.baosight.mode.TbDocControl;

/**
 * Data access object (DAO) for domain model class TbDocControl.
 * 
 * @see com.baosight.base.dao.impl.TbDocControl
 * @author MyEclipse Persistence Tools
 */

public class TbDocControlDAOImpl extends HibernateDaoSupport implements ITbDocControlDAO {
	private static final Log log = LogFactory.getLog(TbDocControlDAOImpl.class);

	// property constants
	public static final String STATE_NAME = "stateName";

	public static final String USER_ID = "userId";

	public static final String USER_NAME = "userName";

	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#save(com.baosight.mode.TbDocControl)
	 */
	public void save(TbDocControl transientInstance) {
		log.debug("saving TbDocControl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#delete(com.baosight.mode.TbDocControl)
	 */
	public void delete(TbDocControl persistentInstance) {
		log.debug("deleting TbDocControl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findById(java.lang.String)
	 */
	public TbDocControl findById(java.lang.String id) {
		log.debug("getting TbDocControl instance with id: " + id);
		try {
			TbDocControl instance = (TbDocControl) getHibernateTemplate().get(
					"com.baosight.mode.TbDocControl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByExample(com.baosight.mode.TbDocControl)
	 */
	public List findByExample(TbDocControl instance) {
		log.debug("finding TbDocControl instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocControl instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocControl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByStateName(java.lang.Object)
	 */
	public List findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findByState(java.lang.Object)
	 */
	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocControl instances");
		try {
			String queryString = "from TbDocControl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#merge(com.baosight.mode.TbDocControl)
	 */
	public TbDocControl merge(TbDocControl detachedInstance) {
		log.debug("merging TbDocControl instance");
		try {
			TbDocControl result = (TbDocControl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#attachDirty(com.baosight.mode.TbDocControl)
	 */
	public void attachDirty(TbDocControl instance) {
		log.debug("attaching dirty TbDocControl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocControlDAO#attachClean(com.baosight.mode.TbDocControl)
	 */
	public void attachClean(TbDocControl instance) {
		log.debug("attaching clean TbDocControl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocControlDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocControlDAO) ctx.getBean("TbDocControlDAO");
	}
}