package com.baosight.base.struts.action;

import java.util.Calendar;
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
import com.baosight.base.service.ITbUserOpeationMgr;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbOaSmsSchedule;
import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MessagesAction extends BaseDispatchAction{
	
	/**
	 * 	收件箱
	 * 
	 */
	public ActionForward findMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//取当前的登陆用户id
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		List messagesList=this.messagesMgr.findByParam(receiversId);
		request.setAttribute("msgList",messagesList);
//		分页
		long count=messagesList.size();
		startPagingCount(null, request,count);
		startPaging(messagesList, null, request);
		return mapping.findForward("list");
	}
	
	public ActionForward messageLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ParseException{
		TbUser user = getCurrentUser(request);
		String receiverId = user.getId();
		response.setCharacterEncoding("GBK");
		List messagesList=this.messagesMgr.findNewByReceiverId(receiverId);
		if(messagesList!=null && !messagesList.isEmpty()){
			if(messagesList.size()==1){
				response.getWriter().write(((TbMessages)messagesList.get(0)).getId());
				return null;
			}else{
				StringBuffer sb = new StringBuffer();
				String path = request.getContextPath();
				for(Object obj:messagesList){
					TbMessages msg = (TbMessages)obj;
					sb.append("<a href='#' onclick=\"openMessage('").append(msg.getId()).append("');return false;\">");
					sb.append(msg.getTitle()).append("</a>; ");
				}
				response.getWriter().write(sb.toString());
			}
		}
		return null;
	}

