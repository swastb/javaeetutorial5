package com.baosight.base.service.impl;

import com.baosight.base.dao.ITbWrit2DAO;
import com.baosight.base.service.IWrit2Mgr;
import com.baosight.mode.TbWrit2;

public class Writ2MgrImpl implements IWrit2Mgr {
	
	private ITbWrit2DAO tbWrit2DAO;

	public void delete(TbWrit2 model) {
		tbWrit2DAO.delete(model);

	}

	public TbWrit2 findById(String id) {
		return tbWrit2DAO.findById(id);
	}

	public void save(TbWrit2 model) {
		tbWrit2DAO.save(model);
}

	public void update(TbWrit2 model) {
		tbWrit2DAO.update(model);
		}

	public ITbWrit2DAO getTbWrit2DAO() {
		return tbWrit2DAO;
	}

	public void setTbWrit2DAO(ITbWrit2DAO tbWrit2DAO) {
		this.tbWrit2DAO = tbWrit2DAO;
	}

}
