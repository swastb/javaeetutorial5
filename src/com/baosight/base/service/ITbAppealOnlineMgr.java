package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbConsultationOnline;

public interface ITbAppealOnlineMgr {

	public void save(TbAppealOnline transientInstance) ;

	public void update(TbAppealOnline transientInstance) ;
	
	public void delete(TbAppealOnline persistentInstance);

	public TbAppealOnline findById(java.lang.String id);

	public List findByExample(TbAppealOnline instance) ;

	public List findByProperty(String propertyName, Object value) ;

	public List findAll() ;
	
	
	public List findAppealSLWaitList(String subject) ;
	public List findAppealSLProcessList(String subject) ;
	public List findAppealSLOverList(String subject) ;
	public List findAppealWaitList(String subject,String userId,String type) ;
	public List findAppealOverList(String subject,String userId,String type) ;
	public abstract long findCountAppealOverList(String subject) ;
}
