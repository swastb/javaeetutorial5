package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbGroup;

public interface IGroupMgr {

	List findAll();

	TbGroup find(String id);

	void updte(TbGroup item);

	void delete(String id);

	void save(TbGroup item);

}