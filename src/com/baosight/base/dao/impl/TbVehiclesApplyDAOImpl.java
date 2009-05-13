package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbVehiclesApplyDAO;

import com.baosight.mode.TbVehiclesApply;


/**
 * Data access object (DAO) for domain model class TbVehiclesApply.
 * 
 * @see com.baosight.mode.TbVehiclesApply
 * @author MyEclipse Persistence Tools
 */

public class TbVehiclesApplyDAOImpl extends HibernateDaoSupport implements ITbVehiclesApplyDAO {
	private static final Log log = LogFactory.getLog(TbVehiclesApplyDAOImpl.class);

	// property constants
	public static final String APPLY_DEPT = "applyDept";

	public static final String AUDITOR = "auditor";

	public static final String MODEL = "model";

	public static final String CAPACITY = "capacity";

	public static final String APPLYER = "applyer";

	public static final String PHONE = "phone";

	public static final String START_LOC = "startLoc";

	public static final String DEST = "dest";

	public static final String REASON = "reason";

	public static final String DISPATCHER = "dispatcher";

	public static final String DRIVER = "driver";

	public static final String LICENSE = "license";

	public static final String REM = "rem";

	public static final String STATUS = "status";

	public static final String BEL_SYS = "belSys";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	public void save(TbVehiclesApply transientInstance) {
		log.debug("saving TbVehiclesApply instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbVehiclesApply transientInstance) {
		log.debug("updating TbVehiclesApply instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(TbVehiclesApply persistentInstance) {
		log.debug("deleting TbVehiclesApply instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbVehiclesApply findById(java.lang.String id) {
		log.debug("getting TbVehiclesApply instance with id: " + id);
		try {
			TbVehiclesApply instance = (TbVehiclesApply) getHibernateTemplate()
					.get("com.baosight.mode.TbVehiclesApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbVehiclesApply instance) {
		log.debug("finding TbVehiclesApply instance by example");
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
		log.debug("finding TbVehiclesApply instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbVehiclesApply as model where model."
					+ propertyName + " like ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByApplyDept(Object applyDept) {
		return findByProperty(APPLY_DEPT, applyDept);
	}

	public List findByAuditor(Object auditor) {
		return findByProperty(AUDITOR, auditor);
	}

	public List findByModel(Object model) {
		return findByProperty(MODEL, model);
	}

	public List findByCapacity(Object capacity) {
		return findByProperty(CAPACITY, capacity);
	}

	public List findByApplyer(Object applyer) {
		return findByProperty(APPLYER, applyer);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByStartLoc(Object startLoc) {
		return findByProperty(START_LOC, startLoc);
	}

	public List findByDest(Object dest) {
		return findByProperty(DEST, dest);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByDispatcher(Object dispatcher) {
		return findByProperty(DISPATCHER, dispatcher);
	}

	public List findByDriver(Object driver) {
		return findByProperty(DRIVER, driver);
	}

	public List findByLicense(Object license) {
		return findByProperty(LICENSE, license);
	}

	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByBelSys(Object belSys) {
		return findByProperty(BEL_SYS, belSys);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	public List findAll() {
		log.debug("finding all TbVehiclesApply instances");
		try {
			String queryString = "from TbVehiclesApply";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbVehiclesApply merge(TbVehiclesApply detachedInstance) {
		log.debug("merging TbVehiclesApply instance");
		try {
			TbVehiclesApply result = (TbVehiclesApply) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbVehiclesApply instance) {
		log.debug("attaching dirty TbVehiclesApply instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbVehiclesApply instance) {
		log.debug("attaching clean TbVehiclesApply instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbVehiclesApplyDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbVehiclesApplyDAOImpl) ctx.getBean("TbVehiclesApplyDAO");
	}
}