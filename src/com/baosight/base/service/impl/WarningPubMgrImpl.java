package com.baosight.base.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.baosight.base.dao.ITbWarningPubDAO;
import com.baosight.base.service.IWarningPubMgr;
import com.baosight.mode.TbWarningPub;

public class WarningPubMgrImpl implements IWarningPubMgr {

	private ITbWarningPubDAO tbWarningPubDAO;
	
	public ITbWarningPubDAO getTbWarningPubDAO() {
		return tbWarningPubDAO;
	}

	public void setTbWarningPubDAO(ITbWarningPubDAO tbWarningPubDAO) {
		this.tbWarningPubDAO = tbWarningPubDAO;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.tbWarningPubDAO.delete(this.findById(id));
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbWarningPubDAO.findAll();
	}

	public TbWarningPub findById(String id) {
		// TODO Auto-generated method stub
		return this.tbWarningPubDAO.findById(id);
	}

	public void save(TbWarningPub mode) {
		// TODO Auto-generated method stub
		if(mode.getId()==null || "".equals(mode.getId())){
			tbWarningPubDAO.save(mode);
		}else{
			tbWarningPubDAO.merge(mode);
		}		
	}

	public void update(TbWarningPub mode) {
		// TODO Auto-generated method stub
		this.tbWarningPubDAO.attachDirty(mode);
	}
	public List findForQuery(TbWarningPub item) {
		StringBuffer hql = new StringBuffer("from TbWarningPub where 1=1");
		StringBuffer finalhql = new StringBuffer("");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(item.getSignal()!=null && !"".equals(item.getSignal())){
			if(item.getSignal().equals("0")){
				hql.append(" and signal like '%%'");
			}else{
				hql.append(" and signal like '%").append(item.getSignal()).append("%'");
			}
		}
		if(item.getResp()!=null && !"".equals(item.getResp())){
			if(item.getResp().equals("0")){
				hql.append(" and resp like '%%'");
			}else{
				hql.append(" and resp like '%").append(item.getResp()).append("%'");
			}
			
		}
		if(item.getPubstart()!=null && !"".equals(item.getPubstart())){		
			hql.append(" and pubend >= to_date('").append(df.format(item.getPubstart())).append("','yyyy-mm-dd')");
		}
		if(item.getPubend()!=null && !"".equals(item.getPubend())){
			hql.append(" and pubstart<= to_date('").append(df.format(item.getPubend())).append(" 23:59:59','yyyy-mm-dd hh24:mi:ss')");
		}
		hql.append(" order by signal desc");
		return tbWarningPubDAO.findByHQL(hql.toString(), true, -1, -1);
	}	

}
