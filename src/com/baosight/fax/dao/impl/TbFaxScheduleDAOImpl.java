package com.baosight.fax.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.fax.dao.TbFaxScheduleDAO;
import com.baosight.fax.mode.TbFaxSchedule;

/**
 * Data access object (DAO) for domain model class TbFaxSchedule.
 * 
 * @see com.baosight.fax.dao.TbFaxSchedule
 * @author MyEclipse Persistence Tools
 */

public class TbFaxScheduleDAOImpl extends DAOHelperImpl implements TbFaxScheduleDAO{
	private static final Log log = LogFactory.getLog(TbFaxScheduleDAOImpl.class);

	// property constants
	public static final String CONTENT = "content";

	public static final String SENDER = "sender";

	public static final String SENDERID = "senderid";

	public static final String FAX = "fax";

	public static final String SENDTYPE = "sendtype";

	public static final String STATE = "state";

	public static final String RECMAN = "recman";

	public static final String RECMANID = "recmanid";

	public static final String RECGROUPID = "recgroupid";

	public static final String SENDDEPTID = "senddeptid";

	public static final String FAXFLAG = "faxflag";

	protected void initDao() {
		// do nothing
	}

	public void save(TbFaxSchedule transientInstance) {
		log.debug("saving TbFaxSchedule instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbFaxSchedule persistentInstance) {
		log.debug("deleting TbFaxSchedule instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbFaxSchedule findById(java.lang.String id) {
		log.debug("getting TbFaxSchedule instance with id: " + id);
		try {
			TbFaxSchedule instance = (TbFaxSchedule) getHibernateTemplate()
					.get("com.baosight.fax.mode.TbFaxSchedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbFaxSchedule instance) {
		log.debug("finding TbFaxSchedule instance by example");
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
		log.debug("finding TbFaxSchedule instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbFaxSchedule as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findBySender(Object sender) {
		return findByProperty(SENDER, sender);
	}

	public List findBySenderid(Object senderid) {
		return findByProperty(SENDERID, senderid);
	}

	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	public List findBySendtype(Object sendtype) {
		return findByProperty(SENDTYPE, sendtype);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByRecman(Object recman) {
		return findByProperty(RECMAN, recman);
	}

	public List findByRecmanid(Object recmanid) {
		return findByProperty(RECMANID, recmanid);
	}

	public List findByRecgroupid(Object recgroupid) {
		return findByProperty(RECGROUPID, recgroupid);
	}

	public List findBySenddeptid(Object senddeptid) {
		return findByProperty(SENDDEPTID, senddeptid);
	}

	public List findByFaxflag(Object faxflag) {
		return findByProperty(FAXFLAG, faxflag);
	}

	public List findAll() {
		log.debug("finding all TbFaxSchedule instances");
		try {
			String queryString = "from TbFaxSchedule";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbFaxSchedule merge(TbFaxSchedule detachedInstance) {
		log.debug("merging TbFaxSchedule instance");
		try {
			TbFaxSchedule result = (TbFaxSchedule) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbFaxSchedule instance) {
		log.debug("attaching dirty TbFaxSchedule instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbFaxSchedule instance) {
		log.debug("attaching clean TbFaxSchedule instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbFaxScheduleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbFaxScheduleDAO) ctx.getBean("TbFaxScheduleDAO");
	}

	public List findByHql(String sql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(sql);
	}

	public void update(TbFaxSchedule instance) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(instance);
	}
}