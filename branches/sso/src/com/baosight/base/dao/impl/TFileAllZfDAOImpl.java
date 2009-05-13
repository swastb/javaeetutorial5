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

import com.baosight.base.dao.ITFileAllZfDAO;
import com.baosight.mode.TFileAllZf;

/**
 * Data access object (DAO) for domain model class TFileAllZf.
 * 
 * @see com.baosight.mode.TFileAllZf
 * @author MyEclipse Persistence Tools
 */

public class TFileAllZfDAOImpl extends HibernateDaoSupport implements ITFileAllZfDAO{
	private static final Log log = LogFactory.getLog(TFileAllZfDAOImpl.class);
	private String queryCacheRegion = null;
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#save(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#save(com.baosight.base.mode.TFileAllZf)
	 */
	public void save(TFileAllZf transientInstance) {
		log.debug("saving TFileAllZf instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#delete(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#delete(com.baosight.base.mode.TFileAllZf)
	 */
	public void delete(TFileAllZf persistentInstance) {
		log.debug("deleting TFileAllZf instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findById(java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findById(java.lang.Long)
	 */
	public TFileAllZf findById(java.lang.Long id) {
		log.debug("getting TFileAllZf instance with id: " + id);
		try {
			TFileAllZf instance = (TFileAllZf) getHibernateTemplate().get(
					"com.baosight.base.mode.TFileAllZf", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByExample(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByExample(com.baosight.base.mode.TFileAllZf)
	 */
	public List findByExample(TFileAllZf instance) {
		log.debug("finding TFileAllZf instance by example");
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
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TFileAllZf instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TFileAllZf as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTitle(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByAuthor(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByAuthor(java.lang.Object)
	 */
	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTypeid(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByTypeid(java.lang.Object)
	 */
	public List findByTypeid(Object typeid) {
		return findByProperty(TYPEID, typeid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByFolderid(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByFolderid(java.lang.Object)
	 */
	public List findByFolderid(Object folderid) {
		return findByProperty(FOLDERID, folderid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByPurview(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByPurview(java.lang.Object)
	 */
	public List findByPurview(Object purview) {
		return findByProperty(PURVIEW, purview);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIsvalid(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByIsvalid(java.lang.Object)
	 */
	public List findByIsvalid(Object isvalid) {
		return findByProperty(ISVALID, isvalid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword1(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByKeyword1(java.lang.Object)
	 */
	public List findByKeyword1(Object keyword1) {
		return findByProperty(KEYWORD1, keyword1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword2(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByKeyword2(java.lang.Object)
	 */
	public List findByKeyword2(Object keyword2) {
		return findByProperty(KEYWORD2, keyword2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword3(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByKeyword3(java.lang.Object)
	 */
	public List findByKeyword3(Object keyword3) {
		return findByProperty(KEYWORD3, keyword3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword4(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByKeyword4(java.lang.Object)
	 */
	public List findByKeyword4(Object keyword4) {
		return findByProperty(KEYWORD4, keyword4);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTemp(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByTemp(java.lang.Object)
	 */
	public List findByTemp(Object temp) {
		return findByProperty(TEMP, temp);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByHit(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByHit(java.lang.Object)
	 */
	public List findByHit(Object hit) {
		return findByProperty(HIT, hit);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByInputuer(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByInputuer(java.lang.Object)
	 */
	public List findByInputuer(Object inputuer) {
		return findByProperty(INPUTUER, inputuer);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByDeptid(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByDeptid(java.lang.Object)
	 */
	public List findByDeptid(Object deptid) {
		return findByProperty(DEPTID, deptid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByInfotype(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByInfotype(java.lang.Object)
	 */
	public List findByInfotype(Object infotype) {
		return findByProperty(INFOTYPE, infotype);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByFilenumber(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByFilenumber(java.lang.Object)
	 */
	public List findByFilenumber(Object filenumber) {
		return findByProperty(FILENUMBER, filenumber);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIssueddept1(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByIssueddept1(java.lang.Object)
	 */
	public List findByIssueddept1(Object issueddept1) {
		return findByProperty(ISSUEDDEPT1, issueddept1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIssueddept2(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByIssueddept2(java.lang.Object)
	 */
	public List findByIssueddept2(Object issueddept2) {
		return findByProperty(ISSUEDDEPT2, issueddept2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByCarriertype(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByCarriertype(java.lang.Object)
	 */
	public List findByCarriertype(Object carriertype) {
		return findByProperty(CARRIERTYPE, carriertype);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByGetid(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByGetid(java.lang.Object)
	 */
	public List findByGetid(Object getid) {
		return findByProperty(GETID, getid);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword5(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByKeyword5(java.lang.Object)
	 */
	public List findByKeyword5(Object keyword5) {
		return findByProperty(KEYWORD5, keyword5);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByLsh(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByLsh(java.lang.Object)
	 */
	public List findByLsh(Object lsh) {
		return findByProperty(LSH, lsh);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByAuditing(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByAuditing(java.lang.Object)
	 */
	public List findByAuditing(Object auditing) {
		return findByProperty(AUDITING, auditing);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByReason(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findByReason(java.lang.Object)
	 */
	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TFileAllZf instances");
		try {
			String queryString = "from TFileAllZf";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#merge(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#merge(com.baosight.base.mode.TFileAllZf)
	 */
	public TFileAllZf merge(TFileAllZf detachedInstance) {
		log.debug("merging TFileAllZf instance");
		try {
			TFileAllZf result = (TFileAllZf) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#attachDirty(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#attachDirty(com.baosight.base.mode.TFileAllZf)
	 */
	public void attachDirty(TFileAllZf instance) {
		log.debug("attaching dirty TFileAllZf instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#attachClean(com.baosight.base.mode.TFileAllZf)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITFileAllZfDAO#attachClean(com.baosight.base.mode.TFileAllZf)
	 */
	public void attachClean(TFileAllZf instance) {
		log.debug("attaching clean TFileAllZf instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITFileAllZfDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITFileAllZfDAO) ctx.getBean("TFileAllZfDAO");
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
}