package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbOaHoliday;


public interface IOaHolidayMgr 
{
	public List findAll();

	public TbOaHoliday findById(String id);

	public void updte(TbOaHoliday model);

	public void delete(String id);

	public void save(TbOaHoliday model);
	
	public List listDate(String year, String month);
	
	public List findSysDate();
	
	public List findSunSat(String year);
	
	public List findYearArb(String year,String arb);
}
