package com.baosight.base.struts.action;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.baosight.mode.TbUser;
import com.baosight.struts.action.BaseDispatchAction;

public class MailAction extends BaseDispatchAction {
	public ActionForward getUnReadMailCount(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TbUser user = (TbUser)request.getSession().getAttribute("SYSTEM_USER_SESSION");
		HttpSession session = request.getSession();
		Map map = (Map)session.getAttribute("SYSTEM_USER_DBSY");//权限
		
		//得到待审批的文件传送的数量 7
		int filesendCount = 0 ;
		if(map!=null && map.get("File transfer")!=null){
			filesendCount = super.tbUserOpeationMgr.count(user.getId(),"7");
		}
		
		//得到未读短信的数量 8
		int myMessage = 0;
		//if(map!=null && map.get("DBSY_MYMESSAGE")!=null){
			myMessage = this.messagesMgr.getNotReadRecordNum(user.getId());
		//}
		
		//得到待审批的车辆的数量 11
		int vehiclesApplyNum = 0;
		if(map!=null && map.get("Vehicle Management")!=null){
			vehiclesApplyNum = super.tbVehiclesApplyMgr.findByProperty("status","2").size();
		}
		//首页待审批档案数量 13
		int archiveApplyCount = 0;
		if(map!=null && map.get("Document Management")!=null){
			archiveApplyCount = super.tbUserOpeationMgr.count(user.getId(),"13");
		}		
		//政府信息公开
		int auditingCount = 0;//审批中记录数量 9
		int willAuditCount = 0;//待审批记录数量 90
		if(map!=null && map.get("GovInfoPub")!=null){
			auditingCount = super.tbUserOpeationMgr.count("","9");
			willAuditCount = super.tbUserOpeationMgr.count("","90");
		}
		//行政许可 66
		int administrat = 0;
		if(map!=null && map.get("dbsx")!=null){
			administrat = super.tbUserOpeationMgr.count(user.getId(),"66");
		}		 
//		网上咨询
		int counsultWaitCount = 0; //待审核记录数量 10
		int counsultZBCount = 0; //专办记录数量 100
		int counsultLeadApproveCount = 0; //待领导审批数量 101
		if(map!=null && map.get("Internet Advisory")!=null){
			counsultWaitCount = super.tbUserOpeationMgr.count("","10");
		}
		if(map!=null && map.get("Internet Advisory Office")!=null){
			counsultZBCount = super.tbUserOpeationMgr.count(user.getId(),"100");
		}
		if(map!=null && map.get("Online advice sought")!=null){
			counsultLeadApproveCount = super.tbUserOpeationMgr.count(user.getId(),"101");
		}

//		网上投诉
		int appealWaitCount = 0; //待审核记录数量 20
		int appealZBCount = 0; //专办记录数量 200
		int appealLeadApproveCount = 0; //待领导审批数量 201
		if(map!=null && map.get("Online complaints")!=null){
			appealWaitCount = super.tbUserOpeationMgr.count("","20");
		}
		if(map!=null && map.get("Online complaints Office")!=null){
			appealZBCount = super.tbUserOpeationMgr.count(user.getId(),"200");
		}
		if(map!=null && map.get("Online complaints consultation")!=null){
			appealLeadApproveCount = super.tbUserOpeationMgr.count(user.getId(),"201");
		}

//		局长信箱
		int directorWaitCount = 0; //待审核记录数量 40
		int directorZBCount = 0; //转办记录数量 400
		int directorLeadApproveCount = 0; //待领导审批数量 401
		if(map!=null && map.get("director_mailBox")!=null){
			directorWaitCount = super.tbUserOpeationMgr.count("","40");
		}
		if(map!=null && map.get("director_mailBox_transfer")!=null){
			directorZBCount = super.tbUserOpeationMgr.count(user.getId(),"400");
		}
		if(map!=null && map.get("director_mailBox_consult")!=null){
			directorLeadApproveCount = super.tbUserOpeationMgr.count(user.getId(),"401");
		}
		
//		收文
		int resiverDocWaitCount = 0; //待办记录数量 300
		int resiverDocProcessCount = 0; //办理中记录数量 301
		resiverDocWaitCount = super.tbUserOpeationMgr.count(user.getId(),"300");
		resiverDocProcessCount = super.tbUserOpeationMgr.count(user.getId(),"301");
		
//		发文
		int sendDocWaitCount = 0; //待办记录数量 302
		int sendDocProcessCount = 0; //办理中记录数量 303
		sendDocWaitCount = super.tbUserOpeationMgr.count(user.getId(),"302");
		sendDocProcessCount = super.tbUserOpeationMgr.count(user.getId(),"303");

//		行政许可抄送
		int xzxkCC = 0; 
		if(map!=null && map.get("CC")!=null){
			xzxkCC = super.tbUserOpeationMgr.count(user.getId(),"50");
		}	
//		行政许可催办
		int xzxkUrger = 0; 
		if(map!=null && map.get("MyUrger")!=null){
			xzxkUrger = super.tbUserOpeationMgr.count(user.getId(),"60");
		}
		
//		委托管理委托
		int commission = 0; 
		if(map!=null && map.get("commission")!=null){
			commission = super.tbUserOpeationMgr.count(user.getId(),"70");
		}	
//		委托管理被委托
		int commissionBe = 0; 
		if(map!=null && map.get("commission")!=null){
			commissionBe = super.tbUserOpeationMgr.count(user.getId(),"710");
		}		
		
		int myMail = 0;
		
		/*
		//		获得邮件地址、用户名、密码
		String username = user.getUserAcc();
		String password = user.getPwd();
		String path = request.getRealPath("/")+ "/WEB-INF/classes/maiConfig.xml";
		String mailPop = this.parseXML(path);
		Session mailsession = Session.getInstance(System.getProperties(), null);
		mailsession.setDebug(false);
		Store store = mailsession.getStore("pop3"); // protocol为连接协议，IMAP或是POP
		
		store.connect(mailPop, -1, username, password);
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

//		得到未读邮件的数量 
		if(map==null || map.get("EMAIL")==null){
			myMail = folder.getUnreadMessageCount();
		}*/
		
		response.setContentType("text/xml;charset=UTF-8");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		String str ="<message>" 
			+"<info>"+ archiveApplyCount+"</info>"
			+"<info>"+ myMail+ "</info>" 
			+"<info>"+ filesendCount + "</info>" 
			+"<info>"+ vehiclesApplyNum + "</info>"
			+"<info>"+ myMessage + "</info>" 
			+"<info>"+ auditingCount + "</info>"
			+"<info>"+ willAuditCount + "</info>"
			+"<info>"+ administrat + "</info>"
			+"<info>"+ counsultWaitCount + "</info>"
			+"<info>"+ counsultZBCount + "</info>"
			+"<info>"+ counsultLeadApproveCount + "</info>"
			+"<info>"+ appealWaitCount + "</info>"
			+"<info>"+ appealZBCount + "</info>"
			+"<info>"+ appealLeadApproveCount + "</info>"
			+"<info>"+ resiverDocWaitCount + "</info>"
			+"<info>"+ resiverDocProcessCount + "</info>"
			+"<info>"+ sendDocWaitCount + "</info>"
			+"<info>"+ sendDocProcessCount + "</info>"
			+"<info>"+ directorWaitCount + "</info>"
			+"<info>"+ directorZBCount + "</info>"
			+"<info>"+ directorLeadApproveCount + "</info>"
			+"<info>"+ xzxkCC + "</info>"
			+"<info>"+ xzxkUrger + "</info>"
			+"<info>"+ commission + "</info>"
			+"<info>"+ commissionBe + "</info>"
			+ "</message>";
		System.out.println("*******messages******str*:"+str);
		response.getWriter().write(xml + str);
		
		return null;
		
		/*Session mailsession = Session.getInstance(System.getProperties(), null);
		mailsession.setDebug(false);
		Store store = mailsession.getStore("pop3"); // protocol为连接协议，IMAP或是POP
		try{
			store.connect(mailPop, -1, username, password);
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			
			response.setContentType("text/xml;charset=UTF-8");
			// response.setHeader("Cache_Control", "no-cache");
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			//String str = "<message><info>"+archiveApplyCount+"</info><info>0</info></message>";
			String str ="<message>" 
				+"<info>"+ archiveApplyCount+"</info>"
				+"<info>"+ folder.getUnreadMessageCount() + "</info>" 
				+"<info>"+ filesendNum + "</info>" 
				+"<info>"+ vehiclesApplyNum + "</info>" 
				+"<info>"+ myMessage + "</info>" 
				+ "</message>";
			System.out.println(xml+str);
			response.getWriter().write(xml + str);
			System.out.print("未读邮件：" + folder.getUnreadMessageCount());
			folder.close(true);
			store.close();

			return null;
		}catch(Exception e){	
			response.setContentType("text/xml;charset=UTF-8");
			// response.setHeader("Cache_Control", "no-cache");
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			//String str = "<message><info>"+archiveApplyCount+"</info><info>0</info></message>";
			String str ="<message>" 
				+"<info>"+ archiveApplyCount+"</info>"
				+"<info>"+ 0 + "</info>" 
				+"<info>"+ filesendNum + "</info>" 
				+"<info>"+ vehiclesApplyNum + "</info>" 
				+"<info>"+ myMessage + "</info>" 
				+ "</message>";
			System.out.println(xml+str);
			response.getWriter().write(xml + str);
			
			store.close();
			return null;
		}*/
			
		
		
/*		String host = "pop3.163.com";
		String username = "52707324";
		String password = "......";

		Session mailsession = Session.getInstance(System.getProperties(), null);
		mailsession.setDebug(false);
		Store store = mailsession.getStore("pop3"); // protocol为连接协议，IMAP或是POP
		store.connect(host, -1, username, password);
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);
		int archiveApplyCount = super.tbUserOpeationMgr.archiveApplyCount();
		response.setContentType("text/xml;charset=UTF-8");
		// response.setHeader("Cache_Control", "no-cache");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		String str = "<message><info>"+archiveApplyCount+"</info><info>"
				+ folder.getUnreadMessageCount() + "</info></message>";
		response.getWriter().write(xml + str);
		System.out.print("未读邮件：" + folder.getUnreadMessageCount());
		// request.setAttribute("unreadMessageCount",
		// folder.getUnreadMessageCount());
		folder.close(true);
		store.close();

		return null;*/		
	}
	
	// 获取邮件协议
	public String parseXML(String filename) throws Exception {
		String mailPop = "";
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File(filename));
			Element root = document.getRootElement();
			// 遍历根结点（MailConfig）的所有孩子节点
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				// 允许文件类型
				if (element.getName().equals("mail-pops")) {
					for (Iterator iterInner = element.elementIterator(); iterInner
							.hasNext();) {
						Element elementInner = (Element) iterInner.next();
						if (elementInner.getName().equals("allow-pop")) {
							mailPop = elementInner.getTextTrim();
						}
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		return mailPop;
	}	
	
	public ActionForward getMyMail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//String temp = "http://31.16.1.80:88/test.asp?userName=&passWord=";
		TbUser user = (TbUser)request.getSession().getAttribute("SYSTEM_USER_SESSION");
		String username = user.getUserAcc();
		String password = user.getPwd();
		
		response.sendRedirect("http://31.16.1.80:88/test.asp?userName="+username+"&passWord="+password);
		return null;
	}	
}
