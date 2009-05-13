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

import com.baosight.base.dao.TbSwrxDAO;
import com.baosight.mode.TbSwrx;

/**
 * Data access object (DAO) for domain model class TbSwrx.
 * 
 * @see com.baosight.mode.TbSwrx
 * @author MyEclipse Persistence Tools
 */

public class TbSwrxDAOImpl extends HibernateDaoSupport implements TbSwrxDAO {
	private static final Log log = LogFactory.getLog(TbSwrxDAOImpl.class);

	// property constants
	public static final String SWRXNO = "swrxno";

	public static final String ACCEPTEDUNITS = "acceptedunits";

	public static final String TRACKNUM = "tracknum";

	public static final String RETURNVISITNUM = "returnvisitnum";

	public static final String STATEMENTSMARK = "statementsmark";

	public static final String TRACKINGTAGS = "trackingtags";

	public static final String CQCFBX = "cqcfbx";

	public static final String STATIONTOMARK = "stationtomark";

	public static final String LOGONSTATION = "logonstation";

	public static final String REFLECTPEOPLE = "reflectpeople";

	public static final String CUSTOMERNO = "customerno";

	public static final String REFLECTUNIT = "reflectunit";

	public static final String REFLECTPHONE = "reflectphone";

	public static final String REFLECTDISTRICT = "reflectdistrict";

	public static final String ADDRESSHAPPEN = "addresshappen";

	public static final String REFLECTTYPE = "reflecttype";

	public static final String REFLECTCONTENT = "reflectcontent";

	public static final String CLJB = "cljb";

	public static final String REFLECTFORMS = "reflectforms";

	public static final String REFLECTSOUR = "reflectsour";

	public static final String ACCEPTEDREMARKS = "acceptedremarks";

	public static final String REMARKLOGONUSER = "remarklogonuser";

	public static final String DEALPOPLE = "dealpople";

	public static final String DEALTYPE = "dealtype";

	public static final String DEALCONTENT = "dealcontent";

	public static final String CAUSE = "cause";

	public static final String SOLUTIONS = "solutions";

	public static final String DEALRESULT = "dealresult";

	public static final String DEALISTIMELY = "dealistimely";

	public static final String DEALREMARKS = "dealremarks";

	public static final String REPEATSIGNS = "repeatsigns";

	public static final String REPEATRECORDS = "repeatrecords";

	public static final String DEALLOGONUSER = "deallogonuser";

	public static final String TRACKINGPROGRAM = "trackingprogram";

	public static final String MOBILEPHONE = "mobilephone";

	public static final String EMAIL = "email";

	public static final String REFLECTINDUSTRY = "reflectindustry";

	public static final String SELLITEMSISTIMELY = "sellitemsistimely";

	public static final String TASKNO = "taskno";

	public static final String REPLYORNOT = "replyornot";

	public static final String VERIFYLOGONUSER = "verifylogonuser";

	public static final String VERIFYPEOPLE = "verifypeople";

	public static final String VERIFYREMARKS = "verifyremarks";

	public static final String VERIFYTIMELYRATE = "verifytimelyrate";

	public static final String ISREVIEW = "isreview";

	public static final String ACCEPTEDSTATUS = "acceptedstatus";

	public static final String REPLYLOGONUSER = "replylogonuser";

	public static final String REPLYFORMS = "replyforms";

	public static final String REPLYREMARKS = "replyremarks";

	public static final String VERIFYRESULT = "verifyresult";

	public static final String NO12319 = "no12319";

	public static final String OLDSYSTEMNO = "oldsystemno";

	public static final String STATUS12319 = "status12319";

	protected void initDao() {
		// do nothing
	}

