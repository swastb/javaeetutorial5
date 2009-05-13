package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.dao.ITbUserlvlDAO;
import com.baosight.base.service.IUserlvlMgr;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbDeptlvl;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserinfo;
import com.baosight.mode.TbUserlvl;

public class UserlvlMgrImpl implements IUserlvlMgr {

	private ITbUserlvlDAO tbUserlvlDAO;

	private ITbUserDAO tbUserDAO;

	public void setTbUserlvlDAO(ITbUserlvlDAO tbUserlvlDAO) {
		this.tbUserlvlDAO = tbUserlvlDAO;
	}

	public void delete(String id) {
		this.tbUserlvlDAO.delete(find(id));
	}

	public TbUserlvl find(String id) {
		return tbUserlvlDAO.findById(id);
	}

	public List findAll() {
		return this.tbUserlvlDAO.findAll();
	}

	public void save(TbUserlvl item) {
		this.tbUserlvlDAO.save(item);
	}

	public void updte(TbUserlvl item) {
		this.tbUserlvlDAO.update(item);
	}

	public String checkUserlvl(String id, String value, String flag) {
		List list=tbUserlvlDAO.checkUserlvl(id, value, flag);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}


	public void updteMore(TbUserlvl item, String oldname) {
		// TODO Auto-generated method stub

		// 更新用户权限表
		this.tbUserlvlDAO.update(item);
		// 用户级别(tb_userlvl)修改时,根据其原name,在tb_user表中查询所有lvl字段为原name的记录，并将这些记录的lvl字段值更新为新name

		String newname = item.getName();
		// 查询lvl为旧name的对象
		List list = this.tbUserDAO.findByProperty("lvl", oldname);
		for (int i = 0; i < list.size(); i++) {
			TbUser tbUser = (TbUser) list.get(i);
			tbUser.setLvl(newname);

			this.tbUserDAO.save(tbUser);
		}
	}

	public void deleteMore(String id, String oldname) {
		// TODO Auto-generated method stub

		// 更新用户权限表
		TbUserlvl item = this.tbUserlvlDAO.findById(id);
		this.tbUserlvlDAO.delete(item);

		// 用户级别(tb_userlvl)删除时，根据其原name,在tb_user表中查询所有lvl字段为原name的记录,并将这些记录的lvl字段值清空
		List list = tbUserDAO.findByProperty("lvl", oldname);
		for (int i = 0; i < list.size(); i++) {
			TbUser tbUser = (TbUser) list.get(i);
			tbUser.setLvl(null);

			this.tbUserDAO.save(tbUser);
		}

	}

	public ITbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}

	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}

	public ITbUserlvlDAO getTbUserlvlDAO() {
		return tbUserlvlDAO;
	}

}
