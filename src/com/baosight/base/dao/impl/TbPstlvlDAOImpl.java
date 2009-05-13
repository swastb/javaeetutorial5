package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbPstlvlDAO;
import com.baosight.mode.TbPstlvl;

/**
 * Data access object (DAO) for domain model class TbPstlvl.
 * 
 * @see com.baosight.mode.TbPstlvl
 * @author MyEclipse Persistence Tools
 */

public class TbPstlvlDAOImpl extends HibernateDaoSupport implements
		ITbPstlvlDAO {
	private static final Log log = LogFactory.getLog(TbPstlvlDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String CODE = "code";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#save(com.baosight.mode.TbPstlvl)
	 */
	public void save(TbPstlvl transientInstance) {
		log.debug("saving TbPstlvl instance");
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#delete(com.baosight.mode.TbPstlvl)
	 */
	public void delete(TbPstlvl persistentInstance) {
		log.debug("deleting TbPstlvl instance");
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findById(java.lang.String)
	 */
	public TbPstlvl findById(java.lang.String id) {
		log.debug("getting TbPstlvl instance with id: " + id);
		try {
			TbPstlvl instance = (TbPstlvl) getHibernateTemplate().get(
					"com.baosight.mode.TbPstlvl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findByExample(com.baosight.mode.TbPstlvl)
	 */
	public List findByExample(TbPstlvl instance) {
		log.debug("finding TbPstlvl instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbPstlvl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbPstlvl as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbPstlvl instances");
		try {
			String queryString = "from TbPstlvl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#merge(com.baosight.mode.TbPstlvl)
	 */
	public TbPstlvl merge(TbPstlvl detachedInstance) {
		log.debug("merging TbPstlvl instance");
		try {
			TbPstlvl result = (TbPstlvl) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#attachDirty(com.baosight.mode.TbPstlvl)
	 */
	public void attachDirty(TbPstlvl instance) {
		log.debug("attaching dirty TbPstlvl instance");
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
	 * @see com.baosight.base.dao.impl.ITbPstlvlDAO#attachClean(com.baosight.mode.TbPstlvl)
	 */
	public void attachClean(TbPstlvl instance) {
		log.debug("attaching clean TbPstlvl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbPstlvlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbPstlvlDAO) ctx.getBean("tbPstlvlDAO");
	}

	public void update(TbPstlvl item) {
		log.debug("update TbPstlvl instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	//职务等级重复验证
	public List checkPstlvl(String id, String value,String flag) {
		log.debug("finding TbPstlvl instance with property: value: " + value);
		
		String queryString ="";
		try {
			if("".equals(id))
			{
				if(flag.equals("name"))
				{
					queryString = "from TbPstlvl as model where model.name= '"+value+"'";
				}
				else
				{
					queryString = "from TbPstlvl as model where model.code= '"+value+"'";
				}
			}else
			{
				if(flag.equals("name"))
				{
					queryString = "from TbPstlvl as model where model.name= '"+value+"' and id != '"+id+"'";
				}
				else
				{
					queryString = "from TbPstlvl as model where model.code= '"+value+"' and id != '"+id+"'";
				}
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}