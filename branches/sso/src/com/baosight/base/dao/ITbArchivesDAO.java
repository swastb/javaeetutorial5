package com.baosight.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.baosight.mode.TbArchives;



public interface ITbArchivesDAO  {
	
	public void save(TbArchives transientInstance);

	public void delete(TbArchives persistentInstance);
	public void update(TbArchives persistentInstance);
	public TbArchives findById(java.lang.String id);

	public List findByExample(TbArchives instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	public abstract List findByNativeSql(String sql);
	
	public List findByObjects(Object entity);
	
	public Object findById(Class entity,Serializable primaryKey);
	

}