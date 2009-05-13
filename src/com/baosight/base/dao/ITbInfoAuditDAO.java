package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbOpinionConsult;

public interface ITbInfoAuditDAO {
	public abstract List findByStatus(String condition);
	
	public List findAuditingCount();
	
	public abstract void save(TbOpinionConsult item);
	
	public abstract List findByFKId(String id);
	
	public abstract void update(TbOpinionConsult item);
	
	public abstract TbGovInfoPub findById(String id);
	
	public abstract void updateStatus(TbGovInfoPub item);
}
