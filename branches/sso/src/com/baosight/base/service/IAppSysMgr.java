package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthlvl;

public interface IAppSysMgr {
	List findAll();

	void updte(TbAppsys item);

	void delete(String id);

	void save(TbAppsys item);

	TbAppsys find(String id);
	
	public TbAppsys getUrlByCode(String code);

	
	public String checkCode(String id,String name);

	
	public List findForAppSys();
	

}
