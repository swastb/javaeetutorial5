package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbOpinionOnlineDAO;
import com.baosight.base.service.ITbOpinionOnlineMgr;
import com.baosight.mode.TbOpinionOnline;

public class TbOpinionOnlineMgrImpl implements ITbOpinionOnlineMgr  {
	
	private ITbOpinionOnlineDAO tbOpinionOnlineDAO;

	public void save(TbOpinionOnline transientInstance) {
		tbOpinionOnlineDAO.save(transientInstance);
	}
	
	public void update(TbOpinionOnline transientInstance) {
		tbOpinionOnlineDAO.update(transientInstance);
	}

	public void delete(TbOpinionOnline persistentInstance) {
		tbOpinionOnlineDAO.delete(persistentInstance);
	}

	public TbOpinionOnline findById(java.lang.String id) {
		return tbOpinionOnlineDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbOpinionOnlineDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbOpinionOnlineDAO.findAll();
	}
	public List findOpinionSLWaitList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Opinion_online t where t.subject like '%"
			+subject+"%' and t.status='100' order by t.ask_time desc";
		return tbOpinionOnlineDAO.findByNativeSql(sql);
	}

	public List findOpinionSLProcessList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Opinion_online t where t.subject like '%"
			+subject+"%' and t.status='200' order by t.ask_time desc";
		return tbOpinionOnlineDAO.findByNativeSql(sql);
	}
	public List findOpinionSLOverList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Opinion_online t where t.subject like '%"
			+subject+"%' and t.status='300' order by t.ask_time desc";
		return tbOpinionOnlineDAO.findByNativeSql(sql);
	}
	
	public List findOpinionWaitList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_Opinion_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '0' and t.affair_type=20 and c.subject like '%"+subject+"%'";
		return tbOpinionOnlineDAO.findByNativeSql(sql);
	}
	public List findOpinionOverList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_Opinion_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '100' and t.affair_type=20 and c.subject like '%"+subject+"%'";
		return tbOpinionOnlineDAO.findByNativeSql(sql);
	}	
	public void setTbOpinionOnlineDAO(ITbOpinionOnlineDAO tbOpinionOnlineDAO) {
		this.tbOpinionOnlineDAO = tbOpinionOnlineDAO;
	}

}