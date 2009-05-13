package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbCommissionDAO;
import com.baosight.mode.TbCommission;

/**
 * Data access object (DAO) for domain model class TbCommission.
 * 
 * @see com.baosight.mode.TbCommission
 * @author MyEclipse Persistence Tools
 */

public class TbCommissionDAOImpl extends HibernateDaoSupport implements ITbCommissionDAO {
	private static final Log log = LogFactory.getLog(TbCommissionDAOImpl.class);

	// property constants
	public static final String COMM_ID = "commId";

	public static final String COMM_NAME = "commName";

	public static final String BECOMMED_ID = "becommedId";

	public static final String BECOMMED_NAME = "becommedName";

	public static final String COMM_MATTERS = "commMatters";

	public static final String COMM_FLAG = "commFlag";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public void save(TbCommission transientInstance) {
		log.debug("saving TbCommission instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbCommission persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbCommission findById(java.lang.String id) {
		log.debug("getting TbCommission instance with id: " + id);
		try {
			TbCommission instance = (TbCommission)getHibernateTemplate().get(
					"com.baosight.mode.TbCommission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbCommission instance) {
		log.debug("finding TbCommission instance by example");
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
		log.debug("finding TbCommission instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbCommission as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCommId(Object commId) {
		return findByProperty(COMM_ID, commId);
	}

	public List findByCommName(Object commName) {
		return findByProperty(COMM_NAME, commName);
	}

	public List findByBecommedId(Object becommedId) {
		return findByProperty(BECOMMED_ID, becommedId);
	}

	public List findByBecommedName(Object becommedName) {
		return findByProperty(BECOMMED_NAME, becommedName);
	}

	public List findByCommMatters(Object commMatters) {
		return findByProperty(COMM_MATTERS, commMatters);
	}

	public List findByCommFlag(Object commFlag) {
		return findByProperty(COMM_FLAG, commFlag);
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

	public List findAll() {
		log.debug("finding all TbCommission instances");
		/*try {
			String queryString = "from TbCommission";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}*/
		try {
			String queryString = "from TbBzsqgzs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbCommission merge(TbCommission detachedInstance) {
		log.debug("merging TbCommission instance");
		try {
			TbCommission result = (TbCommission) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbCommission instance) {
		log.debug("attaching dirty TbCommission instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbCommission instance) {
		log.debug("attaching clean TbCommission instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(TbCommission item) {
		log.debug("update TbBzsqgzs instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据hql找委托或被委托列表
	 * @param hql
	 * @return
	 */
	public List findCommissionListByHql(String hql) {
		
		return getHibernateTemplate().find(hql);
	}
}