package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocArchiveCode;

public interface ITbDocArchiveCodeDAO {

	public abstract void save(TbDocArchiveCode transientInstance);

	public abstract void delete(TbDocArchiveCode persistentInstance);

	public abstract TbDocArchiveCode findById(java.lang.String id);

	public abstract List findByExample(TbDocArchiveCode instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySn(Object sn);

	public abstract List findByName(Object name);

	public abstract List findByDescription(Object description);

	public abstract List findByCategoryId(Object categoryId);

	public abstract List findByYear(Object year);

	public abstract List findByPageCount(Object pageCount);

	public abstract List findByPageSize(Object pageSize);

	public abstract List findByKeepTime(Object keepTime);

	public abstract List findByParentId(Object parentId);

	public abstract List findBySeq(Object seq);

	public abstract List findBySysAttr(Object sysAttr);

	public abstract List findByStatus(Object status);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findByAttr3(Object attr3);

	public abstract List findAll();

	public abstract TbDocArchiveCode merge(TbDocArchiveCode detachedInstance);

	public abstract void attachDirty(TbDocArchiveCode instance);

	public abstract void attachClean(TbDocArchiveCode instance);

}