package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfs4DAO;
import com.baosight.base.service.IZfxxgksqdfs4Mgr;
import com.baosight.mode.TbZfxxgksqdfs4;

public class Zfxxgksqdfs4MgrImpl implements IZfxxgksqdfs4Mgr {
	private ITbZfxxgksqdfs4DAO tbZfxxgksqdfs4DAO;

	public void setTbZfxxgksqdfs4DAO(ITbZfxxgksqdfs4DAO tbZfxxgksqdfs4DAO) {
		this.tbZfxxgksqdfs4DAO = tbZfxxgksqdfs4DAO;
	}

	public void delete(String id) {
		TbZfxxgksqdfs4 item = find(id);
		this.tbZfxxgksqdfs4DAO.delete(item);
	}

	public TbZfxxgksqdfs4 find(String id) {
		return this.tbZfxxgksqdfs4DAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxgksqdfs4DAO.findAll();
	}

	public void save(TbZfxxgksqdfs4 item) {
		this.tbZfxxgksqdfs4DAO.save(item);
	}

	public void update(TbZfxxgksqdfs4 item) {
		this.tbZfxxgksqdfs4DAO.update(item);
	}

	public List findByExample(TbZfxxgksqdfs4 instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqdfs4DAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbZfxxgksqdfs4DAO.findByInfoId(infoId);
	}

}
