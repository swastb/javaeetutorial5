package com.baosight.base.service;

import java.util.List;

import com.baosight.base.dao.ITbZfxxbfgkgzsDAO;
import com.baosight.mode.TbZfxxbfgkgzs;

public interface IZfxxbfgkgzsMgr {

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#setTbZfxxgkgzsDAO(com.baosight.base.dao.ITbZfxxgkgzsDAO)
	 */
	public abstract void setTbZfxxbfgkgzsDAO(ITbZfxxbfgkgzsDAO tbZfxxbfgkgzsDAO);

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#delete(java.lang.String)
	 */
	public abstract void delete(String id);

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#find(java.lang.String)
	 */
	public abstract TbZfxxbfgkgzs find(String id);

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#findAll()
	 */
	public abstract List findAll();

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#save(com.baosight.mode.TbZfxxgkgzs)
	 */
	public abstract void save(TbZfxxbfgkgzs item);

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#update(com.baosight.mode.TbZfxxgkgzs)
	 */
	public abstract void update(TbZfxxbfgkgzs item);

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IZfxxgkgzsMgr#findByExample(com.baosight.mode.TbZfxxgkgzs)
	 */
	public abstract List findByExample(TbZfxxbfgkgzs instance);

}