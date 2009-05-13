package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocUrgentDAO;
import com.baosight.mode.TbDocUrgent;

/**
 * Data access object (DAO) for domain model class TbDocUrgent.
 * 
 * @see com.baosight.mode.TbDocUrgent
 * @author MyEclipse Persistence Tools
 */

public class TbDocUrgentDAOImpl extends HibernateDaoSupport implements ITbDocUrgentDAO {
	private static final Log log = LogFactory.getLog(TbDocUrgentDAOImpl.class);

	// property constants
	public static final String URGENT_CON = "urgentCon";

	public static final String URGENT_OBJ = "urgentObj";

	public static final String URGENT_WAY = "urgentWay";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocUrgent transientInstance) {
		log.debug("saving TbDocUrgent instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocUrgent persistentInstance) {
		log.debug("deleting TbDocUrgent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocUrgent findById(java.lang.String id) {
		log.debug("getting TbDocUrgent instance with id: " + id);
		try {
			TbDocUrgent instance = (TbDocUrgent) getHibernateTemplate().get(
					"com.baosight.mode.TbDocUrgent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocUrgent instance) {
		log.debug("finding TbDocUrgent instance by example");
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
		log.debug("finding TbDocUrgent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDocUrgent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUrgentCon(Object urgentCon) {
		return findByProperty(URGENT_CON, urgentCon);
	}

	public List findByUrgentObj(Object urgentObj) {
		return findByProperty(URGENT_OBJ, urgentObj);
	}

	public List findByUrgentWay(Object urgentWay) {
		return findByProperty(URGENT_WAY, urgentWay);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	public List findAll() {
		log.debug("finding all TbDocUrgent instances");
		try {
			String queryString = "from TbDocUrgent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocUrgent merge(TbDocUrgent detachedInstance) {
		log.debug("merging TbDocUrgent instance");
		try {
			TbDocUrgent result = (TbDocUrgent) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocUrgent instance) {
		log.debug("attaching dirty TbDocUrgent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocUrgent instance) {
		log.debug("attaching clean TbDocUrgent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbDocUrgentDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbDocUrgentDAOImpl) ctx.getBean("TbDocUrgentDAO");
	}
}