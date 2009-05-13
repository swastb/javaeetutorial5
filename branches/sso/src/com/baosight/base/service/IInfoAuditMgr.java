package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbOpinionConsult;

public interface IInfoAuditMgr {
	
	public List findByStatus(String condition);
	
	public void save(TbOpinionConsult item);
	
	public List findOpinionListByFKId(String id);
	
	public void modify(TbOpinionConsult item);
	
	public TbGovInfoPub findById(String id);
	
	public void modifyStatus(TbGovInfoPub item);
	
	public int findAuditingCount();
}

