package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbShareFile;

public interface ITbShareFileDAO {
	
	public void save(TbShareFile transientInstance) ;
	
	public void update(TbShareFile transientInstance) ;
	
	public void delete(TbShareFile persistentInstance) ;

	public TbShareFile findById(java.lang.String id);

	public List findByExample(TbShareFile instance) ;

	public List findByProperty(String propertyName, Object value) ;
	public List findByNativeSql(String sql);
	public List findAll() ;
}
