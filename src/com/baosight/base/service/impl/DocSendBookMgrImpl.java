package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbDocSendDAO;
import com.baosight.base.dao.ITbDocsendControlDAO;
import com.baosight.base.service.IDocSendBookMgr;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;

public class DocSendBookMgrImpl implements IDocSendBookMgr {
	private ITbDocSendDAO tbDocSendDAO;


	private ITbDocsendControlDAO tbDocsendControlDAO;
	
	public void saveDocSend(TbDocSend instance) {
		// TODO Auto-generated method stub
		tbDocSendDAO.save(instance);
	}

	public void updateDocSend(TbDocSend instance) {
		// TODO Auto-generated method stub
		tbDocSendDAO.merge(instance);
	}

	public TbDocSend findDocSendById(String id) {
		return tbDocSendDAO.findById(id);
	}

	public TbDocsendControl findDocSendControlById(String id) {
		// TODO Auto-generated method stub
		return tbDocsendControlDAO.findById(id);
	}

	public void saveDocSendControl(TbDocsendControl instance) {
		// TODO Auto-generated method stub
		tbDocsendControlDAO.save(instance);
	}

	public void updateDocSendControl(TbDocsendControl instance) {
		// TODO Auto-generated method stub
		tbDocsendControlDAO.merge(instance);
	}

	public ITbDocSendDAO getTbDocSendDAO() {
		return tbDocSendDAO;
	}

	public void setTbDocSendDAO(ITbDocSendDAO tbDocSendDAO) {
		this.tbDocSendDAO = tbDocSendDAO;
	}

	public ITbDocsendControlDAO getTbDocsendControlDAO() {
		return tbDocsendControlDAO;
	}

	public void setTbDocsendControlDAO(ITbDocsendControlDAO tbDocsendControlDAO) {
		this.tbDocsendControlDAO = tbDocsendControlDAO;
	}

}
