package com.baosight.base.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import oracle.sql.CLOB;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.lob.SerializableClob;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbInfoPubContentDAO;
import com.baosight.hibernate.HibernateSessionFactory;
import com.baosight.mode.TbInfoPubContent;

/**
 * Data access object (DAO) for domain model class TbInfoPubContent.
 * 
 * @see com.baosight.mode.TbInfoPubContent
 * @author MyEclipse Persistence Tools
 */

public class TbInfoPubContentDAOImpl extends HibernateDaoSupport implements
		ITbInfoPubContentDAO {
	private static final Log log = LogFactory
			.getLog(TbInfoPubContentDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String INFO_ID = "infoId";

	public static final String INFO_SOURCE = "infoSource";

	public static final String TITLE = "title";

	public static final String AUTHOR_NAME = "authorName";

	public static final String KEYWORD = "keyword";

	public static final String CONTENT = "content";

	public static final String PUBLISH_FLAG = "publishFlag";

	public static final String SEND_TO = "sendTo";

	public static final String INFO_SUBJECT = "infoSubject";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	/*
	 * private LobHandler lobHandler; //¢Ÿ ∂®“Â LobHandler  Ù–‘ public LobHandler
	 * getLobHandler() { return lobHandler; } public void
	 * setLobHandler(LobHandler lobHandler) { this.lobHandler = lobHandler; }
	 */
	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#save(com.baosight.mode.TbInfoPubContent)
	 */
	public void save(TbInfoPubContent transientInstance) throws HibernateException {
		log.debug("saving TbInfoPubContent instance");
		try {
			Clob clobCon = transientInstance.getContent();
			Session ssesion = getSession();    
			//Transaction ts = ssesion.beginTransaction();  
			transientInstance.setContent(Hibernate.createClob(" "));
			
			getHibernateTemplate().save(transientInstance);
			
			getHibernateTemplate().flush(); 
			getHibernateTemplate().refresh(transientInstance,LockMode.UPGRADE); 
			SerializableClob clob=(SerializableClob)transientInstance.getContent();     
			java.sql.Clob wrapClob = clob.getWrappedClob();     
			CLOB tmpClob=(CLOB)wrapClob;     
			Writer wt=tmpClob.getCharacterOutputStream(); 
			String content = ClobToString(clobCon);    
			wt.write(content);    
			wt.close(); 
			ssesion.save(transientInstance); 
			//ts.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
			}
	}
	public String ClobToString(Clob clob) {
		String reString = "";
		try {
			Reader reader = clob.getCharacterStream();
			char[] buffer = new char[(int) clob.length()];
			reader.read(buffer);
			reader.close();
			return new String(buffer).replaceAll("\\\\\"", "\"");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reString;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#delete(com.baosight.mode.TbInfoPubContent)
	 */
	public void delete(TbInfoPubContent persistentInstance) {
		log.debug("deleting TbInfoPubContent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findById(java.lang.String)
	 */
	public TbInfoPubContent findById(java.lang.String id) {
		log.debug("getting TbInfoPubContent instance with id: " + id);
		try {
			TbInfoPubContent instance = (TbInfoPubContent) getHibernateTemplate()
					.get("com.baosight.mode.TbInfoPubContent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByExample(com.baosight.mode.TbInfoPubContent)
	 */
	public List findByExample(TbInfoPubContent instance) {
		log.debug("finding TbInfoPubContent instance by example");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbInfoPubContent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbInfoPubContent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByInfoId(java.lang.Object)
	 */
	public List findByInfoId(Object infoId) {
		return findByProperty(INFO_ID, infoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByInfoSource(java.lang.Object)
	 */
	public List findByInfoSource(Object infoSource) {
		return findByProperty(INFO_SOURCE, infoSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByAuthorName(java.lang.Object)
	 */
	public List findByAuthorName(Object authorName) {
		return findByProperty(AUTHOR_NAME, authorName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByKeyword(java.lang.Object)
	 */
	public List findByKeyword(Object keyword) {
		return findByProperty(KEYWORD, keyword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByInfoContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByPublishFlag(java.lang.Object)
	 */
	public List findByPublishFlag(Object publishFlag) {
		return findByProperty(PUBLISH_FLAG, publishFlag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findBySendTo(java.lang.Object)
	 */
	public List findBySendTo(Object sendTo) {
		return findByProperty(SEND_TO, sendTo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByInfoSubject(java.lang.Object)
	 */
	public List findByInfoSubject(Object infoSubject) {
		return findByProperty(INFO_SUBJECT, infoSubject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbInfoPubContent instances");
		try {
			String queryString = "from TbInfoPubContent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#merge(com.baosight.mode.TbInfoPubContent)
	 */
	public TbInfoPubContent merge(TbInfoPubContent detachedInstance) {
		log.debug("merging TbInfoPubContent instance");
		try {
			TbInfoPubContent result = (TbInfoPubContent) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#attachDirty(com.baosight.mode.TbInfoPubContent)
	 */
	public void attachDirty(TbInfoPubContent instance) {
		log.debug("attaching dirty TbInfoPubContent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#attachClean(com.baosight.mode.TbInfoPubContent)
	 */
	public void attachClean(TbInfoPubContent instance) {
		log.debug("attaching clean TbInfoPubContent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#update(com.baosight.mode.TbInfoPubContent)
	 */
	public void update(TbInfoPubContent instance) {
		log.debug("updating TbInfoPubContent instance");
		try {
			Clob clobCon = instance.getContent();
			Session session = HibernateSessionFactory.getSession();    
			//Transaction ts = session.beginTransaction();  
			instance.setContent(Hibernate.createClob(" "));
			
			getHibernateTemplate().update(instance);
			
			getHibernateTemplate().flush(); 
			getHibernateTemplate().refresh(instance,LockMode.UPGRADE); 
			SerializableClob clob=(SerializableClob)instance.getContent();     
			java.sql.Clob wrapClob = clob.getWrappedClob();     
			CLOB tmpClob=(CLOB)wrapClob;     
			Writer wt=tmpClob.getCharacterOutputStream(); 
			String content = ClobToString(clobCon);    
			wt.write(content);    
			wt.close(); 
			session.update(instance); 
			//ts.commit();
			
			//getHibernateTemplate().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ITbInfoPubContentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbInfoPubContentDAO) ctx.getBean("TbInfoPubContentDAO");
	}

	/**
	 * same name checked
	 * 
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public List checkInfoCommName(String parentid,String id, String value, String flag) {
		log.debug("finding TbInfoPubContent instance with property: value: "
				+ value);
		String queryString = "";
		try {
			if ("".equals(id)) {
				queryString = "from TbInfoPubContent as model where model.title= '"
						+ value + "' and model.infoSubject='"+parentid+"'";
			} else {
				queryString = "from TbInfoPubContent as model where model.title= '"
						+ value + "' and model.id != '" + id + "' and model.infoSubject='"+parentid+"'";
			}

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	public List checkInfoClaCommName(String parentid,String id, String value, String flag) {
		log.debug("finding TbInfoPubCla instance with property: value: "
				+ value);
		String queryString = "";
		try {
			if ("".equals(id)) {
				queryString = "from TbInfoPubCla as model where model."+flag+"= '"
						+ value + "' and model.parentid='"+parentid+"'";
			} else {
				queryString = "from TbInfoPubCla as model where model."+flag+"= '"
						+ value + "' and model.id != '" + id + "' and model.parentid='"+parentid+"'";
			}

			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}
	/**
	 * true -1-1
	 */
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
	public List findByHQL(final String hql) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				return query.list();
			}
		}, true);
	}
}