package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfs4DAO;
import com.baosight.mode.TbZfxxgksqdfs4;

public interface IZfxxgksqdfs4Mgr {

	public abstract void setTbZfxxgksqdfs4DAO(ITbZfxxgksqdfs4DAO tbZfxxgksqdfs4DAO);

	public abstract void delete(String id);

	public abstract TbZfxxgksqdfs4 find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgksqdfs4 item);

	public abstract void update(TbZfxxgksqdfs4 item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbZfxxgksqdfs4 instance);

}