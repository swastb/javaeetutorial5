package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITdVehiclesDAO;
import com.baosight.mode.TbVehicles;

public class TdVehiclesDAOImpl extends HibernateDaoSupport implements ITdVehiclesDAO{
	private static final Log log = LogFactory.getLog(TbAppsysDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	//	È«²éÑ¯
	public  List findAll(){
		log.debug("finding all TbVehicles instances");
		try {
			String queryString = "from TbVehicles order by license";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public  List findListByLicense(String license){
		log.debug("getting TbVehicles instance with license: " + license);
		String queryString;
		try {
			if(license.trim().equals("")){
				queryString = "from TbVehicles";	
			}else{
				queryString = "from TbVehicles where license like '%"+license+"%'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void delete(TbVehicles persistentInstance) {
		log.debug("deleting TbVehicles instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public TbVehicles findById(String id){
		log.debug("getting TbFunction instance with id: " + id);
		try {
			TbVehicles instance = (TbVehicles) getHibernateTemplate().get(
					"com.baosight.mode.TbVehicles", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void save(TbVehicles transientInstance) {
		log.debug("saving TbVehicles instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbVehicles transientInstance) {
		log.debug("update TbVehicles instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
}
