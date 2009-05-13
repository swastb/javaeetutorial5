package com.baosight.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.base.service.IFunctionMgr;
import com.baosight.mode.DBSY;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;
import com.baosight.tools.MD5;

public class AutoLoginAction extends BaseDispatchAction {
	private IFunctionMgr functionMgr;
	
	public IFunctionMgr getFunctionMgr() {
		return functionMgr;
	}


	public void setFunctionMgr(IFunctionMgr functionMgr) {
		this.functionMgr = functionMgr;
	}


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("loginAutoAction111111111111111111111111111111111111");
		String KOAL_CERT_SERIAL_NUMBER = (String)request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER");
		System.out.println("loginAutoActionKOAL_CERT_SERIAL_NUMBER:"+KOAL_CERT_SERIAL_NUMBER);
		String mdName = request.getParameter("loginUser");
		String mdPass = request.getParameter("password");
		try {
			mdName = MD5.decrypt(mdName);
			mdPass = MD5.decrypt(mdPass);
			//mdName = "administrator";
			//mdPass = "admin";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		toMain(mapping,request,response,mdName,mdPass);
		System.out.println("loginAutoAction222222222AAAAAAAAAAAAAAAAAAAAAAAA");
		return mapping.findForward("success");		
/*		System.out.println("loginAutoAction111111111111111111111111111111111111");
		String KOAL_CERT_SERIAL_NUMBER = (String)request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER");
		System.out.println("loginAutoActionKOAL_CERT_SERIAL_NUMBER:"+KOAL_CERT_SERIAL_NUMBER);
		TbUser item = userMgr.checkSSL(KOAL_CERT_SERIAL_NUMBER);
		if(item!=null){
			System.out.println("loginAutoAction2222222222222222222222222222");
			toMain(mapping,request,response,item.getUserAcc(),item.getPwd());
			System.out.println("loginAutoAction222222222AAAAAAAAAAAAAAAAAAAAAAAA");
			return mapping.findForward("success");
		}else{
			System.out.println("loginAutoAction33333333333333333333333333333333");
			return mapping.findForward("fail");
		}*/
	}


	private String passed(String name, String cpwd, String KOAL_CERT_SERIAL_NUMBER) {
		return userMgr.checkUser(name, cpwd, KOAL_CERT_SERIAL_NUMBER);
	}


	public void toMain(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response, String name, String pwd) {
		System.out.println("loginAutoAction44444444444444444444444444");
		// 登录用户写入session
		HttpSession session = request.getSession();
		
		System.out.println("loginAutoAction5555555555555555555555555555");
		String KOAL_CERT_SERIAL_NUMBER = (String)session.getAttribute("KOAL_CERT_SERIAL_NUMBER");
		System.out.println("loginAutoAction6666666666666666666666666666666666");
		
		TbUser user = this.userMgr.findByNameAndPwd(name, pwd);
		System.out.println("loginAutoAction7777777777777777777777777777");
		// TbUser user = this.userMgr.findUserByName(name);
		//取用户所拥有的对信息操作的角色
		List inforolesUserList = this.functionMgr.findInfoRolesUserList(user);
		System.out.println("loginAutoAction888888888888888888888888");
		
		List firstLevelList = this.functionMgr.findFirstLevelRes(user);
		List secondLevelList = null;
		Map functionMap = new HashMap();
		TbFunction tbFunction = new TbFunction();
		for (int i = 0; firstLevelList.size() > 0 && i < firstLevelList.size(); i++) {
			tbFunction = (TbFunction) firstLevelList.get(i);
			secondLevelList = this.functionMgr.findSecondLevelRes(user,
					tbFunction);
			functionMap.put(tbFunction.getId(), secondLevelList);
		}
		System.out.println("loginAutoAction999999999999999999999999");
		if(user!=null && user.getDeptCode()!=null){
			System.out.println("loginAutoActionaaaaaaaaaaaaaaaaaaaaa");
			TbDept dept = this.deptMgr.find(user.getDeptCode());
			System.out.println("loginAutoActionbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			if(dept.getParCode()!=null && !dept.getParCode().equals("")){
				System.out.println("loginAutoActionAAAAAAAAAAAAAAAAAAAAAAAAAA");
				TbDept parDept = this.deptMgr.find(dept.getParCode());
				System.out.println("loginAutoActionBBBBBBBBBBBBBBBBBBBBBBBBBBB");
				if(parDept!=null){
					session.setAttribute("SYSTEM_USER_DEPT_ID", parDept.getId());
					session.setAttribute("SYSTEM_USER_DEPT_NAME", parDept.getName());
				}
				System.out.println("loginAutoActionCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
			}
		}
		System.out.println("loginAutoActionDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		//获取当前用户的待办事宜权限
		if(user!=null){
			Map map = getDBSYAuthInfo(request,user);
			session.setAttribute("SYSTEM_USER_DBSY_AUDIT", map);
		}
	
		session.setAttribute("inforolesUserList", inforolesUserList);
		session.setAttribute("firstLevelList", firstLevelList);
		session.setAttribute("functionMap", functionMap);
		session.setAttribute("SYSTEM_USER_SESSION", user);
		System.out.println("loginAutoActionEWEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		
	}
	/**
	 * 获取待办事宜权限
	 * @param request
	 * @return
	 * @author lqs 2008-09-26
	 */
	public Map getDBSYAuthInfo(HttpServletRequest request,TbUser user){
		Map map = new HashMap();
		HttpSession session = request.getSession();
		if(user!=null){
			//待办事宜信息公开
			DBSY dbsyXXGK = this.functionMgr.getDBSYAuthInfo(user.getId(), functionMgr.DBSYAUDIT_XXGK);
			if(dbsyXXGK!=null){
				map.put(functionMgr.DBSYAUDIT_XXGK, dbsyXXGK);
			}
		}
		return map;
	}	
}
