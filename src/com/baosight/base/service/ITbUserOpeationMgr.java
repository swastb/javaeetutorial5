package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbUserOpeationDAO;
import com.baosight.mode.TbUserOpeation;

public interface ITbUserOpeationMgr {

	
	public void save(TbUserOpeation transientInstance);
	
	public void update(TbUserOpeation transientInstance);

	public void delete(TbUserOpeation persistentInstance) ;

	public TbUserOpeation findById(java.lang.String id) ;

	public List findByProperty(String propertyName, Object value);

	public List findAll() ;

	/**
	 * 根据userid来断送是否有记录，有记录则 待办数量[openum]++；无则新增记录！
	 * @param Userid 人员ID
	 * @param opeation 待办类型
	 * @param AddOrCut ture则++，false则--;
	 */
	public void byUseridSaveOrUpdate(String Userid,String opeation,boolean AddOrCut);
	public void archiveApplySaveOrUpdate(String addOrMinus);
	public int count(String userid,String operation);
	public void SaveOrUpdate(String userid,String operation,String addOrMinus);
}
