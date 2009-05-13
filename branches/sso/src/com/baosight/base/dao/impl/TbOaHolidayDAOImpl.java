package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbOaHolidayDAO;
import com.baosight.mode.TbOaHoliday;
import com.baosight.mode.TbPstlvl;

/**
 * Data access object (DAO) for domain model class TbOaHoliday.
 * 
 * @see com.baosight.mode.TbOaHoliday
 * @author MyEclipse Persistence Tools
 */

public class TbOaHolidayDAOImpl extends HibernateDaoSupport implements ITbOaHolidayDAO {
	private static final Log log = LogFactory.getLog(TbOaHolidayDAOImpl.class);

	// property constants
	public static final String AM_PM = "amPm";

	public static final String DAY = "day";

	public static final String DEPT_ID = "deptId";

	public static final String DESCRIPTION = "description";

	public static final String ARB = "arb";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#save(com.baosight.mode.TbOaHoliday)
	 */
	public void save(TbOaHoliday transientInstance) {
		log.debug("saving TbOaHoliday instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#delete(com.baosight.mode.TbOaHoliday)
	 */
	public void delete(TbOaHoliday persistentInstance) {
		log.debug("deleting TbOaHoliday instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findById(java.lang.String)
	 */
	public TbOaHoliday findById(java.lang.String id) {
		log.debug("getting TbOaHoliday instance with id: " + id);
		try {
			TbOaHoliday instance = (TbOaHoliday) getHibernateTemplate().get(
					"com.baosight.mode.TbOaHoliday", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByExample(com.baosight.mode.TbOaHoliday)
	 */
	public List findByExample(TbOaHoliday instance) {
		log.debug("finding TbOaHoliday instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbOaHoliday instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbOaHoliday as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByAmPm(java.lang.Object)
	 */
	public List findByAmPm(Object amPm) {
		return findByProperty(AM_PM, amPm);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByDay(java.lang.Object)
	 */
	public List findByDay(Object day) {
		return findByProperty(DAY, day);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByDeptId(java.lang.Object)
	 */
	public List findByDeptId(Object deptId) {
		return findByProperty(DEPT_ID, deptId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByDescription(java.lang.Object)
	 */
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findByArb(java.lang.Object)
	 */
	public List findByArb(Object arb) {
		return findByProperty(ARB, arb);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbOaHoliday instances");
		try {
			String queryString = "from TbOaHoliday";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			System.out.println(re.getMessage()+"---------------message---------------");
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#merge(com.baosight.mode.TbOaHoliday)
	 */
	public TbOaHoliday merge(TbOaHoliday detachedInstance) {
		log.debug("merging TbOaHoliday instance");
		try {
			TbOaHoliday result = (TbOaHoliday) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#attachDirty(com.baosight.mode.TbOaHoliday)
	 */
	public void attachDirty(TbOaHoliday instance) {
		log.debug("attaching dirty TbOaHoliday instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbOaHolidayDAO#attachClean(com.baosight.mode.TbOaHoliday)
	 */
	public void attachClean(TbOaHoliday instance) {
		log.debug("attaching clean TbOaHoliday instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbOaHolidayDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbOaHolidayDAO) ctx.getBean("TbOaHolidayDAO");
	}
	
	public void update(TbOaHoliday item) {
		log.debug("update TbOaHoliday instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public List listDate(String year, String month) {
		log.debug("finding TbOaHoliday instance with property: ename, year: " + year);
		
		String queryString ="";
		try {
			int monthS = Integer.parseInt(month);
			if(monthS > 9){
				queryString = "from TbOaHoliday as t where " +
				  "substr(to_char(t.holiday,'yyyy-mm-dd'),1,4)= '"+year+"' " +
			      "and substr(to_char(t.holiday,'yyyy-mm-dd'),6,2)= '"+month+"' " +
			      "order by t.holiday";
	
			}
			else{
				queryString = "from TbOaHoliday as t where " +
				  "substr(to_char(t.holiday,'yyyy-mm-dd'),1,4)= '"+year+"' " +
			      "and substr(to_char(t.holiday,'yyyy-mm-dd'),6,2)= '"+"0"+month+"' " +
			      "order by t.holiday";
			}
		
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	
	public List findSysDate() {
		log.debug("finding TbOaHoliday instance with property: ename, year: ");
		
		String queryString ="";
		try {
			queryString="from TbOaHoliday as t " + 
			"where substr(to_char(t.holiday,'yyyy-mm-dd'),1,4) = to_char(sysdate,'YYYY') " + 
			"and substr(to_char(t.holiday,'yyyy-mm-dd'),6,2) = to_char(sysdate,'MM') " + 
			"order by t.holiday";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	
	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
	
}