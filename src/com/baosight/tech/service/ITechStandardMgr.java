package com.baosight.tech.service;

import java.util.List;

import com.baosight.tech.mode.TbTechStandard;

public interface ITechStandardMgr {

	public abstract void save(TbTechStandard transientInstance);

	public abstract void delete(TbTechStandard persistentInstance);

	public abstract TbTechStandard findById(java.lang.String id);

	public abstract List findAll();

	public abstract List findForQuery(TbTechStandard item);
}