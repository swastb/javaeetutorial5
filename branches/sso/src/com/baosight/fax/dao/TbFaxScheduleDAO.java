package com.baosight.fax.dao;

import java.util.List;

import com.baosight.base.dao.DAOHelper;
import com.baosight.fax.mode.TbFaxSchedule;

public interface TbFaxScheduleDAO extends DAOHelper {

	public abstract void save(TbFaxSchedule transientInstance);

	public abstract void delete(TbFaxSchedule persistentInstance);

	public abstract TbFaxSchedule findById(java.lang.String id);

	public abstract List findByExample(TbFaxSchedule instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByContent(Object content);

	public abstract List findBySender(Object sender);

	public abstract List findBySenderid(Object senderid);

	public abstract List findByFax(Object fax);

	public abstract List findBySendtype(Object sendtype);

	public abstract List findByState(Object state);

	public abstract List findByRecman(Object recman);

	public abstract List findByRecmanid(Object recmanid);

	public abstract List findByRecgroupid(Object recgroupid);

	public abstract List findBySenddeptid(Object senddeptid);

	public abstract List findByFaxflag(Object faxflag);

	public abstract List findAll();

	public abstract TbFaxSchedule merge(TbFaxSchedule detachedInstance);

	public abstract void attachDirty(TbFaxSchedule instance);

	public abstract void attachClean(TbFaxSchedule instance);
	public abstract List findByHql(String sql);
	public abstract void update(TbFaxSchedule instance);
}