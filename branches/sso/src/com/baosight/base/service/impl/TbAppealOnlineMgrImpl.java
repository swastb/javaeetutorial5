package com.baosight.base.service.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbAppealOnlineDAO;
import com.baosight.base.dao.ITbConsultationOnlineDAO;
import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbConsultationOnline;



public class TbAppealOnlineMgrImpl  implements ITbAppealOnlineMgr{
	
	private ITbAppealOnlineDAO tbAppealOnlineDAO;
	
	public void save(TbAppealOnline transientInstance) {
		tbAppealOnlineDAO.save(transientInstance);
	}

	public void delete(TbAppealOnline persistentInstance) {
		tbAppealOnlineDAO.delete(persistentInstance);
	}

	public TbAppealOnline findById(java.lang.String id) {
		return tbAppealOnlineDAO.findById(id);
	}

	public List findByExample(TbAppealOnline instance) {
		return tbAppealOnlineDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbAppealOnlineDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbAppealOnlineDAO.findAll();
	}
	
	public List findAppealSLWaitList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Appeal_online t where t.subject like '%"
			+subject+"%' and t.status='100' order by t.ask_time desc";
		return tbAppealOnlineDAO.findByNativeSql(sql);
	}

	public List findAppealSLProcessList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Appeal_online t where t.subject like '%"
			+subject+"%' and t.status='200' order by t.ask_time desc";
		return tbAppealOnlineDAO.findByNativeSql(sql);
	}
	public List findAppealSLOverList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_Appeal_online t where t.subject like '%"
			+subject+"%' and t.status='300' order by t.ask_time desc";
		return tbAppealOnlineDAO.findByNativeSql(sql);
	}
	
	public List findAppealWaitList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_Appeal_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '0' and t.affair_type=20 and c.subject like '%"+subject+"%'";
		return tbAppealOnlineDAO.findByNativeSql(sql);
	}
	public List findAppealOverList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_Appeal_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '100' and t.affair_type=20 and c.subject like '%"+subject+"%'";
		return tbAppealOnlineDAO.findByNativeSql(sql);
	}	
	public void setTbAppealOnlineDAO(
			ITbAppealOnlineDAO tbAppealOnlineDAO) {
		this.tbAppealOnlineDAO = tbAppealOnlineDAO;
	}

	public void update(TbAppealOnline transientInstance) {
		tbAppealOnlineDAO.update(transientInstance);
		
	}
	public long findCountAppealOverList(String subject) {
		String sql="";
		long count=this.tbAppealOnlineDAO.findByNativeSql(sql).size();
		return count;
	}
	
}