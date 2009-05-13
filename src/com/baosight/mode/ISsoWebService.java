package com.baosight.mode;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface ISsoWebService {

	/**
	 * 查询登录用户信息
	 * 
	 * @param loginName:登录名
	 * @return UserInfo对象
	 */
	public UserInfo getUserInfo(String loginName, String uuid);

	/**
	 * 查询用户信息服务
	 * 
	 * @param UserId
	 *            用户标识
	 * @param UserName
	 *            用户名
	 * @param UserLevel
	 *            用户级别
	 * @param Department
	 *            用户所属组织
	 * @return
	 */
	public User getUser(String UserId, String UserName, String UserLevel,
			String Department);

	/**
	 * 查询部门信息服务
	 * 
	 * @param DeptCode
	 *            部门编号
	 * @param DeptName
	 *            部门名称
	 * @param Superior
	 *            上级部门编号
	 * @param DeptLevel
	 *            部门级别
	 * @return
	 */
	public Dept getDept(String DeptCode, String DeptName, String Superior,
			String DeptLevel);
	/**
	 * 获取部门的用户列表服务
	 * @param DeptCode 部门编号
	 * @param DeptName 部门名称
	 * @return
	 */
	public List <User> getUserInfoByDept(String DeptCode,String DeptName); 
	/**
	 * 获取部门的用户组列表服务
	 * @param DeptCode 部门编号
	 * @param DeptName 部门名称
	 * @return
	 */	
	public List <UserGroup> getUserGroupByDept(String DeptCode,String DeptName);
	/**
	 * 获取用户组的用户列表服务
	 * @param GroupCode 用户组编号
	 * @return
	 */
	public List <User> getUserInfoByGroup(String GroupCode);
}