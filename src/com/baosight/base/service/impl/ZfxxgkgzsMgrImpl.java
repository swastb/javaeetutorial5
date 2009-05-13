package com.baosight.base.service.impl;

import java.util.List;

import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import com.baosight.base.dao.ITbInfoAuditDAO;
import com.baosight.base.dao.ITbZfxxgkgzsDAO;
import com.baosight.base.service.IZfxxgkgzsMgr;
import com.baosight.mode.TbZfxxgkgzs;

public class ZfxxgkgzsMgrImpl implements IZfxxgkgzsMgr {

	private ITbZfxxgkgzsDAO tbZfxxgkgzsDAO;

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#setTbZfxxgkgzsDAO(com.baosight.base.dao.ITbZfxxgkgzsDAO)
	 */
	public void setTbZfxxgkgzsDAO(ITbZfxxgkgzsDAO tbZfxxgkgzsDAO) {
		this.tbZfxxgkgzsDAO = tbZfxxgkgzsDAO;
	}
	private ITbInfoAuditDAO tbInfoAuditDAO;

	public void setTbInfoAuditDAO(ITbInfoAuditDAO tbInfoAuditDAO) {
		this.tbInfoAuditDAO = tbInfoAuditDAO;
	}
	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#delete(java.lang.String)
	 */
	public void delete(String id) {
		TbZfxxgkgzs item = find(id);
		this.tbZfxxgkgzsDAO.delete(item);
		
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#find(java.lang.String)
	 */
	public TbZfxxgkgzs find(String id) {
		return this.tbZfxxgkgzsDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#findAll()
	 */
	public List findAll() {
		return this.tbZfxxgkgzsDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#save(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void save(TbZfxxgkgzs item) {
		this.tbZfxxgkgzsDAO.save(item);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#update(com.baosight.mode.TbZfxxgkgzs)
	 */
	public void update(TbZfxxgkgzs item) {
		this.tbZfxxgkgzsDAO.update(item);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#findByExample(com.baosight.mode.TbZfxxgkgzs)
	 */
	public List findByExample(TbZfxxgkgzs instance) {
		// TODO Auto-generated method stub
		return this.tbZfxxgkgzsDAO.findByExample(instance);
	}

}
