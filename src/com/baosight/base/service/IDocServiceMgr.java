package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbDocRec;
import com.baosight.mode.TbDocSend;
import com.baosight.mode.TbUser;

/**
 * <p>Decription:收文管理相关方法</p>
 * @author heaton.cai
 * <p>Create Time:2008-7-31</p>
 */
public interface IDocServiceMgr {

	public static final String UPLOAD_PATH_DOC = "DocReceive";
	public static final String UPLOAD_PATH_DOCSEND = "DocSend";
	public static final String UPLOAD_PATH_FAX = "fax";
	public static final String UPLOAD_TYPE_DOC = "1";//收文
	public static final String UPLOAD_TYPE_DOCSEND = "2";//发文
	public static final String UPLOAD_TYPE_DOCCONTEXT = "3";//发文正文
	public static final String UPLOAD_TYPE_FAX_CONTENT = "4";//传真正文
	public static final String UPLOAD_TYPE_FAX_ATTACH = "5";//传真附件

	//收发文配置的角色Id
	public static final String ROLE_ID_LEADER = "8a9981f11b776225011b7779beeb0005";//收文领导
	
	/**
	 * <p>Decription:判断该用户是否是拟办人或者登记人</p>
	 * @param userId 用户Id
	 * @return 是返回true，否则返回false
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean isDisposerOrBooker(String userId);
	
	/**
	 * <p>Decription:判断该用户是否是拟办人或者登记人</p>
	 * @param userId 用户Id
	 * @param type 1:登记人 2拟办人 3登记人或拟办人
	 * @return 是返回true，否则返回false
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean isDisposerOrBooker(String userId,int type);

	/**
	 * <p>Decription:该用户是否有归档权限</p>
	 * @param userid 用户Id
	 * @return 有返回true，否则false
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public boolean canArchive(String userid);

	/**
	 * <p>Decription:获取拟办人列表</p>
	 * @return List-TbUser 拟办人
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public List getDisposerList();

	/**
	 * <p>Decription:获取某部门的负责人</p>
	 * @param deptId TODO
	 * @return TbUser 部门的负责人，找不到返回nulll
	 * @author heaton.cai
	 * <p>Create Time:2008-7-31</p>
	 */
	public TbUser getDeptDisposer(String deptId);

	/**
	 * <p>Decription:findUserByRoleList</p>
	 * @param roleId
	 * @param user 如果是null则不会判断部门
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public List findUserByRoleList(String roleId,TbUser user);

	/**
	 * <p>Decription:取所有归档类别</p>
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-26</p>
	 */
	public List findAllArchiveType();

	/**
	 * <p>Decription:复制收文内容到发文</p>
	 * @param recId 收文的id
	 * @param user 当前用户
	 * @return 发文新起草的controlId
	 * @author heaton.cai
	 * <p>Create Time:2008-11-3</p>
	 */
	public String copyRec2Send(String recId,TbUser user);

	/**
	 * <p>Decription:归档</p>
	 * @param item
	 * @author heaton.cai
	 * <p>Create Time:2008-11-3</p>
	 */
	public void save2Archives(TbDocRec item,TbUser user);

	/**
	 * <p>Decription:发送到信息中心收文</p>
	 * @param send 发文信息
	 * @author heaton.cai
	 * <p>Create Time:2008-11-24</p>
	 */
	public void sendToInfoRec(TbDocSend send);

	public static final String DEPT_TYPE_JUOA="b205f4e34f4f4d2da5bd89e2e10af37a";//局OA
	public static final String DEPT_TYPE_INFO="ae5532af92f8488994fb632c62423759";//信息中心
	public static final String DEPT_TYPE_SLZX="f410b42455464f8487ee4f86da49b571";//受理中心
}
