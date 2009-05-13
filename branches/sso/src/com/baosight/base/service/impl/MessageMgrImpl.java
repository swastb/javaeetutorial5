package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbMessageDAO;
import com.baosight.base.service.IMessagesMgr;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbOaSmsSchedule;

public class MessageMgrImpl implements IMessagesMgr{
	private ITbMessageDAO tbMessageDAO;
	
	public void setTbMessageDAO(ITbMessageDAO tbMessageDAO) {
		this.tbMessageDAO = tbMessageDAO;
	}

	public List findByParam(String param) {
		List messagesList=tbMessageDAO.findByParam(param);
		return messagesList;
	}
	public List findNewByReceiverId(String receiverId) {
		return tbMessageDAO.findNewByReceiverId(receiverId);
	}
	public TbMessages findById(String id) {
		return this.tbMessageDAO.findById(id);
	}
	
	public void delete(String id) {
		TbMessages msg = this.findById(id);
		if(null!=msg.getAttr1() && msg.getAttr1().equals("1")){
			this.tbMessageDAO.delete(msg);
		}else{
			msg.setAttr1("2");
			this.tbMessageDAO.update(msg);
		}	
	}
	
	public void sendDelete(String id) {
		TbMessages msg = this.findById(id);
		if(null!=msg.getAttr1() && msg.getAttr1().equals("2")){
			this.tbMessageDAO.delete(msg);
		}else{
			msg.setAttr1("1");
			this.tbMessageDAO.update(msg);
		}	
	}

	public void update(TbMessages tbMessages) {
		this.tbMessageDAO.update(tbMessages);
	}

	public int findNotRead(String param) {
		List list=this.tbMessageDAO.findNotRead(param);
		return Integer.parseInt(list.get(0).toString());
	}

	public String findTel(String[] receiverArray) {
		String tel="";
		String userid ="";
		for (int i=0;i<receiverArray.length;i++){
			if(i!=receiverArray.length-1){
				userid += "'"+receiverArray[i]+"',";
			}else{
				userid += "'"+receiverArray[i]+"'";
			}	
		}
		List list=this.tbMessageDAO.findTel(userid);
		System.out.println("list.get(0)"+list.get(0).getClass());
		for(int i=0;i<list.size();i++){
			tel +=list.get(i)+",";
		}
		tel =tel.substring(0, tel.length()-1);
		return tel;
	}
	
	public List findNotReadMsg(String param) {
		return this.tbMessageDAO.findNotReadMsg(param);
	}
	
	public List findselfMessages(String param) {
		List messagesList=tbMessageDAO.findselfMessages(param);
		return messagesList;
	}

	public void save(TbMessages model) {
		 this.tbMessageDAO.save(model);
	}
	
	public void saveSchedule(TbOaSmsSchedule item) {
		 this.tbMessageDAO.saveSchedule(item);
	}
	
	public List findAllUser() {
		return this.tbMessageDAO.findAllUser();
	}
	public List findAllFriends() {
		return this.tbMessageDAO.findAllFriends();
	}

	public int getNotReadRecordNum(String userid) {
		return tbMessageDAO.getNotReadRecordNum(userid);
	}
    //从消息表中查找出会议纪要通知人员名单
	public List findMessage_recordId(String recordId) {
		 String	hql = "select s.* from tb_messages s " +
		              "where s.attr2 = '" +
		              recordId +
		              "' ";


		 List objList = tbMessageDAO.findByNativeSql(hql, TbMessages.class);

			return objList;

	}

		
}
