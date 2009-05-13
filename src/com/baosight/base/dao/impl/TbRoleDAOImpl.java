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

import com.baosight.base.dao.ITbRoleDAO;
import com.baosight.mode.TbRole;

/**
 * Data access object (DAO) for domain model class TbRole.
 * 
 * @see com.baosight.mode.TbRole
 * @author MyEclipse Persistence Tools
 */

public class TbRoleDAOImpl extends HibernateDaoSupport implements ITbRoleDAO {
	private static final Log log = LogFactory.getLog(TbRoleDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String NAME = "name";

	public static final String REM = "rem";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#save(com.baosight.mode.TbRole)
	 */
	public void save(TbRole transientInstance) {
		log.debug("saving TbRole instance");
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#delete(com.baosight.mode.TbRole)
	 */
	public void delete(TbRole persistentInstance) {
		log.debug("deleting TbRole instance");
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findById(java.lang.String)
	 */
	public TbRole findById(java.lang.String id) {
		log.debug("getting TbRole instance with id: " + id);
		try {
			TbRole instance = (TbRole) getHibernateTemplate().get(
					"com.baosight.mode.TbRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findByExample(com.baosight.mode.TbRole)
	 */
	public List findByExample(TbRole instance) {
		log.debug("finding TbRole instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbRole as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbRole instances");
		try {
			String queryString = "from TbRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#merge(com.baosight.mode.TbRole)
	 */
	public TbRole merge(TbRole detachedInstance) {
		log.debug("merging TbRole instance");
		try {
			TbRole result = (TbRole) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#attachDirty(com.baosight.mode.TbRole)
	 */
	public void attachDirty(TbRole instance) {
		log.debug("attaching dirty TbRole instance");
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
	 * @see com.baosight.base.dao.impl.ITbRoleDAO#attachClean(com.baosight.mode.TbRole)
	 */
	public void attachClean(TbRole instance) {
		log.debug("attaching clean TbRole instance");
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

	public static ITbRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbRoleDAO) ctx.getBean("tbRoleDAO");
	}

	public void update(TbRole item) {
		log.debug("update TbRole instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	//角色重复验证
	public List checkName(Object id, Object value,String field) {
		log.debug("finding TbRole instance with property: name, value: " + value);
		System.out.println("------id--------"+id);
		System.out.println("------value--------"+value);
		String queryString ="";
		try {
			if("".equals(id))
			{
				if(field.equals("name"))
				{
					queryString = "from TbRole as model where model.name= '"+value+"'";
				}
				else
				{
					queryString = "from TbRole as model where model.code= '"+value+"'";
				}
			}else
			{
				if(field.equals("name"))
				{
					queryString = "from TbRole as model where model.name= '"+value+"' and id != '"+id+"'";
				}
				else
				{
					queryString = "from TbRole as model where model.code= '"+value+"' and id != '"+id+"'";
				}
			}
			List list =getHibernateTemplate().find(queryString);
			System.out.println("---------list-------"+list.size());
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}