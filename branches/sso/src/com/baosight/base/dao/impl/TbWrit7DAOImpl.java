package com.baosight.base.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWrit7DAO;
import com.baosight.mode.TbWrit7;

public class TbWrit7DAOImpl extends HibernateDaoSupport implements ITbWrit7DAO {
	private static final Log log = LogFactory.getLog(TbWrit7DAOImpl.class);
	public void delete(TbWrit7 persistentInstance) {
		log.debug("deleting TbWrit7 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public TbWrit7 findById(String id) {
		log.debug("getting TbWrit7 instance with id: " + id);
		try {
			TbWrit7 instance = (TbWrit7) getHibernateTemplate().get(
					"com.baosight.mode.TbWrit7", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbWrit7 transientInstance) {
		log.debug("saving TbWrit7 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbWrit7 transientInstance) {
		log.debug("updating TbWrit7 instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

}
