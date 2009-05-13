package com.baosight.base.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDocSendDAO;
import com.baosight.mode.TbDocSend;

/**
 * Data access object (DAO) for domain model class TbDocSend.
 * 
 * @see com.baosight.mode.TbDocSend
 * @author MyEclipse Persistence Tools
 */

public class TbDocSendDAOImpl extends HibernateDaoSupport implements ITbDocSendDAO {
	private static final Log log = LogFactory.getLog(TbDocSendDAOImpl.class);
	private String queryCacheRegion = null;
	// property constants
	public static final String FILE_SECRET = "fileSecret";

	public static final String SIGN = "sign";

	public static final String DRAFT_OPINION = "draftOpinion";

	public static final String FILE_TITLE = "fileTitle";

	public static final String FILE_DEPT = "fileDept";

	public static final String SEND_MAIN = "sendMain";

	public static final String SEND_SECOND = "sendSecond";

	public static final String TOPIC_WORD = "topicWord";

	public static final String MAIN_DRAFT_USER = "mainDraftUser";

	public static final String MAIN_CHARGE_USER = "mainChargeUser";

	public static final String OFFICE_DRAFT_USER = "officeDraftUser";

	public static final String OFFICE_CHARGE_USER = "officeChargeUser";

	public static final String FILE_NO = "fileNo";

	public static final String FILE_NUM = "fileNum";

	public static final String PRINT_USER = "printUser";

	public static final String COLLATE_USER = "collateUser";

	public static final String SIGN_OPINION = "signOpinion";

	public static final String SECRET1 = "secret1";

	public static final String SECRET2 = "secret2";

	public static final String FILE_PAGES = "filePages";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#save(com.baosight.mode.TbDocSend)
	 */
	public void save(TbDocSend transientInstance) {
		log.debug("saving TbDocSend instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#delete(com.baosight.mode.TbDocSend)
	 */
	public void delete(TbDocSend persistentInstance) {
		log.debug("deleting TbDocSend instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findById(java.lang.String)
	 */
	public TbDocSend findById(java.lang.String id) {
		log.debug("getting TbDocSend instance with id: " + id);
		try {
			TbDocSend instance = (TbDocSend) getHibernateTemplate().get(
					"com.baosight.mode.TbDocSend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByExample(com.baosight.mode.TbDocSend)
	 */
	public List findByExample(TbDocSend instance) {
		log.debug("finding TbDocSend instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDocSend instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDocSend as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFileSecret(java.lang.Object)
	 */
	public List findByFileSecret(Object fileSecret) {
		return findByProperty(FILE_SECRET, fileSecret);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySign(java.lang.Object)
	 */
	public List findBySign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByDraftOpinion(java.lang.Object)
	 */
	public List findByDraftOpinion(Object draftOpinion) {
		return findByProperty(DRAFT_OPINION, draftOpinion);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFileTitle(java.lang.Object)
	 */
	public List findByFileTitle(Object fileTitle) {
		return findByProperty(FILE_TITLE, fileTitle);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFileDept(java.lang.Object)
	 */
	public List findByFileDept(Object fileDept) {
		return findByProperty(FILE_DEPT, fileDept);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySendMain(java.lang.Object)
	 */
	public List findBySendMain(Object sendMain) {
		return findByProperty(SEND_MAIN, sendMain);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySendSecond(java.lang.Object)
	 */
	public List findBySendSecond(Object sendSecond) {
		return findByProperty(SEND_SECOND, sendSecond);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByTopicWord(java.lang.Object)
	 */
	public List findByTopicWord(Object topicWord) {
		return findByProperty(TOPIC_WORD, topicWord);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByMainDraftUser(java.lang.Object)
	 */
	public List findByMainDraftUser(Object mainDraftUser) {
		return findByProperty(MAIN_DRAFT_USER, mainDraftUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByMainChargeUser(java.lang.Object)
	 */
	public List findByMainChargeUser(Object mainChargeUser) {
		return findByProperty(MAIN_CHARGE_USER, mainChargeUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByOfficeDraftUser(java.lang.Object)
	 */
	public List findByOfficeDraftUser(Object officeDraftUser) {
		return findByProperty(OFFICE_DRAFT_USER, officeDraftUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByOfficeChargeUser(java.lang.Object)
	 */
	public List findByOfficeChargeUser(Object officeChargeUser) {
		return findByProperty(OFFICE_CHARGE_USER, officeChargeUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFileNo(java.lang.Object)
	 */
	public List findByFileNo(Object fileNo) {
		return findByProperty(FILE_NO, fileNo);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFileNum(java.lang.Object)
	 */
	public List findByFileNum(Object fileNum) {
		return findByProperty(FILE_NUM, fileNum);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByPrintUser(java.lang.Object)
	 */
	public List findByPrintUser(Object printUser) {
		return findByProperty(PRINT_USER, printUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByCollateUser(java.lang.Object)
	 */
	public List findByCollateUser(Object collateUser) {
		return findByProperty(COLLATE_USER, collateUser);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySignOpinion(java.lang.Object)
	 */
	public List findBySignOpinion(Object signOpinion) {
		return findByProperty(SIGN_OPINION, signOpinion);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySecret1(java.lang.Object)
	 */
	public List findBySecret1(Object secret1) {
		return findByProperty(SECRET1, secret1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findBySecret2(java.lang.Object)
	 */
	public List findBySecret2(Object secret2) {
		return findByProperty(SECRET2, secret2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findByFilePages(java.lang.Object)
	 */
	public List findByFilePages(Object filePages) {
		return findByProperty(FILE_PAGES, filePages);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDocSend instances");
		try {
			String queryString = "from TbDocSend";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#merge(com.baosight.mode.TbDocSend)
	 */
	public TbDocSend merge(TbDocSend detachedInstance) {
		log.debug("merging TbDocSend instance");
		try {
			TbDocSend result = (TbDocSend) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#attachDirty(com.baosight.mode.TbDocSend)
	 */
	public void attachDirty(TbDocSend instance) {
		log.debug("attaching dirty TbDocSend instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbDocSendDAO#attachClean(com.baosight.mode.TbDocSend)
	 */
	public void attachClean(TbDocSend instance) {
		log.debug("attaching clean TbDocSend instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocSendDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbDocSendDAO) ctx.getBean("tbDocSendDAO");
	}
	
	public List findBySql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
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
}