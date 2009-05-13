package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbZfxxgkgzsDAO;
import com.baosight.mode.TbRighttype;
import com.baosight.mode.TbZfxxgkgzs;

/**
 * Data access object (DAO) for domain model class TbZfxxgkgzs.
 * 
 * @see com.baosight.mode.TbZfxxgkgzs
 * @author MyEclipse Persistence Tools
 */

public class TbZfxxgkgzsDAOImpl extends HibernateDaoSupport implements ITbZfxxgkgzsDAO {
	private static final Log log = LogFactory.getLog(TbZfxxgkgzsDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#save(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void save(TbZfxxgkgzs transientInstance) {
		log.debug("saving TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#delete(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void delete(TbZfxxgkgzs persistentInstance) {
		log.debug("deleting TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findById(java.lang.String)
	 */
	public TbZfxxgkgzs findById(java.lang.String id) {
		log.debug("getting TbZfxxgkgzs instance with id: " + id);
		try {
			TbZfxxgkgzs instance = (TbZfxxgkgzs) getHibernateTemplate().get(
					"com.baosight.mode.TbZfxxgkgzs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByExample(com.baosight.mode.TbZfxxgkgzs)
	 */
	public List findByExample(TbZfxxgkgzs instance) {
		log.debug("finding TbZfxxgkgzs instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbZfxxgkgzs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbZfxxgkgzs as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findById(java.lang.Object)
	 */
	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr4(java.lang.Object)
	 */
	public List findByAttr4(Object attr4) {
		return findByProperty(ATTR4, attr4);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr5(java.lang.Object)
	 */
	public List findByAttr5(Object attr5) {
		return findByProperty(ATTR5, attr5);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr6(java.lang.Object)
	 */
	public List findByAttr6(Object attr6) {
		return findByProperty(ATTR6, attr6);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr7(java.lang.Object)
	 */
	public List findByAttr7(Object attr7) {
		return findByProperty(ATTR7, attr7);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr8(java.lang.Object)
	 */
	public List findByAttr8(Object attr8) {
		return findByProperty(ATTR8, attr8);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr9(java.lang.Object)
	 */
	public List findByAttr9(Object attr9) {
		return findByProperty(ATTR9, attr9);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr10(java.lang.Object)
	 */
	public List findByAttr10(Object attr10) {
		return findByProperty(ATTR10, attr10);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr11(java.lang.Object)
	 */
	public List findByAttr11(Object attr11) {
		return findByProperty(ATTR11, attr11);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr12(java.lang.Object)
	 */
	public List findByAttr12(Object attr12) {
		return findByProperty(ATTR12, attr12);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr13(java.lang.Object)
	 */
	public List findByAttr13(Object attr13) {
		return findByProperty(ATTR13, attr13);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr14(java.lang.Object)
	 */
	public List findByAttr14(Object attr14) {
		return findByProperty(ATTR14, attr14);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr15(java.lang.Object)
	 */
	public List findByAttr15(Object attr15) {
		return findByProperty(ATTR15, attr15);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr16(java.lang.Object)
	 */
	public List findByAttr16(Object attr16) {
		return findByProperty(ATTR16, attr16);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr17(java.lang.Object)
	 */
	public List findByAttr17(Object attr17) {
		return findByProperty(ATTR17, attr17);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr18(java.lang.Object)
	 */
	public List findByAttr18(Object attr18) {
		return findByProperty(ATTR18, attr18);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr19(java.lang.Object)
	 */
	public List findByAttr19(Object attr19) {
		return findByProperty(ATTR19, attr19);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findByAttr20(java.lang.Object)
	 */
	public List findByAttr20(Object attr20) {
		return findByProperty(ATTR20, attr20);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbZfxxgkgzs instances");
		try {
			String queryString = "from TbZfxxgkgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#merge(com.baosight.mode.TbZfxxgkgzs)
	 */
	public TbZfxxgkgzs merge(TbZfxxgkgzs detachedInstance) {
		log.debug("merging TbZfxxgkgzs instance");
		try {
			TbZfxxgkgzs result = (TbZfxxgkgzs) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#attachDirty(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void attachDirty(TbZfxxgkgzs instance) {
		log.debug("attaching dirty TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxgkgzsDAO#attachClean(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void attachClean(TbZfxxgkgzs instance) {
		log.debug("attaching clean TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbZfxxgkgzsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbZfxxgkgzsDAO) ctx.getBean("tbZfxxgkgzsDAO");
	}
	
	public void update(TbZfxxgkgzs item) {
		log.debug("update TbZfxxgkgzs instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}