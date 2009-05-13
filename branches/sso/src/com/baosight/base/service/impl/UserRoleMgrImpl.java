package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.base.service.IUserRoleMgr;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserRole;

public class UserRoleMgrImpl implements IUserRoleMgr {

	private ITbUserRoleDAO tbUserRoleDAO;
	
	private HashMap cache = new HashMap();

	public void setTbUserRoleDAO(ITbUserRoleDAO tbUserRoleDAO) {
		this.tbUserRoleDAO = tbUserRoleDAO;
	}

	public void save(TbUserRole item) {
		this.tbUserRoleDAO.save(item);
		String roleId = item.getRoleid();
		if (this.cache.containsKey(roleId)) {
			List temp = (List) this.cache.get(roleId);
			temp.add(item);
		} else {
			List temp = new ArrayList();
			temp.add(item);
			this.cache.put(roleId, temp);
		}
	}

	public List findAll() {
		return this.tbUserRoleDAO.findAll();
	}

	public List findByRoleId(String roleId, boolean inCache) {
		if (this.cache.containsKey(roleId) && inCache) {
			return (List) this.cache.get(roleId);
		} else {
			List temp = this.tbUserRoleDAO.findByRoleid(roleId);
			this.cache.put(roleId, temp);
			return temp;
		}
	}

	public void deleteByRoleId(String roleId) {
		for (Iterator iter = this.findByRoleId(roleId, false).iterator(); iter.hasNext(); ) {
			TbUserRole item = (TbUserRole) iter.next();
			this.tbUserRoleDAO.delete(item);
		}
		this.cache.remove(roleId);
	}
	/**
	 * 取用户所属的角色列表
	 * @param user
	 * @return
	 */
	public List getUserRoleList(TbUser user){
		return this.tbUserRoleDAO.getUserRoleList(user);
	}
}
