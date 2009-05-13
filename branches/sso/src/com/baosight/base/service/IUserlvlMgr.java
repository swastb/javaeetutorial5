package com.baosight.base.service;

import java.util.List;

import com.baosight.mode.TbRighttype;
import com.baosight.mode.TbUserlvl;

public interface IUserlvlMgr {

	List findAll();

	TbUserlvl find(String id);

	void updte(TbUserlvl item);

	void delete(String id);

	void save(TbUserlvl item);
	
	//用户级别管理重复验证
	public String checkUserlvl(String id,String value,String flag);


	void updteMore(TbUserlvl item,String oldname);

	void deleteMore(String id, String oldname);

}
