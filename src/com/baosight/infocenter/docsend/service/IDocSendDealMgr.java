package com.baosight.infocenter.docsend.service;

import java.util.List;

import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.mode.TbUser;


public interface IDocSendDealMgr {

	public static final String DEPTLEADER="9f90831d1c98aa42011c98bcfebb0004";
	public static final String LEADER="9f90831d1c98aa42011c98bec84f0005";
	public static final String PRINTROOM="9f90831d1c98aa42011c98bac39f0003";
	
	public abstract List findDocSendList(TbUser user,String type);
	/*新起草的收文删除*/
	public abstract void deleteSendDoc(String docId);
	/*查看*/
	public abstract TbDocSendXxzx findSendDocById(String docId);
	/* 催办通知 --找被催办的相关人 */
	public abstract List findPersonByDocId(String docId);
	/*判断该发文是否可以取回*/
	public abstract boolean isCanRollBack(String docId,String closetime);
	/*取回该发文*/
	public abstract void docSendRollBack(String docId,TbUser user);
	/*选择用户列表*/
	public abstract List findUserByRoleList(String roleId,TbUser user);
	/*成文机关、主送、抄送*/
	public abstract List findDeptList(String type);
	/*主题词*/
	public abstract List findTypeList(long style);
	public abstract List findGongWenTypeList(long style);
}
