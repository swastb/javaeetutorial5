package com.baosight.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbYuanshuishujubiaoDAO;

/**
 * Data access object (DAO) for domain model class TbYuanshuishujubiao.
 * 
 * @see com.baosight.mode.TbYuanshuishujubiao
 * @author MyEclipse Persistence Tools
 */

public class TbYuanshuishujubiaoDAOImpl extends HibernateDaoSupport
		implements ITbYuanshuishujubiaoDAO {

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbYuanshuishujubiaoDAO#findBySql(String)
	 */
	public List<Object> findBySql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

}