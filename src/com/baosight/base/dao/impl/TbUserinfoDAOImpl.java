package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserinfoDAO;
import com.baosight.mode.TbUserinfo;

/**
 * Data access object (DAO) for domain model class TbUserinfo.
 * 
 * @see com.baosight.mode.TbUserinfo
 * @author MyEclipse Persistence Tools
 */

public class TbUserinfoDAOImpl extends HibernateDaoSupport implements
		ITbUserinfoDAO {
	private static final Log log = LogFactory.getLog(TbUserinfoDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String BIRTHDAY = "birthday";

	public static final String EMAIL = "email";

	public static final String LINKADDRESS = "linkaddress";

	public static final String HANDSET = "handset";

	public static final String PHONE = "phone";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#save(com.baosight.mode.TbUserinfo)
	 */
	public void save(TbUserinfo transientInstance) {
		log.debug("saving TbUserinfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#delete(com.baosight.mode.TbUserinfo)
	 */
	public void delete(TbUserinfo persistentInstance) {
		log.debug("deleting TbUserinfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findById(java.lang.String)
	 */
	public TbUserinfo findById(java.lang.String id) {
		log.debug("getting TbUserinfo instance with id: " + id);
		try {
			TbUserinfo instance = (TbUserinfo) getHibernateTemplate().get(
					"com.baosight.mode.TbUserinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByExample(com.baosight.mode.TbUserinfo)
	 */
	public List findByExample(TbUserinfo instance) {
		log.debug("finding TbUserinfo instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserinfo as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByBirthday(java.lang.Object)
	 */
	public List findByBirthday(Object birthday) {
		return findByProperty(BIRTHDAY, birthday);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByEmail(java.lang.Object)
	 */
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByLinkaddress(java.lang.Object)
	 */
	public List findByLinkaddress(Object linkaddress) {
		return findByProperty(LINKADDRESS, linkaddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByHandset(java.lang.Object)
	 */
	public List findByHandset(Object handset) {
		return findByProperty(HANDSET, handset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findByPhone(java.lang.Object)
	 */
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserinfo instances");
		try {
			String queryString = "from TbUserinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#merge(com.baosight.mode.TbUserinfo)
	 */
	public TbUserinfo merge(TbUserinfo detachedInstance) {
		log.debug("merging TbUserinfo instance");
		try {
			TbUserinfo result = (TbUserinfo) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#attachDirty(com.baosight.mode.TbUserinfo)
	 */
	public void attachDirty(TbUserinfo instance) {
		log.debug("attaching dirty TbUserinfo instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserinfoDAO#attachClean(com.baosight.mode.TbUserinfo)
	 */
	public void attachClean(TbUserinfo instance) {
		log.debug("attaching clean TbUserinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserinfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbUserinfoDAO) ctx.getBean("tbUserinfoDAO");
	}

	public void update(TbUserinfo item) {
		log.debug("update TbUserinfo instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public List findByNativeSql(String sql, Class entity) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql).addEntity(entity);
		return query.list();
	}
}