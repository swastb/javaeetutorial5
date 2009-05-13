package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbSmsUserDAO;
import com.baosight.mode.TbSmsUser;

/**
 * Data access object (DAO) for domain model class TbSmsUser.
 * 
 * @see com.baosight.mode.TbSmsUser
 * @author MyEclipse Persistence Tools
 */

public class TbSmsUserDAOImpl extends HibernateDaoSupport implements ITbSmsUserDAO{
	private static final Log log = LogFactory.getLog(TbSmsUserDAOImpl.class);

	// property constants
	public static final String USERNAME = "username";

	public static final String USERPASSWD = "userpasswd";

	public static final String DEPARTID = "departid";

	public static final String USERTYPE = "usertype";

	public static final String REMARK = "remark";

	public static final String BM_TYPE = "bmType";

	public static final String REALNAME = "realname";

	public static final String USERSORT = "usersort";

	protected void initDao() {
		// do nothing
	}

	public void save(TbSmsUser transientInstance) {
		log.debug("saving TbSmsUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbSmsUser persistentInstance) {
		log.debug("deleting TbSmsUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbSmsUser findById(java.lang.String id) {
		log.debug("getting TbSmsUser instance with id: " + id);
		try {
			TbSmsUser instance = (TbSmsUser) getHibernateTemplate().get(
					"com.baosight.mode.TbSmsUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbSmsUser instance) {
		log.debug("finding TbSmsUser instance by example");
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
		log.debug("finding TbSmsUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbSmsUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByUserpasswd(Object userpasswd) {
		return findByProperty(USERPASSWD, userpasswd);
	}

	public List findByDepartid(Object departid) {
		return findByProperty(DEPARTID, departid);
	}

	public List findByUsertype(Object usertype) {
		return findByProperty(USERTYPE, usertype);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByBmType(Object bmType) {
		return findByProperty(BM_TYPE, bmType);
	}

	public List findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List findByUsersort(Object usersort) {
		return findByProperty(USERSORT, usersort);
	}

	public List findAll() {
		log.debug("finding all TbSmsUser instances");
		try {
			String queryString = "from TbSmsUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbSmsUser merge(TbSmsUser detachedInstance) {
		log.debug("merging TbSmsUser instance");
		try {
			TbSmsUser result = (TbSmsUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbSmsUser instance) {
		log.debug("attaching dirty TbSmsUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbSmsUser instance) {
		log.debug("attaching clean TbSmsUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbSmsUserDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbSmsUserDAOImpl) ctx.getBean("TbSmsUserDAO");
	}
	
	public List findAllUserName() {
		log.debug("finding all TbSmsUser instances");
		try {
			String queryString = "select su.id,su.realname from TbSmsUser su";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findByUserName(String departId) {
		log.debug("finding all TbSmsUser instances");
		try {
			String queryString = "select su.id,su.realname from TbSmsUser su where su.departid='"+departId+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}