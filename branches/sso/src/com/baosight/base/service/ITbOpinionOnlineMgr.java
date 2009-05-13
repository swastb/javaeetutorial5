package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbOpinionOnline;

public interface ITbOpinionOnlineMgr {

	public void save(TbOpinionOnline transientInstance);
	
	public void update(TbOpinionOnline transientInstance);

	public void delete(TbOpinionOnline persistentInstance);

	public TbOpinionOnline findById(java.lang.String id) ;

	public List findByProperty(String propertyName, Object value);

	public List findAll() ;
	public List findOpinionSLWaitList(String subject) ;
	public List findOpinionSLProcessList(String subject) ;
	public List findOpinionSLOverList(String subject) ;
	public List findOpinionWaitList(String subject,String userId,String type) ;
	public List findOpinionOverList(String subject,String userId,String type) ;	
}
