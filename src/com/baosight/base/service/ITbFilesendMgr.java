package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbFilesend;

public interface ITbFilesendMgr {


	public void save(TbFilesend transientInstance);

	public void update(TbFilesend transientInstance);
	
	public void delete(TbFilesend persistentInstance);

	public TbFilesend findById(java.lang.String id);

	public List findByExample(TbFilesend instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
	public List findFileSendIn(String userId);
	public void update(String id,String userId);
}
