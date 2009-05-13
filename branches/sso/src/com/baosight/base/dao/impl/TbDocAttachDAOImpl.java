package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocAttachDAO;
import com.baosight.mode.TbDocAttach;

/**
 * Data access object (DAO) for domain model class TbDocAttach.
 * 
 * @see com.baosight.mode.TbDocAttach
 * @author MyEclipse Persistence Tools
 */

public class TbDocAttachDAOImpl extends HibernateDaoSupport implements ITbDocAttachDAO {
	private static final Log log = LogFactory.getLog(TbDocAttachDAOImpl.class);

	// property constants
	public static final String FOREIGN_ID = "foreignId";

	public static final String PATH = "path";

	public static final String ORIGINALLY_NAME = "originallyName";

	public static final String SERVER_NAME = "serverName";

	public static final String TYPE = "type";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocAttach transientInstance) {
		log.debug("saving TbDocAttach instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocAttach persistentInstance) {
		log.debug("deleting TbDocAttach instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocAttach findById(java.lang.String id) {
		log.debug("getting TbDocAttach instance with id: " + id);
		try {
			TbDocAttach instance = (TbDocAttach) getHibernateTemplate().get(
					"com.baosight.mode.TbDocAttach", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocAttach instance) {
		log.debug("finding TbDocAttach instance by example");
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
		log.debug("finding TbDocAttach instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDocAttach as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByForeignId(Object foreignId) {
		return findByProperty(FOREIGN_ID, foreignId);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findByOriginallyName(Object originallyName) {
		return findByProperty(ORIGINALLY_NAME, originallyName);
	}

	public List findByServerName(Object serverName) {
		return findByProperty(SERVER_NAME, serverName);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all TbDocAttach instances");
		try {
			String queryString = "from TbDocAttach";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocAttach merge(TbDocAttach detachedInstance) {
		log.debug("merging TbDocAttach instance");
		try {
			TbDocAttach result = (TbDocAttach) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocAttach instance) {
		log.debug("attaching dirty TbDocAttach instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocAttach instance) {
		log.debug("attaching clean TbDocAttach instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByHQL(final String hql,final int startIndex, final int maxResultCount) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (maxResultCount != -1)
					query.setMaxResults(maxResultCount);
				if (startIndex != -1)
					query.setFirstResult(startIndex);
				return query.list();
			}
		}, true);
	}

	public static ITbDocAttachDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocAttachDAO) ctx.getBean("TbDocAttachDAO");
	}
}