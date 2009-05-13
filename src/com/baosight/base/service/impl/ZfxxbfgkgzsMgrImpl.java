package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxbfgkgzsDAO;
import com.baosight.base.dao.ITbZfxxgkgzsDAO;
import com.baosight.base.service.IZfxxbfgkgzsMgr;
import com.baosight.mode.TbZfxxbfgkgzs;

public class ZfxxbfgkgzsMgrImpl implements IZfxxbfgkgzsMgr {
	private ITbZfxxbfgkgzsDAO tbZfxxbfgkgzsDAO;


	public void setTbZfxxbfgkgzsDAO(ITbZfxxbfgkgzsDAO tbZfxxbfgkgzsDAO) {
		this.tbZfxxbfgkgzsDAO = tbZfxxbfgkgzsDAO;
	}

	public void delete(String id) {
		TbZfxxbfgkgzs item = find(id);
		this.tbZfxxbfgkgzsDAO.delete(item);
		
	}


	public TbZfxxbfgkgzs find(String id) {
		return this.tbZfxxbfgkgzsDAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxbfgkgzsDAO.findAll();
	}


	public void save(TbZfxxbfgkgzs item) {
		this.tbZfxxbfgkgzsDAO.save(item);
	}

	public void update(TbZfxxbfgkgzs item) {
		this.tbZfxxbfgkgzsDAO.update(item);
	}

	public List findByExample(TbZfxxbfgkgzs instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxbfgkgzsDAO.findByExample(instance);
	}
}
