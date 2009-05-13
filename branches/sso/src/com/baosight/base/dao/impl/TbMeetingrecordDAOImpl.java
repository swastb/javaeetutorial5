package com.baosight.base.dao.impl;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbMeetingrecordDAO;
import com.baosight.mode.TbMeetingrecord;

/**
 * Data access object (DAO) for domain model class TbMeeting.
 * 
 * @see com.baosight.mode.TbMeeting
 * @author MyEclipse Persistence Tools
 */

public class TbMeetingrecordDAOImpl extends HibernateDaoSupport implements
		ITbMeetingrecordDAO {
	private static final Log log = LogFactory.getLog(TbMeetingrecordDAOImpl.class);

	// property constants
	public static final String MEETINGRECORD_TITLE = "meetingrecordTitle";

	public static final String MEETINGRECORD_NAME = "meetingrecordName";

	public static final String MEETINGRECORD_ADV = "meetingrecordAdv";

	public static final String MEETINGRECORD_REM = "meetingrecordRem";

	public static final String MEETINGRECORD_JOINER = "meetingrecordJoiner";

	public static final String MEETINGRECORD_STATUS = "meetingrecordStatus";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	public void save(TbMeetingrecord transientInstance) {
		log.debug("saving TbMeetingrecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbMeetingrecord transientInstance) {
		log.debug("saving TbMeetingrecord instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbMeetingrecord persistentInstance) {
		log.debug("deleting TbMeetingrecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbMeetingrecord findById(java.lang.String id) {
		log.debug("getting TbMeetingrecord instance with id: " + id);
		try {
			TbMeetingrecord instance = (TbMeetingrecord) getHibernateTemplate()
					.get("com.baosight.mode.TbMeetingrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbMeetingrecord instance) {
		log.debug("finding TbMeetingrecord instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbMeetingrecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbMeetingrecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMeetingrecordTitle(Object meetingrecordTitle) {
		return findByProperty(MEETINGRECORD_TITLE, meetingrecordTitle);
	}

	public List findByMeetingrecordName(Object meetingrecordName) {
		return findByProperty(MEETINGRECORD_NAME, meetingrecordName);
	}

	public List findByMeetingrecordAdv(Object meetingrecordAdv) {
		return findByProperty(MEETINGRECORD_ADV, meetingrecordAdv);
	}

	public List findByMeetingrecordRem(Object meetingrecordRem) {
		return findByProperty(MEETINGRECORD_REM, meetingrecordRem);
	}

	public List findByMeetingrecordJoiner(Object meetingrecordJoiner) {
		return findByProperty(MEETINGRECORD_JOINER, meetingrecordJoiner);
	}

	public List findByMeetingrecordStatus(Object meetingrecordStatus) {
		return findByProperty(MEETINGRECORD_STATUS, meetingrecordStatus);
	}

	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	public List findAll() {
		log.debug("finding all TbMeetingrecord instances");
		try {
			String queryString = "from TbMeetingrecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbMeetingrecord merge(TbMeetingrecord detachedInstance) {
		log.debug("merging TbMeetingrecord instance");
		try {
			TbMeetingrecord result = (TbMeetingrecord) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbMeetingrecord instance) {
		log.debug("attaching dirty TbMeetingrecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbMeetingrecord instance) {
		log.debug("attaching clean TbMeetingrecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findByNativeSql(String sql, Class entity) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql).addEntity(entity);
		return query.list();
	}
}