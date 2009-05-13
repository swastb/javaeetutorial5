package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocSend;

public interface ITbDocSendDAO {

	public abstract void save(TbDocSend transientInstance);

	public abstract void delete(TbDocSend persistentInstance);

	public abstract TbDocSend findById(java.lang.String id);

	public abstract List findByExample(TbDocSend instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByFileSecret(Object fileSecret);

	public abstract List findBySign(Object sign);

	public abstract List findByDraftOpinion(Object draftOpinion);

	public abstract List findByFileTitle(Object fileTitle);

	public abstract List findByFileDept(Object fileDept);

	public abstract List findBySendMain(Object sendMain);

	public abstract List findBySendSecond(Object sendSecond);

	public abstract List findByTopicWord(Object topicWord);

	public abstract List findByMainDraftUser(Object mainDraftUser);

	public abstract List findByMainChargeUser(Object mainChargeUser);

	public abstract List findByOfficeDraftUser(Object officeDraftUser);

	public abstract List findByOfficeChargeUser(Object officeChargeUser);

	public abstract List findByFileNo(Object fileNo);

	public abstract List findByFileNum(Object fileNum);

	public abstract List findByPrintUser(Object printUser);

	public abstract List findByCollateUser(Object collateUser);

	public abstract List findBySignOpinion(Object signOpinion);

	public abstract List findBySecret1(Object secret1);

	public abstract List findBySecret2(Object secret2);

	public abstract List findByFilePages(Object filePages);

	public abstract List findAll();

	public abstract TbDocSend merge(TbDocSend detachedInstance);

	public abstract void attachDirty(TbDocSend instance);

	public abstract void attachClean(TbDocSend instance);
	
	public abstract List findBySql(String sql);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
}