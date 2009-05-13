package com.baosight.base.struts.action;

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

import com.baosight.base.service.ITbOpinionOnlineMgr;
import com.baosight.base.service.ITbPublicAffairTransactMgr;
import com.baosight.mode.TbOpinionOnline;
import com.baosight.mode.TbPublicAffairTransact;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;
public class OpinionViewAction extends BaseDispatchAction {

	//	公众事务类型(30局长信箱)
	final Long affairType= new Long(30);
	private ITbOpinionOnlineMgr tbOpinionOnlineMgr;
	private ITbPublicAffairTransactMgr tbPublicAffairTransactMgr;

	
	//专办页面
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			request.setAttribute("type",  request.getParameter("type"));
			//跳转编辑页面设置好将要修改的字段
			String mainTableId=this.tbPublicAffairTransactMgr.findById(id).getAffairId();
			TbOpinionOnline mainTableRecord=this.tbOpinionOnlineMgr.findById(mainTableId);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",mainTableRecord.getAsker());
			((DynaValidatorForm) form).set("askerEmail",mainTableRecord.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",mainTableRecord.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",mainTableRecord.getSubject());
			((DynaValidatorForm) form).set("content",mainTableRecord.getContent());
			((DynaValidatorForm) form).set("response",mainTableRecord.getResponse());
			
			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(mainTableId, affairType,new Long(request.getParameter("type")));
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	
	//受理中心页面
	public ActionForward viewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			
			//跳转编辑页面设置好将要修改的字段
			TbOpinionOnline mainTableRecord=this.tbOpinionOnlineMgr.findById(id);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",mainTableRecord.getAsker());
			((DynaValidatorForm) form).set("askerEmail",mainTableRecord.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",mainTableRecord.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",mainTableRecord.getSubject());
			((DynaValidatorForm) form).set("content",mainTableRecord.getContent());
			((DynaValidatorForm) form).set("response",mainTableRecord.getResponse());
			
			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	
 	public ActionForward submitviewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (StringUtils.isNotBlank(action)) {
			String responseText = "";
			if(null!=((DynaValidatorForm) form).get("response")){
				responseText = (String) ((DynaValidatorForm) form).get("response");
			} 
			String transactor = "";
			if(action.equals("zb"))
				transactor = (String) ((DynaValidatorForm) form).get("ZB");
			else if(action.equals("idea"))
				transactor = (String) ((DynaValidatorForm) form).get("IDEA");
			//专办
			if(action.equals("zb")){
				TbOpinionOnline  updateRecord = tbOpinionOnlineMgr.findById(id);
				updateRecord.setResponse(responseText);
				updateRecord.setStatus(new Long(200));
				tbOpinionOnlineMgr.update(updateRecord);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(updateRecord.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(20));
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","40","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"400","add");
			}
			//保存
			else if(action.equals("save")){
				TbOpinionOnline  updateRecord = tbOpinionOnlineMgr.findById(id);
				updateRecord.setResponse(responseText);
				tbOpinionOnlineMgr.update(updateRecord);
			}
			//答复
			else if(action.equals("reply")){
				TbOpinionOnline  updateRecord = tbOpinionOnlineMgr.findById(id);
				updateRecord.setResponse(responseText);
				updateRecord.setResponseTime(new Date());
				updateRecord.setStatus(new Long(300));
				tbOpinionOnlineMgr.update(updateRecord);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","40","minus");
			}
			//征询意见
			else if(action.equals("idea")){
				TbOpinionOnline  updateRecord = tbOpinionOnlineMgr.findById(id);
				updateRecord.setResponse(responseText);
				updateRecord.setStatus(new Long(200));
				tbOpinionOnlineMgr.update(updateRecord);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(updateRecord.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(10));
				tbPublicAffairTransact.setAffairType(new Long(20));
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","40","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"401","add");
			}
		}
		
		return mapping.findForward(action); 
	}
	
	public ActionForward submitview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		String userName =user.getName();
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		
		String actionForwardOther="/opinionWaitListAction.do?method=list&type="+type;
		String actionForwardReply="/opinionOverListAction.do?method=list&type="+type;
		if (StringUtils.isNotBlank(action)) {
			String responseText = "";
			if(null!=((DynaValidatorForm) form).get("response")){
				responseText = (String) ((DynaValidatorForm) form).get("response");
			} 
			String transactor = "";
			if(action.equals("zb"))
				transactor = (String) ((DynaValidatorForm) form).get("ZB");
			else if(action.equals("idea"))
				transactor = (String) ((DynaValidatorForm) form).get("IDEA");
			//专办
			if(action.equals("zb")){
				TbPublicAffairTransact  tbPublicAffairTransactUpdate = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransactUpdate.setCommenta(responseText);
				tbPublicAffairTransactUpdate.setFinisheTime(new Date());
				tbPublicAffairTransactUpdate.setStatus(new Long(100));
				tbPublicAffairTransactMgr.update(tbPublicAffairTransactUpdate);
			
				TbPublicAffairTransact tbPublicAffairTransactNew=new TbPublicAffairTransact();
				tbPublicAffairTransactNew.setAffairId(tbPublicAffairTransactUpdate.getAffairId());
				tbPublicAffairTransactNew.setTransactor(transactor);
				tbPublicAffairTransactNew.setReceiveTime(new Date());
				tbPublicAffairTransactNew.setStatus(new Long(0));
				tbPublicAffairTransactNew.setType(new Long(20));
				tbPublicAffairTransactNew.setAffairType(affairType);
				tbPublicAffairTransactNew.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransactNew);
				
				if(type.equals("10")){ //由专办转为专办
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"401","minus");
				}else if(type.equals("20")){//由待领导审批转为专办
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"400","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"400","add");//转给其它人，其它人专办中要加1	
				
				return new ActionForward(actionForwardOther);
			}
			//保存
			else if(action.equals("save")){
				TbPublicAffairTransact  tbPublicAffairTransact = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransact.setCommenta(responseText);
				tbPublicAffairTransactMgr.update(tbPublicAffairTransact);
				return new ActionForward(actionForwardOther);
			}
			//答复
			else if(action.equals("reply")){
				TbPublicAffairTransact  tbPublicAffairTransact = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransact.setCommenta(responseText);
				tbPublicAffairTransact.setFinisheTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(100));
				tbPublicAffairTransactMgr.update(tbPublicAffairTransact);
				
				if(type.equals("10")){ //由专办状态答复
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"401","minus");
				}else if(type.equals("20")){//由待领导审批状态答复
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"400","minus");
				}
				
				return new ActionForward(actionForwardReply);
			}
			//征询意见
			else if(action.equals("idea")){
				TbPublicAffairTransact  tbPublicAffairTransactUpdate = this.tbPublicAffairTransactMgr.findById(id);
				tbPublicAffairTransactUpdate.setCommenta(responseText);
				tbPublicAffairTransactUpdate.setFinisheTime(new Date());
				tbPublicAffairTransactUpdate.setStatus(new Long(100));
				tbPublicAffairTransactMgr.update(tbPublicAffairTransactUpdate);
			
				TbPublicAffairTransact tbPublicAffairTransactNew=new TbPublicAffairTransact();
				tbPublicAffairTransactNew.setAffairId(tbPublicAffairTransactUpdate.getAffairId());
				tbPublicAffairTransactNew.setTransactor(transactor);
				tbPublicAffairTransactNew.setReceiveTime(new Date());
				tbPublicAffairTransactNew.setStatus(new Long(0));
				tbPublicAffairTransactNew.setType(new Long(10));
				tbPublicAffairTransactNew.setAffairType(affairType);
				tbPublicAffairTransactNew.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransactNew);
				
				if(type.equals("10")){ //由原来专办状态转
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"401","minus");
				}else if(type.equals("20")){//由原来待领导审批状态转
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"400","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"401","add");//转给其它人，其它人待领导审批中要加1
				
				return new ActionForward(actionForwardOther);
			}
		} 
		return null;
	}
	
	public void setTbPublicAffairTransactMgr(
			ITbPublicAffairTransactMgr tbPublicAffairTransactMgr) {
		this.tbPublicAffairTransactMgr = tbPublicAffairTransactMgr;
	}

	public void setTbOpinionOnlineMgr(ITbOpinionOnlineMgr tbOpinionOnlineMgr) {
		this.tbOpinionOnlineMgr = tbOpinionOnlineMgr;
	}


	
}
