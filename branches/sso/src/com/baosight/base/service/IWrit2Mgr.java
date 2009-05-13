package com.baosight.base.service;

import com.baosight.mode.TbWrit2;

public interface IWrit2Mgr {

//	修改
	public void update(TbWrit2 model);

	//删除
	public void delete(TbWrit2 model);

	//添加
	public void save(TbWrit2 model);
	
    //根据ID查询
	public TbWrit2 findById(String id);
}
