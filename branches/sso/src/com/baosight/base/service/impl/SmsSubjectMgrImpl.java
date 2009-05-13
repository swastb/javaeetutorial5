package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbSmsSubjectDAO;
import com.baosight.base.service.ISmsSubjectMgr;

public class SmsSubjectMgrImpl implements ISmsSubjectMgr{
  
	 ITbSmsSubjectDAO tbSmSubjectDAO ;
	
	
	public ITbSmsSubjectDAO getTbSmSubjectDAO() {
		return tbSmSubjectDAO;
	}


	public void setTbSmSubjectDAO(ITbSmsSubjectDAO tbSmSubjectDAO) {
		this.tbSmSubjectDAO = tbSmSubjectDAO;
	}


	public List findAllSuject(String state) {
		// TODO Auto-generated method stub
		return tbSmSubjectDAO.findAllSuject(state);
	}

}
