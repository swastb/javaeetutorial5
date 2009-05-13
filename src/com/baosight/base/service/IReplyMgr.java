package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbObligeeMsg;
import com.baosight.mode.TbObligeeOpinion;
import com.baosight.mode.TbReply5;
import com.baosight.mode.TbReply6;
import com.baosight.mode.TbReply7;

public interface IReplyMgr {
	public int findCount(String tbName);
	
	public void save(TbReply6 item);
	
	public void save(TbReply5 item);
	
	public void save(TbReply7 item);
	
	public void save(TbObligeeMsg item);
	
	public void save(TbObligeeOpinion item);
	
	public List findByAttr1(String id);
	
	public List findReply5ByAttr1(String id);
	
	public List findReply7ByAttr1(String id);
	
	public List findMsgByAttr1(String id);
	
	public List findOpinionByAttr1(String id);
}
