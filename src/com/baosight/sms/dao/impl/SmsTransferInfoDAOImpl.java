package com.baosight.sms.dao.impl;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.sms.dao.SmsTransferInfoDAO;
import com.baosight.sms.mode.SmsTransferInfo;

/**
 * Data access object (DAO) for domain model class SmsTransferInfo.
 * 
 * @see com.baosight.sms.mode.SmsTransferInfo
 * @author MyEclipse Persistence Tools
 */

public class SmsTransferInfoDAOImpl extends HibernateDaoSupport implements SmsTransferInfoDAO {
	private static final Log log = LogFactory.getLog(SmsTransferInfoDAOImpl.class);

	// property constants
	public static final String RECEIVE_MOBILE = "receiveMobile";

	public static final String RECEIVE_NAME = "receiveName";

	public static final String RECEIVE_DEPT = "receiveDept";

	public static final String SENDER_MOBILE = "senderMobile";

	public static final String BZ = "bz";

	public static final String RECEIVE_TYPE = "receiveType";

	protected void initDao() {
		// do nothing
	}

	public void save(SmsTransferInfo transientInstance) {
		log.debug("saving SmsTransferInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SmsTransferInfo persistentInstance) {
		log.debug("deleting SmsTransferInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SmsTransferInfo findById(java.lang.String id) {
		log.debug("getting SmsTransferInfo instance with id: " + id);
		try {
			SmsTransferInfo instance = (SmsTransferInfo) getHibernateTemplate()
					.get("com.baosight.sms.mode.SmsTransferInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SmsTransferInfo instance) {
		log.debug("finding SmsTransferInfo instance by example");
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
		log.debug("finding SmsTransferInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SmsTransferInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReceiveMobile(Object receiveMobile) {
		return findByProperty(RECEIVE_MOBILE, receiveMobile);
	}

	public List findByReceiveName(Object receiveName) {
		return findByProperty(RECEIVE_NAME, receiveName);
	}

	public List findByReceiveDept(Object receiveDept) {
		return findByProperty(RECEIVE_DEPT, receiveDept);
	}

	public List findBySenderMobile(Object senderMobile) {
		return findByProperty(SENDER_MOBILE, senderMobile);
	}

	public List findByBz(Object bz) {
		return findByProperty(BZ, bz);
	}

	public List findByReceiveType(Object receiveType) {
		return findByProperty(RECEIVE_TYPE, receiveType);
	}

	public List findAll() {
		log.debug("finding all SmsTransferInfo instances");
		try {
			String queryString = "from SmsTransferInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SmsTransferInfo merge(SmsTransferInfo detachedInstance) {
		log.debug("merging SmsTransferInfo instance");
		try {
			SmsTransferInfo result = (SmsTransferInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SmsTransferInfo instance) {
		log.debug("attaching dirty SmsTransferInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SmsTransferInfo instance) {
		log.debug("attaching clean SmsTransferInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public int exeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.executeUpdate();
	}

	public List findByHQL(final String hql, final boolean cacheable,
			final int startIndex, final int maxResultCount) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (cacheable) {
					query.setCacheable(true);
					if (getQueryCacheRegion() != null) {
						query.setCacheRegion(getQueryCacheRegion());
					}
				}
				if (maxResultCount != -1)
					query.setMaxResults(maxResultCount);
				if (startIndex != -1)
					query.setFirstResult(startIndex);
				return query.list();
			}
		}, true);
	}

	private String queryCacheRegion = null;
	
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public static SmsTransferInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SmsTransferInfoDAO) ctx.getBean("SmsTransferInfoDAO");
	}

	public List findBySQL(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

}