package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbMeetingRoomDAO;
import com.baosight.base.service.IMeetingRoomMgr;
import com.baosight.mode.TbMeetingroom;

public class MeetingRoomMgrImpl implements IMeetingRoomMgr {

	private ITbMeetingRoomDAO tbMeetingRoomDAO;
	public void delete(String id) {
		TbMeetingroom item = this.tbMeetingRoomDAO.findById(id);
		this.tbMeetingRoomDAO.delete(item);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return this.tbMeetingRoomDAO.findAll();
	}

	public TbMeetingroom findById(String id) {
		// TODO Auto-generated method stub
		return this.tbMeetingRoomDAO.findById(id);
	}

	public void save(TbMeetingroom model) {
		// TODO Auto-generated method stub
		this.tbMeetingRoomDAO.save(model);
	}

	public void updte(TbMeetingroom model) {
		// TODO Auto-generated method stub
		this.tbMeetingRoomDAO.update(model);
	}

	public ITbMeetingRoomDAO getTbMeetingRoomDAO() {
		return tbMeetingRoomDAO;
	}

	public void setTbMeetingRoomDAO(ITbMeetingRoomDAO tbMeetingRoomDAO) {
		this.tbMeetingRoomDAO = tbMeetingRoomDAO;
	}

	public String checkMeetingRoomName(String id, String value) {
		// TODO Auto-generated method stub
		List list=tbMeetingRoomDAO.checkMeetingRoomName(id, value);	
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}

}
