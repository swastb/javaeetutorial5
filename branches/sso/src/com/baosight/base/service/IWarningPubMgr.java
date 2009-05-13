package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbWarningPub;

public interface IWarningPubMgr {
//	修改
	public void update(TbWarningPub mode);
//	删除	
	public void delete(String id);
//	添加	
	public void save(TbWarningPub mode);
//	全查询	
	public List findAll();
//	根据ID查询
	public TbWarningPub findById(String id);
	public List findForQuery(TbWarningPub item);
}
