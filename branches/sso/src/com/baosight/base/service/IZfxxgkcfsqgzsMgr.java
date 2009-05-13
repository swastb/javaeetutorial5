package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgkcfsqgzsDAO;
import com.baosight.mode.TbZfxxgkcfsqgzs;

public interface IZfxxgkcfsqgzsMgr {

	public abstract void setTbZfxxgkcfsqgzsDAO(ITbZfxxgkcfsqgzsDAO tbZfxxgkcfsqgzsDAO);

	public abstract void delete(String id);

	public abstract TbZfxxgkcfsqgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgkcfsqgzs item);

	public abstract void update(TbZfxxgkcfsqgzs item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbZfxxgkcfsqgzs instance);

}