package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbUserdept;

public interface IUserDeptMgr {
	List findAll();

	void updte(TbUserdept item);

	void delete(String id);

	void save(TbUserdept item);

	TbUserdept find(String id);
}
