package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbBzsqgzsDAO;
import com.baosight.base.dao.ITbZfxxbfgkgzsDAO;
import com.baosight.mode.TbBzsqgzs;
import com.baosight.mode.TbZfxxbfgkgzs;

/**
 * Data access object (DAO) for domain model class TbBzsqgzs.
 * 
 * @see com.baosight.mode.TbBzsqgzs
 * @author MyEclipse Persistence Tools
 */

public class TbBzsqgzsDAOImpl extends HibernateDaoSupport implements ITbBzsqgzsDAO {
	private static final Log log = LogFactory.getLog(TbBzsqgzsDAOImpl.class);

	protected void initDao() {
		// do nothing
	}
//hellLLL
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#save(com.baosight.mode.TbBzsqgzs)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#save(com.baosight.mode.TbBzsqgzs)
	 */
	public void save(TbBzsqgzs transientInstance) {
		log.debug("saving TbBzsqgzs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}


	public void delete(TbBzsqgzs persistentInstance) {
		log.debug("deleting TbBzsqgzs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	public TbBzsqgzs findById(java.lang.String id) {
		log.debug("getting TbBzsqgzs instance with id: " + id);
		try {
			TbBzsqgzs instance = (TbBzsqgzs) getHibernateTemplate().get(
					"com.baosight.mode.TbBzsqgzs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List findByExample(TbBzsqgzs instance) {
		log.debug("finding TbBzsqgzs instance by example");
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
		log.debug("finding TbBzsqgzs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbBzsqgzs as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public List findByInfoId(Object infoId) {
		return findByProperty(INFO_ID, infoId);
	}


	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}


	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}


	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}


	public List findByAttr4(Object attr4) {
		return findByProperty(ATTR4, attr4);
	}


	public List findByAttr5(Object attr5) {
		return findByProperty(ATTR5, attr5);
	}


	public List findByAttr6(Object attr6) {
		return findByProperty(ATTR6, attr6);
	}


	public List findByAttr7(Object attr7) {
		return findByProperty(ATTR7, attr7);
	}


	public List findByAttr8(Object attr8) {
		return findByProperty(ATTR8, attr8);
	}


	public List findByAttr9(Object attr9) {
		return findByProperty(ATTR9, attr9);
	}


	public List findByAttr10(Object attr10) {
		return findByProperty(ATTR10, attr10);
	}


	public List findByAttr11(Object attr11) {
		return findByProperty(ATTR11, attr11);
	}


	public List findByAttr12(Object attr12) {
		return findByProperty(ATTR12, attr12);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr13(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr13(java.lang.Object)
	 */
	public List findByAttr13(Object attr13) {
		return findByProperty(ATTR13, attr13);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr14(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr14(java.lang.Object)
	 */
	public List findByAttr14(Object attr14) {
		return findByProperty(ATTR14, attr14);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr15(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr15(java.lang.Object)
	 */
	public List findByAttr15(Object attr15) {
		return findByProperty(ATTR15, attr15);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr16(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr16(java.lang.Object)
	 */
	public List findByAttr16(Object attr16) {
		return findByProperty(ATTR16, attr16);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr17(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr17(java.lang.Object)
	 */
	public List findByAttr17(Object attr17) {
		return findByProperty(ATTR17, attr17);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr18(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr18(java.lang.Object)
	 */
	public List findByAttr18(Object attr18) {
		return findByProperty(ATTR18, attr18);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr19(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr19(java.lang.Object)
	 */
	public List findByAttr19(Object attr19) {
		return findByProperty(ATTR19, attr19);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr20(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr20(java.lang.Object)
	 */
	public List findByAttr20(Object attr20) {
		return findByProperty(ATTR20, attr20);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr21(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr21(java.lang.Object)
	 */
	public List findByAttr21(Object attr21) {
		return findByProperty(ATTR21, attr21);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr22(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr22(java.lang.Object)
	 */
	public List findByAttr22(Object attr22) {
		return findByProperty(ATTR22, attr22);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr23(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr23(java.lang.Object)
	 */
	public List findByAttr23(Object attr23) {
		return findByProperty(ATTR23, attr23);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr24(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr24(java.lang.Object)
	 */
	public List findByAttr24(Object attr24) {
		return findByProperty(ATTR24, attr24);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findByAttr25(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findByAttr25(java.lang.Object)
	 */
	public List findByAttr25(Object attr25) {
		return findByProperty(ATTR25, attr25);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbBzsqgzs instances");
		try {
			String queryString = "from TbBzsqgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#merge(com.baosight.mode.TbBzsqgzs)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#merge(com.baosight.mode.TbBzsqgzs)
	 */
	public TbBzsqgzs merge(TbBzsqgzs detachedInstance) {
		log.debug("merging TbBzsqgzs instance");
		try {
			TbBzsqgzs result = (TbBzsqgzs) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#attachDirty(com.baosight.mode.TbBzsqgzs)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#attachDirty(com.baosight.mode.TbBzsqgzs)
	 */
	public void attachDirty(TbBzsqgzs instance) {
		log.debug("attaching dirty TbBzsqgzs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbZfxxbfgkgzsDAO#attachClean(com.baosight.mode.TbBzsqgzs)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbBzsqgzsDAO#attachClean(com.baosight.mode.TbBzsqgzs)
	 */
	public void attachClean(TbBzsqgzs instance) {
		log.debug("attaching clean TbBzsqgzs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbBzsqgzsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbBzsqgzsDAO) ctx.getBean("tbBzsqgzsDAO");
	}
	public void update(TbBzsqgzs item) {
		log.debug("update TbBzsqgzs instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}