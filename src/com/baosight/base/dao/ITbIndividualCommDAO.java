package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbIndividualComm;
import com.baosight.mode.TbUser;

public interface ITbIndividualCommDAO {

	public abstract void save(TbIndividualComm transientInstance);

	public abstract void delete(TbIndividualComm persistentInstance);

	public abstract TbIndividualComm findById(java.lang.String id);

	public abstract List findByExample(TbIndividualComm instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByInuse(Object inuse);

	public abstract List findByRemark(Object remark);

	public abstract List findByAttr1(Object attr1);

	public abstract List findByAttr2(Object attr2);

	public abstract List findAll(TbUser user);
	
	public abstract List findSelectName(String SelectName,TbUser user);

	public abstract TbIndividualComm merge(TbIndividualComm detachedInstance);

	public abstract void attachDirty(TbIndividualComm instance);

	public abstract void attachClean(TbIndividualComm instance);

	public abstract void update(TbIndividualComm transientInstance);
	
	public List checkIndividualComm(String id, String value, String userid,  String flag);
	
	public List findStatus(TbUser user);
	
	public List findByHQL(String hql, boolean cacheable, int startIndex,
			int maxResultCount);	

}