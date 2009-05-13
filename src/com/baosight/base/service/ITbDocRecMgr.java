package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocControl;
import com.baosight.mode.TbDocRec;

public interface ITbDocRecMgr {

	//当前处理状态
	public final static String STATE_CLOSED= "0";//已处理
	public final static String STATE_NEW = "1";//未处理
	public final static String STATE_DISPOSING = "2";//处理中
	public final static String STATE_NEWBOOK = "3";//新起草
	public final static String STATE_CAN_MONITOR = "4";//可监控
	public final static String STATE_WAIT_DISPOSE = "5";//等待处理

	public final static String STATE_NAME_NEW = "新收到";
	public final static String STATE_NAME_NEWBOOK = "新起草";
	public final static String STATE_NAME_BOOKED = "来文登记";
	public final static String STATE_NAME_DISPOSE = "拟办";
	public final static String STATE_NAME_MAIN_DEPT = "主办部门办理";
	public final static String STATE_NAME_MAIN_PERSON = "主办人员办理";
	public final static String STATE_NAME_SECEND_DEPT = "协办部门处理";
	public final static String STATE_NAME_LEADER = "领导处理";
	public final static String STATE_NAME_ARCHIVE = "已归档";
	public final static String STATE_NAME_PERSON = "相关人员处理";
	public final static String STATE_NAME_END = "处理结束";
	public final static String STATE_NAME_READ = "传阅中";

	//处理类型
	public final static String STATE_TYPE_OTHER = "0";//拟办或者新起草
	public final static String STATE_TYPE_LEADER = "1";//领导处理
	public final static String STATE_TYPE_MAIN_DEPT = "2";//主办部门处理
	public final static String STATE_TYPE_SECEND_DEPT = "3";//协办部门处理(填写办理情况)
	public final static String STATE_TYPE_PERSON = "4";//相关人员处理
	public final static String STATE_TYPE_READ = "5";//传阅
	public final static String STATE_TYPE_NEW = "6";//新收到的起草收文

	public void save(TbDocRec transientInstance);

	public void delete(TbDocRec persistentInstance);

	public TbDocRec findById(java.lang.String id);

	public List findByExample(TbDocRec instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();

	public TbDocRec merge(TbDocRec detachedInstance);

	public void saveControl(TbDocControl instance);

	public TbDocControl findControlById(String controlId);

	public TbDocControl findCuruserControl(String userId,String docId);

	/**
	 * <p>Decription:所有信息等级列表</p>
	 * @return List-TbDocInfoLevelSeq
	 * @author heaton.cai
	 * <p>Create Time:2008-8-1</p>
	 */
	public List findAllInfoLevel();

	/**
	 * <p>Decription:获取当前该等级的序列号，并给当前序列号+1</p>
	 * @param level 当前等级
	 * @return 当前等级序列号
	 * @author heaton.cai
	 * <p>Create Time:2008-8-1</p>
	 */
	public String getCurInfoLevel(String level);

	/**
	 * <p>Decription:找到所有的任务列表</p>
	 * @param docId
	 * @return List-TbDocControl
	 * @author heaton.cai
	 * <p>Create Time:2008-8-5</p>
	 */
	public List findNextControl(String docId);

	public void deleteControl(TbDocControl instance);

	public List findNotClosedControl(String docId);

	public List findNotClosedControl(String docId,String stateType);
	
	public List findDisposeNext(String docId);

	public List findControl(String docId,String type);

	/**
	 * <p>Decription:findBookControl</p>
	 * @param docId
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public TbDocControl findBookControl(String docId);
}
