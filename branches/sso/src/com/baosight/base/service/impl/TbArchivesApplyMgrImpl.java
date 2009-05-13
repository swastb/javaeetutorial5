package com.baosight.base.service.impl;

import java.util.List;
import com.baosight.base.dao.ITbArchivesApplyDAO;
import com.baosight.base.service.ITbArchivesApplyMgr;
import com.baosight.mode.TbArchivesApply;
import com.baosight.mode.TbVehiclesApply;


public class TbArchivesApplyMgrImpl  implements ITbArchivesApplyMgr{

	private ITbArchivesApplyDAO tbArchivesApplyDAO;

	public void save(TbArchivesApply transientInstance) {
		tbArchivesApplyDAO.save(transientInstance);
	}

	public void update(TbArchivesApply transientInstance) {
		// TODO Auto-generated method stub
		this.tbArchivesApplyDAO.update(transientInstance);
	}
	public void delete(TbArchivesApply persistentInstance) {
		tbArchivesApplyDAO.delete(persistentInstance);
	}

	public TbArchivesApply findById(java.lang.String id) {
		return tbArchivesApplyDAO.findById(id);
	}

	public List findByExample(TbArchivesApply instance) {
		return tbArchivesApplyDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbArchivesApplyDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbArchivesApplyDAO.findAll();
	}

	public ITbArchivesApplyDAO getTbArchivesApplyDAO() {
		return tbArchivesApplyDAO;
	}

	public void setTbArchivesApplyDAO(ITbArchivesApplyDAO tbArchivesApplyDAO) {
		this.tbArchivesApplyDAO = tbArchivesApplyDAO;
	}
}