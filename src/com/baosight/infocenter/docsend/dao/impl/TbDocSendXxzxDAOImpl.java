package com.baosight.infocenter.docsend.dao.impl;

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

import com.baosight.infocenter.docsend.dao.ITbDocSendXxzxDAO;
import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;

/**
 * Data access object (DAO) for domain model class TbDocSendXxzx.
 * 
 * @see com.baosight.infocenter.docsend.mode.TbDocSendXxzx
 * @author MyEclipse Persistence Tools
 */

public class TbDocSendXxzxDAOImpl extends HibernateDaoSupport implements ITbDocSendXxzxDAO {
	private static final Log log = LogFactory.getLog(TbDocSendXxzxDAOImpl.class);
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

	public static final String DRAFT_USER = "draftUser";

	public static final String CHARGE_USER = "chargeUser";

	public static final String FILE_NO = "fileNo";

	public static final String FILE_NUM = "fileNum";

	public static final String PRINT_USER = "printUser";

	public static final String COLLATE_USER = "collateUser";

	public static final String SIGN_OPINION = "signOpinion";

	public static final String SECRET1 = "secret1";

	public static final String SECRET2 = "secret2";

	public static final String FILE_PAGES = "filePages";

	public static final String SEND_FILE_TYPE = "sendFileType";

	public static final String DOC_STATE = "docState";

	protected void initDao() {
		// do nothing
	}

	public void save(TbDocSendXxzx transientInstance) {
		log.debug("saving TbDocSendXxzx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbDocSendXxzx persistentInstance) {
		log.debug("deleting TbDocSendXxzx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbDocSendXxzx findById(java.lang.String id) {
		log.debug("getting TbDocSendXxzx instance with id: " + id);
		try {
			TbDocSendXxzx instance = (TbDocSendXxzx) getHibernateTemplate()
					.get("com.baosight.infocenter.docsend.mode.TbDocSendXxzx",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbDocSendXxzx instance) {
		log.debug("finding TbDocSendXxzx instance by example");
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
		log.debug("finding TbDocSendXxzx instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbDocSendXxzx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFileSecret(Object fileSecret) {
		return findByProperty(FILE_SECRET, fileSecret);
	}

	public List findBySign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	public List findByDraftOpinion(Object draftOpinion) {
		return findByProperty(DRAFT_OPINION, draftOpinion);
	}

	public List findByFileTitle(Object fileTitle) {
		return findByProperty(FILE_TITLE, fileTitle);
	}

	public List findByFileDept(Object fileDept) {
		return findByProperty(FILE_DEPT, fileDept);
	}

	public List findBySendMain(Object sendMain) {
		return findByProperty(SEND_MAIN, sendMain);
	}

	public List findBySendSecond(Object sendSecond) {
		return findByProperty(SEND_SECOND, sendSecond);
	}

	public List findByTopicWord(Object topicWord) {
		return findByProperty(TOPIC_WORD, topicWord);
	}

	public List findByDraftUser(Object draftUser) {
		return findByProperty(DRAFT_USER, draftUser);
	}

	public List findByChargeUser(Object chargeUser) {
		return findByProperty(CHARGE_USER, chargeUser);
	}

	public List findByFileNo(Object fileNo) {
		return findByProperty(FILE_NO, fileNo);
	}

	public List findByFileNum(Object fileNum) {
		return findByProperty(FILE_NUM, fileNum);
	}

	public List findByPrintUser(Object printUser) {
		return findByProperty(PRINT_USER, printUser);
	}

	public List findByCollateUser(Object collateUser) {
		return findByProperty(COLLATE_USER, collateUser);
	}

	public List findBySignOpinion(Object signOpinion) {
		return findByProperty(SIGN_OPINION, signOpinion);
	}

	public List findBySecret1(Object secret1) {
		return findByProperty(SECRET1, secret1);
	}

	public List findBySecret2(Object secret2) {
		return findByProperty(SECRET2, secret2);
	}

	public List findByFilePages(Object filePages) {
		return findByProperty(FILE_PAGES, filePages);
	}

	public List findBySendFileType(Object sendFileType) {
		return findByProperty(SEND_FILE_TYPE, sendFileType);
	}

	public List findByDocState(Object docState) {
		return findByProperty(DOC_STATE, docState);
	}

	public List findAll() {
		log.debug("finding all TbDocSendXxzx instances");
		try {
			String queryString = "from TbDocSendXxzx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbDocSendXxzx merge(TbDocSendXxzx detachedInstance) {
		log.debug("merging TbDocSendXxzx instance");
		try {
			TbDocSendXxzx result = (TbDocSendXxzx) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbDocSendXxzx instance) {
		log.debug("attaching dirty TbDocSendXxzx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbDocSendXxzx instance) {
		log.debug("attaching clean TbDocSendXxzx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbDocSendXxzxDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbDocSendXxzxDAO) ctx.getBean("TbDocSendXxzxDAO");
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