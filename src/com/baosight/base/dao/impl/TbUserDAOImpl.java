package com.baosight.base.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbUserDAO;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

/**
 * Data access object (DAO) for domain model class TbUser.
 * 
 * @see com.baosight.mode.TbUser
 * @author MyEclipse Persistence Tools
 */

public class TbUserDAOImpl extends HibernateDaoSupport implements ITbUserDAO {
	private static final Log log = LogFactory.getLog(TbUserDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String NAME = "name";

	public static final String SEX = "sex";

	public static final String USER_ACC = "userAcc";

	public static final String PWD = "pwd";

	public static final String DEPT_CODE = "deptCode";

	public static final String LVL = "lvl";

	public static final String TEL = "tel";

	public static final String PST = "pst";

	public static final String DEF_ORDER = "defOrder";
	
	public static final String INSURE = "insure";
	
	public static final String CA = "ca";
	
	public static final String CAPASS = "capass";
	
	public static final String USERDEPT = "userdept";
	

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#save(com.baosight.mode.TbUser)
	 */
	public void save(TbUser transientInstance) {
		log.debug("saving TbUser instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#delete(com.baosight.mode.TbUser)
	 */
	public void delete(TbUser persistentInstance) {
		log.debug("deleting TbUser instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findById(java.lang.String)
	 */
	public TbUser findById(java.lang.String id) {
		log.debug("getting TbUser instance with id: " + id);
		try {
			TbUser instance = (TbUser) getHibernateTemplate().get(
					"com.baosight.mode.TbUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByExample(com.baosight.mode.TbUser)
	 */
	public List findByExample(TbUser instance) {
		log.debug("finding TbUser instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUser as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findBySex(java.lang.Object)
	 */
	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByUserAcc(java.lang.Object)
	 */
	public List findByUserAcc(Object userAcc) {
		return findByProperty(USER_ACC, userAcc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByPwd(java.lang.Object)
	 */
	public List findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByDeptCode(java.lang.Object)
	 */
	public List findByDeptCode(Object deptCode) {
		return findByProperty(DEPT_CODE, deptCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByLvl(java.lang.Object)
	 */
	public List findByLvl(Object lvl) {
		return findByProperty(LVL, lvl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByTel(java.lang.Object)
	 */
	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByPst(java.lang.Object)
	 */
	public List findByPst(Object pst) {
		return findByProperty(PST, pst);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findByDefOrder(java.lang.Object)
	 */
	public List findByDefOrder(Object defOrder) {
		return findByProperty(DEF_ORDER, defOrder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbUser instances");
		try {
			String queryString = "from TbUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbUserDAO#merge(com.baosight.mode.TbUser)
	 */
	public TbUser merge(TbUser detachedInstance) {
		log.debug("merging TbUser instance");
		try {
			TbUser result = (TbUser) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#attachDirty(com.baosight.mode.TbUser)
	 */
	public void attachDirty(TbUser instance) {
		log.debug("attaching dirty TbUser instance");
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
	 * @see com.baosight.base.dao.impl.ITbUserDAO#attachClean(com.baosight.mode.TbUser)
	 */
	public void attachClean(TbUser instance) {
		log.debug("attaching clean TbUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * true
	 * -1-1
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
	public List find(HashMap hmcriteria, List condition,
			Projection[] projection, String order, String ranking, int start,
			int maxRs, boolean isShowAll,Class object) {
		Criteria criteria = getSession().createCriteria(object);
		// 添加连接查询的对象注册
		if (hmcriteria != null) {
			Iterator it = hmcriteria.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = (String) hmcriteria.get(key);
				criteria.createAlias(value, key);
			}
		}

		// 添加逻辑判断查询条件
		if (condition != null) {
			Iterator iterator = condition.iterator();

			while (iterator.hasNext()) {
				criteria.add((Criterion) iterator.next());
			}
		}

		// 添加统计查询条件
		if (projection != null) {
			for (int i = 0; i < projection.length; i++) {
				criteria.setProjection(projection[i]);
			}
		}

		// 设置排序
		if (order != null && !order.equals("")) {
			if (ranking.equals("desc")) {
				criteria.addOrder(Order.desc(order));
			}
			if (ranking.equals("asc")) {
				criteria.addOrder(Order.asc(order));
			}
		}

		if (!isShowAll) {
			// 设置起始记录
			criteria.setFirstResult(start);
			// 设置取数据的数量
			if (maxRs != 0) {
				criteria.setMaxResults(maxRs);
			}
		}

		List list = criteria.list();

		return list;
	}

	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public static ITbUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITbUserDAO) ctx.getBean("tbUserDAO");
	}

	public void update(TbUser item) {
		log.debug("modfying TbUser instance");
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
	public TbUser findByPDefOrder(String parentId,long defOrder,String type){
		log.debug("getting TbUser instance ");
		try {
			String hqlUp="from TbUser t where (t.deptCode=? or t.pst=?) and t.defOrder=" +
					"(select max(t1.defOrder) from TbUser t1 where (t1.deptCode=? or t1.pst=?) and t1.defOrder<?)";
			String hqlDown="from TbUser t where (t.deptCode=? or t.pst=?) and t.defOrder=" +
					"(select min(t1.defOrder) from TbUser t1 where (t1.deptCode=? or t1.pst=?) and t1.defOrder>?)";
			Object object[]={parentId,parentId,parentId,parentId,defOrder};
			List list = null;
			if(type.equals("up"))
				list = getHibernateTemplate().find(hqlUp,object);
			else
				list = getHibernateTemplate().find(hqlDown,object);
			if (!list.isEmpty()&&list.size()>0)
				return (TbUser)list.get(0);
			else
				return null;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public long findMaxDefOrder(String parentId){
		log.debug("getting TbUser max deforder ");
		try {
			String hql="from TbUser t where t.pst=? and " +
					"t.defOrder=(select max(t1.defOrder) from TbUser t1 where t1.pst=?)";
			Object object[]={parentId,parentId};
			List list = getHibernateTemplate().find(hql,object);
			return list.isEmpty()?0:((TbUser)list.get(0)).getDefOrder();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 找用户所在职位的部门ID
	 * @param parentId
	 * @return
	 */
	public String findDeptIdForUser(String parentId){
		log.debug("getting the deptid for user of TbPst");
		try {
			String hql="from TbPst t where t.id=?";
			Object object[]={parentId};
			List list = getHibernateTemplate().find(hql,object);
			return list.isEmpty()?null:((TbPst)list.get(0)).getDeptid();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 取部门或职务下的人员
	 * @param parentId
	 * @param type
	 * @return
	 */
	public List findAllUser(String parentId,String type){
		log.debug("getting TbUser instance ");
		try {
			String hqlDept="from TbUser t where t.deptCode=? and t.pst is null order by t.defOrder";
			String hqlPst="from TbUser t where t.pst=? and t.deptCode!=t.pst order by t.defOrder";
			Object object[]={parentId};
			List list = null;
			if(type.equals("dept"))
				list = getHibernateTemplate().find(hqlDept,object);
			else
				list = getHibernateTemplate().find(hqlPst,object);
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
//	人员
	public List checkName(Object id, Object value,String field) {
		log.debug("finding TbPst instance with property: name, value: " + value);
		String queryString ="";
		try {
			if("".equals(id))
			{

					queryString = "from TbUser as model where model.userAcc= '"+value+"'";


			}else
			{

					queryString = "from TbUser as model where model.userAcc= '"+value+"' and id != '"+id+"'";

			}
			List list =getHibernateTemplate().find(queryString);
			System.out.println("---------list-------"+list.size());
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCA(Object ca) {
		// TODO Auto-generated method stub
		return findByProperty(CA, ca);
	}

	public List findByCAPass(Object caPass) {
		// TODO Auto-generated method stub
		return findByProperty(CAPASS, caPass);
	}

	public List findByInsure(Object insure) {
		// TODO Auto-generated method stub
		return findByProperty(INSURE, insure);
	}

	public List findByUserDept(Object userDept) {
		// TODO Auto-generated method stub
		return findByProperty(USERDEPT, userDept);
	}
	/**
	 * 根据用户名查询用户
	 */
	public TbUser findUserByName(String name){
		String queryString = "from TbUser as model where model.name= '"+name+"'";
		
		return (TbUser)getHibernateTemplate().find(queryString).get(0);
	}
	public int insertSql(String Insert_SQL)
	{
		
		final String Insert_SQL1=Insert_SQL;
		return (Integer)getHibernateTemplate().execute(new HibernateCallback() {
		public Object doInHibernate(Session session) throws HibernateException {
			Transaction tran=null;
			
			Connection CurConn=null;
			PreparedStatement ps=null;
			int insertint;
			boolean flag=true;
			try 
			{

			    CurConn   = getSession().connection();
				ps = CurConn.prepareStatement(Insert_SQL1);
			    //执行查询
				flag=ps.execute();
			    //关闭该对象
			    ps.close();
			    getSession().flush();
			   
			}catch (SQLException e) {
				//e.printStackTrace();
			}finally
			{
				try {
				    ps.close();
				    getSession().flush();
					CurConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
	}
	});
	}
	public List getUserNameAndId(String deptCode){
		String hql = "select u.id,u.name from TbUser u where u.deptCode='"+deptCode+"'";
		System.out.println("hql========"+hql);
		return findByHQL(hql, true, -1, -1);
	}

	public List findBySql(String sql,String id,Class entity) {
		Query query = getSession().createSQLQuery(sql).addEntity(id,entity);
		return query.list();
	}
}