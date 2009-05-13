package com.baosight.base.dao;

import java.util.List;

import com.baosight.mode.TbGovInfoPubAudit;

public interface ITbGovInfoPubAuditDAO {
	


	public void save(TbGovInfoPubAudit transientInstance) ;

	public void delete(TbGovInfoPubAudit persistentInstance);
	
	public void update(TbGovInfoPubAudit persistentInstance);
	
	public TbGovInfoPubAudit findById(java.lang.String id);
	
	public List findByExample(TbGovInfoPubAudit instance);

	public List findByProperty(String propertyName, Object value);

    public List findAll();

	public TbGovInfoPubAudit merge(TbGovInfoPubAudit detachedInstance);

	public void attachDirty(TbGovInfoPubAudit instance);

	public void attachClean(TbGovInfoPubAudit instance) ;

}