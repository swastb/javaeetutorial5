package com.baosight.tech.service;

import java.util.List;

import com.baosight.tech.mode.TbTechDiscoure;
import com.baosight.tech.mode.TbTechMapShare;;

public interface ITechMapShareMgr {

	public abstract void save(TbTechMapShare transientInstance);

	public abstract void delete(TbTechMapShare persistentInstance);

	public abstract TbTechMapShare findById(java.lang.String id);

	public abstract List findAll();

	public abstract List findForQuery(TbTechMapShare item);
}