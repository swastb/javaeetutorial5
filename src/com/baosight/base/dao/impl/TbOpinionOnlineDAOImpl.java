package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbOpinionOnlineDAO;
import com.baosight.mode.TbOpinionOnline;

/**
 * Data access object (DAO) for domain model class TbOpinionOnline.
 * 
 * @see com.baosight.mode.TbOpinionOnline
 * @author MyEclipse Persistence Tools
 */

public class TbOpinionOnlineDAOImpl extends HibernateDaoSupport implements ITbOpinionOnlineDAO  {
	private static final Log log = LogFactory.getLog(TbOpinionOnlineDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbOpinionOnline transientInstance) {
		log.debug("saving TbOpinionOnline instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbOpinionOnline transientInstance) {
		log.debug("saving TbOpinionOnline instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbOpinionOnline persistentInstance) {
		log.debug("deleting TbOpinionOnline instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbOpinionOnline findById(java.lang.String id) {
		log.debug("getting TbOpinionOnline instance with id: " + id);
		try {
			TbOpinionOnline instance = (TbOpinionOnline) getHibernateTemplate()
					.get("com.baosight.mode.TbOpinionOnline", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbOpinionOnline instance) {
		log.debug("finding TbOpinionOnline instance by example");
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
		log.debug("finding TbOpinionOnline instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbOpinionOnline as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbOpinionOnline instances");
		try {
			String queryString = "from TbOpinionOnline";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbOpinionOnline merge(TbOpinionOnline detachedInstance) {
		log.debug("merging TbOpinionOnline instance");
		try {
			TbOpinionOnline result = (TbOpinionOnline) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbOpinionOnline instance) {
		log.debug("attaching dirty TbOpinionOnline instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbOpinionOnline instance) {
		log.debug("attaching clean TbOpinionOnline instance");
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
	public static TbOpinionOnlineDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbOpinionOnlineDAOImpl) ctx.getBean("TbOpinionOnlineDAO");
	}
}