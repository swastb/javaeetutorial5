package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbOaHoliday;

public interface ITbOaHolidayDAO {

	public abstract void save(TbOaHoliday transientInstance);
	
	public abstract void update(TbOaHoliday item);

	public abstract void delete(TbOaHoliday persistentInstance);

	public abstract TbOaHoliday findById(java.lang.String id);

	public abstract List findByExample(TbOaHoliday instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAmPm(Object amPm);

	public abstract List findByDay(Object day);

	public abstract List findByDeptId(Object deptId);

	public abstract List findByDescription(Object description);

	public abstract List findByArb(Object arb);

	public abstract List findAll();

	public abstract TbOaHoliday merge(TbOaHoliday detachedInstance);

	public abstract void attachDirty(TbOaHoliday instance);

	public abstract void attachClean(TbOaHoliday instance);
	
	public abstract List listDate(String year, String month);
	public abstract List findSysDate();
	public abstract List findByNativeSql(String sql);

}