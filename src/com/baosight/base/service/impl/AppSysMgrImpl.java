package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbAppsysDAO;
import com.baosight.base.dao.ITbAuthlvlDAO;
import com.baosight.base.service.IAppSysMgr;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbAuthlvl;

public class AppSysMgrImpl implements IAppSysMgr {
	private ITbAppsysDAO tbAppsysDAO;



	public ITbAppsysDAO getTbAppsysDAO() {
		return tbAppsysDAO;
	}


	public void setTbAppsysDAO(ITbAppsysDAO tbAppsysDAO) {
		this.tbAppsysDAO = tbAppsysDAO;
	}


	public void delete(String id) {
		this.tbAppsysDAO.delete(find(id));
	}

	
	public TbAppsys find(String id) {
		return tbAppsysDAO.findById(id);
	}
	
	
	public List findAll() {
		return this.tbAppsysDAO.findAll();
	}

	public void save(TbAppsys item) {
		this.tbAppsysDAO.save(item);
	}

	public void updte(TbAppsys item) {
		this.tbAppsysDAO.update(item);
	}
	
	public TbAppsys getUrlByCode(String code) {
		// TODO Auto-generated method stub
		List list = tbAppsysDAO.findByProperty("code", code);
		if(list.size()==0){
			return null;
		}else{
			if(list.size()==1){
				return (TbAppsys)list.get(0);
			}else{
				return null;
			}
		}
	}
	
	public String checkCode(String id,String name)
	{
		List list=tbAppsysDAO.checkCode(id,name);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}
	public List findForAppSys(){
		return tbAppsysDAO.findByHQL("from TbAppsys model where model.ischild=1 and model.insure=1", true, -1, -1);
	}
}
