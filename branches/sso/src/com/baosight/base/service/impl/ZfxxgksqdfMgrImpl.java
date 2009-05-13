package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfDAO;
import com.baosight.base.service.IZfxxgksqdfMgr;
import com.baosight.mode.TbZfxxgksqdf;

public class ZfxxgksqdfMgrImpl implements IZfxxgksqdfMgr {
	private ITbZfxxgksqdfDAO tbZfxxgksqdfDAO;

	public void setTbZfxxgksqdfDAO(ITbZfxxgksqdfDAO tbZfxxgksqdfDAO) {
		this.tbZfxxgksqdfDAO = tbZfxxgksqdfDAO;
	}

	public void delete(String id) {
		TbZfxxgksqdf item = find(id);
		this.tbZfxxgksqdfDAO.delete(item);
	}

	public TbZfxxgksqdf find(String id) {
		return this.tbZfxxgksqdfDAO.findById(id);
	}

	public List findAll() {
		return this.tbZfxxgksqdfDAO.findAll();
	}

	public void save(TbZfxxgksqdf item) {
		this.tbZfxxgksqdfDAO.save(item);
	}

	public void update(TbZfxxgksqdf item) {
		this.tbZfxxgksqdfDAO.update(item);
	}

	public List findByExample(TbZfxxgksqdf instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgksqdfDAO.findByExample(instance);
	}

	public List findByInfoId(Object infoId) {
		return this.tbZfxxgksqdfDAO.findByInfoId(infoId);
	}

}
