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
import com.baosight.base.service.ITbConsultationOnlineMgr;
import com.baosight.base.service.ITbPublicAffairTransactMgr;
import com.baosight.mode.TbConsultationOnline;
import com.baosight.mode.TbPublicAffairTransact;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;
public class ConsultationViewAction extends BaseDispatchAction {
	
	//公众事务类型(10 网上咨询)
	final Long affairType= new Long(10);
	private ITbConsultationOnlineMgr tbConsultationOnlineMgr;
	private ITbPublicAffairTransactMgr tbPublicAffairTransactMgr;
	
	//专办(待领导审批)页面
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			request.setAttribute("type",  request.getParameter("type"));
			//跳转编辑页面设置好将要修改的字段
			String tbConsultationOnlineID=this.tbPublicAffairTransactMgr.findById(id).getAffairId();
			TbConsultationOnline tbConsultationOnline=this.tbConsultationOnlineMgr.findById(tbConsultationOnlineID);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",tbConsultationOnline.getAsker());
			((DynaValidatorForm) form).set("askerEmail",tbConsultationOnline.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",tbConsultationOnline.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",tbConsultationOnline.getSubject());
			((DynaValidatorForm) form).set("content",tbConsultationOnline.getContent());
			((DynaValidatorForm) form).set("response",tbConsultationOnline.getResponse());
			
			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(tbConsultationOnlineID, affairType,new Long(request.getParameter("type")));
			System.out.println("tbPublicAffairTransacts.size"+tbPublicAffairTransacts.size());
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	
	//受理中心页面
	public ActionForward viewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			
			//跳转编辑页面设置好将要修改的字段
			TbConsultationOnline tbConsultationOnline=this.tbConsultationOnlineMgr.findById(id);
			((DynaValidatorForm) form).set("id", id);
			((DynaValidatorForm) form).set("asker",tbConsultationOnline.getAsker());
			((DynaValidatorForm) form).set("askerEmail",tbConsultationOnline.getAskerEmail());
			((DynaValidatorForm) form).set("askerPhone",tbConsultationOnline.getAskerPhone());
			((DynaValidatorForm) form).set("Subject",tbConsultationOnline.getSubject());
			((DynaValidatorForm) form).set("content",tbConsultationOnline.getContent());
			((DynaValidatorForm) form).set("response",tbConsultationOnline.getResponse());

			List tbPublicAffairTransacts = tbPublicAffairTransactMgr.getPublicAffairTransactById(id, affairType,new Long(0));
			request.setAttribute("publicAffairTransacts",tbPublicAffairTransacts);
			return mapping.findForward("view");
	}
	/*
	 * 网上咨询 提交
	 */
 	public ActionForward submitviewCenter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
 		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		String userName =user.getName();
		
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
				TbConsultationOnline  tbConsultationOnline = tbConsultationOnlineMgr.findById(id);
				tbConsultationOnline.setResponse(responseText);
				tbConsultationOnline.setStatus(new Long(200));
				tbConsultationOnlineMgr.update(tbConsultationOnline);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbConsultationOnline.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(20));
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","10","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"100","add");//转给其它人，其它人专办中要加1				
			}
			//保存
			else if(action.equals("save")){
				TbConsultationOnline  tbConsultationOnline = tbConsultationOnlineMgr.findById(id);
				tbConsultationOnline.setResponse(responseText);
				tbConsultationOnlineMgr.update(tbConsultationOnline);
			}
			//答复
			else if(action.equals("reply")){
				TbConsultationOnline  tbConsultationOnline = tbConsultationOnlineMgr.findById(id);
				tbConsultationOnline.setResponse(responseText);
				tbConsultationOnline.setResponseTime(new Date());
				tbConsultationOnline.setStatus(new Long(300));
				tbConsultationOnline.setResponseor(userName);
				tbConsultationOnlineMgr.update(tbConsultationOnline);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","10","minus");
			}
			//征询意见
			else if(action.equals("idea")){
				TbConsultationOnline  tbConsultationOnline = tbConsultationOnlineMgr.findById(id);
				tbConsultationOnline.setResponse(responseText);
				tbConsultationOnline.setStatus(new Long(200));
				tbConsultationOnlineMgr.update(tbConsultationOnline);
				
				TbPublicAffairTransact tbPublicAffairTransact=new TbPublicAffairTransact();
				tbPublicAffairTransact.setAffairId(tbConsultationOnline.getId());
				tbPublicAffairTransact.setTransactor(transactor);
				tbPublicAffairTransact.setBeforeTransactor(userId);
				tbPublicAffairTransact.setReceiveTime(new Date());
				tbPublicAffairTransact.setStatus(new Long(0));
				tbPublicAffairTransact.setType(new Long(10));
				tbPublicAffairTransact.setAffairType(affairType);
				tbPublicAffairTransact.setCommenta(" ");
				tbPublicAffairTransactMgr.save(tbPublicAffairTransact);
				
				super.tbUserOpeationMgr.SaveOrUpdate("","10","minus");
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"101","add");//转给其它人，其它人待领导审批中要加1
			}
		}
		
		return mapping.findForward(action); 
	}
 	/*
	 * 网上咨询（专办、意见征询） 提交
	 */
	public ActionForward submitview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
 		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String userId = user.getId();
		String userName =user.getName();
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		
		String actionForwardOther="/consultationWaitListAction.do?method=list&type="+type;
		String actionForwardReply="/consultationOverListAction.do?method=list&type="+type;
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"101","minus");
				}else if(type.equals("20")){//由待领导审批转为专办
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"100","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"100","add");//转给其它人，其它人专办中要加1		
				
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"101","minus");
				}else if(type.equals("20")){//由待领导审批状态答复
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"100","minus");
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
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"101","minus");
				}else if(type.equals("20")){//由原来待领导审批状态转
					super.tbUserOpeationMgr.SaveOrUpdate(userId,"100","minus");
				}
				super.tbUserOpeationMgr.SaveOrUpdate(transactor,"101","add");//转给其它人，其它人待领导审批中要加1
				return new ActionForward(actionForwardOther);	
			}
		}
		return null; 
	
	}
	
	public void setTbConsultationOnlineMgr(
			ITbConsultationOnlineMgr tbConsultationOnlineMgr) {
		this.tbConsultationOnlineMgr = tbConsultationOnlineMgr;
	}

	public void setTbPublicAffairTransactMgr(
			ITbPublicAffairTransactMgr tbPublicAffairTransactMgr) {
		this.tbPublicAffairTransactMgr = tbPublicAffairTransactMgr;
	}




	
}
