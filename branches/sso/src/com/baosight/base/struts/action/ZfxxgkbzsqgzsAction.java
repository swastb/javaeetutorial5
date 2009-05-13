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
import com.baosight.mode.TbZfxxgkbzsqgzs;
import com.baosight.struts.action.BaseDispatchAction;

public class ZfxxgkbzsqgzsAction extends BaseDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		
		List infoIdlist = super.zfxxgkbzsqgzsMgr.findByInfoId(id);
		String lsNo = "";
		String sqTime = "";
		String dfTime = "";
		String editYesOrNo = "";
		if (infoIdlist.size() > 0) {
			TbZfxxgkbzsqgzs tbZfxxgkbzsqgzs = (TbZfxxgkbzsqgzs) infoIdlist
					.get(0);
			((DynaValidatorForm) form).set("applicant", tbZfxxgkbzsqgzs
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbZfxxgkbzsqgzs.getAttr1());
			lsNo = tbZfxxgkbzsqgzs.getLsNo();
			sqTime = tbZfxxgkbzsqgzs.getSqTime().toString();
			dfTime = tbZfxxgkbzsqgzs.getDfTime().toString();
			editYesOrNo = "0";
		} else {
			List statusList = super.zfxxgkbzsqgzsMgr.findAll();
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
		TbZfxxgkbzsqgzs item = new TbZfxxgkbzsqgzs(infoId, lsNo, applicant,
				sqTimeDate, dfTimeDate, attr1);
		super.zfxxgkbzsqgzsMgr.save(item);
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(32));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);

		//return new ActionForward("/zfxxgkbzsqgzsaction.do?method=add&id="+infoId);
		return mapping.findForward("success");
	}
}
