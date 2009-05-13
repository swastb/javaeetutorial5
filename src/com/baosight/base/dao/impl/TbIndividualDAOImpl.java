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

import com.baosight.base.dao.ITbIndividualDAO;
import com.baosight.mode.TbIndividual;

/**
 * Data access object (DAO) for domain model class TbIndividual.
 * 
 * @see com.baosight.mode.TbIndividual
 * @author MyEclipse Persistence Tools
 */

public class TbIndividualDAOImpl extends DAOHelperImpl implements ITbIndividualDAO {
	private static final Log log = LogFactory.getLog(TbIndividualDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#save(com.baosight.mode.TbIndividual)
	 */
	public void save(TbIndividual transientInstance) {
		log.debug("saving TbIndividual instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#delete(com.baosight.mode.TbIndividual)
	 */
	public void delete(TbIndividual persistentInstance) {
		log.debug("deleting TbIndividual instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findById(java.lang.String)
	 */
	public TbIndividual findById(java.lang.String id) {
		log.debug("getting TbIndividual instance with id: " + id);
		try {
			TbIndividual instance = (TbIndividual) getHibernateTemplate().get(
					"com.baosight.mode.TbIndividual", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByExample(com.baosight.mode.TbIndividual)
	 */
	public List findByExample(TbIndividual instance) {
		log.debug("finding TbIndividual instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbIndividual instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbIndividual as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByIndividualId(java.lang.Object)
	 */
	public List findByIndividualId(Object individualId) {
		return findByProperty(INDIVIDUAL_ID, individualId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByDuty(java.lang.Object)
	 */
	public List findByDuty(Object duty) {
		return findByProperty(DUTY, duty);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByDepartment(java.lang.Object)
	 */
	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByFax(java.lang.Object)
	 */
	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByPost(java.lang.Object)
	 */
	public List findByPost(Object post) {
		return findByProperty(POST, post);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByAddress(java.lang.Object)
	 */
	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByPartmentPhone(java.lang.Object)
	 */
	public List findByPartmentPhone(Object partmentPhone) {
		return findByProperty(PARTMENT_PHONE, partmentPhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByMovePhone(java.lang.Object)
	 */
	public List findByMovePhone(Object movePhone) {
		return findByProperty(MOVE_PHONE, movePhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByHomePhone(java.lang.Object)
	 */
	public List findByHomePhone(Object homePhone) {
		return findByProperty(HOME_PHONE, homePhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByEmail(java.lang.Object)
	 */
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByQq(java.lang.Object)
	 */
	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByMsn(java.lang.Object)
	 */
	public List findByMsn(Object msn) {
		return findByProperty(MSN, msn);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByRemark(java.lang.Object)
	 */
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbIndividual instances");
		try {
			String queryString = "from TbIndividual";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#merge(com.baosight.mode.TbIndividual)
	 */
	public TbIndividual merge(TbIndividual detachedInstance) {
		log.debug("merging TbIndividual instance");
		try {
			TbIndividual result = (TbIndividual) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#update(com.baosight.mode.TbIndividual)
	 */
	public void update(TbIndividual transientInstance) {
		log.debug("updating TbIndividual instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#attachDirty(com.baosight.mode.TbIndividual)
	 */
	public void attachDirty(TbIndividual instance) {
		log.debug("attaching dirty TbIndividual instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbIndividualDAO#attachClean(com.baosight.mode.TbIndividual)
	 */
	public void attachClean(TbIndividual instance) {
		log.debug("attaching clean TbIndividual instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbIndividualDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbIndividualDAO) ctx.getBean("TbIndividualDAO");
	}
	
	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
	public List findindividualid(String individualid) {
		log.debug("finding TbIndividual instance with property: individualid: ");
	
		try {
			String queryString ="from TbIndividual as t where t.individualId = '" + 
			                    individualid + 
			                    "'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	//个人通讯录电话号码
	public List findByNameAndPhone(String individualId){
		System.out.println("individualId==="+individualId);
		  String hql = "select ti.movePhone from TbIndividual ti where ti.individualId ='"+individualId+"'";
		 List findByList = this.findByHQL(hql,true, -1, -1);
		 System.out.println("FindByList != 0======"+findByList.size());
		return findByList;
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