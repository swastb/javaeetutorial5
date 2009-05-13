package com.baosight.base.service.impl;

import java.util.List;
import java.util.Map;

import com.baosight.base.dao.ITbMeetingDAO;
import com.baosight.base.service.IMeetingMgr;
import com.baosight.mode.TbMeeting;

public class MeetingMgrImpl implements IMeetingMgr {
	
	private ITbMeetingDAO tbMeetingDAO;

	public void delete(String id) {
		this.tbMeetingDAO.delete(findById(id));

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbMeetingDAO.findAll();
	}

	public TbMeeting findById(String id) {
		// TODO Auto-generated method stub
		return this.tbMeetingDAO.findById(id);
	}

	public void save(TbMeeting model) {
		// TODO Auto-generated method stub
		this.tbMeetingDAO.save(model);
	}

	public void updte(TbMeeting model) {
		// TODO Auto-generated method stub
		this.tbMeetingDAO.update(model);
	}

	public ITbMeetingDAO getTbMeetingDAO() {
		return tbMeetingDAO;
	}

	public void setTbMeetingDAO(ITbMeetingDAO tbMeetingDAO) {
		this.tbMeetingDAO = tbMeetingDAO;
	}

	//根据年,月查询当前用户所在部门的会议 尚 2008-11-20 修改
	public List findByYearMonth(String yearMonth, String userDept,Map map) {
		StringBuilder hql = new StringBuilder();
	    hql.append("from TbMeeting model ");
	    hql.append("where model.yearMonth ="+yearMonth);
	    hql.append(" and  model.dept='"+userDept+"'");
	    if("f1".equals(map.get("selField")+"")){
	    	hql.append(" and  model.meetingSn like '%"+map.get("selParameter")+"%'");
	    }else if("f2".equals(map.get("selField")+"")){
	    	hql.append(" and  model.title like '%"+map.get("selParameter")+"%'");
	    }else if("f3".equals(map.get("selField")+"")){
	    	hql.append(" and  model.startTime "+map.get("selConditions")+" to_date('"+map.get("selParameterDateTime")+"','yyyy-MM-dd hh24:mi:ss')");
	    }else if("f4".equals(map.get("selField")+"")){
	    	hql.append(" and  model.endTime "+map.get("selConditions")+" to_date('"+map.get("selParameterDateTime")+"','yyyy-MM-dd hh24:mi:ss')");
	    }else if("f5".equals(map.get("selField")+"")){
	    	hql.append(" and  model.attr2 "+map.get("selConditions")+" '"+map.get("selParameter")+"'");
	    }else if("f6".equals(map.get("selField")+"")){
	    	hql.append(" and  model.presidername "+map.get("selConditions")+" '"+map.get("selParameter")+"'");
	    }else if("f7".equals(map.get("selField")+"")){
	    	hql.append(" and  model.lvl "+map.get("selConditions")+" '"+map.get("selParameter")+"'");
	    }
	    hql.append(" order by model.startTime");
	    
	    System.out.println("hql======" +hql.toString());
		return this.tbMeetingDAO.findByHQL(hql.toString(), true, -1, -1);
	}

	//得到可用的会议室
	public List findMeetingRoom() {
		String hql="from TbMeetingroom model where model.status=10";
		return this.tbMeetingDAO.findByHQL(hql, true, -1, -1);
	}

	//得到当前年份
	public List findByYear(String year) {
		String hql="from TbMeeting model where to_char(model.startTime,'yyyy')='"+year+"'";
		return this.tbMeetingDAO.findByHQL(hql, true, -1, -1);
	}
}
