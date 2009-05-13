package com.baosight.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.mode.DBSY;
import com.baosight.mode.TbAppsys;
import com.baosight.mode.TbDept;
import com.baosight.mode.TbFunction;
import com.baosight.mode.TbUser;

public class SessionNavigationAction extends BaseDispatchAction {
	
	public ActionForward top(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("toptoptoptoptoptoptoptoptop");
		
		HttpSession session = request.getSession();
		String flag = request.getParameter("flag");
		String auto = request.getParameter("auto");	
		String name = request.getParameter("user");
		//TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && !auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/			
			//toMain(mapping,request,response,user.getUserAcc(),user.getPwd());
			return mapping.findForward(flag);
		}else if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/			
			return mapping.findForward(flag);
		}else{
			return mapping.findForward("fail");
		}		
	}
	public ActionForward outlook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("outlookoutlookoutlookoutlookoutlookoutlookoutlookoutlookoutlook");
		HttpSession session = request.getSession();
		String flag = request.getParameter("flag");
		String auto = request.getParameter("auto");
		String name = request.getParameter("user");
		if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && !auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/
			//toMain(mapping,request,response,user.getUserAcc(),user.getPwd());
			return mapping.findForward(flag);
		}else if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/			
			return mapping.findForward(flag);
		}else{
			return mapping.findForward("fail");
		}		
	}	
	public ActionForward right(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("rightrightrightrightrightrightrightright");
		HttpSession session = request.getSession();
		String flag = request.getParameter("flag");
		String auto = request.getParameter("auto");	
		String name = request.getParameter("user");
		if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && !auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/			
			//toMain(mapping,request,response,user.getUserAcc(),user.getPwd());
			return mapping.findForward(flag);
		}else if(flag!=null && !flag.equals("")&& auto!=null && !auto.equals("") && auto.equals("null")){
			/*TbUser user = this.userMgr.findUserByName(name);
			LoginAction loginAction = new LoginAction();
			loginAction.setUserMgr(this.userMgr);
			loginAction.setDeptMgr(this.deptMgr);
			loginAction.setFunctionMgr(this.functionMgr);
			loginAction.toMain(mapping, request, response, user.getUserAcc(),user.getPwd(), "");*/			
			return mapping.findForward(flag);
		}else{
			return mapping.findForward("fail");
		}		
	}
}
