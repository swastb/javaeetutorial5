package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgkbzsqgzsDAO;
import com.baosight.base.service.IZfxxgkbzsqgzsMgr;
import com.baosight.mode.TbZfxxgkbzsqgzs;

public class ZfxxgkbzsqgzsMgrImpl implements IZfxxgkbzsqgzsMgr {
	private ITbZfxxgkbzsqgzsDAO tbZfxxgkbzsqgzsDAO;

	public void setTbZfxxgkbzsqgzsDAO(ITbZfxxgkbzsqgzsDAO tbZfxxgkbzsqgzsDAO) {
		this.tbZfxxgkbzsqgzsDAO = tbZfxxgkbzsqgzsDAO;
	}

	public void delete(String id) {
		TbZfxxgkbzsqgzs item = find(id);
		this.tbZfxxgkbzsqgzsDAO.delete(item);
	}

	public TbZfxxgkbzsqgzs find(String id) {
		return this.tbZfxxgkbzsqgzsDAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxgkbzsqgzsDAO.findAll();
	}

	public void save(TbZfxxgkbzsqgzs item) {
		this.tbZfxxgkbzsqgzsDAO.save(item);
	}

	public void update(TbZfxxgkbzsqgzs item) {
		this.tbZfxxgkbzsqgzsDAO.update(item);
	}

	public List findByExample(TbZfxxgkbzsqgzs instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkbzsqgzsDAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbZfxxgkbzsqgzsDAO.findByInfoId(infoId);
	}

}
