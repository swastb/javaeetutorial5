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

import com.baosight.base.dao.ITbUserdeptDAO;
import com.baosight.mode.TbUserdept;

/**
 * Data access object (DAO) for domain model class TbUserdept.
 * 
 * @see com.baosight.mode.TbUserdept
 * @author MyEclipse Persistence Tools
 */

public class TbUserdeptDAOImpl extends HibernateDaoSupport implements ITbUserdeptDAO {
	
	private String queryCacheRegion = null;
	
	
	private static final Log log = LogFactory.getLog(TbUserdeptDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#save(com.baosight.mode.TbUserdept)
	 */
	public void save(TbUserdept transientInstance) {
		log.debug("saving TbUserdept instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#delete(com.baosight.mode.TbUserdept)
	 */
	public void delete(TbUserdept persistentInstance) {
		log.debug("deleting TbUserdept instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findById(java.lang.String)
	 */
	public TbUserdept findById(java.lang.String id) {
		log.debug("getting TbUserdept instance with id: " + id);
		try {
			TbUserdept instance = (TbUserdept) getHibernateTemplate().get(
					"com.baosight.mode.TbUserdept", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByExample(com.baosight.mode.TbUserdept)
	 */
	public List findByExample(TbUserdept instance) {
		log.debug("finding TbUserdept instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserdept instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserdept as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserdept instances");
		try {
			String queryString = "from TbUserdept";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#merge(com.baosight.mode.TbUserdept)
	 */
	public TbUserdept merge(TbUserdept detachedInstance) {
		log.debug("merging TbUserdept instance");
		try {
			TbUserdept result = (TbUserdept) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#attachDirty(com.baosight.mode.TbUserdept)
	 */
	public void attachDirty(TbUserdept instance) {
		log.debug("attaching dirty TbUserdept instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserdeptDAO#attachClean(com.baosight.mode.TbUserdept)
	 */
	public void attachClean(TbUserdept instance) {
		log.debug("attaching clean TbUserdept instance");
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
	public static ITbUserdeptDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbUserdeptDAO) ctx.getBean("TbUserdeptDAO");
	}
}