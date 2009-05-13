package com.baosight.base.dao.impl;

import java.io.Serializable;
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

import com.baosight.base.dao.ITbInfoPubClaDAO;
import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbRoleCla;

/**
 * Data access object (DAO) for domain model class TbInfoPubCla.
 * 
 * @see com.baosight.mode.TbInfoPubCla
 * @author MyEclipse Persistence Tools
 */

public class TbInfoPubClaDAOImpl extends HibernateDaoSupport implements ITbInfoPubClaDAO {
	private static final Log log = LogFactory.getLog(TbInfoPubClaDAOImpl.class);

	// property constants
	private String queryCacheRegion = null;
	public static final String NAME = "name";

	public static final String CODE = "code";

	public static final String PARENTID = "parentid";

	public static final String DEF_ORDER = "defOrder";

	public static final String ONLY_TREE = "onlyTree";

	public static final String ENABLE = "enable";

	public static final String REM = "rem";

	public static final String ATTR1 = "attr1";

	public static final String ATTR2 = "attr2";

	public static final String ATTR3 = "attr3";

	public static final String ATTR4 = "attr4";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#save(com.baosight.mode.TbInfoPubCla)
	 */
	public Serializable save(TbInfoPubCla transientInstance) {
		log.debug("saving TbInfoPubCla instance");
		try {
			Serializable id= getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			return id;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#delete(com.baosight.mode.TbInfoPubCla)
	 */
	public void delete(TbInfoPubCla persistentInstance) {
		log.debug("deleting TbInfoPubCla instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findById(java.lang.String)
	 */
	public TbInfoPubCla findById(java.lang.String id) {
		log.debug("getting TbInfoPubCla instance with id: " + id);
		try {
			TbInfoPubCla instance = (TbInfoPubCla) getHibernateTemplate().get(
					"com.baosight.mode.TbInfoPubCla", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByExample(com.baosight.mode.TbInfoPubCla)
	 */
	public List findByExample(TbInfoPubCla instance) {
		log.debug("finding TbInfoPubCla instance by example");
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
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbInfoPubCla instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbInfoPubCla as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByParentid(java.lang.Object)
	 */
	public List findByParentid(Object parentid) {
		return findByProperty(PARENTID, parentid);
	}
	public List findByParentIdOrder(Object parentid) {
		log.debug("finding TbInfoPubCla instance with parentid");
		try {
			String queryString = "from TbInfoPubCla as model where model.parentid ='"+(String)parentid+"' "
					+" order by model.defOrder asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByDefOrder(java.lang.Object)
	 */
	public List findByDefOrder(Object defOrder) {
		return findByProperty(DEF_ORDER, defOrder);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByOnlyTree(java.lang.Object)
	 */
	public List findByOnlyTree(Object onlyTree) {
		return findByProperty(ONLY_TREE, onlyTree);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByEnable(java.lang.Object)
	 */
	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByRem(java.lang.Object)
	 */
	public List findByRem(Object rem) {
		return findByProperty(REM, rem);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByAttr1(java.lang.Object)
	 */
	public List findByAttr1(Object attr1) {
		return findByProperty(ATTR1, attr1);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByAttr2(java.lang.Object)
	 */
	public List findByAttr2(Object attr2) {
		return findByProperty(ATTR2, attr2);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByAttr3(java.lang.Object)
	 */
	public List findByAttr3(Object attr3) {
		return findByProperty(ATTR3, attr3);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findByAttr4(java.lang.Object)
	 */
	public List findByAttr4(Object attr4) {
		return findByProperty(ATTR4, attr4);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TbInfoPubCla instances");
		try {
			String queryString = "from TbInfoPubCla";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#merge(com.baosight.mode.TbInfoPubCla)
	 */
	public TbInfoPubCla merge(TbInfoPubCla detachedInstance) {
		log.debug("merging TbInfoPubCla instance");
		try {
			TbInfoPubCla result = (TbInfoPubCla) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#attachDirty(com.baosight.mode.TbInfoPubCla)
	 */
	public void attachDirty(TbInfoPubCla instance) {
		log.debug("attaching dirty TbInfoPubCla instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#attachClean(com.baosight.mode.TbInfoPubCla)
	 */
	public void attachClean(TbInfoPubCla instance) {
		log.debug("attaching clean TbInfoPubCla instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.ITbInfoPubClaDAO#update(com.baosight.mode.TbInfoPubCla)
	 */
	public void update(TbInfoPubCla instance) {
		log.debug("updating TbInfoPubCla instance");
		try {
			getHibernateTemplate().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public static ITbInfoPubClaDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbInfoPubClaDAO) ctx.getBean("TbInfoPubClaDAO");
	}
	
	public List findEnableIsTure(String type) {
		log.debug("finding TbInfoPubCla instance with property:enable: ");
		
		String queryString ="";
		try {
			queryString="from TbInfoPubCla as t " + 
			"where t.enable = '1' and t.attr1 = '"+type+"' order by t.createTime,t.defOrder desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	
	public List findParentID_EnableIsTure(String parentid) {
		log.debug("finding TbInfoPubCla instance with property:enable: ");
		
		String queryString ="";
		try {
			queryString="from TbInfoPubCla as t " + 
			" where t.parentid = '" +
			parentid +
			"' and t.enable = '1' order by t.defOrder asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	
	public List getChildren(String parentid,String[] roleForCla) {
		log.debug("finding TbInfoPubCla instance with property:enable: ");
		String roleStr="'00'"+",";
		for (int i=0;roleForCla.length>0&&i<roleForCla.length;i++)
			roleStr+="'"+roleForCla[i]+"'"+',';
		if (!"".equals(roleStr))
			roleStr=roleStr.substring(0,roleStr.lastIndexOf(','));
		String queryString ="";
		try {
			queryString="from TbInfoPubCla as t  where  exists" +
					" (select t1.claId from TbRoleCla t1 where t1.roleId in ("+roleStr+")" +
					" and t.id=t1.claId) and t.parentid = '" + parentid +"' and t.enable = '1' "+
					"order by t.defOrder asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
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
	
	/**
	 * 取deforder的最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public long findMaxDefOrder(String parentId) {
		log.debug("getting maxDeforder from dept instance ");
		try {
			String hql = "from TbInfoPubCla t where t.parentid=? and "
					+ "t.defOrder=(select max(t1.defOrder) from TbInfoPubCla t1 where t1.parentid=?)";
			
			Object object[] = { parentId, parentId };
			List list = null;
			
				list = getHibernateTemplate().find(hql,object);
				return list.isEmpty() ? 0 : ((TbInfoPubCla) list.get(0)).getDefOrder().longValue();

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	//取栏目对应的所有角色
	public List findRolesForCla() {
		log.debug("finding TbInfoPubCla instance with property:enable: ");
		String queryString ="";
		try {
			queryString="from TbRole role where exists (select roleauth.roleid from TbRoleAuth roleauth where exists " +
					"(select distinct authinfo.funid from TbAuthInfo authinfo where exists " +
					"(select function.id from TbFunction function where function.funKey='Information Publishing' " +
					"and authinfo.funid=function.id) and roleauth.authid=authinfo.id) and role.id= roleauth.roleid)";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	//取栏目对应的已选角色
	public List findRolesSeled(String claid) {
		String queryString ="";
		try {
			queryString="from TbRole role where exists (select roleauth.roleid from TbRoleAuth roleauth where exists" +
					" (select authinfo.funid from TbAuthInfo authinfo where exists " +
					" (select function.id from TbFunction function where function.funKey='Information Publishing'" +
					" and authinfo.funid=function.id) and roleauth.authid=authinfo.id) and role.id= roleauth.roleid)" +
					" and role.id in (select t1.roleId from TbRoleCla t1 where t1.claId='"+claid+"')";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	//取栏目对应未选角色
	public List findRolesUnSeled(String claid) {
		String queryString ="";
		try {
			queryString="from TbRole role where exists (select roleauth.roleid from TbRoleAuth roleauth where exists" +
					" (select authinfo.funid from TbAuthInfo authinfo where exists " +
					" (select function.id from TbFunction function where function.funKey='Information Publishing'" +
					" and authinfo.funid=function.id) and roleauth.authid=authinfo.id) and role.id= roleauth.roleid)" +
					" and role.id not in (select t1.roleId from TbRoleCla t1 where t1.claId='"+claid+"')";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	//删除为该栏目已经选择的角色
	public void deleteFromRoleCla(String claid,String[] roles) {
		String queryString ="";
		try {
			//2008-10-08 start
			StringBuffer roleIds = new StringBuffer("");
			for (int i=0;roles.length>0&&i<roles.length;i++)
				roleIds.append("'").append(roles[i]).append("',");
			String roleIdStr = roleIds.substring(0, roleIds.lastIndexOf(","));
			String sql = "delete from tb_role_cla rc where rc.role_id not in ("+roleIdStr+") and rc.cla_id in " +
						"(select ipc.id from Tb_Info_Pub_Cla ipc start with id='"+claid+"' connect by prior id=parentid)";
			Query query = getSession().createSQLQuery(sql);//createSQLQuery(sql);
			query.executeUpdate();
			//2008-10-08 end
			/*queryString="from TbRoleCla t1 where t1.claId='"+claid+"'";
			List list = getHibernateTemplate().find(queryString);
			if (!list.isEmpty()) {
				for (int i=0;i<list.size();i++)
					this.deleteFromRoleCla((TbRoleCla)list.get(i));
			}*/
				
		} catch (RuntimeException re) {
			log.error("find by property ename failed", re);
			throw re;
		}
	}
	//保存为栏目所分配的角色  
	public void saveRoleCla(TbRoleCla roleCla) {
		log.debug("saving TbRoleCla instance");
		try {
			getHibernateTemplate().save(roleCla);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void deleteFromRoleCla(TbRoleCla persistentInstance) {
		log.debug("deleting TbRoleForifnom instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
}