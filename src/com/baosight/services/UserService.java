package com.baosight.services;

public interface UserService {

	/**
	 * 根据登录名和密码检查是否注册用户
	 * @param name
	 * @param password
	 * @return
	 */
	boolean checkUser(String name, String password);

}
