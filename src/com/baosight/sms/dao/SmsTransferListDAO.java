package com.baosight.sms.dao;

import java.util.List;

import com.baosight.sms.mode.SmsTransferList;

public interface SmsTransferListDAO {

	public abstract void save(SmsTransferList transientInstance);

	public abstract void delete(SmsTransferList persistentInstance);

	public abstract SmsTransferList findById(java.lang.String id);

	public abstract List findByExample(SmsTransferList instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySenderMobile(Object senderMobile);

	public abstract List findBySenderName(Object senderName);

	public abstract List findBySenderDept(Object senderDept);

	public abstract List findBySenderType(Object senderType);

	public abstract List findByBz1(Object bz1);

	public abstract List findByBz2(Object bz2);

	public abstract List findAll();

	public abstract SmsTransferList merge(SmsTransferList detachedInstance);

	public abstract void attachDirty(SmsTransferList instance);

	public abstract void attachClean(SmsTransferList instance);

}