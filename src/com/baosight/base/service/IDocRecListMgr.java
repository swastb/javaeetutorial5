package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbDocUrgent;
import com.baosight.mode.TbUser;


public interface IDocRecListMgr {

	/* 新收到的收文 */
	public abstract List findNewReceiveList(TbUser user);
	/*正在办理的收文*/
	public abstract List findDisposingList(TbUser user);
	/*可监控的收文*/
	public abstract List findCanMonitorList(TbUser user);
	/*已办理的收文*/
	public abstract List findDisposedList(TbUser user);
	/*新起草的收文*/
	public abstract List findBookingList(TbUser user);
	/*新起草的收文删除*/
	public abstract void deleteRecDoc(String docId);
	/*上海市水务信息中心公文处理单（查看）*/
	public abstract TbDocRec findReceiveDocById(String docId);
	/* 审查流转单 */
	public abstract List findSCLZDById(String docId);
	/* 催办通知 --找被催办的相关人 */
	public abstract List findPersonByDocId(String docId);
	/* 催办通知 --保存 */
	public void saveDocUrgentObj(TbDocUrgent docUrgent);
}
