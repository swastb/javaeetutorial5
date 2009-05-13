package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbWrit8DAO;
import com.baosight.base.service.IWrit8Mgr;
import com.baosight.mode.TbWrit8;

public class Writ8MgrImpl implements IWrit8Mgr {
	
	private ITbWrit8DAO tbWrit8DAO;

	public void delete(TbWrit8 model) {
		tbWrit8DAO.delete(model);

	}

	public TbWrit8 findById(String id) {
		return tbWrit8DAO.findById(id);
	}

	public void save(TbWrit8 model) {
		tbWrit8DAO.save(model);
}

	public void update(TbWrit8 model) {
		tbWrit8DAO.update(model);
		}

	public ITbWrit8DAO getTbWrit8DAO() {
		return tbWrit8DAO;
	}

	public void setTbWrit8DAO(ITbWrit8DAO tbWrit8DAO) {
		this.tbWrit8DAO = tbWrit8DAO;
	}

}
