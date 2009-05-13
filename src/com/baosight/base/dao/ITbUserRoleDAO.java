package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserRole;

public interface ITbUserRoleDAO {

	public abstract void save(TbUserRole transientInstance);

	public abstract void delete(TbUserRole persistentInstance);

	public abstract TbUserRole findById(java.lang.String id);

	public abstract List findByExample(TbUserRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByRoleid(Object roleid);

	public abstract List findAll();

	public abstract TbUserRole merge(TbUserRole detachedInstance);

	public abstract void attachDirty(TbUserRole instance);

	public abstract void attachClean(TbUserRole instance);
	/**
	 * 取用户所属的角色列表
	 * @param user
	 * @return
	 */
	public List getUserRoleList(TbUser user);

}