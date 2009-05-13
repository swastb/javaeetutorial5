package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbAuthlvlDAO;
import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbUserlvl;

/**
 * Data access object (DAO) for domain model class TbAuthlvl.
 * 
 * @see com.baosight.mode.TbAuthlvl
 * @author MyEclipse Persistence Tools
 */

public class TbAuthlvlDAOImpl extends HibernateDaoSupport implements ITbAuthlvlDAO {
	private static final Log log = LogFactory.getLog(TbAuthlvlDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String ENAME = "ename";

	public static final String CODE = "code";

	public static final String REM = "rem";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#save(com.baosight.mode.TbAuthlvl)
	 */
	public void save(TbAuthlvl transientInstance) {
		log.debug("saving TbAuthlvl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#delete(com.baosight.mode.TbAuthlvl)
	 */
	public void delete(TbAuthlvl persistentInstance) {
		log.debug("deleting TbAuthlvl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findById(java.lang.String)
	 */
	public TbAuthlvl findById(java.lang.String id) {
		log.debug("getting TbAuthlvl instance with id: " + id);
		try {
			TbAuthlvl instance = (TbAuthlvl) getHibernateTemplate().get(
					"com.baosight.mode.TbAuthlvl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByExample(com.baosight.mode.TbAuthlvl)
	 */
	public List findByExample(TbAuthlvl instance) {
		log.debug("finding TbAuthlvl instance by example");
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

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbAuthlvl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbAuthlvl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByEname(java.lang.Object)
	 */
	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbAuthlvl instances");
		try {
			String queryString = "from TbAuthlvl";
			System.out.println(queryString);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#merge(com.baosight.mode.TbAuthlvl)
	 */
	public TbAuthlvl merge(TbAuthlvl detachedInstance) {
		log.debug("merging TbAuthlvl instance");
		try {
			TbAuthlvl result = (TbAuthlvl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#attachDirty(com.baosight.mode.TbAuthlvl)
	 */
	public void attachDirty(TbAuthlvl instance) {
		log.debug("attaching dirty TbAuthlvl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbAuthlvlDAO#attachClean(com.baosight.mode.TbAuthlvl)
	 */
	public void attachClean(TbAuthlvl instance) {
		log.debug("attaching clean TbAuthlvl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbAuthlvlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbAuthlvlDAO) ctx.getBean("TbAuthlvlDAO");
	}
	
	public void update(TbAuthlvl item) {
		log.debug("update TbAuthlvl instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public List checkAuthlvl(String id,String value,String flag) {
		log.debug("finding TbAuthlvl instance with property: value: " + value);

		String queryString ="";
		try {
			if("".equals(id))
			{
				if(flag.equals("ename"))
				{
					queryString = "from TbAuthlvl as model where model.ename= '"+value+"'";
				}
				else
				{
					queryString = "from TbAuthlvl as model where model.code= '"+value+"'";
				}
			}else
			{
				if(flag.equals("ename"))
				{
					queryString = "from TbAuthlvl as model where model.ename= '"+value+"' and id != '"+id+"'";
				}
				else
				{
					queryString = "from TbAuthlvl as model where model.code= '"+value+"' and id != '"+id+"'";
				}
			}
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property failed", re);
			throw re;
		}
	}
}