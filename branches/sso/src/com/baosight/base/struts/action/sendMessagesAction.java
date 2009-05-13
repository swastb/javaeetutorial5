package com.baosight.base.struts.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.CLOB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.hibernate.Hibernate;
import org.hibernate.lob.SerializableClob;

import com.baosight.base.service.IMessagesMgr;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class sendMessagesAction extends BaseDispatchAction{
protected IMessagesMgr messagesMgr;
	
	public void setMessagesMgr(IMessagesMgr messagesMgr) {
		this.messagesMgr = messagesMgr;
	}

	public ActionForward findMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//取当前的登陆用户名
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		
		List messagesList=this.messagesMgr.findByParam(receiversId);
		request.setAttribute("msgList",messagesList);
		
//		分页
		long count= messagesList.size();
		startPagingCount(null, request,count);
		startPaging(messagesList, null, request);
		
		return mapping.findForward("list");
	}
	
	public ActionForward lookupMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		TbMessages msg=this.messagesMgr.findById(id);
		((DynaValidatorForm) form).set("id",msg.getId());
		((DynaValidatorForm) form).set("senderId",msg.getSenderId());
		((DynaValidatorForm) form).set("senderName",msg.getSenderName());
		((DynaValidatorForm) form).set("receiversName",msg.getReceiversName());
		((DynaValidatorForm) form).set("title",msg.getTitle());
		if(null != msg.getContent()){
			SerializableClob  sc= (SerializableClob)msg.getContent();
			Clob wrapclob = sc.getWrappedClob();
			CLOB clob = (CLOB)wrapclob;
			
			Reader is = clob.getCharacterStream ();
		    BufferedReader br = new BufferedReader ( is );
		    String s = br.readLine ();
		    String content = "";
		    while ( s != null )
		       {
		         content += s ;
		         s = br.readLine ();
		       }
		       br.close();
		       is.close();
		       ((DynaValidatorForm) form).set("content", content);
		}   
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		((DynaValidatorForm) form).set("sendWay",msg.getSendWay());
		((DynaValidatorForm) form).set("status",new Long(3));
		((DynaValidatorForm) form).set("sendTime",df.format(msg.getSendTime()));
		((DynaValidatorForm) form).set("source",source);
		request.setAttribute("sendWay", msg.getSendWay());
		
		//查看之后改状态
		msg.setStatus(new Long(3));
		this.messagesMgr.update(msg);
		
		return mapping.findForward("lookupMessages");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		this.messagesMgr.delete(id);
		
		return mapping.findForward("success");
	}
	
	public ActionForward revertMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		TbMessages msg=this.messagesMgr.findById(id);
		((DynaValidatorForm) form).set("id",msg.getId());
		((DynaValidatorForm) form).set("title",msg.getTitle());
		((DynaValidatorForm) form).set("receiversName",msg.getSenderName());
		
		return mapping.findForward("revertMessages");
	}
	
	public ActionForward findNotReadMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getName();
		
		List messagesList=this.messagesMgr.findNotReadMsg(receiversId);
		request.setAttribute("notReadMsgList",messagesList);
		long count=messagesList.size();
		startPagingCount(null, request,count);
		startPaging(messagesList, null, request);
		return mapping.findForward("notReadMessages");
	}
	
	public ActionForward findNotReadMsgCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		
		int count=this.messagesMgr.findNotRead(receiversId);
		request.setAttribute("notReadMsgCount",count);
		
		return mapping.findForward("");
	}
	
	/**
	 * 显示所有消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward sendBoxList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		List messagesList = this.messagesMgr.findselfMessages(receiversId);
		
//		分页
		long count=messagesList.size();
		startPagingCount(null, request,count);
		startPaging(messagesList, null, request);
		
		request.setAttribute("msgList", messagesList);

		return mapping.findForward("listMessagesbox");
	}
	
	/**
	 * 发送消息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	public ActionForward sendMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String id=request.getParameter("id");
		Date date=new Date();	
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String action = request.getParameter("action");
		
		List userList = this.messagesMgr.findAllUser();//获取系统用户列表
		request.setAttribute("userList", userList);//保存系统用户
		
		List friendsList = this.messagesMgr.findAllFriends();//获取好友列表
		request.setAttribute("friendsList", friendsList);//保存好友
		
		if (action != null && !action.equals("")) {
			if (action.equals("add")) {
				((DynaValidatorForm) form).set("sendWay",new Long(1));
				request.setAttribute("sendWay",new Long(1));
				
				return mapping.findForward("sendMessages");
			}
			if(action.equals("revert")){
				TbMessages msg=this.messagesMgr.findById(id);
				((DynaValidatorForm) form).set("id",msg.getId());
				((DynaValidatorForm) form).set("title",msg.getTitle());
				((DynaValidatorForm) form).set("receiversName",msg.getSenderName());
				request.setAttribute("source","receivers");
				if(msg.getSendWay().toString().length()==2){
					((DynaValidatorForm) form).set("sendWay1","1");
					((DynaValidatorForm) form).set("sendWay2","2");
				}else{
					if(msg.getSendWay().toString().equals("1")){
						((DynaValidatorForm) form).set("sendWay1","1");
					}else if(msg.getSendWay().toString().equals("2")){
						((DynaValidatorForm) form).set("sendWay2","2");
					}
				}
				//((DynaValidatorForm) form).set("sendWay",msg.getSendWay());
				
				request.setAttribute("sendWay", msg.getSendWay());
			}
			if (action.equals("submit")) {
				String senderName = user.getName();
				String senderId = user.getId();
				String receiversId = (String) ((DynaValidatorForm) form)
						.get("receiversId");
				String receiversName = (String) ((DynaValidatorForm) form)
						.get("receiversName");
				String title = (String) ((DynaValidatorForm) form).get("title");
				String content = (String) ((DynaValidatorForm) form)
						.get("content");
				Long sendWay = new Long(0);
				//if(null != ((DynaValidatorForm) form).get("sendWay")){
				//	sendWay = (Long) ((DynaValidatorForm) form).get("sendWay");
				//}
				String sendWay1 =((DynaValidatorForm) form).get("sendWay1").toString();
				String sendWay2 =((DynaValidatorForm) form).get("sendWay2").toString();
				
				if(null !=sendWay1 && null != sendWay2){
					sendWay = new Long(12);
				}else if(null != sendWay1 && null == sendWay2) {
					sendWay = new Long(2);
				}else if(null == sendWay1 && null != sendWay2) {
					sendWay = new Long(1);
				}else{
					sendWay = new Long(0);
				}
				
				Long status = (Long) ((DynaValidatorForm) form).get("status");
				TbMessages item = new TbMessages(senderId, senderName, "",
						receiversName, "", title,
						Hibernate.createClob(content),date, sendWay, status);
				this.messagesMgr.save(item);

				return mapping.findForward("delMessagesbox");
			}
		}
		return mapping.findForward("sendMessages");
	}
	
	public ActionForward deleteSend(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		this.messagesMgr.sendDelete(id);
		return mapping.findForward("delMessagesbox");
	}

}
