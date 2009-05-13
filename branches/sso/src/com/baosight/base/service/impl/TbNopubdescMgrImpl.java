package com.baosight.base.service.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.ITbNopubdescDAO;
import com.baosight.base.service.ITbNopubdescMgr;

import com.baosight.mode.TbNopubdesc;


public class TbNopubdescMgrImpl implements ITbNopubdescMgr {

	private ITbNopubdescDAO tbNopubdescDAO;
	
	public void save(TbNopubdesc transientInstance) {
		tbNopubdescDAO.save(transientInstance);
	}

	public void delete(TbNopubdesc persistentInstance) {
		tbNopubdescDAO.delete(persistentInstance);
	}

	public TbNopubdesc findById(java.lang.String id) {
		return tbNopubdescDAO.findById(id);
	}

	public List findByExample(TbNopubdesc instance) {
		return tbNopubdescDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbNopubdescDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbNopubdescDAO.findAll();
	}

	public ITbNopubdescDAO getTbNopubdescDAO() {
		return tbNopubdescDAO;
	}

	public void setTbNopubdescDAO(ITbNopubdescDAO tbNopubdescDAO) {
		this.tbNopubdescDAO = tbNopubdescDAO;
	}
}