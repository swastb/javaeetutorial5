package com.baosight.base.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.baosight.mode.TbYqdfgzs;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tools.DbManager1;

public class YqdfgzsAction extends BaseDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		
		List infoIdlist = super.yqdfgzsMgr.findByInfoId(id);
		String lsNo = "";
		String sqTime = "";
		String dfTime = "";
		String editYesOrNo = "";
		if (infoIdlist.size() > 0) {
			TbYqdfgzs tbYqdfgzs = (TbYqdfgzs) infoIdlist.get(0);
			((DynaValidatorForm) form).set("applicant", tbYqdfgzs
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbYqdfgzs.getAttr1());
			lsNo = tbYqdfgzs.getLsNo();
			sqTime = tbYqdfgzs.getSqTime().toString();
			dfTime = tbYqdfgzs.getDfTime().toString();
			editYesOrNo = "0";
		} else {
			List statusList = super.yqdfgzsMgr.findAll();
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
		TbYqdfgzs item = new TbYqdfgzs(infoId, lsNo, applicant, sqTimeDate,
				dfTimeDate, attr1);
		super.yqdfgzsMgr.save(item);
		
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(131072));
		
	
		String afterDate =new SimpleDateFormat("yyyy-MM-dd").format(com.baosight.tools.DateFormat.spanDate( new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"",15))+"";           //15个工作日后日期"yyyy-MM-dd"格式
		System.out.println("afterDate*****:"+afterDate);
		tbGovInfoPub.setAttr2(afterDate);
		
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
		//return new ActionForward("/yqdfgzsaction.do?method=add&id="+infoId);
		return mapping.findForward("success");
	}
	
}
