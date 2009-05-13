package com.baosight.base.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbSmsSubscribeDAO;
import com.baosight.mode.TbSmsSubscribe;

/**
 * Data access object (DAO) for domain model class TbSmsSubscribe.
 * 
 * @see com.baosight.base.dao.impl.TbSmsSubscribe
 * @author MyEclipse Persistence Tools
 */

public class TbSmsSubscribeDAOImpl extends HibernateDaoSupport implements
		ITbSmsSubscribeDAO {
	private static final Log log = LogFactory
			.getLog(TbSmsSubscribeDAOImpl.class);

	// property constants
	public static final String USERID = "userid";

	public static final String SUBJECTID = "subjectid";

	public static final String MOBILE_NUM = "mobileNum";

	public static final String USERNAME = "username";

	public static final String SUBJECTNAME = "subjectname";

	public static final String INFOFEE_TYPE = "infofeeType";

	public static final String SUBSTIME = "substime";

	public static final String SUBJECTTYPE1 = "subjecttype1";

	public static final String SUBJECTTYPE2 = "subjecttype2";

	public static final String DEPARTID = "departid";

	protected void initDao() {
		// do nothing
	}

	public void save(TbSmsSubscribe transientInstance) {
		log.debug("saving TbSmsSubscribe instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbSmsSubscribe persistentInstance) {
		log.debug("deleting TbSmsSubscribe instance");
		try {
			System.out.println("=="+persistentInstance.getId());
			TbSmsSubscribe ts = findById(persistentInstance.getId());
			System.out.println("raasasasadsa="+ts);
			getHibernateTemplate().delete(ts);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
//	public void delete(TbSmsSubscribe persistentInstance) {
//		log.debug("deleting TbSmsSubscribe instance");
//		try {
//			TbSmsSubscribe tbs = getHibernateTemplate();
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
		
//	}

	public TbSmsSubscribe findById(java.lang.String id) {
		log.debug("getting TbSmsSubscribe instance with id: " + id);
		try {
			TbSmsSubscribe instance = (TbSmsSubscribe) getHibernateTemplate()
					.get("com.baosight.mode.TbSmsSubscribe", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbSmsSubscribe instance) {
		log.debug("finding TbSmsSubscribe instance by example");
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
		log.debug("finding TbSmsSubscribe instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbSmsSubscribe as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	public List findBySubjectid(Object subjectid) {
		return findByProperty(SUBJECTID, subjectid);
	}

	public List findByMobileNum(Object mobileNum) {
		return findByProperty(MOBILE_NUM, mobileNum);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findBySubjectname(Object subjectname) {
		return findByProperty(SUBJECTNAME, subjectname);
	}

	public List findByInfofeeType(Object infofeeType) {
		return findByProperty(INFOFEE_TYPE, infofeeType);
	}

	public List findBySubstime(Object substime) {
		return findByProperty(SUBSTIME, substime);
	}

	public List findBySubjecttype1(Object subjecttype1) {
		return findByProperty(SUBJECTTYPE1, subjecttype1);
	}

	public List findBySubjecttype2(Object subjecttype2) {
		return findByProperty(SUBJECTTYPE2, subjecttype2);
	}

	public List findByDepartid(Object departid) {
		return findByProperty(DEPARTID, departid);
	}

	public List findAll() {
		log.debug("finding all TbSmsSubscribe instances");
		try {
			String queryString = "from TbSmsSubscribe";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbSmsSubscribe merge(TbSmsSubscribe detachedInstance) {
		log.debug("merging TbSmsSubscribe instance");
		try {
			TbSmsSubscribe result = (TbSmsSubscribe) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbSmsSubscribe instance) {
		log.debug("attaching dirty TbSmsSubscribe instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbSmsSubscribe instance) {
		log.debug("attaching clean TbSmsSubscribe instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbSmsSubscribeDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbSmsSubscribeDAOImpl) ctx.getBean("TbSmsSubscribeDAO");
	}

	public List findJoinDepart(TbSmsSubscribe smsSubscribe) {
		log.debug("finding all TbSmsSubscribe instances");
		try {
			StringBuilder hql = new StringBuilder()
					.append("select new com.baosight.mode.BsOther(ss.id,cc.name,")
					.append("ss.username,ss.mobileNum,")
					.append("ss.subjectname,tc.duty,tc.remark,ss.infofeeType) from TbSmsSubscribe ss,TbCommonalityComm cc,TbCommonality tc ")
					.append("where ss.departid = cc.id and tc.id = ss.userid ");
			String username = smsSubscribe.getUsername();
			String subjectname = smsSubscribe.getSubjectname();
			String departid = smsSubscribe.getDepartid();
			if (departid != null && !"".equals(departid)) {
				hql.append(" and cc.id ='"+ departid +"'");
			}
			if (username != null && !"".equals(username)) {
				hql.append(" and ss.username like'%" + username + "%'");
			}
			if (subjectname != null && !"".equals(subjectname)) {
				hql.append(" and ss.subjectname like'%" + subjectname + "%'");
			}
			String queryString = hql.toString();
			return findByHQL(queryString,true,-1,-1);
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
}
