package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWarningPubDAO;
import com.baosight.mode.TbWarningPub;

/**
 * Data access object (DAO) for domain model class TbWarningPub.
 * 
 * @see com.baosight.mode.TbWarningPub
 * @author MyEclipse Persistence Tools
 */

public class TbWarningPubDAOImpl extends HibernateDaoSupport implements ITbWarningPubDAO {
	private static final Log log = LogFactory.getLog(TbWarningPubDAOImpl.class);

	private String queryCacheRegion = null;
	
	// property constants
	public static final String SIGNAL = "signal";

	public static final String RESP = "resp";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#save(com.baosight.mode.TbWarningPub)
	 */
	public void save(TbWarningPub transientInstance) {
		log.debug("saving TbWarningPub instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#delete(com.baosight.mode.TbWarningPub)
	 */
	public void delete(TbWarningPub persistentInstance) {
		log.debug("deleting TbWarningPub instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findById(java.lang.String)
	 */
	public TbWarningPub findById(java.lang.String id) {
		log.debug("getting TbWarningPub instance with id: " + id);
		try {
			TbWarningPub instance = (TbWarningPub) getHibernateTemplate().get(
					"com.baosight.mode.TbWarningPub", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByExample(com.baosight.mode.TbWarningPub)
	 */
	public List findByExample(TbWarningPub instance) {
		log.debug("finding TbWarningPub instance by example");
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

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbWarningPub instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbWarningPub as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findBySignal(java.lang.Object)
	 */
	public List findBySignal(Object signal) {
		return findByProperty(SIGNAL, signal);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByResp(java.lang.Object)
	 */
	public List findByResp(Object resp) {
		return findByProperty(RESP, resp);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbWarningPub instances");
		try {
			String queryString = "from TbWarningPub";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#merge(com.baosight.mode.TbWarningPub)
	 */
	public TbWarningPub merge(TbWarningPub detachedInstance) {
		log.debug("merging TbWarningPub instance");
		try {
			TbWarningPub result = (TbWarningPub) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#attachDirty(com.baosight.mode.TbWarningPub)
	 */
	public void attachDirty(TbWarningPub instance) {
		log.debug("attaching dirty TbWarningPub instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbWarningPubDAO#attachClean(com.baosight.mode.TbWarningPub)
	 */
	public void attachClean(TbWarningPub instance) {
		log.debug("attaching clean TbWarningPub instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * true
	 * -1-1
	 */
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
	
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public static ITbWarningPubDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbWarningPubDAO) ctx.getBean("tbWarningPubDAO");
	}
}