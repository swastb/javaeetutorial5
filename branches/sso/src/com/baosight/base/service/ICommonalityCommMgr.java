package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbCommonalityComm;;

public interface ICommonalityCommMgr {

	public List findAll();

	public TbCommonalityComm findById(String id);

	public void updte(TbCommonalityComm model);

	public void delete(String id);

	public void save(TbCommonalityComm model);
	
	public List findByCommType(String parentId,String belong,String flag);
	
	public List findByComm(String parentId,String name);
	
	public List findByParentId(String commonalityId);
	
	public List findMenu(String belong);
	
	public String checkName(String id,String pid,String name);
	
	
	/**
	 * 根据id查找出公共通讯录组或子结点
	 * @param id
	 * @return
	 */
	public List findAllForTree(String id);
	/**
	 * 根据id查找出公共通讯录组或子结点
	 * @param id
	 * @return
	 */	
	public List findAllForSubscribeTree(String id);
	public List findByIdAndName();
	/**
	 * 根据type查找出公共通讯录组的树
	 * @param type
	 * @return
	 */
	public List findCommTreeList(String type);

	/**
	 * <p>Decription:查询下一级节点</p>
	 * @param parentId 当前节点
	 * @param type 组类型
	 * @return 当前节点的所有下一级子节点
	 * @author heaton.cai
	 * <p>Create Time:2008-10-28</p>
	 */
	public List find4Tree(String parentId,String type);
}
