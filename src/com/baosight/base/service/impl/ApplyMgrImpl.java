package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbApplyDAO;
import com.baosight.base.service.IApplyMgr;
import com.baosight.mode.TbApply;

public class ApplyMgrImpl implements IApplyMgr {

	private ITbApplyDAO tbApplyDAO;

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbApplyDAO.findAll();
	}

	public TbApply findById(String id) {
		// TODO Auto-generated method stub
		return this.tbApplyDAO.findById(id);
	}

	public void save(TbApply model) {
		// TODO Auto-generated method stub
		this.tbApplyDAO.save(model);
	}

	public void update(TbApply model) {
		// TODO Auto-generated method stub
		this.tbApplyDAO.update(model);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbApplyDAO.delete(this.findById(id));
	}

	public ITbApplyDAO getTbApplyDAO() {
		return tbApplyDAO;
	}

	public void setTbApplyDAO(ITbApplyDAO tbApplyDAO) {
		this.tbApplyDAO = tbApplyDAO;
	}

	public List findByView() {
		String sql="select distinct t.processid,t.jdtime,t.slh,t.projectname,t.porcessstate from oademo.vw_xzxk t  where   t.processid  in (select tt.processid from oademo.vw_xzxk tt  where t.porcessstate='½áÊø') ";
		return this.tbApplyDAO.findBySql(sql);
	}
	public List findByViewAll(){
		String sql="select distinct(t.processid),t.jdtime,t.slh,t.projectname,t.porcessstate from oademo.vw_xzxk t where t.porcessstate='½áÊø'";
		return this.tbApplyDAO.findBySql(sql);
	}
	
	
}
