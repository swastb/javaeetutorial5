package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbConsultationOnline;

public interface ITbConsultationOnlineMgr {

	public void save(TbConsultationOnline transientInstance) ;

	public void update(TbConsultationOnline transientInstance) ;
	
	public void delete(TbConsultationOnline persistentInstance);

	public TbConsultationOnline findById(java.lang.String id);

	public List findByExample(TbConsultationOnline instance) ;

	public List findByProperty(String propertyName, Object value) ;

	public List findAll() ;
	
	public List findConsultationSLWaitList(String subject) ;
	public List findConsultationSLProcessList(String subject) ;
	public List findConsultationSLOverList(String subject) ;
	public List findConsultationWaitList(String subject,String userId,String type) ;
	public List findConsultationOverList(String subject,String userId,String type) ;
}
