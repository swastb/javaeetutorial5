package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbBzsqgzsDAO;
import com.baosight.mode.TbBzsqgzs;

public interface IBzsqgzsMgr {

	public abstract void setTbBzsqgzsDAO(ITbBzsqgzsDAO tbBzsqgzsDAO);

	public abstract void delete(String id);

	public abstract TbBzsqgzs find(String id);

	public abstract List findAll();

	public abstract void save(TbBzsqgzs item);

	public abstract void update(TbBzsqgzs item);

	public abstract List findByExample(TbBzsqgzs instance);

}