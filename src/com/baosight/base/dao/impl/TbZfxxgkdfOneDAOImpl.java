package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgkdfOneDAO;
import com.baosight.mode.TbZfxxgkdfOne;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfOne.
 * 
 * @see com.baosight.mode.TbZfxxgkdfOne
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgkdfOneDAOImpl extends HibernateDaoSupport implements ITbZfxxgkdfOneDAO {
	private static final Log log = LogFactory.getLog(TbZfxxgkdfOneDAOImpl.class);

	// property constants
	public static final String APPLI_NAME = "appliName";

	public static final String IFNO_NAME = "ifnoName";

	public static final String OFFER_WAY1 = "offerWay1";

	public static final String OFFER_WAY2 = "offerWay2";

	public static final String LS_NO = "lsNo";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgkdfOne transientInstance) {
		log.debug("saving TbZfxxgkdfOne instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgkdfOne persistentInstance) {
		log.debug("deleting TbZfxxgkdfOne instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbZfxxgkdfOne findById(java.lang.String id) {
		log.debug("getting TbZfxxgkdfOne instance with id: " + id);
		try {
			TbZfxxgkdfOne instance = (TbZfxxgkdfOne) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgkdfOne", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgkdfOne instance) {
		log.debug("finding TbZfxxgkdfOne instance by example");
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
		log.debug("finding TbZfxxgkdfOne instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgkdfOne as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAppliName(Object appliName) {
		return findByProperty(APPLI_NAME, appliName);
	}

	public List findByIfnoName(Object ifnoName) {
		return findByProperty(IFNO_NAME, ifnoName);
	}

	public List findByOfferWay1(Object offerWay1) {
		return findByProperty(OFFER_WAY1, offerWay1);
	}

	public List findByOfferWay2(Object offerWay2) {
		return findByProperty(OFFER_WAY2, offerWay2);
	}

	public List findByLsNo(Object lsNo) {
		return findByProperty(LS_NO, lsNo);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findAll() {
		log.debug("finding all TbZfxxgkdfOne instances");
		try {
			String queryString = "from TbZfxxgkdfOne";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgkdfOne merge(TbZfxxgkdfOne detachedInstance) {
		log.debug("merging TbZfxxgkdfOne instance");
		try {
			TbZfxxgkdfOne result = (TbZfxxgkdfOne) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgkdfOne instance) {
		log.debug("attaching dirty TbZfxxgkdfOne instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgkdfOne instance) {
		log.debug("attaching clean TbZfxxgkdfOne instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
}