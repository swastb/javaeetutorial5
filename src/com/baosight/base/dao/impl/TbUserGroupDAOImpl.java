package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserGroupDAO;
import com.baosight.mode.TbUserGroup;

/**
 * Data access object (DAO) for domain model class TbUserGroup.
 * 
 * @see com.baosight.mode.TbUserGroup
 * @author MyEclipse Persistence Tools
 */

public class TbUserGroupDAOImpl extends HibernateDaoSupport implements ITbUserGroupDAO {
	private static final Log log = LogFactory.getLog(TbUserGroupDAOImpl.class);

	// property constants
	public static final String GROUP_CODE = "groupCode";

	public static final String USER_ID = "userId";

	public static final String GROUPID = "groupid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#save(com.baosight.mode.TbUserGroup)
	 */
	public void save(TbUserGroup transientInstance) {
		log.debug("saving TbUserGroup instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#delete(com.baosight.mode.TbUserGroup)
	 */
	public void delete(TbUserGroup persistentInstance) {
		log.debug("deleting TbUserGroup instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findById(java.lang.String)
	 */
	public TbUserGroup findById(java.lang.String id) {
		log.debug("getting TbUserGroup instance with id: " + id);
		try {
			TbUserGroup instance = (TbUserGroup) getHibernateTemplate().get(
					"com.baosight.mode.TbUserGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findByExample(com.baosight.mode.TbUserGroup)
	 */
	public List findByExample(TbUserGroup instance) {
		log.debug("finding TbUserGroup instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserGroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserGroup as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findByGroupCode(java.lang.Object)
	 */
	public List findByGroupCode(Object groupCode) {
		return findByProperty(GROUP_CODE, groupCode);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findByGroupid(java.lang.Object)
	 */
	public List findByGroupid(Object groupid) {
		return findByProperty(GROUPID, groupid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserGroup instances");
		try {
			String queryString = "from TbUserGroup";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#merge(com.baosight.mode.TbUserGroup)
	 */
	public TbUserGroup merge(TbUserGroup detachedInstance) {
		log.debug("merging TbUserGroup instance");
		try {
			TbUserGroup result = (TbUserGroup) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#attachDirty(com.baosight.mode.TbUserGroup)
	 */
	public void attachDirty(TbUserGroup instance) {
		log.debug("attaching dirty TbUserGroup instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserGroupDAO#attachClean(com.baosight.mode.TbUserGroup)
	 */
	public void attachClean(TbUserGroup instance) {
		log.debug("attaching clean TbUserGroup instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserGroupDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbUserGroupDAO) ctx.getBean("tbUserGroupDAO");
	}
}