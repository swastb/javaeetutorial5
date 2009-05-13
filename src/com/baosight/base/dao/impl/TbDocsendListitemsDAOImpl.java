package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocsendListitemsDAO;
import com.baosight.mode.TbDocsendListitems;

/**
 * Data access object (DAO) for domain model class TbDocsendListitems.
 * 
 * @see com.baosight.mode.TbDocsendListitems
 * @author MyEclipse Persistence Tools
 */

public class TbDocsendListitemsDAOImpl extends HibernateDaoSupport implements ITbDocsendListitemsDAO {
	private static final Log log = LogFactory
			.getLog(TbDocsendListitemsDAOImpl.class);

	// property constants
	public static final String STYLE = "style";

	public static final String CODE = "code";

	public static final String TITLE = "title";

	public static final String INFO = "info";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#save(com.baosight.mode.TbDocsendListitems)
	 */
	public void save(TbDocsendListitems transientInstance) {
		log.debug("saving TbDocsendListitems instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#delete(com.baosight.mode.TbDocsendListitems)
	 */
	public void delete(TbDocsendListitems persistentInstance) {
		log.debug("deleting TbDocsendListitems instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findById(java.lang.String)
	 */
	public TbDocsendListitems findById(java.lang.String id) {
		log.debug("getting TbDocsendListitems instance with id: " + id);
		try {
			TbDocsendListitems instance = (TbDocsendListitems) getHibernateTemplate()
					.get("com.baosight.mode.TbDocsendListitems", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByExample(com.baosight.mode.TbDocsendListitems)
	 */
	public List findByExample(TbDocsendListitems instance) {
		log.debug("finding TbDocsendListitems instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocsendListitems instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocsendListitems as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByStyle(java.lang.Object)
	 */
	public List findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findByInfo(java.lang.Object)
	 */
	public List findByInfo(Object info) {
		return findByProperty(INFO, info);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocsendListitems instances");
		try {
			String queryString = "from TbDocsendListitems";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#merge(com.baosight.mode.TbDocsendListitems)
	 */
	public TbDocsendListitems merge(TbDocsendListitems detachedInstance) {
		log.debug("merging TbDocsendListitems instance");
		try {
			TbDocsendListitems result = (TbDocsendListitems) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#attachDirty(com.baosight.mode.TbDocsendListitems)
	 */
	public void attachDirty(TbDocsendListitems instance) {
		log.debug("attaching dirty TbDocsendListitems instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendListitemsDAO#attachClean(com.baosight.mode.TbDocsendListitems)
	 */
	public void attachClean(TbDocsendListitems instance) {
		log.debug("attaching clean TbDocsendListitems instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocsendListitemsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocsendListitemsDAO) ctx.getBean("tbDocsendListitemsDAO");
	}
}