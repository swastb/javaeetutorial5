package com.baosight.base.service.impl;

import java.util.List;
import com.baosight.base.dao.ITbTopicDAO;
import com.baosight.mode.TbTopic;



public class TbTopicMgrImpl implements ITbTopicDAO {

	private ITbTopicDAO tbTopicDAO;

	public void save(TbTopic transientInstance) {
		tbTopicDAO.save(transientInstance);
	}

	public void delete(TbTopic persistentInstance) {
		tbTopicDAO.delete(persistentInstance);
	}

	public TbTopic findById(java.lang.String id) {
		return tbTopicDAO.findById(id);
	}

	public List findByExample(TbTopic instance) {
		return tbTopicDAO.findByExample(instance);
	}

	public List findByProperty(String propertyName, Object value) {
		return tbTopicDAO.findByProperty(propertyName,value);
	}

	public List findAll() {
		return tbTopicDAO.findAll();
	}

	public ITbTopicDAO getTbTopicDAO() {
		return tbTopicDAO;
	}

	public void setTbTopicDAO(ITbTopicDAO tbTopicDAO) {
		this.tbTopicDAO = tbTopicDAO;
	}
}