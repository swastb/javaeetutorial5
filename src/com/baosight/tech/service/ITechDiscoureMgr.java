package com.baosight.tech.service;

import java.util.List;

import com.baosight.tech.mode.TbTechDiscoure;

public interface ITechDiscoureMgr {

	public abstract void save(TbTechDiscoure transientInstance);

	public abstract void delete(TbTechDiscoure persistentInstance);

	public abstract TbTechDiscoure findById(java.lang.String id);

	public abstract List findAll();

	public abstract List findForQuery(TbTechDiscoure item);

}