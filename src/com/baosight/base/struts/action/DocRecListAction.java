package com.baosight.base.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IDocRecListMgr;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;



public class DocRecListAction extends BaseDispatchAction {
	
	/* 取新收到和正处理列表 */
	public ActionForward newAndDisposingList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list1 = this.docRecListMgr.findNewReceiveList(user);
		List list2 = this.docRecListMgr.findDisposingList(user);
		List list = new ArrayList();
		if (list1!=null)
			list.addAll(list1);
		if (list2!=null)
			list.addAll(list2);
		request.setAttribute("size1", list1!=null?list1.size()+"":"0");
		request.setAttribute("size2", list2!=null?list2.size()+"":"0");
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		
		return mapping.findForward("newAndDisposingList");
	}
	/* 新收到的收文 */
	public ActionForward newReceiveList (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list = this.docRecListMgr.findNewReceiveList(user);
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		
		return mapping.findForward("newReceiveList");
	}
	/*正在办理的收文*/
	public ActionForward disposingList (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list = this.docRecListMgr.findDisposingList(user);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		
		return mapping.findForward("disposingList");
	}
	/*可监控的收文*/
	public ActionForward canMonitorList (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list = this.docRecListMgr.findCanMonitorList(user);
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		
		return mapping.findForward("canMonitorList");
	}
	/*已办理的收文*/
	public ActionForward disposedList (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list = this.docRecListMgr.findDisposedList(user);
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		request.setAttribute("isDisposer", isDisposerOrBooker(user.getId(),2)+"");//2代表拟办人，1代表登记人
		
		return mapping.findForward("disposedList");
	}
	/*新起草的收文*/
	public ActionForward bookingList (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		
		List list = this.docRecListMgr.findBookingList(user);
		long count=0;
		count=list.size();
		startPagingCount(null, request,count);
		startPaging(list, null, request);
		request.setAttribute("who", isDisposerOrBooker(user.getId(),3)+"");//3代表拟办人或登记人
		System.out.println("action----who==="+isDisposerOrBooker(user.getId(),3)+"");
		return mapping.findForward("bookingList");
	}
	/*新起草的收文删除*/
	public ActionForward delRecDoc (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		String docId = request.getParameter("docId");
		
		this.docRecListMgr.deleteRecDoc(docId);
		
		return new ActionForward("/docRecListAction.do?method=bookingList");
	}
	/*判断该用户是登记人或拟办人*/
	private boolean isDisposerOrBooker(String userId,int type) {
		return this.docServiceMgr.isDisposerOrBooker(userId,type);
	}
//	分页程序----------------------------------------------------------------------------------------------------
	/*
	 * 当前页面;0~29
	 */
	private int curPage = 0;
	
	/*
	 * 转到;0~30
	 */
	private int moveTo = 0;
	
	/*
	 * 每页的记录数,10~50
	 */
	private int pageSize = 10;
	
	/*
	 * 最大页数
	 */
	private int maxPage = 0;
	


	/**
	 * @return the curPage
	 */
	protected int getCurPage() {
		return curPage;
	}

	/**
	 * @param curPage the curPage to set
	 */
	protected void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * @return the maxPage
	 */
	protected int getMaxPage() {
		return maxPage;
	}

	/**
	 * @param maxPage the maxPage to set
	 */
	protected void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * @return the moveTo
	 */
	protected int getMoveTo() {
		return moveTo;
	}

	/**
	 * @param moveTo the moveTo to set
	 */
	protected void setMoveTo(int moveTo) {
		this.moveTo = moveTo;
	}

	/**
	 * @return the pageSize
	 */
	protected int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数
	 * @param pageSize the pageSize to set
	 */
	protected void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 启动分页
	 * @param res
	 * @param sessionID
	 * @param request
	 * @return 返回的是当前页面的结果集
	 */
	protected void startPagingDocRec(List res, String sessionID, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		//SESSIONID ,为了避免冲突使用Page+时戳
		if(sessionID==null || sessionID.trim().length()<5)
			sessionID = "Page_"+System.currentTimeMillis();
		
		//结果集		
		session.setAttribute(sessionID, res);
		
		//页面大小
		session.setAttribute(sessionID+"Size", getPageSize());
		
		//当前页码
		session.setAttribute(sessionID+"No", getCurPage());
		
		//最大页码
		session.setAttribute(sessionID+"MaxNo", res.size()%pageSize==0?(res.size()/pageSize):res.size()/pageSize+1);
		
		request.setAttribute("sessionID",sessionID);
		
		int lastLoc = getPageSize()*(getCurPage()+1)>res.size()?res.size():getPageSize()*(getCurPage()+1);
		
		List curPageList = res.subList(getPageSize()*getCurPage(), lastLoc);
		
		request.setAttribute("curPageList", curPageList);
	}
	
	/**
	 * 跳到第X页
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward movePageDocRec(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		//首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");
		HttpSession session = request.getSession();
		String pageName = request.getParameter("pageName");
		//转到
		try{
			setMoveTo(Integer.parseInt(request.getParameter("moveTo")));
		}catch(NumberFormatException ex){
		}
		List res = (List)session.getAttribute(sessionID);
		
		try{
			setCurPage((Integer)session.getAttribute(sessionID+"No"));
		}catch(NumberFormatException ex){
		}
		try{
			setMaxPage((Integer)session.getAttribute(sessionID+"MaxNo"));
		}catch(NumberFormatException ex){
		}
		try{
			setPageSize((Integer)session.getAttribute(sessionID+"Size"));
		}catch(NumberFormatException ex){
		}
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		if(getMoveTo()<0 || getMoveTo()>=getMaxPage())
			setMoveTo(0);
		setCurPage(getMoveTo());
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);
		if (pageName==null || "".equals(pageName))
			return mapping.findForward("trunToPage");
		else
			return mapping.findForward(pageName);
	}

	public ActionForward resetPageSizeDocRec(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");
		HttpSession session = request.getSession();
		String pageName = request.getParameter("pageName");
		//转到
		setMoveTo(0);
		List res = (List)session.getAttribute(sessionID);
		setCurPage(0);
		try{
			setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		}catch(NumberFormatException ex){
		}
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);
		if (pageName==null || "".equals(pageName))
			return mapping.findForward("trunToPage");
		else
			return mapping.findForward(pageName);
	}
}