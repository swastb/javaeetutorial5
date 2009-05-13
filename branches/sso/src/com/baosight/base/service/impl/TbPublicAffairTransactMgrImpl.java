package com.baosight.base.service.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbPublicAffairTransactDAO;
import com.baosight.base.service.ITbPublicAffairTransactMgr;
import com.baosight.mode.TbPublicAffairTransact;




public class TbPublicAffairTransactMgrImpl  implements  ITbPublicAffairTransactMgr {

	private ITbPublicAffairTransactDAO tbPublicAffairTransactDAO;

	public void save(TbPublicAffairTransact transientInstance) {
		tbPublicAffairTransactDAO.save(transientInstance);
	}

	public void delete(TbPublicAffairTransact persistentInstance) {
		tbPublicAffairTransactDAO.delete(persistentInstance);
	}

	public TbPublicAffairTransact findById(java.lang.String id) {
		return tbPublicAffairTransactDAO.findById(id);
	}

	public List findByExample(TbPublicAffairTransact instance) {
		return tbPublicAffairTransactDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbPublicAffairTransactDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbPublicAffairTransactDAO.findAll();
	}
	public void setTbPublicAffairTransactDAO(
			ITbPublicAffairTransactDAO tbPublicAffairTransactDAO) {
		this.tbPublicAffairTransactDAO = tbPublicAffairTransactDAO;
	}

	public void update(TbPublicAffairTransact transientInstance) {
		tbPublicAffairTransactDAO.update(transientInstance);
		
	}
	
	public List getPublicAffairTransactById(String id,Long affairType,Long type){
		return tbPublicAffairTransactDAO.getPublicAffairTransactById(id, affairType,type);
	}
}