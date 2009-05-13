package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baosight.base.dao.ITbCommissionDAO;
import com.baosight.base.service.ICommissionMgr;
import com.baosight.mode.TbCommission;
import com.baosight.mode.TbUser;

public class CommissionMgrImpl implements ICommissionMgr {

	private ITbCommissionDAO tbCommissionDAO;

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbCommissionDAO.findAll();
	}

	public TbCommission findById(String id) {
		// TODO Auto-generated method stub
		return this.tbCommissionDAO.findById(id);
	}

	public void save(TbCommission model) {
		// TODO Auto-generated method stub
		this.tbCommissionDAO.save(model);
	}

	public void update(TbCommission model) {
		// TODO Auto-generated method stub
		this.tbCommissionDAO.update(model);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbCommissionDAO.delete(this.findById(id));
	}
	
	/**
	 * 根据type找委托或被委托列表
	 * @param user,type 1 代表委托列表　２被委托列表
	 * @return
	 */
	public List findCommissionListByType(TbUser user, String comm_name, String beginTime,String endTime, Date now, String type) {
		String sub_hql = " and model.commId='"+user.getId()+"' ";
		String start =" and model.begintime>=to_date('"+beginTime+"','yyyy-MM-dd hh24:mi') ";
		String end = " and model.endtime<=to_date('"+endTime+"','yyyy-MM-dd hh24:mi') ";
		comm_name = comm_name==null?"":comm_name;
		if ("".equals(beginTime) || beginTime==null)
			start = "";
		if ("".equals(endTime) || endTime==null)
			end = "";
		if ("2".equals(type))
			sub_hql = " and model.becommedId='"+user.getId()+"' and model.begintime<=sysdate and model.commFlag in ('1','0')";
		String hql = "from TbCommission model where model.commTitle like '%"+comm_name+"%' " +start+end
				+sub_hql+" order by model.begintime";
		return this.tbCommissionDAO.findCommissionListByHql(hql);
	}
	
	/**
	 * 根据用户id找与该用户同部门的人员树
	 * @param loginUserId
	 * @return
	 */
	public Map findUserTree(TbUser user) {
		String deptHql = "from TbDept d where d.id='"+user.getDeptCode()+"'";
		String userHql = "from TbUser t where t.deptCode='"+user.getDeptCode()+"'";
		
		List dept = this.tbCommissionDAO.findCommissionListByHql(deptHql);
		List userList = this.tbCommissionDAO.findCommissionListByHql(userHql);;
		Map map = new HashMap();
		map.put("root", dept.get(0));
		map.put("userList", userList);
		
		return map;
	}
	
	public ITbCommissionDAO getTbCommissionDAO() {
		return tbCommissionDAO;
	}

	public void setTbCommissionDAO(ITbCommissionDAO tbCommissionDAO) {
		this.tbCommissionDAO = tbCommissionDAO;
	}
	
}
