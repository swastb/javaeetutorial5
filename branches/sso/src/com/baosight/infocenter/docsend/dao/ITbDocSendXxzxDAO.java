package com.baosight.infocenter.docsend.dao;

import java.util.List;

import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;

/**
 * Data access object (DAO) for domain model class TbDocSendXxzx.
 * 
 * @see com.baosight.infocenter.docsend.mode.TbDocSendXxzx
 * @author MyEclipse Persistence Tools
 */

public interface ITbDocSendXxzxDAO {
	
	public void save(TbDocSendXxzx transientInstance);

	public void delete(TbDocSendXxzx persistentInstance);
	
	public TbDocSendXxzx findById(java.lang.String id);

	public List findByExample(TbDocSendXxzx instance);

	public List findByProperty(String propertyName, Object value);

	public List findByFileSecret(Object fileSecret);

	public List findByDraftOpinion(Object draftOpinion);

	public List findByFileTitle(Object fileTitle);

	public List findByFileDept(Object fileDept);

	public List findBySendMain(Object sendMain);

	public List findBySendSecond(Object sendSecond);

	public List findByTopicWord(Object topicWord);

	public List findByDraftUser(Object draftUser);

	public List findByChargeUser(Object chargeUser);

	public List findByFileNo(Object fileNo);

	public List findByFileNum(Object fileNum);

	public List findByPrintUser(Object printUser);

	public List findByCollateUser(Object collateUser);

	public List findBySignOpinion(Object signOpinion);

	public List findBySecret1(Object secret1);

	public List findBySecret2(Object secret2);

	public List findByFilePages(Object filePages);

	public List findBySendFileType(Object sendFileType);

	public List findByDocState(Object docState);

	public List findAll();

	public TbDocSendXxzx merge(TbDocSendXxzx detachedInstance);

	public void attachDirty(TbDocSendXxzx instance);

	public void attachClean(TbDocSendXxzx instance);

	public abstract List findBySql(String sql);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
}