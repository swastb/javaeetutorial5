package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbPstDAO;
import com.baosight.base.dao.ITbPstlvlDAO;
import com.baosight.base.service.IPstlvlMgr;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbPstlvl;

public class PstlvlMgrImpl implements IPstlvlMgr {

	ITbPstlvlDAO tbPstlvlDAO;

	ITbPstDAO tbPstDAO;

	public ITbPstDAO getTbPstDAO() {
		return tbPstDAO;
	}

	public void setTbPstDAO(ITbPstDAO tbPstDAO) {
		this.tbPstDAO = tbPstDAO;
	}

	public ITbPstlvlDAO getTbPstlvlDAO() {
		return tbPstlvlDAO;
	}

	public void setTbPstlvlDAO(ITbPstlvlDAO tbPstlvlDAO) {
		this.tbPstlvlDAO = tbPstlvlDAO;
	}

	public List findAll() {
		return this.tbPstlvlDAO.findAll();
	}

	public void save(TbPstlvl item) {
		this.tbPstlvlDAO.save(item);
	}

	public void delete(String id) {
		TbPstlvl item = this.tbPstlvlDAO.findById(id);
		this.tbPstlvlDAO.delete(item);
	}

	public TbPstlvl find(String id) {
		return this.tbPstlvlDAO.findById(id);
	}

	public void update(TbPstlvl item) {

		this.tbPstlvlDAO.update(item);
	}


	public String checkPstlvl(String id, String name,String flag) {
		List list=tbPstlvlDAO.checkPstlvl(id,name,flag);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}

	public void updateMore(TbPstlvl item, String oldname) {
		// TODO Auto-generated method stub
		
		// 更新职务表
		this.tbPstlvlDAO.update(item);
		// 职务(tb_pstlvl)等级修改时，根据其原name,在tb_pst表中查询所有lvl字段为原name的记录,并将这些记录的lvl字段值更新为新name
		String newname=item.getName();
		// 查询lvl为旧name的对象
		List list = tbPstDAO.findByProperty("lvl", oldname );
		for(int i=0;i<list.size();i++){
			TbPst tbPst=(TbPst)list.get(i);
			tbPst.setLvl(newname);
			
			this.tbPstDAO.save(tbPst);
		}
		
	}

	public void deleteMore(String id, String oldname) {
		// TODO Auto-generated method stub
		//删除职务表
		TbPstlvl item = this.tbPstlvlDAO.findById(id);
		this.tbPstlvlDAO.delete(item);
		
		//职务(tb_pstlvl)等级删除时，根据其原name,在tb_pst表中查询所有lvl字段为原name的记录,并将这些记录的lvl字段值清空
		List list = tbPstDAO.findByProperty("lvl", oldname );
		for(int i=0;i<list.size();i++){
			TbPst tbPst=(TbPst)list.get(i);
			tbPst.setLvl(null);
			
			this.tbPstDAO.save(tbPst);
		}
		
	}

}
