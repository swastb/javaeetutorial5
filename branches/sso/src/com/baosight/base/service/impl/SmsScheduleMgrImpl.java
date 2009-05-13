package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbSmsScheduleDAO;
import com.baosight.base.service.ISmsScheduleMgr;
import com.baosight.mode.TbSmsSchedule;

public class SmsScheduleMgrImpl implements ISmsScheduleMgr{
	private ITbSmsScheduleDAO tbSmsScheduleDAO;
	
	public ITbSmsScheduleDAO getTbSmsScheduleDAO() {
		return tbSmsScheduleDAO;
	}

	public void setTbSmsScheduleDAO(ITbSmsScheduleDAO tbSmsScheduleDAO) {
		this.tbSmsScheduleDAO = tbSmsScheduleDAO;
	}

	public void save (TbSmsSchedule instance){
		tbSmsScheduleDAO.save(instance);
	}

	public List findAll() {
		return tbSmsScheduleDAO.findAll();
	}
	public List findSmsRecord(TbSmsSchedule tss,String startTime,String endTime){
		return tbSmsScheduleDAO.findSmsRecord(tss, startTime, endTime);
	}
}
