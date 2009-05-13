package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbAppsysDAO;
import com.baosight.base.dao.ITbFunctionDAO;
import com.baosight.base.dao.ITbUserAppsysDAO;
import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.service.IUserAppsysMgr;
import com.baosight.mode.TbUserAppsys;

public class UserAppsysMgrImpl implements IUserAppsysMgr {

	private ITbUserAppsysDAO tbUserAppsysDAO;

	private ITbUserDAO tbUserDAO;

	private ITbAppsysDAO tbAppsysDAO;

	private ITbFunctionDAO tbFunctionDAO;

	public ITbAppsysDAO getTbAppsysDAO() {
		return tbAppsysDAO;
	}

	public void setTbAppsysDAO(ITbAppsysDAO tbAppsysDAO) {
		this.tbAppsysDAO = tbAppsysDAO;
	}

	public ITbFunctionDAO getTbFunctionDAO() {
		return tbFunctionDAO;
	}

	public void setTbFunctionDAO(ITbFunctionDAO tbFunctionDAO) {
		this.tbFunctionDAO = tbFunctionDAO;
	}

	public ITbUserAppsysDAO getTbUserAppsysDAO() {
		return tbUserAppsysDAO;
	}

	public void setTbUserAppsysDAO(ITbUserAppsysDAO tbUserAppsysDAO) {
		this.tbUserAppsysDAO = tbUserAppsysDAO;
	}

	public ITbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}

	public void delete(TbUserAppsys tbUserAppsys) {
		// TODO Auto-generated method stub
		tbUserAppsysDAO.delete(tbUserAppsys);
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		TbUserAppsys tbUserAppsys = findById(id);
		tbUserAppsysDAO.delete(tbUserAppsys);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return tbUserAppsysDAO.findAll();
	}

	public TbUserAppsys findById(String id) {
		// TODO Auto-generated method stub
		return tbUserAppsysDAO.findById(id);
	}

	public void save(TbUserAppsys tbUserAppsys) {
		// TODO Auto-generated method stub
		tbUserAppsysDAO.save(tbUserAppsys);
	}

	public void update(TbUserAppsys tbUserAppsys) {
		// TODO Auto-generated method stub
		tbUserAppsysDAO.attachDirty(tbUserAppsys);
	}

}
