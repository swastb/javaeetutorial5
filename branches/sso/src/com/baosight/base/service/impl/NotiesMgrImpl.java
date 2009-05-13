package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbNotiesDAO;
import com.baosight.base.service.INotiesMgr;


public class NotiesMgrImpl implements INotiesMgr{
	private ITbNotiesDAO tbNotiesDAO;
	
	public void setTbNotiesDAO(ITbNotiesDAO tbNotiesDAO) {
		this.tbNotiesDAO = tbNotiesDAO;
	}

	public List findByParam(String param) {
		List messagesList=tbNotiesDAO.findByParam(param);
		return messagesList;
	}

}
