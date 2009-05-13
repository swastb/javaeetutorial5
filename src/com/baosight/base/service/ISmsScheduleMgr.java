package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbSmsSchedule;

public interface ISmsScheduleMgr {
	public void save (TbSmsSchedule instance);
	public  List findAll();
	public List findSmsRecord(TbSmsSchedule tss,String startTime,String endTime);
}
