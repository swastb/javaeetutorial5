package com.baosight.sms.dao;

import java.util.List;

import com.baosight.sms.mode.SmsTransferInfo;

public interface SmsTransferInfoDAO {

	public abstract void save(SmsTransferInfo transientInstance);

	public abstract void delete(SmsTransferInfo persistentInstance);

	public abstract SmsTransferInfo findById(java.lang.String id);

	public abstract List findByExample(SmsTransferInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByReceiveMobile(Object receiveMobile);

	public abstract List findByReceiveName(Object receiveName);

	public abstract List findByReceiveDept(Object receiveDept);

	public abstract List findBySenderMobile(Object senderMobile);

	public abstract List findByBz(Object bz);

	public abstract List findByReceiveType(Object receiveType);

	public abstract List findAll();

	public abstract SmsTransferInfo merge(SmsTransferInfo detachedInstance);

	public abstract int exeSql(String sql);

	public abstract List findByHQL(String hql, boolean cacheable,
			int startIndex, int maxResultCount);

	public abstract List findBySQL(String sql);

	public abstract void attachDirty(SmsTransferInfo instance);

	public abstract void attachClean(SmsTransferInfo instance);

}