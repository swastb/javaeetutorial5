package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.mode.TbFilesendAttachment;

/**
 * Data access object (DAO) for domain model class TbFilesendAttachment.
 * 
 * @see com.baosight.mode.TbFilesendAttachment
 * @author MyEclipse Persistence Tools
 */

public class TbFilesendAttachmentDAOImpl extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(TbFilesendAttachmentDAOImpl.class);

	public void save(TbFilesendAttachment transientInstance) {
		log.debug("saving TbFilesendAttachment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbFilesendAttachment persistentInstance) {
		log.debug("deleting TbFilesendAttachment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbFilesendAttachment findById(java.lang.String id) {
		log.debug("getting TbFilesendAttachment instance with id: " + id);
		try {
			TbFilesendAttachment instance = (TbFilesendAttachment) getHibernateTemplate()
					.get("com.baosight.mode.TbFilesendAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbFilesendAttachment instance) {
		log.debug("finding TbFilesendAttachment instance by example");
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
		log.debug("finding TbFilesendAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbFilesendAttachment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbFilesendAttachment instances");
		try {
			String queryString = "from TbFilesendAttachment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbFilesendAttachment merge(TbFilesendAttachment detachedInstance) {
		log.debug("merging TbFilesendAttachment instance");
		try {
			TbFilesendAttachment result = (TbFilesendAttachment) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbFilesendAttachment instance) {
		log.debug("attaching dirty TbFilesendAttachment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbFilesendAttachment instance) {
		log.debug("attaching clean TbFilesendAttachment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbFilesendAttachmentDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbFilesendAttachmentDAOImpl) ctx.getBean("TbFilesendAttachmentDAO");
	}
}