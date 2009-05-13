package com.baosight.base.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.baosight.base.service.ITbPublicAffairTransactMgr;
import com.baosight.base.service.TbSwrxMgr;
import com.baosight.mode.TbPublicAffairTransact;
import com.baosight.mode.TbSwrx;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class SwrxAction extends BaseDispatchAction {
	final Long affairType = new Long(40);

	private TbSwrxMgr tbSwrxMgr;

	private ITbPublicAffairTransactMgr tbPublicAffairTransactMgr;

	public void setTbSwrxMgr(TbSwrxMgr tbSwrxMgr) {
		this.tbSwrxMgr = tbSwrxMgr;
	}

	public void setTbPublicAffairTransactMgr(
			ITbPublicAffairTransactMgr tbPublicAffairTransactMgr) {
		this.tbPublicAffairTransactMgr = tbPublicAffairTransactMgr;
	}

	/**
	 * 得到待处理的咨询
	 */
	public ActionForward waitList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List waitListSW = this.tbSwrxMgr.findByIDStatus("", "0");
		long count = 0;
		count = waitListSW.size();
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("waitList");
	}

	/**
	 * 得到处理中的咨询
	 */
	public ActionForward processList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		List waitListSW = this.tbSwrxMgr.findByIDStatus("", "1");
		long count = 0;
		count = waitListSW.size();
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("processList");
	}

	/**
	 * 得到已处理的咨询
	 */
	public ActionForward overList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		List waitListSW = this.tbSwrxMgr.findByIDStatus("", "2");
		long count = 0;
		count = waitListSW.size();
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("overList");
	}

	/**
	 * 得到水务热线咨询的详细信息
	 */
	public ActionForward viewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String hui = request.getParameter("hui");
