package com.baosight.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbPublicAffairTransactDAO;
import com.baosight.mode.TbPublicAffairTransact;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbPublicAffairTransact entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.baosight.mode.TbPublicAffairTransact
 * @author MyEclipse Persistence Tools
 */

public class TbPublicAffairTransactDAOImpl extends HibernateDaoSupport implements  ITbPublicAffairTransactDAO {
	private static final Log log = LogFactory
			.getLog(TbPublicAffairTransactDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TbPublicAffairTransact transientInstance) {
		log.debug("saving TbPublicAffairTransact instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public List getPublicAffairTransactById(String id,Long affairType,Long type){
		List list = new ArrayList();
		//String HSQL="select u.name,t.receiveTime,t.commenta from TbPublicAffairTransact t,TbUser u " +
				//"where t.transactor = u.id  and  t.affairId=? and t.affairType=?";
		String HSQL="select u.name,t.receiveTime,t.commenta from TbPublicAffairTransact t,TbUser u " +
		"where t.transactor = u.id  and  t.affairId=? and t.affairType=?";
		/*if(!(type.toString().equals("0"))){
			HSQL +=" and t.type=?";
			list=getHibernateTemplate().find(HSQL,new Object[]{id,affairType,type});
		}else{
			list=getHibernateTemplate().find(HSQL,new Object[]{id,affairType});
		}
		*/
		//list=getHibernateTemplate().find(HSQL,new Object[]{id});
		//list= getHibernateTemplate().find(HSQL);
		list=getHibernateTemplate().find(HSQL,new Object[]{id,affairType});
		return list;
		
	}
	
	public void update(TbPublicAffairTransact transientInstance) {
		log.debug("saving TbPublicAffairTransact instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(TbPublicAffairTransact persistentInstance) {
		log.debug("deleting TbPublicAffairTransact instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbPublicAffairTransact findById(java.lang.String id) {
		log.debug("getting TbPublicAffairTransact instance with id: " + id);
		try {
			TbPublicAffairTransact instance = (TbPublicAffairTransact) getHibernateTemplate()
					.get("com.baosight.mode.TbPublicAffairTransact", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbPublicAffairTransact instance) {
		log.debug("finding TbPublicAffairTransact instance by example");
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
		log.debug("finding TbPublicAffairTransact instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbPublicAffairTransact as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TbPublicAffairTransact instances");
		try {
			String queryString = "from TbPublicAffairTransact";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbPublicAffairTransact merge(TbPublicAffairTransact detachedInstance) {
		log.debug("merging TbPublicAffairTransact instance");
		try {
			TbPublicAffairTransact result = (TbPublicAffairTransact) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbPublicAffairTransact instance) {
		log.debug("attaching dirty TbPublicAffairTransact instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbPublicAffairTransact instance) {
		log.debug("attaching clean TbPublicAffairTransact instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbPublicAffairTransactDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbPublicAffairTransactDAOImpl) ctx
				.getBean("TbPublicAffairTransactDAO");
	}
}