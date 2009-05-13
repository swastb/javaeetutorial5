package com.baosight.infocenter.docsend.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.baosight.infocenter.docsend.mode.TbDocSendXxzx;
import com.baosight.infocenter.docsend.service.IDocSendDealMgr;
import com.baosight.mode.TbUser;

public class DocSendRelatedAction extends DocSendHelper {
	
	private static final String NEW_GETING = "1";//1新收到的发文
	private static final String DOING = "2";     //2正在处理的发文

	//发文列表
	public ActionForward docSendList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String type = (String)request.getParameter("type");
		
		List list = new ArrayList();
		if ("newAndDoing".equals(type)) {
			List list1 = this.docSendDealXxzxMgr.findDocSendList(user,NEW_GETING);//1新收到的发文
			List list2 = this.docSendDealXxzxMgr.findDocSendList(user,DOING);//2正在处理的发问
			
			if (list1!=null)
				list.addAll(list1);
			if (list2!=null)
				list.addAll(list2);
			request.setAttribute("size1", list1!=null?list1.size():0);
			request.setAttribute("size2", list2!=null?list2.size():0);
		}
		else {	
			list = this.docSendDealXxzxMgr.findDocSendList(user,type);
		}
		//request.setAttribute("list", list);
		request.setAttribute("type", type);
		startPaging(list, null, request);
		return mapping.findForward("docSendList");
	}

	/*新起草的发文删除*/
	public ActionForward delSendDoc (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String docId = request.getParameter("docId");
		
		this.docSendDealXxzxMgr.deleteSendDoc(docId);
		
		return new ActionForward("/xdocSendRelatedAction.do?method=docSendList&type=3");
	}
	/* 催办通知 */
	public ActionForward argueNoticeInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String docId = request.getParameter("docId");	
		//String docTitle = request.getParameter("docTitle");
		
		List userList = this.docSendDealXxzxMgr.findPersonByDocId(docId);//找被催办的相关人
		
		request.setAttribute("userList", userList);
		
		return mapping.findForward("argueNoticeS");
	}

	/* 取回 */
	public ActionForward rollBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String docId = request.getParameter("docId");
		String closetime = request.getParameter("closetime");
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		boolean iscanback = this.docSendDealXxzxMgr.isCanRollBack(docId,closetime);
		if (iscanback)
			this.docSendDealXxzxMgr.docSendRollBack(docId,user);
			
		return new ActionForward("/xdocSendRelatedAction.do?method=docSendList&type=2");
	}

	/**
	 * <p>Decription:选择部门领导</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public ActionForward toDeptLeader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = getCurrentUser(request);
		//选择用户列表
		List userList = this.docSendDealXxzxMgr.findUserByRoleList(IDocSendDealMgr.DEPTLEADER,user);
		request.setAttribute("userList", userList);
		return mapping.findForward("chargerLeader");
	}

	/**
	 * <p>Decription:选择领导</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-9-25</p>
	 */
	public ActionForward toLeader(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//选择用户列表
		List userList = this.docSendDealXxzxMgr.findUserByRoleList(IDocSendDealMgr.LEADER,null);
		request.setAttribute("userList", userList);
		return mapping.findForward("chargerLeader");
	}

	/**
	 * <p>Decription:查看只读页面</p>
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @author heaton.cai
	 * <p>Create Time:2008-8-18</p>
	 */
	public ActionForward docSendView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String docId = request.getParameter("docId");
		TbDocSendXxzx item = docSendMgr.findById(docId);
		setBaseInfo((DynaActionForm) form,null,item);
		putCommonInfo(request,item);
		return mapping.findForward("docSendView");
	}

	/*驳回*/
	public ActionForward turnback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String docId = request.getParameter("docId");
		request.setAttribute("fileTitle", docSendMgr.findById(docId).getFileTitle());
		request.setAttribute("sclzdList", docSendMgr.findClosedControl(docId));
		return mapping.findForward("turnback");
	}
}