package com.baosight.tech.service.impl;

import java.util.List;

import com.baosight.tech.dao.ITbTechMapShareDAO;
import com.baosight.tech.mode.TbTechDiscoure;
import com.baosight.tech.mode.TbTechMapShare;
import com.baosight.tech.service.ITechMapShareMgr;

/**
 * <p>Decription:TechMapShareMgr</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechMapShareMgrImpl implements ITechMapShareMgr {

	ITbTechMapShareDAO tbTechMapShareDAO;


	public void setTbTechMapShareDAO(ITbTechMapShareDAO tbTechMapShareDAO) {
		this.tbTechMapShareDAO = tbTechMapShareDAO;
	}
	public void delete(TbTechMapShare persistentInstance) {
		tbTechMapShareDAO.delete(persistentInstance);
	}

	public List findAll() {
		return tbTechMapShareDAO.findAll();
	}

	public TbTechMapShare findById(String id) {
		return tbTechMapShareDAO.findById(id);
	}

	public void save(TbTechMapShare transientInstance) {
		if(transientInstance.getId()!=null && !"".equals(transientInstance)){
			tbTechMapShareDAO.merge(transientInstance);
		}else{
			tbTechMapShareDAO.save(transientInstance);
		}
	}

	public List findForQuery(TbTechMapShare item) {
		StringBuffer hql = new StringBuffer("from TbTechMapShare where 1=1");
		if(item.getGetTime()!=null && !"".equals(item.getGetTime())){
			hql.append(" and get_time like '%").append(item.getGetTime()).append("%'");
		}
		if(item.getUnitName()!=null && !"".equals(item.getUnitName())){
			hql.append(" and unit_name like '%").append(item.getUnitName()).append("%'");
		}
		hql.append(" order by get_time desc");
		return tbTechMapShareDAO.findByHQL(hql.toString(), true, -1, -1);
	}
//	public List findForQuery(TbTechMapShare item) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
