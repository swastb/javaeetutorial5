package com.baosight.base.dao;

import com.baosight.mode.TbWrit4;

public interface ITbWrit4DAO {

//	添加
	public abstract void save(TbWrit4 transientInstance);

	//修改
	public abstract void update(TbWrit4 transientInstance);

	//删除
	public abstract void delete(TbWrit4 persistentInstance);

	//根据ID查询
	public abstract TbWrit4 findById(java.lang.String id);
}
