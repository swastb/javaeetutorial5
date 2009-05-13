package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserOpeationDAO;
import com.baosight.mode.TbUserOpeation;

/**
 * Data access object (DAO) for domain model class TbUserOpeation.
 * 
 * @see com.baosight.mode.TbUserOpeation
 * @author MyEclipse Persistence Tools 
 */

public class TbUserOpeationDAOImpl extends HibernateDaoSupport implements ITbUserOpeationDAO  {
	private static final Log log = LogFactory.getLog(TbUserOpeationDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbUserOpeation transientInstance) {
		log.debug("saving TbUserOpeation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbUserOpeation transientInstance) {
		log.debug("updating TbUserOpeation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(TbUserOpeation persistentInstance) {
		log.debug("deleting TbUserOpeation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbUserOpeation findById(java.lang.String id) {
		log.debug("getting TbUserOpeation instance with id: " + id);
		try {
			TbUserOpeation instance = (TbUserOpeation) getHibernateTemplate()
					.get("com.baosight.mode.TbUserOpeation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbUserOpeation instance) {
		log.debug("finding TbUserOpeation instance by example");
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
		log.debug("finding TbUserOpeation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbUserOpeation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParam(String userid, String operation) {
		log.debug("finding TbUserOpeation instance by example");
		try {
			String queryString = "from TbUserOpeation  where opeation='"+operation+"'";
			if(!userid.trim().equals("")){
				queryString+= " and userid='"+userid+"'";
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		log.debug("finding all TbUserOpeation instances");
		try {
			String queryString = "from TbUserOpeation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbUserOpeation merge(TbUserOpeation detachedInstance) {
		log.debug("merging TbUserOpeation instance");
		try {
			TbUserOpeation result = (TbUserOpeation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbUserOpeation instance) {
		log.debug("attaching dirty TbUserOpeation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbUserOpeation instance) {
		log.debug("attaching clean TbUserOpeation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
}