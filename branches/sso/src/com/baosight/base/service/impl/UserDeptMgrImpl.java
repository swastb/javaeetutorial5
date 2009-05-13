package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.base.dao.ITbUserdeptDAO;
import com.baosight.base.service.IUserDeptMgr;
import com.baosight.base.service.IUserRoleMgr;
import com.baosight.mode.TbUserRole;
import com.baosight.mode.TbUserdept;

public class UserDeptMgrImpl implements IUserDeptMgr {
	
	private ITbUserdeptDAO tbUserdeptDAO;

	public ITbUserdeptDAO getTbUserdeptDAO() {
		return tbUserdeptDAO;
	}

	public void setTbUserdeptDAO(ITbUserdeptDAO tbUserdeptDAO) {
		this.tbUserdeptDAO = tbUserdeptDAO;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public TbUserdept find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbUserdeptDAO.findAll();
	}

	public void save(TbUserdept item) {
		// TODO Auto-generated method stub
		
	}

	public void updte(TbUserdept item) {
		// TODO Auto-generated method stub
		
	}
	
}
