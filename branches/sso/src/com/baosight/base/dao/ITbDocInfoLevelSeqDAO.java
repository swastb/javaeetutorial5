package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbDocInfoLevelSeq;
import com.baosight.mode.TbDocInfoLevelSeqId;

public interface ITbDocInfoLevelSeqDAO {

	public abstract void save(TbDocInfoLevelSeq transientInstance);

	public abstract void delete(TbDocInfoLevelSeq persistentInstance);

	public abstract TbDocInfoLevelSeq findById(TbDocInfoLevelSeqId id);

	public abstract List findByExample(TbDocInfoLevelSeq instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByCurruntNum(Object curruntNum);

	public abstract List findAll();

	public abstract TbDocInfoLevelSeq merge(TbDocInfoLevelSeq detachedInstance);

	public abstract void attachDirty(TbDocInfoLevelSeq instance);

	public abstract void attachClean(TbDocInfoLevelSeq instance);

}