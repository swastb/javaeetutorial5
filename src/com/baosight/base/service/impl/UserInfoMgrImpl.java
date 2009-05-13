package com.baosight.base.service.impl;

import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbUserRoleDAO;
import com.baosight.base.dao.ITbUserinfoDAO;
import com.baosight.base.service.IUserInfoMgr;
import com.baosight.mode.TbMeetingrecord;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserRole;
import com.baosight.mode.TbUserinfo;

;

public class UserInfoMgrImpl implements IUserInfoMgr {

	private ITbUserinfoDAO tbUserinfoDAO;
	private ITbUserRoleDAO tbUserRoleDAO;
	public void setTbUserinfoDAO(ITbUserinfoDAO tbUserinfoDAO) {
		this.tbUserinfoDAO = tbUserinfoDAO;
	}
	public void setTbUserRoleDAO(ITbUserRoleDAO tbUserRoleDAO) {
		this.tbUserRoleDAO = tbUserRoleDAO;
	}
	public boolean delete(String id) {
		TbUserinfo item = this.tbUserinfoDAO.findById(id);
		if (item == null) {
			return false;
		}
		this.tbUserinfoDAO.delete(item);
		return true;
	}

	public void save(TbUserinfo item) {
		this.tbUserinfoDAO.save(item);
	}

	public List find(String userid) {
		return this.tbUserinfoDAO.findByUserid(userid);
	}

	public void update(TbUserinfo item) {
		this.tbUserinfoDAO.update(item);
	}

	public void deleteByUserId(String userId) {
		for (Iterator iter = this.tbUserinfoDAO.findByUserid(userId).iterator(); iter
				.hasNext();) {
			this.tbUserinfoDAO.delete((TbUserinfo) iter.next());
		}
	}
	public void deleteUserRoleByUserId(String userId){
		List roleListOfUser=this.tbUserRoleDAO.findByUserid(userId);
		if(!roleListOfUser.isEmpty()||roleListOfUser!=null){
			for (Iterator iter = roleListOfUser.iterator(); iter.hasNext(); ) {
				TbUserRole item = (TbUserRole) iter.next();
				this.tbUserRoleDAO.delete(item);
				//this.cache.remove(item.getRoleid());
			}
		}
	}
	
//	通过USERID查找记录
	public List findUserID(String userid) {
		 String	hql = "select s.* from tb_userinfo s " +
		              "where s.userid = '" +
		              userid +
		              "' ";


		 List objList = tbUserinfoDAO.findByNativeSql(hql, TbUserinfo.class);

			return objList;

	}

}
