package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbFzfxxgksqgzsDAO;
import com.baosight.mode.TbFzfxxgksqgzs;

public interface IFzfxxgksqgzsMgr {

	public abstract void setTbFzfxxgksqgzsDAO(ITbFzfxxgksqgzsDAO tbFzfxxgksqgzsDAO);

	public abstract void delete(String id);

	public abstract TbFzfxxgksqgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbFzfxxgksqgzs item);

	public abstract void update(TbFzfxxgksqgzs item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbFzfxxgksqgzs instance);

}