package com.baosight.base.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>Decription:公用方法的一个实现</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-15</p>
 */
public abstract class DAOHelperImpl extends HibernateDaoSupport {

	public int exeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.executeUpdate();
	}

	public List findBySql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}

	public List findByHQL(final String hql, final boolean cacheable,
			final int startIndex, final int maxResultCount) {
		//System.out.println("@#$%^&*******begin dao****:");
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

	protected String queryCacheRegion = null;
	
	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

}
