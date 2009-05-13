package com.baosight.base.struts.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.baosight.base.dao.impl.TbUserDAOImpl;
import com.baosight.base.service.ITbAppealOnlineMgr;
import com.baosight.base.service.ITbPublicAffairTransactMgr;
import com.baosight.mode.TbAppealOnline;
import com.baosight.mode.TbUser;

import com.baosight.mode.TbPublicAffairTransact;
import com.baosight.struts.action.BaseDispatchAction;
public class AppealViewAction extends BaseDispatchAction {

	//	公众事务类型(20网上投诉)
	final Long affairType= new Long(20);
	private ITbAppealOnlineMgr tbAppealOnlineMgr;
	private ITbPublicAffairTransactMgr tbPublicAffairTransactMgr;

	
	//专办页面
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			request.setAttribute("type",  request.getParameter("type"));
			//跳转编辑页面设置好将要修改的字段
			String tbAppealOnlineId=this.tbPublicAffairTransactMgr.findById(id).getAffairId();
			TbAppealOnline tbAppealOnline=this.tbAppealOnlineMgr.findById(tbAppealOnlineId);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",tbAppealOnline.getAsker());
			((DynaValidatorForm) form).set("askerEmail",tbAppealOnline.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",tbAppealOnline.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",tbAppealOnline.getSubject());
			((DynaValidatorForm) form).set("content",tbAppealOnline.getContent());
			((DynaValidatorForm) form).set("response",tbAppealOnline.getResponse());
			
			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(tbAppealOnlineId, affairType,new Long(request.getParameter("type")));
			System.out.println("tbPublicAffairTransacts.size"+tbPublicAffairTransacts.size());
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	
	//受理中心页面
	public ActionForward viewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			
			//跳转编辑页面设置好将要修改的字段
			TbAppealOnline tbAppealOnline=this.tbAppealOnlineMgr.findById(id);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",tbAppealOnline.getAsker());
			((DynaValidatorForm) form).set("askerEmail",tbAppealOnline.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",tbAppealOnline.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",tbAppealOnline.getSubject());
			((DynaValidatorForm) form).set("content",tbAppealOnline.getContent());
			((DynaValidatorForm) form).set("response",tbAppealOnline.getResponse());
			
			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	
 	public ActionForward submitviewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
 		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		
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
				TbAppealOnline  tbAppealOnline = tbAppealOnlineMgr.findById(id);
				tbAppealOnline.setResponse(responseText);
				tbAppealOnline.setStatus(new Long(200));
				tbAppealOnlineMgr.update(tbAppealOnline);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbAppealOnline.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(20));
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				super.tbUserOpeationMgr.SaveOrUpdate("","20","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"200","add");//转给其它人，其它人专办中要加1				
			}
			//保存
			else if(action.equals("save")){
				TbAppealOnline  tbAppealOnline = tbAppealOnlineMgr.findById(id);
				tbAppealOnline.setResponse(responseText);
				tbAppealOnlineMgr.update(tbAppealOnline);
			}
			//答复
			else if(action.equals("reply")){
				TbAppealOnline  tbAppealOnline = tbAppealOnlineMgr.findById(id);
				tbAppealOnline.setResponse(responseText);
				tbAppealOnline.setResponseTime(new Date());
				tbAppealOnline.setStatus(new Long(300));
				tbAppealOnlineMgr.update(tbAppealOnline);
				super.tbUserOpeationMgr.SaveOrUpdate("","20","minus");
			}
			//征询意见
			else if(action.equals("idea")){
				TbAppealOnline  tbAppealOnline = tbAppealOnlineMgr.findById(id);
				tbAppealOnline.setResponse(responseText);
				tbAppealOnline.setStatus(new Long(200));
				tbAppealOnlineMgr.update(tbAppealOnline);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbAppealOnline.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(10));
				tbPublicAffairTransact.setAffairType(new Long(20));
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				super.tbUserOpeationMgr.SaveOrUpdate("","20","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"201","add");//转给其它人，其它人待领导审批中要加1
			}
		}
		
		return mapping.findForward(action); 
	}
	
	public ActionForward submitview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		
		String actionForwardOther="/appealWaitListAction.do?method=list&type="+type;
		String actionForwardReply="/appealOverListAction.do?method=list&type="+type;
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"201","minus");
				}else if(type.equals("20")){//由待领导审批转为专办
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"200","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"200","add");//转给其它人，其它人专办中要加1		
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"201","minus");
				}else if(type.equals("20")){//由待领导审批状态答复
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"200","minus");
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"201","minus");
				}else if(type.equals("20")){//由原来待领导审批状态转
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"200","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"201","add");//转给其它人，其它人待领导审批中要加1
				return new ActionForward(actionForwardOther);
			}
		} 
		return null;
	}
	
	public void setTbPublicAffairTransactMgr(
			ITbPublicAffairTransactMgr tbPublicAffairTransactMgr) {
		this.tbPublicAffairTransactMgr = tbPublicAffairTransactMgr;
	}

	public void setTbAppealOnlineMgr(ITbAppealOnlineMgr tbAppealOnlineMgr) {
		this.tbAppealOnlineMgr = tbAppealOnlineMgr;
	}


	
}
