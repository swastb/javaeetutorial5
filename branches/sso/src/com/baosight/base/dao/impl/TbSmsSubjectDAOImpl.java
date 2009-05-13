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

import com.baosight.base.dao.ITbSmsSubjectDAO;
import com.baosight.mode.TbSmsSubject;

/**
 * Data access object (DAO) for domain model class TbSmsSubject.
 * 
 * @see com.baosight.mode.TbSmsSubject
 * @author MyEclipse Persistence Tools
 */

public class TbSmsSubjectDAOImpl extends HibernateDaoSupport implements ITbSmsSubjectDAO {
	private static final Log log = LogFactory.getLog(TbSmsSubjectDAOImpl.class);

	// property constants
	public static final String SUBJECT = "subject";

	public static final String FEETYPE_ID = "feetypeId";

	public static final String INFO_TYPE = "infoType";

	public static final String SCHEDULE = "schedule";

	public static final String JJSW = "jjsw";

	public static final String BZ = "bz";

	protected void initDao() {
		// do nothing
	}

	public void save(TbSmsSubject transientInstance) {
		log.debug("saving TbSmsSubject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbSmsSubject persistentInstance) {
		log.debug("deleting TbSmsSubject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbSmsSubject findById(java.lang.String id) {
		log.debug("getting TbSmsSubject instance with id: " + id);
		try {
			TbSmsSubject instance = (TbSmsSubject) getHibernateTemplate().get(
					"com.baosight.mode.TbSmsSubject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbSmsSubject instance) {
		log.debug("finding TbSmsSubject instance by example");
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
		log.debug("finding TbSmsSubject instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbSmsSubject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List findByFeetypeId(Object feetypeId) {
		return findByProperty(FEETYPE_ID, feetypeId);
	}

	public List findByInfoType(Object infoType) {
		return findByProperty(INFO_TYPE, infoType);
	}

	public List findBySchedule(Object schedule) {
		return findByProperty(SCHEDULE, schedule);
	}

	public List findByJjsw(Object jjsw) {
		return findByProperty(JJSW, jjsw);
	}

	public List findByBz(Object bz) {
		return findByProperty(BZ, bz);
	}

	public List findAll() {
		log.debug("finding all TbSmsSubject instances");
		try {
			String queryString = "from TbSmsSubject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 
	 */

//	public List findAllSuject(String state) {
//		log.debug("finding all TbSmsSubject instances");
//	      Session session = this.getSessionFactory().openSession();
//		try {
//			String hql = "select ts.id,ts.subject from TbSmsSubject ts where ts.infoType ='"+state+"'";
//			Query q = session.createQuery(hql);
//			List list = q.list();
//			System.out.println("=========================="+list.size());
//			return list;
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}finally{
//			session.close();
//		}
//		
//		}
	
	public List findAllSuject(String state) {
	log.debug("finding all TbSmsSubject instances");
   
	try {
		StringBuilder hql = new StringBuilder().append("select ts.id,ts.subject,ts.feetypeId,ts.infoType from TbSmsSubject ts where 1=1");
		if(state!=null && state.length()>0){
			hql.append(" and ts.infoType ='"+state+"'");
		}
		return findByHQL(hql.toString(), true, -1, -1);
	} catch (RuntimeException re) {
		log.error("find all failed", re);
		throw re;
	}
	}
	
	private String queryCacheRegion;
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
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
	public TbSmsSubject merge(TbSmsSubject detachedInstance) {
		log.debug("merging TbSmsSubject instance");
		try {
			TbSmsSubject result = (TbSmsSubject) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbSmsSubject instance) {
		log.debug("attaching dirty TbSmsSubject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbSmsSubject instance) {
		log.debug("attaching clean TbSmsSubject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbSmsSubjectDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbSmsSubjectDAOImpl) ctx.getBean("TbSmsSubjectDAO");
	}
}