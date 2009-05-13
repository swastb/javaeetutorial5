package com.baosight.services.impl;

import java.util.Iterator;
import java.util.List;

import com.baosight.dao.TUser;
import com.baosight.dao.TUserDAO;
import com.baosight.services.UserService;
import com.baosight.tools.EncryptMachine;
import com.baosight.tools.GetEncryptMachineTool;

public class UserServiceImpl implements UserService {

	private TUserDAO userDao;

	public void setUserDao(TUserDAO userDao) {
		this.userDao = userDao;
	}

	public boolean checkUser(String name, String password) {
		// È¡µÃ¼ÓÃÜÆ÷
		EncryptMachine em = GetEncryptMachineTool.getEncryptMachine();
		List users = this.userDao.findAll();// .findByProperty("ENAME", name);
		Iterator iter = users.iterator();
		while (iter.hasNext()) {
			TUser user = (TUser) iter.next();
			if (user.getId().getEname().equals(name)
					&& user.getId().getPassword().equals(
							em.getEncryptData(password, "userpassword"))) {
				return true;
			}
		}
		return false;
	}

}
