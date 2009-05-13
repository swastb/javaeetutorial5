package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocsendControlDAO;
import com.baosight.mode.TbDocsendControl;

/**
 * Data access object (DAO) for domain model class TbDocsendControl.
 * 
 * @see com.baosight.mode.TbDocsendControl
 * @author MyEclipse Persistence Tools
 */

public class TbDocsendControlDAOImpl extends HibernateDaoSupport implements ITbDocsendControlDAO {
	private static final Log log = LogFactory.getLog(TbDocsendControlDAOImpl.class);

	// property constants
	public static final String STATE_NAME = "stateName";

	public static final String USER_ID = "userId";

	public static final String USER_NAME = "userName";

	public static final String STATE = "state";

	public static final String STATE_TYPE = "stateType";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#save(com.baosight.mode.TbDocsendControl)
	 */
	public void save(TbDocsendControl transientInstance) {
		log.debug("saving TbDocsendControl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#delete(com.baosight.mode.TbDocsendControl)
	 */
	public void delete(TbDocsendControl persistentInstance) {
		log.debug("deleting TbDocsendControl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findById(java.lang.String)
	 */
	public TbDocsendControl findById(java.lang.String id) {
		log.debug("getting TbDocsendControl instance with id: " + id);
		try {
			TbDocsendControl instance = (TbDocsendControl) getHibernateTemplate()
					.get("com.baosight.mode.TbDocsendControl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByExample(com.baosight.mode.TbDocsendControl)
	 */
	public List findByExample(TbDocsendControl instance) {
		log.debug("finding TbDocsendControl instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocsendControl instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocsendControl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByStateName(java.lang.Object)
	 */
	public List findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByState(java.lang.Object)
	 */
	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findByStateType(java.lang.Object)
	 */
	public List findByStateType(Object stateType) {
		return findByProperty(STATE_TYPE, stateType);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocsendControl instances");
		try {
			String queryString = "from TbDocsendControl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#merge(com.baosight.mode.TbDocsendControl)
	 */
	public TbDocsendControl merge(TbDocsendControl detachedInstance) {
		log.debug("merging TbDocsendControl instance");
		try {
			TbDocsendControl result = (TbDocsendControl) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#attachDirty(com.baosight.mode.TbDocsendControl)
	 */
	public void attachDirty(TbDocsendControl instance) {
		log.debug("attaching dirty TbDocsendControl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendControlDAO#attachClean(com.baosight.mode.TbDocsendControl)
	 */
	public void attachClean(TbDocsendControl instance) {
		log.debug("attaching clean TbDocsendControl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocsendControlDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocsendControlDAO) ctx.getBean("tbDocsendControlDAO");
	}
}