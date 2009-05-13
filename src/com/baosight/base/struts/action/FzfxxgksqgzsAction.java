package com.baosight.base.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.mode.TbFzfxxgksqgzs;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.struts.action.BaseDispatchAction;

public class FzfxxgksqgzsAction extends BaseDispatchAction {

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		//String rem = request.getParameter("rem");
		String isOrNotPrint = request.getParameter("isOrNotPrint");
		request.setAttribute("id", id);
		
		List infoIdlist = super.fzfxxgksqgzsMgr.findByInfoId(id);
		String lsNo = "";
		String sqTime = "";
		String dfTime = "";
		String editYesOrNo = "";
		if (infoIdlist.size() > 0) {
			TbFzfxxgksqgzs tbFzfxxgksqgzs = (TbFzfxxgksqgzs) infoIdlist.get(0);
			((DynaValidatorForm) form).set("applicant", tbFzfxxgksqgzs
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbFzfxxgksqgzs.getAttr1());
			((DynaValidatorForm) form).set("attr2", tbFzfxxgksqgzs.getAttr2());
			lsNo = tbFzfxxgksqgzs.getLsNo();
			sqTime = tbFzfxxgksqgzs.getSqTime().toString();
			dfTime = tbFzfxxgksqgzs.getDfTime().toString();
			editYesOrNo = "0";
		} else {
			List statusList = super.fzfxxgksqgzsMgr.findAll();
			TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) super.tbGovInfoPubMgr
					.findById(id);
			((DynaValidatorForm) form).set("applicant", tbGovInfoPub
					.getApplicant());
			((DynaValidatorForm) form).set("attr1", tbGovInfoPub.getReason());
			((DynaValidatorForm) form).set("attr2", tbGovInfoPub.getPassWay());
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
		//request.setAttribute("rem", rem);
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
		TbFzfxxgksqgzs item = new TbFzfxxgksqgzs(infoId, lsNo, applicant,
				sqTimeDate, dfTimeDate, attr1, attr2);
		super.fzfxxgksqgzsMgr.save(item);
		TbGovInfoPub tbGovInfoPub = (TbGovInfoPub) (super.tbGovInfoPubMgr
				.findById(infoId));
		TbGovInfoPubAudit tbGovInfoPubAudit = tbGovInfoPub
				.getTbGovInfoPubAudit();
		tbGovInfoPubAudit.setStatus(new Long(2048));
		//tbGovInfoPubAudit.setRem(request.getParameter("rem"));
		super.tbGovInfoPubMgr.update(tbGovInfoPub);
		
		super.tbUserOpeationMgr.SaveOrUpdate("","9","minus");
		//return new ActionForward("/fzfxxgksqgzsaction.do?method=add&id="+infoId);
		return mapping.findForward("success");
	}
}
