package com.baosight.base.service;

import java.util.Collection;

import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;

public interface IPstMgr {

	Collection getByDeptId(String parentId);

	boolean delete(String nodeId);

	void save(TbPst item);
//	start
	public TbPst find(String id);
	
	public String checkName(String id,String name,String par,String field);
	/**
	 * ±à¼­Ö°Îñ
	 */
	public void updatePst(TbPst item);
	public long getMaxDefOrder(String parentId);
	public void cacheUpdate(TbPst item);
	//end
}