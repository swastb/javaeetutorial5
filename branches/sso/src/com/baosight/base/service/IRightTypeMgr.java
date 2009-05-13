package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbRighttype;

public interface IRightTypeMgr {

	List findAll();
	
	//新增根据appsysID、funID查询
	List findByExample(TbRighttype instance);

	TbRighttype find(String id);

	void delete(String id);

	void save(TbRighttype item);

	void updte(TbRighttype item);
	
	//权限类型管理代码重复验证
	public String checkRighttypeCode(String id,String value,String funid);

}
