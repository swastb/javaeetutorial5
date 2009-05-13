package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbReplyDAO;
import com.baosight.mode.TbObligeeMsg;
import com.baosight.mode.TbObligeeOpinion;
import com.baosight.mode.TbReply5;
import com.baosight.mode.TbReply6;
import com.baosight.mode.TbReply7;

public class TbReplyDAOImpl extends HibernateDaoSupport implements ITbReplyDAO{
	private static final Log log = LogFactory.getLog(TbReplyDAOImpl.class);
	
	public List findCount(String tbName) {
		String sql="select count(*)from "+tbName+"";
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

	public void save(TbReply6 item) {
		log.debug("saving TbReply6 instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public List findByAttr1(String id) {
		String queryString = "from TbReply6 where attr1='"+id+"'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findReply5ByAttr1(String id) {
		String queryString = "from TbReply5 where attr1='"+id+"'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findReply7ByAttr1(String id) {
		String queryString = "from TbReply7 where attr1='"+id+"'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbReply5 item) {
		log.debug("saving TbReply5 instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void save(TbReply7 item) {
		log.debug("saving TbReply7 instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public List findMsgByAttr1(String id) {
		String queryString = "from TbObligeeMsg where attr1='"+id+"'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbObligeeMsg item) {
		log.debug("saving TbObligeeMsg instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public List findOpinionByAttr1(String id) {
		String queryString = "from TbObligeeOpinion where attr1='"+id+"'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void save(TbObligeeOpinion item) {
		log.debug("saving TbObligeeOpinion instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
}
