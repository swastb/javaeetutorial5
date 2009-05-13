package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbWrit4DAO;
import com.baosight.base.service.IWrit4Mgr;
import com.baosight.mode.TbWrit4;

public class Writ4MgrImpl implements IWrit4Mgr {
	
	private ITbWrit4DAO tbWrit4DAO;

	public void delete(TbWrit4 model) {
		tbWrit4DAO.delete(model);

	}

	public TbWrit4 findById(String id) {
		return tbWrit4DAO.findById(id);
	}

	public void save(TbWrit4 model) {
		tbWrit4DAO.save(model);
}

	public void update(TbWrit4 model) {
		tbWrit4DAO.update(model);
		}

	public ITbWrit4DAO getTbWrit4DAO() {
		return tbWrit4DAO;
	}

	public void setTbWrit4DAO(ITbWrit4DAO tbWrit4DAO) {
		this.tbWrit4DAO = tbWrit4DAO;
	}

}
