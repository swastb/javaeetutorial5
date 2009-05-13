package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGovInfoPubAudit;

public interface ITbGovInfoPubAuditMgr 
{
	//更新
	public void update(TbGovInfoPubAudit model);

	//删除
	public void delete(String id);

	//插入
	public void save(TbGovInfoPubAudit model);
	
	//全查询
	public List findAll();

	//根据ID查询
	public TbGovInfoPubAudit findById(String id);
	
	//
	public List findByProperty(String propertyName, Object value);

}
