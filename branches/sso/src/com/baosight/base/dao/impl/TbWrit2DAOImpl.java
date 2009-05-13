package com.baosight.base.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWrit2DAO;
import com.baosight.mode.TbWrit2;

public class TbWrit2DAOImpl extends HibernateDaoSupport implements ITbWrit2DAO {
	private static final Log log = LogFactory.getLog(TbWrit2DAOImpl.class);
	public void delete(TbWrit2 persistentInstance) {
		log.debug("deleting TbWrit2 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public TbWrit2 findById(String id) {
		log.debug("getting TbWrit2 instance with id: " + id);
		try {
			TbWrit2 instance = (TbWrit2) getHibernateTemplate().get(
					"com.baosight.mode.TbWrit2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbWrit2 transientInstance) {
		log.debug("saving TbWrit2 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbWrit2 transientInstance) {
		log.debug("updating TbWrit2 instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

}
