package com.baosight.base.dao;

import com.baosight.mode.TbWrit8;

public interface ITbWrit8DAO {

//	添加
	public abstract void save(TbWrit8 transientInstance);

	//修改
	public abstract void update(TbWrit8 transientInstance);

	//删除
	public abstract void delete(TbWrit8 persistentInstance);

	//根据ID查询
	public abstract TbWrit8 findById(java.lang.String id);
}
