package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbMeetingroom;;

public interface IMeetingRoomMgr {

	public List findAll();

	public TbMeetingroom findById(String id);

	public void updte(TbMeetingroom model);

	public void delete(String id);

	public void save(TbMeetingroom model);

	public String checkMeetingRoomName(String id, String value);

}
