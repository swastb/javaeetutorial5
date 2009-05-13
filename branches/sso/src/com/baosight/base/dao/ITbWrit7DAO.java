package com.baosight.base.dao;

import com.baosight.mode.TbWrit7;

public interface ITbWrit7DAO {

//	添加
	public abstract void save(TbWrit7 transientInstance);

	//修改
	public abstract void update(TbWrit7 transientInstance);

	//删除
	public abstract void delete(TbWrit7 persistentInstance);

	//根据ID查询
	public abstract TbWrit7 findById(java.lang.String id);
}