//	protected String getMessageUrl(String path,String id){
//		return path+"/messages.do?method=lookupMessages&id="+id+"&source=receivers&forwardFlag=messagelogin";
//	}

	/**
	 * 	查看消息
	 * 
	 */
	public ActionForward lookupMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		TbMessages msg=this.messagesMgr.findById(id);
		((DynaValidatorForm) form).set("id",msg.getId());
		((DynaValidatorForm) form).set("senderId",msg.getSenderId());
		((DynaValidatorForm) form).set("senderName",msg.getSenderName());
		((DynaValidatorForm) form).set("receiversname",msg.getReceiversName());
		((DynaValidatorForm) form).set("title",msg.getTitle());
		((DynaValidatorForm) form).set("messageType",msg.getMessageType());
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
		int status = msg.getStatus().intValue();
		if(status!=3){
			msg.setStatus(new Long(3));
			this.messagesMgr.update(msg);
		}
		String flag = request.getParameter("forwardFlag");
		if(flag!=null && !"".equals(flag)){
			return mapping.findForward(flag);
		}else{
			return mapping.findForward("lookupMessages");
		}
	}
	
	/**
	 * 删除收件箱消息
	 * 
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		this.messagesMgr.delete(id);
		
		return mapping.findForward("success");
	}
	
	/**
	 * 	回复消息
	 * 
	 */
	public ActionForward revertMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		TbMessages msg=this.messagesMgr.findById(id);
		((DynaValidatorForm) form).set("id",msg.getId());
		((DynaValidatorForm) form).set("title",msg.getTitle());
		((DynaValidatorForm) form).set("receiversname",msg.getSenderName());
		
		return mapping.findForward("revertMessages");
	}
	
	/**
	 * 	未读消息列表
	 * 
	 */
	public ActionForward findNotReadMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String receiversId = user.getId();
		
		List messagesList=this.messagesMgr.findNotReadMsg(receiversId);
		request.setAttribute("notReadMsgList",messagesList);
		long count=messagesList.size();
		startPagingCount(null, request,count);
		startPaging(messagesList, null, request);
		return mapping.findForward("notReadMessages");
	}
	
	/**
	 * 	未读消息条数
	 * 
	 */
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
	 * 	发件箱
	 * 
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
	 *  发送消息
	 * @throws IOException 
	 * 
	 */
	public ActionForward sendMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		String id=request.getParameter("id");
		
		Date date = new   Date(System.currentTimeMillis());
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("SYSTEM_USER_SESSION");
		String action = request.getParameter("action");
		List userList = this.messagesMgr.findAllUser();//获取系统用户列表
		request.setAttribute("userList", userList);//保存系统用户
		
		if (action != null && !action.equals("")) {
			//发信息
			if (action.equals("add")) {
				((DynaValidatorForm) form).set("sendWay1","1");
				((DynaValidatorForm) form).set("nowTime","1");
				request.setAttribute("sendWay1","1");
				return mapping.findForward("sendMessages");
			}
			//回复信息
			if(action.equals("revert")){
				TbMessages msg=this.messagesMgr.findById(id);
				//把状态改为已读
				msg.setStatus(new Long(3));
				this.messagesMgr.update(msg);
				//初始化页面内容
				((DynaValidatorForm) form).set("id",msg.getId());
				((DynaValidatorForm) form).set("title",msg.getTitle());
				((DynaValidatorForm) form).set("receiversname",msg.getSenderName());
				((DynaValidatorForm) form).set("nowTime","1");
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
				request.setAttribute("sendWay", msg.getSendWay());
			}
			//提交
			if (action.equals("submit")) {
				Date selectTime = new   Date(System.currentTimeMillis());;
				String senderName = user.getName();
				String senderId = user.getId();
				String receiversName = (String) ((DynaValidatorForm) form).get("receiversname");
				String receivers = (String) ((DynaValidatorForm) form).get("receivers");
				String title = (String) ((DynaValidatorForm) form).get("title");
				String content = (String) ((DynaValidatorForm) form).get("content");
				String nowTime = (String) ((DynaValidatorForm) form).get("nowTime");
				String setTime = (String) ((DynaValidatorForm) form).get("setTime");
				String hourTime = (String) ((DynaValidatorForm) form).get("hourTime");
				String dayTime = (String) ((DynaValidatorForm) form).get("dayTime");
				
				String sendWay1 =((DynaValidatorForm) form).get("sendWay1").toString();
				String sendWay2 =((DynaValidatorForm) form).get("sendWay2").toString();
				Long sendWay = new Long(0) ;
				String destNumber ="";//收件人的电话号码
				Boolean isSJDX = false; //标志是否是手机短信
				
				//1表示选择站内短信，2表示选择手机短信，12表示选择站内短信和手机短信
				if("1".equals(sendWay1) && "2".equals(sendWay2)){
					sendWay = new Long(12);
					isSJDX = true;
				}else if("1".equals(sendWay1) && !"2".equals(sendWay2)) {
					sendWay = new Long(1);
				}else if(!"1".equals(sendWay1) && "2".equals(sendWay2)) {
					sendWay = new Long(2);
					isSJDX = true;
				}
				
				//手机发送方式
				if(isSJDX){
					String[] receiverArray = receivers.split(",");
					destNumber = this.messagesMgr.findTel(receiverArray);
				}
				
				//选择了立即发送
				if(nowTime.equals("1")){
					TbMessages item = new TbMessages(senderId, senderName, receivers,
							receiversName, "", title,
							Hibernate.createClob(content),date, sendWay, new Long(2));
					this.messagesMgr.save(item);
					
					if(isSJDX){ //如果选择的有手机短信
						TbOaSmsSchedule  schedule = new TbOaSmsSchedule(date, "", destNumber,
							content,"ZNDX", "1",user.getDeptCode(), senderId, "","");
						this.messagesMgr.saveSchedule(schedule);
					}
				}
				
//				设定了定时发送时间
				if(setTime.equals("1")){
					String d = (String) ((DynaValidatorForm) form).get("selectTime");
					DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					selectTime = format.parse(d);
					TbMessages item = new TbMessages(senderId, senderName, receivers,
							receiversName, "", title,
							Hibernate.createClob(content),selectTime, sendWay, new Long(2));
					this.messagesMgr.save(item);
					
					if(isSJDX){ //如果选择的有手机短信
						TbOaSmsSchedule  schedule = new TbOaSmsSchedule(selectTime, "", destNumber,
							content, "ZNDX", "1",user.getDeptCode(), senderId, "","");
						this.messagesMgr.saveSchedule(schedule);
					}
				}
				
//				设定了提前一个小时发送
				if(hourTime.equals("1")){
					Calendar   cal=Calendar.getInstance(); 
					cal.setTime(selectTime);
					//cal.add(Calendar.HOUR,   -1);  
					cal.add(cal.HOUR,   -1);
					Timestamp   hourtime=   new   Timestamp(cal.getTimeInMillis());
					TbMessages item = new TbMessages(senderId, senderName, receivers,
							receiversName, "", title,
							Hibernate.createClob(content),hourtime, sendWay, new Long(2));
					this.messagesMgr.save(item);
					
					if(isSJDX){ //如果选择的有手机短信
						TbOaSmsSchedule  schedule = new TbOaSmsSchedule(hourtime, "", destNumber,
							content, "ZNDX", "1",user.getDeptCode(), senderId, "","");
						this.messagesMgr.saveSchedule(schedule);
					}
				}
				
//				设定了提前一天发送
				if(dayTime.equals("1")){
					Calendar   cal=Calendar.getInstance();  
					cal.setTime(selectTime);
					cal.add(Calendar.DAY_OF_MONTH,   -1);   
					Timestamp   daytime=   new   Timestamp(cal.getTimeInMillis());
					TbMessages item = new TbMessages(senderId, senderName, receivers,
							receiversName, "", title,
							Hibernate.createClob(content),daytime, sendWay, new Long(2));
					this.messagesMgr.save(item);
					
					if(isSJDX){ //如果选择的有手机短信
						TbOaSmsSchedule  schedule = new TbOaSmsSchedule(daytime, "", destNumber,
							content, "ZNDX", "1",user.getDeptCode(), senderId, "","");
						this.messagesMgr.saveSchedule(schedule);
					}
				}
				if("openWindow".equals(request.getParameter("fromPage"))){
					response.setCharacterEncoding("GBK");
					response.getOutputStream().println("<script>alert('回复成功！');window.close();</script>");
					return null;
				}
				return mapping.findForward("delMessagesbox");
			}
		}
		return mapping.findForward("sendMessages");
	}
	
	/**
	 * 	删除发件箱消息
	 * 
	 */
	public ActionForward deleteSend(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		this.messagesMgr.sendDelete(id);
		return mapping.findForward("delMessagesbox");
	}

}
