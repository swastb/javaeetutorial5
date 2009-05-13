package com.baosight.base.struts.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import com.baosight.base.service.IZfxxgkdfMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbZfxxgksqSjhc;
import com.baosight.mode.TbZfxxgkdfOne;
import com.baosight.mode.TbZfxxgkdfTwo;
import com.baosight.struts.action.BaseDispatchAction;

public class ZfxxgkbdfDealAction extends BaseDispatchAction {

	protected IZfxxgkdfMgr zfxxgkdfMgr;

	public ActionForward addOne(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		List statusList = this.zfxxgkdfMgr.findOneByAttr1(id);
		List allList = this.zfxxgkdfMgr.findAllOne();
		if(statusList.size() > 0){
			TbZfxxgkdfOne one = (TbZfxxgkdfOne) statusList.get(0);
			
			request.setAttribute("year", one.getLsNo().substring(0, 4));
			request.setAttribute("no", one.getLsNo().substring(4, 5));
			request.setAttribute("applicant", one.getAppliName());
			request.setAttribute("sqTime", one.getReceiveDate()+"");
			request.setAttribute("applyManner", one.getIfnoName());
			request.setAttribute("offer1", one.getOfferWay1());
			request.setAttribute("offer2", one.getOfferWay2());
			request.setAttribute("dfTime", one.getSendDate()+"");
			request.setAttribute("attr1", id);
			request.setAttribute("unEdit", "1");
		}else{
			TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
					.findById(id);
	
			String year = DateFormat.getDateTimeInstance().format(
					new java.util.Date()).substring(0, 4);
			
			request.setAttribute("year", year);
			request.setAttribute("no", allList.size()+1+"");
			request.setAttribute("applicant",tbGovInfoPub.getApplicant());
			request.setAttribute("sqTime", tbGovInfoPub.getStartTime().toString());
			request.setAttribute("applyManner", tbGovInfoPub.getDescr());
			request.setAttribute("offer1", "");
			request.setAttribute("offer2", "");
			request.setAttribute("attr1", id);
//			获得当前时间
			SimpleDateFormat   sf   =   new   SimpleDateFormat("yyyy-MM-dd");   
			Date   date   =   new   Date();       
			request.setAttribute("dfTime", sf.format(date)+"");
		}
		if(null != isOrNotPrint && isOrNotPrint.equals("print")){
			request.setAttribute("form", form);
			return mapping.findForward("printOne");
		}else{
			return mapping.findForward("editOne");
		}
		/*TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
				.findById(id);

		String sqTime = tbGovInfoPub.getStartTime().toString();
		String year = DateFormat.getDateTimeInstance().format(
				new java.util.Date()).substring(0, 4);
		request.setAttribute("sqTime", sqTime);
		request.setAttribute("year", year);
		request.setAttribute("statusList", statusList);
		request.setAttribute("tbGovInfoPub", tbGovInfoPub);
		return mapping.findForward("editOne");*/
	}

	public ActionForward addOrEditSaveOne(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, SQLException, IOException {
		String infoId = (String) request.getParameter("infoId");
		String lsNo = (String) request.getParameter("lsNo");
		String applicant = (String) request.getParameter("applicant");
		String applyManner = (String) request.getParameter("applyManner");
		String offer1 = (String) request.getParameter("offer1");
		String offer2 = (String) request.getParameter("offer2");
		String sqTime = (String) request.getParameter("sqTime");
		Date sqTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(sqTime);
		String dfTime = (String) request.getParameter("dfTime");
		Date dfTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(dfTime);
		String attr1 = (String) request.getParameter("attr1");

		TbZfxxgkdfOne item = new TbZfxxgkdfOne(applicant, sqTimeDate,
				applyManner, offer1, offer2, dfTimeDate, lsNo, attr1);
		this.zfxxgkdfMgr.saveOne(item);
		
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(8));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
//		更新
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		
//		发送邮件
		if(request.getParameter("passWay").toString().equals("17")){
			//发关于答复书的内容的邮件
			String mailbody = "" +request.getParameter("content");
			sendMail themail = new sendMail("mail.shanghaiwater.gov.cn");
			themail.setNeedAuth(true);
			themail.setSubject("答复书");
			themail.setBody(mailbody);
			themail.setTo(request.getParameter("email").toString());
			themail.setFrom("info@shanghaiwater.gov.cn");
			themail.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail.sendout();	
			
			//发关于信息发布中政府信息公开的邮寄	
			String docNum =request.getParameter("docNum");
			//查询在发信息发布中的内容
			String mailbody1=this.zfxxgkdfMgr.queryContent(docNum);
			sendMail themail1 = new sendMail("mail.shanghaiwater.gov.cn");
			themail1.setSubject("关于您申请的信息内容");
			themail1.setBody(mailbody1);
			themail1.setTo(request.getParameter("email").toString());
			themail1.setFrom("info@shanghaiwater.gov.cn");
			themail1.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail1.sendout();
			
		}
		
		//return new ActionForward("/zfxxgkDealaction.do?method=addOne&id="+attr1);
		return mapping.findForward("success");
	}

