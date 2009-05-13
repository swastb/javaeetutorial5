package com.baosight.layout.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.layout.*;
import com.baosight.layout.portlet.*;
import com.baosight.layout.table.*;
import com.baosight.mode.TbUser;

public class LayoutAction extends DispatchAction {

	
	

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean bSuccess = true;
		UserEO user = null;
		LayoutEO layout = null;
		HttpSession session = ((HttpServletRequest) request).getSession(true);//获得session
		String userId = ((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getId();//获得session中user的值
		if (userId == null || userId.equals("")) {//如果user的值不存在
			bSuccess = false;
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");//返回login.jsp页面
			dispatcher.forward(request, response);
		} else {//如果user的值存在
			user = new UserEO(userId);//创建UserEO对象
			layout = LayoutEO.getInstance(user);//获得该User的布局设置
		}
		String action = request.getParameter("action");//获得action的值
		if (bSuccess && action != null && action.equals("close")) {//如果等于close,删除该窗口
			String id = request.getParameter("id");
			String side = request.getParameter("side");
			if (side != null && side.equals("right")) {
				String s = layout.getColNarrowRight();
				layout.setColNarrowright(Util.replaceAWithB(s, id, ""));
			} else if (side != null && side.equals("left")) {
				String s = layout.getColNarrowLeft();
				layout.setColNarrowLeft(Util.replaceAWithB(s, id, ""));

			} else if (side != null && side.equals("wide"))
			{
				String s = layout.getColWide();
				layout.setColWide(Util.replaceAWithB(s, id, ""));
			}
			bSuccess = layout.ToDb();
		}else if (bSuccess && action != null && action.equals("change"))//如果等于change,重新保存布局
		{
			String left = request.getParameter("left");//获得左侧布局
			String wide = request.getParameter("wide");//获得中间布局
			String right = request.getParameter("right");//获得右侧布局
			layout.setColNarrowLeft(left);
			layout.setColWide(wide);
			layout.setColNarrowright(right);
			bSuccess = layout.ToDb();//更新数据库
		}else if (bSuccess && action != null && action.equals("add"))//如果等于add,添加新布局
		{
			String id = request.getParameter("id");
			id = id + ",4,2,1";
			String []idList = id.split(",");
			layout.setIdList(idList);
			layout.ToAddDb(userId);//更新数据库		
		}		
		return null;
	}

}
