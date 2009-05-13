package com.baosight.fax.service.impl;

import java.util.List;

import com.baosight.fax.bean.ListSearchBean;
import com.baosight.fax.dao.TbFaxScheduleDAO;
import com.baosight.fax.mode.TbFaxSchedule;
import com.baosight.fax.service.ScheduleMgr;

/**
 * <p>Decription:·¢ËÍ´«Õæ</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-15</p>
 */
public class ScheduleMgrImpl implements ScheduleMgr {

	TbFaxScheduleDAO tbFaxScheduleDAO;

	public void delete(TbFaxSchedule instance) {
		tbFaxScheduleDAO.delete(instance);
	}

	public List findAll() {
		return tbFaxScheduleDAO.findAll();
	}

	public List findByExample(TbFaxSchedule instance) {
		return tbFaxScheduleDAO.findByExample(instance);
	}

	public TbFaxSchedule findById(String id) {
		return tbFaxScheduleDAO.findById(id);
	}

	public void save(TbFaxSchedule instance) {
		if(instance.getId()!=null && !"".equals(instance.getId())){
			tbFaxScheduleDAO.merge(instance);
		}else{
			tbFaxScheduleDAO.save(instance);
		}
	}

	public List findByCondition(ListSearchBean searchBean) {
		String hql = "from TbFaxSchedule " +
				"where state='"+searchBean.getState()+"' ";
		if(searchBean.getStartTime()!=null && !"".equals(searchBean.getStartTime().trim())){
			hql+="and senddate >= to_date('"+searchBean.getStartTime()+"','yyyy-mm-dd') ";
		}
		if(searchBean.getEndTime()!=null && !"".equals(searchBean.getEndTime().trim())){
			hql+="and senddate <= to_date('"+searchBean.getEndTime()+" 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
		}
		if(searchBean.getFaxNum()!=null && !"".equals(searchBean.getFaxNum().trim())){
			hql+="and fax='"+searchBean.getFaxNum()+"' ";
		}
		return tbFaxScheduleDAO.findByHQL(hql,true,-1,-1);
	}

	public void setTbFaxScheduleDAO(TbFaxScheduleDAO tbFaxScheduleDAO) {
		this.tbFaxScheduleDAO = tbFaxScheduleDAO;
	}

	public List findByStatus() {
		String hql="from TbFaxSchedule model where model.state=000 ";
		return tbFaxScheduleDAO.findByHql(hql);
	}

	public void update(TbFaxSchedule instance) {
		// TODO Auto-generated method stub
		this.tbFaxScheduleDAO.update(instance);
	}
	
}
