package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbUser;


public interface IDocSendDealMgr {

	public static final String DEPTLEADER="8a9981af1bbf23a3011bbf47c1c70003";
	public static final String LEADER="8a9981af1bbf23a3011bbf4a4b700004";
	public static final String PRINTROOM="8a9981a81bd89eca011bd90191eb0017";
	public static final String DRAFT="9f90831b1cf3d17e011cf43c22a40003";
	public static final String SIGNSEND="9f90831b1cf3d17e011cf43ddac40004";
	
	public abstract List findDocSendList(TbUser user,String type);
	/*新起草的收文删除*/
	public abstract void deleteSendDoc(String docId);
	/*查看*/
	public abstract TbDocSend findSendDocById(String docId);
	/* 催办通知 --找被催办的相关人 */
	public abstract List findPersonByDocId(String docId);
	/*判断该发文是否可以取回*/
	public abstract boolean isCanRollBack(String docId,String closetime);
	/*取回该发文*/
	public abstract void docSendRollBack(String docId,TbUser user);
	/*选择用户列表*/
	public List findUserByRoleList(String roleId,TbUser user);
	/*成文机关、主送、抄送*/
	public abstract List findDeptList(String type);
	/*主题词*/
	public abstract List findTypeList(long style);
	public abstract List findGongWenTypeList(long style);
	
}
