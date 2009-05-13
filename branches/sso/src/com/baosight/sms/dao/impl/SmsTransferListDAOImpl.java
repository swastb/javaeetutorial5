package com.baosight.sms.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.sms.dao.SmsTransferListDAO;
import com.baosight.sms.mode.SmsTransferList;

/**
 * Data access object (DAO) for domain model class SmsTransferList.
 * 
 * @see com.baosight.sms.mode.SmsTransferList
 * @author MyEclipse Persistence Tools
 */

public class SmsTransferListDAOImpl extends HibernateDaoSupport implements SmsTransferListDAO {
	private static final Log log = LogFactory.getLog(SmsTransferListDAOImpl.class);

	// property constants
	public static final String SENDER_MOBILE = "senderMobile";

	public static final String SENDER_NAME = "senderName";

	public static final String SENDER_DEPT = "senderDept";

	public static final String SENDER_TYPE = "senderType";

	public static final String BZ1 = "bz1";

	public static final String BZ2 = "bz2";

	protected void initDao() {
		// do nothing
	}

	public void save(SmsTransferList transientInstance) {
		log.debug("saving SmsTransferList instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SmsTransferList persistentInstance) {
		log.debug("deleting SmsTransferList instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SmsTransferList findById(java.lang.String id) {
		log.debug("getting SmsTransferList instance with id: " + id);
		try {
			SmsTransferList instance = (SmsTransferList) getHibernateTemplate()
					.get("com.baosight.sms.mode.SmsTransferList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SmsTransferList instance) {
		log.debug("finding SmsTransferList instance by example");
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
		log.debug("finding SmsTransferList instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SmsTransferList as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySenderMobile(Object senderMobile) {
		return findByProperty(SENDER_MOBILE, senderMobile);
	}

	public List findBySenderName(Object senderName) {
		return findByProperty(SENDER_NAME, senderName);
	}

	public List findBySenderDept(Object senderDept) {
		return findByProperty(SENDER_DEPT, senderDept);
	}

	public List findBySenderType(Object senderType) {
		return findByProperty(SENDER_TYPE, senderType);
	}

	public List findByBz1(Object bz1) {
		return findByProperty(BZ1, bz1);
	}

	public List findByBz2(Object bz2) {
		return findByProperty(BZ2, bz2);
	}

	public List findAll() {
		log.debug("finding all SmsTransferList instances");
		try {
			String queryString = "from SmsTransferList";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SmsTransferList merge(SmsTransferList detachedInstance) {
		log.debug("merging SmsTransferList instance");
		try {
			SmsTransferList result = (SmsTransferList) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SmsTransferList instance) {
		log.debug("attaching dirty SmsTransferList instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SmsTransferList instance) {
		log.debug("attaching clean SmsTransferList instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SmsTransferListDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SmsTransferListDAO) ctx.getBean("SmsTransferListDAO");
	}
}