package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbSmsSubscribe;

public interface ITbSmsSubscribeDAO {
	public void save(TbSmsSubscribe transientInstance);
	public List findAll() ;
	public List findJoinDepart(TbSmsSubscribe smsSubscribe) ;
	public void delete(TbSmsSubscribe persistentInstance) ;
}
