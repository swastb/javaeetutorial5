package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbSwrx;

public interface TbSwrxMgr {
	public abstract void update(TbSwrx transientInstance);
	public abstract List findByIDStatus(String id,String status);
	public abstract List findByHQL(String sql);
	public abstract TbSwrx findByID(Long id);
	public abstract List findByUserId(String id,long type);
	public abstract List findByUserIdover(String id,long type);
	public abstract void delete(TbSwrx transientInstance);
	public abstract List findBySubjectType(String subject,String type);
	public abstract List findBySubjectTypeZB(String id,String subject,long type);
	public abstract List findBySubjectTypeZX(String id,String subject,long type);
}
