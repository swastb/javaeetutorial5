package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbUserAppsys;

public interface IUserAppsysMgr {
	public List findAll();

	public TbUserAppsys findById(String id);

	public void save(TbUserAppsys tbUserAppsys);

	public void update(TbUserAppsys tbUserAppsys);

	public void delete(TbUserAppsys tbUserAppsys);

	public void deleteById(String id);
}
