package com.baosight.base.struts.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbDept;
import com.baosight.mode.TbPst;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserRole;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tools.DeptNodeForCheckedbox;
import com.baosight.tools.PstNodeForCheckedbox;
import com.baosight.tools.UserNodeForCheckedbox;
import com.data.load.webapp.listener.*;

public class OrgLeftTreeAction extends BaseDispatchAction {

	private List allUserRole;

	public ActionForward ruleUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String roleId = request.getParameter("role");
		String userIds = request.getParameter("userid");
		// 处理角色和用户的关系
		disposeUserRole(roleId, userIds);
		return new ActionForward(
				"/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid="
						+ roleId);
	}

	private void disposeUserRole(String roleId, String userIds) {
		// 首先删除当前角色所有用户
		this.userRoleMgr.deleteByRoleId(roleId);
		String[] uIds = new String[0];
		// 去掉最后一个“,”号
		if (userIds != null && !userIds.equals("")) {
			userIds = userIds.substring(0, userIds.length() - 1);
			uIds = userIds.split(",");
		}
		for (int i = 0; i < uIds.length; i++) {
			String userId = uIds[i];
			TbUserRole item = new TbUserRole();
			item.setRoleid(roleId);
			item.setUserid(userId);
			this.userRoleMgr.save(item);
		}
	}

	public ActionForward listCheckedUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String roleId = request.getParameter("roleid");
		if (roleId != null && !roleId.equals("")) {
			request.setAttribute("roleid", roleId);
			this.allUserRole = this.userRoleMgr.findByRoleId(roleId, true);
		}
		TbDept system = this.deptMgr.getSystemRoot();

		List orgList = getOrgListWithCheckedUser(system, roleId);
		// List orgList = getOrgListWithCheckedUser(system);

		request.setAttribute("system", system);
		request.setAttribute("orglist", orgList);

		String source = request.getParameter("source");
		if (source != null && !"".equals(source)) {
			if (source.equals("week_sechedule")) 
			{
				String flag = request.getParameter("flag");
				if (flag != null && "modify".equals(flag)) 
				{
					request.setAttribute("action", "modify");
				}
				return mapping.findForward("week_sechedule_selectuser");
			}
			if (source.equals("week_secheduledept")) 
			{
				String flag = request.getParameter("flag");
				if (flag != null && "modify".equals(flag)) 
				{
					request.setAttribute("action", "modify");
				}
				return mapping.findForward("week_sechedule_selectdept");
			}
			if (source.equals("filesendedit")) {
				return mapping.findForward("filesendedit_selectuser");
			}
		}
		if (source != null && !"".equals(source)) {
			if (source.equals("meetingedituser")) {
				return mapping.findForward("meetingedit_selectuser");
			}
			if (source.equals("meetingeditdept")) {
				return mapping.findForward("meetingedit_selectdept");
			}
			if (source.equals("shouwenuser")) {
				return mapping.findForward("shouwen_selectuser");
			}
			if (source.equals("shouwendept")) {
				return mapping.findForward("shouwen_selectdept");
			}
			if (source.equals("showBookUser")) {
				return mapping.findForward("showBookUser");
			}
		
		}

		return mapping.findForward("list");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbDept system = this.deptMgr.getSystemRoot();



		// List orgList = Constants.orgList;
		List orgList = getOrgList(system);

		request.setAttribute("system", system);
		request.setAttribute("orglist", orgList);
		String roleId = request.getParameter("roleid");
		if (roleId != null && !roleId.equals("")) {
			request.setAttribute("roleid", roleId);
		}
		return mapping.findForward("list");
	}
	
	/**
	 * 查询统计所用的树
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward queryList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		///WEB-INF/web/jsp/org/orgtreelist.jsp
		TbDept system = this.deptMgr.getSystemRoot();
		// List orgList = Constants.orgList;
		List orgList = getOrgList(system);

		request.setAttribute("system", system);
		request.setAttribute("orglist", orgList);
		String roleId = request.getParameter("roleid");
		if (roleId != null && !"".equals(roleId)) {
			request.setAttribute("roleid", roleId);
		}
		return mapping.findForward("queryList");
	}
	public ActionForward listServlet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbDept system = this.deptMgr.getSystemRoot();
		getOrgList(system);
		return null;
	}

	private List getOrgListWithCheckedUser(TbDept root) {
		List result = new LinkedList();
		return result;
	}

	private List getOrgListWithCheckedUser(TbDept root, String roleId) {
		List result = new LinkedList();
		String rootId = root.getId();
		// 得到父id为此id的，分别从deptMgr,pstMgr,userMgr中
		getChild(result, rootId, roleId);
		return result;
	}

	private void getChild(List result, String parentId, String roleId) {
		List children = getChildrenWithChecked(parentId, roleId);
		if (children.size() > 0) {
			result.addAll(children);
			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				Object item = iter.next();
				if (item instanceof DeptNodeForCheckedbox) {
					getChild(result, ((DeptNodeForCheckedbox) item).getDept()
							.getId(), roleId);
				}
				if (item instanceof PstNodeForCheckedbox) {
					getChild(result, ((PstNodeForCheckedbox) item).getPst()
							.getId(), roleId);
				}
				if (item instanceof UserNodeForCheckedbox) {
					getChild(result, ((UserNodeForCheckedbox) item).getUser()
							.getId(), roleId);
				}
			}
		}
	}

	private List getChildrenWithChecked(String parentId, String roleId) {
		List result = new LinkedList();
		Iterator iter = null;
		// 从deptMgr中找
		for (iter = deptMgr.getChildren(parentId).iterator(); iter.hasNext();) {
			TbDept dept = (TbDept) iter.next();
			if (dept.getName().indexOf("其他") != -1) {
				System.out.println();
			}
			if (hasRole(dept, roleId)) {
				result.add(new DeptNodeForCheckedbox(dept, true));
			} else {
				result.add(new DeptNodeForCheckedbox(dept, false));
			}
		}
		// 从pstMgr中找
		for (iter = pstMgr.getByDeptId(parentId).iterator(); iter.hasNext();) {
			TbPst pst = (TbPst) iter.next();
			if (hasRole(pst, roleId)) {
				result.add(new PstNodeForCheckedbox(pst, true));
			} else {
				result.add(new PstNodeForCheckedbox(pst, false));
			}
		}
		// 从userMgr中找
		for (iter = userMgr.getChildren(parentId).iterator(); iter.hasNext();) {
			TbUser user = (TbUser) iter.next();
			// 判断当前用户是否属于当前角色
			if (hasRole(user, roleId)) {
				result.add(new UserNodeForCheckedbox(user, true));
			} else {
				result.add(new UserNodeForCheckedbox(user, false));
			}
		}
		return result;
	}

	private boolean hasRole(TbPst pst, String roleId) {
		String parentId = pst.getId();
		for (Iterator iter = this.userMgr.getChildren(parentId).iterator(); iter
				.hasNext();) {
			TbUser item = (TbUser) iter.next();
			if (hasRole(item, roleId)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasRole(TbDept dept, String roleId) {
		boolean result = false;
		for (Iterator iter = getChildren(dept.getId()).iterator(); iter
				.hasNext();) {
			Object item = iter.next();
			if (item instanceof TbDept) {
				result = hasRole((TbDept) item, roleId);
				if (result) {
					return result;
				}
			}
			if (item instanceof TbPst) {
				result = hasRole((TbPst) item, roleId);
				if (result) {
					return result;
				}
			}
			if (item instanceof TbUser) {
				result = hasRole((TbUser) item, roleId);
				if (result) {
					return result;
				}
			}
		}
		return result;
	}

	private boolean hasRole(TbUser user, String roleId) {
		Iterator iter = allUserRole.iterator();
		while (iter.hasNext()) {
			TbUserRole userRole = (TbUserRole) iter.next();
			if (userRole.getUserid().equals(user.getId())) {
				return true;
			}
		}
		return false;
	}

	private List getOrgList(TbDept root) {
		List result = new LinkedList();
		String rootId = root.getId();
		// 得到父id为此id的，分别从deptMgr,pstMgr,userMgr中
		getChild(result, rootId);
		return result;
	}

	private void getChild(List result, String parentId) {
		List children = getChildren(parentId);
		if (children.size() > 0) {
			result.addAll(children);
			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				Object item = iter.next();
				if (item instanceof TbDept) {
					getChild(result, ((TbDept) item).getId());
				}
				if (item instanceof TbPst) {
					getChild(result, ((TbPst) item).getId());
				}
				if (item instanceof TbUser) {
					getChild(result, ((TbUser) item).getId());
				}
			}
		}
	}

	/**
	 * 得到给定节点的所有直接子节点
	 * 
	 * @param parentId
	 *            给定节点的id
	 * @return 该节点的所有子节点
	 */
	private List getChildren(String parentId) {
		List result = new LinkedList();
		// 从deptMgr中找
		result.addAll(deptMgr.getChildren(parentId));
		// 从pstMgr中找
		result.addAll(pstMgr.getByDeptId(parentId));
		// 从userMgr中找
		result.addAll(userMgr.getChildren(parentId));
		OrgRightDetailAction orgrightdetail = new OrgRightDetailAction();
		result = orgrightdetail.sortList(result);
		return result;
	}
}
