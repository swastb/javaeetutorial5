package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbGovInfoPubAuditDAO;
import com.baosight.base.service.ITbGovInfoPubAuditMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;

public class TbGovInfoPubAuditMgrImpl implements ITbGovInfoPubAuditMgr {

	private ITbGovInfoPubAuditDAO tbGovInfoPubAuditDAO;
	
	public ITbGovInfoPubAuditDAO getTbGovInfoPubAuditDAO() {
		return tbGovInfoPubAuditDAO;
	}
	public void setTbGovInfoPubAuditDAO(ITbGovInfoPubAuditDAO tbGovInfoPubAuditDAO) {
		this.tbGovInfoPubAuditDAO = tbGovInfoPubAuditDAO;
	}
	
	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubAuditDAO.findAll();
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		 this.tbGovInfoPubAuditDAO.delete(this.findById(id));
	}


	public TbGovInfoPubAudit findById(String id) {
		return this.tbGovInfoPubAuditDAO.findById(id);
		
	}


	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubAuditDAO.findByProperty(propertyName,value);
	}


	public void save(TbGovInfoPubAudit model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubAuditDAO.save(model);
	}


	public void update(TbGovInfoPubAudit model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubAuditDAO.update(model);
	}
}
