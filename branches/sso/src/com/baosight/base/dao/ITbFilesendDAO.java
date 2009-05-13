package com.baosight.base.dao;

import java.util.List;
import com.baosight.mode.TbFilesend;


public interface ITbFilesendDAO {

	public void save(TbFilesend transientInstance);
	
	public void update(TbFilesend transientInstance);
	
	public void delete(TbFilesend persistentInstance);

	public TbFilesend findById(java.lang.String id);

	public List findByExample(TbFilesend instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
	
	public List findByNativeSql(String sql) ;
	public void update(String sql);
	
}