package com.baosight.base.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.hibernate.Hibernate;

import com.baosight.base.service.IMessagesMgr;
import com.baosight.base.service.ITbUserOpeationMgr;
import com.baosight.mode.TbIndividual;
import com.baosight.mode.TbMeeting;
import com.baosight.mode.TbMeetingrecord;
import com.baosight.mode.TbMeetingroom;
import com.baosight.mode.TbMessages;
import com.baosight.mode.TbUser;
import com.baosight.mode.TbUserinfo;
import com.baosight.mode.TbZwWeekSechedule;
import com.baosight.struts.action.BaseDispatchAction;
import com.baosight.tools.WeekManager;
import com.baosight.tools.YearList;

public class MeetingrecordAction extends BaseDispatchAction{
	protected IMessagesMgr messagesMgr;
	
	public void setMessagesMgr(IMessagesMgr messagesMgr) {
		this.messagesMgr = messagesMgr;
	}
	public void setTbUserOpeationMgr(ITbUserOpeationMgr tbUserOpeationMgr) {
		this.tbUserOpeationMgr = tbUserOpeationMgr;
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String ftime = request.getParameter("ftime");
		String ttime = request.getParameter("ttime");
		
		List allMeetingrecord = this.meetingrecordMgr.findAll();
		
		request.setAttribute("title", title);
		request.setAttribute("ftime", ftime);
		request.setAttribute("ttime", ttime);
		long count=allMeetingrecord.size();
		startPagingCount(null, request,count);
		startPaging(allMeetingrecord, null, request);
		return mapping.findForward("list");
	}
	
