package com.baosight.base.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWrit8DAO;
import com.baosight.mode.TbWrit8;

public class TbWrit8DAOImpl extends HibernateDaoSupport implements ITbWrit8DAO {
	private static final Log log = LogFactory.getLog(TbWrit8DAOImpl.class);
	public void delete(TbWrit8 persistentInstance) {
		log.debug("deleting TbWrit8 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public TbWrit8 findById(String id) {
		log.debug("getting TbWrit8 instance with id: " + id);
		try {
			TbWrit8 instance = (TbWrit8) getHibernateTemplate().get(
					"com.baosight.mode.TbWrit8", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbWrit8 transientInstance) {
		log.debug("saving TbWrit8 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbWrit8 transientInstance) {
		log.debug("updating TbWrit8 instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

}
