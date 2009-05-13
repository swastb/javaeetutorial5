package com.baosight.base.service;

import java.util.List;
import java.util.Map;

import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.DBSY;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;

public interface IFunctionMgr {
	/**
	 * 待办事宜信息公开资源KEY
	 */
	public static final String DBSYAUDIT_XXGK="GovInfoPub";//信息公开
	public static final String DBSY_VEHICLE="Vehicle Management";//车辆
	public static final String DBSY_ADMINISTRAT="dbsx";//行政许可
	public static final String DBSY_MYMAIL="EMAIL";//我的邮件
	public static final String DBSY_FILETRANSMISSION="File transfer";//文件传送
	public static final String DBSY_ARCHIVES="Document Management";//档案管理
	public static final String DBSY_MYMESSAGE="";//我的短信
	public static final String DBSY_COUNSULT="Internet Advisory";//网上咨询
	public static final String DBSY_COUNSULTZB="Internet Advisory Office";//网上咨询专办
	public static final String DBSY_COUNSULTLEADAPPROVE="Online advice sought";//网上咨询待领导审批
	public static final String DBSY_APPEAL="Online complaints";//网上投诉
	public static final String DBSY_APPEALZB="Online complaints Office";//网上投诉专办
	public static final String DBSY_APPEALLEADAPPROVE="Online complaints consultation";//网上投诉待领导审批
	public static final String DBSY_DIRECTORWAIT="director_mailBox";//局长信息待办
	public static final String DBSY_DIRECTORZB="director_mailBox_transfer";//局长信息转办
	public static final String DBSY_DIRECTORLEADAPPROVE="director_mailBox_consult";//局长信息待领导审批
	public static final String DBSY_XZXK_CC="CC";//行政许可抄送
	public static final String DBSY_XZXK_Urger="MyUrger";//行政许可催办
	public static final String DBSY_XZXK_Commission="commission";//委托管理委托
	
	public void save(TbFunction tbfunction);

	public void delete(TbFunction tbfunction);

	public void update(TbFunction tbfunction);

	public TbFunction findById(String id);

	public List findAll();

	public void save(DynaValidatorForm form);

	public void delete(String id);

	public void update(DynaValidatorForm form, String insure);

	public List findAllForTree(String fid);

	public void save(DynaValidatorForm form, String root);

	public List findAllRightType();

	public List findRightTypeByFunction(TbFunction tbfunction);
	
	public List findAllRole();
	
	public Map findFunByRid(String rid);
	
	public List findFunForRole();
	
	public void toAuth(String rid,String [] funList,String [] isDefList);
	
	public boolean isChecked(TbFunction tbFunction,String rid);
	
	public List findAllAppSys();
	
	public List findFunBySysId(String sysId);
	
	public List findRightTypeByRidAndFid(String fid,String rid);
	
	public List findAllForTreeInsure(String fid);
	
	public String checkName(String id,String name,String fid,String field);
	/*cheng begin*/
	/*根据父ID取新加资源顺位的默认值*/
	public int getDeforderByParId(String parid);
	/*找统一门户第一层资源*/
	public List findFirstLevelRes(TbUser user);
	/*找统一门户第二层资源*/
	public List findSecondLevelRes(TbUser user,TbFunction tbFunction);
	/*个性化设置－取已经设置的资源*/
	public List findAllSetByUser(TbUser user);
	/*个性化设置－取所有的资源*/
	public List findAllRes(TbUser user);
	/*保存资源设置*/
	public List saveResSet(TbUser user,String[] resIds,String sysId);
	/*取当前登陆用户所拥有的对信息栏目操作的角色*/
	public List findInfoRolesUserList(TbUser user);
	/*cheng end*/
	
	/**
	 * 获取待办事宜权限
	 * @param userId
	 * @param funKey
	 * @return DBSY
	 * @author lqs 2008-09-26
	 */
	public DBSY getDBSYAuthInfo(String userId, String funKey);
	/**
	 * 当前用户个性化定制信息
	 * @param user
	 * @return
	 */
	public String getPersonalInfo(TbUser user);
	
}
