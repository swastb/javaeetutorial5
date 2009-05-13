package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbRoleDAO;
import com.baosight.base.service.IRoleMgr;
import com.baosight.mode.TbRole;

public class RoleMgrImpl implements IRoleMgr {
	private ITbRoleDAO tbRoleDAO;

	public void setTbRoleDAO(ITbRoleDAO tbRoleDAO) {
		this.tbRoleDAO = tbRoleDAO;
	}

	public void delete(String id) {
		TbRole item = find(id);
		this.tbRoleDAO.delete(item);
	}

	public TbRole find(String id) {
		return this.tbRoleDAO.findById(id);
	}

	public List findAll() {
		return this.tbRoleDAO.findAll();
	}

	public void save(TbRole item) {
		this.tbRoleDAO.save(item);
	}

	public void updte(TbRole item) {
		this.tbRoleDAO.update(item);
	}
	
	public String checkName(String id, String name,String field) {
		List list=tbRoleDAO.checkName(id,name,field);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		System.out.println("-----------checkMessage----------"+checkMessage);
		return checkMessage;
	}

	public List findByName(String name, String code) {
		String hql="from TbRole model where model.name like '%"+name+"%' and model.code like '%"+code+"%'";
		return this.tbRoleDAO.findByHQL(hql, true, -1, -1);
	}
}
