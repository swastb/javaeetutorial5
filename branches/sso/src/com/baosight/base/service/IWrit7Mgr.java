package com.baosight.base.service;

import com.baosight.mode.TbWrit7;

public interface IWrit7Mgr {

//	修改
	public void update(TbWrit7 model);

	//删除
	public void delete(TbWrit7 model);

	//添加
	public void save(TbWrit7 model);
	
    //根据ID查询
	public TbWrit7 findById(String id);
}
