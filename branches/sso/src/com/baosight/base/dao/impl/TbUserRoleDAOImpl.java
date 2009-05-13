package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserRole;

/**
 * Data access object (DAO) for domain model class TbUserRole.
 * 
 * @see com.baosight.mode.TbUserRole
 * @author MyEclipse Persistence Tools
 */

public class TbUserRoleDAOImpl extends HibernateDaoSupport implements ITbUserRoleDAO {
	private static final Log log = LogFactory.getLog(TbUserRoleDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String ROLEID = "roleid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#save(com.baosight.mode.TbUserRole)
	 */
	public void save(TbUserRole transientInstance) {
		log.debug("saving TbUserRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#delete(com.baosight.mode.TbUserRole)
	 */
	public void delete(TbUserRole persistentInstance) {
		log.debug("deleting TbUserRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findById(java.lang.String)
	 */
	public TbUserRole findById(java.lang.String id) {
		log.debug("getting TbUserRole instance with id: " + id);
		try {
			TbUserRole instance = (TbUserRole) getHibernateTemplate().get(
					"com.baosight.mode.TbUserRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findByExample(com.baosight.mode.TbUserRole)
	 */
	public List findByExample(TbUserRole instance) {
		log.debug("finding TbUserRole instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findByRoleid(java.lang.Object)
	 */
	public List findByRoleid(Object roleid) {
		return findByProperty(ROLEID, roleid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserRole instances");
		try {
			String queryString = "from TbUserRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#merge(com.baosight.mode.TbUserRole)
	 */
	public TbUserRole merge(TbUserRole detachedInstance) {
		log.debug("merging TbUserRole instance");
		try {
			TbUserRole result = (TbUserRole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#attachDirty(com.baosight.mode.TbUserRole)
	 */
	public void attachDirty(TbUserRole instance) {
		log.debug("attaching dirty TbUserRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbUserRoleDAO#attachClean(com.baosight.mode.TbUserRole)
	 */
	public void attachClean(TbUserRole instance) {
		log.debug("attaching clean TbUserRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbUserRoleDAO) ctx.getBean("tbUserRoleDAO");
	}
	/**
	 * 取用户所属的角色列表
	 * @param user
	 * @return
	 */
	public List getUserRoleList(TbUser user){
		log.debug("finding all roles of user instance with user: ");
		try {
			String queryString = "from TbRole t1 where t1.id in (select distinct t.roleid from TbUserRole t where t.userid=?)";
			return getHibernateTemplate().find(queryString, user.getId());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}