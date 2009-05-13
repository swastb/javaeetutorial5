package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbPstlvl;

public interface IPstlvlMgr {

	public List findAll();

	public void save(TbPstlvl item);

	public void delete(String id);

	public TbPstlvl find(String id);

	public void update(TbPstlvl item);
	
	//职务等级重复验证
	public String checkPstlvl(String id,String name,String flag);
	
	public void updateMore(TbPstlvl item,String oldname);
	
	public void deleteMore(String id,String oldname);

}
