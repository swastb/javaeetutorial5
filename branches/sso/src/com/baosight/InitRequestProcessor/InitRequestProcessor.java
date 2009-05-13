package com.baosight.InitRequestProcessor;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.RequestProcessor;

import com.baosight.mode.TbUser;

public class InitRequestProcessor extends RequestProcessor {
	public static List notNeedCheckList = null;

	public List notNeedSessionList = null;

	public static Logger log = Logger.getLogger(InitRequestProcessor.class
			.getName());

	protected boolean processPreprocess(HttpServletRequest _request,
			HttpServletResponse _response) {
		try {
			String ca = _request.getParameter("ca");
			String path = processPath(_request, _response);
			HttpSession session = _request.getSession();
			String certValue = (String)_request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER");
			System.out.println("KOAL_CERT_SERIAL_NUMBER:-----------------"+certValue);
		    String KOAL_CERT_SERIAL_NUMBER = "";
		    String VALUE = "";
			if(certValue==null || certValue.equals("")){
				Cookie[] cookies = _request.getCookies();
			    if(cookies == null)
			        cookies = new Cookie[0];
			    for(int i = 0; i < cookies.length; i ++)
			    {
			        Cookie cookie = cookies[i];
			        if("KOAL_CERT_SERIAL_NUMBER".equals(cookie.getName()))
			        {
			        	KOAL_CERT_SERIAL_NUMBER = "证书序列号：";
			        	VALUE = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
			        	break;
			        }else{
			        	continue;
			        }
			    }
			    _request.getSession().setAttribute("KOAL_CERT_SERIAL_NUMBER", VALUE);
			    System.out.println("session:----------"+_request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER"));
			}else{
				_request.getSession().setAttribute("KOAL_CERT_SERIAL_NUMBER", certValue);
			}
			
			TbUser us = (TbUser) _request.getSession().getAttribute(
					requestConstants.SYSTEM_USER_SESSION);

			if (notNeedSession().contains(path)) {
				System.out.println("0000000000000000000000000000000000000000000000");
				if(path!=null && !path.equals("")){
					/*if(path.equals("/login")){
						String temCert = (String)_request.getSession().getAttribute("KOAL_CERT_SERIAL_NUMBER");
						System.out.println("11111111111111111111111111111111111111111111111");
						if(temCert!=null && !temCert.equals("") && ca==null){
								System.out.println("SSL自动登录");
								System.out.println("222222222222222222222222222222222222222222");
								getServletContext().getRequestDispatcher("/login.do?ca=true")
								.forward(_request, _response);	
								return false;
						}
						System.out.println("33333333333333333333333333333333333333333333333333");
					}
					System.out.println("4444444444444444444444444444444444444444444444444");*/
					/*if((us == null) && (path.equals("/applyaction") || path.equals("/govern") || path.equals("/infopubContentaction"))){
						getServletContext().getRequestDispatcher("/index.jsp")
						.forward(_request, _response);
						return false;
					}*/					
				}
				return true;
			} else if (notNeedSession().contains(path) == false) {
				if (us == null) {
					_request.setAttribute("loginFlag", "timeout");
					getServletContext().getRequestDispatcher("https://31.16.1.30/sso")
							.forward(_request, _response);
					/*getServletContext().getRequestDispatcher("/index.jsp")
					.forward(_request, _response);	*/				
					System.out.println("666666666666666666666666666666666666");
					return false;
				}			
				/*if(certValue==null && certValue.equals("")){
					_request.setAttribute("loginFlag", "timeout");
					getServletContext().getRequestDispatcher("/index.jsp")
							.forward(_request, _response);
					return false;
				}else{
					if (us == null) {
						_request.setAttribute("loginFlag", "timeout");
						getServletContext().getRequestDispatcher("/index.jsp")
								.forward(_request, _response);
						return false;
					}
				}*/
				return true;
			}

		} catch (Exception e) {
			try {
				_request.setAttribute("loginFlag", "timeout");
				getServletContext().getRequestDispatcher("https://31.16.1.30/sso")
						.forward(_request, _response);
				/*getServletContext().getRequestDispatcher("/index.jsp")
				.forward(_request, _response);*/
//				getServletContext().getRequestDispatcher("/loginoutAction.do")
//				.forward(_request, _response);
			} catch (Exception e1) {

			}
			return false;
		}
		return true;
	}

	protected List notNeedSession() throws Exception {
		if (notNeedSessionList != null) {
			return notNeedSessionList;
		}
		notNeedSessionList = new ArrayList();
		notNeedSessionList.add("/login");
		notNeedSessionList.add("/loginSSL");
		notNeedSessionList.add("/applyaction");
		notNeedSessionList.add("/govern");
		notNeedSessionList.add("/infopubContentaction");
		notNeedSessionList.add("/yuanshuishujubiaoaction");
		notNeedSessionList.add("/sessionNavigation");
		notNeedSessionList.add("/autologin");
//		notNeedSessionList.add("/loginoutAction");
		return notNeedSessionList;
	}

}