package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbInfoAuditDAO;
import com.baosight.base.service.IInfoAuditMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbOpinionConsult;

public class InfoAuditMgrImpl implements IInfoAuditMgr{
	private ITbInfoAuditDAO tbInfoAuditDAO;

	public void setTbInfoAuditDAO(ITbInfoAuditDAO tbInfoAuditDAO) {
		this.tbInfoAuditDAO = tbInfoAuditDAO;
	}

	public List findByStatus(String condition) {
		List infoAutoList=tbInfoAuditDAO.findByStatus(condition);
		return infoAutoList;
	}

	public void save(TbOpinionConsult item) {
		this.tbInfoAuditDAO.save(item);
		
	}

	public List findOpinionListByFKId(String id) {
		List opinionConsultList=this.tbInfoAuditDAO.findByFKId(id);
		return opinionConsultList;
	}

	public void modify(TbOpinionConsult item) {
		this.tbInfoAuditDAO.update(item);	
	}

	public void modifyStatus(TbGovInfoPub item) {
		this.tbInfoAuditDAO.updateStatus(item);	
	}

	public TbGovInfoPub findById(String id) {
		return this.tbInfoAuditDAO.findById(id);
	}
	
	public int findAuditingCount() {
		List list=this.tbInfoAuditDAO.findAuditingCount();
		return Integer.parseInt(list.get(0).toString());
	}
}
