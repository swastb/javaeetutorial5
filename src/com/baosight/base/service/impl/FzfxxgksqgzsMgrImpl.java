package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbFzfxxgksqgzsDAO;
import com.baosight.base.service.IFzfxxgksqgzsMgr;
import com.baosight.mode.TbFzfxxgksqgzs;

public class FzfxxgksqgzsMgrImpl implements IFzfxxgksqgzsMgr {
	private ITbFzfxxgksqgzsDAO tbFzfxxgksqgzsDAO;

	public void setTbFzfxxgksqgzsDAO(ITbFzfxxgksqgzsDAO tbFzfxxgksqgzsDAO) {
		this.tbFzfxxgksqgzsDAO = tbFzfxxgksqgzsDAO;
	}

	public void delete(String id) {
		TbFzfxxgksqgzs item = find(id);
		this.tbFzfxxgksqgzsDAO.delete(item);
	}

	public TbFzfxxgksqgzs find(String id) {
		return this.tbFzfxxgksqgzsDAO.findById(id);
	}

	public List findAll() {
		return this.tbFzfxxgksqgzsDAO.findAll();
	}

	public void save(TbFzfxxgksqgzs item) {
		this.tbFzfxxgksqgzsDAO.save(item);
	}

	public void update(TbFzfxxgksqgzs item) {
		this.tbFzfxxgksqgzsDAO.update(item);
	}

	public List findByExample(TbFzfxxgksqgzs instance) {
		// TODO Auto-generated method stub
		return this.tbFzfxxgksqgzsDAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbFzfxxgksqgzsDAO.findByInfoId(infoId);
	}

}
