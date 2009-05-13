package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDeptlvl;

public interface IDeptlvlMgr {

	List findAll();

	TbDeptlvl find(String id);

	void updte(TbDeptlvl item);

	void delete(String id);

	void save(TbDeptlvl item);

	void updteMore(TbDeptlvl item,String oldname);

	void deleteMore(String id, String oldname);
	
	//部门级别管理重复验证
	public String checkDeptlvl(String id,String value,String flag);

}