	public void save(TbSwrx transientInstance) {
		log.debug("saving TbSwrx instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbSwrx persistentInstance) {
		log.debug("deleting TbSwrx instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbSwrx findById(java.lang.Long id) {
		log.debug("getting TbSwrx instance with id: " + id);
		try {
			TbSwrx instance = (TbSwrx) getHibernateTemplate().get(
					"com.baosight.mode.TbSwrx", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbSwrx instance) {
		log.debug("finding TbSwrx instance by example");
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
		log.debug("finding TbSwrx instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbSwrx as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySwrxno(Object swrxno) {
		return findByProperty(SWRXNO, swrxno);
	}

	public List findByAcceptedunits(Object acceptedunits) {
		return findByProperty(ACCEPTEDUNITS, acceptedunits);
	}

	public List findByTracknum(Object tracknum) {
		return findByProperty(TRACKNUM, tracknum);
	}

	public List findByReturnvisitnum(Object returnvisitnum) {
		return findByProperty(RETURNVISITNUM, returnvisitnum);
	}

	public List findByStatementsmark(Object statementsmark) {
		return findByProperty(STATEMENTSMARK, statementsmark);
	}

	public List findByTrackingtags(Object trackingtags) {
		return findByProperty(TRACKINGTAGS, trackingtags);
	}

	public List findByCqcfbx(Object cqcfbx) {
		return findByProperty(CQCFBX, cqcfbx);
	}

	public List findByStationtomark(Object stationtomark) {
		return findByProperty(STATIONTOMARK, stationtomark);
	}

	public List findByLogonstation(Object logonstation) {
		return findByProperty(LOGONSTATION, logonstation);
	}

	public List findByReflectpeople(Object reflectpeople) {
		return findByProperty(REFLECTPEOPLE, reflectpeople);
	}

	public List findByCustomerno(Object customerno) {
		return findByProperty(CUSTOMERNO, customerno);
	}

	public List findByReflectunit(Object reflectunit) {
		return findByProperty(REFLECTUNIT, reflectunit);
	}

	public List findByReflectphone(Object reflectphone) {
		return findByProperty(REFLECTPHONE, reflectphone);
	}

	public List findByReflectdistrict(Object reflectdistrict) {
		return findByProperty(REFLECTDISTRICT, reflectdistrict);
	}

	public List findByAddresshappen(Object addresshappen) {
		return findByProperty(ADDRESSHAPPEN, addresshappen);
	}

	public List findByReflecttype(Object reflecttype) {
		return findByProperty(REFLECTTYPE, reflecttype);
	}

	public List findByReflectcontent(Object reflectcontent) {
		return findByProperty(REFLECTCONTENT, reflectcontent);
	}

	public List findByCljb(Object cljb) {
		return findByProperty(CLJB, cljb);
	}

	public List findByReflectforms(Object reflectforms) {
		return findByProperty(REFLECTFORMS, reflectforms);
	}

	public List findByReflectsour(Object reflectsour) {
		return findByProperty(REFLECTSOUR, reflectsour);
	}

	public List findByAcceptedremarks(Object acceptedremarks) {
		return findByProperty(ACCEPTEDREMARKS, acceptedremarks);
	}

	public List findByRemarklogonuser(Object remarklogonuser) {
		return findByProperty(REMARKLOGONUSER, remarklogonuser);
	}

	public List findByDealpople(Object dealpople) {
		return findByProperty(DEALPOPLE, dealpople);
	}

	public List findByDealtype(Object dealtype) {
		return findByProperty(DEALTYPE, dealtype);
	}

	public List findByDealcontent(Object dealcontent) {
		return findByProperty(DEALCONTENT, dealcontent);
	}

	public List findByCause(Object cause) {
		return findByProperty(CAUSE, cause);
	}

	public List findBySolutions(Object solutions) {
		return findByProperty(SOLUTIONS, solutions);
	}

	public List findByDealresult(Object dealresult) {
		return findByProperty(DEALRESULT, dealresult);
	}

	public List findByDealistimely(Object dealistimely) {
		return findByProperty(DEALISTIMELY, dealistimely);
	}

	public List findByDealremarks(Object dealremarks) {
		return findByProperty(DEALREMARKS, dealremarks);
	}

	public List findByRepeatsigns(Object repeatsigns) {
		return findByProperty(REPEATSIGNS, repeatsigns);
	}

	public List findByRepeatrecords(Object repeatrecords) {
		return findByProperty(REPEATRECORDS, repeatrecords);
	}

	public List findByDeallogonuser(Object deallogonuser) {
		return findByProperty(DEALLOGONUSER, deallogonuser);
	}

	public List findByTrackingprogram(Object trackingprogram) {
		return findByProperty(TRACKINGPROGRAM, trackingprogram);
	}

	public List findByMobilephone(Object mobilephone) {
		return findByProperty(MOBILEPHONE, mobilephone);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByReflectindustry(Object reflectindustry) {
		return findByProperty(REFLECTINDUSTRY, reflectindustry);
	}

	public List findBySellitemsistimely(Object sellitemsistimely) {
		return findByProperty(SELLITEMSISTIMELY, sellitemsistimely);
	}

	public List findByTaskno(Object taskno) {
		return findByProperty(TASKNO, taskno);
	}

	public List findByReplyornot(Object replyornot) {
		return findByProperty(REPLYORNOT, replyornot);
	}

	public List findByVerifylogonuser(Object verifylogonuser) {
		return findByProperty(VERIFYLOGONUSER, verifylogonuser);
	}

	public List findByVerifypeople(Object verifypeople) {
		return findByProperty(VERIFYPEOPLE, verifypeople);
	}

	public List findByVerifyremarks(Object verifyremarks) {
		return findByProperty(VERIFYREMARKS, verifyremarks);
	}

	public List findByVerifytimelyrate(Object verifytimelyrate) {
		return findByProperty(VERIFYTIMELYRATE, verifytimelyrate);
	}

	public List findByIsreview(Object isreview) {
		return findByProperty(ISREVIEW, isreview);
	}

	public List findByAcceptedstatus(Object acceptedstatus) {
		return findByProperty(ACCEPTEDSTATUS, acceptedstatus);
	}

	public List findByReplylogonuser(Object replylogonuser) {
		return findByProperty(REPLYLOGONUSER, replylogonuser);
	}

	public List findByReplyforms(Object replyforms) {
		return findByProperty(REPLYFORMS, replyforms);
	}

	public List findByReplyremarks(Object replyremarks) {
		return findByProperty(REPLYREMARKS, replyremarks);
	}

	public List findByVerifyresult(Object verifyresult) {
		return findByProperty(VERIFYRESULT, verifyresult);
	}

	public List findByNo12319(Object no12319) {
		return findByProperty(NO12319, no12319);
	}

	public List findByOldsystemno(Object oldsystemno) {
		return findByProperty(OLDSYSTEMNO, oldsystemno);
	}

	public List findByStatus12319(Object status12319) {
		return findByProperty(STATUS12319, status12319);
	}

	public List findAll() {
		log.debug("finding all TbSwrx instances");
		try {
			String queryString = "from TbSwrx";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbSwrx merge(TbSwrx detachedInstance) {
		log.debug("merging TbSwrx instance");
		try {
			TbSwrx result = (TbSwrx) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbSwrx instance) {
		log.debug("attaching dirty TbSwrx instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbSwrx instance) {
		log.debug("attaching clean TbSwrx instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbSwrxDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (TbSwrxDAOImpl) ctx.getBean("TbSwrxDAO");
	}

	public void update(TbSwrx transientInstance) {
		log.debug("updateing TbSwrx instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
		
	}
	public List findByHQL(final String hql) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createSQLQuery(hql);
				return query.list();
			}
		}, true);
	}

	public List findByIDStatus(String id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public TbSwrx findByID(Long id) {
		TbSwrx tbSwrx=(TbSwrx)getHibernateTemplate().get(
				"com.baosight.mode.TbSwrx", id);
		return tbSwrx;
	}

	public List findByNativeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}



}