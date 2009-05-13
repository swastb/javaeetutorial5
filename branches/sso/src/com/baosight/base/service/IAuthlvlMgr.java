package com.baosight.base.service;

import java.util.List;
import java.util.Map;

import com.baosight.mode.TbAuthlvl;

public interface IAuthlvlMgr {

	List findAll();

	TbAuthlvl find(String id);

	void updte(TbAuthlvl item);

	void delete(String id);

	void save(TbAuthlvl item);

	//权限级别管理重复验证
	public String checkAuthlvl(String id,String value,String flag);

}
