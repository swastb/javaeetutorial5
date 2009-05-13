package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbRighttypeDAO;
import com.baosight.base.service.IRightTypeMgr;
import com.baosight.mode.TbPstlvl;
import com.baosight.mode.TbRighttype;

public class RightTypeMgrImpl implements IRightTypeMgr {
	private ITbRighttypeDAO tbRighttypeDAO;

	public void setTbRighttypeDAO(ITbRighttypeDAO tbRighttypeDAO) {
		this.tbRighttypeDAO = tbRighttypeDAO;
	}

	public void delete(String id) {
		TbRighttype item = find(id);
		this.tbRighttypeDAO.delete(item);
		
	}

	public TbRighttype find(String id) {
		return this.tbRighttypeDAO.findById(id);
	}

	public List findAll() {
		return this.tbRighttypeDAO.findAll();
	}

	public void save(TbRighttype item) {
		this.tbRighttypeDAO.save(item);
	}

	public void updte(TbRighttype item) {
		this.tbRighttypeDAO.update(item);
	}

	public List findByExample(TbRighttype instance) {
		// TODO Auto-generated method stub
		return this.tbRighttypeDAO.findByExample(instance);
	}

	public String checkRighttypeCode(String id, String value, String funid) {
		List list=tbRighttypeDAO.checkRighttypeCode(id, value, funid);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}
	
}
