<%@ page language="java"
	import="java.util.*,org.apache.struts.action.DynaActionForm,com.baosight.mode.SmsRecordDept"
	pageEncoding="GBK"%>
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

		<title>查询统计</title>




		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<script type="text/javascript" src="<%=path%>/js/calendarS.js"></script>
		<script language="javascript">
		function fileprint(){
			var destnumber=document.form1.destnumber.value;
		    var userid=document.form1.userid.value;
			window.open("fileprint.jsp?destnumber="+destnumber+"&userid="+userid,null,"height=550,width=850,status=no,toolbar=yes,scrollbars=yes,menubar=yes,location=no,left=80,top=50");
		}

		 function checkin(){
		 //window.location.href="<%=path%>/queryStatistics.do?method=executeSelect";
		 	document.queryStatisticsForm.method.value="chooseQuery";
			document.queryStatisticsForm.submit();
		 }
		 function selectDepart(){
		    var departid = document.queryStatisticsForm.departid.value;
		    if(departid!=null && departid!=""){
		      document.queryStatisticsForm.method.value="chooseQuery";
		      document.queryStatisticsForm.submit();
		      return true;
		    }else{
		     	window.location.href="<%=path%>/queryStatistics.do?method=executeInput";
		   		return false;
		    }
		   
		 }
		 function clickImageSubmit(){
			 var pattern=/[^0-9]/;
			 if(pattern.test(document.queryStatisticsForm.destnumber.value)){
			   alert("号码只能为数字！");
			   return false;
			 }else{
			   var mm = document.queryStatisticsForm.method.value;
			   mm="likeSelect";
			   document.queryStatisticsForm.method.value=mm;
			   document.queryStatisticsForm.submit();
			   return false;
			 }
			
		 }
		 function clickList(){
		   window.showModalDialog("<%=path %>/orglefttreeaction.do?method=queryList",window,'dialogwidth:500px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		 }
 		function systemTimeS(){
		   	today = new Date();
			sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
			//stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
			//ses = fmtl(today.getSeconds(),2);
			document.getElementById("startTime").value = sday;
		
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
	</head>

	<body onload="systemTimeS();">
		<html:form action="/queryStatistics" method="post">
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="288" height="40" align="left" valign="middle"
									background="<%=path%>/images/8-1.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="5%" align="center" valign="middle">
												&nbsp;
											</td>
											<td width="11%" height="12" align="center" valign="middle">
												<img src="<%=path%>/images/icon5.gif" width="7" height="7" />
											</td>
											<td width="84%" class="table2_topic" align="right">
												查询统计
											</td>
										</tr>
									</table>
								</td>
								<td background="<%=path%>/images/8-2.gif">
									&nbsp;
								</td>
							</tr>
						</table>
						<table width="100%" align="center" border="1" cellpadding="0"
							cellspacing="1" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="99%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="15" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="bottom">
															<table width="100%" border="1" align="center"
																cellpadding="0" cellspacing="0"
																bordercolorlight="#cccccc" bordercolordark="#FFFFFF"
																id="question1">
																<tr>
																	<td width="11%" bgcolor="#F7F7F7">
																		<strong>发送部门：</strong>
																	</td>
																	<td width="9%">
																		<html:text property="deptName" onclick="clickList()" readonly="true" style="width: 100"/>
																		<html:hidden property="departid"/>
																		<%--<html:select property=""
																			onchange="selectDepart()" onclick="clickList()">
																			<option id="" Value="">
																				--部门--
																			</option>
																			<html:optionsCollection property="collDepart"
																				name="queryStatisticsForm" />
																		</html:select>
																	--%></td>
																	<td width="10%" bgcolor="#F7F7F7">
																		<strong>发送人：</strong>
																	</td>
																	<td width="10%">
																		<html:select property="userid">
																			<option Value="">
																				--人员--
																			</option>
																			<logic:notEmpty name="queryStatisticsForm" property="collUser">
																			<html:optionsCollection property="collUser"
																				name="queryStatisticsForm" />
																			</logic:notEmpty>
																		</html:select>
																	</td>
																	<td width="6%" bgcolor="#F7F7F7">
																		<strong>时间</strong>：
																	</td>

																	<td width="26%">
																		<html:text property="startTime" style="cursor:hand"
																			onfocus="setday(this)" readonly="true"
																			style="cursor:hand" size="10" value=""></html:text>
																		到
																		<html:text property="endTime" style="cursor:hand"
																			onfocus="setday(this)" readonly="true"
																			style="cursor:hand" size="10"></html:text>
																	</td>
																	<td width="10%" bgcolor="#F7F7F7">
																		<strong>手机号码：</strong>
																	</td>
																	<td width="12%">
																		<html:text property="destnumber" size="15"
																			maxlength="50" value=""></html:text>
																	</td>
																</tr>
																<tr>
																	<td bgcolor="#F7F7F7" colspan="8">
																		<table>
																			<tr>
																				<td>
																					<strong>发送内容：</strong>
																				</td>
																				<td>
																					<html:text property="content" size="90"
																						maxlength="50" value=""></html:text>
																				</td>
																				<td>
																					&nbsp;
																					<input type="hidden" name="method" />
																					<a href="#" onclick="return clickImageSubmit();">
																						<img src="<%=path %>/imagine/tj.gif"></a> &nbsp;
																					<a href="#" onclick="fileprint()"> </a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>

															<table width="100%" border="0" align="center"
																cellpadding="2" cellspacing="0"
																bordercolorlight="#cccccc" bordercolordark="#FFFFFF">
																<tr>
																	<td colspan="2" bgcolor="f7f7f7">
																		<strong> 所有发送短信列表</strong>
																	</td>
																</tr>

																<tr>
																	<td colspan="8" bgcolor="f7f7f7">
																		<table width="100%" border="1" align="center"
																			cellpadding="2" cellspacing="0"
																			bordercolorlight="#cccccc" bordercolordark="#FFFFFF">
																			<tr>
																				<td bgcolor="e0e3e8" align="center" width="25%">
																					<strong>短信内容</strong>
																				</td>
																				<td bgcolor="e0e3e8" align="center" width="8%">
																					<strong>发送人</strong>
																				</td>
																				<td bgcolor="e0e3e8" align="center" width="15%">
																					<strong>发送部门</strong>
																				</td>
																				<td bgcolor="e0e3e8" align="center" width="22%">
																					<strong>发送时间</strong>
																				</td>
																				<td bgcolor="e0e3e8" align="center" width="8%">
																					<strong>接收人</strong>
																				</td>
																				<td bgcolor="e0e3e8" align="center" width="22%">
																					<strong>接收号码</strong>
																				</td>
																			</tr>
																			<logic:iterate id="item" name="curPageList">
																				<tr>
																					<td width="25%"
																						title="<bean:write name="item" property="messageContent" />">
																						&nbsp;
																						<bean:write name="item" property="messageContent" />
																					</td>
																					<td width="8%"
																						title="<bean:write name="item" property="uname" />">
																						&nbsp;
																						<bean:write name="item" property="uname" />
																					</td>
																					<td width="15%"
																						title="<bean:write name="item" property="deptname" />">
																						<bean:write name="item" property="deptname" />
																						&nbsp;
																					</td>
																					<td width="22%"
																						title="<bean:write name="item" property="scheduletime" />">
																						&nbsp;
																						<bean:write name="item" property="scheduletime"
																							format="yyyy-MM-dd HH:mm:ss" />
																					</td>
																					<td width="8%" title="<bean:write name="item" property="receiveuser" />">
																						&nbsp;<bean:write name="item" property="receiveuser" />
																					</td>
																					<td width="22%"
																						title="<bean:write name="item" property="destNumber" />">
																						&nbsp;
																						<bean:write name="item" property="destNumber" />
																					</td>
																				</tr>
																				
																			</logic:iterate>
																			<tr>
																				<td colspan="8">
																					<table align="right">
																						<tr>
																							<td>
																								<a
																									href="<%=path%>/queryStatistics.do?method=movePageCur&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>"><span
																									class="bg-zw">上一页</span> </a>
																								<a
																									href="<%=path%>/queryStatistics.do?method=movePageCur&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>"><span
																									class="bg-zw">下一页</span> </a>
																								<span class="bg-zw">第<%=curPage + 1%>页</span>
																								<span class="bg-zw">每页显示</span>
																								<a
																									href="<%=path%>/queryStatistics.do?method=resetPageSizeCur&pageSize=10&sessionID=<%=sessionID%>"><span
																									class="bg-zw">10</span> </a>
																								<a
																									href="<%=path%>/queryStatistics.do?method=resetPageSizeCur&pageSize=20&sessionID=<%=sessionID%>"><span
																									class="bg-zw">20</span> </a>
																								<a
																									href="<%=path%>/queryStatistics.do?method=resetPageSizeCur&pageSize=30&sessionID=<%=sessionID%>"><span
																									class="bg-zw">30</span> </a>
																								<span class="bg-zw">条</span>
																								<span class="bg-zw">共<%=count %>条</span>
																							</td>
																						</tr>
																					</table>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>

														</td>
													<tr>
														<td height="10"></td>
													</tr>
												</table>

												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="8"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>

