package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgkcfsqgzsDAO;
import com.baosight.base.service.IZfxxgkcfsqgzsMgr;
import com.baosight.mode.TbZfxxgkcfsqgzs;

public class ZfxxgkcfsqgzsMgrImpl implements IZfxxgkcfsqgzsMgr {
	private ITbZfxxgkcfsqgzsDAO tbZfxxgkcfsqgzsDAO;

	public void setTbZfxxgkcfsqgzsDAO(ITbZfxxgkcfsqgzsDAO tbZfxxgkcfsqgzsDAO) {
		this.tbZfxxgkcfsqgzsDAO = tbZfxxgkcfsqgzsDAO;
	}

	public void delete(String id) {
		TbZfxxgkcfsqgzs item = find(id);
		this.tbZfxxgkcfsqgzsDAO.delete(item);
	}

	public TbZfxxgkcfsqgzs find(String id) {
		return this.tbZfxxgkcfsqgzsDAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxgkcfsqgzsDAO.findAll();
	}

	public void save(TbZfxxgkcfsqgzs item) {
		this.tbZfxxgkcfsqgzsDAO.save(item);
	}

	public void update(TbZfxxgkcfsqgzs item) {
		this.tbZfxxgkcfsqgzsDAO.update(item);
	}

	public List findByExample(TbZfxxgkcfsqgzs instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkcfsqgzsDAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbZfxxgkcfsqgzsDAO.findByInfoId(infoId);
	}

}
