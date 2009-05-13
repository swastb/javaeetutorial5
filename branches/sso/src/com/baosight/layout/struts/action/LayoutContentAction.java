package com.baosight.layout.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.CLOB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.lob.SerializableClob;

import com.baosight.base.struts.action.InfoPubHelperAction;
import com.baosight.mode.TbGovInfoPubContent;
import com.baosight.mode.TbInfoPubCla;
import com.baosight.mode.TbInfoPubContent;
import com.baosight.mode.TbUser;
import com.baosight.tools.WeekManager;

public class LayoutContentAction extends InfoPubHelperAction {
	/* LAYOUT数据显示 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String flag = request.getParameter("flag");
		if (title != null && !title.equals("")) {
			List viewResult = this.infoPubContentMgr.findByTitle(title);
			TbInfoPubContent item = (TbInfoPubContent) viewResult.get(0);
			SerializableClob sc = (SerializableClob) item.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB) wrapclob;
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			String content = "";
			while (s != null) {
				content += s;
				s = br.readLine();
			}
			br.close();
			is.close();

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("view");
		}
		if (flag != null && !flag.equals("")) {
			TbGovInfoPubContent item = this.infoPubContentMgr.findGovInfoPubById(id);

			SerializableClob sc = (SerializableClob) item.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB) wrapclob;
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			String content = "";
			while (s != null) {
				content += s;
				s = br.readLine();
			}
			br.close();
			is.close();

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("zfxxgkview");
		}		
		if (id != null && !id.equals("")) {
			TbInfoPubContent item = this.infoPubContentMgr.findById(id);

			SerializableClob sc = (SerializableClob) item.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB) wrapclob;
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			String content = "";
			while (s != null) {
				content += s;
				s = br.readLine();
			}
			br.close();
			is.close();

			request.setAttribute("content", content);
			request.setAttribute("item", item);
			return mapping.findForward("view");
		}
		return null;
	}

	/* 获取LAYOUT数据 */
	public ActionForward content(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		HttpSession seseion = request.getSession();
		TbUser user = (TbUser)seseion.getAttribute("SYSTEM_USER_SESSION");
		String belong = this.userMgr.getUserDept(user.getId());
		
		List resultList = null;
		String claId = this.infoPubClaMgr.getClaForLayout(belong,code);
		if(claId!=null && !claId.equals("")) {
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId,code);
			request.setAttribute("claId", claId);
			request.setAttribute("resultList", resultList);	
			if(code.equals("zfxxgk")){
				return mapping.findForward("zfxxgk");
			}
			if(code.equals("gs")){
				List personLastList =  getPersonel("personNow",request);
				if(personLastList!=null){
					request.setAttribute("personLastList", personLastList);	
					return mapping.findForward("gsandpersonel");
				}
			}			
		}
		return mapping.findForward("content");
	}


	/* LAYOUT更多数据 */
	public ActionForward more(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String claId = request.getParameter("claId");

		List resultList = null;
		if(claId!=null && !claId.equals("")) {
			TbInfoPubCla cla = this.infoPubClaMgr.findById(claId);
			if(cla!=null){			
				if(cla.getCode().equals("govinfopub")){
					request.setAttribute("name", cla.getName());
					resultList = this.infoPubContentMgr.findAllGovInfo();
					long count2=resultList.size();
					request.setAttribute("resultList", resultList);	
					startPagingCount(null, request,count2);
					startPaging(resultList, null, request);						
					return mapping.findForward("zfxxgkmore");
				}
			}			
			resultList = this.infoPubContentMgr
					.findByInfoSubject(claId,"moreOther");			
			if(cla!=null){
				request.setAttribute("name", cla.getName());
			}	
			long count1=resultList.size();
			request.setAttribute("resultList", resultList);	
			startPagingCount(null, request,count1);
			startPaging(resultList, null, request);			
		}
		return mapping.findForward("more");
	}
	/*获取个人日程数据*/
	public List getPersonel(String action,HttpServletRequest request){
		if ("personNow".equals(action)) {
			// 当前用户
			TbUser user = (TbUser) request.getSession().getAttribute(
					"SYSTEM_USER_SESSION");
			// 得到为x年x周
			String weekofyear = request.getParameter("weekofyear");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 当天日期
			Date nowDate = new Date();
			// 明天日期
			Date nextDate = WeekManager.getNextDate(new Date(), "2");

			Hashtable htable = new Hashtable<String, String>();
			htable.put("nowDate", sdf.format(nowDate));
			htable.put("nextDate", sdf.format(nextDate));

			// 用户今明两天日程
			List personLastList = this.tbZwWeekSecheduleMgr.findPersonLast(
					user, htable);
			return personLastList;
		}
		return null;
	}
	/* 党建园地选择卡 */
	public ActionForward djyd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String flag = request.getParameter("flag");
			if(flag.equals("true")){
				String code = request.getParameter("code");
				HttpSession seseion = request.getSession();
				TbUser user = (TbUser)seseion.getAttribute("SYSTEM_USER_SESSION");
				String belong = this.userMgr.getUserDept(user.getId());				
				String zbjs = this.infoPubClaMgr.getClaForLayout(belong,"zhibujianshe");
				String dqgz = this.infoPubClaMgr.getClaForLayout(belong,"dangqungongzuo");
				String jzcm = this.infoPubClaMgr.getClaForLayout(belong,"WarningEdu");
				String xxzl = this.infoPubClaMgr.getClaForLayout(belong,"xuexizhuanlan");
				String jhzj = this.infoPubClaMgr.getClaForLayout(belong,"jihuazongjie");
				String xxsjkxfz = this.infoPubClaMgr.getClaForLayout(belong,"huodongjianbao");
				request.setAttribute("zbjs", zbjs);
				request.setAttribute("dqgz", dqgz);
				request.setAttribute("jzcm", jzcm);
				request.setAttribute("xxzl", xxzl);
				request.setAttribute("jhzj", jhzj);
				request.setAttribute("xxsjkxfz", xxsjkxfz);
				return mapping.findForward("djyd");			
			}else{
				String code = request.getParameter("code");
				HttpSession seseion = request.getSession();
				TbUser user = (TbUser)seseion.getAttribute("SYSTEM_USER_SESSION");
				String belong = this.userMgr.getUserDept(user.getId());
				
				List resultList = null;
				String claId = this.infoPubClaMgr.getClaForLayout(belong,code);
				if(claId!=null && !claId.equals("")) {
					resultList = this.infoPubContentMgr
							.findByInfoSubject(claId,"moreOther");
					if(code.equals("zhibujianshe")){
						request.setAttribute("name", "支部建设");
					}else if(code.equals("xuexizhuanlan")){
						request.setAttribute("name", "学习专栏");
					}else if(code.equals("WarningEdu")){
						request.setAttribute("name", "警钟常鸣");
					}else if(code.equals("jihuazongjie")){
						request.setAttribute("name", "计划总结");
					}else if(code.equals("huodongjianbao")){
						request.setAttribute("name", "学习实践科学发展观专题");
					}else{
						request.setAttribute("name", "");
					}
					long count1=resultList.size();	
					startPagingCount(null, request,count1);
					startPaging(resultList, null, request);					
				}		
				return mapping.findForward("more");					
			}
				
	}
	/* 党群工作选择卡 */
	public ActionForward dqgz(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {	
		String claId = request.getParameter("claId");
		List resultList = null;		
		resultList = this.infoPubContentMgr
				.findByInfoSubject(claId,"forDQGZ");	
		request.setAttribute("name", "党群工作");
		long count1=resultList.size();
		//request.setAttribute("resultList", resultList);	
		startPagingCount(null, request,count1);
		startPaging(resultList, null, request);			
		return mapping.findForward("more");		
	}	
	/* 水资源原水选择卡 */
	public ActionForward szyys(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String flag = request.getParameter("flag");
			if(flag.equals("true")){
				return mapping.findForward("djyd");			
			}else{
				String code = request.getParameter("code");
				HttpSession seseion = request.getSession();
				TbUser user = (TbUser)seseion.getAttribute("SYSTEM_USER_SESSION");
				String belong = this.userMgr.getUserDept(user.getId());
				
				List resultList = null;
				String claId = this.infoPubClaMgr.getClaForLayout(belong,code);
				if(claId!=null && !claId.equals("")) {
					resultList = this.infoPubContentMgr
							.findByInfoSubject(claId,"moreOther");
					if(code.equals("zhibujianshe")){
						request.setAttribute("name", "支部建设");
					}else if(code.equals("xuexizhuanlan")){
						request.setAttribute("name", "学习专栏");
					}else if(code.equals("WarningEdu")){
						request.setAttribute("name", "警钟常鸣");
					}else if(code.equals("jihuazongjie")){
						request.setAttribute("name", "计划总结");
					}else if(code.equals("huodongjianbao")){
						request.setAttribute("name", "学习实践科学发展观专题");
					}else{
						request.setAttribute("name", "");
					}
					long count1=resultList.size();	
					startPagingCount(null, request,count1);
					startPaging(resultList, null, request);					
				}		
				return mapping.findForward("more");					
			}
				
	}	
	public ActionForward zfxxgkMovePageMore(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		// 首先获得SESSIONID
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

		return mapping.findForward("zfxxgkTurnToPage");
	}
	public ActionForward zfxxgkResetPageSizeMore(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
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
		return mapping.findForward("zfxxgkTurnToPage");		
	}
}
