package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocsendSubject;

public interface ITbDocsendSubjectDAO {

	public abstract void save(TbDocsendSubject transientInstance);

	public abstract void delete(TbDocsendSubject persistentInstance);

	public abstract TbDocsendSubject findById(java.lang.String id);

	public abstract List findByExample(TbDocsendSubject instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStyle(Object style);

	public abstract List findByClass_(Object class_);

	public abstract List findByTitle(Object title);

	public abstract List findByPinyin(Object pinyin);

	public abstract List findAll();

	public abstract TbDocsendSubject merge(TbDocsendSubject detachedInstance);

	public abstract void attachDirty(TbDocsendSubject instance);

	public abstract void attachClean(TbDocsendSubject instance);

}