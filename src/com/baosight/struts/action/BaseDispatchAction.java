package com.baosight.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.baosight.base.service.IAppSysMgr;
import com.baosight.base.service.IAuthlvlMgr;
import com.baosight.base.service.IBzsqgzsMgr;
import com.baosight.base.service.ICommonalityCommMgr;
import com.baosight.base.service.ICommonalityMgr;
import com.baosight.base.service.IDeptMgr;
import com.baosight.base.service.IDeptlvlMgr;
import com.baosight.base.service.IDocAttachMgr;
import com.baosight.base.service.IDocRecListMgr;
import com.baosight.base.service.IDocSendBookMgr;
import com.baosight.base.service.IDocSendDealMgr;
import com.baosight.base.service.IDocServiceMgr;
import com.baosight.base.service.IFunctionMgr;
import com.baosight.base.service.IFzfxxgksqgzsMgr;
import com.baosight.base.service.IGroupMgr;
import com.baosight.base.service.IIndividualCommMgr;
import com.baosight.base.service.IIndividualMgr;
import com.baosight.base.service.IInfoAuditMgr;
import com.baosight.base.service.IMeetingMgr;
import com.baosight.base.service.IMeetingRoomMgr;
import com.baosight.base.service.IMeetingrecordMgr;
import com.baosight.base.service.IMessagesMgr;
import com.baosight.base.service.IOaHolidayMgr;
import com.baosight.base.service.IPstMgr;
import com.baosight.base.service.IPstlvlMgr;
import com.baosight.base.service.IRightTypeMgr;
import com.baosight.base.service.IRoleMgr;
import com.baosight.base.service.ISmsDepartMgr;
import com.baosight.base.service.ISmsScheduleMgr;
import com.baosight.base.service.ISmsSubjectMgr;
import com.baosight.base.service.ISmsSubscribeMgr;
import com.baosight.base.service.ISmsUserMgr;
import com.baosight.base.service.ITbArchivesApplyMgr;
import com.baosight.base.service.ITbArchivesMgr;
import com.baosight.base.service.ITbDocRecMgr;
import com.baosight.base.service.ITbGovInfoPubAuditMgr;
import com.baosight.base.service.ITbGovInfoPubMgr;
import com.baosight.base.service.ITbUserMgr;
import com.baosight.base.service.ITbUserOpeationMgr;
import com.baosight.base.service.ITbVehiclesApplyMgr;
import com.baosight.base.service.ITbZwWeekSecheduleMgr;
import com.baosight.base.service.IUserDeptMgr;
import com.baosight.base.service.IUserInfoMgr;
import com.baosight.base.service.IUserRoleMgr;
import com.baosight.base.service.IUserlvlMgr;
import com.baosight.base.service.IYqdfgzsMgr;
import com.baosight.base.service.IZfxxbfgkgzsMgr;
import com.baosight.base.service.IZfxxgkbzsqgzsMgr;
import com.baosight.base.service.IZfxxgkcfsqgzsMgr;
import com.baosight.base.service.IZfxxgkgzsMgr;
import com.baosight.base.service.IZfxxgksqdfMgr;
import com.baosight.base.service.IZfxxgksqdfs3Mgr;
import com.baosight.base.service.IZfxxgksqdfs4Mgr;
import com.baosight.mode.TbUser;
import com.baosight.services.TestService;

public class BaseDispatchAction extends DispatchAction {

	protected TestService testService;

	/**
	 * 系统用户业务模型
	 */
	protected ITbUserMgr userMgr;

	/**
	 * 用户信息扩展模型
	 */
	protected IUserInfoMgr userInfoMgr;

	/**
	 * 职务等级管理器
	 */
	protected IPstlvlMgr pstlvlMgr;

	/**
	 * 权限类型管理器
	 */
	protected IRightTypeMgr rightTypeMgr;

	/**
	 * 用户级别管理器
	 */
	protected IUserlvlMgr userlvlMgr;

	/**
	 * 角色管理器
	 */
	protected IRoleMgr roleMgr;

	/**
	 * 组管理器
	 */
	protected IGroupMgr groupMgr;

