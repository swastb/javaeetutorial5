package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbGroupDAO;
import com.baosight.base.service.IGroupMgr;
import com.baosight.mode.TbGroup;

public class GroupMgrImpl implements IGroupMgr {
	
	private ITbGroupDAO tbGroupDAO;

	public void delete(String id) {
		TbGroup item = find(id);
		this.tbGroupDAO.delete(item);
	}

	public TbGroup find(String id) {
		return this.tbGroupDAO.findById(id);
	}

	public List findAll() {
		return this.tbGroupDAO.findAll();
	}

	public void save(TbGroup item) {
		this.tbGroupDAO.save(item);
	}

	public void updte(TbGroup item) {
		String id = item.getId();
		delete(id);
		save(item);
	}
	
	public void setTbGroupDAO(ITbGroupDAO tbGroupDAO) {
		this.tbGroupDAO = tbGroupDAO;
	}

}
