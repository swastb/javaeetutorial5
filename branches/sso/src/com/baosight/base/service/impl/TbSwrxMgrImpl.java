package com.baosight.base.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baosight.base.dao.TbSwrxDAO;
import com.baosight.base.service.TbSwrxMgr;
import com.baosight.mode.TbSwrx;

/**
 * Data access object (DAO) for domain model class TbSwrx.
 * 
 * @see com.baosight.mode.TbSwrx
 * @author MyEclipse Persistence Tools
 */

public class TbSwrxMgrImpl  implements TbSwrxMgr {
	private static final Log log = LogFactory.getLog(TbSwrxMgrImpl.class);
	private TbSwrxDAO tbSwrxDAO;
	
	public List findByHQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByIDStatus(String id, String status) {
		String sql="select sw.swrxid,sw.reflectpeople,sw.reflectcontent,sw.datehappen from Tb_Swrx sw where sw.status="+status;
		List list=this.tbSwrxDAO.findByHQL(sql);
		return list;
	}

	public void update(TbSwrx transientInstance) {
		this.tbSwrxDAO.update(transientInstance);
		
	}

	public TbSwrxDAO getTbSwrxDAO() {
		return tbSwrxDAO;
	}

	public void setTbSwrxDAO(TbSwrxDAO tbSwrxDAO) {
		this.tbSwrxDAO = tbSwrxDAO;
	}

	public TbSwrx findByID(Long id) {
		TbSwrx tbSwrx=this.tbSwrxDAO.findByID(id);
		return tbSwrx;
	}

	public List findByUserId(String id,long type) {
		String sql = "select  sw.swrxid,sw.reflectpeople,sw.reflectcontent,sw.datehappen,t.id"
			  +" from tb_public_affair_transact t"
			   +" left join TB_SWRX sw on t.affair_id=sw.swrxid"
			 +" where t.transactor = '"+id+"'"
			 +" and t.type = '"+type+"'"
			   +" and t.status = '0' ";
		return this.tbSwrxDAO.findByNativeSql(sql);
	}

	public List findByUserIdover(String id, long type) {
		String sql = "select  sw.swrxid,sw.reflectpeople,sw.reflectcontent,sw.datehappen,t.id"
			  +" from tb_public_affair_transact t"
			   +" left join TB_SWRX sw on t.affair_id=sw.swrxid"
			 +" where t.transactor = '"+id+"'"
			 +" and t.type = '"+type+"'"
			   +" and t.status = '100' ";
		return this.tbSwrxDAO.findByNativeSql(sql);
	}

	public void delete(TbSwrx persistentInstance) {
	this.tbSwrxDAO.delete(persistentInstance);
	}

	public List findBySubjectType(String subject, String type) {
	String sql="select sw.swrxid,sw.reflectpeople,sw.reflectcontent,sw.datehappen from Tb_Swrx sw where sw.status='"+type+"' and sw.reflectcontent like '%"+subject+"%'";
		return this.tbSwrxDAO.findByHQL(sql);
	}

	public List findBySubjectTypeZB(String id, String subject, long type) {
		String sql="";
		return null;
	}

	public List findBySubjectTypeZX(String id, String subject, long type) {
		// TODO Auto-generated method stub
		return null;
	}
}