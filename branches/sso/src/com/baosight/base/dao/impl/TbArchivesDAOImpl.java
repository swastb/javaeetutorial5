package com.baosight.base.dao.impl;

import java.io.Serializable;
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

import com.baosight.base.dao.ITbArchivesDAO;
import com.baosight.mode.TbArchives;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbVehiclesApply;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbArchives entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.baosight.mode.TbArchives
 * @author MyEclipse Persistence Tools
 */

public class TbArchivesDAOImpl extends HibernateDaoSupport implements  ITbArchivesDAO{
	private static final Log log = LogFactory.getLog(TbArchivesDAOImpl.class);

	protected void initDao() {
		// do nothing
	}
	private String queryCacheRegion = null;
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public void save(TbArchives transientInstance) {
		log.debug("saving TbArchives instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbArchives persistentInstance) {
		log.debug("deleting TbArchives instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(TbArchives transientInstance) {
		log.debug("updating TbArchives instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public TbArchives findById(java.lang.String id) {
		log.debug("getting TbArchives instance with id: " + id);
		try {
			TbArchives instance = (TbArchives) getHibernateTemplate().get(
					"com.baosight.mode.TbArchives", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbArchives instance) {
		log.debug("finding TbArchives instance by example");
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
		log.debug("finding TbArchives instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbArchives as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbArchives instances");
		try {
			String queryString = "from TbArchives";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbArchives merge(TbArchives detachedInstance) {
		log.debug("merging TbArchives instance");
		try {
			TbArchives result = (TbArchives) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbArchives instance) {
		log.debug("attaching dirty TbArchives instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbArchives instance) {
		log.debug("attaching clean TbArchives instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
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
	
	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	public static TbArchivesDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbArchivesDAOImpl) ctx.getBean("tbArchivesDAO");
	}

	public List findByObjects(Object entity) {
		// TODO Auto-generated method stub
		List results = getHibernateTemplate().findByExample(entity);
		return results;
	}
	
	public Object findById(Class entity,Serializable primaryKey) {
		Object instance = getHibernateTemplate().get(entity, primaryKey);
		return instance;
	}
}