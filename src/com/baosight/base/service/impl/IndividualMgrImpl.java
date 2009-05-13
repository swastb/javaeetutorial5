package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbIndividualDAO;
import com.baosight.base.service.IIndividualMgr;
import com.baosight.mode.TbIndividual;
import com.baosight.mode.TbUser;

public class IndividualMgrImpl implements IIndividualMgr {

	private ITbIndividualDAO tbIndividualDAO;
	public void delete(String id) {
		TbIndividual item = this.tbIndividualDAO.findById(id);
		this.tbIndividualDAO.delete(item);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbIndividualDAO.findAll();
	}

	public TbIndividual findById(String id) {
		// TODO Auto-generated method stub
		return this.tbIndividualDAO.findById(id);
	}

	public void save(TbIndividual model) {
		// TODO Auto-generated method stub
		this.tbIndividualDAO.save(model);
	}

	public void updte(TbIndividual model) {
		// TODO Auto-generated method stub
		this.tbIndividualDAO.update(model);
	}

	public ITbIndividualDAO getTbIndividualDAO() {
		return tbIndividualDAO;
	}

	public void setTbIndividualDAO(ITbIndividualDAO tbIndividualDAO) {
		this.tbIndividualDAO = tbIndividualDAO;
	}
	
	public List findSelect(String name,String movephone,TbUser user) {
		 String	hql = "select t.id,s.name zm,t.name,t.duty,t.move_phone,t.remark " +
		              "from tb_individual t,tb_individual_comm s " +
		              "where s.id = t.individual_id and (t.name like '%" +
		              name +
		              "%' and t.move_phone like '%" +
		              movephone + 
		              "%' and t.attr1 = '" +
		              user.getId() +
		              "')";

		 List objList = tbIndividualDAO.findByNativeSql(hql);

			return objList;

	}

	public List findindividualid(String individualid) {
		// TODO Auto-generated method stub
		return this.tbIndividualDAO.findindividualid(individualid);
	}
	//个人通讯录电话号码
	public List findByNameAndPhone(String individualId){
		return this.tbIndividualDAO.findByNameAndPhone(individualId);
	}

	public List findByGroupId(String groupId){
		String hql = "from TbIndividual t where t.individualId='"+groupId+"'";
		return tbIndividualDAO.findByHQL(hql, true, -1, -1);
	}

}