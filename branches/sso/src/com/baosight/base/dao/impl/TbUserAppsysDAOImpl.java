package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserAppsysDAO;
import com.baosight.mode.TbUserAppsys;

/**
 * Data access object (DAO) for domain model class TbUserAppsys.
 * 
 * @see com.baosight.mode.TbUserAppsys
 * @author MyEclipse Persistence Tools
 */

public class TbUserAppsysDAOImpl extends HibernateDaoSupport implements ITbUserAppsysDAO {
	private static final Log log = LogFactory.getLog(TbUserAppsysDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String APPID = "appid";

	public static final String FUNID = "funid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#save(com.baosight.mode.TbUserAppsys)
	 */
	public void save(TbUserAppsys transientInstance) {
		log.debug("saving TbUserAppsys instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#delete(com.baosight.mode.TbUserAppsys)
	 */
	public void delete(TbUserAppsys persistentInstance) {
		log.debug("deleting TbUserAppsys instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findById(java.lang.String)
	 */
	public TbUserAppsys findById(java.lang.String id) {
		log.debug("getting TbUserAppsys instance with id: " + id);
		try {
			TbUserAppsys instance = (TbUserAppsys) getHibernateTemplate().get(
					"com.baosight.mode.TbUserAppsys", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findByExample(com.baosight.mode.TbUserAppsys)
	 */
	public List findByExample(TbUserAppsys instance) {
		log.debug("finding TbUserAppsys instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserAppsys instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbUserAppsys as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findByAppid(java.lang.Object)
	 */
	public List findByAppid(Object appid) {
		return findByProperty(APPID, appid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findByFunid(java.lang.Object)
	 */
	public List findByFunid(Object funid) {
		return findByProperty(FUNID, funid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserAppsys instances");
		try {
			String queryString = "from TbUserAppsys";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#merge(com.baosight.mode.TbUserAppsys)
	 */
	public TbUserAppsys merge(TbUserAppsys detachedInstance) {
		log.debug("merging TbUserAppsys instance");
		try {
			TbUserAppsys result = (TbUserAppsys) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#attachDirty(com.baosight.mode.TbUserAppsys)
	 */
	public void attachDirty(TbUserAppsys instance) {
		log.debug("attaching dirty TbUserAppsys instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserAppsys#attachClean(com.baosight.mode.TbUserAppsys)
	 */
	public void attachClean(TbUserAppsys instance) {
		log.debug("attaching clean TbUserAppsys instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserAppsysDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbUserAppsysDAO) ctx.getBean("tbUserAppsysDAO");
	}
}