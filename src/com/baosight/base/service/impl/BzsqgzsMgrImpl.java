package com.baosight.base.service.impl;

import java.util.List;

import com.baosight.base.dao.ITbBzsqgzsDAO;
import com.baosight.base.service.IBzsqgzsMgr;
import com.baosight.mode.TbBzsqgzs;

public class BzsqgzsMgrImpl implements IBzsqgzsMgr {
	private ITbBzsqgzsDAO tbBzsqgzsDAO;


	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#setTbBzsqgzsDAO(com.baosight.base.dao.ITbBzsqgzsDAO)
	 */
	public void setTbBzsqgzsDAO(ITbBzsqgzsDAO tbBzsqgzsDAO) {
		this.tbBzsqgzsDAO = tbBzsqgzsDAO;
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#delete(java.lang.String)
	 */
	public void delete(String id) {
		TbBzsqgzs item = find(id);
		this.tbBzsqgzsDAO.delete(item);
		
	}


	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#find(java.lang.String)
	 */
	public TbBzsqgzs find(String id) {
		return this.tbBzsqgzsDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#findAll()
	 */
	public List findAll() {
		return this.tbBzsqgzsDAO.findAll();
	}


	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#save(com.baosight.mode.TbBzsqgzs)
	 */
	public void save(TbBzsqgzs item) {
		this.tbBzsqgzsDAO.save(item);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#update(com.baosight.mode.TbBzsqgzs)
	 */
	public void update(TbBzsqgzs item) {
		this.tbBzsqgzsDAO.update(item);
	}

	/* (non-Javadoc)
	 * @see com.baosight.base.service.impl.IBzsqgzsMgr#findByExample(com.baosight.mode.TbBzsqgzs)
	 */
	public List findByExample(TbBzsqgzs instance) {
		// TODO Auto-generated method stub
		return this.tbBzsqgzsDAO.findByExample(instance);
	}
}
