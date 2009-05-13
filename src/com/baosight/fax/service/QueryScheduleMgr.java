package com.baosight.fax.service;

import java.util.List;

import com.baosight.fax.bean.ListSearchBean;
import com.baosight.fax.dao.TbFaxQueryScheduleDAO;
import com.baosight.fax.mode.TbFaxSchedule;

public interface QueryScheduleMgr {
	public List findListByCondition(String name,ListSearchBean searchBean);
	
	public TbFaxSchedule findById(String id);
}
