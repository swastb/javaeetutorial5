package com.baosight.base.struts.action;

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

import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbZfxxgksqdf;
import com.baosight.struts.action.BaseDispatchAction;

public class ZfxxgksqdfAction extends BaseDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String rem = request.getParameter("rem");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		
		List infoIdlist = super.zfxxgksqdfMgr.findByInfoId(id);
		String lsNo = "";
		String sqTime = "";
		String dfTime = "";
		String editYesOrNo = "";
		if (infoIdlist.size() > 0) {
			TbZfxxgksqdf tbZfxxgksqdf = (TbZfxxgksqdf) infoIdlist.get(0);
			((DynaValidatorForm) form).set("applicant", tbZfxxgksqdf
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbZfxxgksqdf.getAttr1());
			((DynaValidatorForm) form).set("attr2", tbZfxxgksqdf.getAttr2());
			lsNo = tbZfxxgksqdf.getLsNo();
			sqTime = tbZfxxgksqdf.getSqTime().toString();
			dfTime = tbZfxxgksqdf.getDfTime().toString();
			editYesOrNo = "0";
		} else {
			List statusList = super.zfxxgksqdfMgr.findAll();
			TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
					.findById(id);
			((DynaValidatorForm) form).set("applicant", tbGovInfoPub
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbGovInfoPub.getDescr());
			String date = DateFormat.getDateTimeInstance().format(
					new java.util.Date()).substring(0, 4);
			lsNo = date + "" + (statusList.size() + 1);
			sqTime = tbGovInfoPub.getStartTime().toString();
//			获得当前时间
			SimpleDateFormat   sf   =   new   SimpleDateFormat("yyyy-MM-dd");   
			Date   now   =   new   Date();    
			dfTime =  sf.format(now)+"";
			editYesOrNo = "1";
		}
		request.setAttribute("lsNo", lsNo);
		request.setAttribute("sqTime", sqTime);
		request.setAttribute("dfTime", dfTime);
		request.setAttribute("editYesOrNo", editYesOrNo);
		request.setAttribute("rem", rem);
		if(null != isOrNotPrint && isOrNotPrint.equals("print")){
			request.setAttribute("form", form);
			return mapping.findForward("print");
		}else{
			return mapping.findForward("edit");
		}
		//return mapping.findForward("edit");
	}

	public ActionForward addOrEditSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		String infoId = (String) ((DynaValidatorForm) form).get("infoId");
		String lsNo = (String) ((DynaValidatorForm) form).get("lsNo");
		String applicant = (String) ((DynaValidatorForm) form).get("applicant");
		String sqTime = (String) ((DynaValidatorForm) form).get("sqTime");
		Date sqTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(sqTime);
		String dfTime = (String) ((DynaValidatorForm) form).get("dfTime");
		Date dfTimeDate = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.parse(dfTime);
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		String attr2 = "".equals((String) ((DynaValidatorForm) form)
				.get("attr2")) ? "0" : (String) ((DynaValidatorForm) form)
				.get("attr2");
		TbZfxxgksqdf item = new TbZfxxgksqdf(infoId, lsNo, applicant,
				sqTimeDate, dfTimeDate, attr1, attr2, "");
		super.zfxxgksqdfMgr.save(item);
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(16384));
		tbGovInfoPubAudit.setRem(request.getParameter("rem"));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
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
		
		
		//return new ActionForward("/zfxxgksqdfaction.do?method=add&id="+infoId);
		return mapping.findForward("success");
	}
}
