package com.baosight.base.service.impl;

import java.util.List;
import java.util.Map;

import com.baosight.base.dao.ITbAuthlvlDAO;
import com.baosight.base.service.IAuthlvlMgr;
import com.baosight.mode.TbAuthlvl;

public class AuthlvlMgrImpl implements IAuthlvlMgr {
	
	private ITbAuthlvlDAO tbAuthlvlDAO;

	public void setTbAuthlvlDAO(ITbAuthlvlDAO tbAuthlvlDAO) {
		this.tbAuthlvlDAO = tbAuthlvlDAO;
	}

	public void delete(String id) {
		this.tbAuthlvlDAO.delete(find(id));
	}

	public TbAuthlvl find(String id) {
		return tbAuthlvlDAO.findById(id);
	}

	public List findAll() {
		return this.tbAuthlvlDAO.findAll();
	}

	public void save(TbAuthlvl item) {
		this.tbAuthlvlDAO.save(item);
	}

	public void updte(TbAuthlvl item) {
		this.tbAuthlvlDAO.update(item);
	}

	public String checkAuthlvl(String id,String value,String flag) {
		
		List list=tbAuthlvlDAO.checkAuthlvl(id,value,flag);		
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}

}
