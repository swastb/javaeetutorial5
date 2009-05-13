package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbMessages;
import com.baosight.mode.TbOaSmsSchedule;

public interface ITbMessageDAO {
	public List findByParam(String param);
	/**
	 * <p>Decription:Î´¶ÁÊÕ¼þ</p>
	 * @param receiverId
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-11-7</p>
	 */
	public List findNewByReceiverId(String receiverId);
	public TbMessages findById(String id);
	
	public void delete(TbMessages tbMessages);
	
	public void update(TbMessages tbMessages);
	
	public List findNotRead(String param);
	
	public List findNotReadMsg(String param);
	
	
	public abstract void save(TbMessages transientInstance);
	public void saveSchedule(TbOaSmsSchedule item);

	public abstract List findselfMessages(String param);
	
	public List findAllFriends();
	
	public List findAllUser();
	
	public List findTel(String sql) ;
	
	public int getNotReadRecordNum(String userid);
	public abstract List findByNativeSql(String sql, Class entity);	
}
