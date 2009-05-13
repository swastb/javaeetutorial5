package com.baosight.services.impl;

import com.baosight.dao.TestDAO;
import com.baosight.services.TestService;

public class TestServiceImpl implements TestService {
	private TestDAO testDao;
	
	public void setTestDao(TestDAO testDao) {
		this.testDao = testDao;
	}

	public TestDAO getDao() {
		return this.testDao;
	}
}
