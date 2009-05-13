package com.baosight.base.service;

import java.util.Collection;
import java.util.List;

import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserdept;
import com.baosight.mode.TbUserinfo;

public interface ITbUserMgr {

	String checkUser(String string, String string2, String key);

	Collection getChildren(String parentId);

	TbUser findByNameAndPwd(String username, String password);

	TbUser find(String id);

	boolean delete(String nodeId);

	void save(TbUser item, String type);

	void update(TbUser item);

	List findByLVL(String lvl);

	List findAll();

	public String checkName(String id, String name, String field);

	public String selectUsers(String ids);

	public boolean isValid(String loginName, String password);

	/**
	 * 节点移动
	 * 
	 * @param parentId
	 * @param nodeId
	 * @param type
	 */
	public void upDownMoveS(String parentId, String nodeId, String defOrder,
			String type);

	/**
	 * 取deforder的最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public long findMaxDefOrder(String parentId);

	public void cacheUpdate(TbUser item);

	/**
	 * 找用户所在职位的部门ID
	 * 
	 * @param parentId
	 * @return
	 */
	public String findDeptIdForUser(String parentId);

	public String authCA(String capassword);

	/**
	 * 根据用户名查询用户
	 */
	public TbUser findUserByName(String name);
	public TbUser checkSSL(String key);	
	public void checkWorkFlowUser(TbUser user,String newLoginName);
	public List getUserNameAndId(String deptCode);

	/**
	 * <p>Decription:查找部门下所有用户，包括子部门的</p>
	 * @param rootDeptId 根节点的部门Id
	 * @return 用户列表
	 * @author heaton.cai
	 * <p>Create Time:2008-10-29</p>
	 */
	public List find4Tree(String rootDeptId);
	/**
	 * 获取用户所属用户类型
	 * @return
	 */
	public String getUserDept(String id);
	/**
	 * 根据用户登录名和KEY获取密码
	 * @param userId
	 * @param cert
	 * @return
	 */
	public String getPwdForAutoCert(String userLogin,String cert);	
	
	/**
	 * 获取用户所属用户部门
	 * @return
	 */
	public TbUserdept findByUserId(String id);
	/**
	 * 判断用户是否属于所给定部门
	 * 是返回true，不是返回false
	 * @return
	 */
	public boolean isForDeptOfUser (TbUser user, String deptId);

	public TbUserdept findUserDeptByUserId(String id);
	/**
	 * 判断当前用户与CA是否一致
	 * @param userName
	 * @param caIdentity
	 * @return
	 */
	public String caAuth(String userName,String caIdentity);
}
