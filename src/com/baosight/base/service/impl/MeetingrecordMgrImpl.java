package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbMeetingDAO;
import com.baosight.base.dao.ITbMeetingrecordDAO;
import com.baosight.base.service.IMeetingMgr;
import com.baosight.base.service.IMeetingrecordMgr;
import com.baosight.mode.TbMeeting;
import com.baosight.mode.TbMeetingrecord;
import com.baosight.mode.TbMeetingroom;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbUser;

public class MeetingrecordMgrImpl implements IMeetingrecordMgr {
	
	private ITbMeetingrecordDAO tbMeetingrecordDAO;

	public void delete(String id) {
		TbMeetingrecord item = this.tbMeetingrecordDAO.findById(id);
		this.tbMeetingrecordDAO.delete(item);

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbMeetingrecordDAO.findAll();
	}

	public TbMeetingrecord findById(String id) {
		// TODO Auto-generated method stub
		return this.tbMeetingrecordDAO.findById(id);
	}

	public void save(TbMeetingrecord model) {
		// TODO Auto-generated method stub
		this.tbMeetingrecordDAO.save(model);
	}

	public void updte(TbMeetingrecord model) {
		// TODO Auto-generated method stub
		this.tbMeetingrecordDAO.update(model);
	}

	public ITbMeetingrecordDAO getTbMeetingrecordDAO() {
		return tbMeetingrecordDAO;
	}

	public void setTbMeetingrecordDAO(ITbMeetingrecordDAO tbMeetingrecordDAO) {
		this.tbMeetingrecordDAO = tbMeetingrecordDAO;
	}
	
	//时间范围都选择的情况
	public List findSelectF_T(String title,String ftime,String ttime) {
		 String	hql = "select s.* from tb_meetingrecord s " +
		              "where s.meetingrecord_title like '%" +
		              title +
		              "' " + 
		              "and s.meetingrecord_time >= to_date('" + 
		              ftime + 
		              "','yyyy-mm-dd') " +  
		              "and s.meetingrecord_time <= to_date('" + 
		              ttime + 
		              "','yyyy-mm-dd') ";


		 List objList = tbMeetingrecordDAO.findByNativeSql(hql, TbMeetingrecord.class);

			return objList;

	}
	
//	时间都未选择的情况
	public List findSelectNo_FT(String title) {
		 String	hql = "select s.* from tb_meetingrecord s " +
		              "where s.meetingrecord_title like '%" +
		              title +
		              "' ";


		 List objList = tbMeetingrecordDAO.findByNativeSql(hql, TbMeetingrecord.class);

			return objList;

	}
	
//	首时间指定，末时间未指定的情况
	public List findSelectTitle_From(String title,String ftime) {
		 String	hql = "select s.* from tb_meetingrecord s " +
		              "where s.meetingrecord_title like '%" +
		              title +
		              "' " + 
		              "and s.meetingrecord_time >= to_date('" + 
		              ftime + 
		              "','yyyy-mm-dd') ";


		 List objList = tbMeetingrecordDAO.findByNativeSql(hql, TbMeetingrecord.class);

			return objList;

	}
	
//	末时间指定，首时间未指定的情况
	public List findSelectTitle_To(String title,String ttime) {
		 String	hql = "select s.* from tb_meetingrecord s " +
		              "where s.meetingrecord_title like '%" +
		              title +
		              "' " + 
		              "and s.meetingrecord_time <= to_date('" + 
		              ttime + 
		              "','yyyy-mm-dd') ";


		 List objList = tbMeetingrecordDAO.findByNativeSql(hql, TbMeetingrecord.class);

			return objList;

	}
	

}