	/**
	 * 部门管理器
	 */
	protected IDeptMgr deptMgr;

	/**
	 * 职务管理器
	 */
	protected IAuthlvlMgr authlvlMgr;

	/**
	 * 系统用户业务模型
	 */
	protected IDeptlvlMgr deptlvlMgr;

	/**
	 * 系统用户业务模型
	 */
	protected IPstMgr pstMgr;

	/**
	 * 应用系统业务模型
	 */
	protected IAppSysMgr appSysMgr;

	protected IUserRoleMgr userRoleMgr;

	protected IFunctionMgr functionMgr;

	/**
	 * 节假日管理
	 */
	protected IOaHolidayMgr oaholidayMgr;

	/**
	 * 一周日程管理
	 */
	protected ITbZwWeekSecheduleMgr tbZwWeekSecheduleMgr;

	/**
	 * 公共通讯录
	 */
	protected ICommonalityMgr commonalityMgr;

	/**
	 * 公共通讯组
	 */
	protected ICommonalityCommMgr commonalityCommMgr;

	/**
	 * 会议安排管理
	 */
	protected IMeetingMgr meetingMgr;

	protected IMeetingRoomMgr meetingRoomMgr;

	protected IUserDeptMgr userDeptMgr;

	/**
	 * 个人通讯管理
	 */
	protected IIndividualMgr individualMgr;

	/**
	 * 个人通讯组管理
	 */
	protected IIndividualCommMgr individualCommMgr;

	/**
	 * 用车申请管理
	 */
	protected ITbVehiclesApplyMgr tbVehiclesApplyMgr;

	/**
	 * 消息管理
	 */
	protected IMessagesMgr messagesMgr;

	protected ISmsScheduleMgr smsScheduleMgr;

	protected ITbGovInfoPubAuditMgr tbGovInfoPubAuditMgr;

	protected ITbGovInfoPubMgr tbGovInfoPubMgr;

	protected ITbArchivesMgr tbArchivesMgr;

	protected ITbArchivesApplyMgr tbArchivesApplyMgr;

	/**
	 * 政府信息公开告知书
	 */
	protected IZfxxgkgzsMgr zfxxgkgzsMgr;

	protected IZfxxbfgkgzsMgr zfxxbfgkgzsMgr;

	protected IBzsqgzsMgr bzsqgzsMgr;

	protected IZfxxgksqdfMgr zfxxgksqdfMgr;

	protected IZfxxgksqdfs3Mgr zfxxgksqdfs3Mgr;

	protected IZfxxgksqdfs4Mgr zfxxgksqdfs4Mgr;

	protected IZfxxgkcfsqgzsMgr zfxxgkcfsqgzsMgr;

	protected IZfxxgkbzsqgzsMgr zfxxgkbzsqgzsMgr;

	protected IYqdfgzsMgr yqdfgzsMgr;

	protected IFzfxxgksqgzsMgr fzfxxgksqgzsMgr;

	protected IInfoAuditMgr infoAuditMgr;

	// 收文管理
	protected ITbDocRecMgr tbDocRecMgr;

	protected IDocServiceMgr docServiceMgr;

	protected IDocRecListMgr docRecListMgr;

	protected IDocAttachMgr docAttachMgr;

	// 发文管理docSendDealMgr
	protected IDocSendDealMgr docSendDealMgr;

	protected IDocSendBookMgr docSendBookMgr;

	protected ITbUserOpeationMgr tbUserOpeationMgr;

	// 会议纪要管理
	protected IMeetingrecordMgr meetingrecordMgr;

	public void setIndividualCommMgr(IIndividualCommMgr individualCommMgr) {
		this.individualCommMgr = individualCommMgr;
	}

