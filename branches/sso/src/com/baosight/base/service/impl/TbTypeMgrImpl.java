package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbTypeDAO;
import com.baosight.base.service.ITbTypeMgr;
import com.baosight.mode.TbType;



public class TbTypeMgrImpl implements ITbTypeMgr {

	private ITbTypeDAO tbTypeDAO;

	public void save(TbType transientInstance) {
		tbTypeDAO.save(transientInstance);
	}

	public void delete(TbType persistentInstance) {
		tbTypeDAO.delete(persistentInstance);
	}

	public TbType findById(java.lang.String id) {
		return tbTypeDAO.findById(id);
	}

	public List findByExample(TbType instance) {
		return tbTypeDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbTypeDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbTypeDAO.findAll();
	}

	public ITbTypeDAO getTbTypeDAO() {
		return tbTypeDAO;
	}

	public void setTbTypeDAO(ITbTypeDAO tbTypeDAO) {
		this.tbTypeDAO = tbTypeDAO;
	}

}