package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbConsultationOnline;

public interface ITbConsultationOnlineDAO {

	public void save(TbConsultationOnline transientInstance);

	public void update(TbConsultationOnline transientInstance) ;
	
	public void delete(TbConsultationOnline persistentInstance);

	public TbConsultationOnline findById(java.lang.String id);

	public List findByExample(TbConsultationOnline instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
	public List findByNativeSql(String sql);
}
