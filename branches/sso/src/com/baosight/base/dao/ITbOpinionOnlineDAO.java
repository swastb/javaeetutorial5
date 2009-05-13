package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbOpinionOnline;

public interface ITbOpinionOnlineDAO {

	public void save(TbOpinionOnline transientInstance) ;
	
	public void update(TbOpinionOnline transientInstance) ;

	public void delete(TbOpinionOnline persistentInstance) ;

	public TbOpinionOnline findById(java.lang.String id) ;
	
	public List findByExample(TbOpinionOnline instance) ;

	public List findByProperty(String propertyName, Object value);
	public List findByNativeSql(String sql);
	public List findAll() ;
	
}
