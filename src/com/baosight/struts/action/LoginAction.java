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
import com.baosight.mode.TbUserdept;

public class LoginAction extends BaseDispatchAction {

	private static final String DEPTID_JUOA = "b205f4e34f4f4d2da5bd89e2e10af37a";//局OA
	private static final String DEPTID_FXZHHB = "9f9083fd1930d442011930ebcf52000b";//防汛指挥部
	//private static final String DEPTID_XXZX = "";//信息中心
	//private static final String DEPTID_SLZX = "";//受理中心
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String ca = request.getParameter("ca");
		String cert = request.getParameter("cert");
		String KOAL_CERT_SERIAL_NUMBER = (String)request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER");
		System.out.println("------------------------------ca:"+ca);
		String mappingUrl = "";
		String key = request.getParameter("goto");
		TbAppsys tbAppsys = appSysMgr.getUrlByCode(key);		
		if(cert!=null && !cert.equals("")&& ca!=null && ca.equals("true")){
			String mdName = "";
			String mdPass = "";
			TbUser item = userMgr.checkSSL(cert);
			if(item!=null){
				mdName = item.getUserAcc();
				mdPass = item.getPwd();
			}else{
				return new ActionForward("index.jsp");
			}
			toMain(mapping, request, response, mdName,mdPass, "");
			request.getSession().setAttribute("keyLogin", "true");
			String loginType = request.getParameter("loginType");
			request.setAttribute("loginType", loginType);
			request.getSession().setAttribute("keyPassword", request.getParameter("keyPassword"));
			return mapping.findForward("success");		
		}		

