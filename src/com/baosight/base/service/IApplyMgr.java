package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbApply;

public interface IApplyMgr 
{
	//修改
	public void update(TbApply model);

	//删除
	public void delete(String id);

	//添加
	public void save(TbApply model);

	//全查询
	public List findAll();

	//根据ID查询
	public TbApply findById(String id);
	public List findByView();
	public List findByViewAll();

}
