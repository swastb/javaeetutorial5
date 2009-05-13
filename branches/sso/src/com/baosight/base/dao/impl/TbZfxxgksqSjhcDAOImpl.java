package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgksqSjhcDAO;
import com.baosight.mode.TbZfxxgksqSjhc;

/**
 * Data access object (DAO) for domain model class TbZfxxgksqSjhc.
 * 
 * @see com.baosight.mode.TbZfxxgksqSjhc
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgksqSjhcDAOImpl extends HibernateDaoSupport implements ITbZfxxgksqSjhcDAO {
	private static final Log log = LogFactory.getLog(ITbZfxxgksqSjhcDAO.class);

	// property constants
	public static final String LS_NO = "lsNo";

	public static final String APPLI_NAME = "appliName";

	public static final String INFO_NAME = "infoName";

	public static final String ATTR1 = "attr1";

	protected void initDao() {
		// do nothing
	}

	public void save(TbZfxxgksqSjhc transientInstance) {
		log.debug("saving TbZfxxgksqSjhc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbZfxxgksqSjhc persistentInstance) {
		log.debug("deleting TbZfxxgksqSjhc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbZfxxgksqSjhc findById(java.lang.String id) {
		log.debug("getting TbZfxxgksqSjhc instance with id: " + id);
		try {
			TbZfxxgksqSjhc instance = (TbZfxxgksqSjhc) getHibernateTemplate()
					.get("com.baosight.mode.TbZfxxgksqSjhc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbZfxxgksqSjhc instance) {
		log.debug("finding TbZfxxgksqSjhc instance by example");
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
		log.debug("finding TbZfxxgksqSjhc instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZfxxgksqSjhc as model where model."
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

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findAll() {
		log.debug("finding all TbZfxxgksqSjhc instances");
		try {
			String queryString = "from TbZfxxgksqSjhc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbZfxxgksqSjhc merge(TbZfxxgksqSjhc detachedInstance) {
		log.debug("merging TbZfxxgksqSjhc instance");
		try {
			TbZfxxgksqSjhc result = (TbZfxxgksqSjhc) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbZfxxgksqSjhc instance) {
		log.debug("attaching dirty TbZfxxgksqSjhc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbZfxxgksqSjhc instance) {
		log.debug("attaching clean TbZfxxgksqSjhc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbZfxxgksqSjhcDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbZfxxgksqSjhcDAO) ctx.getBean("TbZfxxgksqSjhcDAO");
	}

	public List queryContent(String docNum) {
		log.debug("finding TbGovInfoPubContent instance with property: docNum, value: " + docNum);
		try {
			String queryString = "from TbGovInfoPubContent as model where model.fileCode= ?";
			return getHibernateTemplate().find(queryString, docNum);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		/*String sql="select c.content c from tb_gov_info_pub_content c where c.file_code='"+docNum+"'";
		Query query = getSession().createSQLQuery(sql);
		System.out.println("**");
		query.list();
		return null;*/
	}

}