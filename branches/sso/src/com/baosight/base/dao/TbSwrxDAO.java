package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbSwrx;

public interface TbSwrxDAO {
	//ÐÞ¸Ä
	public abstract void update(TbSwrx transientInstance);
	public abstract List findByIDStatus(String id,String status);
	public abstract List findByHQL(String sql);
	public abstract TbSwrx findByID(Long id);
	public List findByNativeSql(String sql);
	public abstract void delete(TbSwrx transientInstance);
}
