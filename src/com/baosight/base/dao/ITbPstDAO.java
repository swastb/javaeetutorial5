package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

public interface ITbPstDAO {

	public abstract void save(TbPst transientInstance);

	public abstract void delete(TbPst persistentInstance);

	public abstract TbPst findById(java.lang.String id);

	public abstract List findByExample(TbPst instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByLvl(Object lvl);

	public abstract List findByCode(Object code);
	
	public abstract List findByDeptId(Object deptId);

	public abstract List findAll();

	public abstract TbPst merge(TbPst detachedInstance);

	public abstract void attachDirty(TbPst instance);

	public abstract void attachClean(TbPst instance);
	
	public List checkName(Object id,Object value,Object par,String field);
	
	/**
	 * ±à¼­Ö°Îñ
	 */
	public void updatePost(TbPst item);

	/**
	 * 
	 * @param parentId
	 * @param defOrder
	 * @return
	 */
	public TbPst findByPDefOrder(String parentId,long defOrder,String type);
}