<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbMeetingrecord"/>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	List allMeetingrecord = (List) request.getAttribute("curPageList");

	String title = "";
	String ftime = "";
	String ttime = "";
	title = (String) request.getAttribute("title");
	ftime = (String) request.getAttribute("ftime");
	ttime = (String) request.getAttribute("ttime");
	if (title == null || title.equals("")) {
		title = (String) request.getParameter("title");
	}
	if (ftime == null || ftime.equals("")) {
		ftime = (String) request.getParameter("ftime");
	}
	if (ttime == null || ttime.equals("")) {
		ttime = (String) request.getParameter("ttime");
	}
	
	String sessionID = "";
	int curPage = 0;
	long count=0;
	try {
		sessionID = (String) request.getAttribute("sessionID");
		curPage = (Integer) session.getAttribute(sessionID + "No");
		count=(Long)session.getAttribute(sessionID+"Count");
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<script src="<%=path %>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendarS.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style> 

	</head>

	<body>
		<html:form action="/meetingrecordaction.do">
		<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5%" align="center" valign="middle">
								&nbsp;
							</td>
							<td width="11%" height="12" align="center" valign="middle">
								<img src="images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								会议安排管理
							</td>
						</tr>
					</table>
				</td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
       <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
			<tr>
          <td>
		 <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
			<tr>
          <td><table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0"> 
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="10%" class="tabin_atabno"><a href="meetingaction.do?method=list&action=thismonth"><span class="bg-zw">会议管理</span></a></td>
                      <td width="10%" class="tabin_atabno"><a href="meetingroomaction.do?method=list"><span class="bg-zw">会议室管理</span></a></td>
                       <td width="10%" class="tabin_atab"><span class="bg-zw">会议纪要管理</span></td>
                      <td width="30%">&nbsp;</td>
                   </table> 
                   <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                   <tr>
		
			<td height="25" colspan="8" valign="bottom" bgcolor="#f7f7f7" align="left">
						<span class="bg-zw">会议纪要标题：</span>
						<html:text property="title" styleClass="shuruk1"></html:text>
						</td>
						</tr>
						<tr>
						<td height="25" colspan="4" valign="bottom" bgcolor="#f7f7f7" align="left">
						<span class="bg-zw">会议召开时间：</span>
						<html:text property="ftime" onfocus="setday(this)" readonly="true" styleClass="shuruk1"></html:text>
						<span class="bg-zw">至</span>
						<html:text property="ttime" onfocus="setday(this)" readonly="true" styleClass="shuruk1"></html:text>
						
						<input name="Submit2" type="button" class="button0" value="查 询" onclick="window.open('<%=path%>/meetingrecordaction.do?method=listSelect&title='+document.getElementById('title').value+'&ftime='+document.getElementById('ftime').value+'&ttime='+document.getElementById('ttime').value,'_self');"
	    		 		 onmouseover="this.style.cursor='hand'"/>
						</td>
						
						<td height="25" colspan="4" valign="bottom" bgcolor="#f7f7f7" align="right">&nbsp;
			      <input name="Submit2" type="button" class="button0" value="增 加" onclick="window.open('<%=path %>/meetingrecordaction.do?method=add&action=add&title='+document.getElementById('title').value+'&ftime='+document.getElementById('ftime').value+'&ttime='+document.getElementById('ttime').value,'_self');"
	    		 		 onmouseover="this.style.cursor='hand'"/>
					</td>
				</tr>
				<tr  align="center">
											<th width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												序号
											</th>
											<th width="40%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												会议纪要标题
											</th>
											<th width="30%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												会议纪要时间
											</th>
											<th width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												发送状态
											</th>
											
											<th width="10%" align="center" colspan="4">
												操作
											</th>
										</tr>
										<%
												for (int i = 0; i < allMeetingrecord.size(); i++) {
												TbMeetingrecord meetingrecord=(TbMeetingrecord)allMeetingrecord.get(i);
										%>
										<tr align="center" class="bg-zw">
											<td width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=i + 1%>
											</td>
											<%
											if ("1".equals(meetingrecord.getMeetingrecordStatus()) ) {
											%>
											<td width="40%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<a title="发送纪要"
													href="<%=path%>/meetingrecordaction.do?method=view&id=<%=meetingrecord.getId()%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><%=meetingrecord.getMeetingrecordTitle().toString()%>
												</a>
												
											</td>
											<%
											} else {
											%>
											<td width="40%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=meetingrecord.getMeetingrecordTitle().toString()%>
											</td>
											<%
											}
											%>
											<td width="30%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=meetingrecord.getMeetingrecordTime().toString()%>
											</td>
                                         	<%
											if ("1".equals(meetingrecord.getMeetingrecordStatus()) ) {
											%>
											<td width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												已发送
												</td>
											<%
											} else {
											%>
											<td width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<a title="发送纪要"
													href="<%=path%>/meetingrecordaction.do?method=record&id=<%=meetingrecord.getId()%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>" onclick="return confirm('此会议纪要将发送，是否确认发送');">未发送
												</a>
											</td>
											<%
											}
											%>
											<%
											if ("1".equals(meetingrecord.getMeetingrecordStatus()) ) {
											%>
											<td width="10%" align="center" colspan="4">
												<a title="删除"
													href="<%=path%>/meetingrecordaction.do?method=delete&id=<%=meetingrecord.getId()%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"
													onclick="return confirm('是否确认删除');"><img
														src="<%=path%>/imagine/sc.gif" width="15" height="15"
														border="0"> </a>
											</td>
											<%
											} else {
											%>
											<td width="5%" align="center">
												<a title="修改"
													href="<%=path%>/meetingrecordaction.do?method=modify&id=<%=meetingrecord.getId()%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><img
														src="<%=path%>/imagine/xg.gif" width="15" height="15"
														border="0"> </a>
											</td>
											<td width="5%" align="center">
												<a title="删除"
													href="<%=path%>/meetingrecordaction.do?method=delete&id=<%=meetingrecord.getId()%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"
													onclick="return confirm('是否确认删除');"><img
														src="<%=path%>/imagine/sc.gif" width="15" height="15"
														border="0"> </a>
											</td>
											<%
											}
											%>
										</tr>
										<%
										}
										%>
									
				<tr>
					<td colspan="13">
						<table align="right">
							<tr>
								<td>
									<a
										href="<%=path%>/meetingrecordaction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><span
										class="bg-zw">上一页</span> </a>
									<a
										href="<%=path%>/meetingrecordaction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><span
										class="bg-zw">下一页</span> </a>
									<span class="bg-zw">第<%=curPage + 1%>页</span>
									<span class="bg-zw">每页显示</span>
									<a
										href="<%=path%>/meetingrecordaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><span
										class="bg-zw">10</span> </a>
									<a
										href="<%=path%>/meetingrecordaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><span
										class="bg-zw">20</span> </a>
									<a
										href="<%=path%>/meetingrecordaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>"><span
										class="bg-zw">30</span> </a>
									<span class="bg-zw">条</span>
									<span class="bg-zw">共<%=count %>条</span>
								</td>
								</tr>
             			</table>
             	 	</td>
            	</tr>
            
          </table>
         <table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>


</table>
</td></tr>
<%--<tr>
<td height="10"></td>
</tr>
--%></table>
</td></tr>
</table>
  <tr>
    <td height="10"></td>
  </tr>
</table>
</td></tr></table></html:form>
</body>
</html>




