package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baosight.base.dao.ITbCommonalityCommDAO;
import com.baosight.base.service.ICommonalityCommMgr;
import com.baosight.mode.TbCommonalityComm;

public class CommonalityCommMgrImpl implements ICommonalityCommMgr {

	private ITbCommonalityCommDAO tbCommonalityCommDAO;
	
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbCommonalityCommDAO.delete(this.findById(id));
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbCommonalityCommDAO.findAll();
	}

	public TbCommonalityComm findById(String id) {
		// TODO Auto-generated method stub
		return this.tbCommonalityCommDAO.findById(id);
	}

	public void save(TbCommonalityComm model) {
		// TODO Auto-generated method stub
		this.tbCommonalityCommDAO.save(model);
	}

	public void updte(TbCommonalityComm model) {
		// TODO Auto-generated method stub
		this.tbCommonalityCommDAO.update(model);
	}

	public ITbCommonalityCommDAO getTbCommonalityCommDAO() {
		return tbCommonalityCommDAO;
	}

	public void setTbCommonalityCommDAO(ITbCommonalityCommDAO tbCommonalityCommDAO) {
		this.tbCommonalityCommDAO = tbCommonalityCommDAO;
	}

	//查询同一系统一级组
	public List findByCommType(String parentId,String belong,String flag) {
		
		String sql="select * from (select * from Tb_Commonality_Comm start with id='"+parentId+"' " +
				"connect by prior id=parent_Id and belong='"+belong+"' order by level) t where t.id!='"+parentId+"'";
		
		return this.tbCommonalityCommDAO.findBySql(sql);
		
	}

	//根据输入组类型和组名称查询
	public List findByComm(String parentId,String name) {
		
		String sql="select * from Tb_Commonality_Comm where name like '%"+name+"%'";
		return this.tbCommonalityCommDAO.findBySql(sql);
	}

	//查询二级名称
	public List findByParentId(String commonalityId) {
		String hql="from TbCommonalityComm model where model.parentId='"+commonalityId+"' and model.inuse=1";
		return this.tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
	}

	public List findMenu(String belong) {  
		String hql="from TbCommonalityComm model where model.belong='"+belong+"' and model.inuse=1";
		return this.tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
	}
	
	//组名重复验证
	public String checkName(String id, String pid, String name) {
		
		String hql ="";
		//id为空为添加
		if(id.equals(""))
		{
			if(pid.equals("一级组"))
			{
				hql="from TbCommonalityComm as model where model.name='"+name+"' and model.parentId is null";
			}
			else
			{
				hql="from TbCommonalityComm as model where model.name='"+name+"' and model.parentId='"+pid+"'";
			}
		}
		else
		{
			if(pid.equals("一级组"))
			{
				hql="from TbCommonalityComm as model where model.name='"+name+"' and model.id!='"+id+"' and model.parentId is null";
			}
			else
			{
				hql="from TbCommonalityComm as model where model.name='"+name+"' and model.id!='"+id+"' and model.parentId='"+pid+"'";
			}
			
		}
		
		List list=tbCommonalityCommDAO.findByHQL(hql,true, -1, -1);	
		
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}
	public List findAllForTree(String id) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String hql = "";
		if (id != null) {
			if (id.equals("0")) {
				hql = "from TbCommonalityComm model where model.parentId is null and model.inuse=1";
				list = tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
			} else {
				TbCommonalityComm instance = tbCommonalityCommDAO.findById(id);
				if (instance != null) {
					hql = "from TbCommonalityComm model where model.parentId='"
							+ instance.getId()
							+ "' and model.inuse=1 order by model.name";
					list = tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
				}
			}
		}
		System.out
				.println(list.size()
						+ "???????????????????????????????????????????????????????????????????");
		return list;
	}
	public List findAllForSubscribeTree(String id) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String hql = "";
		if (id != null) {
			if (id.equals("0")) {
				hql = "from TbCommonalityComm model where model.parentId is null and model.inuse=1";
				list = tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
			} else {
				TbCommonalityComm instance = tbCommonalityCommDAO.findById(id);
				if (instance != null) {
					hql = "from TbCommonalityComm model where model.parentId='"
							+ instance.getId()
							+ "' and model.inuse=1 order by model.name";
					list = tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
				}
			}
		}
		
		return list;
	}

	public List find4Tree(String parentId,String type){
		if(type==null || "".equals(type)){
			type="sms";
		}
		String hql = "from TbCommonalityComm model where model.parentId='"
			+ parentId + "' and model.attr1='"+type+"' "
			+ "and model.inuse=1  order by model.name";
		return tbCommonalityCommDAO.findByHQL(hql, true, -1, -1);
	}

	public List findByIdAndName(){
		return   this.tbCommonalityCommDAO.findByIdAndName();
	}
	/**
	 * 根据type查找出公共通讯录组的树
	 * @param type
	 * @return
	 */
	public List findCommTreeList(String type) {
		type = "root".equals(type)?"":type;
		String sql = "select t.* from tb_commonality_comm t start with t.id='0a' " +
				"connect by prior t.id=t.parent_id and t.inuse='1' and t.attr1 like '%"+type+"%' order by level,t.attr1 desc";
		return tbCommonalityCommDAO.findBySql(sql);
	}

}
