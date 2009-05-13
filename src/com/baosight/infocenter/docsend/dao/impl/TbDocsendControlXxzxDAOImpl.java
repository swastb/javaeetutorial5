package com.baosight.infocenter.docsend.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.infocenter.docsend.dao.ITbDocsendControlXxzxDAO;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;

/**
 * Data access object (DAO) for domain model class TbDocsendControlXxzx.
 * 
 * @see com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx
 * @author MyEclipse Persistence Tools
 */

public class TbDocsendControlXxzxDAOImpl extends HibernateDaoSupport implements ITbDocsendControlXxzxDAO {
	private static final Log log = LogFactory
			.getLog(TbDocsendControlXxzxDAOImpl.class);

	// property constants
	public static final String STATE_NAME = "stateName";

	public static final String USER_ID = "userId";

	public static final String USER_NAME = "userName";

	public static final String STATE = "state";

	public static final String STATE_TYPE = "stateType";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocsendControlXxzx transientInstance) {
		log.debug("saving TbDocsendControlXxzx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocsendControlXxzx persistentInstance) {
		log.debug("deleting TbDocsendControlXxzx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocsendControlXxzx findById(java.lang.String id) {
		log.debug("getting TbDocsendControlXxzx instance with id: " + id);
		try {
			TbDocsendControlXxzx instance = (TbDocsendControlXxzx) getHibernateTemplate()
					.get(
							"com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocsendControlXxzx instance) {
		log.debug("finding TbDocsendControlXxzx instance by example");
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
		log.debug("finding TbDocsendControlXxzx instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocsendControlXxzx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByStateType(Object stateType) {
		return findByProperty(STATE_TYPE, stateType);
	}

	public List findAll() {
		log.debug("finding all TbDocsendControlXxzx instances");
		try {
			String queryString = "from TbDocsendControlXxzx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocsendControlXxzx merge(TbDocsendControlXxzx detachedInstance) {
		log.debug("merging TbDocsendControlXxzx instance");
		try {
			TbDocsendControlXxzx result = (TbDocsendControlXxzx) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocsendControlXxzx instance) {
		log.debug("attaching dirty TbDocsendControlXxzx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocsendControlXxzx instance) {
		log.debug("attaching clean TbDocsendControlXxzx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocsendControlXxzxDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocsendControlXxzxDAO) ctx.getBean("TbDocsendControlXxzxDAO");
	}
}