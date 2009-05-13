package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbYqdfgzsDAO;
import com.baosight.mode.TbYqdfgzs;

public interface IYqdfgzsMgr {

	public abstract void setTbYqdfgzsDAO(ITbYqdfgzsDAO tbYqdfgzsDAO);

	public abstract void delete(String id);

	public abstract TbYqdfgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbYqdfgzs item);

	public abstract void update(TbYqdfgzs item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbYqdfgzs instance);

}