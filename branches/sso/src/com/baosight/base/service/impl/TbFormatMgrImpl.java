package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbFormatDAO;
import com.baosight.base.service.ITbFormatMgr;
import com.baosight.mode.TbFormat;;



public class TbFormatMgrImpl implements  ITbFormatMgr{

	private ITbFormatDAO tbFormatDAO;

	public void save(TbFormat transientInstance) {
		tbFormatDAO.save(transientInstance);
	}

	public void delete(TbFormat persistentInstance) {
		tbFormatDAO.delete(persistentInstance);
	}

	public TbFormat findById(java.lang.String id) {
		return tbFormatDAO.findById(id);
	}

	public List findByExample(TbFormat instance) {
		return tbFormatDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbFormatDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbFormatDAO.findAll();
	}

	public ITbFormatDAO getTbFormatDAO() {
		return tbFormatDAO;
	}

	public void setTbFormatDAO(ITbFormatDAO tbFormatDAO) {
		this.tbFormatDAO = tbFormatDAO;
	}




}