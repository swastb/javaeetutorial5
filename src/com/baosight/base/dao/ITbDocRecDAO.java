package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocRec;

public interface ITbDocRecDAO extends DAOHelper {

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#save(com.baosight.mode.TbDocRec)
	 */
	public abstract void save(TbDocRec transientInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#delete(com.baosight.mode.TbDocRec)
	 */
	public abstract void delete(TbDocRec persistentInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findById(java.lang.String)
	 */
	public abstract TbDocRec findById(java.lang.String id);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByExample(com.baosight.mode.TbDocRec)
	 */
	public abstract List findByExample(TbDocRec instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByProperty(java.lang.String, java.lang.Object)
	 */
	public abstract List findByProperty(String propertyName, Object value);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByInfoLevel(java.lang.Object)
	 */
	public abstract List findByInfoLevel(Object infoLevel);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocDept(java.lang.Object)
	 */
	public abstract List findByDocDept(Object docDept);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocCode(java.lang.Object)
	 */
	public abstract List findByDocCode(Object docCode);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocNum(java.lang.Object)
	 */
	public abstract List findByDocNum(Object docNum);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocType(java.lang.Object)
	 */
	public abstract List findByDocType(Object docType);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocName(java.lang.Object)
	 */
	public abstract List findByDocName(Object docName);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDraftOpinion(java.lang.Object)
	 */
	public abstract List findByDraftOpinion(Object draftOpinion);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByBookUser(java.lang.Object)
	 */
	public abstract List findByBookUser(Object bookUser);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByAuditUser(java.lang.Object)
	 */
	public abstract List findByAuditUser(Object auditUser);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByLeaderAudit(java.lang.Object)
	 */
	public abstract List findByLeaderAudit(Object leaderAudit);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByAssUserRemark(java.lang.Object)
	 */
	public abstract List findByAssUserRemark(Object assUserRemark);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByMainDeptOpinion(java.lang.Object)
	 */
	public abstract List findByMainDeptOpinion(Object mainDeptOpinion);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDealState(java.lang.Object)
	 */
	public abstract List findByDealState(Object dealState);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByDocState(java.lang.Object)
	 */
	public abstract List findByDocState(Object docState);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findByArchiveFlag(java.lang.Object)
	 */
	public abstract List findByArchiveFlag(Object archiveFlag);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#findAll()
	 */
	public abstract List findAll();

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#merge(com.baosight.mode.TbDocRec)
	 */
	public abstract TbDocRec merge(TbDocRec detachedInstance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#attachDirty(com.baosight.mode.TbDocRec)
	 */
	public abstract void attachDirty(TbDocRec instance);

	/* (non-Javadoc)
	 * @see com.baosight.base.dao.impl.TbDocRecDA#attachClean(com.baosight.mode.TbDocRec)
	 */
	public abstract void attachClean(TbDocRec instance);


}