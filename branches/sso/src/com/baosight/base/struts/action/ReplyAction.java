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
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.IReplyMgr;
import com.baosight.base.service.ITbGovInfoPubMgr;
import com.baosight.base.service.IZfxxgkdfMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbObligeeMsg;
import com.baosight.mode.TbObligeeOpinion;
import com.baosight.mode.TbReply6;
import com.baosight.mode.TbReply5;
import com.baosight.mode.TbReply7;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class ReplyAction extends BaseDispatchAction {
	protected IReplyMgr replyMgr;
	
	protected ITbGovInfoPubMgr tbGovInfoPubMgr;
	
	protected IZfxxgkdfMgr zfxxgkdfMgr;

	public void setZfxxgkdfMgr(IZfxxgkdfMgr zfxxgkdfMgr) {
		this.zfxxgkdfMgr = zfxxgkdfMgr;
	}

	public void setReplyMgr(IReplyMgr replyMgr) {
		this.replyMgr = replyMgr;
	}
	
	public void setTbGovInfoPubMgr(ITbGovInfoPubMgr tbGovInfoPubMgr) {
		this.tbGovInfoPubMgr = tbGovInfoPubMgr;
	}

	public ActionForward reply6List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String id=request.getParameter("id");
			String isOrNotPrint = request.getParameter("isOrNotPrint");
			((DynaValidatorForm) form).set("infoId",id);
			request.setAttribute("id", id);
			
			List list = replyMgr.findByAttr1(id);
			if(list.size() > 0){
				TbReply6 re = (TbReply6)list.get(0);
				((DynaValidatorForm) form).set("id",re.getId());
				((DynaValidatorForm) form).set("year",re.getYear());	
				((DynaValidatorForm) form).set("applyNo",re.getApplyNo());
				((DynaValidatorForm) form).set("applicant",re.getApplicant());
				((DynaValidatorForm) form).set("applyTitle",re.getApplyTitle());
				((DynaValidatorForm) form).set("type",re.getType());
				((DynaValidatorForm) form).set("sendWay",re.getSendWay());
				Date applyDate=re.getApplyDate();
				((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
				Date asignDate=re.getAsignDate();
				((DynaValidatorForm) form).set("asignDate",asignDate);	
				((DynaValidatorForm) form).set("signYear",(asignDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",asignDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",asignDate.getDate()+"");
				
				request.setAttribute("unEdit", "1");
			}else{
				int count=this.replyMgr.findCount("tb_reply6");
				TbGovInfoPub  pub = tbGovInfoPubMgr.findById(id);
			
				if(null != pub){
					((DynaValidatorForm) form).set("id",pub.getId());
					Date now = new Date();
					((DynaValidatorForm) form).set("year",(now.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyNo",count+1+"");
					((DynaValidatorForm) form).set("applicant",pub.getApplicant());
					((DynaValidatorForm) form).set("applyTitle",pub.getDescr());
					((DynaValidatorForm) form).set("type","");
					((DynaValidatorForm) form).set("sendWay","");
					
					Date applyDate=pub.getStartTime();
					((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
					((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
					
					((DynaValidatorForm) form).set("signYear",(new Date().getYear()+1900)+"");	
					((DynaValidatorForm) form).set("signMonth",new Date().getMonth()+1+"");
					((DynaValidatorForm) form).set("signDay",new Date().getDate()+"");
					((DynaValidatorForm) form).set("attr1",id);
				}
			}
			if(null != isOrNotPrint && isOrNotPrint.equals("print")){
				request.setAttribute("form", form);
				return mapping.findForward("print");
			}else{
				return mapping.findForward("list");
			}
	}
	
	public ActionForward obligeeMsgList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String id=request.getParameter("id");
			String isOrNotPrint = request.getParameter("isOrNotPrint");
			((DynaValidatorForm) form).set("infoId",id);
			request.setAttribute("id", id);
			
			List list = replyMgr.findMsgByAttr1(id);
			if(list.size() > 0){
				TbObligeeMsg re = (TbObligeeMsg)list.get(0);
				//((DynaValidatorForm) form).set("id",re.getId());
				((DynaValidatorForm) form).set("year",re.getYear());	
				((DynaValidatorForm) form).set("autoNo",re.getAutoNo());
				((DynaValidatorForm) form).set("obligeeName",re.getObligeeName());
				((DynaValidatorForm) form).set("contentMsg",re.getContentMsg());
				((DynaValidatorForm) form).set("involveMsg",re.getInvolveMsg());
				Date signDate=re.getSignDate();
				((DynaValidatorForm) form).set("signDate",signDate);	
				((DynaValidatorForm) form).set("signYear",(signDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",signDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",signDate.getDate()+"");
				
				request.setAttribute("unEdit", "1");
			}else{
				int count=this.replyMgr.findCount("tb_obligee_msg");
				//((DynaValidatorForm) form).set("id",id);
				Date now = new Date();
				((DynaValidatorForm) form).set("year",(now.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("autoNo",count+1+"");
				((DynaValidatorForm) form).set("obligeeName","");
				((DynaValidatorForm) form).set("contentMsg","");
				((DynaValidatorForm) form).set("involveMsg","");	
				((DynaValidatorForm) form).set("signYear",(new Date().getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",new Date().getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",new Date().getDate()+"");
				((DynaValidatorForm) form).set("attr1",id);
			}
			if(null != isOrNotPrint && isOrNotPrint.equals("print")){
				request.setAttribute("form", form);
				return mapping.findForward("print");
			}else{
				return mapping.findForward("list");
			}
	}
	
	public ActionForward obligeeOpinionList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String id=request.getParameter("id");
			String isOrNotPrint = request.getParameter("isOrNotPrint");
			((DynaValidatorForm) form).set("infoId",id);
			request.setAttribute("id", id);
			
			List list = replyMgr.findOpinionByAttr1(id);
			if(list.size() > 0){
				TbObligeeOpinion re = (TbObligeeOpinion)list.get(0);
				//((DynaValidatorForm) form).set("id",re.getId());
				((DynaValidatorForm) form).set("year",re.getYear());	
				((DynaValidatorForm) form).set("autoNo",re.getAutoNo());
				((DynaValidatorForm) form).set("consultName",re.getConsultName());
				((DynaValidatorForm) form).set("contentMsg",re.getContentMsg());
				((DynaValidatorForm) form).set("involveMsg",re.getInvolveMsg());
				((DynaValidatorForm) form).set("opinion",re.getOpinion());
				((DynaValidatorForm) form).set("address",re.getAddress());
				((DynaValidatorForm) form).set("postalcode",re.getPostalcode());
				
				Date replyDate=re.getReplyDate();
				((DynaValidatorForm) form).set("replyDate",replyDate);	
				((DynaValidatorForm) form).set("replyYear",(replyDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("replyMonth",replyDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("replyDay",replyDate.getDate()+"");
				
				Date signDate=re.getSignDate();	
				((DynaValidatorForm) form).set("signYear",(signDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",signDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",signDate.getDate()+"");
				
				request.setAttribute("unEdit", "1");
			}else{
				int count=this.replyMgr.findCount("tb_obligee_opinion");
				//((DynaValidatorForm) form).set("id",id);
				Date now = new Date();
				((DynaValidatorForm) form).set("year",(now.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("autoNo",count+1+"");
				((DynaValidatorForm) form).set("consultName","");
				((DynaValidatorForm) form).set("contentMsg","");
				((DynaValidatorForm) form).set("involveMsg","");
				((DynaValidatorForm) form).set("opinion","");
				((DynaValidatorForm) form).set("address","");
				((DynaValidatorForm) form).set("postalcode","");
				((DynaValidatorForm) form).set("replyYear","");	
				((DynaValidatorForm) form).set("replyMonth","");
				((DynaValidatorForm) form).set("replyDay","");
				((DynaValidatorForm) form).set("signYear",(new Date().getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",new Date().getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",new Date().getDate()+"");
				((DynaValidatorForm) form).set("attr1",id);
			}
			if(null != isOrNotPrint && isOrNotPrint.equals("print")){
				request.setAttribute("form", form);
				return mapping.findForward("print");
			}else{
				return mapping.findForward("list");
			}
	}
	
	public ActionForward reply5List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String id=request.getParameter("id");
			String isOrNotPrint = request.getParameter("isOrNotPrint");
			request.setAttribute("rem", request.getParameter("rem"));
			request.setAttribute("id", id);
			((DynaValidatorForm) form).set("infoId",id);
			
			List list = replyMgr.findReply5ByAttr1(id);
			if(list.size() > 0){
				TbReply5 re = (TbReply5)list.get(0);
				((DynaValidatorForm) form).set("id",re.getId());
				((DynaValidatorForm) form).set("year",re.getYear());	
				((DynaValidatorForm) form).set("applyNo",re.getApplyNo());
				((DynaValidatorForm) form).set("applicant",re.getApplicant());
				((DynaValidatorForm) form).set("applyTitle",re.getApplyTitle());
				((DynaValidatorForm) form).set("contactAddr",re.getContactAddr());
				((DynaValidatorForm) form).set("department",re.getDepartment());
				Date applyDate=re.getApplyDate();
				((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
				Date signDate=re.getSignDate();
				((DynaValidatorForm) form).set("asignDate",signDate);	
				((DynaValidatorForm) form).set("signYear",(signDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",signDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",signDate.getDate()+"");
				
				request.setAttribute("unEdit", "1");
			}else{
				int count=this.replyMgr.findCount("tb_reply5");
				TbGovInfoPub  pub = tbGovInfoPubMgr.findById(id);
			
				if(null != pub){
					((DynaValidatorForm) form).set("id",pub.getId());
					Date now = new Date();
					((DynaValidatorForm) form).set("year",(now.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyNo",count+1+"");
					((DynaValidatorForm) form).set("applicant",pub.getApplicant());
					((DynaValidatorForm) form).set("applyTitle",pub.getDescr());
					((DynaValidatorForm) form).set("contactAddr","");
					((DynaValidatorForm) form).set("department","");
					((DynaValidatorForm) form).set("attr1",id);
					
					Date applyDate=pub.getStartTime();
					((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
					((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
					
					((DynaValidatorForm) form).set("signYear",(new Date().getYear()+1900)+"");	
					((DynaValidatorForm) form).set("signMonth",new Date().getMonth()+1+"");
					((DynaValidatorForm) form).set("signDay",new Date().getDate()+"");
				}
			}
			
			if(null != isOrNotPrint && isOrNotPrint.equals("print")){
				request.setAttribute("form", form);
				return mapping.findForward("print");
			}else{
				return mapping.findForward("list");
			}
		
	}
	
	public ActionForward reply7List(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String id=request.getParameter("id");
			String isOrNotPrint = request.getParameter("isOrNotPrint");
			((DynaValidatorForm) form).set("infoId",id);
			request.setAttribute("id", id);
			
			List list = replyMgr.findReply7ByAttr1(id);
			if(list.size() > 0){
				TbReply7 re = (TbReply7)list.get(0);
				((DynaValidatorForm) form).set("id",re.getId());
				((DynaValidatorForm) form).set("year",re.getYear());	
				((DynaValidatorForm) form).set("applyNo",re.getApplyNo());
				((DynaValidatorForm) form).set("applicant",re.getApplicant());
				((DynaValidatorForm) form).set("applyTitle",re.getApplyTitle());
				((DynaValidatorForm) form).set("attr3",re.getAttr3());
				((DynaValidatorForm) form).set("replyType",re.getReplyType());
				((DynaValidatorForm) form).set("offerWay",re.getOfferWay());
				Date applyDate=re.getApplyDate();
				((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
				Date signDate=re.getSignDate();
				((DynaValidatorForm) form).set("asignDate",signDate);	
				((DynaValidatorForm) form).set("signYear",(signDate.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("signMonth",signDate.getMonth()+1+"");
				((DynaValidatorForm) form).set("signDay",signDate.getDate()+"");
				
				request.setAttribute("unEdit", "1");
			}else{
				int count=this.replyMgr.findCount("tb_reply7");
				TbGovInfoPub  pub = tbGovInfoPubMgr.findById(id);
			
				if(null != pub){
					((DynaValidatorForm) form).set("id",pub.getId());
					Date now = new Date();
					((DynaValidatorForm) form).set("year",(now.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyNo",count+1+"");
					((DynaValidatorForm) form).set("applicant",pub.getApplicant());
					((DynaValidatorForm) form).set("applyTitle",pub.getDescr());
					((DynaValidatorForm) form).set("attr3","");
					((DynaValidatorForm) form).set("attr1",id);
					((DynaValidatorForm) form).set("replyType","");
					((DynaValidatorForm) form).set("offerWay","");
					
					Date applyDate=pub.getStartTime();
					((DynaValidatorForm) form).set("applyYear",(applyDate.getYear()+1900)+"");	
					((DynaValidatorForm) form).set("applyMonth",applyDate.getMonth()+1+"");
					((DynaValidatorForm) form).set("applyDay",applyDate.getDate()+"");
					
					((DynaValidatorForm) form).set("signYear",(new Date().getYear()+1900)+"");	
					((DynaValidatorForm) form).set("signMonth",new Date().getMonth()+1+"");
					((DynaValidatorForm) form).set("signDay",new Date().getDate()+"");
				}
			}
			if(null != isOrNotPrint && isOrNotPrint.equals("print")){
				request.setAttribute("form", form);
				return mapping.findForward("print");
			}else{
				return mapping.findForward("list");
			}
	}
	
	public ActionForward saveReply6(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String infoId= (String) ((DynaValidatorForm) form).get("infoId");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String applyNo = (String) ((DynaValidatorForm) form).get("applyNo");
		String applicant = (String) ((DynaValidatorForm) form).get("applicant");
		String applyTitle = (String) ((DynaValidatorForm) form).get("applyTitle");
		String type = (String) ((DynaValidatorForm) form).get("type");
		String sendWay = (String) ((DynaValidatorForm) form).get("sendWay");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		String signYear = (String) ((DynaValidatorForm) form).get("signYear");
		String signMonth = (String) ((DynaValidatorForm) form).get("signMonth");
		String signDay = (String) ((DynaValidatorForm) form).get("signDay");
		String date=signYear+"-"+signMonth+"-"+signDay;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date asignDate = dateFormat.parse (date);
		
		String applyYear = (String) ((DynaValidatorForm) form).get("applyYear");
		String applyMonth = (String) ((DynaValidatorForm) form).get("applyMonth");
		String applyDay = (String) ((DynaValidatorForm) form).get("applyDay");
		String applydate=applyYear+"-"+applyMonth+"-"+applyDay;
		Date applyDate = dateFormat.parse (applydate);
		
		TbReply6 item = new TbReply6(applicant,year,applyNo,applyDate,applyTitle,type,sendWay,
				asignDate,attr1,"","");
		
		this.replyMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(infoId);
		tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(16));
		this.infoAuditMgr.modifyStatus(tbGovInfoPub);
		
//		更新
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		
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
		
		//return new ActionForward("/reply6.do?method=reply6List&id="+infoId);
		return mapping.findForward("success");
	}
	
	public ActionForward saveReply5(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String infoId= (String) ((DynaValidatorForm) form).get("infoId");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String applyNo = (String) ((DynaValidatorForm) form).get("applyNo");
		String applicant = (String) ((DynaValidatorForm) form).get("applicant");
		String applyTitle = (String) ((DynaValidatorForm) form).get("applyTitle");
		String department = (String) ((DynaValidatorForm) form).get("department");
		String contactAddr = (String) ((DynaValidatorForm) form).get("contactAddr");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		
		String signYear = (String) ((DynaValidatorForm) form).get("signYear");
		String signMonth = (String) ((DynaValidatorForm) form).get("signMonth");
		String signDay = (String) ((DynaValidatorForm) form).get("signDay");
		String date=signYear+"-"+signMonth+"-"+signDay;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date asignDate = dateFormat.parse (date);
		
		String applyYear = (String) ((DynaValidatorForm) form).get("applyYear");
		String applyMonth = (String) ((DynaValidatorForm) form).get("applyMonth");
		String applyDay = (String) ((DynaValidatorForm) form).get("applyDay");
		String applydate=applyYear+"-"+applyMonth+"-"+applyDay;
		Date applyDate = dateFormat.parse (applydate);
		
		TbReply5 item = new TbReply5(applicant,year,applyNo,applyDate,applyTitle,department,contactAddr,
				asignDate,attr1,"","");
		
		this.replyMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(infoId);
		tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(1024));
		tbGovInfoPub.getTbGovInfoPubAudit().setRem(request.getParameter("rem"));
		this.infoAuditMgr.modifyStatus(tbGovInfoPub);
		
//		更新
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		
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
		
		return mapping.findForward("success");
		//return new ActionForward("/reply5.do?method=reply5List&id="+attr1);
	}
	public ActionForward saveReply7(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, IOException {
		String infoId= (String) ((DynaValidatorForm) form).get("infoId");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String applyNo = (String) ((DynaValidatorForm) form).get("applyNo");
		String applicant = (String) ((DynaValidatorForm) form).get("applicant");
		String applyTitle = (String) ((DynaValidatorForm) form).get("applyTitle");
		String attr3 = (String) ((DynaValidatorForm) form).get("attr3");
		String replyType = (String) ((DynaValidatorForm) form).get("replyType");
		String offerWay = (String) ((DynaValidatorForm) form).get("offerWay");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		
		String signYear = (String) ((DynaValidatorForm) form).get("signYear");
		String signMonth = (String) ((DynaValidatorForm) form).get("signMonth");
		String signDay = (String) ((DynaValidatorForm) form).get("signDay");
		String date=signYear+"-"+signMonth+"-"+signDay;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date asignDate = dateFormat.parse (date);
		
		String applyYear = (String) ((DynaValidatorForm) form).get("applyYear");
		String applyMonth = (String) ((DynaValidatorForm) form).get("applyMonth");
		String applyDay = (String) ((DynaValidatorForm) form).get("applyDay");
		String applydate=applyYear+"-"+applyMonth+"-"+applyDay;
		Date applyDate = dateFormat.parse (applydate);
		
		TbReply7 item = new TbReply7(applicant,year,applyNo,applyDate,applyTitle,replyType,offerWay,
				asignDate,attr1,"",attr3);
		
		this.replyMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(infoId);
		if(replyType.equals("2") || replyType.equals("3")){
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(12298));//审核未通过
		}else if(replyType.equals("1") || replyType.equals("4")){
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(8200));//审核通过
			
//			发关于信息发布中政府信息公开的邮寄	
			String docNum =request.getParameter("docNum");
			//查询在发信息发布中的内容
			String mailbody1=zfxxgkdfMgr.queryContent(docNum);
			sendMail themail1 = new sendMail("mail.shanghaiwater.gov.cn");
			themail1.setNeedAuth(true);
			themail1.setSubject("关于您申请的信息内容");
			themail1.setBody(mailbody1);
			themail1.setTo(request.getParameter("email").toString());
			themail1.setFrom("info@shanghaiwater.gov.cn");
			themail1.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail1.sendout();
		}
		this.infoAuditMgr.modifyStatus(tbGovInfoPub);
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
		//return new ActionForward("/reply7.do?method=reply7List&id="+attr1);
		return mapping.findForward("success");
	}
	public ActionForward saveObligeeMsg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String infoId= (String) ((DynaValidatorForm) form).get("infoId");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String autoNo = (String) ((DynaValidatorForm) form).get("autoNo");
		String obligeeName = (String) ((DynaValidatorForm) form).get("obligeeName");
		String contentMsg = (String) ((DynaValidatorForm) form).get("contentMsg");
		String involveMsg = (String) ((DynaValidatorForm) form).get("involveMsg");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		
		String signYear = (String) ((DynaValidatorForm) form).get("signYear");
		String signMonth = (String) ((DynaValidatorForm) form).get("signMonth");
		String signDay = (String) ((DynaValidatorForm) form).get("signDay");
		String date=signYear+"-"+signMonth+"-"+signDay;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date signDate = dateFormat.parse (date);
		
		TbObligeeMsg item = new TbObligeeMsg(obligeeName,contentMsg,involveMsg,signDate,year,autoNo,
				attr1,"","");
		
		this.replyMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(infoId);
		tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(32768));
		this.infoAuditMgr.modifyStatus(tbGovInfoPub);
		
//		更新
		//HttpSession session = request.getSession();
		//TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		//String receiversId = user.getId();
		super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		
//		发送邮件
		if(request.getParameter("flag").toString().equals("1")){
			String mailbody = "" +request.getParameter("content");
			sendMail themail = new sendMail("mail.shanghaiwater.gov.cn");
			themail.setNeedAuth(true);
			themail.setSubject("公开权利人信息告知单 ");
			themail.setBody(mailbody);
			themail.setTo(request.getParameter("email").toString());
			themail.setFrom("info@shanghaiwater.gov.cn");
//		    themail.addFileAffix("");
			themail.setNamePass("info@shanghaiwater.gov.cn", "dl2008");
			themail.sendout();	
		}
		
		//return new ActionForward("/obligeeMsg.do?method=obligeeMsgList&id="+attr1);
		return mapping.findForward("success");
	}
	public ActionForward saveObligeeOpinion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String infoId= (String) ((DynaValidatorForm) form).get("infoId");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String autoNo = (String) ((DynaValidatorForm) form).get("autoNo");
		String consultName = (String) ((DynaValidatorForm) form).get("consultName");
		String contentMsg = (String) ((DynaValidatorForm) form).get("contentMsg");
		String involveMsg = (String) ((DynaValidatorForm) form).get("involveMsg");
		String opinion = (String) ((DynaValidatorForm) form).get("opinion");
		String address = (String) ((DynaValidatorForm) form).get("address");
		String postalcode = (String) ((DynaValidatorForm) form).get("postalcode");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		
		String replyYear = (String) ((DynaValidatorForm) form).get("replyYear");
		String replyMonth = (String) ((DynaValidatorForm) form).get("replyMonth");
		String replyDay = (String) ((DynaValidatorForm) form).get("replyDay");
		String replydate=replyYear+"-"+replyMonth+"-"+replyDay;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date replyDate = dateFormat.parse (replydate);
		
		String signYear = (String) ((DynaValidatorForm) form).get("signYear");
		String signMonth = (String) ((DynaValidatorForm) form).get("signMonth");
		String signDay = (String) ((DynaValidatorForm) form).get("signDay");
		String date=signYear+"-"+signMonth+"-"+signDay;
		Date signDate = dateFormat.parse (date);
		
		TbObligeeOpinion item = new TbObligeeOpinion(consultName,contentMsg,involveMsg,year,autoNo,
				opinion,replyDate,address,postalcode,attr1,"","",signDate);

		this.replyMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(infoId);
		tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(2));
		this.infoAuditMgr.modifyStatus(tbGovInfoPub);

		//return new ActionForward("/obligeeOpinion.do?method=obligeeOpinionList&id="+attr1);
		return mapping.findForward("success");
	}
}
