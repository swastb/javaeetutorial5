package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbConsultationOnline;

public interface ITbAppealOnlineDAO {

	public void save(TbAppealOnline transientInstance);

	public void update(TbAppealOnline transientInstance) ;
	
	public void delete(TbAppealOnline persistentInstance);

	public TbAppealOnline findById(java.lang.String id);

	public List findByExample(TbAppealOnline instance);
	

	
	public List findByProperty(String propertyName, Object value);

	public List findAll();
	public List findByNativeSql(String sql);
}
