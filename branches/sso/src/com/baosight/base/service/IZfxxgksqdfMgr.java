package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxgksqdfDAO;
import com.baosight.mode.TbZfxxgksqdf;

public interface IZfxxgksqdfMgr {

	public abstract void setTbZfxxgksqdfDAO(ITbZfxxgksqdfDAO tbZfxxgksqdfDAO);

	public abstract void delete(String id);

	public abstract TbZfxxgksqdf find(String id);

	public abstract List findAll();

	public abstract void save(TbZfxxgksqdf item);

	public abstract void update(TbZfxxgksqdf item);

	public List findByInfoId(Object infoId);

	public abstract List findByExample(TbZfxxgksqdf instance);

}