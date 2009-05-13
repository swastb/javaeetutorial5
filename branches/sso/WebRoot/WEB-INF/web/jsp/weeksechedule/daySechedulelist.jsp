<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbUserlvl" />
<jsp:directive.page import="com.baosight.mode.TbZwWeekSechedule" />
<jsp:directive.page import="com.baosight.tools.WeekManager"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List allweekSechedule = (List) request
			.getAttribute("allweekSechedule");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'pstlvllist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">

	</head>

	<body>

		<table width="97%" align="center" cellpadding="0" cellspacing="0">
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
			<tr>
				<td height="5" colspan="2">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%" border="1" cellpadding="0" cellspacing="0"
						bordercolor="97cdda" class="tableborder">
						<tr align="center" class="bg-zwbt">
							<td width="" align="center">
								日期
							</td>
							<td width="" align="center">
								时间
							</td>
							<td width="" align="center">
								发布人
							</td>
							<td width="" align="center">
								内容
								<br>
							</td>
							<td width="" align="center">
								参加人员
							</td>
							<td width="" align="center">
								备注
							</td>
							<td width="" align="center">
								操作
							</td>
						</tr>
						<%
						
							Date nowdate=new Date();
							String now=WeekManager.getSeqWeek(new SimpleDateFormat("yyyy-MM-dd").format(nowdate));
							int n=Integer.parseInt(now);
							boolean flag=true;
							
							Iterator it = allweekSechedule.iterator();
							while (it.hasNext()) {
								TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
								String date = zw.getStartTime().toString().substring(0, 10);
								String time = zw.getStartTime().toString().substring(11, 16);
								int hour = Integer.parseInt(time.substring(0, 2));
								String dayofweek = zw.getAttr2().substring(0, 3);
								if (hour <= 12) {
									time = "上午" + time;
								} else {
									hour = hour - 12;
									time = "下午" + hour + time.substring(2);
								}
								
								int m=Integer.parseInt(WeekManager.getSeqWeek(date));
								
								if(n<m)
								{
									flag=false;
								}else
								{
									flag=true;
								}
						%>
						<tr align="center" class="bg-zw">
							<td width="200" align="center">
								<a href="<%=path%>/tbZwWeekSecheduleAction.do?method=modify&action=addSechedule&date=<%=date%>&weekofyear=<%=zw.getWeekofyear()%>&id=<%=zw.getId()%>&flag=look"><%=date%>
												( <%=dayofweek%> )</a>
									
							</td>
							<td width="100" align="center">
								<%=time%>
							</td>
							<td width="100" align="center">
								<%=zw.getPromulgator()%>
							</td>
							<td width="300" align="center">
								<%=zw.getContent()%>
							</td>
							<td width="200" align="center">
								<%=zw.getUserId()%>
							</td>
							<td width="200" align="center">
								<%=zw.getRem()%>
							</td>
							<td width="200" align="center">
								<%
									if(flag==false)
									{
										%>
											<img src="<%=path %>/imagine/xg.gif" width="15" height="15"><a href="<%=path%>/tbZwWeekSecheduleAction.do?method=modify&action=addSechedule&date=<%=date%>&weekofyear=<%=zw.getWeekofyear()%>&id=<%=zw.getId() %>">修改</a>
											&nbsp;&nbsp;
											<img src="<%=path %>/imagine/sc.gif" width="15" height="15"><a href="<%=path%>/tbZwWeekSecheduleAction.do?method=delete&id=<%=zw.getId() %>">删除</a>
										<%
									}else
									{
										%>
											-
										<%
									}
								 %>

							</td>
						</tr>
						<%
						}
						%>
					</table>
				</td>
			</tr>

		</table>

	</body>
</html>

