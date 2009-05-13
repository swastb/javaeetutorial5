package com.baosight.mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthMode {
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 部门ID
	 */
	private String deptId;

	/**
	 * 岗位名称
	 */
	private String postName;

	/**
	 * 岗位ID
	 */
	private String postId;
	/**
	 * 子系统列表
	 */
	private List appList = new ArrayList();
	/**
	 * key:TbAppsys的id
	 * value:TbAuthInfo集合
	 */
	private Map authMap = new HashMap();
	/**
	 * key:TbAppsys的id
	 * value:TbFunction集合
	 */
	private Map funMap = new HashMap();	
	/**
	 * key:TbFunction的id
	 * value:TbRighttype集合
	 */
	private Map rightTypeMap = new HashMap();	
}
