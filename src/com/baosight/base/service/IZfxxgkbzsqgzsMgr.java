package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgkbzsqgzsDAO;
import com.baosight.mode.TbZfxxgkbzsqgzs;

public interface IZfxxgkbzsqgzsMgr {

	public abstract void setTbZfxxgkbzsqgzsDAO(ITbZfxxgkbzsqgzsDAO tbZfxxgkbzsqgzsDAO);

	public abstract void delete(String id);

	public abstract TbZfxxgkbzsqgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgkbzsqgzs item);

	public abstract void update(TbZfxxgkbzsqgzs item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbZfxxgkbzsqgzs instance);

}