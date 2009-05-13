package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbMeeting;
import com.baosight.mode.TbMeetingrecord;

public interface IMeetingrecordMgr 
{
	public List findAll();

	public TbMeetingrecord findById(String id);

	public void updte(TbMeetingrecord model);

	public void delete(String id);

	public void save(TbMeetingrecord model);
	
	public List findSelectF_T(String title,String ftime,String ttime);
	
	public List findSelectNo_FT(String title);
	
	public List findSelectTitle_From(String title,String ftime);
	
	public List findSelectTitle_To(String title,String ttime);
	
	
	
}
