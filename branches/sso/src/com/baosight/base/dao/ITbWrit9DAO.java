package com.baosight.base.dao;

import com.baosight.mode.TbWrit9;

public interface ITbWrit9DAO {

//	添加
	public abstract void save(TbWrit9 transientInstance);

	//修改
	public abstract void update(TbWrit9 transientInstance);

	//删除
	public abstract void delete(TbWrit9 persistentInstance);

	//根据ID查询
	public abstract TbWrit9 findById(java.lang.String id);
}
