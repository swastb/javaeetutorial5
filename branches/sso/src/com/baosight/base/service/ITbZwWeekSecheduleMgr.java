package com.baosight.base.service;

import java.util.Hashtable;
import java.util.List;

import com.baosight.base.service.impl.TbZwWeekSecheduleMgrImpl;
import com.baosight.mode.TbMeeting;
import com.baosight.mode.TbZwWeekSechedule;
import com.baosight.mode.TbUser;

public interface ITbZwWeekSecheduleMgr {

	List findAll();

	TbZwWeekSechedule find(String id);

	void updte(TbZwWeekSechedule item);

	void updatePerson(TbZwWeekSechedule item, TbUser user);

	void updateDept(TbZwWeekSechedule item, TbUser user);
	
	void updateDept(TbZwWeekSechedule item, TbUser user,TbMeeting model);

	void delete(String id);

	void savePerson(TbZwWeekSechedule item, TbUser user);

	void savaDept(TbZwWeekSechedule item, TbUser user);
	
	void savaDept(TbZwWeekSechedule item, TbUser user,TbMeeting model);

	void save(TbZwWeekSechedule item);

	List findByWeekOfYear(String weekofyear);

	List findByStartEndTime(String startTime, String endTime);

	List findByGroupByWeekOfYear();

	List findByExample(TbZwWeekSechedule item);
	
	List findPersonByExample(TbZwWeekSechedule item);

	List findByQuerySQL(Hashtable hashtable);
	
	List findPersonLast(TbUser user,Hashtable dateList);

}
