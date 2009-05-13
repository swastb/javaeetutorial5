package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbDocsendControl;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:IDocSendMgr</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-13</p>
 */
public interface IDocSendMgr {

	public void save(TbDocSend instance);

	public void delete(TbDocSend instance);

	public TbDocSend findById(String id);

	public void saveControl(TbDocsendControl instance);

	public void deleteControl(TbDocsendControl instance);

	public TbDocsendControl findControlById(String controlId);

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

	/**
	 * <p>Decription:办公室负责人</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public TbUser getOfficeCharger();

	/**
	 * <p>Decription:文印室负责人</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public TbUser getPrinter();

	/**
	 * <p>Decription:办公室拟办人</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-13</p>
	 */
	public TbUser getDrafter();

	/**
	 * <p>Decription:办公室审签人</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-10-13</p>
	 */
	public TbUser getSignsender();
	
	//步骤名称
	public final static String STATE_NAME_NEWBOOK = "新起草";
	public final static String STATE_NAME_DEPT_LEADERORRESPONSER = "部门领导或负责人处理";
	public final static String STATE_NAME_SIGN = "会签";
	public final static String STATE_NAME_OFFICER = "局办公室负责人处理";
	public final static String STATE_NAME_DRAFT = "局办公室拟办";
	public final static String STATE_NAME_SIGN_SEND = "审签";
	public final static String STATE_NAME_PRINTER = "文印室处理";
	public final static String STATE_NAME_END = "处理结束";
	
	//处理状态
	public final static String STATE_END = "0";
	public final static String STATE_NEW = "1";
	public final static String STATE_DISPOSE = "2";
	public final static String STATE_BOOKING = "3";

	//步骤类型
	public final static String STATE_TYPE_DRAFTER = "0";//拟稿人
	public final static String STATE_TYPE_DEPT_LEADERORRESPONSER = "1";//部门领导或负责人
	public final static String STATE_TYPE_SIGN = "2";//会签
	public final static String STATE_TYPE_OFFICER = "3";//局办公室负责人处理
	public final static String STATE_TYPE_PRINTER = "4";//文印室
	public final static String STATE_TYPE_DRAFT = "5";
	public final static String STATE_TYPE_SIGN_SEND = "6";
}
