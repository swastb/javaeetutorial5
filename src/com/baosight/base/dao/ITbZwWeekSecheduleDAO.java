package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbZwWeekSechedule;

public interface ITbZwWeekSecheduleDAO {

	public abstract void save(TbZwWeekSechedule transientInstance);
	
	public abstract void update(TbZwWeekSechedule transientInstance); 

	public abstract void delete(TbZwWeekSechedule persistentInstance);

	public abstract TbZwWeekSechedule findById(java.lang.String id);

	public abstract List findByExample(TbZwWeekSechedule instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByItemTitle(Object itemTitle);

	public abstract List findByItemType(Object itemType);

	public abstract List findByDept(Object dept);

	public abstract List findByAttendance(Object attendance);

	public abstract List findByUserId(Object userId);

	public abstract List findByPromulgator(Object promulgator);

	public abstract List findByOrigin(Object origin);

	public abstract List findByCreateTime(Object createTime);

	public abstract List findByRem(Object rem);

	public abstract List findByAttr2(Object attr2);
	
	public abstract List findByAttr3(Object attr3);
	
	public abstract List findByContent(Object content);

	public abstract List findByWeekofyear(Object weekofyear);
	
	public abstract List findByColorFlag(Object colorflag);
	
	public abstract List findByDeptId(Object deptId);
	
	public abstract List findByPrivateUserId(Object privateUserId);
	
	public abstract List findByIsChild(Object isChild);
	
	public abstract List findByPId(Object pid);

	public abstract List findAll();
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	
	public List findByNativeSql(String sql);
	
	public List findByNativeSql(String sql,Class entity);

	public List findByNativeSql1(String sql);

	public abstract TbZwWeekSechedule merge(TbZwWeekSechedule detachedInstance);

	public abstract void attachDirty(TbZwWeekSechedule instance);

	public abstract void attachClean(TbZwWeekSechedule instance);

}