	public ActionForward addTwo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		request.setAttribute("rem", request.getParameter("rem"));
		List allList = this.zfxxgkdfMgr.findAllTwo();
		List statusList = this.zfxxgkdfMgr.findByAttr1Two(id);
		if(statusList.size() > 0){
			TbZfxxgkdfTwo two = (TbZfxxgkdfTwo)statusList.get(0);
			
			request.setAttribute("year", two.getLsNo().substring(0, 4));
			request.setAttribute("no", two.getLsNo().substring(4, 5));
			request.setAttribute("applicant", two.getAppliName());
			request.setAttribute("sqTime", two.getReceiveDate()+"");
			request.setAttribute("applyManner", two.getInfoName());
			request.setAttribute("inforank", two.getInfoRank());
			request.setAttribute("dfTime", two.getSendDate()+"");
			request.setAttribute("attr1", id);
			request.setAttribute("unEdit", "1");
		}else{
			TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
					.findById(id);
	
			String year = DateFormat.getDateTimeInstance().format(
					new java.util.Date()).substring(0, 4);
			
			request.setAttribute("year", year);
			request.setAttribute("no", allList.size()+1+"");
			request.setAttribute("applicant",tbGovInfoPub.getApplicant());
			request.setAttribute("sqTime", tbGovInfoPub.getStartTime().toString());
			request.setAttribute("applyManner", tbGovInfoPub.getDescr());
			request.setAttribute("inforank","");
			request.setAttribute("attr1", id);
			
//			获得当前时间
			SimpleDateFormat   sf   =   new   SimpleDateFormat("yyyy-MM-dd");   
			Date   date   =   new   Date();       
			request.setAttribute("dfTime", sf.format(date)+"");
		}
		if(null != isOrNotPrint && isOrNotPrint.equals("print")){
			request.setAttribute("form", form);
			return mapping.findForward("printTwo");
		}else{
			return mapping.findForward("editTwo");
		}
		/*TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
				.findById(id);

		String sqTime = tbGovInfoPub.getStartTime().toString();
		String year = DateFormat.getDateTimeInstance().format(
				new java.util.Date()).substring(0, 4);
		request.setAttribute("sqTime", sqTime);
		request.setAttribute("year", year);
		request.setAttribute("statusList", statusList);
		request.setAttribute("tbGovInfoPub", tbGovInfoPub);
		return mapping.findForward("editTwo");*/
	}

	public ActionForward addOrEditSaveTwo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, SQLException, IOException {
		String infoId = (String) request.getParameter("infoId");
		String lsNo = (String) request.getParameter("lsNo");
		String applicant = (String) request.getParameter("applicant");
		String applyManner = (String) request.getParameter("applyManner");
		String infoRank = (String) request.getParameter("inforank");
		String sqTime = (String) request.getParameter("sqTime");
		Date sqTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(sqTime);
		String dfTime = (String) request.getParameter("dfTime");
		Date dfTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(dfTime);
		String attr1 = (String) request.getParameter("attr1");

		TbZfxxgkdfTwo item = new TbZfxxgkdfTwo(lsNo, applicant, sqTimeDate,
				applyManner, infoRank, dfTimeDate, attr1);
		this.zfxxgkdfMgr.saveTwo(item);
		
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(128));
		tbGovInfoPub.getTbGovInfoPubAudit().setRem(request.getParameter("rem"));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
