package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbGovInfoPubDAO;
import com.baosight.base.service.IGovInfoPubMgr;
import com.baosight.mode.TbGovInfoPub;

public class GovInfoPubManagerImpl implements IGovInfoPubMgr {

	
	private ITbGovInfoPubDAO tbGovInfoPubDAO;
	public TbGovInfoPub  findById(String id) {
		return tbGovInfoPubDAO.findById(id);
	}
	public ITbGovInfoPubDAO getTbGovInfoPubDAO() {
		return tbGovInfoPubDAO;
	}
	public void setTbGovInfoPubDAO(ITbGovInfoPubDAO tbGovInfoPubDAO) {
		this.tbGovInfoPubDAO = tbGovInfoPubDAO;
	}

}
