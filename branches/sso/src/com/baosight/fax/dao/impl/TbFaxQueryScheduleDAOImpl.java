package com.baosight.fax.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.fax.dao.TbFaxQueryScheduleDAO;
import com.baosight.fax.mode.TbFaxSchedule;

public class TbFaxQueryScheduleDAOImpl extends DAOHelperImpl implements TbFaxQueryScheduleDAO{
	private static final Log log = LogFactory.getLog(TbFaxScheduleDAOImpl.class);
	
	public List findList(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}	
	public TbFaxSchedule findById(java.lang.String id) {
		log.debug("getting TbFaxSchedule instance with id: " + id);
		try {
			TbFaxSchedule instance = (TbFaxSchedule) getHibernateTemplate()
					.get("com.baosight.fax.mode.TbFaxSchedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
