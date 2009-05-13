package com.baosight.base.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.IInfoPubClaMgr;
import com.baosight.base.service.IInfoPubContentMgr;
import com.baosight.struts.action.BaseDispatchAction;

public class InfoPubHelperAction extends BaseDispatchAction{
	/**
	 * 信息发布内容
	 */
	protected IInfoPubContentMgr infoPubContentMgr;
	/**
	 * 信息发布栏目
	 */
	protected IInfoPubClaMgr infoPubClaMgr;
	public void setInfoPubClaMgr(IInfoPubClaMgr infoPubClaMgr) {
		this.infoPubClaMgr = infoPubClaMgr;
	}

	public void setInfoPubContentMgr(IInfoPubContentMgr infoPubContentMgr) {
		this.infoPubContentMgr = infoPubContentMgr;
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
	protected void startPagingInfo(List res, String sessionID, HttpServletRequest request){
		
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
	public ActionForward movePageInfo(ActionMapping mapping, ActionForm form,
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
		if(getMoveTo()<0 || getMoveTo()>=getMaxPage())
			setMoveTo(0);
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		setCurPage(getMoveTo());
		startPagingCount(null, request,count);
		startPaging(res, sessionID, request);
		if (pageName==null || "".equals(pageName))
			return mapping.findForward("trunToPage");
		else
			return mapping.findForward(pageName);
	}

	public ActionForward resetPageSizeInfo(ActionMapping mapping, ActionForm form,
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
		startPagingCount(null, request,count);
		startPaging(res, sessionID, request);
		if (pageName==null || "".equals(pageName))
			return mapping.findForward("trunToPage");
		else
			return mapping.findForward(pageName);
	}
	
}