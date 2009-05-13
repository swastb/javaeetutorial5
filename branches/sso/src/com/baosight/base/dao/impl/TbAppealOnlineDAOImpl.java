package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbAppealOnlineDAO;
import com.baosight.mode.TbAppealOnline;

/**
 * Data access object (DAO) for domain model class TbAppealOnline.
 * 
 * @see com.baosight.mode.TbAppealOnline
 * @author MyEclipse Persistence Tools
 */

public class TbAppealOnlineDAOImpl extends HibernateDaoSupport implements ITbAppealOnlineDAO {
	private static final Log log = LogFactory.getLog(TbAppealOnlineDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbAppealOnline transientInstance) {
		log.debug("saving TbAppealOnline instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbAppealOnline persistentInstance) {
		log.debug("deleting TbAppealOnline instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	
	public void update(TbAppealOnline persistentInstance) {
		log.debug("update TbAppealOnline instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public TbAppealOnline findById(java.lang.String id) {
		log.debug("getting TbAppealOnline instance with id: " + id);
		try {
			TbAppealOnline instance = (TbAppealOnline) getHibernateTemplate()
					.get("com.baosight.mode.TbAppealOnline", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbAppealOnline instance) {
		log.debug("finding TbAppealOnline instance by example");
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
		log.debug("finding TbAppealOnline instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbAppealOnline as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbAppealOnline instances");
		try {
			String queryString = "from TbAppealOnline";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbAppealOnline merge(TbAppealOnline detachedInstance) {
		log.debug("merging TbAppealOnline instance");
		try {
			TbAppealOnline result = (TbAppealOnline) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbAppealOnline instance) {
		log.debug("attaching dirty TbAppealOnline instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbAppealOnline instance) {
		log.debug("attaching clean TbAppealOnline instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	public static TbAppealOnlineDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbAppealOnlineDAOImpl) ctx.getBean("TbAppealOnlineDAO");
	}
	
}