package com.baosight.base.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbSmsScheduleDAO;
import com.baosight.mode.TbSmsSchedule;

/**
 * Data access object (DAO) for domain model class TbSmsSchedule.
 * 
 * @see com.baosight.mode.TbSmsSchedule
 * @author MyEclipse Persistence Tools
 */

public class TbSmsScheduleDAOImpl extends HibernateDaoSupport implements ITbSmsScheduleDAO {
	private static final Log log = LogFactory.getLog(TbSmsScheduleDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String DEST_NUMBER = "destNumber";

	public static final String MESSAGE_CONTENT = "messageContent";

	public static final String FLAG = "flag";

	public static final String DEPARTID = "departid";

	public static final String SENDUSERID = "senduserid";

	public static final String SENDDEPARTID = "senddepartid";

	public static final String BZ = "bz";

	public static final String SEND_BY = "sendBy";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#save(com.baosight.mode.TbSmsSchedule)
	 */
	public void save(TbSmsSchedule transientInstance) {
		log.debug("saving TbSmsSchedule instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}


	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#delete(com.baosight.mode.TbSmsSchedule)
	 */
	public void delete(TbSmsSchedule persistentInstance) {
		log.debug("deleting TbSmsSchedule instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findById(java.lang.String)
	 */
	public TbSmsSchedule findById(java.lang.String id) {
		log.debug("getting TbSmsSchedule instance with id: " + id);
		try {
			TbSmsSchedule instance = (TbSmsSchedule) getHibernateTemplate()
					.get("com.baosight.mode.TbSmsSchedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByExample(com.baosight.mode.TbSmsSchedule)
	 */
	public List findByExample(TbSmsSchedule instance) {
		log.debug("finding TbSmsSchedule instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbSmsSchedule instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbSmsSchedule as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByDestNumber(java.lang.Object)
	 */
	public List findByDestNumber(Object destNumber) {
		return findByProperty(DEST_NUMBER, destNumber);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByMessageContent(java.lang.Object)
	 */
	public List findByMessageContent(Object messageContent) {
		return findByProperty(MESSAGE_CONTENT, messageContent);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findBySystype(java.lang.Object)
	 */
	public List findBySystype(Object systype) {
		return findByProperty(SYSTYPE, systype);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByFlag(java.lang.Object)
	 */
	public List findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByDepartid(java.lang.Object)
	 */
	public List findByDepartid(Object departid) {
		return findByProperty(DEPARTID, departid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findBySenduserid(java.lang.Object)
	 */
	public List findBySenduserid(Object senduserid) {
		return findByProperty(SENDUSERID, senduserid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findBySenddepartid(java.lang.Object)
	 */
	public List findBySenddepartid(Object senddepartid) {
		return findByProperty(SENDDEPARTID, senddepartid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findByBz(java.lang.Object)
	 */
	public List findByBz(Object bz) {
		return findByProperty(BZ, bz);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findBySendBy(java.lang.Object)
	 */
	public List findBySendBy(Object sendBy) {
		return findByProperty(SEND_BY, sendBy);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbSmsSchedule instances");
		try {
			String queryString = "from TbSmsSchedule";
			return findByHQL(queryString, true, -1, -1);
			//return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findByHQL(final String hql, final boolean cacheable,
			final int startIndex, final int maxResultCount) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				if (cacheable) {
					query.setCacheable(true);
					if (getQueryCacheRegion() != null) {
						query.setCacheRegion(getQueryCacheRegion());
					}
				}
				if (maxResultCount != -1)
					query.setMaxResults(maxResultCount);
				if (startIndex != -1)
					query.setFirstResult(startIndex);
				return query.list();
			}
		}, true);
	}
	
	private String queryCacheRegion = null;
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#merge(com.baosight.mode.TbSmsSchedule)
	 */
	public TbSmsSchedule merge(TbSmsSchedule detachedInstance) {
		log.debug("merging TbSmsSchedule instance");
		try {
			TbSmsSchedule result = (TbSmsSchedule) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#attachDirty(com.baosight.mode.TbSmsSchedule)
	 */
	public void attachDirty(TbSmsSchedule instance) {
		log.debug("attaching dirty TbSmsSchedule instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbSmsScheduleDAO#attachClean(com.baosight.mode.TbSmsSchedule)
	 */
	public void attachClean(TbSmsSchedule instance) {
		log.debug("attaching clean TbSmsSchedule instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbSmsScheduleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbSmsScheduleDAO) ctx.getBean("tbSmsScheduleDAO");
	}
	public List findSmsRecord(TbSmsSchedule tss,String startTime,String endTime) {
		log.debug("finding all TbSmsSchedule instances");
		try {
			StringBuilder queryStr = new StringBuilder();
			queryStr.append("select new com.baosight.mode.SmsRecordDept").
			append("(ts.messageContent,tu.name,td.name,ts.scheduletime,ts.userid,ts.destNumber) ").
			append("from TbSmsSchedule ts,TbDept td,TbUser tu where ts.senduserid = tu.id(+) and ts.senddepartid = td.id(+)")
			;
		
			if(tss.getSenddepartid() !=null && !"".equals(tss.getSenddepartid())){
				queryStr.append(" and ts.senddepartid='"+tss.getSenddepartid()+"'");
			}
			if(tss.getUserid() != null && !"".equals(tss.getUserid())){
				queryStr.append(" and ts.userid='"+tss.getUserid()+"'");
			}
			if(tss.getDestNumber()!=null && !"".equals(tss.getDestNumber())){
				queryStr.append(" and ts.destNumber like '%"+tss.getDestNumber()+"%'");
			}
			if(tss.getMessageContent()!=null && !"".equals(tss.getMessageContent())){
				queryStr.append(" and ts.messageContent like '%"+tss.getMessageContent()+"%'");
			}
			if(startTime!=null && !"".equals(startTime)){
				// DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
				if(endTime!=null && !"".equals(endTime)){
					queryStr.append(" and ts.scheduletime>=to_date('"+startTime+"','yyyy-MM-dd hh24:mi:ss') and ts.scheduletime<=to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss')");
				}else{
					queryStr.append(" and ts.scheduletime>=to_date('"+startTime+"','yyyy-MM-dd hh24:mi:ss')");
				}
			}
			String queryString = queryStr.toString();
			System.out.println("queryString ="+queryString);
			return this.findByHQL(queryString, true, -1, -1);
		}catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
//		catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
	}
}