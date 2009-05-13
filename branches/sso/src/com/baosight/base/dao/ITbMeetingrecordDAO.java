package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbMeetingrecord;;

public interface ITbMeetingrecordDAO {

	public void save(TbMeetingrecord transientInstance);

	public void delete(TbMeetingrecord persistentInstance);
	public void update(TbMeetingrecord persistentInstance);
	public TbMeetingrecord findById(java.lang.String id);

	public List findByExample(TbMeetingrecord instance);
	public abstract List findByNativeSql(String sql, Class entity);
	
	public List findAll();
}
