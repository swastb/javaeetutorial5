<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String state = request.getParameter("state");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'queryStatistic.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="images/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=path%>/js/calendarS.js"></script>
		<style>
		a:link {text-decoration: none;}
		a:visited {text-decoration: none;}
		a:active {text-decoration: none;}
		a:hover {text-decoration: none;}
		</style>
		<script language="javascript">

function subFrom(){
	document.forms[0].submit();
} 
function sendAgain(id){
		document.getElementById("id").value = id;
		document.getElementById("method").value="insert";
		document.forms[0].submit();
		alert("该传真发送成功");
} 
</script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<%
		String sessionID = "";
		int curPage = 0;
		long count = 0;
		try {
			sessionID = (String) request.getAttribute("sessionID");
			curPage = (Integer) session.getAttribute(sessionID + "No");
			count = (Long) session.getAttribute(sessionID + "Count");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List list = (List) request.getAttribute("curPageList");
		List deptNamelist = (List) request.getAttribute("deptNamelist");
		List senderlist = (List) request.getAttribute("senderlist");
	%>
	<body>
		<html:form action="/faxQuerySchedule">
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
											<td width="84%" class="table2_topic" align="right">
												查询统计
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
								<td align="center">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center">
															<table width="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="2%" height="24">
																		&nbsp;
																	</td>
																	<%
																	if (request.getParameter("state").toString().equals("002")) {
																	%>
																	<td width="16%" class="tabin_atabno">
																		<a href="faxQuerySchedule.do?method=list&state=001">已发送传真</a>
																	</td>
																	<td width="16%" class="tabin_atab">
																		<span class="bg-zw">发送失败传真</span>
																	</td>
																	<%
																	} else {
																	%>
																	<td width="16%" class="tabin_atab">
																		已发送传真
																	</td>
																	<td width="16%" class="tabin_atabno">
																		<a href="faxQuerySchedule.do?method=list&state=002"><span
																			class="bg-zw">发送失败传真</span> </a>
																	</td>
																	<%
																	}
																	%>

																	<td width="90%">
																		&nbsp;
																	</td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td height="35" colspan="6" valign="middle"
																		bgcolor="#f7f7f7" align="left">
																		发送部门：
																		<select name="sendDeptId">
																			<option value="">
																				--部门--
																			</option>
																			<%
																						for (int i = 0; null != deptNamelist && !deptNamelist.isEmpty()
																						&& deptNamelist.size() > 0 && i < deptNamelist.size(); i++) {
																					Object[] item = (Object[]) deptNamelist.get(i);
																					if (request.getAttribute("sendDeptId") != null
																					&& request.getAttribute("sendDeptId").equals(item[0])) {
																			%>
																			<option
																				value="<%=item[0] == null ? "&nbsp;" : item[0]%>"
																				selected>
																				<%=item[1] == null ? "&nbsp;" : item[1]%>
																			</option>
																			<%
																			} else {
																			%>
																			<option
																				value="<%=item[0] == null ? "&nbsp;" : item[0]%>">
																				<%=item[1] == null ? "&nbsp;" : item[1]%>
																			</option>
																			<%
																			}
																			%>
																			<%
																			}
																			%>
																		</select>
																		发送人：
																		<select name="sender">
																			<option value="">
																				--人员--
																			</option>
																			<%
																						for (int i = 0; !senderlist.isEmpty() && senderlist.size() > 0
																						&& i < senderlist.size(); i++) {
																					if (request.getAttribute("sender") != null
																					&& request.getAttribute("sender").equals(
																							senderlist.get(i).toString())) {
																			%>
																			<option
																				value="<%=senderlist.get(i) == null ? "&nbsp;": senderlist.get(i)%>"
																				selected>
																				<%=senderlist.get(i) == null ? "&nbsp;": senderlist.get(i).toString()%>
																			</option>
																			<%
																			} else {
																			%>
																			<option
																				value="<%=senderlist.get(i) == null ? "&nbsp;": senderlist.get(i)%>">
																				<%=senderlist.get(i) == null ? "&nbsp;": senderlist.get(i).toString()%>
																			</option>
																			<%
																				}
																				}
																			%>
																		</select>
																		时间：
																		<input id="startTime" name="startTime"
																			value="${param.startTime}" style="width:80px"
																			onfocus='setday(this)'
																			ondblclick="javaScript:document.getElementById('startTime').value = '';"
																			readonly>
																		到
																		<input id="endTime" name="endTime"
																			value="${param.endTime}" style="width:80px"
																			onclick='setday(this)'
																			ondblclick="javaScript:document.getElementById('endTime').value = '';"
																			readonly />
																		传真号码：
																		<input name="faxNum" id="faxNum"
																			value="${param.faxNum}" style="width:100px" />
																		<input name="Submit2" type="button" class="button0"
																			value="查 询" onclick="subFrom();"
																			onmouseover="this.style.cursor='hand'" />
																	</td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<th width="20%" height="25">
																		传真内容
																	</th>
																	<th width="10%">
																		发送人
																	</th>
																	<th width="20%">
																		发送部门
																	</th>
																	<th width="10%">
																		发送时间
																	</th>
																	<th width="10%">
																		接收人
																	</th>
																	<th width="10%">
																		接收号码
																	</th>
																	<%
																	if (request.getParameter("state").toString().equals("002")) {
																	%>
																	<th width="10%">
																		操作
																	</th>
																	<%
																	}
																	%>


																</tr>
																<%
																			for (int i = 0; !list.isEmpty() && list.size() > 0
																			&& i < list.size(); i++) {
																		Object[] item = (Object[]) list.get(i);
																%>
																<tr>
																	<td height="25">
																		<a href="<%=item[7]%>"><%=item[0] == null ? "&nbsp;" : item[0]%>
																		</a>
																	</td>
																	<td>
																		<%=item[1] == null ? "&nbsp;" : item[1]%>
																	</td>
																	<td>
																		<%=item[3] == null ? "&nbsp;" : item[3]%>
																	</td>
																	<td>
																		<%=item[4] == null ? "&nbsp;" : item[4]%>
																	</td>
																	<td>
																		<%=item[5] == null ? "&nbsp;" : item[5]%>
																	</td>
																	<td>
																		<%=item[6] == null ? "&nbsp;" : item[6]%>
																	</td>
																	<%
																	if ((request.getParameter("state").toString().equals("002"))) {
																	%>
																	<td width="10%">
																		<input name="" type="button" value="重发"
																			onclick="sendAgain('<%=item[8]%>');"
																			onmouseover="this.style.cursor='hand'" />
																	</td>
																	<%
																	}
																	%>
																</tr>
																<%
																}
																%>
															</table>
														</td>
													</tr>

													<tr>
														<td align="right">
															<table>
																<tr>
																	<td>
																		<a
																			href="<%=path%>/faxQuerySchedule.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&state=<%=state%>&startTime=${param.startTime}&endTime=${param.endTime}&faxNum=${param.faxNum}&sendDeptId=${param.sendDeptId}&sender=${param.sender}"><span
																			class="bg-zw">上一页</span> </a>
																		<a
																			href="<%=path%>/faxQuerySchedule.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&state=<%=state%>&startTime=${param.startTime}&endTime=${param.endTime}&faxNum=${param.faxNum}&sendDeptId=${param.sendDeptId}&sender=${param.sender}"><span
																			class="bg-zw">下一页</span> </a>
																		<span class="bg-zw">第<%=curPage + 1%>页</span>
																		<span class="bg-zw">每页显示</span>
																		<a
																			href="<%=path%>/faxQuerySchedule.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&state=<%=state%>&startTime=${param.startTime}&endTime=${param.endTime}&faxNum=${param.faxNum}&sendDeptId=${param.sendDeptId}&sender=${param.sender}"><span
																			class="bg-zw">10</span> </a>
																		<a
																			href="<%=path%>/faxQuerySchedule.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&state=<%=state%>&startTime=${param.startTime}&endTime=${param.endTime}&faxNum=${param.faxNum}&sendDeptId=${param.sendDeptId}&sender=${param.sender}"><span
																			class="bg-zw">20</span> </a>
																		<a
																			href="<%=path%>/faxQuerySchedule.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&state=<%=state%>&startTime=${param.startTime}&endTime=${param.endTime}&faxNum=${param.faxNum}&sendDeptId=${param.sendDeptId}&sender=${param.sender}"><span
																			class="bg-zw">30</span> </a>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">共<%=count%>条</span>
																	</td>
																</tr>
																<tr>
																	<td height="20"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>

											</td>
										</tr>

										<tr>
											<td height="8" colspan="2"></td>
										</tr>

									</table>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="method" value="list" />
			<input type="hidden" name="state" value=<%=state%> />
			<input type="hidden" name="id" />
		</html:form>
	</body>
</html>
