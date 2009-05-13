package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbPubclassDAO;
import com.baosight.base.service.ITbPubclassMgr;
import com.baosight.mode.TbPubclass;



public class TbPubclassMgrImpl implements ITbPubclassMgr {

	private ITbPubclassDAO tbPubclassDAO;

	public void save(TbPubclass transientInstance) {
		tbPubclassDAO.save(transientInstance);
	}

	public void delete(TbPubclass persistentInstance) {
		tbPubclassDAO.delete(persistentInstance);
	}

	public TbPubclass findById(java.lang.String id) {
		return tbPubclassDAO.findById(id);
	}

	public List findByExample(TbPubclass instance) {
		return tbPubclassDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbPubclassDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbPubclassDAO.findAll();
	}

	public ITbPubclassDAO getTbPubclassDAO() {
		return tbPubclassDAO;
	}

	public void setTbPubclassDAO(ITbPubclassDAO tbPubclassDAO) {
		this.tbPubclassDAO = tbPubclassDAO;
	}
}