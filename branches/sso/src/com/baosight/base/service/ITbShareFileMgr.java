package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbShareFile;

public interface ITbShareFileMgr {
	
	public void save(TbShareFile transientInstance);
	
	public void update(TbShareFile transientInstance);

	
	public void delete(TbShareFile persistentInstance) ;

	public TbShareFile findById(java.lang.String id) ;
	
	public List findByProperty(String propertyName, Object value);
	public List findShareFileList(String type,String userId);
	public List findAll() ;
}
