package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbSmsSchedule;

public interface ITbSmsScheduleDAO {

	public static final String SYSTYPE = "systype";

	public abstract void save(TbSmsSchedule transientInstance);

	public abstract void delete(TbSmsSchedule persistentInstance);

	public abstract TbSmsSchedule findById(java.lang.String id);

	public abstract List findByExample(TbSmsSchedule instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByDestNumber(Object destNumber);

	public abstract List findByMessageContent(Object messageContent);

	public abstract List findBySystype(Object systype);

	public abstract List findByFlag(Object flag);

	public abstract List findByDepartid(Object departid);

	public abstract List findBySenduserid(Object senduserid);

	public abstract List findBySenddepartid(Object senddepartid);

	public abstract List findByBz(Object bz);

	public abstract List findBySendBy(Object sendBy);

	public abstract List findAll();

	public abstract TbSmsSchedule merge(TbSmsSchedule detachedInstance);

	public abstract void attachDirty(TbSmsSchedule instance);

	public abstract void attachClean(TbSmsSchedule instance);
	
	public List findSmsRecord(TbSmsSchedule tss,String startTime,String endTime);

}