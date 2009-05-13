package com.baosight.tech.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.baosight.tech.dao.ITbTechStandardDAO;
import com.baosight.tech.mode.TbTechStandard;
import com.baosight.tech.service.ITechStandardMgr;

/**
 * <p>Decription:TechStandardMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechStandardMgrImpl implements ITechStandardMgr {

	ITbTechStandardDAO tbTechStandardDAO;

	public void delete(TbTechStandard persistentInstance) {
		tbTechStandardDAO.delete(persistentInstance);
	}

	public List findAll() {
		return tbTechStandardDAO.findAll();
	}

	public TbTechStandard findById(String id) {
		return tbTechStandardDAO.findById(id);
	}

	public void save(TbTechStandard transientInstance) {
		if(transientInstance.getId()!=null && !"".equals(transientInstance)){
			tbTechStandardDAO.merge(transientInstance);
		}else{
			tbTechStandardDAO.save(transientInstance);
		}
	}

	public List findForQuery(TbTechStandard item) {
		StringBuffer hql = new StringBuffer("from TbTechStandard where 1=1");
		if(item.getName()!=null && !"".equals(item.getName())){
			hql.append(" and name like '%").append(item.getName()).append("%'");
		}
		if(item.getPubDepartment()!=null && !"".equals(item.getPubDepartment())){
			hql.append(" and pub_department like '%").append(item.getPubDepartment()).append("%'");
		}
		if(item.getPubTime()!=null){
			DateFormat df = new SimpleDateFormat("yyyyMM");
			hql.append(" and to_char(pub_time,'yyyymm') = '").append(df.format(item.getPubTime())).append("'");
		}
		hql.append(" order by pub_time desc");
		return tbTechStandardDAO.findByHQL(hql.toString(), true, -1, -1);
	}

	public void setTbTechStandardDAO(ITbTechStandardDAO tbTechStandardDAO) {
		this.tbTechStandardDAO = tbTechStandardDAO;
	}

}
