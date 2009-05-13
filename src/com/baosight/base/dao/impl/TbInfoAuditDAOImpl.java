package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbInfoAuditDAO;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbOpinionConsult;

public class TbInfoAuditDAOImpl extends HibernateDaoSupport implements ITbInfoAuditDAO{
	private static final Log log = LogFactory.getLog(TbInfoAuditDAOImpl.class);

	public List findByStatus(String condition) {
		String whereString="";
		String queryString;
		if(condition.equals("audited_pass")){ //审核通过数据
			whereString="where status in ('8','16','8200','32768','65536')";
		}else if(condition.equals("audited_notPass")){//审核未通过数据
			whereString="where status in ('4096','128','64','256','1024','16384','12298')";
		}else if(condition.equals("auditing")){//审核中数据
			whereString="where status in ('2','32','131072','262144')";
		}else if(condition.equals("invalidApply")){//无效申请数据
			whereString="where status ='524288'";
		}else if(condition.equals("notAccept")){ //不予受理数据
			whereString="where status = '2048'"; 
		}
		try {
			queryString = "from TbGovInfoPubAudit "+whereString;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findAuditingCount() {
		String sql="select count(*) c from tb_Gov_Info_Pub_Audit where status in ('2','32','131072','262144')";
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
	public TbGovInfoPub findById(String id) {
		log.debug("getting TbAppsys instance with id: " + id);
		try {
			TbGovInfoPub instance = (TbGovInfoPub) getHibernateTemplate().get(
					"com.baosight.mode.TbGovInfoPub", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbOpinionConsult item) {
		log.debug("saving  instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}

	public List findByFKId(String id) {
		log.debug("getting TbOpinionConsult instance with id: " + id);
		try {
			String queryString ="from TbOpinionConsult t where t.govInfoId='"+id+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void update(TbOpinionConsult item) {
		log.debug("update  instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void updateStatus(TbGovInfoPub item) {
		log.debug("update  instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	
}
