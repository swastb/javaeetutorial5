package com.baosight.base.service;

import com.baosight.mode.TbWrit9;

public interface IWrit9Mgr {

//	修改
	public void update(TbWrit9 model);

	//删除
	public void delete(TbWrit9 model);

	//添加
	public void save(TbWrit9 model);
	
    //根据ID查询
	public TbWrit9 findById(String id);
}