		// 取得登录系统标示key
		// key=1 为登录sso
		// 否则为登录其他子系统
		if (key == null || key.equals("") || key.equals("null")) {
			TbAppsys root = getMappingUrl("1");
			if (root != null && !root.getUrl().equals("")) {
				mappingUrl = root.getUrl();
			}
			key = "1";
		}	
			
		
		DynaActionForm userForm = (DynaActionForm) form;
		// from cokie
		Cookie[] cookies = request.getCookies();
		String cName = "";
		String cPWD = "";
		// key=1 取cookies中sso用户的cookies
		if (cookies != null && key != null && !key.equals("1")) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie item = cookies[i];
				if (item.getName().equals("loginUserForSL")) {
					// 得到用户名
					cName = item.getValue();
				}
				if (item.getName().equals("passwordForSL")) {
					cPWD = item.getValue();
				}
			}
		}
		// 受理中心 取cookies中受理中心用户的cookies
		if (cookies != null && key != null && key.equals("1")) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie item = cookies[i];
				if (item.getName().equals("loginUserForSSO")) {
					// 得到用户名
					cName = item.getValue();
				}
				if (item.getName().equals("passwordForSSO")) {
					cPWD = item.getValue();
				}
			}
		}
		// sso 登录时始终通过登录页面
		// 首先判断cookie 如果cookie中不存在，则从表单中取用户名、密码进行验证，验证通过写入sso用户的cookie
		// cookie中存在，首先验证cookie中的sso 用户
		// 验证通过 再判断表单上的用户名是否和cookie中相同
		// 不相同，则验证表单上的用户名、密码 通过了重写sso的cookie 即覆盖原有用户的cookie
		// 相同， 则判断表单上的用户名、密码是否和cookie中相同 相同则为同一用户，直接登录
		if (key != null && key.equals("1")) {
			// cookie中找到，进行验证
			if ((cName != null && cName.equals(""))
					|| (cPWD != null && cPWD.equals(""))) {
				String fUser = "";
				String fPassword = "";
				fUser = userForm.getString("loginUser");
				fPassword = userForm.getString("password");
//				if(fUser!=null && fPassword!=null){
				if (!fUser.equals("")) {
					//String str = passed(fUser, fPassword, key);
					String str = passed(fUser, fPassword, KOAL_CERT_SERIAL_NUMBER);
					if ("loginIn".equals(str)) {
						// 如果通过验证，写cookie

						Cookie c = new Cookie("loginUserForSSO", fUser);
						c.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(c);
						Cookie pass = new Cookie("passwordForSSO", fPassword);
						pass.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(pass);

						// 跳转
						if (tbAppsys != null) {
							doRedirect(mapping, response, key, mappingUrl,
									fUser, fPassword, tbAppsys, request);
						} else {
							toMain(mapping, request, response, fUser,
									fPassword, mappingUrl);
							String loginType = request
									.getParameter("loginType");
							request.setAttribute("loginType", loginType);
							HttpSession session = request.getSession();
							session.setAttribute("loginType", loginType);
							ActionForward forward = new ActionForward();
							forward.setPath(mappingUrl);
							return mapping.findForward("success");
						}
						return null;
					} else {
						String loginType = request.getParameter("loginType");
						if (loginType != null && loginType.equals("1")) {
							request.setAttribute("loginFlag", str);
							return mapping.findForward("fail1");
						} else if (loginType != null && loginType.equals("2")) {
							request.setAttribute("loginFlag", str);
							return mapping.findForward("fail2");
						} else if (loginType != null && loginType.equals("3")) {
							request.setAttribute("loginFlag", str);
							return mapping.findForward("fail3");
						} else {
							request.setAttribute("loginFlag", str);
							return mapping.findForward("fail");
						}
					}
				}
			} else {
				//String cStr = passed(cName, cPWD, key);
				String cStr = passed(cName, cPWD, KOAL_CERT_SERIAL_NUMBER);
				if ("loginIn".equals(cStr)) {
					// 验证通过，页面跳转至URL
					String fUser = "";
					String fPassword = "";
					fUser = userForm.getString("loginUser");
					fPassword = userForm.getString("password");

					// // key=1 登录sso
					// if (key != null && key.equals("1")) {

					// 验证表单上的用户名是否已存在于cookie
					// 是 直接登录
					// 否 验证，成功重写cookie
					if (!fUser.equals(cName) && !fPassword.equals(cPWD)) {
						//String str = passed(fUser, fPassword, key);
						String str = passed(fUser, fPassword, KOAL_CERT_SERIAL_NUMBER);
						if ("loginIn".equals(str)) {
							// 如果通过验证，写cookie

							Cookie c = new Cookie("loginUserForSSO", fUser);
							c.setMaxAge(24 * 60 * 60 * 1000);
							response.addCookie(c);
							Cookie pass = new Cookie("passwordForSSO",
									fPassword);
							pass.setMaxAge(24 * 60 * 60 * 1000);
							response.addCookie(pass);

							if (tbAppsys != null) {
								doRedirect(mapping, response, key, mappingUrl,
										fUser, fPassword, tbAppsys, request);
							} else {
								toMain(mapping, request, response, fUser, fPassword,
										mappingUrl);
								String loginType = request
										.getParameter("loginType");
								request.setAttribute("loginType", loginType);
								HttpSession session = request.getSession();
								session.setAttribute("loginType", loginType);
								ActionForward forward = new ActionForward();
								forward.setPath(mappingUrl);
								return mapping.findForward("success");
							}
							return null;

						} else {
							String loginType = request
									.getParameter("loginType");
							if (loginType != null && loginType.equals("1")) {
								request.setAttribute("loginFlag", str);
								return mapping.findForward("fail1");
							} else if (loginType != null
									&& loginType.equals("2")) {
								request.setAttribute("loginFlag", str);
								return mapping.findForward("fail2");
							} else if (loginType != null
									&& loginType.equals("3")) {
								request.setAttribute("loginFlag", str);
								return mapping.findForward("fail3");
							} else {
								request.setAttribute("loginFlag", str);
								return mapping.findForward("fail");
							}
						}

					}
					if (fUser.equals(cName) && fPassword.equals(cPWD)) {
						if (tbAppsys != null) {
							doRedirect(mapping, response, key, mappingUrl,
									cName, cPWD, tbAppsys, request);
						} else {
							String loginType = request
									.getParameter("loginType");
							request.setAttribute("loginType", loginType);
							HttpSession session = request.getSession();
							session.setAttribute("loginType", loginType);
							toMain(mapping, request, response, cName, cPWD,
									mappingUrl);
							return mapping.findForward("success");
						}
						return null;
					} else {
						String loginType = request.getParameter("loginType");
						if (loginType != null && loginType.equals("1")) {
							request.setAttribute("loginFlag", cStr);
							return mapping.findForward("fail1");
						} else if (loginType != null && loginType.equals("2")) {
							request.setAttribute("loginFlag", cStr);
							return mapping.findForward("fail2");
						} else if (loginType != null && loginType.equals("3")) {
							request.setAttribute("loginFlag", cStr);
							return mapping.findForward("fail3");
						} else {
							request.setAttribute("loginFlag", cStr);
							return mapping.findForward("fail");
						}
					}
					// } else {// 通过登录sso之后再登录子系统，
					// doRedirect(response, key, mappingUrl, cName, cPWD,
					// tbAppsys, request);
					// return null;
					// }

				} else {
					request.setAttribute("loginFlag", cStr);
					return mapping.findForward("fail");
				}
			}

		} else {
			// 不为sso 系统 受理中心
			// 首先验证cookie
			// cookie为空，去表单上用户名、密码进行验证。通过写入受理中心用户cookie
			// cookie不为空，成功登录
			if ((cName != null && cName.equals(""))
					|| (cPWD != null && cPWD.equals(""))) {
				// cookie中没有，从form中找
				String fUser = "";
				String fPassword = "";

				// if(key!=null && key.equals("1"))
				// {
				fUser = userForm.getString("loginUser");
				fPassword = userForm.getString("password");
				if (!fUser.equals("") && !fPassword.equals("")) {
					//String str = passed(fUser, fPassword, key);
					String str = passed(fUser, fPassword, KOAL_CERT_SERIAL_NUMBER);
					if ("loginIn".equals(str)) {
						// 如果通过验证，写cookie

						Cookie c = new Cookie("loginUserForSL", fUser);
						c.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(c);
						Cookie pass = new Cookie("passwordForSL", fPassword);
						pass.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(pass);

						// 跳转
						if (tbAppsys != null) {
							doRedirect(mapping, response, key, mappingUrl,
									fUser, fPassword, tbAppsys, request);
						} else {
							toMain(mapping, request, response, fUser,
									fPassword, mappingUrl);
							ActionForward forward = new ActionForward();
							forward.setPath(mappingUrl);
							return mapping.findForward("success");
						}
						return null;
					} else {
						if (key.equals("6")) {
							return new ActionForward(
									"http://31.16.1.7/fx/zb/loginIndexDo.jsp?result=fail&loginUser="+fUser, true);
						} else {
							request.setAttribute("loginFlag", str);
							return mapping.findForward("fail");
						}
					}
				}
			} else {
				//是防汛值班
				if(key!=null && !key.equals("") && key.equals("6")){
					String fUser = "";
					String fPassword = "";
					fUser = userForm.getString("loginUser");
					fPassword = userForm.getString("password");
					if (!fUser.equals("") && !fPassword.equals("")) {
						//String str = passed(fUser, fPassword, key);
						String str = passed(fUser, fPassword, KOAL_CERT_SERIAL_NUMBER);
						if ("loginIn".equals(str)) {
							// 如果通过验证，写cookie

							Cookie c = new Cookie("loginUserForSL", fUser);
							c.setMaxAge(24 * 60 * 60 * 1000);
							response.addCookie(c);
							Cookie pass = new Cookie("passwordForSL", fPassword);
							pass.setMaxAge(24 * 60 * 60 * 1000);
							response.addCookie(pass);

							// 跳转
							if (tbAppsys != null) {
								doRedirect(mapping, response, key, mappingUrl,
										fUser, fPassword, tbAppsys, request);
							} else {
								toMain(mapping, request, response, fUser,
										fPassword, mappingUrl);
								ActionForward forward = new ActionForward();
								forward.setPath(mappingUrl);
								return mapping.findForward("success");
							}
							return null;
						} else {
							return new ActionForward("http://31.16.1.7/fx/zb/loginIndexDo.jsp?result=fail&loginUser="+fUser, true);
						}
					}					
				}else{
					//不是防汛值班
					//String cStr = passed(cName, cPWD, key);
					String cStr = passed(cName, cPWD, KOAL_CERT_SERIAL_NUMBER);
					if ("loginIn".equals(cStr)) {
						// 验证通过，页面跳转至URL
						/*
						 * String fUser = ""; String fPassword = ""; fUser =
						 * userForm.getString("loginUser"); fPassword =
						 * userForm.getString("password"); // 验证表单上的用户名是否已存在于cookie //
						 * 是 直接登录 // 否 验证，成功重写cookie if (!fUser.equals(cName)) {
						 * String str = passed(fUser, fPassword, key); if
						 * ("loginIn".equals(str)) {
						 */// 如果通过验证，写cookie
						Cookie c = new Cookie("loginUserForSL", cName);
						c.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(c);
						Cookie pass = new Cookie("passwordForSL", cPWD);
						pass.setMaxAge(24 * 60 * 60 * 1000);
						response.addCookie(pass);

						if (tbAppsys != null) {
							doRedirect(mapping, response, key, mappingUrl, cName,
									cPWD, tbAppsys, request);
						} else {
							toMain(mapping, request, response, cName, cPWD,
									mappingUrl);
							ActionForward forward = new ActionForward();
							forward.setPath(mappingUrl);
							return mapping.findForward("success");
						}
						return null;

						/*
						 * } else { request.setAttribute("loginFlag", str); return
						 * mapping.findForward("fail"); } } if (fUser.equals(cName) &&
						 * fPassword.equals(cPWD)) { doRedirect(response, key,
						 * mappingUrl, cName, cPWD, tbAppsys, request); return null; }
						 */

					} else {
						request.setAttribute("loginFlag", cStr);
						return mapping.findForward("fail");					
					}
				}
			}
		}
		try {
			TbAppsys root = getMappingUrl("0");
			if (root != null && !root.getUrl().equals("")) {
				// request.setAttribute("loginFlag", "false");
				response.sendRedirect(root.getUrl() + "?goto=" + key);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private void doRedirect(ActionMapping mapping,
			HttpServletResponse response, String key, String mappingUrl,
			String name, String pwd, TbAppsys tbAppsys,
			HttpServletRequest request) {
		// isChild==1为子系统
		if (tbAppsys != null) {
			Integer isChild = Integer.valueOf(tbAppsys.getIschild().toString());
			if (isChild != null && isChild == 1) {
				if (tbAppsys.getCode().equals("6")) {
					mappingUrl += tbAppsys.getUrl() + "?result=succes&logName="
							+ name;
				} else {
					mappingUrl += tbAppsys.getUrl() + "?logName=" + name
							+ "&password=" + pwd;
				}
				try {
					response.sendRedirect(mappingUrl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else {
				try {
					response.sendRedirect(tbAppsys.getUrl());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private String passed(String name, String cpwd, String KOAL_CERT_SERIAL_NUMBER) {
		return userMgr.checkUser(name, cpwd, KOAL_CERT_SERIAL_NUMBER);
	}

	private TbAppsys getMappingUrl(String key) {
		return appSysMgr.getUrlByCode(key);
	}

	public void toMain(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response, String name, String pwd,
			String mappingUrl) {
		// 登录用户写入session
		HttpSession session = request.getSession();
		
		String KOAL_CERT_SERIAL_NUMBER = (String)session.getAttribute("KOAL_CERT_SERIAL_NUMBER");
		TbUser user = this.userMgr.findByNameAndPwd(name, pwd);
		//		GCL MOD 2008-11-25 start
		boolean isfxzhb = false;
		if (DEPTID_JUOA.equals(user.getUserdept()))
			isfxzhb = this.userMgr.isForDeptOfUser (user, DEPTID_FXZHHB);
		request.setAttribute("ISFXZHB", isfxzhb);
		//session.setAttribute("ISFXZHB", isfxzhb);
		//GCL MOD 2008-11-25 end
		// TbUser user = this.userMgr.findUserByName(name);
		//取用户所拥有的对信息操作的角色
		List inforolesUserList = this.functionMgr.findInfoRolesUserList(user);
		
		List firstLevelList = this.functionMgr.findFirstLevelRes(user);
		List secondLevelList = null;
		Map functionMap = new HashMap();
		TbFunction tbFunction = new TbFunction();
		List<TbFunction> firstLevelListT = new ArrayList();
		int firstSize = firstLevelList.size();
		for (int i = 0; firstSize > 0 && i < firstSize; i++) {
			tbFunction = (TbFunction) firstLevelList.get(i);
			secondLevelList = this.functionMgr.findSecondLevelRes(user,
					tbFunction);
			if (secondLevelList.size()!=0) {
				firstLevelListT.add(tbFunction);
			}
		}
		int temp = firstLevelListT.size();
		for (int i = 0; temp > 0 && i < temp; i++) {
			tbFunction = (TbFunction) firstLevelListT.get(i);
			secondLevelList = this.functionMgr.findSecondLevelRes(user,
					tbFunction);
			functionMap.put(tbFunction.getId(), secondLevelList);
		}
		
		System.out.println("------------------------user--------------------------------"+user);
		System.out.println("------------------------getDeptCode--------------------------------"+user.getDeptCode());
		if(user!=null && user.getDeptCode()!=null){
			TbDept dept = this.deptMgr.find(user.getDeptCode());
			if(dept.getParCode()!=null && !dept.getParCode().equals("")){
				TbDept parDept = this.deptMgr.find(dept.getParCode());
				if(parDept!=null){
					session.setAttribute("SYSTEM_USER_DEPT_ID", parDept.getId());
					session.setAttribute("SYSTEM_USER_DEPT_NAME", parDept.getName());
				}
			}
		}
//		//获取用户部门名称
//		if(user!=null && user.getUserdept()!=null){
//			TbUserdept tbUserdept = this.iTbUserMgr.findByUserId(user.getUserdept());
//			if(tbUserdept !=null && tbUserdept.getId()!=null){
//				session.setAttribute("SYSTEM_USER_USERDEPT_SESSION", tbUserdept);
//			}
//		}
		//获取当前用户的待办事宜权限
		if(user!=null){
			getDBSYAuthInfo(request,user);
		}
		
		session.setAttribute("inforolesUserList", inforolesUserList);
		session.setAttribute("firstLevelList", firstLevelListT);
		session.setAttribute("functionMap", functionMap);
		session.setAttribute("SYSTEM_USER_SESSION", user);
		
		//添加当前用户个性化定制信息
		if(user!=null){
			String sql = this.functionMgr.getPersonalInfo(user);
			session.setAttribute("SYSTEM_USER_PERSONALINFO", sql);
			TbUserdept userDept = this.userMgr.findUserDeptByUserId(user.getId());
			if(userDept!=null){
				session.setAttribute("SYSTEM_USER_PERSONALINFO_DEPT", userDept.getName());
			}
		}
	}
	public ActionForward forwordSSL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		AutoLoginAction a  = new AutoLoginAction();
		a.setUserMgr(this.userMgr);
		a.setFunctionMgr(this.functionMgr);
		a.setDeptMgr(this.deptMgr);
		a.setServlet(this.servlet);
		ActionForward  forward = a.execute(mapping, form, request, response);
		return forward;
	}
	/**
	 * 获取待办事宜权限
	 * @param request
	 * @return
	 * @author lqs 2008-09-26
	 */
	public void getDBSYAuthInfo(HttpServletRequest request,TbUser user){
		if(user!=null){
			//待办事宜信息公开
			getDBSYByFunKey(user,functionMgr.DBSYAUDIT_XXGK,request);
			//车辆
			getDBSYByFunKey(user,functionMgr.DBSY_VEHICLE,request);
//			行政许可
			getDBSYByFunKey(user,functionMgr.DBSY_ADMINISTRAT,request);
//			我的邮件
			getDBSYByFunKey(user,functionMgr.DBSY_MYMAIL,request);
//			文件传送
			getDBSYByFunKey(user,functionMgr.DBSY_FILETRANSMISSION,request);
//			档案管理
			getDBSYByFunKey(user,functionMgr.DBSY_ARCHIVES,request);
//			我的短信
			getDBSYByFunKey(user,functionMgr.DBSY_MYMESSAGE,request);
//			网上咨询
			getDBSYByFunKey(user,functionMgr.DBSY_COUNSULT,request);
//			网上咨询专办
			getDBSYByFunKey(user,functionMgr.DBSY_COUNSULTZB,request);
//			网上咨询待领导审批
			getDBSYByFunKey(user,functionMgr.DBSY_COUNSULTLEADAPPROVE,request);
//			网上投诉
			getDBSYByFunKey(user,functionMgr.DBSY_APPEAL,request);
//			网上投诉专办
			getDBSYByFunKey(user,functionMgr.DBSY_APPEALZB,request);
//			网上投诉待领导审批
			getDBSYByFunKey(user,functionMgr.DBSY_APPEALLEADAPPROVE,request);
//			局长信箱待办
			getDBSYByFunKey(user,functionMgr.DBSY_DIRECTORWAIT,request);
//			局长信箱转办
			getDBSYByFunKey(user,functionMgr.DBSY_DIRECTORZB,request);
//			局长信箱待领导审批
			getDBSYByFunKey(user,functionMgr.DBSY_DIRECTORLEADAPPROVE,request);
//			行政许可抄送
			getDBSYByFunKey(user,functionMgr.DBSY_XZXK_CC,request);		
//			行政许可催办
			getDBSYByFunKey(user,functionMgr.DBSY_XZXK_Urger,request);		
//			委托管理委托
			getDBSYByFunKey(user,functionMgr.DBSY_XZXK_Commission,request);				
		}
	}
	public void getDBSYByFunKey(TbUser user,String funKey,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map map = (Map)session.getAttribute("SYSTEM_USER_DBSY");
		DBSY dbsy = this.functionMgr.getDBSYAuthInfo(user.getId(), funKey);
		if(dbsy!=null){
			if(map==null){
				map = new HashMap();
				map.put(funKey, dbsy);
			}else{
				map.put(funKey, dbsy);
			}
			session.setAttribute("SYSTEM_USER_DBSY", map);
		}
	}
	
}
