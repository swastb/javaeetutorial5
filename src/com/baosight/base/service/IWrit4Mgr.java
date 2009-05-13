package com.baosight.base.service;

import com.baosight.mode.TbWrit4;

public interface IWrit4Mgr {

//	修改
	public void update(TbWrit4 model);

	//删除
	public void delete(TbWrit4 model);

	//添加
	public void save(TbWrit4 model);
	
    //根据ID查询
	public TbWrit4 findById(String id);
}
