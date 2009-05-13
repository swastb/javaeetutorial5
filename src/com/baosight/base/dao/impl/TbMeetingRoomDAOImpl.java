package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbMeetingRoomDAO;
import com.baosight.mode.TbMeetingroom;

/**
 * Data access object (DAO) for domain model class TbMeetingroom.
 * 
 * @see com.baosight.mode.TbMeetingroom
 * @author MyEclipse Persistence Tools
 */

public class TbMeetingRoomDAOImpl extends HibernateDaoSupport implements ITbMeetingRoomDAO {
	private static final Log log = LogFactory.getLog(TbMeetingRoomDAOImpl.class);

	// property constants
	public static final String ROOM_NAME = "roomName";

	public static final String LOCATION = "location";

	public static final String CAPABILITY = "capability";

	public static final String STATUS = "status";

	public static final String REM = "rem";

	public static final String DEPT = "dept";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#save(com.baosight.mode.TbMeetingroom)
	 */
	public void save(TbMeetingroom transientInstance) {
		log.debug("saving TbMeetingroom instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#update(com.baosight.mode.TbMeetingroom)
	 */
	public void update(TbMeetingroom transientInstance) {
		log.debug("updating TbMeetingroom instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#delete(com.baosight.mode.TbMeetingroom)
	 */
	public void delete(TbMeetingroom persistentInstance) {
		log.debug("deleting TbMeetingroom instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findById(java.lang.String)
	 */
	public TbMeetingroom findById(java.lang.String id) {
		log.debug("getting TbMeetingroom instance with id: " + id);
		try {
			TbMeetingroom instance = (TbMeetingroom) getHibernateTemplate()
					.get("com.baosight.mode.TbMeetingroom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByExample(com.baosight.mode.TbMeetingroom)
	 */
	public List findByExample(TbMeetingroom instance) {
		log.debug("finding TbMeetingroom instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbMeetingroom instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbMeetingroom as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByRoomName(java.lang.Object)
	 */
	public List findByRoomName(Object roomName) {
		return findByProperty(ROOM_NAME, roomName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByLocation(java.lang.Object)
	 */
	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByCapability(java.lang.Object)
	 */
	public List findByCapability(Object capability) {
		return findByProperty(CAPABILITY, capability);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByDept(java.lang.Object)
	 */
	public List findByDept(Object dept) {
		return findByProperty(DEPT, dept);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbMeetingroom instances");
		try {
			String queryString = "from TbMeetingroom";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
//	public List findByRommName() {
//		log.debug("finding all TbMeetingroom instances");
//		try {
//			String queryString = "select t. from TbMeetingroom t";
//			return getHibernateTemplate().find(queryString);
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#merge(com.baosight.mode.TbMeetingroom)
	 */
	public TbMeetingroom merge(TbMeetingroom detachedInstance) {
		log.debug("merging TbMeetingroom instance");
		try {
			TbMeetingroom result = (TbMeetingroom) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#attachDirty(com.baosight.mode.TbMeetingroom)
	 */
	public void attachDirty(TbMeetingroom instance) {
		log.debug("attaching dirty TbMeetingroom instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbMeetingRoomDAO#attachClean(com.baosight.mode.TbMeetingroom)
	 */
	public void attachClean(TbMeetingroom instance) {
		log.debug("attaching clean TbMeetingroom instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbMeetingRoomDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbMeetingRoomDAO) ctx.getBean("TbMeetingroomDAO");
	}

	public List checkMeetingRoomName(String id, String value) {
		log.debug("finding TbMeetingroom instance with property: value: "
				+ value);
		String queryString = "";
		try {
			if ("".equals(id)) {
				queryString = "from TbMeetingroom as model where model.roomName= '"
						+ value + "'";
			} else {
				queryString = "from TbMeetingroom as model where model.roomName= '"
						+ value + "' and model.id != '" + id + "'";
			}

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

}