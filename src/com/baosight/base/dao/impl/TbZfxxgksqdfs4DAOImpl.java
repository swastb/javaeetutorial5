package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgksqdfs4DAO;
import com.baosight.mode.TbZfxxgksqdfs4;

/**
 * Data access object (DAO) for domain model class TbZfxxgksqdfs4.
 * 
 * @see com.baosight.mode.TbZfxxgksqdfs4
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgksqdfs4DAOImpl extends HibernateDaoSupport implements ITbZfxxgksqdfs4DAO {
	private static final Log log = LogFactory.getLog(TbZfxxgksqdfs4DAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgksqdfs4 transientInstance) {
		log.debug("saving TbZfxxgksqdfs4 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgksqdfs4 persistentInstance) {
		log.debug("deleting TbZfxxgksqdfs4 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbZfxxgksqdfs4 persistentInstance) {
		log.debug("update TbZfxxgksqdfs4 instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdfs4 findById(java.lang.String id) {
		log.debug("getting TbZfxxgksqdfs4 instance with id: " + id);
		try {
			TbZfxxgksqdfs4 instance = (TbZfxxgksqdfs4) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgksqdfs4", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgksqdfs4 instance) {
		log.debug("finding TbZfxxgksqdfs4 instance by example");
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
		log.debug("finding TbZfxxgksqdfs4 instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgksqdfs4 as model where model."
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
		log.debug("finding all TbZfxxgksqdfs4 instances");
		try {
			String queryString = "from TbZfxxgksqdfs4";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdfs4 merge(TbZfxxgksqdfs4 detachedInstance) {
		log.debug("merging TbZfxxgksqdfs4 instance");
		try {
			TbZfxxgksqdfs4 result = (TbZfxxgksqdfs4) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgksqdfs4 instance) {
		log.debug("attaching dirty TbZfxxgksqdfs4 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgksqdfs4 instance) {
		log.debug("attaching clean TbZfxxgksqdfs4 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbZfxxgksqdfs4DAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbZfxxgksqdfs4DAOImpl) ctx.getBean("TbZfxxgksqdfs4DAO");
	}
}