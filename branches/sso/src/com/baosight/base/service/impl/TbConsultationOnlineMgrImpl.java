package com.baosight.base.service.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbConsultationOnlineDAO;
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.mode.TbConsultationOnline;



public class TbConsultationOnlineMgrImpl  implements ITbConsultationOnlineMgr{
	
	private ITbConsultationOnlineDAO tbConsultationOnlineDAO;
	
	public void save(TbConsultationOnline transientInstance) {
		tbConsultationOnlineDAO.save(transientInstance);
	}

	public void delete(TbConsultationOnline persistentInstance) {
		tbConsultationOnlineDAO.delete(persistentInstance);
	}

	public TbConsultationOnline findById(java.lang.String id) {
		return tbConsultationOnlineDAO.findById(id);
	}

	public List findByExample(TbConsultationOnline instance) {
		return tbConsultationOnlineDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbConsultationOnlineDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbConsultationOnlineDAO.findAll();
	}
	
	public List findConsultationSLWaitList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_consultation_online t where t.subject like '%"
			+subject+"%' and t.status='100' order by t.ask_time desc";
		return tbConsultationOnlineDAO.findByNativeSql(sql);
	}

	public List findConsultationSLProcessList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_consultation_online t where t.subject like '%"
			+subject+"%' and t.status='200' order by t.ask_time desc";
		return tbConsultationOnlineDAO.findByNativeSql(sql);
	}
	public List findConsultationSLOverList(String subject) {
		String sql = "select t.id,t.asker,t.subject,t.ask_time from tb_consultation_online t where t.subject like '%"
			+subject+"%' and t.status='300' order by t.ask_time desc";
		return tbConsultationOnlineDAO.findByNativeSql(sql);
	}
	
	public List findConsultationWaitList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_CONSULTATION_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '0' and t.affair_type=10 and c.subject like '%"+subject+"%'";
		return tbConsultationOnlineDAO.findByNativeSql(sql);
	}
	public List findConsultationOverList(String subject,String userId,String type) {
		String sql = "select  c.id,c.asker,c.subject,c.ask_time,t.id as littleId"
		  +" from tb_public_affair_transact t"
		   +" left join TB_CONSULTATION_ONLINE c on t.affair_id=c.id"
		 +" where t.transactor = '"+userId+"'"
		   +" and t.type = '"+type+"'"
		   +" and t.status = '100' and t.affair_type=10 and c.subject like '%"+subject+"%'";
		return tbConsultationOnlineDAO.findByNativeSql(sql);
	}	
	public void setTbConsultationOnlineDAO(
			ITbConsultationOnlineDAO tbConsultationOnlineDAO) {
		this.tbConsultationOnlineDAO = tbConsultationOnlineDAO;
	}

	public void update(TbConsultationOnline transientInstance) {
		tbConsultationOnlineDAO.update(transientInstance);
		
	}
}