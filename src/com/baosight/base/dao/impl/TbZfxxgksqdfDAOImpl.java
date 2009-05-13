package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgksqdfDAO;
import com.baosight.mode.TbZfxxgksqdf;

/**
 * Data access object (DAO) for domain model class TbZfxxgksqdf.
 * 
 * @see com.baosight.mode.TbZfxxgksqdf
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgksqdfDAOImpl extends HibernateDaoSupport implements ITbZfxxgksqdfDAO {
	private static final Log log = LogFactory.getLog(TbZfxxgksqdfDAOImpl.class);

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String LS_NO = "lsNo";

	public static final String APPLICANT = "applicant";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgksqdf transientInstance) {
		log.debug("saving TbZfxxgksqdf instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgksqdf persistentInstance) {
		log.debug("deleting TbZfxxgksqdf instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbZfxxgksqdf persistentInstance) {
		log.debug("update TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdf findById(java.lang.String id) {
		log.debug("getting TbZfxxgksqdf instance with id: " + id);
		try {
			TbZfxxgksqdf instance = (TbZfxxgksqdf) getHibernateTemplate().get(
					"com.baosight.mode.TbZfxxgksqdf", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgksqdf instance) {
		log.debug("finding TbZfxxgksqdf instance by example");
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
		log.debug("finding TbZfxxgksqdf instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgksqdf as model where model."
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

	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	public List findAll() {
		log.debug("finding all TbZfxxgksqdf instances");
		try {
			String queryString = "from TbZfxxgksqdf";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgksqdf merge(TbZfxxgksqdf detachedInstance) {
		log.debug("merging TbZfxxgksqdf instance");
		try {
			TbZfxxgksqdf result = (TbZfxxgksqdf) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgksqdf instance) {
		log.debug("attaching dirty TbZfxxgksqdf instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgksqdf instance) {
		log.debug("attaching clean TbZfxxgksqdf instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbZfxxgksqdfDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbZfxxgksqdfDAOImpl) ctx.getBean("TbZfxxgksqdfDAO");
	}
}