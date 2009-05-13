package com.baosight.tech.service;

import java.util.List;

import com.baosight.tech.mode.TbTechResult;

public interface ITechResultMgr {

	public abstract void save(TbTechResult transientInstance);

	public abstract void delete(TbTechResult persistentInstance);

	public abstract TbTechResult findById(java.lang.String id);

	public abstract List findAll();

	public abstract List findForQuery(TbTechResult item);

}