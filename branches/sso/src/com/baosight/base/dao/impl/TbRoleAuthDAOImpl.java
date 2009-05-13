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

import com.baosight.base.dao.ITbRoleAuthDAO;
import com.baosight.mode.TbRoleAuth;

/**
 * Data access object (DAO) for domain model class TbRoleAuth.
 * 
 * @see com.baosight.mode.TbRoleAuth
 * @author MyEclipse Persistence Tools
 */

public class TbRoleAuthDAOImpl extends HibernateDaoSupport implements
		ITbRoleAuthDAO {
	private static final Log log = LogFactory.getLog(TbRoleAuthDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String ROLEID = "roleid";

	public static final String AUTHID = "authid";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#save(com.baosight.mode.TbRoleAuth)
	 */
	public void save(TbRoleAuth transientInstance) {
		log.debug("saving TbRoleAuth instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#delete(com.baosight.mode.TbRoleAuth)
	 */
	public void delete(TbRoleAuth persistentInstance) {
		log.debug("deleting TbRoleAuth instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findById(java.lang.String)
	 */
	public TbRoleAuth findById(java.lang.String id) {
		log.debug("getting TbRoleAuth instance with id: " + id);
		try {
			TbRoleAuth instance = (TbRoleAuth) getHibernateTemplate().get(
					"com.baosight.mode.TbRoleAuth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findByExample(com.baosight.mode.TbRoleAuth)
	 */
	public List findByExample(TbRoleAuth instance) {
		log.debug("finding TbRoleAuth instance by example");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbRoleAuth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbRoleAuth as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findByRoleid(java.lang.Object)
	 */
	public List findByRoleid(Object roleid) {
		return findByProperty(ROLEID, roleid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findByAuthid(java.lang.Object)
	 */
	public List findByAuthid(Object authid) {
		return findByProperty(AUTHID, authid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbRoleAuth instances");
		try {
			String queryString = "from TbRoleAuth";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#merge(com.baosight.mode.TbRoleAuth)
	 */
	public TbRoleAuth merge(TbRoleAuth detachedInstance) {
		log.debug("merging TbRoleAuth instance");
		try {
			TbRoleAuth result = (TbRoleAuth) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#attachDirty(com.baosight.mode.TbRoleAuth)
	 */
	public void attachDirty(TbRoleAuth instance) {
		log.debug("attaching dirty TbRoleAuth instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleAuthDAO#attachClean(com.baosight.mode.TbRoleAuth)
	 */
	public void attachClean(TbRoleAuth instance) {
		log.debug("attaching clean TbRoleAuth instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	/**
	 * true -1-1
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

	public static ITbRoleAuthDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbRoleAuthDAO) ctx.getBean("tbRoleAuthDAO");
	}
}