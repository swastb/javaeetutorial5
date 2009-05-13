package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfs3DAO;
import com.baosight.base.service.IZfxxgksqdfs3Mgr;
import com.baosight.mode.TbZfxxgksqdfs3;

public class Zfxxgksqdfs3MgrImpl implements IZfxxgksqdfs3Mgr {
	private ITbZfxxgksqdfs3DAO tbZfxxgksqdfs3DAO;

	public void setTbZfxxgksqdfs3DAO(ITbZfxxgksqdfs3DAO tbZfxxgksqdfs3DAO) {
		this.tbZfxxgksqdfs3DAO = tbZfxxgksqdfs3DAO;
	}

	public void delete(String id) {
		TbZfxxgksqdfs3 item = find(id);
		this.tbZfxxgksqdfs3DAO.delete(item);
	}

	public TbZfxxgksqdfs3 find(String id) {
		return this.tbZfxxgksqdfs3DAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxgksqdfs3DAO.findAll();
	}

	public void save(TbZfxxgksqdfs3 item) {
		this.tbZfxxgksqdfs3DAO.save(item);
	}

	public void update(TbZfxxgksqdfs3 item) {
		this.tbZfxxgksqdfs3DAO.update(item);
	}

	public List findByExample(TbZfxxgksqdfs3 instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqdfs3DAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbZfxxgksqdfs3DAO.findByInfoId(infoId);
	}

}
