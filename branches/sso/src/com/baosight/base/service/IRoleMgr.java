package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbRole;

public interface IRoleMgr {

	List findAll();

	TbRole find(String id);

	void updte(TbRole item);

	void delete(String id);

	void save(TbRole item);
	
	public String checkName(String id,String name,String field);
	
	public List findByName(String name,String code);

}
