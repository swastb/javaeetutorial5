package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbGovInfoPubContentDAO;
import com.baosight.base.service.IGovInfoPubContentMgr;
import com.baosight.mode.TbGovInfoPubContent;

public class GovInfoPubContentMgrImpl implements IGovInfoPubContentMgr {

	private ITbGovInfoPubContentDAO tbGovInfoPubContentDAO;

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubContentDAO.findAll();
	}

	public TbGovInfoPubContent findById(String id) {
		// TODO Auto-generated method stub
		return this.tbGovInfoPubContentDAO.findById(id);
	}

	public void save(TbGovInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubContentDAO.save(model);
	}

	public void update(TbGovInfoPubContent model) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubContentDAO.update(model);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbGovInfoPubContentDAO.delete(this.findById(id));
	}

	public ITbGovInfoPubContentDAO getTbGovInfoPubContentDAO() {
		return tbGovInfoPubContentDAO;
	}

	public void setTbGovInfoPubContentDAO(
			ITbGovInfoPubContentDAO tbGovInfoPubContentDAO) {
		this.tbGovInfoPubContentDAO = tbGovInfoPubContentDAO;
	}
//查询政府公开信息时候显示不需要审核的信息，并且查询的时候只查询出6条
	public List findById(Long id) {
//		List list = tbGovInfoPubContentDAO.findByHQL("from TbGovInfoPubContent model where rownum<7 order by model.createTime desc", true, 0, 6);
		List list = tbGovInfoPubContentDAO.findByHQL("from TbGovInfoPubContent model where model.status=1 and  rownum<7 order by model.createTime desc", true, 0, 6);
		System.out.println(list.size());
		return list;
	}
	
public List findAllInfo(){
	List list = tbGovInfoPubContentDAO.fingByHql("from TbGovInfoPubContent model where model.status=1  order by model.createTime desc");
	return list;
}
	public List findByTitle(String title) {
		String hql="from TbGovInfoPubContent model where model.title='"+title+"' and rownum<7 order by model.createTime desc";
		return this.tbGovInfoPubContentDAO.findByHQL(hql, true, -1, 6);
	}
	
	
}
