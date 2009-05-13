package com.baosight.base.dao;

import java.util.List;

public interface ITbYuanshuishujubiaoDAO {

	//根据站点ID查询
	public List<Object> findBySql(String sql);

}