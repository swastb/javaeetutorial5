package com.baosight.base.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
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

import com.baosight.base.dao.ITbGovInfoPubContentDAO;
import com.baosight.hibernate.HibernateSessionFactory;
import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbInfoPubContent;

/**
 * Data access object (DAO) for domain model class TbGovInfoPubContent.
 * @see com.baosight.mode.TbGovInfoPubContent
  * @author MyEclipse Persistence Tools 
 */

public class TbGovInfoPubContentDAOImpl extends HibernateDaoSupport implements ITbGovInfoPubContentDAO {
    private static final Log log = LogFactory.getLog(TbGovInfoPubContentDAOImpl.class);
	//property constants
	public static final String INFO_SOURCE = "infoSource";
	public static final String TITLE = "title";
	public static final String AUTHOR_NAME = "authorName";
	public static final String KEYWORD = "keyword";
	public static final String SUMMARY = "summary";
	public static final String CONTENT = "content";
	public static final String PUBLISH_TYPE = "publishType";
	public static final String FILE_CODE = "fileCode";
	public static final String INFO_SUBJECT = "infoSubject";
	public static final String OFFER_WAY = "offerWay";
	public static final String APPLY_ID = "applyId";
	public static final String STATUS = "status";
	public static final String ATTR1 = "attr1";
	public static final String ATTR2 = "attr2";
	public static final String ATTR3 = "attr3";

	private String queryCacheRegion = null;
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	protected void initDao() {
		//do nothing
	}
    
    public void save(TbGovInfoPubContent transientInstance) {
        log.debug("saving TbGovInfoPubContent instance");
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
    
	public void delete(TbGovInfoPubContent persistentInstance) {
        log.debug("deleting TbGovInfoPubContent instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TbGovInfoPubContent findById( java.lang.String id) {
        log.debug("getting TbGovInfoPubContent instance with id: " + id);
        try {
            TbGovInfoPubContent instance = (TbGovInfoPubContent) getHibernateTemplate()
                    .get("com.baosight.mode.TbGovInfoPubContent", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TbGovInfoPubContent instance) {
        log.debug("finding TbGovInfoPubContent instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TbGovInfoPubContent instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TbGovInfoPubContent as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByInfoSource(Object infoSource) {
		return findByProperty(INFO_SOURCE, infoSource);
	}
	
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}
	
	public List findByAuthorName(Object authorName) {
		return findByProperty(AUTHOR_NAME, authorName);
	}
	
	public List findByKeyword(Object keyword) {
		return findByProperty(KEYWORD, keyword);
	}
	
	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}
	
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}
	
	public List findByPublishType(Object publishType) {
		return findByProperty(PUBLISH_TYPE, publishType);
	}
	
	public List findByFileCode(Object fileCode) {
		return findByProperty(FILE_CODE, fileCode);
	}
	
	public List findByInfoSubject(Object infoSubject) {
		return findByProperty(INFO_SUBJECT, infoSubject);
	}
	
	public List findByOfferWay(Object offerWay) {
		return findByProperty(OFFER_WAY, offerWay);
	}
	
	public List findByApplyId(Object applyId) {
		return findByProperty(APPLY_ID, applyId);
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
		log.debug("finding all TbGovInfoPubContent instances");
		try {
			String queryString = "from TbGovInfoPubContent t where rownum=5";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TbGovInfoPubContent merge(TbGovInfoPubContent detachedInstance) {
        log.debug("merging TbGovInfoPubContent instance");
        try {
            TbGovInfoPubContent result = (TbGovInfoPubContent) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TbGovInfoPubContent instance) {
        log.debug("attaching dirty TbGovInfoPubContent instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TbGovInfoPubContent instance) {
        log.debug("attaching clean TbGovInfoPubContent instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubContentDAO#update(com.baosight.mode.TbInfoPubContent)
	 */
	public void update(TbGovInfoPubContent instance) {
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
	public static TbGovInfoPubContentDAOImpl getFromApplicationContext(ApplicationContext ctx) {
    	return (TbGovInfoPubContentDAOImpl) ctx.getBean("TbGovInfoPubContentDAOImpl");
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

	public List fingByHql(final String sql) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(sql);
				return query.list();
			}
		}, true);
	}	
}