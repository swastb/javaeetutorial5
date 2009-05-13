package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.ITbDocRecDAO;
import com.baosight.mode.TbDocRec;

/**
 * Data access object (DAO) for domain model class TbDocRec.
 * 
 * @see com.baosight.base.dao.impl.TbDocRec
 * @author MyEclipse Persistence Tools
 */

public class TbDocRecDAOImpl extends DAOHelperImpl implements ITbDocRecDAO {
	private static final Log log = LogFactory.getLog(TbDocRecDAOImpl.class);
	// property constants
	public static final String INFO_LEVEL = "infoLevel";

	public static final String DOC_DEPT = "docDept";

	public static final String DOC_CODE = "docCode";

	public static final String DOC_NUM = "docNum";

	public static final String DOC_TYPE = "docType";

	public static final String DOC_NAME = "docName";

	public static final String DRAFT_OPINION = "draftOpinion";

	public static final String BOOK_USER = "bookUser";

	public static final String AUDIT_USER = "auditUser";

	public static final String LEADER_AUDIT = "leaderAudit";

	public static final String ASS_USER_REMARK = "assUserRemark";

	public static final String MAIN_DEPT_OPINION = "mainDeptOpinion";

	public static final String DEAL_STATE = "dealState";

	public static final String DOC_STATE = "docState";

	public static final String ARCHIVE_FLAG = "archiveFlag";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#save(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#save(com.baosight.mode.TbDocRec)
	 */
	public void save(TbDocRec transientInstance) {
		log.debug("saving TbDocRec instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#delete(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#delete(com.baosight.mode.TbDocRec)
	 */
	public void delete(TbDocRec persistentInstance) {
		log.debug("deleting TbDocRec instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findById(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findById(java.lang.String)
	 */
	public TbDocRec findById(java.lang.String id) {
		log.debug("getting TbDocRec instance with id: " + id);
		try {
			TbDocRec instance = (TbDocRec) getHibernateTemplate().get(
					"com.baosight.mode.TbDocRec", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByExample(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByExample(com.baosight.mode.TbDocRec)
	 */
	public List findByExample(TbDocRec instance) {
		log.debug("finding TbDocRec instance by example");
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
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByProperty(java.lang.String, java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocRec instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDocRec as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByInfoLevel(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByInfoLevel(java.lang.Object)
	 */
	public List findByInfoLevel(Object infoLevel) {
		return findByProperty(INFO_LEVEL, infoLevel);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocDept(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocDept(java.lang.Object)
	 */
	public List findByDocDept(Object docDept) {
		return findByProperty(DOC_DEPT, docDept);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocCode(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocCode(java.lang.Object)
	 */
	public List findByDocCode(Object docCode) {
		return findByProperty(DOC_CODE, docCode);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocNum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocNum(java.lang.Object)
	 */
	public List findByDocNum(Object docNum) {
		return findByProperty(DOC_NUM, docNum);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocType(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocType(java.lang.Object)
	 */
	public List findByDocType(Object docType) {
		return findByProperty(DOC_TYPE, docType);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocName(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocName(java.lang.Object)
	 */
	public List findByDocName(Object docName) {
		return findByProperty(DOC_NAME, docName);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDraftOpinion(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDraftOpinion(java.lang.Object)
	 */
	public List findByDraftOpinion(Object draftOpinion) {
		return findByProperty(DRAFT_OPINION, draftOpinion);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByBookUser(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByBookUser(java.lang.Object)
	 */
	public List findByBookUser(Object bookUser) {
		return findByProperty(BOOK_USER, bookUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByAuditUser(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByAuditUser(java.lang.Object)
	 */
	public List findByAuditUser(Object auditUser) {
		return findByProperty(AUDIT_USER, auditUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByLeaderAudit(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByLeaderAudit(java.lang.Object)
	 */
	public List findByLeaderAudit(Object leaderAudit) {
		return findByProperty(LEADER_AUDIT, leaderAudit);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByAssUserRemark(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByAssUserRemark(java.lang.Object)
	 */
	public List findByAssUserRemark(Object assUserRemark) {
		return findByProperty(ASS_USER_REMARK, assUserRemark);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByMainDeptOpinion(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByMainDeptOpinion(java.lang.Object)
	 */
	public List findByMainDeptOpinion(Object mainDeptOpinion) {
		return findByProperty(MAIN_DEPT_OPINION, mainDeptOpinion);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDealState(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDealState(java.lang.Object)
	 */
	public List findByDealState(Object dealState) {
		return findByProperty(DEAL_STATE, dealState);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocState(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByDocState(java.lang.Object)
	 */
	public List findByDocState(Object docState) {
		return findByProperty(DOC_STATE, docState);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByArchiveFlag(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findByArchiveFlag(java.lang.Object)
	 */
	public List findByArchiveFlag(Object archiveFlag) {
		return findByProperty(ARCHIVE_FLAG, archiveFlag);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocRec instances");
		try {
			String queryString = "from TbDocRec";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#merge(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#merge(com.baosight.mode.TbDocRec)
	 */
	public TbDocRec merge(TbDocRec detachedInstance) {
		log.debug("merging TbDocRec instance");
		try {
			TbDocRec result = (TbDocRec) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#attachDirty(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#attachDirty(com.baosight.mode.TbDocRec)
	 */
	public void attachDirty(TbDocRec instance) {
		log.debug("attaching dirty TbDocRec instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#attachClean(com.baosight.mode.TbDocRec)
	 */
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDAO#attachClean(com.baosight.mode.TbDocRec)
	 */
	public void attachClean(TbDocRec instance) {
		log.debug("attaching clean TbDocRec instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocRecDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbDocRecDAO) ctx.getBean("TbDocRecDAO");
	}

}