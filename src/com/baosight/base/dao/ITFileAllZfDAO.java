package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TFileAllZf;

public interface ITFileAllZfDAO {

	// property constants
	public static final String TITLE = "title";

	public static final String AUTHOR = "author";

	public static final String TYPEID = "typeid";

	public static final String FOLDERID = "folderid";

	public static final String PURVIEW = "purview";

	public static final String ISVALID = "isvalid";

	public static final String KEYWORD1 = "keyword1";

	public static final String KEYWORD2 = "keyword2";

	public static final String KEYWORD3 = "keyword3";

	public static final String KEYWORD4 = "keyword4";

	public static final String TEMP = "temp";

	public static final String HIT = "hit";

	public static final String INPUTUER = "inputuer";

	public static final String DEPTID = "deptid";

	public static final String INFOTYPE = "infotype";

	public static final String FILENUMBER = "filenumber";

	public static final String ISSUEDDEPT1 = "issueddept1";

	public static final String ISSUEDDEPT2 = "issueddept2";

	public static final String CARRIERTYPE = "carriertype";

	public static final String GETID = "getid";

	public static final String KEYWORD5 = "keyword5";

	public static final String LSH = "lsh";

	public static final String AUDITING = "auditing";

	public static final String REASON = "reason";

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#save(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract void save(TFileAllZf transientInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#delete(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract void delete(TFileAllZf persistentInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findById(java.lang.Long)
	 */
	public abstract TFileAllZf findById(java.lang.Long id);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByExample(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract List findByExample(TFileAllZf instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public abstract List findByProperty(String propertyName, Object value);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTitle(java.lang.Object)
	 */
	public abstract List findByTitle(Object title);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByAuthor(java.lang.Object)
	 */
	public abstract List findByAuthor(Object author);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTypeid(java.lang.Object)
	 */
	public abstract List findByTypeid(Object typeid);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByFolderid(java.lang.Object)
	 */
	public abstract List findByFolderid(Object folderid);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByPurview(java.lang.Object)
	 */
	public abstract List findByPurview(Object purview);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIsvalid(java.lang.Object)
	 */
	public abstract List findByIsvalid(Object isvalid);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword1(java.lang.Object)
	 */
	public abstract List findByKeyword1(Object keyword1);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword2(java.lang.Object)
	 */
	public abstract List findByKeyword2(Object keyword2);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword3(java.lang.Object)
	 */
	public abstract List findByKeyword3(Object keyword3);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword4(java.lang.Object)
	 */
	public abstract List findByKeyword4(Object keyword4);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByTemp(java.lang.Object)
	 */
	public abstract List findByTemp(Object temp);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByHit(java.lang.Object)
	 */
	public abstract List findByHit(Object hit);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByInputuer(java.lang.Object)
	 */
	public abstract List findByInputuer(Object inputuer);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByDeptid(java.lang.Object)
	 */
	public abstract List findByDeptid(Object deptid);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByInfotype(java.lang.Object)
	 */
	public abstract List findByInfotype(Object infotype);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByFilenumber(java.lang.Object)
	 */
	public abstract List findByFilenumber(Object filenumber);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIssueddept1(java.lang.Object)
	 */
	public abstract List findByIssueddept1(Object issueddept1);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByIssueddept2(java.lang.Object)
	 */
	public abstract List findByIssueddept2(Object issueddept2);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByCarriertype(java.lang.Object)
	 */
	public abstract List findByCarriertype(Object carriertype);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByGetid(java.lang.Object)
	 */
	public abstract List findByGetid(Object getid);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByKeyword5(java.lang.Object)
	 */
	public abstract List findByKeyword5(Object keyword5);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByLsh(java.lang.Object)
	 */
	public abstract List findByLsh(Object lsh);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByAuditing(java.lang.Object)
	 */
	public abstract List findByAuditing(Object auditing);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findByReason(java.lang.Object)
	 */
	public abstract List findByReason(Object reason);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#findAll()
	 */
	public abstract List findAll();

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#merge(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract TFileAllZf merge(TFileAllZf detachedInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#attachDirty(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract void attachDirty(TFileAllZf instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.ITFileAllZfDAO#attachClean(com.baosight.base.mode.TFileAllZf)
	 */
	public abstract void attachClean(TFileAllZf instance);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);

}