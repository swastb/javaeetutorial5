package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbUserOpeationDAO;
import com.baosight.base.service.ITbUserOpeationMgr;
import com.baosight.mode.TbUserOpeation;


public class TbUserOpeationMgrImpl  implements ITbUserOpeationMgr  {

	private ITbUserOpeationDAO tbUserOpeationDAO;

	public void save(TbUserOpeation transientInstance) {
		this.tbUserOpeationDAO.save(transientInstance);
	}
	
	public void update(TbUserOpeation transientInstance) {
		this.tbUserOpeationDAO.update(transientInstance);
	}

	public void delete(TbUserOpeation persistentInstance) {
		this.tbUserOpeationDAO.delete(persistentInstance);
	}

	public TbUserOpeation findById(java.lang.String id) {
		return this.tbUserOpeationDAO.findById(id);
	}


	public List findByProperty(String propertyName, Object value) {
		return this.tbUserOpeationDAO.findByProperty(propertyName, value);
	}

	public List findAll() {
		return this.tbUserOpeationDAO.findAll();
	}

	public void byUseridSaveOrUpdate(String Userid,String opeation,boolean AddOrCut){
		
		List tbUserOpeation=this.tbUserOpeationDAO.findByProperty("userid", Userid);
		if(tbUserOpeation.size()==0){
			TbUserOpeation saveObject = new TbUserOpeation();
			saveObject.setUserid(Userid);
			saveObject.setOpeation(opeation);
			saveObject.setOpenum(new Long(1));
			this.tbUserOpeationDAO.save(saveObject);
		}
		else{
			
			TbUserOpeation updateObject  = (TbUserOpeation)tbUserOpeation.get(0);
			int num  = updateObject.getOpenum().intValue();
			if(AddOrCut)
			{
				num++;
			}
			else{
				if(num<=0)return ;
				num--;}
			updateObject.setOpenum(new Long(num));
			this.tbUserOpeationDAO.update(updateObject);
		}
	}
	public void archiveApplySaveOrUpdate(String addOrMinus){
		
		List tbUserOpeation=this.tbUserOpeationDAO.findByProperty("opeation", "13");
		if(tbUserOpeation.size()==0){
			TbUserOpeation saveObject = new TbUserOpeation();
			saveObject.setUserid("");
			saveObject.setOpeation("13");
			saveObject.setOpenum(new Long(1));
			this.tbUserOpeationDAO.save(saveObject);
		}
		else{
			TbUserOpeation updateObject  = (TbUserOpeation)tbUserOpeation.get(0);
			int num  = updateObject.getOpenum().intValue();
			if(addOrMinus.equals("add"))
				num++;
			else if(addOrMinus.equals("minus"))
				num--;
			updateObject.setOpenum(new Long(num));
			this.tbUserOpeationDAO.update(updateObject);
		}
	}
	
	public void SaveOrUpdate(String userid,String operation,String addOrMinus){
		
		List tbUserOpeation=this.tbUserOpeationDAO.findByParam(userid, operation);
		if(tbUserOpeation.size()==0){
			TbUserOpeation saveObject = new TbUserOpeation();
			saveObject.setUserid(userid);
			saveObject.setOpeation(operation);
			saveObject.setOpenum(new Long(1));
			this.tbUserOpeationDAO.save(saveObject);
		}
		else{
			TbUserOpeation updateObject  = (TbUserOpeation)tbUserOpeation.get(0);
			int num  = updateObject.getOpenum().intValue();
			if(addOrMinus.equals("add"))
				num++;
			else if(addOrMinus.equals("minus"))
				num--;
			updateObject.setOpenum(new Long(num));
			this.tbUserOpeationDAO.update(updateObject);
		}
	}
	
//	¼ÇÂ¼ÊýÁ¿
	public int count(String userid,String operation){
		List tbUserOpeation=this.tbUserOpeationDAO.findByParam(userid, operation);
		if(tbUserOpeation.size()==0){
			return 0;
		}else{
			long count = ((TbUserOpeation)tbUserOpeation.get(0)).getOpenum();
			
			return (new Long(count)).intValue();
		}	
	}
	
	public void setTbUserOpeationDAO(ITbUserOpeationDAO tbUserOpeationDAO) {
		this.tbUserOpeationDAO = tbUserOpeationDAO;
	}
}