package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbSmsDepartDAO;
import com.baosight.mode.TbSmsDepart;

/**
 * Data access object (DAO) for domain model class TbSmsDepart.
 * 
 * @see com.baosight.mode.TbSmsDepart
 * @author MyEclipse Persistence Tools
 */

public class TbSmsDepartDAOImpl extends HibernateDaoSupport implements ITbSmsDepartDAO{
	private static final Log log = LogFactory.getLog(TbSmsDepartDAOImpl.class);

	// property constants
	public static final String DEPARTNAME = "departname";

	public static final String SUPERIOR_ID = "superiorId";

	public static final String DEPT_SORT = "deptSort";

	public static final String SMSCOUNT = "smscount";

	protected void initDao() {
		// do nothing
	}

	public void save(TbSmsDepart transientInstance) {
		log.debug("saving TbSmsDepart instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbSmsDepart persistentInstance) {
		log.debug("deleting TbSmsDepart instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbSmsDepart findById(java.lang.String id) {
		log.debug("getting TbSmsDepart instance with id: " + id);
		try {
			TbSmsDepart instance = (TbSmsDepart) getHibernateTemplate().get(
					"com.baosight.mode.TbSmsDepart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbSmsDepart instance) {
		log.debug("finding TbSmsDepart instance by example");
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
		log.debug("finding TbSmsDepart instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbSmsDepart as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDepartname(Object departname) {
		return findByProperty(DEPARTNAME, departname);
	}

	public List findBySuperiorId(Object superiorId) {
		return findByProperty(SUPERIOR_ID, superiorId);
	}

	public List findByDeptSort(Object deptSort) {
		return findByProperty(DEPT_SORT, deptSort);
	}

	public List findBySmscount(Object smscount) {
		return findByProperty(SMSCOUNT, smscount);
	}

	public List findAll() {
		log.debug("finding all TbSmsDepart instances");
		try {
			String queryString = "from TbSmsDepart";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbSmsDepart merge(TbSmsDepart detachedInstance) {
		log.debug("merging TbSmsDepart instance");
		try {
			TbSmsDepart result = (TbSmsDepart) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbSmsDepart instance) {
		log.debug("attaching dirty TbSmsDepart instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbSmsDepart instance) {
		log.debug("attaching clean TbSmsDepart instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbSmsDepartDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbSmsDepartDAOImpl) ctx.getBean("TbSmsDepartDAO");
	}
	public List findAllDepartName() {
		log.debug("finding all TbSmsDepart instances");
		try {
			String queryString = "select dt.id,dt.departname from TbSmsDepart dt";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}