	public ActionForward listSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String title = request.getParameter("title");
		String ftime = request.getParameter("ftime");
		String ttime = request.getParameter("ttime");
		//当页面选择起始时间和结束时间都不为空时
		if(!"".equals(ftime) && !"".equals(ttime)){
			List meetingrecordF_T = this.meetingrecordMgr.findSelectF_T(title, ftime, ttime);
			long count=meetingrecordF_T.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordF_T, null, request);
		}
        //当页面选择起始时间不为空，结束时间为空时
		if(!"".equals(ftime) && "".equals(ttime)){
			List meetingrecordF = this.meetingrecordMgr.findSelectTitle_From(title, ftime);
			long count=meetingrecordF.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordF, null, request);
		}
        //当页面选择起始时间为空，结束时间不为空时
		if("".equals(ftime) && !"".equals(ttime)){
			List meetingrecordT = this.meetingrecordMgr.findSelectTitle_To(title, ttime);
			long count=meetingrecordT.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordT, null, request);
		}
		 //当页面选择起始时间和结束时间都为空时
		if("".equals(ftime) && "".equals(ttime)){
			List meetingrecordNOFT = this.meetingrecordMgr.findSelectNo_FT(title);
			long count=meetingrecordNOFT.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordNOFT, null, request);
		}


		request.setAttribute("title", title);
		request.setAttribute("ftime", ftime);
		request.setAttribute("ttime", ttime);
		return mapping.findForward("list");
	}
	
	public ActionForward delSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
		String title = (String) request.getAttribute("title");
		String ftime = (String) request.getAttribute("ftime");
		String ttime = (String) request.getAttribute("ttime");
		//当页面选择起始时间和结束时间都不为空时
		if(!"".equals(ftime) && !"".equals(ttime)){
			List meetingrecordF_T = this.meetingrecordMgr.findSelectF_T(title, ftime, ttime);
			long count=meetingrecordF_T.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordF_T, null, request);
		}
        //当页面选择起始时间不为空，结束时间为空时
		if(!"".equals(ftime) && "".equals(ttime)){
			List meetingrecordF = this.meetingrecordMgr.findSelectTitle_From(title, ftime);
			long count=meetingrecordF.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordF, null, request);
		}
        //当页面选择起始时间为空，结束时间不为空时
		if("".equals(ftime) && !"".equals(ttime)){
			List meetingrecordT = this.meetingrecordMgr.findSelectTitle_To(title, ttime);
			long count=meetingrecordT.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordT, null, request);
		}
		 //当页面选择起始时间和结束时间都为空时
		if("".equals(ftime) && "".equals(ttime)){
			List meetingrecordNOFT = this.meetingrecordMgr.findSelectNo_FT(title);
			long count=meetingrecordNOFT.size();
			startPagingCount(null, request,count);
			startPaging(meetingrecordNOFT, null, request);
		}


		request.setAttribute("title", title);
		request.setAttribute("ftime", ftime);
		request.setAttribute("ttime", ttime);
		return mapping.findForward("list");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String ftime = request.getParameter("ftime");
		String ttime = request.getParameter("ttime");
		if (!"".equals(id)) {
			this.meetingrecordMgr.delete(id);
			request.setAttribute("title", title);
			request.setAttribute("ftime", ftime);
			request.setAttribute("ttime", ttime);
			return mapping.findForward("su");
		}
		return mapping.findForward("su");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		TbUser user = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		String action = request.getParameter("action");
		if (!"".equals(action)) {
			if (action.equals("add")) {
				String title = request.getParameter("title");
				String ftime = request.getParameter("ftime");
				String ttime = request.getParameter("ttime");
				
				
				request.setAttribute("title", title);
				request.setAttribute("ftime", ftime);
				request.setAttribute("ttime", ttime);
				
				return mapping.findForward("add");
			}
			if (action.equals("submit")) {
				String meetingrecordTitle = (String) ((DynaValidatorForm) form).get("meetingrecordTitle");
				String meetingrecordTime = (String) ((DynaValidatorForm) form).get("meetingrecordTime");
				String meetingrecordName = (String) ((DynaValidatorForm) form).get("meetingrecordName");
				String meetingrecordAdv = (String) ((DynaValidatorForm) form).get("meetingrecordAdv");
				String meetingrecordRem = (String) ((DynaValidatorForm) form).get("meetingrecordRem");
				//参加人员
				String joiner = (String) ((DynaValidatorForm) form).get("joiner");
				//通知人员
				String attr1 = (String) ((DynaValidatorForm) form).get("attr1S");
				
				DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");         
				Date time=null;
				try {
					time = format.parse(meetingrecordTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				
				TbMeetingrecord model = new TbMeetingrecord(meetingrecordTitle, time, meetingrecordName,
						meetingrecordAdv, meetingrecordRem, joiner, "0", attr1, "",
						"");
				this.meetingrecordMgr.save(model);

				return new ActionForward(
						"/meetingrecordaction.do?method=list&title=&ftime=&ttime=");
				
			}
		}
		return mapping.findForward("list");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		if (action != null && action.equals("submit")) {
			String title = request.getParameter("title");
			String ftime = request.getParameter("ftime");
			String ttime = request.getParameter("ttime");
			
			String meetingrecordTitle = (String) ((DynaValidatorForm) form).get("meetingrecordTitle");
			String meetingrecordTime = (String) ((DynaValidatorForm) form).get("meetingrecordTime");
			String meetingrecordName = (String) ((DynaValidatorForm) form).get("meetingrecordName");
			String meetingrecordRem = (String) ((DynaValidatorForm) form).get("meetingrecordRem");
			String meetingrecordAdv = (String) ((DynaValidatorForm) form).get("meetingrecordAdv");
			String meetingrecordJoiner = (String) ((DynaValidatorForm) form).get("joiner");
			String attr1 = (String) ((DynaValidatorForm) form).get("attr1S");
			TbMeetingrecord meetingrecord = this.meetingrecordMgr.findById(id);
			
			meetingrecord.setMeetingrecordTitle(meetingrecordTitle);
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm");         
			Date time=null;
			try {
				time = format.parse(meetingrecordTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			meetingrecord.setMeetingrecordTime(time);
			meetingrecord.setMeetingrecordName(meetingrecordName);
			meetingrecord.setMeetingrecordRem(meetingrecordRem);
			meetingrecord.setMeetingrecordAdv(meetingrecordAdv);
			meetingrecord.setMeetingrecordJoiner(meetingrecordJoiner);
			meetingrecord.setAttr1(attr1);
			this.meetingrecordMgr.updte(meetingrecord);
			
			request.setAttribute("title", title);
			request.setAttribute("ftime", ftime);
			request.setAttribute("ttime", ttime);
			return new ActionForward(
			"/meetingrecordaction.do?method=list&title=&ftime=&ttime=");
		} else {
			if (id != null && !id.equals("")) {
				String title = request.getParameter("title");
				String ftime = request.getParameter("ftime");
				String ttime = request.getParameter("ttime");
				
				TbMeetingrecord meetingrecord = this.meetingrecordMgr.findById(id);
				
				 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
		         String str = formatDate.format(meetingrecord.getMeetingrecordTime());
		         
				((DynaValidatorForm) form).set("meetingrecordTitle",meetingrecord.getMeetingrecordTitle());
				((DynaValidatorForm) form).set("meetingrecordTime",str);
				((DynaValidatorForm) form).set("meetingrecordName",meetingrecord.getMeetingrecordName());
				((DynaValidatorForm) form).set("meetingrecordAdv",meetingrecord.getMeetingrecordAdv());
				((DynaValidatorForm) form).set("meetingrecordRem",meetingrecord.getMeetingrecordRem());
				
				//将参加人员ID分隔，循环取得参加人员姓名，将ID和姓名传到JSP
				String namelist = "";
				String[] jons = meetingrecord.getMeetingrecordJoiner().split(",");
				for (int i = 0; i < jons.length; i++) {
					String jon = jons[i];
					TbUser user = this.userMgr.find(jon);
					String username = user.getName();
					namelist = namelist+username+",";	
				}
				String nlist = namelist.substring(0, namelist.length()-1);
				((DynaValidatorForm) form).set("meetingrecordJoiner",nlist);
				((DynaValidatorForm) form).set("joiner",meetingrecord.getMeetingrecordJoiner());
				
                //将通知人员ID分隔，循环取得通知人员姓名，将ID和姓名传到JSP
				String attrlist = "";
				String[] attr1s = meetingrecord.getAttr1().split(",");
				for (int i = 0; i < attr1s.length; i++) {
					String attr1 = attr1s[i];
					TbUser user = this.userMgr.find(attr1);
					String username = user.getName();
					attrlist = attrlist+username+",";
					
					
				}
				String alist = attrlist.substring(0, attrlist.length()-1);
				((DynaValidatorForm) form).set("attr1",alist);
				((DynaValidatorForm) form).set("attr1S",meetingrecord.getAttr1());
				
				request.setAttribute("title", title);
				request.setAttribute("ftime", ftime);
				request.setAttribute("ttime", ttime);

				return mapping.findForward("add");
			}
		}
		return mapping.findForward("success");
	}
	
	public ActionForward record(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String title = request.getParameter("title");
		String ftime = request.getParameter("ftime");
		String ttime = request.getParameter("ttime");
		
		String id = request.getParameter("id");
		
		TbUser loginname = (TbUser) request.getSession().getAttribute("SYSTEM_USER_SESSION");
		TbMeetingrecord meetingrecord = this.meetingrecordMgr.findById(id);
		
        //将通知人员ID分隔，循环取得通知人员姓名
		String[] attr1s = meetingrecord.getAttr1().split(",");
		for (int i = 0; i < attr1s.length; i++) {
			//通过字段截取得到用户ID,通过用户ID查找到对应用户信息和资料
			String attr1 = attr1s[i];
			TbUser user = this.userMgr.find(attr1);
			TbUserinfo userinfo = (TbUserinfo) this.userInfoMgr.findUserID(user.getId()).get(0);
			//将发送内容保存至表MESSAGE中
			String senderID = loginname.getId();//发送者ID
			String senderName = loginname.getName();//发送者NAME
			String receiver_ID = user.getId();//接收者ID
			String receiver_name = user.getName();//接收者NAME
			String receiver_email = userinfo.getEmail();//接收者EMAIL
			String receiver_handset = userinfo.getHandset();//接收者手机
			String message_title = meetingrecord.getMeetingrecordTitle();//标题
			String message_content = meetingrecord.getMeetingrecordName();//内容
			Date send_time = new Date();//发送时间
			String send_way = "1";//发送方式(1站内短信，2手机短信，4邮件)
			String status = "2";//消息状态(1草稿，2未查看，3已查看)
			String attr2 = meetingrecord.getId();//将发送记录与消息记录进行关联
			
			TbMessages item = new TbMessages(senderID, senderName, receiver_ID,
					receiver_name, receiver_email, receiver_handset,message_title,
					Hibernate.createClob(message_content),send_time, new Long(1), new Long(2),"",attr2,"");
			this.messagesMgr.save(item);
			
		}
		
		//变更发送状态，改为已发送，状态码为1
		meetingrecord.setMeetingrecordStatus("1");
		this.meetingrecordMgr.updte(meetingrecord);

		
				return new ActionForward(
						"/meetingrecordaction.do?method=listSelect&title="+title+"&ftime="+ftime+"&ttime="+ttime);

	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String id = request.getParameter("id");
		
			
				String title = request.getParameter("title");
				String ftime = request.getParameter("ftime");
				String ttime = request.getParameter("ttime");
				
				TbMeetingrecord meetingrecord = this.meetingrecordMgr.findById(id);
				
				 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
		         String str = formatDate.format(meetingrecord.getMeetingrecordTime());
		         
				((DynaValidatorForm) form).set("meetingrecordTitle",meetingrecord.getMeetingrecordTitle());
				((DynaValidatorForm) form).set("meetingrecordTime",str);
				((DynaValidatorForm) form).set("meetingrecordName",meetingrecord.getMeetingrecordName());
				((DynaValidatorForm) form).set("meetingrecordAdv",meetingrecord.getMeetingrecordAdv());
				((DynaValidatorForm) form).set("meetingrecordRem",meetingrecord.getMeetingrecordRem());
				
				//将参加人员ID分隔，循环取得参加人员姓名，将ID和姓名传到JSP
				String namelist = "";
				String[] jons = meetingrecord.getMeetingrecordJoiner().split(",");
				for (int i = 0; i < jons.length; i++) {
					String jon = jons[i];
					TbUser user = this.userMgr.find(jon);
					String username = user.getName();
					namelist = namelist+username+",";	
				}
				String nlist = namelist.substring(0, namelist.length()-1);
				((DynaValidatorForm) form).set("meetingrecordJoiner",nlist);
	
				
                //通过会议纪要ID在消息表中查找出通知的人员
				List message = this.messagesMgr.findMessage_recordId(id);
				
				request.setAttribute("message", message);
				request.setAttribute("title", title);
				request.setAttribute("ftime", ftime);
				request.setAttribute("ttime", ttime);

				return mapping.findForward("view");
		

	}
}
