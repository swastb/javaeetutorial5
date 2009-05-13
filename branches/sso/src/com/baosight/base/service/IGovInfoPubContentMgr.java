package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGovInfoPubContent;

public interface IGovInfoPubContentMgr 
{
	//修改
	public void update(TbGovInfoPubContent model);

	//删除
	public void delete(String id);

	//添加
	public void save(TbGovInfoPubContent model);

	//全查询
	public List findAll();

	//根据ID查询
	public TbGovInfoPubContent findById(String id);

	public List findById(Long id);
	public List findByTitle(String title); 
	public List findAllInfo();

}
