package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbDocAttachDAO;
import com.baosight.base.service.IDocAttachMgr;
import com.baosight.mode.TbDocAttach;

/**
 * <p>Decription:DocAttachMgrImpl</p>
 * @author heaton.cai
 * <p>Create Time:2008-8-4</p>
 */
public class DocAttachMgrImpl implements IDocAttachMgr {
	private ITbDocAttachDAO tbDocAttachDAO;

	public void delete(TbDocAttach persistentInstance) {
		this.tbDocAttachDAO.delete(persistentInstance);
		
	}

	public List findAll() {
		return tbDocAttachDAO.findAll();
	}

	public List findByForeignId(String foreignId) {
		return tbDocAttachDAO.findByForeignId(foreignId);
	}

	public TbDocAttach findById(String id) {
		return tbDocAttachDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbDocAttachDAO.findByProperty(propertyName, value);
	}

	public List findByType(String type) {
		return this.tbDocAttachDAO.findByType(type);
	}

	public List findByIdAndType(String foreignId, String type) {
		String hql = "from TbDocAttach t where t.foreignId='"+foreignId+"' "
			+ "and t.type = '"+type+"'";
		return this.tbDocAttachDAO.findByHQL(hql, -1, -1);
	}

	public void save(TbDocAttach transientInstance) {
		if(transientInstance.getId()==null || transientInstance.getId().length()<1){
			this.tbDocAttachDAO.save(transientInstance);
		}else{
			this.tbDocAttachDAO.merge(transientInstance);
		}
	}

	public void setTbDocAttachDAO(ITbDocAttachDAO tbDocAttachDAO) {
		this.tbDocAttachDAO = tbDocAttachDAO;
	}

}
