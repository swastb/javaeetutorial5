package com.baosight.base.service;

import com.baosight.mode.TbWrit8;

public interface IWrit8Mgr {

//	修改
	public void update(TbWrit8 model);

	//删除
	public void delete(TbWrit8 model);

	//添加
	public void save(TbWrit8 model);
	
    //根据ID查询
	public TbWrit8 findById(String id);
}
