<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbZwWeekSechedule" />
<jsp:directive.page import="com.baosight.tools.WeekManager" />

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List allweekSechedule = (List) request
			.getAttribute("allweekSechedule");

	List alllist = (List) request.getAttribute("alllist");

	List weekdayList = (List) request.getAttribute("weekdayList");

	List sundayList = (List) request.getAttribute("sundayList");
	List mondayList = (List) request.getAttribute("mondayList");
	List tuesdayList = (List) request.getAttribute("tuesdayList");
	List wednesdayList = (List) request.getAttribute("wednesdayList");
	List thursdayList = (List) request.getAttribute("thursdayList");
	List fridayList = (List) request.getAttribute("fridayList");
	List saturdayList = (List) request.getAttribute("saturdayList");

	String weekofyear = (String) request.getAttribute("weekofyear");
	String starttime = (String) request.getAttribute("starttime");
	String endtime = (String) request.getAttribute("endtime");

	String nowweekofyear = WeekManager.getSeqWeek(WeekManager
			.dateToStr(new Date()));

	String timeoutflag = "0";
	if (Integer.parseInt(weekofyear) < Integer.parseInt(nowweekofyear)) {
		timeoutflag = "1";
	}

	String showBossLink = (String) request.getAttribute("showBossLink");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'weekSechedulelist.jsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />

		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-zh.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-setup.js"></script>
		<script type="text/javascript">
		function submitform()
		{
			var stime=document.all.queryTime.value;
			//var etime=document.all.endTime.value;
			var strpath="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=querylist&queryTime="+stime;
			window.location.href=strpath;
		}
		function modifycheck(id,ischild,flag,addtype,xgorgl)
		{
			//flag 比较时间，是否已过期，过期则不能修改
			//ischild 是否为其他日程级联添加的日程，是则不能修改
			//id 该条日程的id
			//var sflag=true;
			//var error="";
			//if(flag=='1')
			//{
			//	error=error+"该条日程已过期，不能修改！\n";
			//	sflag=false;
			//}
			//if(ischild=='1')
			//{
			//	error=error+"该条日程为其他日程级联添加的日程，不能修改！\n";
			//	sflag=false;
			//}
			//if(sflag==true)
			//{
				var strpath="<%=path%>/tbZwWeekSecheduleAction.do?method=modify&action=modify&id="+id+"&addtype="+addtype+"&ischild="+ischild+"&flag="+flag+"&xgorgl="+xgorgl;
				window.location.href=strpath;
				//alert(strpath);
			//}
			//else
			//{
			//	alert(error);
			//}
			
		}
	</script>

	</head>

	<body>

		<table width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="288" height="40" align="left" valign="middle"
								background="images/8-1.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="5%" align="center" valign="middle">
											&nbsp;
										</td>
										<td width="11%" height="12" align="center" valign="middle">
											<img src="images/icon5.gif" width="7" height="7" />
										</td>
										<td width="84%" class="table2_topic">
											<%=starttime%>
											到
											<%=endtime%><br>
											日程安排
										</td>
									</tr>
								</table>
							</td>
							<td background="images/8-2.gif">
								&nbsp;
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#0e88b9">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="table2bg">
									<tr>
										<td align="center" valign="top">
											<table width="98%" border="0" cellpadding="0" cellspacing="0"
												class="table2bgin">
												<tr>
													<th height="30" valign="bottom"></th>
												</tr>
												<tr>
													<td align="center" valign="bottom">
														<table width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in">
															<tr>

																<td height="27" colspan="7" valign="middle"
																	bgcolor="#e8f0f1" class="tabin_toptext" align="right">
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=add&action=addSechedule&addtype=dept"><span
																		class="bg-zw">部门日程管理</span>
																	</a>
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=add&action=addSechedule&addtype=person"><span
																		class="bg-zw">个人日程管理</span>
																	</a>
																	<%
																			if (showBossLink != null && !"".equals(showBossLink)) {
																			if ("yes".equals(showBossLink)) {
																	%>
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=Bosslist"
																		target="new"><span class="bg-zw">查看局机关日程安排</span>
																	</a>
																	<%
																	} else {
																	%>
																	<%--<a
																href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=Bosslist" target="new"><span
																class="bg-zw">查看局机关日程安排</span></a>
														--%>
																	<%
																		}
																		}
																	%>

																</td>
															</tr>
															<tr>
																<td height="27" colspan="7" valign="middle"
																	bgcolor="#f7f7f7" align="left">
																	&nbsp;<span class="bg-zw">日期</span>&nbsp;&nbsp;&nbsp;

																	<input type="text" name="queryTime" value=""
																		onfocus="setday(this)"
																		readonly="readonly" class="shuruk1" />
																	<b>&nbsp;&nbsp;&nbsp;<input name="Submit2"
																			type="submit" class="button0" value="查 询"
																			onclick="submitform();"
																			onmouseover="this.style.cursor='hand'" />
																</td>
															</tr>
															<tr>
																<th width="14%" height="25">
																	日期
																</th>
																<th width="10%">
																	时间
																</th>
																<th width="10%">
																	召集人
																</th>
																<th width="23%">
																	内容
																</th>
																<th width="23%">
																	参加人员
																</th>
																<th width="15%">
																	地点
																</th>
																<th width="5%">
																	管理
																</th>
															</tr>
															<%
															Iterator it = null;
															%>

															<%
																it = mondayList.iterator();
																boolean bool1 = true;
																if (mondayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool1 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=mondayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(1)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																	<br>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																	<br>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool1 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(1)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
																}
																it = tuesdayList.iterator();
																boolean bool2 = true;
																if (tuesdayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																	String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool2 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=tuesdayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(2)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool2 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(2)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
																}
																it = wednesdayList.iterator();
																boolean bool3 = true;
																if (wednesdayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool3 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=wednesdayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(3)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool3 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(3)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
																}
																it = thursdayList.iterator();
																boolean bool4 = true;
																if (thursdayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool4 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=thursdayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(4)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool4 = false;
																	}
																} else {
															%>
															<tr align="center">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(4)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
																}
																it = fridayList.iterator();
																boolean bool5 = true;
																if (fridayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool5 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=fridayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(5)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																	<br>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool5 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(5)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
															}
															%>
														
															<%
															
																it = saturdayList.iterator();
																boolean bool6 = true;
																if (saturdayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool6 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=saturdayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(6)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																	<br>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool6 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(6)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
															}
															%>
															<%
															
																it = sundayList.iterator();
																boolean bool0 = true;
																if (sundayList.size() != 0) {
																	while (it.hasNext()) {
																		TbZwWeekSechedule zw = (TbZwWeekSechedule) it.next();
																		String time = zw.getStartTime().toString()
																		.substring(11, 16);
																		int hour = Integer.parseInt(time.substring(0, 2));
																		if (hour <= 12) {
																	time = "上午" + time;
																		} else {
																	hour = hour - 12;
																	time = "下午" + hour + time.substring(2);
																		}
																		String itemType = zw.getItemType();
															%>
															<tr align="center" class="bg-zw">
																<%
																if (bool0 == true) {
																%>
																<td width="200" height="30" align="center"
																	rowspan="<%=sundayList.size()%>"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(0)%>
																</td>
																<%
																			}
																			String rowcolor = "";
																			//0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门
																			if (zw.getColorflag().equals("0")) {
																		rowcolor = "#8000ff";
																			} else if (zw.getColorflag().equals("1")) {
																		rowcolor = "#969696";
																			} else if (zw.getColorflag().equals("2")) {
																		rowcolor = "#008080";
																			} else if (zw.getColorflag().equals("3")) {
																		rowcolor = "#800000";
																			} else if (zw.getColorflag().equals("4")) {
																		rowcolor = "#666699";
																			} else if (zw.getColorflag().equals("5")) {
																		rowcolor = "#333333";
																			} else {
																		rowcolor = "#FF80C0";
																			}
																%>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','xg')">
																		<font color="#ffffff"><%=time%>
																	</font>
																	</a>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getPromulgator()%>
																	</font>
																</td>
																<td width="250" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getContent()%>
																	</font>
																</td>
																<td width="300" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getAttendance()%>
																	</font>
																	<br>
																</td>
																<td width="150" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<font color="#ffffff"><%=zw.getRem()%>
																	</font>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	bgcolor="<%=rowcolor%>" style="word-wrap: break-word;">
																	<%if ("dept".endsWith(itemType)) {%>
																	<a
																		href="javascript:modifycheck('<%=zw.getId()%>','<%=zw.getIschild()%>','<%=timeoutflag%>','<%=zw.getItemType()%>','gl')">
																		<font color="#ffffff"><%="管理"%>
																	</font>
																	</a><%} %>
																	<br>
																</td>
															</tr>
															<%
																	bool0 = false;
																	}
																} else {
															%>
															<tr align="center" class="bg-zw">
																<td width="200" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=weekdayList.get(0)%>
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="300" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="150" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	&nbsp;
																</td>
															</tr>
															<%
															}
															%>
														</table>
												<tr>
													<td height="10"></td>
												</tr>
												<tr align="right">
													<td class="tabin_page">
														<%--0为个人日程,1为本部门日程,2为局OA,3为信息中心OA,4为受理中心OA,5为苏办,6为其他部门--%>
														<label style="color='#008080'">
															局OA日程
														</label>
														&nbsp;
														<label style="color='#800000'">
															信息中心OA日程
														</label>
														&nbsp;
														<label style="color='#666699'">
															受理中心OA日程
														</label>
														&nbsp;
														<label style="color='#333333'">
															苏办日程
														</label>
														&nbsp;
														<%--<label style="color='#FF80C0'">其他部门日程</label>--%>
														<label style="color='#969696'">
															本部门日程
														</label>
														&nbsp;
														<label style="color='#8000ff'">
															个人日程
														</label>
														&nbsp; &nbsp;
														<a
															href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=alllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=last">前一周</a>
														<a
															href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=alllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=now">当前周</a>
														<a
															href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=alllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=next">后一周</a>
														&nbsp;
													</td>
												</tr>

												<tr>
													<td height="20"></td>
												</tr>

											</table>
										</td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
