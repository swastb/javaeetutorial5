package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbMessages;
import com.baosight.mode.TbOaSmsSchedule;

public interface IMessagesMgr {
	
	public List findByParam(String param);
	/**
	 * <p>Decription:未读收件</p>
	 * @param receiverId
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-11-7</p>
	 */
	public List findNewByReceiverId(String receiverId);
	
	public TbMessages findById(String id);
	
	public void delete(String id);
	
	public void update(TbMessages tbMessages);
	
	public int findNotRead(String param);
	
	public List findNotReadMsg(String param);
	
	public String findTel(String[] receiverArray);

	public void save(TbMessages model);
	
	public void saveSchedule(TbOaSmsSchedule item);

	public List findselfMessages(String param);
	
	public List findAllFriends();
	
	public List findAllUser();
	
	public void sendDelete(String id);
	/**
	 * 查找出所有未读的到发送时间的记录数
	 * @param userid 登录用户
	 * @return
	 */
	public int getNotReadRecordNum(String userid);
	public List findMessage_recordId(String recordId);	
}
