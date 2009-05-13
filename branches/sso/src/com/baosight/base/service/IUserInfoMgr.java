package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbUserinfo;;

public interface IUserInfoMgr {

	boolean delete(String id);

	void save(TbUserinfo item);
	
	List find(String id);

	void update(TbUserinfo item);

	void deleteByUserId(String nodeId);
	void deleteUserRoleByUserId(String userId);
	public List findUserID(String userid);
}