package com.baosight.base.dao;

import java.util.List;

public interface ITbSmsUserDAO {
	public List findAllUserName() ;
	public List findByUserName(String departId);
}
