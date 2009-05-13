package com.baosight.base.dao.impl;

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

import com.baosight.base.dao.ITbZwWeekSecheduleDAO;
import com.baosight.mode.TbZwWeekSechedule;

/**
 * Data access object (DAO) for domain model class TbZwWeekSechedule.
 * 
 * @see com.baosight.base.dao.impl.TbZwWeekSechedule
 * @author MyEclipse Persistence Tools
 */

public class TbZwWeekSecheduleDAOImpl extends HibernateDaoSupport implements
		ITbZwWeekSecheduleDAO {
	private static final Log log = LogFactory
			.getLog(TbZwWeekSecheduleDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String ITEM_TITLE = "itemTitle";

	public static final String ITEM_TYPE = "itemType";

	public static final String DEPT = "dept";

	public static final String ATTENDANCE = "attendance";

	public static final String USER_ID = "userId";

	public static final String PROMULGATOR = "promulgator";

	public static final String ORIGIN = "origin";

	public static final String CREATE_TIME = "createTime";

	public static final String REM = "rem";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public static final String CONTENT = "content";

	public static final String WEEKOFYEAR = "weekofyear";

	public static final String COLORFLAG = "colorflag";

	public static final String DEPT_ID = "deptId";
	
	public static final String PRIVATE_USERID = "privateUserId";
	
	public static final String PID = "pid";
	
	public static final String ISCHILD = "ischild";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#save(com.baosight.mode.TbZwWeekSechedule)
	 */
	public void save(TbZwWeekSechedule transientInstance) {
		log.debug("saving TbZwWeekSechedule instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#delete(com.baosight.mode.TbZwWeekSechedule)
	 */
	public void delete(TbZwWeekSechedule persistentInstance) {
		log.debug("deleting TbZwWeekSechedule instance");
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
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findById(java.lang.String)
	 */
	public TbZwWeekSechedule findById(java.lang.String id) {
		log.debug("getting TbZwWeekSechedule instance with id: " + id);
		try {
			TbZwWeekSechedule instance = (TbZwWeekSechedule) getHibernateTemplate()
					.get("com.baosight.mode.TbZwWeekSechedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByExample(com.baosight.mode.TbZwWeekSechedule)
	 */
	public List findByExample(TbZwWeekSechedule instance) {
		log.debug("finding TbZwWeekSechedule instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbZwWeekSechedule instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbZwWeekSechedule as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByItemTitle(java.lang.Object)
	 */
	public List findByItemTitle(Object itemTitle) {
		return findByProperty(ITEM_TITLE, itemTitle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByItemType(java.lang.Object)
	 */
	public List findByItemType(Object itemType) {
		return findByProperty(ITEM_TYPE, itemType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByDept(java.lang.Object)
	 */
	public List findByDept(Object dept) {
		return findByProperty(DEPT, dept);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByAttendance(java.lang.Object)
	 */
	public List findByAttendance(Object attendance) {
		return findByProperty(ATTENDANCE, attendance);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByPromulgator(java.lang.Object)
	 */
	public List findByPromulgator(Object promulgator) {
		return findByProperty(PROMULGATOR, promulgator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByOrigin(java.lang.Object)
	 */
	public List findByOrigin(Object origin) {
		return findByProperty(ORIGIN, origin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByCreateTime(java.lang.Object)
	 */
	public List findByCreateTime(Object createTime) {
		return findByProperty(CREATE_TIME, createTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findByWeekofyear(java.lang.Object)
	 */
	public List findByWeekofyear(Object weekofyear) {
		return findByProperty(WEEKOFYEAR, weekofyear);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbZwWeekSechedule instances");
		try {
			String queryString = "from TbZwWeekSechedule";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#merge(com.baosight.mode.TbZwWeekSechedule)
	 */
	public TbZwWeekSechedule merge(TbZwWeekSechedule detachedInstance) {
		log.debug("merging TbZwWeekSechedule instance");
		try {
			TbZwWeekSechedule result = (TbZwWeekSechedule) getHibernateTemplate()
					.merge(detachedInstance);
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
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#attachDirty(com.baosight.mode.TbZwWeekSechedule)
	 */
	public void attachDirty(TbZwWeekSechedule instance) {
		log.debug("attaching dirty TbZwWeekSechedule instance");
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
	 * @see com.baosight.base.dao.impl.ITbZwWeekSecheduleDAO#attachClean(com.baosight.mode.TbZwWeekSechedule)
	 */
	public void attachClean(TbZwWeekSechedule instance) {
		log.debug("attaching clean TbZwWeekSechedule instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbZwWeekSecheduleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbZwWeekSecheduleDAO) ctx.getBean("TbZwWeekSecheduleDAO");
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

	/**
	 * @return the queryCacheRegion
	 */
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	/**
	 * @param queryCacheRegion
	 *            the queryCacheRegion to set
	 */
	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public List findByNativeSql(String sql) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

	public List findByNativeSql1(String sql) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql).addEntity(
				TbZwWeekSechedule.class);
		return query.list();
	}
	
	public List findByNativeSql(String sql,Class entity) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql).addEntity(entity);
		return query.list();
	}

	public List findByAttr3(Object attr3) {
		// TODO Auto-generated method stub
		return findByProperty(ATTR3, attr3);
	}

	public List findByContent(Object content) {
		// TODO Auto-generated method stub
		return findByProperty(CONTENT, content);
	}

	public List findByColorFlag(Object colorflag) {
		// TODO Auto-generated method stub
		return findByProperty(COLORFLAG, colorflag);
	}

	public List findByDeptId(Object deptId) {
		// TODO Auto-generated method stub
		return findByProperty(DEPT_ID, deptId);
	}

	public List findByPrivateUserId(Object privateUserId) {
		// TODO Auto-generated method stub
		return findByProperty(PRIVATE_USERID, privateUserId);
	}

	public List findByIsChild(Object isChild) {
		// TODO Auto-generated method stub
		return findByProperty(ISCHILD, isChild);
	}

	public List findByPId(Object pid) {
		// TODO Auto-generated method stub
		return findByProperty(PID, pid);
	}

	public void update(TbZwWeekSechedule transientInstance) {
		// TODO Auto-generated method stub
		log.debug("update TbZwWeekSechedule instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}