package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGovInfoPub;

public interface ITbGovInfoPubMgr 
{
	//更新
	public void update(TbGovInfoPub model);

	//删除
	public void delete(String id);

	//插入
	public void save(TbGovInfoPub model);
	
	//全查询
	public List findAll();

	//根据ID查询
	public TbGovInfoPub findById(String id);
	
	//
	public List findByProperty(String propertyName, Object value);

}
