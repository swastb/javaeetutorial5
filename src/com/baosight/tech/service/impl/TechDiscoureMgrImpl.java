package com.baosight.tech.service.impl;

import java.util.List;

import com.baosight.tech.dao.ITbTechDiscoureDAO;
import com.baosight.tech.mode.TbTechDiscoure;
import com.baosight.tech.service.ITechDiscoureMgr;

/**
 * <p>Decription:TechDiscoureMgr</p>
 * @author heaton.cai
 * <p>Create Time:2008-12-19</p>
 */
public class TechDiscoureMgrImpl implements ITechDiscoureMgr {

	ITbTechDiscoureDAO tbTechDiscoureDAO;

	public void setTbTechDiscoureDAO(ITbTechDiscoureDAO tbTechDiscoureDAO) {
		this.tbTechDiscoureDAO = tbTechDiscoureDAO;
	}

	public void delete(TbTechDiscoure persistentInstance) {
		tbTechDiscoureDAO.delete(persistentInstance);
	}

	public List findAll() {
		return tbTechDiscoureDAO.findAll();
	}

	public TbTechDiscoure findById(String id) {
		return tbTechDiscoureDAO.findById(id);
	}

	public void save(TbTechDiscoure transientInstance) {
		if(transientInstance.getId()!=null && !"".equals(transientInstance)){
			tbTechDiscoureDAO.merge(transientInstance);
		}else{
			tbTechDiscoureDAO.save(transientInstance);
		}
	}

	public List findForQuery(TbTechDiscoure item) {
		StringBuffer hql = new StringBuffer("from TbTechDiscoure where 1=1");
		if(item.getA1()!=null && !"".equals(item.getA1())){
			hql.append(" and a1 like '%").append(item.getA1()).append("%'");
		}
		if(item.getPianming()!=null && !"".equals(item.getPianming())){
			hql.append(" and pianming like '%").append(item.getPianming()).append("%'");
		}
		if(item.getZuozhe1()!=null && !"".equals(item.getZuozhe1())){
			hql.append(" and zuozhe1 like '%").append(item.getZuozhe1()).append("%'");
		}
		if(item.getKanming()!=null && !"".equals(item.getKanming())){
			hql.append(" and kanming like '%").append(item.getKanming()).append("%'");
		}
		hql.append(" order by a1 desc");
		return tbTechDiscoureDAO.findByHQL(hql.toString(), true, -1, -1);
	}

}
