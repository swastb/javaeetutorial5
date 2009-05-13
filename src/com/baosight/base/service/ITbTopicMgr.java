package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbTopic;


public interface ITbTopicMgr{

	public void save(TbTopic transientInstance);

	public void delete(TbTopic persistentInstance);
	
	public TbTopic findById(java.lang.String id);

	public List findByExample(TbTopic instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}