	public void setIndividualMgr(IIndividualMgr individualMgr) {
		this.individualMgr = individualMgr;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String method = request.getParameter("method");
		if (method != null && !method.equals("")) {
			try {
				return this.dispatchMethod(mapping, form, request, response,
						method);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (method != null && !method.equals("")) {
			if (method.equals("zfxxgk") || method.equals("wsbs")
					|| method.equals("news") || method.equals("wzdt")) {
				return null;
			}
		}
		ActionForward forward = new ActionForward();
		// String path = processPath(request, response);
		//forward.setPath("https://31.16.1.30/sso");
		//forward.setPath("/index.jsp");
		return forward;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	/**
	 * 系统用户注射器
	 * 
	 * @param userService
	 */
	public void setUserMgr(ITbUserMgr userMgr) {
		this.userMgr = userMgr;
	}

	public void setPstlvlMgr(IPstlvlMgr pstlvlMgr) {
		this.pstlvlMgr = pstlvlMgr;
	}

	public void setRightTypeMgr(IRightTypeMgr rightTypeMgr) {
		this.rightTypeMgr = rightTypeMgr;
	}

	public void setUserlvlMgr(IUserlvlMgr userlvlMgr) {
		this.userlvlMgr = userlvlMgr;
	}

	public void setRoleMgr(IRoleMgr roleMgr) {
		this.roleMgr = roleMgr;
	}

	public void setGroupMgr(IGroupMgr groupMgr) {
		this.groupMgr = groupMgr;
	}

	public void setDeptMgr(IDeptMgr deptMgr) {
		this.deptMgr = deptMgr;
	}

	public void setPstMgr(IPstMgr pstMgr) {
		this.pstMgr = pstMgr;
	}

	public void setUserInfoMgr(IUserInfoMgr userInfoMgr) {
		this.userInfoMgr = userInfoMgr;
	}

	public void setUserRoleMgr(IUserRoleMgr userRoleMgr) {
		this.userRoleMgr = userRoleMgr;
	}

	public void setAuthlvlMgr(IAuthlvlMgr authlvlMgr) {
		this.authlvlMgr = authlvlMgr;
	}

	public void setDeptlvlMgr(IDeptlvlMgr deptlvlMgr) {
		this.deptlvlMgr = deptlvlMgr;
	}

	public void setAppSysMgr(IAppSysMgr appSysMgr) {
		this.appSysMgr = appSysMgr;
	}

	public void setFunctionMgr(IFunctionMgr functionMgr) {
		this.functionMgr = functionMgr;
	}

	public void setOaholidayMgr(IOaHolidayMgr oaholidayMgr) {
		this.oaholidayMgr = oaholidayMgr;
	}

	public void setTbZwWeekSecheduleMgr(
			ITbZwWeekSecheduleMgr tbZwWeekSecheduleMgr) {
		this.tbZwWeekSecheduleMgr = tbZwWeekSecheduleMgr;
	}

	/**
	 * @param userDeptMgr
	 *            the userDeptMgr to set
	 */
	public void setUserDeptMgr(IUserDeptMgr userDeptMgr) {
		this.userDeptMgr = userDeptMgr;
	}

	public void setMeetingRoomMgr(IMeetingRoomMgr meetingRoomMgr) {
		this.meetingRoomMgr = meetingRoomMgr;
	}

	public IMeetingMgr getMeetingMgr() {
		return meetingMgr;
	}

	public void setMeetingMgr(IMeetingMgr meetingMgr) {
		this.meetingMgr = meetingMgr;
	}

	public void setCommonalityCommMgr(ICommonalityCommMgr commonalityCommMgr) {
		this.commonalityCommMgr = commonalityCommMgr;
	}

	public void setCommonalityMgr(ICommonalityMgr commonalityMgr) {
		this.commonalityMgr = commonalityMgr;
	}

	public void setTbVehiclesApplyMgr(ITbVehiclesApplyMgr tbVehiclesApplyMgr) {
		this.tbVehiclesApplyMgr = tbVehiclesApplyMgr;
	}

	// 分页程序----------------------------------------------------------------------------------------------------
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
	 * @param curPage
	 *            the curPage to set
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
	 * @param maxPage
	 *            the maxPage to set
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
	 * @param moveTo
	 *            the moveTo to set
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
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	protected void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
/**
 * 天加信息的总量
 * */
	protected void startPagingCount(String sessionID,
			HttpServletRequest request,long count){
//		HttpSession session = request.getSession();
		// SESSIONID ,为了避免冲突使用Page+时戳
//		if (sessionID == null || sessionID.trim().length() < 5)
//			sessionID = "Page_" + System.currentTimeMillis();

	}
	/**
	 * 启动分页
	 * 
	 * @param res
	 * @param sessionID
	 * @param request
	 * @param count
	 * @return 返回的是当前页面的结果集
	 */
	protected void startPaging(List res, String sessionID,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		// SESSIONID ,为了避免冲突使用Page+时戳
		if (sessionID == null || sessionID.trim().length() < 5)
			sessionID = "Page_" + System.currentTimeMillis();
		// 结果集
		session.setAttribute(sessionID, res);
		//总量
		session.setAttribute(sessionID + "Count", new Long(res.size()));
		// 页面大小
		session.setAttribute(sessionID + "Size", getPageSize());

		// 当前页码
		session.setAttribute(sessionID + "No", getCurPage());

		// 最大页码
		session.setAttribute(sessionID + "MaxNo",
				res.size() % pageSize == 0 ? (res.size() / pageSize) : res
						.size()
						/ pageSize + 1);

		request.setAttribute("sessionID", sessionID);

		int lastLoc = getPageSize() * (getCurPage() + 1) > res.size() ? res
				.size() : getPageSize() * (getCurPage() + 1);

		List curPageList = res.subList((getPageSize() * getCurPage())>=res.size()?0:(getPageSize() * getCurPage()), lastLoc);
	
		request.setAttribute("curPageList", curPageList);
	}

	/**
	 * 跳到第X页
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward movePage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		
		// 首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");
		 if(sessionID==null || sessionID.trim().length()<5)
		 sessionID = "Page_"+System.currentTimeMillis();
		 
		 DynaActionForm dyForm = (DynaActionForm) form;
		 
		HttpSession session = request.getSession();

		// 转到
		try {
			setMoveTo(Integer.parseInt(request.getParameter("moveTo")));
		} catch (NumberFormatException ex) {

		}

		List res = (List) session.getAttribute(sessionID);

		try {
			setCurPage((Integer) session.getAttribute(sessionID + "No"));
		} catch (NumberFormatException ex) {

		}

		try {
			setMaxPage((Integer) session.getAttribute(sessionID + "MaxNo"));
		} catch (NumberFormatException ex) {

		}

		try {
			setPageSize((Integer) session.getAttribute(sessionID + "Size"));
		} catch (NumberFormatException ex) {

		}
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		if (getMoveTo() < 0 || getMoveTo() >= getMaxPage())
			setMoveTo(0);

		setCurPage(getMoveTo());
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);

		return mapping.findForward("trunToPage");
	}

	public ActionForward movePageMore(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// 首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");
		if(sessionID==null || sessionID.trim().length()<5)
		sessionID = "Page_"+System.currentTimeMillis();

		HttpSession session = request.getSession();

		// 转到
		try {
			setMoveTo(Integer.parseInt(request.getParameter("moveTo")));
		} catch (NumberFormatException ex) {

		}

		List res = (List) session.getAttribute(sessionID);

		try {
			setCurPage((Integer) session.getAttribute(sessionID + "No"));
		} catch (NumberFormatException ex) {

		}

		try {
			setMaxPage((Integer) session.getAttribute(sessionID + "MaxNo"));
		} catch (NumberFormatException ex) {

		}

		try {
			setPageSize((Integer) session.getAttribute(sessionID + "Size"));
		} catch (NumberFormatException ex) {

		}

		if (getMoveTo() < 0 || getMoveTo() >= getMaxPage())
			setMoveTo(0);
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		setCurPage(getMoveTo());
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);

		return mapping.findForward("turnToPage");
	}

	public ActionForward resetPageSize(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// 首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");

		HttpSession session = request.getSession();

		// 转到
		setMoveTo(0);

		List res = (List) session.getAttribute(sessionID);

		setCurPage(0);

		try {
			setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		} catch (NumberFormatException ex) {

		}
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);
		return mapping.findForward("trunToPage");
	}

	public ActionForward resetPageSizeMore(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		// 首先获得SESSIONID
		String sessionID = request.getParameter("sessionID");

		HttpSession session = request.getSession();

		// 转到
		setMoveTo(0);

		List res = (List) session.getAttribute(sessionID);

		setCurPage(0);

		try {
			setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		} catch (NumberFormatException ex) {

		}
		long count=0;
		try{
			count=(Long)session.getAttribute(sessionID+"Count");
		}catch(NumberFormatException ex){
			
		}
		startPagingCount(sessionID, request,count);
		startPaging(res, sessionID, request);
		return mapping.findForward("turnToPage");
	}

	/**
	 * <p>
	 * Decription:getCurrentUser
	 * </p>
	 * 
	 * @param request
	 * @return TbUser
	 *         <p>
	 *         Create Time:2008-7-31
	 *         </p>
	 */
	public TbUser getCurrentUser(HttpServletRequest request) {
		return (TbUser) request.getSession()
				.getAttribute("SYSTEM_USER_SESSION");
	}

	public void setTbGovInfoPubAuditMgr(
			ITbGovInfoPubAuditMgr tbGovInfoPubAuditMgr) {
		this.tbGovInfoPubAuditMgr = tbGovInfoPubAuditMgr;
	}

	public void setTbGovInfoPubMgr(ITbGovInfoPubMgr tbGovInfoPubMgr) {
		this.tbGovInfoPubMgr = tbGovInfoPubMgr;
	}

	public void setZfxxgkgzsMgr(IZfxxgkgzsMgr zfxxgkgzsMgr) {
		this.zfxxgkgzsMgr = zfxxgkgzsMgr;
	}

	public void setZfxxbfgkgzsMgr(IZfxxbfgkgzsMgr zfxxbfgkgzsMgr) {
		this.zfxxbfgkgzsMgr = zfxxbfgkgzsMgr;
	}

	public void setBzsqgzsMgr(IBzsqgzsMgr bzsqgzsMgr) {
		this.bzsqgzsMgr = bzsqgzsMgr;
	}

	public void setInfoAuditMgr(IInfoAuditMgr infoAuditMgr) {
		this.infoAuditMgr = infoAuditMgr;
	}

	public void setTbArchivesMgr(ITbArchivesMgr tbArchivesMgr) {
		this.tbArchivesMgr = tbArchivesMgr;
	}

	public void setTbArchivesApplyMgr(ITbArchivesApplyMgr tbArchivesApplyMgr) {
		this.tbArchivesApplyMgr = tbArchivesApplyMgr;
	}

	public IZfxxgksqdfMgr getZfxxgksqdfMgr() {
		return zfxxgksqdfMgr;
	}

	public void setZfxxgksqdfMgr(IZfxxgksqdfMgr zfxxgksqdfMgr) {
		this.zfxxgksqdfMgr = zfxxgksqdfMgr;
	}

	public IYqdfgzsMgr getYqdfgzsMgr() {
		return yqdfgzsMgr;
	}

	public void setYqdfgzsMgr(IYqdfgzsMgr yqdfgzsMgr) {
		this.yqdfgzsMgr = yqdfgzsMgr;
	}

	public IZfxxgkbzsqgzsMgr getZfxxgkbzsqgzsMgr() {
		return zfxxgkbzsqgzsMgr;
	}

	public void setZfxxgkbzsqgzsMgr(IZfxxgkbzsqgzsMgr zfxxgkbzsqgzsMgr) {
		this.zfxxgkbzsqgzsMgr = zfxxgkbzsqgzsMgr;
	}

	public IZfxxgkcfsqgzsMgr getZfxxgkcfsqgzsMgr() {
		return zfxxgkcfsqgzsMgr;
	}

	public void setZfxxgkcfsqgzsMgr(IZfxxgkcfsqgzsMgr zfxxgkcfsqgzsMgr) {
		this.zfxxgkcfsqgzsMgr = zfxxgkcfsqgzsMgr;
	}

	public IFzfxxgksqgzsMgr getFzfxxgksqgzsMgr() {
		return fzfxxgksqgzsMgr;
	}

	public void setFzfxxgksqgzsMgr(IFzfxxgksqgzsMgr fzfxxgksqgzsMgr) {
		this.fzfxxgksqgzsMgr = fzfxxgksqgzsMgr;
	}

	public IZfxxgksqdfs3Mgr getZfxxgksqdfs3Mgr() {
		return zfxxgksqdfs3Mgr;
	}

	public void setZfxxgksqdfs3Mgr(IZfxxgksqdfs3Mgr zfxxgksqdfs3Mgr) {
		this.zfxxgksqdfs3Mgr = zfxxgksqdfs3Mgr;
	}

	public IZfxxgksqdfs4Mgr getZfxxgksqdfs4Mgr() {
		return zfxxgksqdfs4Mgr;
	}

	public void setZfxxgksqdfs4Mgr(IZfxxgksqdfs4Mgr zfxxgksqdfs4Mgr) {
		this.zfxxgksqdfs4Mgr = zfxxgksqdfs4Mgr;
	}

	public void setTbDocRecMgr(ITbDocRecMgr tbDocRecMgr) {
		this.tbDocRecMgr = tbDocRecMgr;
	}

	public IDocRecListMgr getDocRecListMgr() {
		return docRecListMgr;
	}

	public void setDocRecListMgr(IDocRecListMgr docRecListMgr) {
		this.docRecListMgr = docRecListMgr;
	}

	public void setDocServiceMgr(IDocServiceMgr docServiceMgr) {
		this.docServiceMgr = docServiceMgr;
	}

	public void setDocAttachMgr(IDocAttachMgr docAttachMgr) {
		this.docAttachMgr = docAttachMgr;
	}

	public IDocSendDealMgr getDocSendDealMgr() {
		return docSendDealMgr;
	}

	public void setDocSendDealMgr(IDocSendDealMgr docSendDealMgr) {
		this.docSendDealMgr = docSendDealMgr;
	}

	public void setDocSendBookMgr(IDocSendBookMgr docSendBookMgr) {
		this.docSendBookMgr = docSendBookMgr;
	}

	public void setTbUserOpeationMgr(ITbUserOpeationMgr tbUserOpeationMgr) {
		this.tbUserOpeationMgr = tbUserOpeationMgr;
	}

	public void setMessagesMgr(IMessagesMgr messagesMgr) {
		this.messagesMgr = messagesMgr;
	}

	public void setMeetingrecordMgr(IMeetingrecordMgr meetingrecordMgr) {
		this.meetingrecordMgr = meetingrecordMgr;
	}

	public ISmsScheduleMgr getSmsScheduleMgr() {
		return smsScheduleMgr;
	}

	public void setSmsScheduleMgr(ISmsScheduleMgr smsScheduleMgr) {
		this.smsScheduleMgr = smsScheduleMgr;
	}

	// 短信订阅
	protected ISmsSubscribeMgr smsSubscribeMgr;

	public ISmsSubscribeMgr getSmsSubscribeMgr() {
		return smsSubscribeMgr;
	}

	public void setSmsSubscribeMgr(ISmsSubscribeMgr smsSubscribeMgr) {
		this.smsSubscribeMgr = smsSubscribeMgr;
	}

	public ISmsSubjectMgr smsSubjectMgr;

	public ISmsSubjectMgr getSmsSubjectMgr() {
		return smsSubjectMgr;
	}

	public void setSmsSubjectMgr(ISmsSubjectMgr smsSubjectMgr) {
		this.smsSubjectMgr = smsSubjectMgr;
	}

	// 查询统计
	public ISmsDepartMgr smsDepartMgr;

	public ISmsUserMgr smsUserMgr;

	public ISmsUserMgr getSmsUserMgr() {
		return smsUserMgr;
	}

	public void setSmsUserMgr(ISmsUserMgr smsUserMgr) {
		this.smsUserMgr = smsUserMgr;
	}

	public ISmsDepartMgr getSmsDepartMgr() {
		return smsDepartMgr;
	}

	public void setSmsDepartMgr(ISmsDepartMgr smsDepartMgr) {
		this.smsDepartMgr = smsDepartMgr;
	}
}
