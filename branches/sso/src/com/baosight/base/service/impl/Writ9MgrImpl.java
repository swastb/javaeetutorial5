package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbWrit9DAO;
import com.baosight.base.service.IWrit9Mgr;
import com.baosight.mode.TbWrit9;

public class Writ9MgrImpl implements IWrit9Mgr {
	
	private ITbWrit9DAO tbWrit9DAO;

	public void delete(TbWrit9 model) {
		tbWrit9DAO.delete(model);

	}

	public TbWrit9 findById(String id) {
		return tbWrit9DAO.findById(id);
	}

	public void save(TbWrit9 model) {
		tbWrit9DAO.save(model);
}

	public void update(TbWrit9 model) {
		tbWrit9DAO.update(model);
		}

	public ITbWrit9DAO getTbWrit9DAO() {
		return tbWrit9DAO;
	}

	public void setTbWrit9DAO(ITbWrit9DAO tbWrit9DAO) {
		this.tbWrit9DAO = tbWrit9DAO;
	}

}
