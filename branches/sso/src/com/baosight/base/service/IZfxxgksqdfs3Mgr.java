package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfs3DAO;
import com.baosight.mode.TbZfxxgksqdfs3;

public interface IZfxxgksqdfs3Mgr {

	public abstract void setTbZfxxgksqdfs3DAO(ITbZfxxgksqdfs3DAO tbZfxxgksqdfs3DAO);

	public abstract void delete(String id);

	public abstract TbZfxxgksqdfs3 find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgksqdfs3 item);

	public abstract void update(TbZfxxgksqdfs3 item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbZfxxgksqdfs3 instance);

}