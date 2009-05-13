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

import com.baosight.base.dao.ITbAppsysDAO;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthlvl;

/**
 * Data access object (DAO) for domain model class TbAppsys.
 * 
 * @see com.baosight.mode.TbAppsys
 * @author MyEclipse Persistence Tools
 */

public class TbAppsysDAOImpl extends HibernateDaoSupport implements ITbAppsysDAO {
	private static final Log log = LogFactory.getLog(TbAppsysDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String URL = "url";

	public static final String CODE = "code";

	public static final String REM = "rem";

	public static final String ISCHILD = "isChild";
	
	private String queryCacheRegion = null;
	
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#save(com.baosight.mode.TbAppsys)
	 */
	public void save(TbAppsys transientInstance) {
		log.debug("saving TbAppsys instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#delete(com.baosight.mode.TbAppsys)
	 */
	public void delete(TbAppsys persistentInstance) {
		log.debug("deleting TbAppsys instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findById(java.lang.String)
	 */
	public TbAppsys findById(java.lang.String id) {
		log.debug("getting TbAppsys instance with id: " + id);
		try {
			TbAppsys instance = (TbAppsys) getHibernateTemplate().get(
					"com.baosight.mode.TbAppsys", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByExample(com.baosight.mode.TbAppsys)
	 */
	public List findByExample(TbAppsys instance) {
		log.debug("finding TbAppsys instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbAppsys instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbAppsys as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List checkCode(Object id,Object value) {
		log.debug("finding TbAppsys instance with property: code, value: " + value);
		String queryString ="";
		try {
			if("".equals(id))
			{
				//²åÈë
				queryString = "from TbAppsys as model where model.code= '"+value+"'";
			}else
			{
				//ÐÞ¸Ä
				queryString = "from TbAppsys as model where model.code= '"+value+"' and id != '"+id+"'";
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByUrl(java.lang.Object)
	 */
	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbAppsys instances");
		try {
			String queryString = "from TbAppsys";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#merge(com.baosight.mode.TbAppsys)
	 */
	public TbAppsys merge(TbAppsys detachedInstance) {
		log.debug("merging TbAppsys instance");
		try {
			TbAppsys result = (TbAppsys) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#attachDirty(com.baosight.mode.TbAppsys)
	 */
	public void attachDirty(TbAppsys instance) {
		log.debug("attaching dirty TbAppsys instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAppsysDAO#attachClean(com.baosight.mode.TbAppsys)
	 */
	public void attachClean(TbAppsys instance) {
		log.debug("attaching clean TbAppsys instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbAppsysDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbAppsysDAO) ctx.getBean("tbAppsysDAO");
	}
	
	
	public void update(TbAppsys item) {
		log.debug("update TbAppsys instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
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
}