package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGovInfoPubContent;

public interface ITbGovInfoPubContentDAO {

	public abstract void save(TbGovInfoPubContent transientInstance);

	public abstract void delete(TbGovInfoPubContent persistentInstance);

	public abstract TbGovInfoPubContent findById(java.lang.String id);

	public abstract List findByExample(TbGovInfoPubContent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByInfoSource(Object infoSource);
	
	public abstract List findByTitle(Object title);
	
	public abstract List findByAuthorName(Object authorName);
	
	public abstract List findByKeyword(Object keyword);
	
	public abstract List findBySummary(Object summary);
	
	public abstract List findByContent(Object content);
	
	public abstract List findByPublishType(Object publishType);
	
	public abstract List findByFileCode(Object fileCode);
	
	public abstract List findByInfoSubject(Object infoSubject);
	
	public abstract List findByOfferWay(Object offerWay);
	
	public abstract List findByApplyId(Object applyId);
	
	public abstract List findByStatus(Object status);
	
	public abstract List findByAttr1(Object attr1);
	
	public abstract List findByAttr2(Object attr2);
	
	public abstract List findByAttr3(Object attr3);

	public abstract List findAll();

	public abstract TbGovInfoPubContent merge(TbGovInfoPubContent detachedInstance);

	public abstract void attachDirty(TbGovInfoPubContent instance);

	public abstract void attachClean(TbGovInfoPubContent instance);

	public abstract void update(TbGovInfoPubContent instance);
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);
	public abstract List fingByHql(String sql);
}