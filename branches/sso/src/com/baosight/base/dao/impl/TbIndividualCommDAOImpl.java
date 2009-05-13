package com.baosight.base.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbIndividualCommDAO;
import com.baosight.mode.TbIndividualComm;
import com.baosight.mode.TbMeetingroom;
import com.baosight.mode.TbUser;

/**
 * Data access object (DAO) for domain model class TbIndividualComm.
 * 
 * @see com.baosight.mode.TbIndividualComm
 * @author MyEclipse Persistence Tools
 */

public class TbIndividualCommDAOImpl extends HibernateDaoSupport implements
		ITbIndividualCommDAO {
	private static final Log log = LogFactory
			.getLog(TbIndividualCommDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String INUSE = "inuse";

	public static final String REMARK = "remark";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	private String queryCacheRegion = null;

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#save(com.baosight.mode.TbIndividualComm)
	 */
	public void save(TbIndividualComm transientInstance) {
		log.debug("saving TbIndividualComm instance");
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#delete(com.baosight.mode.TbIndividualComm)
	 */
	public void delete(TbIndividualComm persistentInstance) {
		log.debug("deleting TbIndividualComm instance");
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findById(java.lang.String)
	 */
	public TbIndividualComm findById(java.lang.String id) {
		log.debug("getting TbIndividualComm instance with id: " + id);
		try {
			TbIndividualComm instance = (TbIndividualComm) getHibernateTemplate()
					.get("com.baosight.mode.TbIndividualComm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByExample(com.baosight.mode.TbIndividualComm)
	 */
	public List findByExample(TbIndividualComm instance) {
		log.debug("finding TbIndividualComm instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbIndividualComm instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbIndividualComm as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByInuse(java.lang.Object)
	 */
	public List findByInuse(Object inuse) {
		return findByProperty(INUSE, inuse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByRemark(java.lang.Object)
	 */
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#findAll()
	 */
	public List findAll(TbUser user) {
		log.debug("finding TbIndividualComm instance with property: all: ");

		try {
			String queryString = "from TbIndividualComm as t where t.name like '%%' and t.attr1='"
					+ user.getId() + "'";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#merge(com.baosight.mode.TbIndividualComm)
	 */
	public TbIndividualComm merge(TbIndividualComm detachedInstance) {
		log.debug("merging TbIndividualComm instance");
		try {
			TbIndividualComm result = (TbIndividualComm) getHibernateTemplate()
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#attachDirty(com.baosight.mode.TbIndividualComm)
	 */
	public void attachDirty(TbIndividualComm instance) {
		log.debug("attaching dirty TbIndividualComm instance");
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
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#attachClean(com.baosight.mode.TbIndividualComm)
	 */
	public void attachClean(TbIndividualComm instance) {
		log.debug("attaching clean TbIndividualComm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbIndividualCommDAO#update(com.baosight.mode.TbIndividualComm)
	 */
	public void update(TbIndividualComm transientInstance) {
		log.debug("updating TbIndividualComm instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public List findSelectName(String SelectName, TbUser user) {
		log.debug("finding TbIndividualComm instance with property: name: ");

		try {
			String queryString = "from TbIndividualComm as t where t.name like '%"
					+ SelectName + "%' and t.attr1 = '" + user.getId() + "'";

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	public List findStatus(TbUser user) {
		log.debug("finding TbIndividualComm instance with property: inuse: ");

		try {
			String queryString = "from TbIndividualComm as t where t.inuse ='1' and t.attr1='"
					+ user.getId() + "'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	public static ITbIndividualCommDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbIndividualCommDAO) ctx.getBean("TbIndividualCommDAO");
	}

	public List checkIndividualComm(String id, String value, String userid,
			String flag) {
		log.debug("finding TbIndividualComm instance with property: value: "
				+ value);
		String queryString = "";
		try {
			if ("".equals(id)) {
				queryString = "from TbIndividualComm as model where model.name= '"
						+ value + "' and model.attr1= '" + userid + "'";
			} else {
				queryString = "from TbIndividualComm as model where model.name= '"
						+ value
						+ "' and model.id != '"
						+ id
						+ "' and model.attr1= '" + userid + "'";
			}

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}
	/**
	 * true -1-1
	 */
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