package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgkgzsDAO;
import com.baosight.mode.TbZfxxgkgzs;

public interface IZfxxgkgzsMgr {

	public abstract void setTbZfxxgkgzsDAO(ITbZfxxgkgzsDAO tbZfxxgkgzsDAO);

	public abstract void delete(String id);

	public abstract TbZfxxgkgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgkgzs item);

	public abstract void update(TbZfxxgkgzs item);

	public abstract List findByExample(TbZfxxgkgzs instance);

}