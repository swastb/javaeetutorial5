package com.baosight.base.dao.impl;

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

import com.baosight.base.dao.ITbMeetingDAO;
import com.baosight.mode.TbAuthlvl;
import com.baosight.mode.TbMeeting;

/**
 * Data access object (DAO) for domain model class TbMeeting.
 * 
 * @see com.baosight.mode.TbMeeting
 * @author MyEclipse Persistence Tools
 */

public class TbMeetingDAOImpl extends HibernateDaoSupport implements
		ITbMeetingDAO {
	private static final Log log = LogFactory.getLog(TbMeetingDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String MEETING_SN = "meetingSn";

	public static final String TITLE = "title";

	public static final String MEETINGROOM = "meetingroom";

	public static final String PRESIDER = "presider";

	public static final String FEE = "fee";

	public static final String PARTICIPANT = "participant";

	public static final String NOTIFY = "notify";

	public static final String STATUS = "status";

	public static final String LVL = "lvl";

	public static final String TOPIC = "topic";

	public static final String REM = "rem";

	public static final String DEPT = "dept";

	public static final String YEAR_MONTH = "yearMonth";

	public static final String ATTR2 = "attr2";
	
	public static final String PRESIDERNAME = "presidername";
	
	public static final String PARTICIPANTNAME = "participantname";
	
	public static final String PRESIDE_DEPT = "presideDept";

	public static final String PARTICIPANT_DEPT = "participantDept";

	public static final String SCHEDULE = "schedule";

	public static final String PID = "pid";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#save(com.baosight.mode.TbMeeting)
	 */
	public void save(TbMeeting transientInstance) {
		log.debug("saving TbMeeting instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#delete(com.baosight.mode.TbMeeting)
	 */
	public void delete(TbMeeting persistentInstance) {
		log.debug("deleting TbMeeting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findById(java.lang.String)
	 */
	public TbMeeting findById(java.lang.String id) {
		log.debug("getting TbMeeting instance with id: " + id);
		try {
			TbMeeting instance = (TbMeeting) getHibernateTemplate().get(
					"com.baosight.mode.TbMeeting", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByExample(com.baosight.mode.TbMeeting)
	 */
	public List findByExample(TbMeeting instance) {
		log.debug("finding TbMeeting instance by example");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbMeeting instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbMeeting as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByMeetingSn(java.lang.Object)
	 */
	public List findByMeetingSn(Object meetingSn) {
		return findByProperty(MEETING_SN, meetingSn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByMeetingroom(java.lang.Object)
	 */
	public List findByMeetingroom(Object meetingroom) {
		return findByProperty(MEETINGROOM, meetingroom);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByPresider(java.lang.Object)
	 */
	public List findByPresider(Object presider) {
		return findByProperty(PRESIDER, presider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByFee(java.lang.Object)
	 */
	public List findByFee(Object fee) {
		return findByProperty(FEE, fee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByParticipant(java.lang.Object)
	 */
	public List findByParticipant(Object participant) {
		return findByProperty(PARTICIPANT, participant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByNotify(java.lang.Object)
	 */
	public List findByNotify(Object notify) {
		return findByProperty(NOTIFY, notify);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByLvl(java.lang.Object)
	 */
	public List findByLvl(Object lvl) {
		return findByProperty(LVL, lvl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByTopic(java.lang.Object)
	 */
	public List findByTopic(Object topic) {
		return findByProperty(TOPIC, topic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByDept(java.lang.Object)
	 */
	public List findByDept(Object dept) {
		return findByProperty(DEPT, dept);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByAttr1(java.lang.Object)
	 */
	public List findByYearMonth(Object yearMonth) {
		return findByProperty(YEAR_MONTH, yearMonth);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbMeeting instances");
		try {
			String queryString = "from TbMeeting";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#merge(com.baosight.mode.TbMeeting)
	 */
	public TbMeeting merge(TbMeeting detachedInstance) {
		log.debug("merging TbMeeting instance");
		try {
			TbMeeting result = (TbMeeting) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#attachDirty(com.baosight.mode.TbMeeting)
	 */
	public void attachDirty(TbMeeting instance) {
		log.debug("attaching dirty TbMeeting instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#attachClean(com.baosight.mode.TbMeeting)
	 */
	public void attachClean(TbMeeting instance) {
		log.debug("attaching clean TbMeeting instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbMeetingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbMeetingDAO) ctx.getBean("TbMeetingDAO");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbMeetingDAO#update(com.baosight.mode.TbMeeting)
	 */
	public void update(TbMeeting instance) {
		log.debug("update TbMeeting instance");
		try {
			getHibernateTemplate().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
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

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}
}