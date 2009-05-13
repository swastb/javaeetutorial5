package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baosight.base.dao.ITbIndividualCommDAO;
import com.baosight.base.service.IIndividualCommMgr;
import com.baosight.mode.TbIndividualComm;
import com.baosight.mode.TbUser;

public class IndividualCommMgrImpl implements IIndividualCommMgr {

	private ITbIndividualCommDAO tbIndividualCommDAO;
	public void delete(String id) {
		TbIndividualComm item = this.tbIndividualCommDAO.findById(id);
		this.tbIndividualCommDAO.delete(item);
	}

	public List findAll(TbUser user) {
		// TODO Auto-generated method stub
		return this.tbIndividualCommDAO.findAll(user);
	}

	public TbIndividualComm findById(String id) {
		// TODO Auto-generated method stub
		return this.tbIndividualCommDAO.findById(id);
	}

	public void save(TbIndividualComm model) {
		// TODO Auto-generated method stub
		this.tbIndividualCommDAO.save(model);
	}

	public void updte(TbIndividualComm model) {
		// TODO Auto-generated method stub
		this.tbIndividualCommDAO.update(model);
	}

	public ITbIndividualCommDAO getTbIndividualCommDAO() {
		return tbIndividualCommDAO;
	}

	public void setTbIndividualCommDAO(ITbIndividualCommDAO tbIndividualCommDAO) {
		this.tbIndividualCommDAO = tbIndividualCommDAO;
	}

	public List findSelectName(String SelectName,TbUser user) {
		// TODO Auto-generated method stub
		return this.tbIndividualCommDAO.findSelectName(SelectName, user);
	}

	public String checkIndividualCommName(String id, String value, String userid,  String flag) {
		// TODO Auto-generated method stub
		List list=tbIndividualCommDAO.checkIndividualComm(id, value,userid, flag);	
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}

	public List findStatus(TbUser user) {
		// TODO Auto-generated method stub
		return this.tbIndividualCommDAO.findStatus(user);
	}
	public List findAllForTree() {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		list = tbIndividualCommDAO.findByHQL("from TbIndividualComm model where model.inuse=1", true, -1, -1);
		System.out
				.println(list.size()
						+ "???????????????????????????????????????????????????????????????????");
		return list;
	}

	public List findForTree(String userId){
		String hql = "from TbIndividualComm where inuse=1 and attr1='"+userId+"'";
		return tbIndividualCommDAO.findByHQL(hql, true, -1, -1);
	}

}
