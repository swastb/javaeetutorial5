package com.baosight.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.struts.action.BaseDispatchAction;

/**
 * <p>Decription:ÓÃ»§Ê÷</p>
 * @author heaton.cai
 * <p>Create Time:2008-10-28</p>
 */
public class UserTreeAction extends BaseDispatchAction {

	public ActionForward input(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String rootDeptId = request.getParameter("rootId");
		if(rootDeptId==null || "".equals(rootDeptId)){
			rootDeptId = "e584b88cc02f49c0b0da6db657f8fd83";
		}
		List deptList = deptMgr.find4Tree(rootDeptId);
		List userList = userMgr.find4Tree(rootDeptId);
		if(deptList!=null && deptList.size()>0){
			request.setAttribute("root", deptList.remove(0));
			request.setAttribute("deptList", deptList);
			request.setAttribute("userList", userList);
		}
		return mapping.findForward("input");
	}

}
