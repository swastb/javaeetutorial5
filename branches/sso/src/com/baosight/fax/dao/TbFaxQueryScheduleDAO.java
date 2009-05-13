package com.baosight.fax.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.fax.mode.TbFaxSchedule;

public interface TbFaxQueryScheduleDAO extends DAOHelper{
	public List findList(String sql);
	public TbFaxSchedule findById(java.lang.String id);
	
}
