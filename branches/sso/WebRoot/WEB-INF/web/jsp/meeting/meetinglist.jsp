<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.tools.YearListForm" />
<jsp:directive.page import="com.baosight.mode.TbMeeting" />
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>会议安排管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
		<script type="text/javascript">
			function selectByDate(){
				var year=document.getElementById("year").value;
	            var month=document.getElementById("month").value;
	            document.getElementById("method").value = "list";
                document.getElementById("action").value = "query";
                //window.location.replace("<%=path%>/meetingaction.do?method=list&action=selectByDate&year="+year+"&month="+month);
				document.forms[0].submit();
			}
			function add(){
			 document.getElementById("action").value = "add";
			 document.getElementById("method").value = "add";
			document.forms[0].submit();
                 //window.location.replace("<%=path%>/meetingaction.do?method=add&action=add");
			}
			function onSelField(){
			    document.getElementById("method").value = "list";
			    document.getElementById("action").value = "thismonth";
				document.forms[0].submit();
			}
			function systemTime(){
		   	today = new Date();
			sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
			stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2)+":"+fmtl(today.getSeconds(),2);
			//ses = fmtl(today.getSeconds(),2);
			document.getElementById("scheduletime").value = sday;
			document.getElementById("sendTime_hour").value = shours;
			document.getElementById("sendTime_minute").value = ":"+sminutes+":00";
			//obj.value+="---${SYSTEM_USER_SESSION.name}同志  "+sday+" "+stime;
		   }
		   function fmtl(s,l){
			ss = ""+s;
			if(ss.length<l){
				for(i=0;i<l-ss.length;i++){
					ss = "0"+ss;
				}
			}
			return ss;
		   }
	</script>
		<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style>
		<%
			String year = (String) request.getAttribute("year");
			String month = (String) request.getAttribute("month");
			List yearList = (List) request.getAttribute("yearList");
			List monthList = (List) request.getAttribute("monthList");
			List meeting = (List) request.getAttribute("meeting");
		%>
	</head>

	<body>
		<html:form action="/meetingaction" method="post">
		<input type="hidden" name="method"/>
			<table width="100%" align="center" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="288" height="40" valign="middle"
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
									会议安排管理
								</td>
							</tr>
						</table>
					</td>
					<td background="images/8-2.gif">
						&nbsp;
					</td>
				</tr>
			</table>
			<table width="100%" align="center" border="1" cellpadding="0"
				cellspacing="1" bgcolor="#0e88b9">
				<tr>
					<td>
						<table width="100%" align="center" border="0" cellpadding="0"
							cellspacing="0" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="98%" align="center" border="0" cellpadding="0"
										cellspacing="0" class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="100%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="top">
															<table width="98%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="2%" height="24">
																		&nbsp;
																	</td>
																	<td width="10%" class="tabin_atab">
																		会议管理
																	</td>
																	<td width="10%" class="tabin_atabno">
																		<a href="meetingroomaction.do?method=list"><span
																			class="bg-zw">会议室管理</span> </a>
																	</td>
																	<td width="10%" class="tabin_atabno">
																		<a
																			href="meetingrecordaction.do?method=list&title=&ftime=&ttime="><span
																			class="bg-zw">会议纪要管理</span> </a>
																	</td>
																	<td width="30%">
																		&nbsp;
																	</td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>

																	<td height="25" colspan="9" valign="bottom"
																		bgcolor="#f7f7f7" align="left">
																		<select name="year">
																			<%
																					for (int i = 0; i < yearList.size(); i++) {
																					int yearNum = ((YearListForm) yearList.get(i)).getYear();
																					int thisyear = Integer.parseInt(year);

																					if (yearNum == thisyear) {
																			%>
																			<option value="<%=yearNum%>" selected="selected">
																				<%=yearNum%>
																			</option>
																			<%
																			} else {
																			%>
																			<option value="<%=yearNum%>">
																				<%=yearNum%>
																			</option>
																			<%
																				}
																				}
																			%>
																		</select>
																		<span class="tabin_toptext"><strong>年</strong>
																		</span>
																		<select name="month">
																			<%
																					for (int i = 0; i < monthList.size(); i++) {
																					int monthNum = ((YearListForm) monthList.get(i)).getMonth();
																					int thismonth = Integer.parseInt(month);

																					if (monthNum == thismonth) {
																			%>
																			<option value="<%=monthNum%>" selected="selected">
																				<%=monthNum%>
																			</option>
																			<%
																			} else {
																			%>
																			<option value="<%=monthNum%>">
																				<%=monthNum%>
																			</option>
																			<%
																				}
																				}
																			%>
																		</select>
																		<span class="tabin_toptext"><strong>月</strong>
																		</span>

																		<input type="hidden" name="action" />
																		1.选择字段
																		<html:select property="selField"
																			onchange="onSelField()">
																			<html:optionsCollection property="selFieldColl"
																				name="meetingForm" />
																		</html:select>
																		2.条件
																		<html:select property="selConditions">
																			<html:optionsCollection property="selConditionsColl"
																				name="meetingForm" />
																		</html:select>
																		3.参数
																		<!-- 1代表显示下拉框 0代表显示文本框 -->
																		<logic:equal name="meetingForm" property="strStute"
																			value="1">
																			<html:select property="selParameter">
																				<html:optionsCollection property="selParameterColl"
																					name="meetingForm" />
																			</html:select>
																		</logic:equal>
																		<logic:equal name="meetingForm" property="strStute"
																			value="0">
																			<html:text property="selParameter" maxlength="30"></html:text>
																		</logic:equal>
																		<logic:equal name="meetingForm" property="strStute"
																			value="2">
																			<html:text property="selParameterDateTime"
																				maxlength="30" onclick="setday(this)"
																				readonly="true"></html:text>
																		</logic:equal>


																		<input name="Submit2" type="submit" class="button0"
																			value="查 询" onclick="selectByDate();"
																			onmouseover="this.style.cursor='hand'" />

																	</td>

																	<td height="25" colspan="1" valign="bottom"
																		bgcolor="#f7f7f7" align="right">
																		<input name="Submit2" type="submit" class="button0"
																			value="增 加" onclick="add();"
																			onmouseover="this.style.cursor='hand'" />
																	</td>

																</tr>
																<tr align="center">
																	<th width="5%" height="25" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		序号
																	</th>
																	<th width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		会议编号
																	</th>
																	<th width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		会议标题
																	</th>
																	<th width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		开始时间
																	</th>
																	<th width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		结束时间
																	</th>
																	<th width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		会议室
																	</th>
																	<th width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		主持人
																	</th>
																	<th width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		状态
																	</th>
																	<th width="10%" align="center" colspan="2">
																		操作
																	</th>
																</tr>
																<%
																		if (meeting != null) {
																		for (int i = 0; i < meeting.size(); i++) {
																			TbMeeting item = (TbMeeting) meeting.get(i);
																%>
																<tr align="center">
																	<td width="5%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=i + 1%>
																	</td>
																	<td width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getMeetingSn()%>
																	</td>
																	<td width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getTitle()%>
																	</td>
																	<td width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getStartTime().toString().substring(0, 16)%>
																	</td>
																	<td width="15%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getEndTime().toString().substring(0, 16)%>
																	</td>
																	<td width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getAttr2()%>
																	</td>
																	<td width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=item.getPresidername()%>
																	</td>
																	<%
																	if (item.getStatus().toString().equals("0")) {
																	%>
																	<td width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		未通知
																	</td>
																	<%
																	}
																	%>
																	<td width="5%" align="center">
																		<a title="修改"
																			href="<%=path%>/meetingaction.do?method=modify&id=<%=item.getId()%>"><img
																				src="<%=path%>/imagine/xg.gif" width="15"
																				height="15" border="0"> </a>
																	</td>
																	<td width="5%" align="center">
																		<a title="删除"
																			href="<%=path%>/meetingaction.do?method=delete&id=<%=item.getId()%>"
																			onclick="return confirm('是否确认删除')"><img
																				src="<%=path%>/imagine/sc.gif" width="15"
																				height="15" border="0"> </a>
																	</td>
																</tr>
																<%
																	}
																	}
																%>

															</table>

															<table width="99%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td height="10"></td>
																</tr>


															</table>
														</td>
													</tr>
													<%--<tr>
<td height="10"></td>
</tr>
--%>
												</table>
											</td>
										</tr>
									</table>
							<tr>
								<td height="10"></td>
							</tr>

							<tr>
								<td></td>
							</tr>
						</table>
						</html:form>
	</body>
</html>
