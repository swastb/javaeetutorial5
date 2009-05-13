package com.baosight.base.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.baosight.base.dao.ITbDeptDAO;
import com.baosight.base.dao.ITbPstDAO;
import com.baosight.base.dao.ITbUserDAO;
import com.baosight.base.service.IDeptMgr;
import com.baosight.base.service.ITbUserMgr;
import com.baosight.base.service.IPstMgr;
import com.baosight.base.service.impl.TbUserMgrImpl;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;

public class DeptMgrImpl implements IDeptMgr {

	private ITbDeptDAO tbDeptDAO;

	private ITbPstDAO tbPstDAO;

	private ITbUserDAO tbUserDAO;

	private HashMap cache = new HashMap();

	public TbDept getSystemRoot() {
		List list = tbDeptDAO.findAll();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			TbDept item = (TbDept) iter.next();
			if (item.getParCode() == null || item.getParCode().equals("")) {
				return item;
			}
		}
		return null;
	}

	public void setTbDeptDAO(ITbDeptDAO tbDeptDAO) {
		this.tbDeptDAO = tbDeptDAO;
	}

	public void setTbPstDAO(ITbPstDAO tbPstDAO) {
		this.tbPstDAO = tbPstDAO;
	}

	public void setTbUserDAO(ITbUserDAO tbUserDAO) {
		this.tbUserDAO = tbUserDAO;
	}

	public Collection getChildren(String parentId) {
		if (this.cache.containsKey(parentId)) {
			return (Collection) this.cache.get(parentId);
		}
		Collection temp = this.tbDeptDAO.findByParCode(parentId);
		this.cache.put(parentId, temp);
		return temp;
	}

	public void save(TbDept item) {
		this.tbDeptDAO.save(item);
		// 在缓存中同步保存
		cacheSave(item);
	}

	private void cacheSave(TbDept item) {
		String parentId = item.getParCode();
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

	/**
	 * 编辑部门
	 */
	public void updateDept(TbDept item) {
		this.tbDeptDAO.updateDept(item);
		// 在缓存中同步更新
		cacheUpdate(item);
	}

	private void cacheUpdate(TbDept item) {
		String parentId = item.getParCode();
		if (parentId != null && !parentId.equals("")) {
			if (this.cache.containsKey(parentId)) {
				Collection temp = (Collection) this.cache.get(parentId);
				for (Iterator iter = temp.iterator(); iter.hasNext();) {
					Object child = iter.next();
					if (child instanceof TbDept) {
						if (((TbDept) child).getId().equals(
								((TbDept) item).getId())) {
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

	public boolean delete(String nodeId) {
		TbDept item = this.tbDeptDAO.findById(nodeId);
		if (item == null) {
			return false;
		}
		// 在缓存中同步删除
		cacheDelete(item);
		// 部门(tb_dept)删除
		this.tbDeptDAO.delete(item);
		// 部门(tb_dept)删除时，根据部门id，将tb_user表中所有dept_code字段值清空
		List list = this.tbUserDAO.findByDeptCode(nodeId);
		for (int i = 0; i < list.size(); i++) {
			TbUser user = (TbUser) list.get(i);
			user.setDeptCode(null);

			this.tbUserDAO.save(user);
		}
		return true;
	}

	private void cacheDelete(TbDept item) {
		String parentId = item.getParCode();
		if (parentId != null && !parentId.equals("")) {
			if (this.cache.containsKey(parentId)) {
				Collection temp = (Collection) this.cache.get(parentId);
				for (Iterator iter = temp.iterator(); iter.hasNext();) {
					TbDept i = (TbDept) iter.next();
					if (i.getId().equals(item.getId())) {
						iter.remove();
						break;
					}
				}
			}
		}
	}

	// start
	public TbDept find(String id) {
		return this.tbDeptDAO.findById(id);
	}

	/**
	 * 取deforder的最大值
	 * 
	 * @param parentId
	 * @return
	 */
	public long getMaxDefOrder(String parentId) {
		long maxDefOrderDept = this.tbDeptDAO.findMaxDefOrder(parentId, "dept");
		long maxDefOrderPost = this.tbDeptDAO.findMaxDefOrder(parentId, "post");
		long maxDefOrderUser = this.tbDeptDAO.findMaxDefOrder(parentId, "user");
		System.out.println("11--" + maxDefOrderDept + "---22--"
				+ maxDefOrderPost + "--33--" + maxDefOrderUser);
		if (maxDefOrderDept > maxDefOrderPost
				&& maxDefOrderDept > maxDefOrderUser)
			return maxDefOrderDept;
		else if (maxDefOrderPost > maxDefOrderDept
				&& maxDefOrderPost > maxDefOrderUser)
			return maxDefOrderPost;
		else
			return maxDefOrderUser;
	}

	/**
	 * 节点移动
	 * 
	 * @param parentId
	 * @param nodeId
	 * @param type
	 */
	public void upDownMoveS(String parentId, String nodeId, String nodeType,
			String nextNType, String defOrder, String type) {
		if ("dept".equals(nodeType) && "dept".equals(nextNType)) {
			TbDept dept = this.tbDeptDAO.findById(nodeId);
			TbDept dept1 = this.tbDeptDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (dept!=null && dept1!=null) {
				dept.setDefOrder(dept1.getDefOrder());
				dept1.setDefOrder(Long.parseLong(defOrder));
				this.tbDeptDAO.updateDept(dept);
				this.tbDeptDAO.updateDept(dept1);
				this.cacheUpdate(dept);
				this.cacheUpdate(dept1);
			}
		} else if ("post".equals(nodeType) && "post".equals(nextNType)) {
			TbPst post = this.tbPstDAO.findById(nodeId);
			TbPst post1 = this.tbPstDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (post!=null && post1!=null) {
				post.setDefOrder(post1.getDefOrder());
				post1.setDefOrder(Long.parseLong(defOrder));
				this.tbPstDAO.updatePost(post);
				this.tbPstDAO.updatePost(post1);
				this.pstMgr.cacheUpdate(post);
				this.pstMgr.cacheUpdate(post1);
			}
		} else if ("user".equals(nodeType) && "user".equals(nextNType)) {
			TbUser user = this.tbUserDAO.findById(nodeId);
			TbUser user1 = this.tbUserDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (user!=null && user1!=null) {
				user.setDefOrder(user1.getDefOrder());
				user1.setDefOrder(Long.parseLong(defOrder));
				this.tbUserDAO.update(user);
				this.tbUserDAO.update(user1);
				this.userMgr.cacheUpdate(user);
				this.userMgr.cacheUpdate(user1);
			}
		} else if ("dept".equals(nodeType) && "post".equals(nextNType)) {
			TbDept dept = this.tbDeptDAO.findById(nodeId);
			TbPst post = this.tbPstDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (dept!=null && post!=null) {
				dept.setDefOrder(post.getDefOrder());
				post.setDefOrder(Long.parseLong(defOrder));
				this.tbDeptDAO.updateDept(dept);
				this.tbPstDAO.updatePost(post);
				this.cacheUpdate(dept);
				this.pstMgr.cacheUpdate(post);
			}
		} else if ("dept".equals(nodeType) && "user".equals(nextNType)) {
			TbDept dept = this.tbDeptDAO.findById(nodeId);
			TbUser user = this.tbUserDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (dept!=null && user!=null) {
				dept.setDefOrder(user.getDefOrder());
				user.setDefOrder(Long.parseLong(defOrder));
				this.tbDeptDAO.updateDept(dept);
				this.tbUserDAO.update(user);
				this.cacheUpdate(dept);
				this.userMgr.cacheUpdate(user);
			}
		} else if ("post".equals(nodeType) && "dept".equals(nextNType)) {
			TbPst post = this.tbPstDAO.findById(nodeId);
			TbDept dept = this.tbDeptDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (post!=null && dept!=null) {
				post.setDefOrder(dept.getDefOrder());
				dept.setDefOrder(Long.parseLong(defOrder));
				this.tbPstDAO.updatePost(post);
				this.tbDeptDAO.updateDept(dept);
				this.pstMgr.cacheUpdate(post);
				this.cacheUpdate(dept);
			}
		} else if ("post".equals(nodeType) && "user".equals(nextNType)) {
			TbPst post = this.tbPstDAO.findById(nodeId);
			TbUser user = this.tbUserDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (post!=null && user!=null) {
				post.setDefOrder(user.getDefOrder());
				user.setDefOrder(Long.parseLong(defOrder));
				this.tbPstDAO.updatePost(post);
				this.tbUserDAO.update(user);
				this.pstMgr.cacheUpdate(post);
				this.userMgr.cacheUpdate(user);
			}
		} else if ("user".equals(nodeType) && "dept".equals(nextNType)) {
			TbUser user = this.tbUserDAO.findById(nodeId);
			TbDept dept = this.tbDeptDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (user!=null && dept!=null) {
				user.setDefOrder(dept.getDefOrder());
				dept.setDefOrder(Long.parseLong(defOrder));
				this.tbUserDAO.update(user);
				this.tbDeptDAO.updateDept(dept);
				this.userMgr.cacheUpdate(user);
				this.cacheUpdate(dept);
			}
		} else if ("user".equals(nodeType) && "post".equals(nextNType)) {
			TbUser user = this.tbUserDAO.findById(nodeId);
			TbPst post = this.tbPstDAO.findByPDefOrder(parentId, Long
					.parseLong(defOrder), type);
			if (user!=null && post!=null) {
				user.setDefOrder(post.getDefOrder());
				post.setDefOrder(Long.parseLong(defOrder));
				this.tbUserDAO.update(user);
				this.tbPstDAO.updatePost(post);
				this.userMgr.cacheUpdate(user);
				this.pstMgr.cacheUpdate(post);
			}
		}

	}

	// end

	private ITbUserMgr userMgr;

	private IPstMgr pstMgr;

	public void setUserMgr(ITbUserMgr userMgr) {
		this.userMgr = userMgr;
	}

	public void setPstMgr(IPstMgr pstMgr) {
		this.pstMgr = pstMgr;
	}

	public String checkName(String id, String name, String par, String field) {
		List list = tbDeptDAO.checkName(id, name, par, field);
		String checkMessage = "true";
		if (list.size() > 0) {
			checkMessage = "false";
		}
		return checkMessage;
	}

	// 日程安排选择部门，根据ids查询到部门名称
	public String selectDepts(String ids) {
		// TODO Auto-generated method stub
		List deptList=new ArrayList();
		String depts="";
		
		String id[]=ids.split(",");
		int len=id.length;
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				TbDept dept=this.tbDeptDAO.findById(id[i]);
				deptList.add(dept);
			}
		}
		int dlen = deptList.size();
		if (dlen > 0) {
			for (int j = 0; j < dlen; j++) {
				TbDept tdept = (TbDept) deptList.get(j);
				if (j == 0) {
					depts = depts + tdept.getName();
				} else {
					depts = depts + "," + tdept.getName();
				}
			}
		}
		//System.out.println(depts+"????????????????????????????????????????");
		return depts;
	}

	public List findAllDept() {
		return tbDeptDAO.findAll();
	}
	public List getTwoDept(String deptId){
		return tbDeptDAO.getTwoDept(deptId);
	}

	public List find4Tree(String rootId){
		String sql = "select {t.*} from tb_dept t start with t.id='"+rootId+"' "
			+"connect by prior t.id=t.par_code order by level";
		return tbDeptDAO.findBySql(sql,"t",TbDept.class);
	}

}
