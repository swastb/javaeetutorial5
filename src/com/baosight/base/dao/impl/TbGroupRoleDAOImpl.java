package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbGroupRoleDAO;
import com.baosight.mode.TbGroupRole;

/**
 * Data access object (DAO) for domain model class TbGroupRole.
 * 
 * @see com.baosight.mode.TbGroupRole
 * @author MyEclipse Persistence Tools
 */

public class TbGroupRoleDAOImpl extends HibernateDaoSupport implements ITbGroupRoleDAO {
	private static final Log log = LogFactory.getLog(TbGroupRoleDAOImpl.class);

	// property constants
	public static final String GROUP_CODE = "groupCode";

	public static final String GROUPID = "groupid";

	public static final String ROLEID = "roleid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#save(com.baosight.mode.TbGroupRole)
	 */
	public void save(TbGroupRole transientInstance) {
		log.debug("saving TbGroupRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#delete(com.baosight.mode.TbGroupRole)
	 */
	public void delete(TbGroupRole persistentInstance) {
		log.debug("deleting TbGroupRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findById(java.lang.String)
	 */
	public TbGroupRole findById(java.lang.String id) {
		log.debug("getting TbGroupRole instance with id: " + id);
		try {
			TbGroupRole instance = (TbGroupRole) getHibernateTemplate().get(
					"com.baosight.mode.TbGroupRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findByExample(com.baosight.mode.TbGroupRole)
	 */
	public List findByExample(TbGroupRole instance) {
		log.debug("finding TbGroupRole instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbGroupRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbGroupRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findByGroupCode(java.lang.Object)
	 */
	public List findByGroupCode(Object groupCode) {
		return findByProperty(GROUP_CODE, groupCode);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findByGroupid(java.lang.Object)
	 */
	public List findByGroupid(Object groupid) {
		return findByProperty(GROUPID, groupid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findByRoleid(java.lang.Object)
	 */
	public List findByRoleid(Object roleid) {
		return findByProperty(ROLEID, roleid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbGroupRole instances");
		try {
			String queryString = "from TbGroupRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#merge(com.baosight.mode.TbGroupRole)
	 */
	public TbGroupRole merge(TbGroupRole detachedInstance) {
		log.debug("merging TbGroupRole instance");
		try {
			TbGroupRole result = (TbGroupRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#attachDirty(com.baosight.mode.TbGroupRole)
	 */
	public void attachDirty(TbGroupRole instance) {
		log.debug("attaching dirty TbGroupRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbGroupRoleDAO#attachClean(com.baosight.mode.TbGroupRole)
	 */
	public void attachClean(TbGroupRole instance) {
		log.debug("attaching clean TbGroupRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbGroupRoleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbGroupRoleDAO) ctx.getBean("tbGroupRoleDAO");
	}
}