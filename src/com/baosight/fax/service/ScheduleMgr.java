package com.baosight.fax.service;

import java.util.List;

import com.baosight.fax.bean.ListSearchBean;
import com.baosight.fax.mode.TbFaxSchedule;

/**
 * <p>Decription:·¢ËÍ´«Õæ</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-15</p>
 */
public interface ScheduleMgr {

	public abstract void save(TbFaxSchedule instance);

	public abstract void delete(TbFaxSchedule instance);

	public abstract TbFaxSchedule findById(String id);

	public abstract List findByExample(TbFaxSchedule instance);

	public abstract List findAll();

	public abstract List findByCondition(ListSearchBean searchBean);
	public abstract List findByStatus();
	public abstract void update(TbFaxSchedule instance);
}
