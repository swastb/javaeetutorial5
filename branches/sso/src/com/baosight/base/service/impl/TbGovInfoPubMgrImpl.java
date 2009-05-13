package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbGovInfoPubDAO;
import com.baosight.base.service.ITbGovInfoPubMgr;
import com.baosight.mode.TbGovInfoPub;

public class TbGovInfoPubMgrImpl implements ITbGovInfoPubMgr {

	private ITbGovInfoPubDAO tbGovInfoPubDAO;
	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubDAO.findAll();
	}
	      
	public TbGovInfoPub findById(String id) {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubDAO.findById(id);
	}
	public List findByProperty(String propertyName, Object value){
		return this.tbGovInfoPubDAO.findByProperty(propertyName,value);
	}
	
	public void save(TbGovInfoPub model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubDAO.save(model);
	}

	public void update(TbGovInfoPub model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubDAO.update(model);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubDAO.delete(this.findById(id));
	}

	public ITbGovInfoPubDAO getTbGovInfoPubDAO() {
		return tbGovInfoPubDAO;
	}

	public void setTbGovInfoPubDAO(ITbGovInfoPubDAO tbGovInfoPubDAO) {
		this.tbGovInfoPubDAO = tbGovInfoPubDAO;
	}
}
