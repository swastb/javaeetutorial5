package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgkcfsqgzsDAO;
import com.baosight.mode.TbZfxxgkcfsqgzs;

/**
 * Data access object (DAO) for domain model class TbZfxxgkcfsqgzs.
 * 
 * @see com.baosight.mode.TbZfxxgkcfsqgzs
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgkcfsqgzsDAOImpl extends HibernateDaoSupport implements ITbZfxxgkcfsqgzsDAO {
	private static final Log log = LogFactory.getLog(TbZfxxgkcfsqgzsDAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgkcfsqgzs transientInstance) {
		log.debug("saving TbZfxxgkcfsqgzs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgkcfsqgzs persistentInstance) {
		log.debug("deleting TbZfxxgkcfsqgzs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbZfxxgkcfsqgzs persistentInstance) {
		log.debug("update TbZfxxgkcfsqgzs instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbZfxxgkcfsqgzs findById(java.lang.String id) {
		log.debug("getting TbZfxxgkcfsqgzs instance with id: " + id);
		try {
			TbZfxxgkcfsqgzs instance = (TbZfxxgkcfsqgzs) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgkcfsqgzs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgkcfsqgzs instance) {
		log.debug("finding TbZfxxgkcfsqgzs instance by example");
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
		log.debug("finding TbZfxxgkcfsqgzs instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgkcfsqgzs as model where model."
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
		log.debug("finding all TbZfxxgkcfsqgzs instances");
		try {
			String queryString = "from TbZfxxgkcfsqgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgkcfsqgzs merge(TbZfxxgkcfsqgzs detachedInstance) {
		log.debug("merging TbZfxxgkcfsqgzs instance");
		try {
			TbZfxxgkcfsqgzs result = (TbZfxxgkcfsqgzs) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgkcfsqgzs instance) {
		log.debug("attaching dirty TbZfxxgkcfsqgzs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgkcfsqgzs instance) {
		log.debug("attaching clean TbZfxxgkcfsqgzs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbZfxxgkcfsqgzsDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbZfxxgkcfsqgzsDAOImpl) ctx.getBean("TbZfxxgkcfsqgzsDAO");
	}
}