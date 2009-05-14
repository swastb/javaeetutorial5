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
	 * ��Ϣ��������
	 */
	protected IInfoPubContentMgr infoPubContentMgr;
	/**
	 * ��Ϣ������Ŀ
	 */
	protected IInfoPubClaMgr infoPubClaMgr;
	public void setInfoPubClaMgr(IInfoPubClaMgr infoPubClaMgr) {
		this.infoPubClaMgr = infoPubClaMgr;
	}

	public void setInfoPubContentMgr(IInfoPubContentMgr infoPubContentMgr) {
		this.infoPubContentMgr = infoPubContentMgr;
	}
//	��ҳ����----------------------------------------------------------------------------------------------------
	/*
	 * ��ǰҳ��;0~29
	 */
	private int curPage = 0;
	
	/*
	 * ת��;0~30
	 */
	private int moveTo = 0;
	
	/*
	 * ÿҳ�ļ�¼��,10~50
	 */
	private int pageSize = 10;
	
	/*
	 * ���ҳ��
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
	 * ����ÿҳ�ļ�¼��
	 * @param pageSize the pageSize to set
	 */
	protected void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * ������ҳ
	 * @param res
	 * @param sessionID
	 * @param request
	 * @return ���ص��ǵ�ǰҳ��Ľ����
	 */
	protected void startPagingInfo(List res, String sessionID, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		//SESSIONID ,Ϊ�˱����ͻʹ��Page+ʱ��
		if(sessionID==null || sessionID.trim().length()<5)
			sessionID = "Page_"+System.currentTimeMillis();
		
		//�����		
		session.setAttribute(sessionID, res);
		
		//ҳ���С
		session.setAttribute(sessionID+"Size", getPageSize());
		
		//��ǰҳ��
		session.setAttribute(sessionID+"No", getCurPage());
		
		//���ҳ��
		session.setAttribute(sessionID+"MaxNo", res.size()%pageSize==0?(res.size()/pageSize):res.size()/pageSize+1);
		
		request.setAttribute("sessionID",sessionID);
		
		int lastLoc = getPageSize()*(getCurPage()+1)>res.size()?res.size():getPageSize()*(getCurPage()+1);
		
		List curPageList = res.subList(getPageSize()*getCurPage(), lastLoc);
		
		request.setAttribute("curPageList", curPageList);
	}
	
	/**
	 * ������Xҳ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward movePageInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		//���Ȼ��SESSIONID
		String sessionID = request.getParameter("sessionID");
		HttpSession session = request.getSession();
		String pageName = request.getParameter("pageName");
		//ת��
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
		//���Ȼ��SESSIONID
		String sessionID = request.getParameter("sessionID");
		HttpSession session = request.getSession();
		String pageName = request.getParameter("pageName");
		//ת��
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