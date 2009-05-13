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

import com.baosight.base.dao.ITbRighttypeDAO;
import com.baosight.mode.TbRighttype;

/**
 * Data access object (DAO) for domain model class TbRighttype.
 * 
 * @see com.baosight.mode.TbRighttype
 * @author MyEclipse Persistence Tools
 */

public class TbRighttypeDAOImpl extends HibernateDaoSupport implements
		ITbRighttypeDAO {
	private static final Log log = LogFactory.getLog(TbRighttypeDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String APPSYSID = "appsysid";
	
	public static final String FUNID = "funid";
	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#save(com.baosight.mode.TbRighttype)
	 */
	public void save(TbRighttype transientInstance) {
		log.debug("saving TbRighttype instance");
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#delete(com.baosight.mode.TbRighttype)
	 */
	public void delete(TbRighttype persistentInstance) {
		log.debug("deleting TbRighttype instance");
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findById(java.lang.String)
	 */
	public TbRighttype findById(java.lang.String id) {
		log.debug("getting TbRighttype instance with id: " + id);
		try {
			TbRighttype instance = (TbRighttype) getHibernateTemplate().get(
					"com.baosight.mode.TbRighttype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findByExample(com.baosight.mode.TbRighttype)
	 */
	public List findByExample(TbRighttype instance) {
		log.debug("finding TbRighttype instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbRighttype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbRighttype as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbRighttype instances");
		try {
			String queryString = "from TbRighttype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#merge(com.baosight.mode.TbRighttype)
	 */
	public TbRighttype merge(TbRighttype detachedInstance) {
		log.debug("merging TbRighttype instance");
		try {
			TbRighttype result = (TbRighttype) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#attachDirty(com.baosight.mode.TbRighttype)
	 */
	public void attachDirty(TbRighttype instance) {
		log.debug("attaching dirty TbRighttype instance");
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
	 * @see com.baosight.base.dao.impl.ITbRighttypeDAO#attachClean(com.baosight.mode.TbRighttype)
	 */
	public void attachClean(TbRighttype instance) {
		log.debug("attaching clean TbRighttype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
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

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public static ITbRighttypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbRighttypeDAO) ctx.getBean("tbRighttypeDAO");
	}

	public void update(TbRighttype item) {
		log.debug("update TbRighttype instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public List checkRighttypeCode(String id, String value, String funid) {
		log.debug("finding TbRighttype instance with property: code, value: " + value);
		
		String queryString ="";
		try {
			if("".equals(id))
			{
				queryString = "from TbRighttype as model where model.code= '"+value+"' and model.funid='"+funid+"'";

			}else
			{
				queryString = "from TbRighttype as model where model.code= '"+value+"' and model.funid='"+funid+"' and id != '"+id+"'";
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
}