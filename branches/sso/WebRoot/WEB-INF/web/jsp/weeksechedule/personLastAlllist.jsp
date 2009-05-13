<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbZwWeekSechedule" />
<jsp:directive.page import="com.baosight.tools.WeekManager" />
<jsp:directive.page import="java.text.SimpleDateFormat" />

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
	
	List personLastList = (List) request.getAttribute("personLastList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>个人日程</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />

		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-zh.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-setup.js"></script>
		<script type="text/javascript">
			function showTable(tableId)
			{
				if(tableId=="thisDay")
				{
					document.getElementById("thisDay").style.display="";
					document.getElementById("thisWeek").style.display="none";
					document.getElementById("thisMonth").style.display="none";
				}
				if(tableId=="thisWeek")
				{
					document.getElementById("thisDay").style.display="none";
					document.getElementById("thisWeek").style.display="";
					document.getElementById("thisMonth").style.display="none";
				}
				if(tableId=="thisMonth")
				{
					document.getElementById("thisDay").style.display="none";
					document.getElementById("thisWeek").style.display="none";
					document.getElementById("thisMonth").style.display="";
				}
			}
		</script>
	</head>

	<body>
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
								个人日程安排
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
                                  <td width="10%" class="tabin_atabno"><a onclick="showTable('thisDay');"
									onmouseover="this.style.cursor='hand'"><span class="bg-zw">本日日程</span></a></td>
			                      <td width="10%" class="tabin_atabno"><a onclick="showTable('thisWeek');"
									onmouseover="this.style.cursor='hand'"><span class="bg-zw">本周日程</span></a></td>
								 <!-- <td width="10%" class="tabin_atabno"><a onclick="showTable('thisMonth');"
									onmouseover="this.style.cursor='hand'"><span class="bg-zw">本月日程</span></a></td>  -->
			                      <td width="29%">&nbsp;</td>
                     </table> 
                  
														<table id="thisMonth" width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in">
															<tr>
															</tr>
														</table>
														<table id="thisDay" width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in">
															<tr>
																<th width="11%" height="25">
																	时间
																</th>
																<th width="10%" height="25">
																	召集人
																</th>
																<th width="24%" height="25">
																	内容
																</th>
																<th width="23%" height="25">
																	参加人员
																</th>
																<th width="17%" height="25">
																	地点
																</th>
															</tr>
															<%
																	if (personLastList != null && personLastList.size() > 0) {
																	Iterator it = personLastList.iterator();
												
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
															%>
												
															<tr align="center" class="bg-zw">
																<td width="11%" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=time%>
																</td>
																<td width="11%" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																</td>
																<td width="11%" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="11%" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="11%" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getRem()%>
																</td>
															</tr>
															<%
																}
																}
															%>
														</table>
														<table id="thisWeek" width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in" style="display:none">
															<tr>
																<th height="25">
																	日期
																</th>
																<th width="11%">
																	时间
																</th>
																<th width="10%">
																	召集人
																</th>
																<th width="24%">
																	内容
																</th>
																<th width="23%">
																	参加人员
																</th>
																<th width="17%">
																	地点
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
																
																%>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																		<%=time%>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																	<br>
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getContent()%>
																	<br>
																</td>
																<td width="300" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="150" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getRem()%>
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
																%>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=time%>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																</td>
																<td width="250" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getContent()%>
																</td>
																<td width="300" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="150" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getRem()%>
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
																%>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=time%>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																</td>
																<td width="250" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getContent()%>
																</td>
																<td width="300" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="150" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getRem()%>
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
																%>
																<td width="100" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=time%>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																</td>
																<td width="250" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getContent()%>
																</td>
																<td width="300" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																</td>
																<td width="150" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getRem()%>
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
																%>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=time%>
																	<br>
																</td>
																<td width="100" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getPromulgator()%>
																</td>
																<td width="250" height="30" align="center"
																	style="word-wrap: break-word;">
																	<%=zw.getContent()%>
																</td>
																<td width="300" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getAttendance()%>
																	<br>
																</td>
																<td width="150" height="30" align="center"
																	 style="word-wrap: break-word;">
																	<%=zw.getRem()%>
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
															</tr>
															<%
															}
															%>

<%--<tr align="right">
																<td class="tabin_page" colspan="6">
																	
																	&nbsp; &nbsp;
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=personalllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=last">前一周</a>
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=personalllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=now">当前周</a>
																	<a
																		href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=personalllist&weekofyear=<%=weekofyear%>&starttime=<%=starttime%>&endtime=<%=endtime%>&skip=next">后一周</a>
																	&nbsp;
																</td>
															</tr>
														--%>
            
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
</td></tr></table>
</body>
</html>






