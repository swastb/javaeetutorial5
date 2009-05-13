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

import com.baosight.base.dao.ITbAuthInfoDAO;
import com.baosight.mode.TbAuthInfo;

/**
 * Data access object (DAO) for domain model class TbAuthInfo.
 * 
 * @see com.baosight.mode.TbAuthInfo
 * @author MyEclipse Persistence Tools
 */

public class TbAuthInfoDAOImpl extends HibernateDaoSupport implements
		ITbAuthInfoDAO {
	private static final Log log = LogFactory.getLog(TbAuthInfoDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String FUNID = "funid";

	public static final String NAME = "name";

	public static final String HAS_CHILD = "hasChild";

	public static final String RIGHTTYPEID = "righttypeid";

	public static final String REM = "rem";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#save(com.baosight.mode.TbAuthInfo)
	 */
	public void save(TbAuthInfo transientInstance) {
		log.debug("saving TbAuthInfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#delete(com.baosight.mode.TbAuthInfo)
	 */
	public void delete(TbAuthInfo persistentInstance) {
		log.debug("deleting TbAuthInfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findById(java.lang.String)
	 */
	public TbAuthInfo findById(java.lang.String id) {
		log.debug("getting TbAuthInfo instance with id: " + id);
		try {
			TbAuthInfo instance = (TbAuthInfo) getHibernateTemplate().get(
					"com.baosight.mode.TbAuthInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByExample(com.baosight.mode.TbAuthInfo)
	 */
	public List findByExample(TbAuthInfo instance) {
		log.debug("finding TbAuthInfo instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbAuthInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbAuthInfo as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByFunid(java.lang.Object)
	 */
	public List findByFunid(Object funid) {
		return findByProperty(FUNID, funid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByHasChild(java.lang.Object)
	 */
	public List findByHasChild(Object hasChild) {
		return findByProperty(HAS_CHILD, hasChild);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByRighttypeid(java.lang.Object)
	 */
	public List findByRighttypeid(Object righttypeid) {
		return findByProperty(RIGHTTYPEID, righttypeid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbAuthInfo instances");
		try {
			String queryString = "from TbAuthInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#merge(com.baosight.mode.TbAuthInfo)
	 */
	public TbAuthInfo merge(TbAuthInfo detachedInstance) {
		log.debug("merging TbAuthInfo instance");
		try {
			TbAuthInfo result = (TbAuthInfo) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#attachDirty(com.baosight.mode.TbAuthInfo)
	 */
	public void attachDirty(TbAuthInfo instance) {
		log.debug("attaching dirty TbAuthInfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbAuthInfoDAO#attachClean(com.baosight.mode.TbAuthInfo)
	 */
	public void attachClean(TbAuthInfo instance) {
		log.debug("attaching clean TbAuthInfo instance");
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

	public static ITbAuthInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbAuthInfoDAO) ctx.getBean("tbAuthInfoDAO");
	}
}