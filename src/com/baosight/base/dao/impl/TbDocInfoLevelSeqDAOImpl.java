package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocInfoLevelSeqDAO;
import com.baosight.mode.TbDocInfoLevelSeq;
import com.baosight.mode.TbDocInfoLevelSeqId;

/**
 * Data access object (DAO) for domain model class TbDocInfoLevelSeq.
 * 
 * @see com.baosight.base.dao.impl.TbDocInfoLevelSeq
 * @author MyEclipse Persistence Tools
 */

public class TbDocInfoLevelSeqDAOImpl extends HibernateDaoSupport implements ITbDocInfoLevelSeqDAO {
	private static final Log log = LogFactory
			.getLog(TbDocInfoLevelSeqDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String CURRUNT_NUM = "curruntNum";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocInfoLevelSeq transientInstance) {
		log.debug("saving TbDocInfoLevelSeq instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocInfoLevelSeq persistentInstance) {
		log.debug("deleting TbDocInfoLevelSeq instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocInfoLevelSeq findById(TbDocInfoLevelSeqId id) {
		log.debug("getting TbDocInfoLevelSeq instance with id: " + id);
		try {
			TbDocInfoLevelSeq instance = (TbDocInfoLevelSeq) getHibernateTemplate()
					.get("com.baosight.mode.TbDocInfoLevelSeq", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocInfoLevelSeq instance) {
		log.debug("finding TbDocInfoLevelSeq instance by example");
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
		log.debug("finding TbDocInfoLevelSeq instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocInfoLevelSeq as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCurruntNum(Object curruntNum) {
		return findByProperty(CURRUNT_NUM, curruntNum);
	}

	public List findAll() {
		log.debug("finding all TbDocInfoLevelSeq instances");
		try {
			String queryString = "from TbDocInfoLevelSeq";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocInfoLevelSeq merge(TbDocInfoLevelSeq detachedInstance) {
		log.debug("merging TbDocInfoLevelSeq instance");
		try {
			TbDocInfoLevelSeq result = (TbDocInfoLevelSeq) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocInfoLevelSeq instance) {
		log.debug("attaching dirty TbDocInfoLevelSeq instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocInfoLevelSeq instance) {
		log.debug("attaching clean TbDocInfoLevelSeq instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocInfoLevelSeqDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocInfoLevelSeqDAO) ctx.getBean("TbDocInfoLevelSeqDAO");
	}
}