package com.baosight.tech.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.baosight.tech.dao.ITbTechResultDAO;
import com.baosight.tech.mode.TbTechResult;
import com.baosight.tech.service.ITechResultMgr;

/**
 * <p>Decription:TechTechResultMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechResultMgrImpl implements ITechResultMgr {

	ITbTechResultDAO tbTechResultDAO;

	public void setTbTechResultDAO(ITbTechResultDAO tbTechResultDAO) {
		this.tbTechResultDAO = tbTechResultDAO;
	}

	public void delete(TbTechResult persistentInstance) {
		tbTechResultDAO.delete(persistentInstance);
	}

	public List findAll() {
		return tbTechResultDAO.findAll();
	}

	public TbTechResult findById(String id) {
		return tbTechResultDAO.findById(id);
	}

	public List findForQuery(TbTechResult item) {
		StringBuffer hql = new StringBuffer("from TbTechResult where 1=1");
		if(item.getItemName()!=null && !"".equals(item.getItemName())){
			hql.append(" and item_name like '%").append(item.getItemName()).append("%'");
		}
		if(item.getBearUnit()!=null && !"".equals(item.getBearUnit())){
			hql.append(" and bear_unit like '%").append(item.getBearUnit()).append("%'");
		}
		if(item.getItemPrincipal()!=null && !"".equals(item.getItemPrincipal())){
			hql.append(" and item_principal like '%").append(item.getItemPrincipal()).append("%'");
		}
		if(item.getStartTime()!=null){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			hql.append(" and end_time >= to_date('").append(df.format(item.getStartTime())).append("','yyyy-mm-dd')");
		}
		if(item.getEndTime()!=null){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			hql.append(" and start_time <= to_date('").append(df.format(item.getEndTime())).append(" 23:59:59','yyyy-mm-dd hh24:mi:ss')");
		}
		hql.append(" order by start_time desc");
		return tbTechResultDAO.findByHQL(hql.toString(), true, -1, -1);
	}

	public void save(TbTechResult transientInstance) {
		if(transientInstance.getId()==null || "".equals(transientInstance.getId())){
			tbTechResultDAO.save(transientInstance);
		}else{
			tbTechResultDAO.merge(transientInstance);
		}
	}

}
