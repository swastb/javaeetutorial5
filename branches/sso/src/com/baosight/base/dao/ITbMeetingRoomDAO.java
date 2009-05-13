package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbMeetingroom;

public interface ITbMeetingRoomDAO {

	public abstract void save(TbMeetingroom transientInstance);

	public abstract void update(TbMeetingroom transientInstance);

	public abstract void delete(TbMeetingroom persistentInstance);

	public abstract TbMeetingroom findById(java.lang.String id);

	public abstract List findByExample(TbMeetingroom instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByRoomName(Object roomName);

	public abstract List findByLocation(Object location);

	public abstract List findByCapability(Object capability);

	public abstract List findByStatus(Object status);

	public abstract List findByRem(Object rem);

	public abstract List findByDept(Object dept);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findAll();

	public abstract TbMeetingroom merge(TbMeetingroom detachedInstance);

	public abstract void attachDirty(TbMeetingroom instance);

	public abstract void attachClean(TbMeetingroom instance);

	public List checkMeetingRoomName(String id, String value);

}