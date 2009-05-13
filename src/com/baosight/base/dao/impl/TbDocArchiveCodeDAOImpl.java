package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocArchiveCodeDAO;
import com.baosight.mode.TbDocArchiveCode;

/**
 * Data access object (DAO) for domain model class TbDocArchiveCode.
 * 
 * @see com.baosight.base.dao.impl.TbDocArchiveCode
 * @author MyEclipse Persistence Tools
 */

public class TbDocArchiveCodeDAOImpl extends HibernateDaoSupport implements ITbDocArchiveCodeDAO {
	private static final Log log = LogFactory.getLog(TbDocArchiveCodeDAOImpl.class);

	// property constants
	public static final String SN = "sn";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	public static final String CATEGORY_ID = "categoryId";

	public static final String YEAR = "year";

	public static final String PAGE_COUNT = "pageCount";

	public static final String PAGE_SIZE = "pageSize";

	public static final String KEEP_TIME = "keepTime";

	public static final String PARENT_ID = "parentId";

	public static final String SEQ = "seq";

	public static final String SYS_ATTR = "sysAttr";

	public static final String STATUS = "status";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocArchiveCode transientInstance) {
		log.debug("saving TbDocArchiveCode instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocArchiveCode persistentInstance) {
		log.debug("deleting TbDocArchiveCode instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocArchiveCode findById(java.lang.String id) {
		log.debug("getting TbDocArchiveCode instance with id: " + id);
		try {
			TbDocArchiveCode instance = (TbDocArchiveCode) getHibernateTemplate()
					.get("com.baosight.mode.TbDocArchiveCode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocArchiveCode instance) {
		log.debug("finding TbDocArchiveCode instance by example");
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
		log.debug("finding TbDocArchiveCode instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocArchiveCode as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySn(Object sn) {
		return findByProperty(SN, sn);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByCategoryId(Object categoryId) {
		return findByProperty(CATEGORY_ID, categoryId);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByPageCount(Object pageCount) {
		return findByProperty(PAGE_COUNT, pageCount);
	}

	public List findByPageSize(Object pageSize) {
		return findByProperty(PAGE_SIZE, pageSize);
	}

	public List findByKeepTime(Object keepTime) {
		return findByProperty(KEEP_TIME, keepTime);
	}

	public List findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	public List findBySeq(Object seq) {
		return findByProperty(SEQ, seq);
	}

	public List findBySysAttr(Object sysAttr) {
		return findByProperty(SYS_ATTR, sysAttr);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
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
		log.debug("finding all TbDocArchiveCode instances");
		try {
			String queryString = "from TbDocArchiveCode";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocArchiveCode merge(TbDocArchiveCode detachedInstance) {
		log.debug("merging TbDocArchiveCode instance");
		try {
			TbDocArchiveCode result = (TbDocArchiveCode) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocArchiveCode instance) {
		log.debug("attaching dirty TbDocArchiveCode instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocArchiveCode instance) {
		log.debug("attaching clean TbDocArchiveCode instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocArchiveCodeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocArchiveCodeDAO) ctx.getBean("TbDocArchiveCodeDAO");
	}
}