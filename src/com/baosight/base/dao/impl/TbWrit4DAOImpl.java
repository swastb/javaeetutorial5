package com.baosight.base.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWrit4DAO;
import com.baosight.mode.TbWrit4;

public class TbWrit4DAOImpl extends HibernateDaoSupport implements ITbWrit4DAO {
	private static final Log log = LogFactory.getLog(TbWrit4DAOImpl.class);
	public void delete(TbWrit4 persistentInstance) {
		log.debug("deleting TbWrit4 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public TbWrit4 findById(String id) {
		log.debug("getting TbWrit4 instance with id: " + id);
		try {
			TbWrit4 instance = (TbWrit4) getHibernateTemplate().get(
					"com.baosight.mode.TbWrit4", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbWrit4 transientInstance) {
		log.debug("saving TbWrit4 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbWrit4 transientInstance) {
		log.debug("updating TbWrit4 instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

}
