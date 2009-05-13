package com.baosight.tech.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.baosight.base.dao.impl.DAOHelperImpl;
import com.baosight.tech.dao.ITbTechDiscoureDAO;
import com.baosight.tech.mode.TbTechDiscoure;

/**
 * Data access object (DAO) for domain model class TbTechDiscoure.
 * 
 * @see com.baosight.tech.dao.TbTechDiscoure
 * @author MyEclipse Persistence Tools
 */

public class TbTechDiscoureDAOImpl extends DAOHelperImpl implements ITbTechDiscoureDAO {
	private static final Log log = LogFactory.getLog(TbTechDiscoureDAOImpl.class);

	// property constants
	public static final String PIANMING = "pianming";

	public static final String ZUOZHE1 = "zuozhe1";

	public static final String ZUOZHE2 = "zuozhe2";

	public static final String ZUOZHE3 = "zuozhe3";

	public static final String DANWEI = "danwei";

	public static final String KANMING = "kanming";

	public static final String QIHAO = "qihao";

	public static final String GUANJIANCI = "guanjianci";

	public static final String ZHAIYAO = "zhaiyao";

	public static final String ZHENGWEN = "zhengwen";

	public static final String A1 = "a1";

	public static final String A2 = "a2";

	public static final String A3 = "a3";

	public static final String A4 = "a4";

	public static final String A5 = "a5";

	protected void initDao() {
		// do nothing
	}

	public void save(TbTechDiscoure transientInstance) {
		log.debug("saving TbTechDiscoure instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTechDiscoure persistentInstance) {
		log.debug("deleting TbTechDiscoure instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTechDiscoure findById(java.lang.String id) {
		log.debug("getting TbTechDiscoure instance with id: " + id);
		try {
			TbTechDiscoure instance = (TbTechDiscoure) getHibernateTemplate()
					.get("com.baosight.tech.mode.TbTechDiscoure", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTechDiscoure instance) {
		log.debug("finding TbTechDiscoure instance by example");
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
		log.debug("finding TbTechDiscoure instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTechDiscoure as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPianming(Object pianming) {
		return findByProperty(PIANMING, pianming);
	}

	public List findByZuozhe1(Object zuozhe1) {
		return findByProperty(ZUOZHE1, zuozhe1);
	}

	public List findByZuozhe2(Object zuozhe2) {
		return findByProperty(ZUOZHE2, zuozhe2);
	}

	public List findByZuozhe3(Object zuozhe3) {
		return findByProperty(ZUOZHE3, zuozhe3);
	}

	public List findByDanwei(Object danwei) {
		return findByProperty(DANWEI, danwei);
	}

	public List findByKanming(Object kanming) {
		return findByProperty(KANMING, kanming);
	}

	public List findByQihao(Object qihao) {
		return findByProperty(QIHAO, qihao);
	}

	public List findByGuanjianci(Object guanjianci) {
		return findByProperty(GUANJIANCI, guanjianci);
	}

	public List findByZhaiyao(Object zhaiyao) {
		return findByProperty(ZHAIYAO, zhaiyao);
	}

	public List findByZhengwen(Object zhengwen) {
		return findByProperty(ZHENGWEN, zhengwen);
	}

	public List findByA1(Object a1) {
		return findByProperty(A1, a1);
	}

	public List findByA2(Object a2) {
		return findByProperty(A2, a2);
	}

	public List findByA3(Object a3) {
		return findByProperty(A3, a3);
	}

	public List findByA4(Object a4) {
		return findByProperty(A4, a4);
	}

	public List findByA5(Object a5) {
		return findByProperty(A5, a5);
	}

	public List findAll() {
		log.debug("finding all TbTechDiscoure instances");
		try {
			String queryString = "from TbTechDiscoure";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTechDiscoure merge(TbTechDiscoure detachedInstance) {
		log.debug("merging TbTechDiscoure instance");
		try {
			TbTechDiscoure result = (TbTechDiscoure) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTechDiscoure instance) {
		log.debug("attaching dirty TbTechDiscoure instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTechDiscoure instance) {
		log.debug("attaching clean TbTechDiscoure instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITbTechDiscoureDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ITbTechDiscoureDAO) ctx.getBean("TbTechDiscoureDAO");
	}
}