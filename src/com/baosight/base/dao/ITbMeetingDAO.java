package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbMeeting;

public interface ITbMeetingDAO {

	public abstract void save(TbMeeting transientInstance);

	public abstract void delete(TbMeeting persistentInstance);

	public abstract TbMeeting findById(java.lang.String id);

	public abstract List findByExample(TbMeeting instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByMeetingSn(Object meetingSn);

	public abstract List findByTitle(Object title);

	public abstract List findByMeetingroom(Object meetingroom);

	public abstract List findByPresider(Object presider);

	public abstract List findByFee(Object fee);

	public abstract List findByParticipant(Object participant);

	public abstract List findByNotify(Object notify);

	public abstract List findByStatus(Object status);

	public abstract List findByLvl(Object lvl);

	public abstract List findByTopic(Object topic);

	public abstract List findByRem(Object rem);

	public abstract List findByDept(Object dept);

	public abstract List findByYearMonth(Object yearMonth);

	public abstract List findByAttr2(Object attr2);

	public abstract List findAll();

	public abstract TbMeeting merge(TbMeeting detachedInstance);

	public abstract void attachDirty(TbMeeting instance);

	public abstract void attachClean(TbMeeting instance);

	public abstract void update(TbMeeting instance);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

}