package com.baosight.base.dao;

import java.io.Serializable;
import java.util.List;

import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbRoleCla;

public interface ITbInfoPubClaDAO {

	public abstract Serializable save(TbInfoPubCla transientInstance);

	public abstract void delete(TbInfoPubCla persistentInstance);

	public abstract TbInfoPubCla findById(java.lang.String id);

	public abstract List findByExample(TbInfoPubCla instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByCode(Object code);

	public abstract List findByParentid(Object parentid);
	
	public abstract List findByParentIdOrder(Object parentid);

	public abstract List findByDefOrder(Object defOrder);

	public abstract List findByOnlyTree(Object onlyTree);

	public abstract List findByEnable(Object enable);

	public abstract List findByRem(Object rem);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findByAttr4(Object attr4);

	public abstract List findAll();

	public abstract TbInfoPubCla merge(TbInfoPubCla detachedInstance);

	public abstract void attachDirty(TbInfoPubCla instance);

	public abstract void attachClean(TbInfoPubCla instance);

	public abstract void update(TbInfoPubCla instance);
	
	public abstract List findEnableIsTure(String type);
	public abstract List findParentID_EnableIsTure(String parentid);
	
	public abstract List getChildren(String parentid,String[] roleForCla);

	public abstract List findBySql(String sql);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public abstract long findMaxDefOrder(String parentId);
	
	//取栏目对应的所有角色
	public abstract List findRolesForCla();
	//取栏目对应的已选角色
	public abstract List findRolesSeled(String claid);
	//取栏目对应未选角色
	public abstract List findRolesUnSeled(String claid);
	//删除为该栏目已经选择的角色
	public abstract void deleteFromRoleCla(String claid,String[] roles);
	//保存为栏目所分配的角色  
	public abstract void saveRoleCla(TbRoleCla roleCla);

}