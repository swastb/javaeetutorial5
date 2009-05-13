package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocsendSubjectDAO;
import com.baosight.mode.TbDocsendSubject;

/**
 * Data access object (DAO) for domain model class TbDocsendSubject.
 * 
 * @see com.baosight.mode.TbDocsendSubject
 * @author MyEclipse Persistence Tools
 */

public class TbDocsendSubjectDAOImpl extends HibernateDaoSupport implements ITbDocsendSubjectDAO {
	private static final Log log = LogFactory.getLog(TbDocsendSubjectDAOImpl.class);

	// property constants
	public static final String STYLE = "style";

	public static final String CLASS_ = "class_";

	public static final String TITLE = "title";

	public static final String PINYIN = "pinyin";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#save(com.baosight.mode.TbDocsendSubject)
	 */
	public void save(TbDocsendSubject transientInstance) {
		log.debug("saving TbDocsendSubject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#delete(com.baosight.mode.TbDocsendSubject)
	 */
	public void delete(TbDocsendSubject persistentInstance) {
		log.debug("deleting TbDocsendSubject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findById(java.lang.String)
	 */
	public TbDocsendSubject findById(java.lang.String id) {
		log.debug("getting TbDocsendSubject instance with id: " + id);
		try {
			TbDocsendSubject instance = (TbDocsendSubject) getHibernateTemplate()
					.get("com.baosight.mode.TbDocsendSubject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByExample(com.baosight.mode.TbDocsendSubject)
	 */
	public List findByExample(TbDocsendSubject instance) {
		log.debug("finding TbDocsendSubject instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocsendSubject instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocsendSubject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByStyle(java.lang.Object)
	 */
	public List findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByClass_(java.lang.Object)
	 */
	public List findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findByPinyin(java.lang.Object)
	 */
	public List findByPinyin(Object pinyin) {
		return findByProperty(PINYIN, pinyin);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocsendSubject instances");
		try {
			String queryString = "from TbDocsendSubject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#merge(com.baosight.mode.TbDocsendSubject)
	 */
	public TbDocsendSubject merge(TbDocsendSubject detachedInstance) {
		log.debug("merging TbDocsendSubject instance");
		try {
			TbDocsendSubject result = (TbDocsendSubject) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#attachDirty(com.baosight.mode.TbDocsendSubject)
	 */
	public void attachDirty(TbDocsendSubject instance) {
		log.debug("attaching dirty TbDocsendSubject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocsendSubjectDAO#attachClean(com.baosight.mode.TbDocsendSubject)
	 */
	public void attachClean(TbDocsendSubject instance) {
		log.debug("attaching clean TbDocsendSubject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocsendSubjectDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocsendSubjectDAO) ctx.getBean("tbDocsendSubjectDAO");
	}
}