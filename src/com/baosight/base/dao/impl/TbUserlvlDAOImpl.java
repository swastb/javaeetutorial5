package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserlvlDAO;
import com.baosight.mode.TbUserlvl;

/**
 * Data access object (DAO) for domain model class TbUserlvl.
 * 
 * @see com.baosight.mode.TbUserlvl
 * @author MyEclipse Persistence Tools
 */

public class TbUserlvlDAOImpl extends HibernateDaoSupport implements
		ITbUserlvlDAO {
	private static final Log log = LogFactory.getLog(TbUserlvlDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String ENAME = "ename";

	public static final String CODE = "code";

	public static final String RM = "rm";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#save(com.baosight.mode.TbUserlvl)
	 */
	public void save(TbUserlvl transientInstance) {
		log.debug("saving TbUserlvl instance");
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#delete(com.baosight.mode.TbUserlvl)
	 */
	public void delete(TbUserlvl persistentInstance) {
		log.debug("deleting TbUserlvl instance");
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findById(java.lang.String)
	 */
	public TbUserlvl findById(java.lang.String id) {
		log.debug("getting TbUserlvl instance with id: " + id);
		try {
			TbUserlvl instance = (TbUserlvl) getHibernateTemplate().get(
					"com.baosight.mode.TbUserlvl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByExample(com.baosight.mode.TbUserlvl)
	 */
	public List findByExample(TbUserlvl instance) {
		log.debug("finding TbUserlvl instance by example");
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUserlvl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUserlvl as model where model."
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByEname(java.lang.Object)
	 */
	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findByRm(java.lang.Object)
	 */
	public List findByRm(Object rm) {
		return findByProperty(RM, rm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUserlvl instances");
		try {
			String queryString = "from TbUserlvl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.ITbUserlvlDAO#merge(com.baosight.mode.TbUserlvl)
	 */
	public TbUserlvl merge(TbUserlvl detachedInstance) {
		log.debug("merging TbUserlvl instance");
		try {
			TbUserlvl result = (TbUserlvl) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#attachDirty(com.baosight.mode.TbUserlvl)
	 */
	public void attachDirty(TbUserlvl instance) {
		log.debug("attaching dirty TbUserlvl instance");
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
	 * @see com.baosight.base.dao.ITbUserlvlDAO#attachClean(com.baosight.mode.TbUserlvl)
	 */
	public void attachClean(TbUserlvl instance) {
		log.debug("attaching clean TbUserlvl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbUserlvlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbUserlvlDAO) ctx.getBean("TbUserlvlDAO");
	}

	public void update(TbUserlvl item) {
		log.debug("update TbUserlvl instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	
	public List checkUserlvl(String id, String value,String flag) {
		log.debug("finding TbUserlvl instance with property: ename, value: " + value);
		
		String queryString ="";
		try {
			if("".equals(id))
			{
				if(flag.equals("ename"))
				{
					queryString = "from TbUserlvl as model where model.ename= '"+value+"'";
				}
				else
				{
					queryString = "from TbUserlvl as model where model.code= '"+value+"'";
				}
			}else
			{
				if(flag.equals("ename"))
				{
					queryString = "from TbUserlvl as model where model.ename= '"+value+"' and id != '"+id+"'";
				}
				else
				{
					queryString = "from TbUserlvl as model where model.code= '"+value+"' and id != '"+id+"'";
				}
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
}