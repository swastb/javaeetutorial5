package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TFileAllZf;



public interface TFileAllZfMgr {
	public List findAll();
	
	public List findById(java.lang.Long id);
	public List findByIdList(Long id);
}
