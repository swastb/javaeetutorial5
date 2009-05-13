package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbFilesendDAO;
import com.baosight.base.service.ITbFilesendMgr;
import com.baosight.mode.TbFilesend;

/**
 * Data access object (DAO) for domain model class TbFilesend.
 * 
 * @see com.baosight.mode.TbFilesend
 * @author MyEclipse Persistence Tools
 */

public class TbFilesendMgrImpl implements ITbFilesendMgr {

	private ITbFilesendDAO tbFilesendDAO;
	
	public void save(TbFilesend transientInstance){
		tbFilesendDAO.save(transientInstance);
	}

	public void delete(TbFilesend persistentInstance){
		tbFilesendDAO.delete(persistentInstance);
	}

	public TbFilesend findById(java.lang.String id){
		return tbFilesendDAO.findById(id);
	}

	public List findByExample(TbFilesend instance){
		return tbFilesendDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value){
		return tbFilesendDAO.findByProperty(propertyName, value);
	}

	public List findAll(){
		return tbFilesendDAO.findAll();
	}
	public List findFileSendIn(String userId) {
		 String	hql = "select t.id,(select u.name from tb_user u where u.id = t.sender_id) as sender_name," +
		 		"to_char(t.send_dt,'yyyy-mm-dd hh:mm:ss'),t.subject,t.IS_VIEW from tb_filesend t where dbms_lob.instr(t.receiver_id,'"+userId+"',1,1)>0"+
		 "or dbms_lob.instr(t.cc_id,'"+userId+"',1,1)>0 or dbms_lob.instr(t.st_id,'"+userId+"',1,1)>0 order by to_char(t.send_dt,'yyyy-mm-dd hh:mm:ss') desc";

		List objList = this.tbFilesendDAO.findByNativeSql(hql);
		return objList;
	}
	public void update(String id,String userId) {
		String	hql = "update tb_filesend t set t.receiver_id=replaceclob(t.receiver_id,'"+userId+
		",',''),t.cc_id=replaceclob(t.cc_id,'"+userId+",',''),t.st_id=replaceclob(t.st_id,'"+userId+
		",','') where t.id='"+id+"'";
		this.tbFilesendDAO.update(hql);
	}
	public void setTbFilesendDAO(ITbFilesendDAO tbFilesendDAO) {
		this.tbFilesendDAO = tbFilesendDAO;
	}

	public void update(TbFilesend transientInstance) {
		tbFilesendDAO.update(transientInstance);
	}
}