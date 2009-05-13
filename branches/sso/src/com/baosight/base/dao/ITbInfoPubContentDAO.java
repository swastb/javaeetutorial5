package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbInfoPubContent;

public interface ITbInfoPubContentDAO {

	public abstract void save(TbInfoPubContent transientInstance);

	public abstract void delete(TbInfoPubContent persistentInstance);

	public abstract TbInfoPubContent findById(java.lang.String id);

	public abstract List findByExample(TbInfoPubContent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByInfoId(Object infoId);

	public abstract List findByInfoSource(Object infoSource);

	public abstract List findByTitle(Object title);

	public abstract List findByAuthorName(Object authorName);

	public abstract List findByKeyword(Object keyword);

	public abstract List findByContent(Object content);

	public abstract List findByPublishFlag(Object publishFlag);

	public abstract List findBySendTo(Object sendTo);

	public abstract List findByInfoSubject(Object infoSubject);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findAll();

	public abstract TbInfoPubContent merge(TbInfoPubContent detachedInstance);

	public abstract void attachDirty(TbInfoPubContent instance);

	public abstract void attachClean(TbInfoPubContent instance);

	public abstract void update(TbInfoPubContent instance);
	
	/**
	 * same name checked
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public List checkInfoCommName(String parentid,String id, String value,  String flag);
	/**
	 * same name checked
	 * @param id
	 * @param value
	 * @param flag
	 * @return
	 */
	public List checkInfoClaCommName(String parentid,String id, String value,  String flag);

	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);	
	public List findByHQL(String hql);	

}