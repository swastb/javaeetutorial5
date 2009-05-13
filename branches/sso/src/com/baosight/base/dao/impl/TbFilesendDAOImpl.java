package com.baosight.base.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbFilesendDAO;
import com.baosight.mode.TbFilesend;

/**
 * Data access object (DAO) for domain model class TbFilesend.
 * 
 * @see com.baosight.mode.TbFilesend
 * @author MyEclipse Persistence Tools
 */

public class TbFilesendDAOImpl extends HibernateDaoSupport implements ITbFilesendDAO {
	private static final Log log = LogFactory.getLog(TbFilesendDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbFilesend transientInstance) {
		log.debug("saving TbFilesend instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbFilesend transientInstance) {
		log.debug("updating TbFilesend instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void delete(TbFilesend persistentInstance) {
		log.debug("deleting TbFilesend instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbFilesend findById(java.lang.String id) {
		log.debug("getting TbFilesend instance with id: " + id);
		try {
			TbFilesend instance = (TbFilesend) getHibernateTemplate().get(
					"com.baosight.mode.TbFilesend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbFilesend instance) {
		log.debug("finding TbFilesend instance by example");
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
		log.debug("finding TbFilesend instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbFilesend as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbFilesend instances");
		try {
			String queryString = "from TbFilesend";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbFilesend merge(TbFilesend detachedInstance) {
		log.debug("merging TbFilesend instance");
		try {
			TbFilesend result = (TbFilesend) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbFilesend instance) {
		log.debug("attaching dirty TbFilesend instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbFilesend instance) {
		log.debug("attaching clean TbFilesend instance");
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
	public void update(String sql) {
	      Configuration   cfg   =   new   Configuration();   
	      Session   session   =   null; 
	      Transaction   tran   =   null; 
	      SessionFactory sessionFactory = null;
	      cfg.configure("/hibernate.cfg.xml");   
          sessionFactory   =   cfg.buildSessionFactory();   
	      try   { 
	          session   =   sessionFactory.openSession(); 
	          tran   =   session.beginTransaction(); 
	          Connection conn = session.connection(); 
	          PreparedStatement stmt = conn.prepareStatement(sql); 
	          stmt.executeUpdate(); 
	          stmt.execute(); 
	          tran.commit(); 
	      }   catch   (Exception   e)   { 
	          e.printStackTrace(); 
	          tran.rollback(); 
	      }finally{ 
	          if(session!=null) 
	          session.close(); 
	      } 

	      
	}	
	public static ITbFilesendDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbFilesendDAO) ctx.getBean("tbFilesendDAO");
	}
}