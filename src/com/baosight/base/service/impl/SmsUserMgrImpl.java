package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbSmsUserDAO;
import com.baosight.base.service.ISmsUserMgr;

public class SmsUserMgrImpl implements ISmsUserMgr {
	public ITbSmsUserDAO tbSmsUserDao;

	public ITbSmsUserDAO getTbSmsUserDao() {
		return tbSmsUserDao;
	}

	public void setTbSmsUserDao(ITbSmsUserDAO tbSmsUserDao) {
		this.tbSmsUserDao = tbSmsUserDao;
	}

	public List findAllUserName() {
		// TODO Auto-generated method stub
		return tbSmsUserDao.findAllUserName();
	}

	public List findByUserName(String departId) {
		return tbSmsUserDao.findByUserName(departId);
	}
}
