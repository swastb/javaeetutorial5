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
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.service.IInfoAuditMgr;
import com.baosight.mode.TbGovInfoPub;
import com.baosight.mode.TbGovInfoPubAudit;
import com.baosight.mode.TbOpinionConsult;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class InfoAuditAtion extends BaseDispatchAction {
	protected IInfoAuditMgr infoAuditMgr;
	
	
	public IInfoAuditMgr getInfoAuditMgr() {
		return infoAuditMgr;
	} 

	public void setInfoAuditMgr(IInfoAuditMgr infoAuditMgr) {
		this.infoAuditMgr = infoAuditMgr;
	}

	public ActionForward findAuditList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String condition=request.getParameter("condition");
		
		//查询结果
		List infoAuditList=this.infoAuditMgr.findByStatus(condition);
		
		//把数据库里的数字换成汉字
		for(int i=0;i<infoAuditList.size();i++){
			TbGovInfoPub tbGovInfoPub=((TbGovInfoPubAudit)(infoAuditList.get(i))).getTbGovInfoPub();
			TbGovInfoPubAudit tbGovInfoPubAudit=(TbGovInfoPubAudit)infoAuditList.get(i);
			
			String applyType=tbGovInfoPub.getApplyType();
			Long status=tbGovInfoPubAudit.getStatus();
			if(applyType.equals("10")){
				tbGovInfoPub.setApplyType("个人");
			}else if(applyType.equals("20")){
				tbGovInfoPub.setApplyType("企业");
			}
			if(status==8 || status==8200){
				tbGovInfoPubAudit.setStatusName("同意");
			}else if(status==16){
				tbGovInfoPubAudit.setStatusName("部分同意");
			}else if(status==4096 || status==128 || status==64 || status==256 || status==1024 || status==16384 || status==12298){
				tbGovInfoPubAudit.setStatusName("不同意");
			}else if(status==32){
				tbGovInfoPubAudit.setStatusName("补正申请");
			}else if(status==2){
				tbGovInfoPubAudit.setStatusName("意见征询");
			}else if(status==262144){
				tbGovInfoPubAudit.setStatusName("申请收件回执");
			}else if(status==32768){
				tbGovInfoPubAudit.setStatusName("权利人告知单");
			}else if(status==65536){
				tbGovInfoPubAudit.setStatusName("重复申请");
			}else if(status==131072){
				tbGovInfoPubAudit.setStatusName("延期答复");
			}else if(status==524288){
				tbGovInfoPubAudit.setStatusName("无效申请");//无效申请列表中状态
			}else if(status==2048){
				tbGovInfoPubAudit.setStatusName("不予受理");//不予受理列表中状态
			}
		}
		
		//分页
		long count=infoAuditList.size();
		startPagingCount(null, request,count);
		startPaging(infoAuditList, null, request);

		return mapping.findForward("list");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)){
			TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(id);
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(524288));
			this.infoAuditMgr.modifyStatus(tbGovInfoPub);
			//tbGovInfoPubMgr.delete(id);
			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}
	
	public ActionForward findAuditingCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		
		//int count = this.infoAuditMgr.findAuditingCount();
		
		//super.tbUserOpeationMgr.SaveOrUpdate(receiversId,"9","add");
		
		return null;
	}
	
	/*public ActionForward findOpinionConsult(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String govInfoId=request.getParameter("id");

			List opinionConsultList=this.infoAuditMgr.findOpinionListByFKId(govInfoId);
			if(opinionConsultList.size()>0){
				TbOpinionConsult oc=(TbOpinionConsult)opinionConsultList.get(0);
				((DynaValidatorForm) form).set("id",oc.getId());
				((DynaValidatorForm) form).set("govInfoId",oc.getGovInfoId());
				((DynaValidatorForm) form).set("attr1",oc.getAttr1());
				((DynaValidatorForm) form).set("attr2",oc.getAttr2());
				((DynaValidatorForm) form).set("numb",oc.getNumb());
				((DynaValidatorForm) form).set("consultedName",oc.getConsultedName());
				((DynaValidatorForm) form).set("applicant",oc.getApplicant());
				((DynaValidatorForm) form).set("cause",oc.getCause());
				((DynaValidatorForm) form).set("address",oc.getAddress());
				((DynaValidatorForm) form).set("postalcode",oc.getPostalcode());
				Date date=oc.getArriveDate();
				Date date1=oc.getSignDate();
				((DynaValidatorForm) form).set("year",(date.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("month",date.getMonth()+1+"");
				((DynaValidatorForm) form).set("day",date.getDate()+"");

				((DynaValidatorForm) form).set("year1",(date1.getYear()+1900)+"");	
				((DynaValidatorForm) form).set("month1",date1.getMonth()+1+"");
				((DynaValidatorForm) form).set("day1",date1.getDate()+"");
				((DynaValidatorForm) form).set("action","modify");
			}else{
				((DynaValidatorForm) form).set("attr1","");
				((DynaValidatorForm) form).set("attr2","");
				((DynaValidatorForm) form).set("numb","");
				((DynaValidatorForm) form).set("cause","");
				((DynaValidatorForm) form).set("address","");
				((DynaValidatorForm) form).set("postalcode","");
				((DynaValidatorForm) form).set("year","");
				((DynaValidatorForm) form).set("month","");
				((DynaValidatorForm) form).set("day","");
				((DynaValidatorForm) form).set("year1","");
				((DynaValidatorForm) form).set("month1","");
				((DynaValidatorForm) form).set("day1","");
				((DynaValidatorForm) form).set("consultedName","（被征询人姓名或者名称）:");
				((DynaValidatorForm) form).set("applicant","申请人（单位）姓名（名称）");
				((DynaValidatorForm) form).set("action","add");
				((DynaValidatorForm) form).set("govInfoId",govInfoId);
			}
		return mapping.findForward("opinionConsultList");
	}
	
	public ActionForward saveOpinion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String action = (String) ((DynaValidatorForm) form).get("action");
		
		String govInfoId = (String) ((DynaValidatorForm) form).get("govInfoId");
		String attr1 = (String) ((DynaValidatorForm) form).get("attr1");
		String attr2 = (String) ((DynaValidatorForm) form).get("attr2");
		String numb = (String) ((DynaValidatorForm) form).get("numb");
		String consultedName = (String) ((DynaValidatorForm) form).get("consultedName");
		String applicant = (String) ((DynaValidatorForm) form).get("applicant");
		String cause = (String) ((DynaValidatorForm) form).get("cause");
		String address = (String) ((DynaValidatorForm) form).get("address");
		String postalcode = (String) ((DynaValidatorForm) form).get("postalcode");
		String year = (String) ((DynaValidatorForm) form).get("year");
		String month = (String) ((DynaValidatorForm) form).get("month");
		String day = (String) ((DynaValidatorForm) form).get("day");
		String year1 = (String) ((DynaValidatorForm) form).get("year1");
		String month1 = (String) ((DynaValidatorForm) form).get("month1");
		String day1 = (String) ((DynaValidatorForm) form).get("day1");
		String date=year+"-"+month+"-"+day;
		String date1=year1+"-"+month1+"-"+day1;
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date arriveDate=null;
		Date signDate=null;
		if(!"".equals(year)&&!"".equals(month)&&!"".equals(day)){
			arriveDate = dateFormat.parse (date);
		} 
		if(!"".equals(year1)&&!"".equals(month1)&&!"".equals(day1)){
			signDate = dateFormat.parse (date1);
		}
		
		if(action.equals("add")){ //添加
			TbOpinionConsult item = new TbOpinionConsult(govInfoId,attr1,attr2,numb,
					consultedName,arriveDate, applicant,cause, address,postalcode,signDate);
			
			item.setGovInfoId(govInfoId);
			item.setAttr1(attr1);
			item.setAttr2(attr2);
			item.setAddress(address);
			item.setApplicant(applicant);
			item.setCause(cause);
			item.setConsultedName(consultedName);
			item.setNumb(numb);
			item.setPostalcode(postalcode);
			item.setSignDate(signDate);
			item.setArriveDate(arriveDate);
			
			this.infoAuditMgr.save(item);
			((DynaValidatorForm) form).set("action","modify");
		
			//改变状态
			TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(govInfoId);
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(2));
			this.infoAuditMgr.modifyStatus(tbGovInfoPub);
		}else if(action.equals("modify")){ //修改
			List opinionConsultList=this.infoAuditMgr.findOpinionListByFKId(govInfoId);
			TbOpinionConsult item =(TbOpinionConsult)opinionConsultList.get(0);
			
			item.setAttr1(attr1);
			item.setAttr2(attr2);
			item.setAddress(address);
			item.setApplicant(applicant);
			item.setCause(cause);
			item.setConsultedName(consultedName);
			item.setNumb(numb);
			item.setPostalcode(postalcode);
			item.setSignDate(signDate);
			item.setArriveDate(arriveDate);
			
			this.infoAuditMgr.modify(item);
			
			TbGovInfoPub tbGovInfoPub=this.infoAuditMgr.findById(govInfoId);
			tbGovInfoPub.getTbGovInfoPubAudit().setStatus(new Long(2));
			this.infoAuditMgr.modifyStatus(tbGovInfoPub);	
		}
		return mapping.findForward("turnToAuditing");
	}*/
	
}
