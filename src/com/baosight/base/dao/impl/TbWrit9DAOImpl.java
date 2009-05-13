package com.baosight.base.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbWrit9DAO;
import com.baosight.mode.TbWrit9;

public class TbWrit9DAOImpl extends HibernateDaoSupport implements ITbWrit9DAO {
	private static final Log log = LogFactory.getLog(TbWrit9DAOImpl.class);
	public void delete(TbWrit9 persistentInstance) {
		log.debug("deleting TbWrit9 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public TbWrit9 findById(String id) {
		log.debug("getting TbWrit9 instance with id: " + id);
		try {
			TbWrit9 instance = (TbWrit9) getHibernateTemplate().get(
					"com.baosight.mode.TbWrit9", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbWrit9 transientInstance) {
		log.debug("saving TbWrit9 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbWrit9 transientInstance) {
		log.debug("updating TbWrit9 instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

}
