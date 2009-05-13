package com.baosight.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbUser;

public interface IInfoPubClaMgr {
	TbInfoPubCla getRoot(String type);
	
	Collection getChildren(String parentId,String[] roleForCla);
	
	public List findAll();

	public  TbInfoPubCla findById(String id);

	public void updte(TbInfoPubCla model);

	public void delete(String id);

	public Serializable save(TbInfoPubCla model);
	
	public abstract List findByParentid(Object parentid);
	
	public abstract List findByParentIdOrder(Object parentid);
	
	public abstract List findEnableIsTure(String type);
	
	public abstract List findParentID_EnableIsTure(String parentid);
	
	public abstract List getId(String code);
	
	public abstract List findByPIdClaName(String parentid,String claname,TbUser user);
	
	public abstract void upAndDownCla(String parentid,String nodeId,String type);
	
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public long getMaxDefOrder(String parentId);
	/**
	 *有id取栏目名
	 * @param id
	 * @return
	 */
	public String selectClas(String id);
	
	//取栏目对应的所有角色
	public abstract List getRolesForClaList();
	//取栏目对应的已选角色
	public abstract List findRolesSeled(String id);
	//取栏目对应未选角色
	public abstract List findRolesUnSeled(String id);
	//为栏目添加选择的角色
	public abstract boolean disRolesForCla(String claid,String[] roles);
	//判断是否有操作权限
	public boolean isCanNotdo(String claid,String rightcode,String userId);
	/**
	 * 取栏目树
	 * @param roleForCla
	 * @return
	 */
	public List getClaListTest(String[] roleForCla,String rootId);
	public String getClaForLayout(String belong,String code);
}
