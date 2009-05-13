package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbPstDAO;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

/**
 * Data access object (DAO) for domain model class TbPst.
 * 
 * @see com.baosight.mode.TbPst
 * @author MyEclipse Persistence Tools
 */

public class TbPstDAOImpl extends HibernateDaoSupport implements ITbPstDAO {
	private static final Log log = LogFactory.getLog(TbPstDAOImpl.class);

	// property constants
	public static final String NAME = "name";

	public static final String LVL = "lvl";

	public static final String CODE = "code";
	
	public static final String DEPTID = "deptid";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#save(com.baosight.mode.TbPst)
	 */
	public void save(TbPst transientInstance) {
		log.debug("saving TbPst instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#delete(com.baosight.mode.TbPst)
	 */
	public void delete(TbPst persistentInstance) {
		log.debug("deleting TbPst instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findById(java.lang.String)
	 */
	public TbPst findById(java.lang.String id) {
		log.debug("getting TbPst instance with id: " + id);
		try {
			TbPst instance = (TbPst) getHibernateTemplate().get(
					"com.baosight.mode.TbPst", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findByExample(com.baosight.mode.TbPst)
	 */
	public List findByExample(TbPst instance) {
		log.debug("finding TbPst instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbPst instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbPst as model where model."
					+ propertyName + "= ? order by model.defOrder";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findByLvl(java.lang.Object)
	 */
	public List findByLvl(Object lvl) {
		return findByProperty(LVL, lvl);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbPst instances");
		try {
			String queryString = "from TbPst";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#merge(com.baosight.mode.TbPst)
	 */
	public TbPst merge(TbPst detachedInstance) {
		log.debug("merging TbPst instance");
		try {
			TbPst result = (TbPst) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#attachDirty(com.baosight.mode.TbPst)
	 */
	public void attachDirty(TbPst instance) {
		log.debug("attaching dirty TbPst instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbPstDAO#attachClean(com.baosight.mode.TbPst)
	 */
	public void attachClean(TbPst instance) {
		log.debug("attaching clean TbPst instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbPstDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbPstDAO) ctx.getBean("tbPstDAO");
	}

	public List findByDeptId(Object deptId) {
		return findByProperty(DEPTID, deptId);
	}
	/**
	 * 编辑职务
	 */
	public void updatePost(TbPst item){
		log.debug("modfying TbPst instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("modify successful");
		} catch (RuntimeException re) {
			log.error("modify failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param parentId
	 * @param defOrder
	 * @return
	 */
	public TbPst findByPDefOrder(String parentId,long defOrder,String type){
		log.debug("getting TbUser instance ");
		try {
			String hqlUp="from TbPst t where t.deptid=? and t.defOrder=" +
					"(select max(t1.defOrder) from TbPst t1 where t1.deptid=? and t1.defOrder<?)";
			String hqlDown="from TbPst t where t.deptid=? and t.defOrder=" +
					"(select min(t1.defOrder) from TbPst t1 where t1.deptid=? and t1.defOrder>?)";
			Object object[]={parentId,parentId,defOrder};
			List list = null;
			if(type.equals("up"))
				list = getHibernateTemplate().find(hqlUp,object);
			else
				list = getHibernateTemplate().find(hqlDown,object);
			if (list.size()>0 && !list.isEmpty())
				return (TbPst)list.get(0);
			else 
				return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	//职务
	public List checkName(Object id, Object value,Object par,String field) {
		log.debug("finding TbPst instance with property: name, value: " + value);
		String queryString ="";
		try {
			if("".equals(id))
			{
				if(field.equals("name"))
				{
					queryString = "from TbPst as model where model.name= '"+value+"' and model.deptid = '"+par+"'";
				}
				else
				{
					queryString = "from TbPst as model where model.code= '"+value+"'";
				}
			}else
			{
				if(field.equals("name"))
				{
					queryString = "from TbPst as model where model.name= '"+value+"' and id != '"+id+"' and model.deptid = '"+par+"'";
				}
				else
				{
					queryString = "from TbPst as model where model.code= '"+value+"' and id != '"+id+"'";
				}
			}
			List list =getHibernateTemplate().find(queryString);
			System.out.println("---------list-------"+list.size());
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

}