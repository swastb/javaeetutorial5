package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbDeptDAO;
import com.baosight.base.dao.ITbPstDAO;
import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.service.IPstMgr;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

public class PstMgrImpl implements IPstMgr {

	private ITbPstDAO tbPstDAO;
    private ITbDeptDAO tbDeptDAO;
    private ITbUserDAO tbUserDAO;
    
	private HashMap cache = new HashMap();

	public void setTbPstDAO(ITbPstDAO tbPstDAO) {
		this.tbPstDAO = tbPstDAO;
	}
	public void setTbDeptDAO(ITbDeptDAO tbDeptDAO) {
		this.tbDeptDAO = tbDeptDAO;
	}
	public Collection getByDeptId(String parentId) {
		if (this.cache.containsKey(parentId)) {
			return (Collection) this.cache.get(parentId);
		}
		Collection temp = this.tbPstDAO.findByDeptId(parentId);
		this.cache.put(parentId, temp);
		return temp;
	}

	public boolean delete(String nodeId) {
		TbPst item = this.tbPstDAO.findById(nodeId);
		if (item == null) {
			return false;
		}
		// 在缓存中同步删除
		cacheDelete(item);
		//职务(tb_pst)删除时
		this.tbPstDAO.delete(item);

		//职务(tb_pst)删除时，根据职务id，将tb_user表中所有pst字段值清空
		List list=this.tbUserDAO.findByDeptCode(nodeId);
		for(int i=0;i<list.size();i++)
		{
			TbUser user=(TbUser)list.get(i);
			user.setPst(null);
			
			this.tbUserDAO.save(user);
		}
		
		return true;
	}

	private void cacheDelete(TbPst item) {
		String parentId = item.getDeptid();
		if (parentId != null && !parentId.equals("")) {
			if (this.cache.containsKey(parentId)) {
				Collection temp = (Collection) this.cache.get(parentId);
				for (Iterator iter = temp.iterator(); iter.hasNext();) {
					Object node = iter.next();
					if (node instanceof TbPst
							&& ((TbPst) node).getId().equals(item.getId())) {
						iter.remove();
						break;
					}
				}
			}
		}
	}

	public void save(TbPst item) {
		this.tbPstDAO.save(item);
		// 在缓存中同步保存
		cacheSave(item);
	}

	private void cacheSave(TbPst item) {
		String parentId = item.getDeptid();
		if (parentId != null && !parentId.equals("")) {
			if (this.cache.containsKey(parentId)) {
				Collection temp = (Collection) this.cache.get(parentId);
				temp.add(item);
			} else {
				Collection temp = new ArrayList();
				temp.add(item);
				this.cache.put(parentId, temp);
			}
		}
	}

	// start
	public TbPst find(String id) {
		return this.tbPstDAO.findById(id);
	}

	/**
	 * 编辑职务
	 */
	public void updatePst(TbPst item) {
		this.tbPstDAO.updatePost(item);
		// 在缓存中同步更新
		cacheUpdate(item);
	}
	// end

	public void cacheUpdate(TbPst item) {
		String parentId = item.getDeptid();
		if (parentId != null && !parentId.equals("")) {
			if (this.cache.containsKey(parentId)) {
				Collection temp = (Collection) this.cache.get(parentId);
				for (Iterator iter = temp.iterator(); iter.hasNext();) {
					Object child = iter.next();
					if (child instanceof TbPst) {
						if (((TbPst) child).getId().equals(item.getId())) {
							iter.remove();
							break;
						}
					}
				}
				temp.add(item);
			} else {
				Collection temp = new ArrayList();
				temp.add(item);
				this.cache.put(parentId, temp);
			}
		}
	}
	public long test(){
		return 0;
	}
	/**
	 * 取deforder的最大值
	 * @param parentId
	 * @return
	 */
	public long getMaxDefOrder(String parentId){
		long maxDefOrderDept=this.tbDeptDAO.findMaxDefOrder(parentId,"dept");
		long maxDefOrderPost=this.tbDeptDAO.findMaxDefOrder(parentId,"post");
		long maxDefOrderUser=this.tbDeptDAO.findMaxDefOrder(parentId,"user");
		if(maxDefOrderDept>maxDefOrderPost&&maxDefOrderDept>maxDefOrderUser)
			return maxDefOrderDept;
		else if(maxDefOrderPost>maxDefOrderDept&&maxDefOrderPost>maxDefOrderUser)
			return maxDefOrderPost;
		else
			return maxDefOrderUser;
	}
	public ITbUserDAO getTbUserDAO() {
		return tbUserDAO;
	}
	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}
	
	public String checkName(String id, String name,String par,String field) {
		List list=tbPstDAO.checkName(id,name,par,field);
		String checkMessage="true";
		if(list.size() > 0)
		{
			checkMessage="false";
		}
		return checkMessage;
	}
}
