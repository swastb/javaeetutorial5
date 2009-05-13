package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbWrit7DAO;
import com.baosight.base.service.IWrit7Mgr;
import com.baosight.mode.TbWrit7;

public class Writ7MgrImpl implements IWrit7Mgr {
	
	private ITbWrit7DAO tbWrit7DAO;

	public void delete(TbWrit7 model) {
		tbWrit7DAO.delete(model);

	}

	public TbWrit7 findById(String id) {
		return tbWrit7DAO.findById(id);
	}

	public void save(TbWrit7 model) {
		tbWrit7DAO.save(model);
}

	public void update(TbWrit7 model) {
		tbWrit7DAO.update(model);
		}

	public ITbWrit7DAO getTbWrit7DAO() {
		return tbWrit7DAO;
	}

	public void setTbWrit7DAO(ITbWrit7DAO tbWrit7DAO) {
		this.tbWrit7DAO = tbWrit7DAO;
	}

}
