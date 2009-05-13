package com.baosight.base.struts.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

/**
 * 进入论坛
 * @author Tong.Cai
 * <p>Create Time:2008-07-25</p>
 */
public class ForumsAction extends BaseDispatchAction {

	public ActionForward goForums(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		TbUser user = (TbUser)request.getSession().getAttribute("SYSTEM_USER_SESSION");
		try {
			if(user == null){
				response.getWriter().println("用户没有登陆！");
				return null;
			}
			String url = "/JForum/jforum.page?module=user&action=validateLogin&username="
				+ user.getUserAcc() + "&password=" + user.getPwd();
			System.out.println("url:"+url);
			response.sendRedirect(url);
			System.out.println("login success!");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}
