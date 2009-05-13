<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.tools.WeekManager"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	List list=(List)request.getAttribute("list");
	String starttime=(String)request.getAttribute("starttime");
	String endtime=(String)request.getAttribute("endtime");
	String publicflag=(String)request.getAttribute("publicflag");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'weekSecheduleedit.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		
		<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		
	<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
	<script type="text/javascript">
		function submitform()
		{
			document.all.method.value="add";
			document.all.action.value="query";
			var stime=document.all.startTime.value;
			var etime=document.all.endTime.value;
			var pflag=document.all.publicflag.value;
			var strpath="<%=path%>/tbZwWeekSecheduleAction.do?method=add&action=query&starttime="+stime+"&endtime="+etime+"&publicflag="+pflag;
			window.location.href=strpath;

		}
	</script>

	</head>

	<body>
		<html:form action="/tbZwWeekSecheduleAction.do">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				bordercolor="97cdda" class="tableborder">
				<tr>
					<td>
						<img src="<%=path%>/imagine/r-bt.gif" width="11.5" height="14">
						<span class="bg-zw">&nbsp; </span><span class="bg-zw">日程安排管理</span>
					</td>
					<td align="right">
						<img src="<%=path%>/imagine/fh.gif" width="46" height="25" onclick="history.go(-1)"
								onmouseover="this.style.cursor='hand'">
						&nbsp;
					</td>
				</tr>
			</table>
			
			<div align="right"><br></div><table width="100%" border="2" cellpadding="0" cellspacing="0"
				bordercolor="97cdda" class="tableborder">
				<thead class="bg-zw">
					<tr align="left" class="bg-zw">
						<td colspan="2">
							<span><a href="<%=path%>/tbZwWeekSecheduleAction.do?method=add&action=addSechedule">增加日程</span>
						</td>
					</tr>
					<tr align="left" class="bg-zw">
						<td colspan="2" align="center">
							<b>开始时间<input type="text" name="startTime" value="" onclick="return showCalendar('startTime', 'y-mm-dd');"  readonly="readonly"/><b>&nbsp;&nbsp;&nbsp;截止时间<input type="text" name="endTime" value="" onclick="return showCalendar('endTime', 'y-mm-dd');"  readonly="readonly"/><b>
							&nbsp;&nbsp;&nbsp; 发布状态 <select name="publicflag"><option value="0">请选择</option><option value="1">已发布</option><option value="2">未发布</option></select> &nbsp;&nbsp;&nbsp; 
							<input type="button" value="查询" onclick="submitform();">
						</td>
					</tr>
					<tr align="center" class="bg-zwbt">
						<td width="70%" align="center">目录</td>
						<td width="30%" align="center">状态</td>
					</tr>
					<%
						Iterator it =list.iterator();
						Date date=new Date();
						String now=WeekManager.getSeqWeek(new SimpleDateFormat("yyyy-MM-dd").format(date));
						int n=Integer.parseInt(now);
						String flag="";
						while(it.hasNext())
						{
							String time= (String) it.next();
							String start=time.substring(0,10);
							String end=time.substring(11,time.length());
							
							String strm=WeekManager.getSeqWeek(start);
							int m=Integer.parseInt(strm);
							
							if(n<m)
							{
								flag="未发布";
							}else
							{
								flag="已发布";
							}
							%>
								<tr align="center" class="bg-zw">
									<td width="70%" align="center"><a href="<%=path %>/tbZwWeekSecheduleAction.do?method=list&action=listofweek&weekofyear=<%=strm %>">上海市水务信息中心一周工作安排<%=start %>到<%=end %></a></td>
									<td width="30%" align="center"><%=flag %></td>
								</tr>
							<%
						}
					 %>
					
				</thead>
			</table>
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			
		</html:form>
	</body>
</html>
