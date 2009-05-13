package com.baosight.infocenter.docsend.service;

import java.util.List;

import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.mode.TbDocsendControlXxzx;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:IDocSendMgr</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public interface IDocSendMgr {

	public void save(TbDocSendXxzx instance);

	public void delete(TbDocSendXxzx instance);

	public TbDocSendXxzx findById(String id);

	public void saveControl(TbDocsendControlXxzx instance);

	public void deleteControl(TbDocsendControlXxzx instance);

	public TbDocsendControlXxzx findControlById(String controlId);

	/**
	 * <p>Decription:活动中的任务</p>
	 * @param docId 发文Id
	 * @param stateType 可选，状态类别
	 * @return 返回state in ('1','2')的任务
	 * @author heaton.cai
	 * <p>Create Time:2008-8-14</p>
	 */
	public List findActiveControl(String docId,String stateType);

	public List findClosedControl(String docId);

	public TbUser getPrinter();
	
	//步骤名称
	public final static String STATE_NAME_NEWBOOK = "新起草";
	public final static String STATE_NAME_CHARGER = "负责人处理";
	public final static String STATE_NAME_LEADER = "领导处理";
	public final static String STATE_NAME_PRINTER = "文印室处理";
	public final static String STATE_NAME_END = "处理结束";
	
	//处理状态
	public final static String STATE_END = "0";
	public final static String STATE_NEW = "1";
	public final static String STATE_DISPOSE = "2";
	public final static String STATE_BOOKING = "3";

	//步骤类型
	public final static String STATE_TYPE_DRAFTER = "0";//拟稿人
	public final static String STATE_TYPE_CHARGER = "1";//负责人
	public final static String STATE_TYPE_LEADER = "2";//领导处理
	public final static String STATE_TYPE_PRINTER = "3";//文印室
}
