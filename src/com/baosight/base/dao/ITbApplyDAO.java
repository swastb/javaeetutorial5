package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbApply;

public interface ITbApplyDAO {

	//添加
	public abstract void save(TbApply transientInstance);

	//修改
	public abstract void update(TbApply transientInstance);

	//删除
	public abstract void delete(TbApply persistentInstance);

	//根据ID查询
	public abstract TbApply findById(java.lang.String id);

	//全查询
	public abstract List findAll();
	
	public abstract List findBySql(final String sql);

}