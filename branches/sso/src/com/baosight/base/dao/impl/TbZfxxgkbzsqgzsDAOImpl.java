package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgkbzsqgzsDAO;
import com.baosight.mode.TbZfxxgkbzsqgzs;

/**
 * Data access object (DAO) for domain model class TbZfxxgkbzsqgzs.
 * 
 * @see com.baosight.mode.TbZfxxgkbzsqgzs
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgkbzsqgzsDAOImpl extends HibernateDaoSupport implements ITbZfxxgkbzsqgzsDAO {
	private static final Log log = LogFactory.getLog(TbZfxxgkbzsqgzsDAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgkbzsqgzs transientInstance) {
		log.debug("saving TbZfxxgkbzsqgzs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgkbzsqgzs persistentInstance) {
		log.debug("deleting TbZfxxgkbzsqgzs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbZfxxgkbzsqgzs persistentInstance) {
		log.debug("update TbZfxxgkbzsqgzs instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbZfxxgkbzsqgzs findById(java.lang.String id) {
		log.debug("getting TbZfxxgkbzsqgzs instance with id: " + id);
		try {
			TbZfxxgkbzsqgzs instance = (TbZfxxgkbzsqgzs) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgkbzsqgzs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgkbzsqgzs instance) {
		log.debug("finding TbZfxxgkbzsqgzs instance by example");
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
		log.debug("finding TbZfxxgkbzsqgzs instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgkbzsqgzs as model where model."
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
		log.debug("finding all TbZfxxgkbzsqgzs instances");
		try {
			String queryString = "from TbZfxxgkbzsqgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgkbzsqgzs merge(TbZfxxgkbzsqgzs detachedInstance) {
		log.debug("merging TbZfxxgkbzsqgzs instance");
		try {
			TbZfxxgkbzsqgzs result = (TbZfxxgkbzsqgzs) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgkbzsqgzs instance) {
		log.debug("attaching dirty TbZfxxgkbzsqgzs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgkbzsqgzs instance) {
		log.debug("attaching clean TbZfxxgkbzsqgzs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbZfxxgkbzsqgzsDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbZfxxgkbzsqgzsDAOImpl) ctx.getBean("TbZfxxgkbzsqgzsDAO");
	}
}