package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbConsultationOnlineDAO;
import com.baosight.mode.TbConsultationOnline;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbConsultationOnline entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.baosight.mode.TbConsultationOnline
 * @author MyEclipse Persistence Tools
 */

public class TbConsultationOnlineDAOImpl extends HibernateDaoSupport implements ITbConsultationOnlineDAO{
	private static final Log log = LogFactory
			.getLog(TbConsultationOnlineDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbConsultationOnline transientInstance) {
		log.debug("saving TbConsultationOnline instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbConsultationOnline transientInstance) {
		log.debug("saving TbConsultationOnline instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(TbConsultationOnline persistentInstance) {
		log.debug("deleting TbConsultationOnline instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbConsultationOnline findById(java.lang.String id) {
		log.debug("getting TbConsultationOnline instance with id: " + id);
		try {
			TbConsultationOnline instance = (TbConsultationOnline) getHibernateTemplate()
					.get("com.baosight.mode.TbConsultationOnline", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbConsultationOnline instance) {
		log.debug("finding TbConsultationOnline instance by example");
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
		log.debug("finding TbConsultationOnline instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbConsultationOnline as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbConsultationOnline instances");
		try {
			String queryString = "from TbConsultationOnline";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbConsultationOnline merge(TbConsultationOnline detachedInstance) {
		log.debug("merging TbConsultationOnline instance");
		try {
			TbConsultationOnline result = (TbConsultationOnline) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbConsultationOnline instance) {
		log.debug("attaching dirty TbConsultationOnline instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbConsultationOnline instance) {
		log.debug("attaching clean TbConsultationOnline instance");
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
	public static TbConsultationOnlineDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbConsultationOnlineDAOImpl) ctx.getBean("TbConsultationOnlineDAO");
	}
}