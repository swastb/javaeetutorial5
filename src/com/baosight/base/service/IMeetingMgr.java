package com.baosight.base.service;

import java.util.List;
import java.util.Map;

import com.baosight.mode.TbMeeting;

public interface IMeetingMgr 
{
	public List findAll();

	public TbMeeting findById(String id);

	public void updte(TbMeeting model);

	public void delete(String id);

	public void save(TbMeeting model);
	
	public List findByYearMonth(String yearMonth, String userDept,Map map);
	
	public List findMeetingRoom();

	public List findByYear(String year);
}