//		更新
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		//super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		
//		发送邮件
		if(request.getParameter("passWay").toString().equals("17")){
			String mailbody = "" +request.getParameter("content");
			sendMail themail = new sendMail("mail.shanghaiwater.gov.cn");
			themail.setNeedAuth(true);
			themail.setSubject("答复书");
			themail.setBody(mailbody);
			themail.setTo(request.getParameter("email").toString());
			themail.setFrom("info@shanghaiwater.gov.cn");
//		    themail.addFileAffix("");
			themail.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail.sendout();
		}
		
		//return new ActionForward("/zfxxgkDealaction.do?method=addTwo&id="+attr1);
		return mapping.findForward("success");
	}

	public ActionForward addSjhc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		List allList = this.zfxxgkdfMgr.findAllSjhc();
		List statusList = this.zfxxgkdfMgr.findByAttr1Sjhc(id);
		//收件回执表中已有数据
		if(statusList.size() > 0){
			TbZfxxgksqSjhc sq = (TbZfxxgksqSjhc)statusList.get(0);
			
			request.setAttribute("year", sq.getLsNo().substring(0, 4));
			request.setAttribute("no", sq.getLsNo().substring(4, 5));
			request.setAttribute("applicant", sq.getAppliName());
			request.setAttribute("sqTime", sq.getReceiveDate()+"");
			request.setAttribute("applyManner", sq.getInfoName());
			request.setAttribute("dfTime", sq.getRestoreDate()+"");
			request.setAttribute("attr1", id);
			request.setAttribute("unEdit", "1");
		}else{
			TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
					.findById(id);
	
			String year = DateFormat.getDateTimeInstance().format(
					new java.util.Date()).substring(0, 4);
			
			request.setAttribute("year", year);
			request.setAttribute("no", allList.size()+1+"");
			request.setAttribute("applicant",tbGovInfoPub.getApplicant());
			request.setAttribute("sqTime", tbGovInfoPub.getStartTime().toString());
			request.setAttribute("applyManner", tbGovInfoPub.getDescr());
			//获得当前时间
			SimpleDateFormat   sf   =   new   SimpleDateFormat("yyyy-MM-dd");   
			Date   date   =   new   Date();       
			request.setAttribute("dfTime", sf.format(date)+"");
			
			request.setAttribute("attr1", id);
		}
		if(null != isOrNotPrint && isOrNotPrint.equals("print")){
			request.setAttribute("form", form);
			return mapping.findForward("printSjch");
		}else{
			return mapping.findForward("editSjch");
		}
	}

	public ActionForward addOrEditSaveSjhc(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, SQLException, IOException {
		String infoId = (String) request.getParameter("infoId");
		String lsNo = (String) request.getParameter("lsNo");
		String applicant = (String) request.getParameter("applicant");
		String applyManner = (String) request.getParameter("applyManner");
		String sqTime = (String) request.getParameter("sqTime");
		Date sqTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(sqTime);
		String dfTime = (String) request.getParameter("dfTime");
		Date dfTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(dfTime);
		String attr1 = (String) request.getParameter("attr1");
		TbZfxxgksqSjhc item = new TbZfxxgksqSjhc(lsNo, applicant, sqTimeDate,
				applyManner, dfTimeDate, attr1);
		this.zfxxgkdfMgr.saveSjhc(item);
		
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(262144));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
		//更新待审核
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		super.tbUserOpeationMgr.SaveOrUpdate("","90","minus");
		//更新审核中
		super.tbUserOpeationMgr.SaveOrUpdate("","9","add");
		
//		发送邮件
		if(request.getParameter("passWay").toString().equals("17")){
			String mailbody = "" +request.getParameter("content");
			sendMail themail = new sendMail("mail.shanghaiwater.gov.cn");
			themail.setNeedAuth(true);
			themail.setSubject("收件回执");
			themail.setBody(mailbody);
			themail.setTo(request.getParameter("email").toString());
			themail.setFrom("info@shanghaiwater.gov.cn");
//		    themail.addFileAffix("");
			themail.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail.sendout();	
		}	
		return new ActionForward((String)request.getParameter("URL"));
	}

	public IZfxxgkdfMgr getZfxxgkdfMgr() {
		return zfxxgkdfMgr;
	}

	public void setZfxxgkdfMgr(IZfxxgkdfMgr zfxxgkdfMgr) {
		this.zfxxgkdfMgr = zfxxgkdfMgr;
	}
}