//		String idt=request.getParameter("ids");
		//增加对于转办和意见咨询的判断，如果是被转办人员和被咨询人员进入湘西信息则只能回复不能修改内容
		TbSwrx tbSwrx = new TbSwrx();
		long ids = 0;
		try {
			ids = Long.parseLong(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tbSwrx = this.tbSwrxMgr.findByID(ids);
		request.setAttribute("tbSwrx", tbSwrx);
		List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
//		System.out.println("tbPublicAffairTransacts==="+tbPublicAffairTransacts);
		request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
		if ("2".equals(hui)) {
			return mapping.findForward("viewCenterOver");
		} else {
			return mapping.findForward("viewCenter");
		}

	}
	public ActionForward viewCentersl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String idt=request.getParameter("ids");
//		String hui = request.getParameter("hui");
		//增加对于转办和意见咨询的判断，如果是被转办人员和被咨询人员进入湘西信息则只能回复不能修改内容
		TbSwrx tbSwrx = new TbSwrx();
		long ids = 0;
		try {
			ids = Long.parseLong(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tbSwrx = this.tbSwrxMgr.findByID(ids);
		List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
//		System.out.println("tbPublicAffairTransacts==="+tbPublicAffairTransacts);
		request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
		request.setAttribute("tbSwrx", tbSwrx);
		request.setAttribute("idt", idt);
		return mapping.findForward("viewCentersl");


	}
	public ActionForward viewCenterslR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String idt=request.getParameter("ids");
//		String hui = request.getParameter("hui");
		//增加对于转办和意见咨询的判断，如果是被转办人员和被咨询人员进入湘西信息则只能回复不能修改内容
		TbSwrx tbSwrx = new TbSwrx();
		long ids = 0;
		try {
			ids = Long.parseLong(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tbSwrx = this.tbSwrxMgr.findByID(ids);
		List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
//		System.out.println("tbPublicAffairTransacts==="+tbPublicAffairTransacts);
		request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
		request.setAttribute("tbSwrx", tbSwrx);
		request.setAttribute("idt", idt);
		return mapping.findForward("viewCenterslOver");


	}
/**
 * 该方法是水务热线的接受者发起转办和意见咨询的方法
 * */
	public ActionForward swrxZB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 回复信息保存在信息表中，专办和意见征询的内容单独保存在一张表中
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		String userName = user.getName();
		// 叶面设置信息的id
		String id = request.getParameter("swid");
//		System.out.println("id==========="+id);
		long ids = Long.parseLong(id);
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)) {
			String responseText = request.getParameter("response");
			String transactor = "";
			if (action.equals("zb"))
				transactor = request.getParameter("ZB");
			else if (action.equals("idea"))
				transactor = request.getParameter("IDEA");
			// 专办
			if (action.equals("zb")) {
				String actionurl="/swrxWaitAction.do?method=processList";
//				updateTbSwrx(mapping, form, request, response);
				// 保存在专办的时候再回复栏内填写的内容
				TbSwrx tbSwrx = tbSwrxMgr.findByID(ids);
				tbSwrx.setAttr1(responseText);
				tbSwrx.setStatus("1");
				tbSwrxMgr.update(tbSwrx);

				TbPublicAffairTransact tbPublicAffairTransact = new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbSwrx.getSwrxid() + "");
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(20));
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransact.setAffairType(affairType);
//				System.out.println("tbPublicAffairTransactMgr====="+tbPublicAffairTransactMgr);
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				return new ActionForward(actionurl);	
			}
			// 保存
			else if (action.equals("save")) {
				String actionurl="/swrxWaitAction.do?method=waitList";
				updateTbSwrx(mapping, form, request, response);
				// 只保存信息，不设置信息的状态
				TbSwrx tbSwrx = tbSwrxMgr.findByID(ids);
				tbSwrx.setAttr1(responseText);
				
				tbSwrxMgr.update(tbSwrx);
				return new ActionForward(actionurl);	
			}
			// 答复
			else if (action.equals("reply")) {
				String actionurl="/swrxWaitAction.do?method=overList";
				updateTbSwrx(mapping, form, request, response);
				// 保存回复内容和回复时间以及回复人，并且设置信息的状态为已回复
				TbSwrx tbSwrx = tbSwrxMgr.findByID(ids);
				tbSwrx.setAttr1(responseText);
				tbSwrx.setStatus("2");
				tbSwrx.setAttr2(userName);
				
				tbSwrxMgr.update(tbSwrx);
				return new ActionForward(actionurl);
			}
			// 征询意见
			else if (action.equals("idea")) {
				String actionurl="/swrxWaitAction.do?method=processList";
				updateTbSwrx(mapping, form, request, response);
				TbSwrx tbSwrx = tbSwrxMgr.findByID(ids);
				tbSwrx.setAttr1(responseText);
				tbSwrx.setStatus("1");
				tbSwrxMgr.update(tbSwrx);

				TbPublicAffairTransact tbPublicAffairTransact = new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbSwrx.getSwrxid() + "");
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(10));
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransact.setCommenta(" ");
				
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				return new ActionForward(actionurl);
			}
		}
		return null;
	}
	/**
	 * 专办或者一间咨询的回复
	 * */
	public ActionForward swrxZBHF(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 回复信息保存在信息表中，专办和意见征询的内容单独保存在一张表中
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
//		String userName = user.getName();
		String type=request.getParameter("type");
		// 叶面设置信息的id
		String id = request.getParameter("ids");
//		System.out.println("id==========="+id);
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)) {
			String responseText = request.getParameter("response");
			String transactor = "";
			if (action.equals("zb"))
				transactor = request.getParameter("ZB");
			else if (action.equals("idea"))
				transactor = request.getParameter("IDEA");
			// 专办
			String action1="";
			if (action.equals("zb")) {
				if("sl".equals(type)){
					action1="/swrxWaitAction.do?method=overslList";
				}else{
					 action1="/swrxWaitAction.do?method=overlsList";
				}
				
				// 保存在专办的时候再回复栏内填写的内容
				TbPublicAffairTransact  tbPublicAffairTransactUpdate = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransactUpdate.setCommenta(responseText);
				tbPublicAffairTransactMgr.update(tbPublicAffairTransactUpdate);

				TbPublicAffairTransact tbPublicAffairTransact = new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbPublicAffairTransactUpdate.getAffairId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(20));
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				return new ActionForward(action1);
			}
			// 保存
			else if (action.equals("save")) {
				if("sl".equals(type)){
					 action1="/swrxWaitAction.do?method=waitslList";
				}else{
					 action1="/swrxWaitAction.do?method=waitlsList";
				}
				
				// 只保存信息，不设置信息的状态
				TbPublicAffairTransact  tbPublicAffairTransactUpdate = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransactUpdate.setCommenta(responseText);
				tbPublicAffairTransactMgr.update(tbPublicAffairTransactUpdate);
				return new ActionForward(action1);
			}
			// 答复
			else if (action.equals("reply")) {
				if("sl".equals(type)){
					 action1="/swrxWaitAction.do?method=overslList";
				}else{
					 action1="/swrxWaitAction.do?method=overlsList";
				}
				
				// 保存回复内容和回复时间以及回复人，并且设置信息的状态为已回复
				TbPublicAffairTransact  tbPublicAffairTransact = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransact.setCommenta(responseText);
				tbPublicAffairTransact.setFinisheTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(100));
				tbPublicAffairTransactMgr.update(tbPublicAffairTransact);
				return new ActionForward(action1);
			}
			// 征询意见
			else if (action.equals("idea")) {
				if("sl".equals(type)){
					 action1="/swrxWaitAction.do?method=overslList";
				}else{
					 action1="/swrxWaitAction.do?method=overlsList";
				}
				
				TbPublicAffairTransact  tbPublicAffairTransactUpdate = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransactUpdate.setCommenta(responseText);
				tbPublicAffairTransactMgr.update(tbPublicAffairTransactUpdate);

				TbPublicAffairTransact tbPublicAffairTransact = new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbPublicAffairTransactUpdate.getAffairId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(10));
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransact.setCommenta(" ");
				
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				return new ActionForward(action1);
			}
		}
		return null;
	}
	public void updateTbSwrx(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		// 在专办或者征询意见的时候调用该方法，用来修改发起人对水务热线内容的修改
		String id = request.getParameter("swid");
//		System.out.println("id=========="+id);
		
		long ids = Long.parseLong(id);
		TbSwrx tbSwrx = tbSwrxMgr.findByID(ids);
//		System.out.println("aaaaaaaaaa==="+tbSwrx.getAcceptedunits());
//		System.out.println("mmmmm"+request.getParameter("acceptedunits"));
		tbSwrx.setAcceptedunits(request.getParameter("acceptedunits"));
//		System.out.println("bbbbbbbbbbbb==="+tbSwrx.getAcceptedunits());
		
		long tracknum = 0;
		String tracknums = request.getParameter("tracknum");
		if (tracknums != null || !"".equals(tracknums)) {
			tracknum = Long.parseLong(tracknums);
		}
		tbSwrx.setTracknum(tracknum);

		long returnvisinum = 0;
		String returnvisinums = request.getParameter("returnvisitnum");
		if (returnvisinums != null || !"".equals(returnvisinums)) {
			returnvisinum = Long.parseLong(returnvisinums);
		}
		tbSwrx.setReturnvisitnum(returnvisinum);
		tbSwrx.setStatementsmark(request.getParameter("statementsmark"));
		tbSwrx.setTrackingtags(request.getParameter("trackingtags"));
		tbSwrx.setCqcfbx(request.getParameter("cqcfbx"));

		String infomationreliabilitys = request.getParameter("informationreliability");
		String Autoprinttimes=request.getParameter("autoprinttime");
		String Firstautoprinttimes=request.getParameter("firstautoprinttime");
		String Underordertimes=request.getParameter("underordertime");
		String Recevicereporttimes=request.getParameter("recevicereporttime");
		String Datehappens=request.getParameter("datehappen");
		String Completiontimes=request.getParameter("completiontime");
		String Appointmenttimes=request.getParameter("appointmenttime");
		String Inputdates=request.getParameter("inputdate");
		String Verifytimes=request.getParameter("verifytime");
		String Acceptedtimes=request.getParameter("acceptedtime");
		String Replytimes=request.getParameter("replytime");
//		Date recordTime = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date InformationreliabilityTime = null, Autoprinttime = null,
		Firstautoprinttime = null, Underordertime = null,
		Recevicereporttime = null, Datehappen = null, 
		Completiontime = null, Appointmenttime = null,
		Inputdate=null,Verifytime=null,Acceptedtime=null,
		Replytime=null;
		InformationreliabilityTime = dateFormat.parse(infomationreliabilitys);
		Autoprinttime=dateFormat.parse(Autoprinttimes);
		Firstautoprinttime=dateFormat.parse(Firstautoprinttimes);
		Underordertime=dateFormat.parse(Underordertimes);
		Recevicereporttime=dateFormat.parse(Recevicereporttimes);
		Datehappen=dateFormat.parse(Datehappens);
		Completiontime=dateFormat.parse(Completiontimes);
		Appointmenttime=dateFormat.parse(Appointmenttimes);
		Inputdate=dateFormat.parse(Inputdates);
		Verifytime=dateFormat.parse(Verifytimes);
		Acceptedtime=dateFormat.parse(Acceptedtimes);
		Replytime=dateFormat.parse(Replytimes);
		
		tbSwrx.setInformationreliability(InformationreliabilityTime);
		tbSwrx.setAutoprinttime(Autoprinttime);
		tbSwrx.setFirstautoprinttime(Firstautoprinttime);
		tbSwrx.setStationtomark(request.getParameter("stationtomark"));
		tbSwrx.setUnderordertime(Underordertime);
		tbSwrx.setRecevicereporttime(Recevicereporttime);
		tbSwrx.setLogonstation(request.getParameter("logonstation"));
		tbSwrx.setReflectpeople(request.getParameter("reflectpeople"));
		tbSwrx.setCustomerno(request.getParameter("customerno"));
		tbSwrx.setReflectunit(request.getParameter("reflectunit"));
		tbSwrx.setReflectphone(request.getParameter("reflectphone"));
		tbSwrx.setReflectdistrict(request.getParameter("reflectdistrict"));
		tbSwrx.setAddresshappen(request.getParameter("addresshappen"));
		tbSwrx.setDatehappen(Datehappen);
		tbSwrx.setReflecttype(request.getParameter("reflecttype"));
		tbSwrx.setReflectcontent(request.getParameter("reflectcontent"));
		tbSwrx.setCljb(request.getParameter("cljb"));
		tbSwrx.setReflectforms(request.getParameter("reflectforms"));
		tbSwrx.setReflectsour(request.getParameter("reflectsour"));
		tbSwrx.setAcceptedremarks(request.getParameter("acceptedremarks"));
		tbSwrx.setRemarklogonuser(request.getParameter("remarklogonuser"));
		tbSwrx.setCompletiontime(Completiontime);
		tbSwrx.setDealpople(request.getParameter("dealpople"));
		tbSwrx.setDealtype(request.getParameter("dealtype"));
		tbSwrx.setDealcontent(request.getParameter("dDealcontent"));
		tbSwrx.setCause(request.getParameter("cause"));
		tbSwrx.setSolutions(request.getParameter("solutions"));
		tbSwrx.setDealresult(request.getParameter("dealresult"));
		tbSwrx.setDealistimely(request.getParameter("dealistimely"));
		tbSwrx.setDealremarks(request.getParameter("dealremarks"));
		tbSwrx.setRepeatsigns(request.getParameter("repeatsigns"));
		tbSwrx.setRepeatrecords(request.getParameter("repeatrecords"));
		tbSwrx.setDeallogonuser(request.getParameter("deallogonuser"));
		tbSwrx.setTrackingprogram(request.getParameter("trackingprogram"));
		tbSwrx.setMobilephone(request.getParameter("mobilephone"));
		tbSwrx.setEmail(request.getParameter("email"));
		tbSwrx.setReflectindustry(request.getParameter("reflectindustry"));
		tbSwrx.setAppointmenttime(Appointmenttime);
		tbSwrx.setInputdate(Inputdate);
		tbSwrx.setSellitemsistimely(request.getParameter("sellitemsistimely"));
		tbSwrx.setVerifytime(Verifytime);
		tbSwrx.setTaskno(request.getParameter("taskno"));
		tbSwrx.setReplyornot(request.getParameter("replyornot"));
		tbSwrx.setVerifylogonuser(request.getParameter("verifylogonuser"));
		tbSwrx.setVerifypeople(request.getParameter("verifypeople"));
		tbSwrx.setVerifyremarks(request.getParameter("verifyremarks"));
		tbSwrx.setVerifytimelyrate(request.getParameter("verifytimelyrate"));
		tbSwrx.setIsreview(request.getParameter("isreview"));
		tbSwrx.setAcceptedstatus(request.getParameter("acceptedstatus"));
		tbSwrx.setAcceptedtime(Acceptedtime);
		tbSwrx.setReplylogonuser(request.getParameter("replylogonuser"));
		tbSwrx.setReplytime(Replytime);
		tbSwrx.setReplyforms(request.getParameter("replyforms"));
		tbSwrx.setReplyremarks(request.getParameter("replyremarks"));
		tbSwrx.setVerifyresult(request.getParameter("verifyresult"));
		tbSwrx.setNo12319(request.getParameter("no12319"));
		tbSwrx.setOldsystemno(request.getParameter("oldsystemno"));
		tbSwrx.setStatus12319(request.getParameter("status12319"));
		tbSwrxMgr.update(tbSwrx);
	}
	/**
	 * 得到待处理的水务热线转办
	 */
	public ActionForward waitslList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		
		
		long type=20;
		List waitListSW = this.tbSwrxMgr.findByUserId(userId,type);
		long count = 0;
		count = waitListSW.size();
		request.setAttribute("hui","0");
		request.setAttribute("type", "sl");
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("waitslList");
	}
	public ActionForward overslList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		
		long type=20;
		List waitListSW = this.tbSwrxMgr.findByUserIdover(userId,type);
		long count = 0;
		count = waitListSW.size();
		request.setAttribute("hui","1");
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("overslList");
	}
	/**
	 * 得到待处理的水务热线转办
	 */
	public ActionForward waitlsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		
		long type=10;
		List waitListSW = this.tbSwrxMgr.findByUserId(userId,type);
		long count = 0;
		count = waitListSW.size();
		request.setAttribute("hui","0");
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		request.setAttribute("type", "ls");
		return mapping.findForward("waitlsList");
	}
	public ActionForward overlsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TbUser user = (TbUser) request.getSession().getAttribute(
		"SYSTEM_USER_SESSION");
		String userId = user.getId();
		
		long type=10;
		List waitListSW = this.tbSwrxMgr.findByUserIdover(userId,type);
		long count = 0;
		count = waitListSW.size();
		request.setAttribute("hui","1");
		startPagingCount(null, request, count);
		startPaging(waitListSW, null, request);
		return mapping.findForward("overlsList");
	}
}
