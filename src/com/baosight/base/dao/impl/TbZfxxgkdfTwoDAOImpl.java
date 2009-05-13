package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgkdfTwoDAO;
import com.baosight.mode.TbZfxxgkdfTwo;

/**
 * Data access object (DAO) for domain model class TbZfxxgkdfTwo.
 * 
 * @see com.baosight.mode.TbZfxxgkdfTwo
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgkdfTwoDAOImpl extends HibernateDaoSupport implements ITbZfxxgkdfTwoDAO {
	private static final Log log = LogFactory.getLog(ITbZfxxgkdfTwoDAO.class);

	// property constants
	public static final String LS_NO = "lsNo";

	public static final String APPLI_NAME = "appliName";

	public static final String INFO_NAME = "infoName";

	public static final String INFO_RANK = "infoRank";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgkdfTwo transientInstance) {
		log.debug("saving TbZfxxgkdfTwo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgkdfTwo persistentInstance) {
		log.debug("deleting TbZfxxgkdfTwo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbZfxxgkdfTwo findById(java.lang.String id) {
		log.debug("getting TbZfxxgkdfTwo instance with id: " + id);
		try {
			TbZfxxgkdfTwo instance = (TbZfxxgkdfTwo) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgkdfTwo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgkdfTwo instance) {
		log.debug("finding TbZfxxgkdfTwo instance by example");
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
		log.debug("finding TbZfxxgkdfTwo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgkdfTwo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLsNo(Object lsNo) {
		return findByProperty(LS_NO, lsNo);
	}

	public List findByAppliName(Object appliName) {
		return findByProperty(APPLI_NAME, appliName);
	}

	public List findByInfoName(Object infoName) {
		return findByProperty(INFO_NAME, infoName);
	}

	public List findByInfoRank(Object infoRank) {
		return findByProperty(INFO_RANK, infoRank);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findAll() {
		log.debug("finding all TbZfxxgkdfTwo instances");
		try {
			String queryString = "from TbZfxxgkdfTwo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgkdfTwo merge(TbZfxxgkdfTwo detachedInstance) {
		log.debug("merging TbZfxxgkdfTwo instance");
		try {
			TbZfxxgkdfTwo result = (TbZfxxgkdfTwo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgkdfTwo instance) {
		log.debug("attaching dirty TbZfxxgkdfTwo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgkdfTwo instance) {
		log.debug("attaching clean TbZfxxgkdfTwo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbZfxxgkdfTwoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbZfxxgkdfTwoDAO) ctx.getBean("TbZfxxgkdfTwoDAO");
	}
}