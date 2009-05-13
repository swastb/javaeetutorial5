package com.baosight.base.service.impl;

import java.util.List;
import com.baosight.base.dao.ITbOffDocCateDAO;
import com.baosight.base.service.ITbOffDocCateMgr;
import com.baosight.mode.TbOffDocCate;


public class TbOffDocCateMgrImpl implements ITbOffDocCateMgr{

	private ITbOffDocCateDAO tbOffDocCateDAO;

	public void save(TbOffDocCate transientInstance) {
		tbOffDocCateDAO.save(transientInstance);
	}

	public void delete(TbOffDocCate persistentInstance) {
		tbOffDocCateDAO.delete(persistentInstance);
	}

	public TbOffDocCate findById(java.lang.String id) {
		return tbOffDocCateDAO.findById(id);
	}

	public List findByExample(TbOffDocCate instance) {
		return tbOffDocCateDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbOffDocCateDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbOffDocCateDAO.findAll();
	}

	public ITbOffDocCateDAO getTbOffDocCateDAO() {
		return tbOffDocCateDAO;
	}

	public void setTbOffDocCateDAO(ITbOffDocCateDAO tbOffDocCateDAO) {
		this.tbOffDocCateDAO = tbOffDocCateDAO;
	}
}