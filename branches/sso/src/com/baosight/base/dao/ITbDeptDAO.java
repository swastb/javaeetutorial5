package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDept;

public interface ITbDeptDAO {

	public abstract void save(TbDept transientInstance);

	public abstract void delete(TbDept persistentInstance);

	public abstract TbDept findById(java.lang.String id);

	public abstract List findByExample(TbDept instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCode(Object code);

	public abstract List findByName(Object name);

	public abstract List findByLvl(Object lvl);

	public abstract List findByParCode(Object parCode);

	public abstract List findByTel(Object tel);

	public abstract List findByCtc(Object ctc);

	public abstract List findByRem(Object rem);
	
	public abstract List findByUserDept(Object userDept);

	public abstract List findByDefOrder(Object defOrder);

	public abstract List findAll();

	public abstract TbDept merge(TbDept detachedInstance);

	public abstract void attachDirty(TbDept instance);

	public abstract void attachClean(TbDept instance);
	
	public List checkName(Object id,Object value,Object par,String field);

	/**
	 * 编辑部门
	 */
	public abstract void updateDept(TbDept item);
	/**
	 * 节点移动
	 * @param parentId
	 * @param nodeId
	 * @param type
	 */
	public abstract void upDownDDS(String parentId,String nodeId,String defOrder,String type);
	public abstract TbDept findByPDefOrder(String parentId,long defOrder,String type);
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public abstract long findMaxDefOrder(String parentId,String type);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	public List getTwoDept(String deptId);

	public abstract List findBySql(String sql,String id,Class entity);

}