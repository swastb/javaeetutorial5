package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbYqdfgzsDAO;
import com.baosight.mode.TbYqdfgzs;

/**
 * Data access object (DAO) for domain model class TbYqdfgzs.
 * 
 * @see com.baosight.mode.TbYqdfgzs
 * @author MyEclipse Persistence Tools
 */

public class TbYqdfgzsDAOImpl extends HibernateDaoSupport implements ITbYqdfgzsDAO {
	private static final Log log = LogFactory.getLog(TbYqdfgzsDAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbYqdfgzs transientInstance) {
		log.debug("saving TbYqdfgzs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbYqdfgzs persistentInstance) {
		log.debug("deleting TbYqdfgzs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbYqdfgzs persistentInstance) {
		log.debug("update TbYqdfgzs instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbYqdfgzs findById(java.lang.String id) {
		log.debug("getting TbYqdfgzs instance with id: " + id);
		try {
			TbYqdfgzs instance = (TbYqdfgzs) getHibernateTemplate().get(
					"com.baosight.mode.TbYqdfgzs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbYqdfgzs instance) {
		log.debug("finding TbYqdfgzs instance by example");
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
		log.debug("finding TbYqdfgzs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbYqdfgzs as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInfoId(Object infoId) {
		return findByProperty(INFO_ID, infoId);
	}

	public List findByLsNo(Object lsNo) {
		return findByProperty(LS_NO, lsNo);
	}

	public List findByApplicant(Object applicant) {
		return findByProperty(APPLICANT, applicant);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findAll() {
		log.debug("finding all TbYqdfgzs instances");
		try {
			String queryString = "from TbYqdfgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbYqdfgzs merge(TbYqdfgzs detachedInstance) {
		log.debug("merging TbYqdfgzs instance");
		try {
			TbYqdfgzs result = (TbYqdfgzs) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbYqdfgzs instance) {
		log.debug("attaching dirty TbYqdfgzs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbYqdfgzs instance) {
		log.debug("attaching clean TbYqdfgzs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbYqdfgzsDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbYqdfgzsDAOImpl) ctx.getBean("TbYqdfgzsDAO");
	}
}