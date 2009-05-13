package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbNotiesDAO;

public class TbNotiesDAOImpl extends HibernateDaoSupport implements ITbNotiesDAO{
	private static final Log log = LogFactory.getLog(TbNotiesDAOImpl.class);
	
	public List findByParam(String param) {
		String queryString;
		//if("".equals(param)){
			queryString = "from TbNoties ";
		//}else {
		//	queryString = "from TbMessages where receivers_Name='"+param+"'";
		//}
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
