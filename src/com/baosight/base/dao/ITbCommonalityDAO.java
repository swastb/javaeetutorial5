package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbCommonality;

public interface ITbCommonalityDAO {

	public abstract void save(TbCommonality transientInstance);
	
	public abstract void update(TbCommonality transientInstance);

	public abstract void delete(TbCommonality persistentInstance);

	public abstract TbCommonality findById(java.lang.String id);

	public abstract List findByExample(TbCommonality instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCommonalityId(Object commonalityId);

	public abstract List findByComParentId(Object comParentId);

	public abstract List findByName(Object name);

	public abstract List findByDuty(Object duty);

	public abstract List findByDepartment(Object department);

	public abstract List findByFax(Object fax);

	public abstract List findByPost(Object post);

	public abstract List findByAddress(Object address);

	public abstract List findByPartmentPhone(Object partmentPhone);

	public abstract List findByMovePhone(Object movePhone);

	public abstract List findByHomePhone(Object homePhone);

	public abstract List findByEmail(Object email);

	public abstract List findByQq(Object qq);

	public abstract List findByMsn(Object msn);

	public abstract List findByRemark(Object remark);

	public abstract List findByBelong(Object belong);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findByAttr4(Object attr4);

	public abstract List findByAttr5(Object attr5);

	public abstract List findAll();

	public abstract TbCommonality merge(TbCommonality detachedInstance);

	public abstract void attachDirty(TbCommonality instance);

	public abstract void attachClean(TbCommonality instance);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

	//查询二级组下的所有通讯录
	public List findByNameAndPhone(String comParentId);
	/**
	 * 保存对象并返回id
	 * @param model
	 */
	public String saveObjRetrunId(TbCommonality model);
	public abstract List findBySql(String sql);  
	
	//供查询统计模块所用。
	public List findByIdReturnName(String id);
}