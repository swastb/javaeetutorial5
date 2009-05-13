package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbYqdfgzsDAO;
import com.baosight.base.service.IYqdfgzsMgr;
import com.baosight.mode.TbYqdfgzs;

public class YqdfgzsMgrImpl implements IYqdfgzsMgr {
	private ITbYqdfgzsDAO tbYqdfgzsDAO;

	public void setTbYqdfgzsDAO(ITbYqdfgzsDAO tbYqdfgzsDAO) {
		this.tbYqdfgzsDAO = tbYqdfgzsDAO;
	}

	public void delete(String id) {
		TbYqdfgzs item = find(id);
		this.tbYqdfgzsDAO.delete(item);
	}

	public TbYqdfgzs find(String id) {
		return this.tbYqdfgzsDAO.findById(id);
	}

	public List findAll() {
		return this.tbYqdfgzsDAO.findAll();
	}

	public void save(TbYqdfgzs item) {
		this.tbYqdfgzsDAO.save(item);
	}

	public void update(TbYqdfgzs item) {
		this.tbYqdfgzsDAO.update(item);
	}

	public List findByExample(TbYqdfgzs instance) {
		// TODO Auto-generated method stub
		return this.tbYqdfgzsDAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbYqdfgzsDAO.findByInfoId(infoId);
	}

}
