package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbSmsDepartDAO;
import com.baosight.base.service.ISmsDepartMgr;

public class SmsDepartMgrImpl implements ISmsDepartMgr{
	private ITbSmsDepartDAO tbSmsDepartDao;
	public ITbSmsDepartDAO getTbSmsDepartDao() {
		return tbSmsDepartDao;
	}
	public void setTbSmsDepartDao(ITbSmsDepartDAO tbSmsDepartDao) {
		this.tbSmsDepartDao = tbSmsDepartDao;
	}
	public List findAllDepartName() {
		return tbSmsDepartDao.findAllDepartName();
		
	}
	
}
