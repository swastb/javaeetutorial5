package com.baosight.base.dao;

import com.baosight.mode.TbWrit2;

public interface ITbWrit2DAO {

//	添加
	public abstract void save(TbWrit2 transientInstance);

	//修改
	public abstract void update(TbWrit2 transientInstance);

	//删除
	public abstract void delete(TbWrit2 persistentInstance);

	//根据ID查询
	public abstract TbWrit2 findById(java.lang.String id);
}
