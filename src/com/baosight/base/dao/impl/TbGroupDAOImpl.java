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

import com.baosight.base.dao.ITbGroupDAO;
import com.baosight.mode.TbGroup;

/**
 * Data access object (DAO) for domain model class TbGroup.
 * 
 * @see com.baosight.mode.TbGroup
 * @author MyEclipse Persistence Tools
 */

public class TbGroupDAOImpl extends HibernateDaoSupport implements ITbGroupDAO {
	private static final Log log = LogFactory.getLog(TbGroupDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String DEPT_CODE = "deptCode";

	public static final String LVL = "lvl";

	public static final String REM = "rem";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#save(com.baosight.mode.TbGroup)
	 */
	public void save(TbGroup transientInstance) {
		log.debug("saving TbGroup instance");
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#delete(com.baosight.mode.TbGroup)
	 */
	public void delete(TbGroup persistentInstance) {
		log.debug("deleting TbGroup instance");
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findById(java.lang.String)
	 */
	public TbGroup findById(java.lang.String id) {
		log.debug("getting TbGroup instance with id: " + id);
		try {
			TbGroup instance = (TbGroup) getHibernateTemplate().get(
					"com.baosight.mode.TbGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByExample(com.baosight.mode.TbGroup)
	 */
	public List findByExample(TbGroup instance) {
		log.debug("finding TbGroup instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbGroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbGroup as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByDeptCode(java.lang.Object)
	 */
	public List findByDeptCode(Object deptCode) {
		return findByProperty(DEPT_CODE, deptCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByLvl(java.lang.Object)
	 */
	public List findByLvl(Object lvl) {
		return findByProperty(LVL, lvl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbGroup instances");
		try {
			String queryString = "from TbGroup";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#merge(com.baosight.mode.TbGroup)
	 */
	public TbGroup merge(TbGroup detachedInstance) {
		log.debug("merging TbGroup instance");
		try {
			TbGroup result = (TbGroup) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#attachDirty(com.baosight.mode.TbGroup)
	 */
	public void attachDirty(TbGroup instance) {
		log.debug("attaching dirty TbGroup instance");
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
	 * @see com.baosight.base.dao.impl.ITbGroupDAO#attachClean(com.baosight.mode.TbGroup)
	 */
	public void attachClean(TbGroup instance) {
		log.debug("attaching clean TbGroup instance");
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

	public static ITbGroupDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbGroupDAO) ctx.getBean("tbGroupDAO");
	}
}