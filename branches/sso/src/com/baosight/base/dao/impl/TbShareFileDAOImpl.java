package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbShareFileDAO;
import com.baosight.mode.TbShareFile;

/**
 * Data access object (DAO) for domain model class TbShareFile.
 * 
 * @see com.baosight.mode.TbShareFile
 * @author MyEclipse Persistence Tools
 */

public class TbShareFileDAOImpl extends HibernateDaoSupport implements ITbShareFileDAO{
	private static final Log log = LogFactory.getLog(TbShareFileDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbShareFile transientInstance) {
		log.debug("saving TbShareFile instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(TbShareFile transientInstance) {
		log.debug("saving TbShareFile instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbShareFile persistentInstance) {
		log.debug("deleting TbShareFile instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbShareFile findById(java.lang.String id) {
		log.debug("getting TbShareFile instance with id: " + id);
		try {
			TbShareFile instance = (TbShareFile) getHibernateTemplate().get(
					"com.baosight.mode.TbShareFile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbShareFile instance) {
		log.debug("finding TbShareFile instance by example");
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
		log.debug("finding TbShareFile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbShareFile as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbShareFile instances");
		try {
			String queryString = "from TbShareFile";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbShareFile merge(TbShareFile detachedInstance) {
		log.debug("merging TbShareFile instance");
		try {
			TbShareFile result = (TbShareFile) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbShareFile instance) {
		log.debug("attaching dirty TbShareFile instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbShareFile instance) {
		log.debug("attaching clean TbShareFile instance");
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
	public static TbShareFileDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbShareFileDAOImpl) ctx.getBean("TbShareFileDAO");
	}
}