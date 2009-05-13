package com.baosight.base.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbMessageDAO;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbOaSmsSchedule;

public class TbMessageDAOImpl extends HibernateDaoSupport implements ITbMessageDAO{
	private static final Log log = LogFactory.getLog(TbMessageDAOImpl.class);
	
	/**
	 * 	收件箱
	 * 
	 */
	public List findByParam(String param) {
		String queryString;
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if("".equals(param)){
			queryString = "";
		}else {
			queryString = "from TbMessages where status in ('2','3') and (attr1 is null or attr1!='2')   and send_time < to_date('"+df.format(now)+"','yyyy-mm-dd hh24:mi:ss') and receivers_Id like '%"+param+"%' order by status";
		}
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findNewByReceiverId(String receiverId) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String queryString = "from TbMessages where status='2' and (attr1 is null or attr1!='2')  and send_time < to_date('"+df.format(now)+"','yyyy-mm-dd hh24:mi:ss') and receivers_Id='"+receiverId+"' order by send_time  ";
		return getHibernateTemplate().find(queryString);
	}
	public TbMessages findById(String id) {
		log.debug("getting TbMessages instance with id: " + id);
		try {
			TbMessages instance = (TbMessages) getHibernateTemplate().get(
					"com.baosight.mode.TbMessages", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void delete(TbMessages persistentInstance) {
		log.debug("deleting TbMessages instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void save(TbMessages tbMessages) {
		log.debug("saving TbMessages instance");
		try {
			getHibernateTemplate().save(tbMessages);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveSchedule(TbOaSmsSchedule item) {
		log.debug("saving TbOaSmsSchedule instance");
		try {
			getHibernateTemplate().save(item);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/**
	 * 	发件箱
	 * 
	 */
	public List findselfMessages(String param) { 
		log.debug("finding all TbMessages instances");
		try {
			String queryString = "from TbMessages where  (attr1 is null or attr1!='1') and sender_id ='"+param+"' order by send_time desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void update(TbMessages tbMessages) {
			log.debug("update  instance");
			try {
				getHibernateTemplate().update(tbMessages);
				log.debug("save successful");
			} catch (RuntimeException re) {
				log.error("update failed", re);
				throw re;
			}
		}
	
	/**
	 * 联系电话
	 */
	public List findTel(String userid) {  
		String sql="select HANDSET handset from tb_userinfo where userid in ("+userid+")";
		Query query = getSession().createSQLQuery(sql);
		//Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
	/**
	 * 未读短信条数
	 */
	public List findNotRead(String param) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql="select count(*) c from tb_messages where status='2' and (attr1 is null or attr1!='2') and send_time < to_date('"+df.format(now)+"','yyyy-mm-dd hh24:mi:ss') and receivers_id like '%"+param+"%'";
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	/**
	 * 未读短信信息
	 */
	public List findNotReadMsg(String param) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String queryString = "from TbMessages where status='2' and  (attr1 is null or attr1!='2') and send_time < to_date('"+df.format(now)+"','yyyy-mm-dd hh24:mi:ss') and receivers_id like '%"+param+"%'";	
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public int getNotReadRecordNum(String userid) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String queryString = "from TbMessages where status='2' and (attr1 is null or attr1!='2') and send_time < to_date('"+df.format(now)+"','yyyy-mm-dd hh24:mi:ss') and receivers_id like '%"+userid+"%'";	
		try {
			return getHibernateTemplate().find(queryString).size();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 好友列表
	 */
	public List findAllFriends() {
		log.debug("finding all TbUser instances");
		try {
			String queryString = "from TbFriends";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 所以用户
	 */
	public List findAllUser() {
		log.debug("finding all TbUser instances");
		try {
			String queryString = "from TbUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findByNativeSql(String sql, Class entity) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql).addEntity(entity);
		return query.list();
	}	
}
