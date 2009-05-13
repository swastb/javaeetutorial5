package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDeptlvlDAO;
import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbDeptlvl;

/**
 * Data access object (DAO) for domain model class TbDeptlvl.
 * 
 * @see com.baosight.mode.TbDeptlvl
 * @author MyEclipse Persistence Tools
 */

public class TbDeptlvlDAOImpl extends HibernateDaoSupport implements ITbDeptlvlDAO {
	private static final Log log = LogFactory.getLog(TbDeptlvlDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String ENAME = "ename";

	public static final String CODE = "code";

	public static final String REM = "rem";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#save(com.baosight.mode.TbDeptlvl)
	 */
	public void save(TbDeptlvl transientInstance) {
		log.debug("saving TbDeptlvl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#delete(com.baosight.mode.TbDeptlvl)
	 */
	public void delete(TbDeptlvl persistentInstance) {
		log.debug("deleting TbDeptlvl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findById(java.lang.String)
	 */
	public TbDeptlvl findById(java.lang.String id) {
		log.debug("getting TbDeptlvl instance with id: " + id);
		try {
			TbDeptlvl instance = (TbDeptlvl) getHibernateTemplate().get(
					"com.baosight.mode.TbDeptlvl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByExample(com.baosight.mode.TbDeptlvl)
	 */
	public List findByExample(TbDeptlvl instance) {
		log.debug("finding TbDeptlvl instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDeptlvl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDeptlvl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByEname(java.lang.Object)
	 */
	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDeptlvl instances");
		try {
			String queryString = "from TbDeptlvl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#merge(com.baosight.mode.TbDeptlvl)
	 */
	public TbDeptlvl merge(TbDeptlvl detachedInstance) {
		log.debug("merging TbDeptlvl instance");
		try {
			TbDeptlvl result = (TbDeptlvl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#attachDirty(com.baosight.mode.TbDeptlvl)
	 */
	public void attachDirty(TbDeptlvl instance) {
		log.debug("attaching dirty TbDeptlvl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDeptlvlDAO#attachClean(com.baosight.mode.TbDeptlvl)
	 */
	public void attachClean(TbDeptlvl instance) {
		log.debug("attaching clean TbDeptlvl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDeptlvlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbDeptlvlDAO) ctx.getBean("TbDeptlvlDAO");
	}
	
	public void update(TbDeptlvl item) {
		log.debug("update TbDeptlvl instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public List checkDeptlvl(String id, String value, String flag) {
			log.debug("finding TbDeptlvl instance with property: value: " + value);
			
			String queryString ="";
			try {
				if("".equals(id))
				{
					if(flag.equals("ename"))
					{
						queryString = "from TbDeptlvl as model where model.ename= '"+value+"'";
					}
					else
					{
						queryString = "from TbDeptlvl as model where model.code= '"+value+"'";
					}
				}else
				{
					if(flag.equals("ename"))
					{
						queryString = "from TbDeptlvl as model where model.ename= '"+value+"' and id != '"+id+"'";
					}
					else
					{
						queryString = "from TbDeptlvl as model where model.code= '"+value+"' and id != '"+id+"'";
					}
				}
				
				return getHibernateTemplate().find(queryString);
			} catch (RuntimeException re) {
				log.error("find by property ename failed", re);
				throw re;
			}
	}
}