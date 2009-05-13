package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbSmsSubscribeDAO;
import com.baosight.base.service.ISmsSubscribeMgr;
import com.baosight.mode.TbSmsSubscribe;

public class SmsSubscribeMgrImpl  implements ISmsSubscribeMgr{
    protected ITbSmsSubscribeDAO tbSmsSubscribeDAO ;
    
	public ITbSmsSubscribeDAO getTbSmsSubscribeDAO() {
		return tbSmsSubscribeDAO;
	}

	public void setTbSmsSubscribeDAO(ITbSmsSubscribeDAO tbSmsSubscribeDAO) {
		this.tbSmsSubscribeDAO = tbSmsSubscribeDAO;
	}

	public void save(TbSmsSubscribe transientInstance) {
		// TODO Auto-generated method stub
		tbSmsSubscribeDAO.save(transientInstance);
	}
	public List findAll() {
		return tbSmsSubscribeDAO.findAll();
	}
	public List findJoinDepart(TbSmsSubscribe smsSubscribe) {
		return tbSmsSubscribeDAO.findJoinDepart(smsSubscribe);
	}
	public void delete(TbSmsSubscribe persistentInstance) {
	    tbSmsSubscribeDAO.delete(persistentInstance);
	}
}
