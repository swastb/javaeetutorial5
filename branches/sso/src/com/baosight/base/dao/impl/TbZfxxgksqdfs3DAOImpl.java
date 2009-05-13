package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgksqdfs3DAO;
import com.baosight.mode.TbZfxxgksqdfs3;

/**
 * Data access object (DAO) for domain model class TbZfxxgksqdfs3.
 * 
 * @see com.baosight.mode.TbZfxxgksqdfs3
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgksqdfs3DAOImpl extends HibernateDaoSupport implements ITbZfxxgksqdfs3DAO {
	private static final Log log = LogFactory.getLog(TbZfxxgksqdfs3DAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgksqdfs3 transientInstance) {
		log.debug("saving TbZfxxgksqdfs3 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgksqdfs3 persistentInstance) {
		log.debug("deleting TbZfxxgksqdfs3 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbZfxxgksqdfs3 persistentInstance) {
		log.debug("update TbZfxxgksqdfs3 instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdfs3 findById(java.lang.String id) {
		log.debug("getting TbZfxxgksqdfs3 instance with id: " + id);
		try {
			TbZfxxgksqdfs3 instance = (TbZfxxgksqdfs3) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgksqdfs3", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgksqdfs3 instance) {
		log.debug("finding TbZfxxgksqdfs3 instance by example");
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
		log.debug("finding TbZfxxgksqdfs3 instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgksqdfs3 as model where model."
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
		log.debug("finding all TbZfxxgksqdfs3 instances");
		try {
			String queryString = "from TbZfxxgksqdfs3";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdfs3 merge(TbZfxxgksqdfs3 detachedInstance) {
		log.debug("merging TbZfxxgksqdfs3 instance");
		try {
			TbZfxxgksqdfs3 result = (TbZfxxgksqdfs3) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgksqdfs3 instance) {
		log.debug("attaching dirty TbZfxxgksqdfs3 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgksqdfs3 instance) {
		log.debug("attaching clean TbZfxxgksqdfs3 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbZfxxgksqdfs3DAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbZfxxgksqdfs3DAOImpl) ctx.getBean("TbZfxxgksqdfs3DAO");
	}
}