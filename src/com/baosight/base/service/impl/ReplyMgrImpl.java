package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbReplyDAO;
import com.baosight.base.service.IReplyMgr;
import com.baosight.mode.TbObligeeMsg;
import com.baosight.mode.TbObligeeOpinion;
import com.baosight.mode.TbReply5;
import com.baosight.mode.TbReply6;
import com.baosight.mode.TbReply7;

public class ReplyMgrImpl implements IReplyMgr{
	private ITbReplyDAO tbReplyDAO;

	public void setTbReplyDAO(ITbReplyDAO tbReplyDAO) {
		this.tbReplyDAO = tbReplyDAO;
	}

	public int findCount(String tbName) {
		List list=this.tbReplyDAO.findCount(tbName);
		//Object[] obj=(Object[])list.get(0);
		return Integer.parseInt(list.get(0).toString());
	}

	public void save(TbReply6 item) {
		this.tbReplyDAO.save(item);
		
	}

	public List findByAttr1(String id) {
		// TODO Auto-generated method stub
		return this.tbReplyDAO.findByAttr1(id);
	}

	public List findReply5ByAttr1(String id) {
		return this.tbReplyDAO.findReply5ByAttr1(id);
	}

	public List findReply7ByAttr1(String id) {
		return this.tbReplyDAO.findReply7ByAttr1(id);
	}

	public void save(TbReply5 item) {
		this.tbReplyDAO.save(item);
		
	}

	public void save(TbReply7 item) {
		this.tbReplyDAO.save(item);
		
	}

	public List findMsgByAttr1(String id) {
		return this.tbReplyDAO.findMsgByAttr1(id);
	}

	public void save(TbObligeeMsg item) {
		this.tbReplyDAO.save(item);
		
	}

	public List findOpinionByAttr1(String id) {
		return this.tbReplyDAO.findOpinionByAttr1(id);
	}

	public void save(TbObligeeOpinion item) {
		this.tbReplyDAO.save(item);
	}
	
	
}
