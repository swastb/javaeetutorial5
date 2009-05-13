package com.baosight.base.dao.impl;

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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbFunctionDAO;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserAppsys;

/**
 * Data access object (DAO) for domain model class TbFunction.
 * 
 * @see com.baosight.base.dao.impl.TbFunction
 * @author MyEclipse Persistence Tools
 */

public class TbFunctionDAOImpl extends HibernateDaoSupport implements
		ITbFunctionDAO {
	private static final Log log = LogFactory.getLog(TbFunctionDAOImpl.class);

	private String queryCacheRegion = null;

	// property constants
	public static final String NAME = "name";

	public static final String FUN_KEY = "funKey";

	public static final String SYS_ID = "sysId";

	public static final String PAR_ID = "parId";

	public static final String INUSE = "inuse";

	public static final String DEFORDER = "deforder";

	public static final String NODETYPE = "nodetype";
	
	public static final String RIGHTTYPEID	 = "righttypeid";
	
	public static final String URL = "url";
	
	public static final String DEFOR = "defor";
	
	private static final String PERSONALIZEDSETTINGS = "PersonalizedSettings";
	private static final String PERSONALIZED = "Personalized";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#save(com.baosight.mode.TbFunction)
	 */
	public void save(TbFunction transientInstance) {
		log.debug("saving TbFunction instance");
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
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#delete(com.baosight.mode.TbFunction)
	 */
	public void delete(TbFunction persistentInstance) {
		log.debug("deleting TbFunction instance");
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
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findById(java.lang.String)
	 */
	public TbFunction findById(java.lang.String id) {
		log.debug("getting TbFunction instance with id: " + id);
		try {
			TbFunction instance = (TbFunction) getHibernateTemplate().get(
					"com.baosight.mode.TbFunction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByExample(com.baosight.mode.TbFunction)
	 */
	public List findByExample(TbFunction instance) {
		log.debug("finding TbFunction instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByProperty(java.lang.String,
	 *      java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbFunction instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbFunction as model where model."
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
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByFunKey(java.lang.Object)
	 */
	public List findByFunKey(Object funKey) {
		return findByProperty(FUN_KEY, funKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findBySysId(java.lang.Object)
	 */
	public List findBySysId(Object sysId) {
		return findByProperty(SYS_ID, sysId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByParId(java.lang.Object)
	 */
	public List findByParId(Object parId) {
		return findByProperty(PAR_ID, parId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByInuse(java.lang.Object)
	 */
	public List findByInuse(Object inuse) {
		return findByProperty(INUSE, inuse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByDeforder(java.lang.Object)
	 */
	public List findByDeforder(Object deforder) {
		return findByProperty(DEFORDER, deforder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findByNodetype(java.lang.Object)
	 */
	public List findByNodetype(Object nodetype) {
		return findByProperty(NODETYPE, nodetype);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbFunction instances");
		try {
			String queryString = "from TbFunction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#merge(com.baosight.mode.TbFunction)
	 */
	public TbFunction merge(TbFunction detachedInstance) {
		log.debug("merging TbFunction instance");
		try {
			TbFunction result = (TbFunction) getHibernateTemplate().merge(
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
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#attachDirty(com.baosight.mode.TbFunction)
	 */
	public void attachDirty(TbFunction instance) {
		log.debug("attaching dirty TbFunction instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			System.out.println("yeyyeyee");
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baosight.base.dao.impl.ITbFunctionDAO#attachClean(com.baosight.mode.TbFunction)
	 */
	public void attachClean(TbFunction instance) {
		log.debug("attaching clean TbFunction instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
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

	public List find(HashMap hmcriteria, List condition,
			Projection[] projection, String order, String ranking, int start,
			int maxRs, boolean isShowAll, Class object) {
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

	public static ITbFunctionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbFunctionDAO) ctx.getBean("tbFunctionDAO");
	}
	
	//职务
	public List checkName(Object id, Object value,Object fid,String field) {
		log.debug("finding TbFunction instance with property: name, value: " + value);
		System.out.println("------id--------"+id);
		System.out.println("------fid--------"+fid);
		System.out.println("------value--------"+value);
		String queryString ="";
		try {
			if("".equals(id))
			{
				if("".equals(fid)){
					queryString = "from TbFunction as model where model.funKey= '"+value+"'";
				}
				else{
					queryString = "from TbFunction as model where model.funKey= '"+value+"' and model.parId='"+fid+"'";
				}
			}else{
				if("".equals(fid)){
					queryString = "from TbFunction as model where model.funKey= '"+value+"' and id != '"+id+"'";
				}
				else
			{
	
					queryString = "from TbFunction as model where model.funKey= '"+value+"' and id != '"+id+"'and model.parId='"+fid+"'";

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

	public List findByDefor(Object defor) {
		// TODO Auto-generated method stub
		return findByProperty(DEFOR, defor);
	}

	public List findByRighttypeid(Object righttypeid) {
		// TODO Auto-generated method stub
		return findByProperty(RIGHTTYPEID, righttypeid);
	}

	public List findByUrl(Object url) {
		// TODO Auto-generated method stub
		return findByProperty(URL, url);
	}
	/*cheng begin*/
	/*根据新设置的顺位来改变其他的资源顺位*/
	public void setOthersDefordByNewdeford(TbFunction tbFunction,String newDeforder,String parid,String type){
		String queryString = "";
		if (!"".equals(newDeforder) && newDeforder!=null) {
		if (!type.equals("update"))
			queryString = "from TbFunction model where model.defor>= '"+Integer.parseInt(newDeforder)+"' and model.parId='"+parid+"'";
		else
		{
			int neworder=Integer.parseInt(newDeforder.split(",")[0]);
			int deforder=Integer.parseInt(newDeforder.split(",")[1]);
			if(neworder<deforder)
				queryString = "from TbFunction t where t.defor>= '"+neworder+"' and t.defor< '"+deforder+"' and t.parId='"+parid+"'";
			else if(neworder>deforder)
				queryString = "from TbFunction t where t.defor<= '"+neworder+"' and t.defor> '"+deforder+"' and t.parId='"+parid+"'";
			else
				queryString = "from TbFunction t where t.defor<>t.defor and t.parId='"+parid+"'";
		}
		List list =getHibernateTemplate().find(queryString);

		if(type.equals("save")){
			if(!list.isEmpty()&&list.size()>0){
			for (int i=0;i<list.size();i++){
				TbFunction tbfun = new TbFunction();
				tbfun = (TbFunction)list.get(i);
				tbfun.setDefor((Integer.parseInt(tbfun.getDefor())+1)+"");
				this.attachDirty(tbfun);
			}
			}
			save(tbFunction);
		}
		else if((!list.isEmpty()&&list.size()>0)&&type.equals("delete")){
			for (int i=0;i<list.size();i++){
				TbFunction tbfun = new TbFunction();
				tbfun = (TbFunction)list.get(i);
				tbfun.setDefor((Integer.parseInt(tbfun.getDefor())-1)+"");
				this.attachDirty(tbfun);
			}
		}
		else if(type.equals("update")){
			if(!list.isEmpty()&&list.size()>0){
			for (int i=0;i<list.size();i++){
				TbFunction tbfun = new TbFunction();
				tbfun = (TbFunction)list.get(i);
				if (Integer.parseInt(newDeforder.split(",")[0])>Integer.parseInt(newDeforder.split(",")[1])){
					tbfun.setDefor((Integer.parseInt(tbfun.getDefor())-1)+"");//2-4
				}
				else{
					tbfun.setDefor((Integer.parseInt(tbfun.getDefor())+1)+"");//4-2
				}
				this.attachDirty(tbfun);
				}
			}
			tbFunction.setDefor(Integer.parseInt(newDeforder.split(",")[0])+"");
			this.attachDirty(tbFunction);
		}
	 }
		else {
			if (!type.equals("delete"))
			this.attachDirty(tbFunction);
		}
			
	}
	/*找统一门户第一层资源*/
	public List findFirstLevelRes(TbUser user){
		log.debug("find TbFunctions instance");
		try {
			String queryString = "from TbFunction t2 where t2.parId =(" +
					"select t1.id from TbFunction t1 " +
					"where t1.sysId=(select t.id from TbAppsys t where t.code='10') " +
					"and t1.parId is null) order by t2.defor asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}
	/*找统一门户第二层资源*/
	public List findSecondLevelRes(TbUser user,TbFunction tbFunction){
		log.debug("find TbFunctions instance");
		try {
			String queryString="from TbFunction t3 where exists(" +
				"select t2.funid from TbAuthInfo t2 where exists(" +
				"select distinct t1.authid from TbRoleAuth t1 where exists (" +
				"select  distinct t.roleid from TbUserRole t where t.userid='"+user.getId()+"' and t1.roleid=t.roleid) " +
				"and t2.id=t1.authid) and t3.id=t2.funid) and t3.parId='"+tbFunction.getId()+"' order by t3.defor asc";
			String personalStr="from TbFunction t where exists(select t1.funid from TbUserAppsys t1 where t1.userid='"+user.getId()+"' and t.id=t1.funid) order by t.defor asc";
			if (!tbFunction.getFunKey().equals(PERSONALIZED))
				return getHibernateTemplate().find(queryString);
			else{
				List listone=getHibernateTemplate().find(queryString);
				List listtwo=getHibernateTemplate().find(personalStr);
				listone.addAll(listtwo);
				return listone;
				//return getHibernateTemplate().find(personalStr);
			}
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}
	/*个性化设置－取已经设置的资源*/
	public List findAllSetByUser(TbUser user){
		String personalStr="from TbFunction t where exists(select t1.funid from TbUserAppsys t1 " +
				"where t1.userid='"+user.getId()+"' and t.id=t1.funid) and t.funKey<>'"+PERSONALIZEDSETTINGS+"'";
		return getHibernateTemplate().find(personalStr);
	}
	/*个性化设置－取所有的资源*/
	public List findAllRes(TbUser user){
		String queryString="from TbFunction t3 where exists(" +
		"select t2.funid from TbAuthInfo t2 where exists(" +
		"select distinct t1.authid from TbRoleAuth t1 where exists (" +
		"select  distinct t.roleid from TbUserRole t where t.userid='"+user.getId()+"' and t1.roleid=t.roleid) " +
		"and t2.id=t1.authid) and t3.id=t2.funid) and t3.funKey<>'"+PERSONALIZEDSETTINGS+"' and t3.sysId=(select t4.id from TbAppsys t4 where t4.code='10')";
		return getHibernateTemplate().find(queryString);
	}
	/*保存资源设置*/
	public List saveResSet(TbUser user,String[] resIds,String sysId){
		log.debug("saving seted TbUserAppsys instances");
		try {
			List allSetRes = this.findAllTbUserAppsys(user);
			if(allSetRes!=null && !allSetRes.isEmpty())
				this.deleteTbUserAppsys(allSetRes);
			
			if (resIds!=null){
				for(String id:resIds){
					TbUserAppsys tbUserAppSys = new TbUserAppsys();
					tbUserAppSys.setUserid(user.getId());
					tbUserAppSys.setAppid(sysId);
					tbUserAppSys.setFunid(id);
					this.savaTbUserAppsys(tbUserAppSys);
				}
			}
			return this.findAllSetByUser(user);
		} catch (RuntimeException re) {
			log.error("save all failed", re);
			throw re;
		}
	}
	public List findAllTbUserAppsys(TbUser user){
		log.debug("finding seted TbAppsys instances");
		try {
			String queryString = "from TbUserAppsys t where t.userid='"+user.getId()+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void deleteTbUserAppsys(List allSetAppSys){
		log.debug("deleting TbUserAppsys instance");
		try {
				for(int i=0;i<allSetAppSys.size();i++)
				getHibernateTemplate().delete((TbUserAppsys)allSetAppSys.get(i));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void savaTbUserAppsys(TbUserAppsys tbUserAppSys){
		log.debug("saving tbUserAppSys instance");
		try {
			getHibernateTemplate().save(tbUserAppSys);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/*cheng end*/
}