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

import com.baosight.base.dao.ITbCommonalityCommDAO;
import com.baosight.mode.TbCommonalityComm;

/**
 * Data access object (DAO) for domain model class TbCommonalityComm.
 * 
 * @see com.baosight.mode.TbCommonalityComm
 * @author MyEclipse Persistence Tools
 */

public class TbCommonalityCommDAOImpl extends HibernateDaoSupport implements ITbCommonalityCommDAO {
	private static final Log log = LogFactory
			.getLog(TbCommonalityCommDAOImpl.class);

	private String queryCacheRegion = null;
	// property constants
	public static final String PARENT_ID = "parentId";

	public static final String NAME = "name";

	public static final String INUSE = "inuse";

	public static final String BELONG = "belong";

	public static final String REMARK = "remark";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public static final String ATTR4 = "attr4";

	public static final String ATTR5 = "attr5";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#save(com.baosight.mode.TbCommonalityComm)
	 */
	public void save(TbCommonalityComm transientInstance) {
		log.debug("saving TbCommonalityComm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbCommonalityComm transientInstance) {
		log.debug("updating TbCommonalityComm instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#delete(com.baosight.mode.TbCommonalityComm)
	 */
	public void delete(TbCommonalityComm persistentInstance) {
		log.debug("deleting TbCommonalityComm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findById(java.lang.String)
	 */
	public TbCommonalityComm findById(java.lang.String id) {
		log.debug("getting TbCommonalityComm instance with id: " + id);
		try {
			TbCommonalityComm instance = (TbCommonalityComm) getHibernateTemplate()
					.get("com.baosight.mode.TbCommonalityComm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByExample(com.baosight.mode.TbCommonalityComm)
	 */
	public List findByExample(TbCommonalityComm instance) {
		log.debug("finding TbCommonalityComm instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbCommonalityComm instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbCommonalityComm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByParentId(java.lang.Object)
	 */
	public List findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByInuse(java.lang.Object)
	 */
	public List findByInuse(Object inuse) {
		return findByProperty(INUSE, inuse);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByBelong(java.lang.Object)
	 */
	public List findByBelong(Object belong) {
		return findByProperty(BELONG, belong);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByRemark(java.lang.Object)
	 */
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByAttr4(java.lang.Object)
	 */
	public List findByAttr4(Object attr4) {
		return findByProperty(ATTR4, attr4);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findByAttr5(java.lang.Object)
	 */
	public List findByAttr5(Object attr5) {
		return findByProperty(ATTR5, attr5);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbCommonalityComm instances");
		try {
			String queryString = "from TbCommonalityComm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#merge(com.baosight.mode.TbCommonalityComm)
	 */
	public TbCommonalityComm merge(TbCommonalityComm detachedInstance) {
		log.debug("merging TbCommonalityComm instance");
		try {
			TbCommonalityComm result = (TbCommonalityComm) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#attachDirty(com.baosight.mode.TbCommonalityComm)
	 */
	public void attachDirty(TbCommonalityComm instance) {
		log.debug("attaching dirty TbCommonalityComm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityCommDAO#attachClean(com.baosight.mode.TbCommonalityComm)
	 */
	public void attachClean(TbCommonalityComm instance) {
		log.debug("attaching clean TbCommonalityComm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbCommonalityCommDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbCommonalityCommDAO) ctx.getBean("TbCommonalityCommDAO");
		
	
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
	
	public List findByIdAndName(){
		String hql = "select tcc.id,tcc.name from TbCommonalityComm tcc";
		return findByHQL(hql,true,-1,-1);
	}
	public List findBySql(String sql) {  
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
}