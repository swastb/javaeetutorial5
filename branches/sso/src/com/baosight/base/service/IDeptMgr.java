package com.baosight.base.service;

import java.util.Collection;
import java.util.List;

import com.baosight.mode.TbDept;

public interface IDeptMgr {

	TbDept getSystemRoot();

	Collection getChildren(String parentId);

	void save(TbDept item);
	
	public List findAllDept();
	
	public String selectDepts(String ids);
	
	public String checkName(String id,String name,String par,String field);

	boolean delete(String nodeId);
	//start
	/**
	 * 根据ＩＤ查部门
	 */
	public TbDept find(String id);
	/**
	 * 编辑部门
	 */
	public void updateDept(TbDept item);
	/**
	 * 节点移动
	 * @param parentId
	 * @param nodeId
	 * @param type
	 */
	public void upDownMoveS(String parentId,String nodeId,String nodeType,String nextNType,String defOrder,String type);
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public long getMaxDefOrder(String parentId);
	//end
	public List getTwoDept(String deptId);
	/**
	 * <p>Decription:查找部门树</p>
	 * @param rootId 根节点的ID
	 * @return 根节点以下的所有子节点
	 * @author heaton.cai
	 * <p>Create Time:2008-10-28</p>
	 */
	public List find4Tree(String rootId);
}