package com.baosight.base.dao.impl;

import java.io.Serializable;
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

import com.baosight.base.dao.ITbCommonalityDAO;
import com.baosight.mode.TbCommonality;

/**
 * Data access object (DAO) for domain model class TbCommonality.
 * 
 * @see com.baosight.mode.TbCommonality
 * @author MyEclipse Persistence Tools
 */

public class TbCommonalityDAOImpl extends HibernateDaoSupport implements ITbCommonalityDAO {
	private static final Log log = LogFactory.getLog(TbCommonalityDAOImpl.class);

	private String queryCacheRegion = null;
	
	// property constants
	public static final String COMMONALITY_ID = "commonalityId";

	public static final String COM_PARENT_ID = "comParentId";

	public static final String NAME = "name";

	public static final String DUTY = "duty";

	public static final String DEPARTMENT = "department";

	public static final String FAX = "fax";

	public static final String POST = "post";

	public static final String ADDRESS = "address";

	public static final String PARTMENT_PHONE = "partmentPhone";

	public static final String MOVE_PHONE = "movePhone";

	public static final String HOME_PHONE = "homePhone";

	public static final String EMAIL = "email";

	public static final String QQ = "qq";

	public static final String MSN = "msn";

	public static final String REMARK = "remark";

	public static final String BELONG = "belong";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public static final String ATTR4 = "attr4";

	public static final String ATTR5 = "attr5";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#save(com.baosight.mode.TbCommonality)
	 */
	public void save(TbCommonality transientInstance) {
		log.debug("saving TbCommonality instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(TbCommonality transientInstance) {
		log.debug("updating TbCommonality instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#delete(com.baosight.mode.TbCommonality)
	 */
	public void delete(TbCommonality persistentInstance) {
		log.debug("deleting TbCommonality instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findById(java.lang.String)
	 */
	public TbCommonality findById(java.lang.String id) {
		log.debug("getting TbCommonality instance with id: " + id);
		try {
			TbCommonality instance = (TbCommonality) getHibernateTemplate()
					.get("com.baosight.mode.TbCommonality", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByExample(com.baosight.mode.TbCommonality)
	 */
	public List findByExample(TbCommonality instance) {
		log.debug("finding TbCommonality instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbCommonality instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbCommonality as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByCommonalityId(java.lang.Object)
	 */
	public List findByCommonalityId(Object commonalityId) {
		return findByProperty(COMMONALITY_ID, commonalityId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByComParentId(java.lang.Object)
	 */
	public List findByComParentId(Object comParentId) {
		return findByProperty(COM_PARENT_ID, comParentId);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByDuty(java.lang.Object)
	 */
	public List findByDuty(Object duty) {
		return findByProperty(DUTY, duty);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByDepartment(java.lang.Object)
	 */
	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByFax(java.lang.Object)
	 */
	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByPost(java.lang.Object)
	 */
	public List findByPost(Object post) {
		return findByProperty(POST, post);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAddress(java.lang.Object)
	 */
	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByPartmentPhone(java.lang.Object)
	 */
	public List findByPartmentPhone(Object partmentPhone) {
		return findByProperty(PARTMENT_PHONE, partmentPhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByMovePhone(java.lang.Object)
	 */
	public List findByMovePhone(Object movePhone) {
		return findByProperty(MOVE_PHONE, movePhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByHomePhone(java.lang.Object)
	 */
	public List findByHomePhone(Object homePhone) {
		return findByProperty(HOME_PHONE, homePhone);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByEmail(java.lang.Object)
	 */
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByQq(java.lang.Object)
	 */
	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByMsn(java.lang.Object)
	 */
	public List findByMsn(Object msn) {
		return findByProperty(MSN, msn);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByRemark(java.lang.Object)
	 */
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByBelong(java.lang.Object)
	 */
	public List findByBelong(Object belong) {
		return findByProperty(BELONG, belong);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAttr4(java.lang.Object)
	 */
	public List findByAttr4(Object attr4) {
		return findByProperty(ATTR4, attr4);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findByAttr5(java.lang.Object)
	 */
	public List findByAttr5(Object attr5) {
		return findByProperty(ATTR5, attr5);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbCommonality instances");
		try {
			String queryString = "from TbCommonality";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#merge(com.baosight.mode.TbCommonality)
	 */
	public TbCommonality merge(TbCommonality detachedInstance) {
		log.debug("merging TbCommonality instance");
		try {
			TbCommonality result = (TbCommonality) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#attachDirty(com.baosight.mode.TbCommonality)
	 */
	public void attachDirty(TbCommonality instance) {
		log.debug("attaching dirty TbCommonality instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbCommonalityDAO#attachClean(com.baosight.mode.TbCommonality)
	 */
	public void attachClean(TbCommonality instance) {
		log.debug("attaching clean TbCommonality instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbCommonalityDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbCommonalityDAO) ctx.getBean("TbCommonalityDAO");
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
	
	//查询二级组下的所有通讯录
	public List findByNameAndPhone(String comParentId){
	  String hql = "select tc.movePhone from TbCommonality tc where tc.comParentId ='"+comParentId+"'";
	  return this.findByHQL(hql, true, -1, -1);
	}
	/**
	 * 保存对象并返回id
	 * @param model
	 */
	public String saveObjRetrunId(TbCommonality model) {
		log.debug("saving TbCommonality instance");
		try {
			Serializable id = getHibernateTemplate().save(model);
			log.debug("save successful");
			return id.toString();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	public List findBySql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	public List findByIdReturnName(String id){
	  String hql = "select t.name from TbCommonality t where t.id ='"+id+"'";
	  return findByHQL(hql, true, -1, -1);
	}
	
	
}