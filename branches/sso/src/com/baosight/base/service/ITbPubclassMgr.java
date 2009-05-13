package com.baosight.base.service;

import java.util.List;
import com.baosight.mode.TbPubclass;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbPubclass entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.baosight.mode.TbPubclass
 * @author MyEclipse Persistence Tools
 */

public interface ITbPubclassMgr {

	public void save(TbPubclass transientInstance);

	public void delete(TbPubclass persistentInstance);
	
	public TbPubclass findById(java.lang.String id);

	public List findByExample(TbPubclass instance);

	public List findByProperty(String propertyName, Object value);

	public List findAll();
}