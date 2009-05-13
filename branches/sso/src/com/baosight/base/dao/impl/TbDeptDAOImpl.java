package com.baosight.base.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbDeptDAO;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

/**
 * Data access object (DAO) for domain model class TbDept.
 * 
 * @see com.baosight.mode.TbDept
 * @author MyEclipse Persistence Tools
 */

public class TbDeptDAOImpl extends HibernateDaoSupport implements ITbDeptDAO {
	private static final Log log = LogFactory.getLog(TbDeptDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String LVL = "lvl";

	public static final String PAR_CODE = "parCode";

	public static final String TEL = "tel";

	public static final String CTC = "ctc";

	public static final String REM = "rem";

	public static final String DEF_ORDER = "defOrder";

	public static final String USERDEPT = "userDept";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#save(com.baosight.mode.TbDept)
	 */
	public void save(TbDept transientInstance) {
		log.debug("saving TbDept instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#delete(com.baosight.mode.TbDept)
	 */
	public void delete(TbDept persistentInstance) {
		log.debug("deleting TbDept instance");
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
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findById(java.lang.String)
	 */
	public TbDept findById(java.lang.String id) {
		log.debug("getting TbDept instance with id: " + id);
		try {
			TbDept instance = (TbDept) getHibernateTemplate().get(
					"com.baosight.mode.TbDept", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByExample(com.baosight.mode.TbDept)
	 */
	public List findByExample(TbDept instance) {
		log.debug("finding TbDept instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbDept instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbDept as model where model."
					+ propertyName + "= ? order by model.defOrder";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByLvl(java.lang.Object)
	 */
	public List findByLvl(Object lvl) {
		return findByProperty(LVL, lvl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByParCode(java.lang.Object)
	 */
	public List findByParCode(Object parCode) {
		return findByProperty(PAR_CODE, parCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByTel(java.lang.Object)
	 */
	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByCtc(java.lang.Object)
	 */
	public List findByCtc(Object ctc) {
		return findByProperty(CTC, ctc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findByDefOrder(java.lang.Object)
	 */
	public List findByDefOrder(Object defOrder) {
		return findByProperty(DEF_ORDER, defOrder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbDept instances");
		try {
			String queryString = "from TbDept";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#merge(com.baosight.mode.TbDept)
	 */
	public TbDept merge(TbDept detachedInstance) {
		log.debug("merging TbDept instance");
		try {
			TbDept result = (TbDept) getHibernateTemplate().merge(
					detachedInstance);
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
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#attachDirty(com.baosight.mode.TbDept)
	 */
	public void attachDirty(TbDept instance) {
		log.debug("attaching dirty TbDept instance");
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
	 * @see com.baosight.base.dao.impl.ITbDeptDAO#attachClean(com.baosight.mode.TbDept)
	 */
	public void attachClean(TbDept instance) {
		log.debug("attaching clean TbDept instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static ITbDeptDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbDeptDAO) ctx.getBean("tbDeptDAO");
	}

	/**
	 * 编辑部门
	 */
	public void updateDept(TbDept item) {
		log.debug("modfying TbDept instance");
		try {
			getHibernateTemplate().update(item);
			log.debug("modify successful");
		} catch (RuntimeException re) {
			log.error("modify failed", re);
			throw re;
		}
	}

	/**
	 * 节点移动
	 * 
	 * @param parentId
	 * @param nodeId
	 * @param type
	 */
	public void upDownDDS(String parentId, String nodeId, String defOrder,
			String type) {
		log.debug("move TbDept instance");
		try {
			// getHibernateTemplate()
		} catch (RuntimeException re) {
			log.error("modify failed", re);
			throw re;
		}
	}

	public TbDept findByPDefOrder(String parentId, long defOrder, String type) {
		log.debug("getting TbDept instance ");
		try {
			String hqlUp = "from TbDept t where t.parCode=? and t.defOrder="
					+ "(select max(t1.defOrder) from TbDept t1 where t1.parCode=? and t1.defOrder<?)";
			String hqlDown = "from TbDept t where t.parCode=? and t.defOrder="
					+ "(select min(t1.defOrder) from TbDept t1 where t1.parCode=? and t1.defOrder>?)";
			Object object[] = { parentId, parentId, defOrder };
			List list = null;
			if (type.equals("up"))
				list = getHibernateTemplate().find(hqlUp, object);
			else
				list = getHibernateTemplate().find(hqlDown, object);
			if (!list.isEmpty()&&list.size()>0)
				 return (TbDept) list.get(0);
			else return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 取deforder的最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public long findMaxDefOrder(String parentId, String type) {
		log.debug("getting maxDeforder from dept instance ");
		try {
			String hqlDept = "from TbDept t where t.parCode=? and "
					+ "t.defOrder=(select max(t1.defOrder) from TbDept t1 where t1.parCode=?)";
			String hqlPost = "from TbPst t where t.deptid=? and "
					+ "t.defOrder=(select max(t1.defOrder) from TbPst t1 where t1.deptid=?)";
			String hqluser = "from TbUser t where (t.pst=? or t.deptCode=?) and "
					+ "t.defOrder=(select max(t1.defOrder) from TbUser t1 where t1.deptCode=? or t1.pst=?)";
			Object object[] = { parentId, parentId };
			List list = null;
			if (type.equals("dept")) {
				list = getHibernateTemplate().find(hqlDept, object);
				return list.isEmpty() ? 0 : ((TbDept) list.get(0))
						.getDefOrder();
			} else if (type.equals("post")) {
				list = getHibernateTemplate().find(hqlPost, object);
				return list.isEmpty() ? 0 : ((TbPst) list.get(0)).getDefOrder();
			} else {
				list = getHibernateTemplate()
						.find(
								hqluser,
								new Object[] { parentId, parentId, parentId,
										parentId });
				return list.isEmpty() ? 0 : ((TbUser) list.get(0))
						.getDefOrder();
			}

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
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

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	// 部门重复验证
	public List checkName(Object id, Object value, Object par, String field) {
		log.debug("finding TbDept instance with property: name, value: "
				+ value);
		System.out.println("------id--------" + id);
		System.out.println("------par--------" + par);
		System.out.println("------value--------" + value);
		String queryString = "";
		try {
			if ("".equals(id)) {
				if (field.equals("name")) {
					queryString = "from TbDept as model where model.name= '"
							+ value + "' and model.parCode = '" + par + "'";
				} else {
					queryString = "from TbDept as model where model.code= '"
							+ value + "'";
				}
			} else {
				if (field.equals("name")) {
					queryString = "from TbDept as model where model.name= '"
							+ value + "' and id != '" + id
							+ "' and model.parCode = '" + par + "'";
				} else {
					queryString = "from TbDept as model where model.code= '"
							+ value + "' and id != '" + id + "'";
				}
			}
			List list = getHibernateTemplate().find(queryString);
			System.out.println("---------list-------" + list.size());
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserDept(Object userDept) {
		// TODO Auto-generated method stub
		return findByProperty(USERDEPT, userDept);
	}
	public List getTwoDept(String deptId){
		String hql = "select t.name from TbDept t where t.id='"+deptId+"'";
//		String hql = "select d.name from TbDept d start with d.id='"+deptId+"'" +
//				" connect by prior d.parCode=d.id and d.lvl ='9f9083fe194fbea901194fc18da80006'";
		return this.findByHQL(hql, true, -1, -1);
	}

	public List findBySql(String sql,String id,Class entity) {
		Query query = getSession().createSQLQuery(sql).addEntity(id,entity);
		return query.list();
	}

}