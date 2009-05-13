package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbSmsSubscribe;



public interface ISmsSubscribeMgr {
	public void save(TbSmsSubscribe transientInstance);
	public List findAll() ;
	public List findJoinDepart(TbSmsSubscribe smsSubscribe);
	public void delete(TbSmsSubscribe persistentInstance) ;
}
