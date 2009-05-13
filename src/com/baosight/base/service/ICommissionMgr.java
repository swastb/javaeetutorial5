package com.baosight.base.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baosight.mode.TbCommission;
import com.baosight.mode.TbUser;

public interface ICommissionMgr 
{
	//修改
	public void update(TbCommission model);

	//删除
	public void delete(String id);

	//添加
	public void save(TbCommission model);

	//全查询
	public List findAll();

	//根据ID查询
	public TbCommission findById(String id);
	
	/**
	 * 根据type找委托或被委托列表
	 * @param user type
	 * @return
	 */
	public List findCommissionListByType(TbUser user, String comm_name, String beginTime,String endTime, Date now, String type);
	
	/**
	 * 根据用户id找与该用户同部门的人员树
	 * @param loginUserId
	 * @return
	 */
	public Map findUserTree(TbUser user);
}
