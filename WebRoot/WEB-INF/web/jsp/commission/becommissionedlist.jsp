<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbCommission" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String commission = request.getParameter("commission");
	String beginTime = request.getParameter("beginTime");
	String endTime = request.getParameter("endTime");
	if (commission==null || commission.equals(""))
		commission = "";
	if (beginTime==null || beginTime.equals(""))
		beginTime = "";
	if (endTime==null || endTime.equals(""))
		endTime = "";
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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	Date now = new Date();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%
		List commissionList = (List) request.getAttribute("curPageList");
		%>
		<base href="<%=basePath%>">

		<title>My JSP 'pstlvllist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	</head>
	<body>
		<form action="<%=path %>/commission.do" target="_top" method="post">
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
												被委托列表
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
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="top">
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="2%" height="25">
																		&nbsp;
																	</td>
																	<td width="18%" class="tabin_atabno">
																		<span onclick="javascript:commissionList();"
																			onmouseover="this.style.cursor='hand'">委托列表</span>
																	</td>
																	<td width="18%" class="tabin_atab">
																		<span onclick="javascript:beCommissionedList();"
																			onmouseover="this.style.cursor='hand'">被委托列表</span>
																	</td>
																	<td colspan="5"></td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td align="left" valign="bottom" width="10%"
																		colspan="6" height="25">
																		委托名：&nbsp;
																		<input type="text" name="commission" maxlength="100"
																			value="<%=commission%>" class="shuruk1"/>
																		开始时间：&nbsp;	
																		<input type="text" name="beginTime" maxlength="100"
																			value="<%=beginTime%>" class="shuruk1" onfocus="setday(this)"/>
																		结束时间：&nbsp;
																		<input type="text" name="endTime" maxlength="100"
																			value="<%=endTime%>" class="shuruk1" onfocus="setday(this)"/>
																			<input name="Submit2" type="button" class="button0" value="&nbsp;查 询&nbsp;" onclick="searchCommission();"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																
																	</td>
																	
																</tr>
																<tr align="center">
																	<th width="5%" align="center" height="25">
																		序号
																	</th>
																	<th align="center" width="20%">
																		标题
																	</th>
																	<th align="center" width="15%">
																		委托人
																	</th>
																	<th align="center" width="20%">
																		委托开始日期
																	</th>
																	<th align="center" width="20%">
																		委托结束日期
																	</th>
																	<th align="center" width="20%" colspan="1">
																		操作
																	</th>
																</tr>
																<%
																	for (int i = 0; i < commissionList.size(); i++) {
																		TbCommission item = (TbCommission) commissionList.get(i);
																%>
																<tr align="center">
																	<td width="5%" height="25" align="center" nowrap="nowrap">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="20%" nowrap="nowrap">
																		<%=item.getCommTitle()%>
																	</td>
																	<td align="center" width="15%" nowrap="nowrap">
																		<%=item.getCommName()%>
																	</td>
																	<td align="center" width="20%" nowrap="nowrap">
																		<%=sdf.format(item.getBegintime())%>
																	</td>
																	<td align="center" width="20%" nowrap="nowrap">
																		<%=sdf.format(item.getEndtime())%>
																	</td>
																	<td align="center" width="20%" nowrap="nowrap">
																	<%
																		if (item.getCommFlag()==0) {
																		%>
																		<input type="button" class="button0" value="查看处理" name="mod_btn" onclick="loginTo('<%=item.getCommId() %>')">
																		<%
																		}
																		else if (item.getCommFlag()==1 && now.before(item.getEndtime())) {
																		%>
																		<input type="button" class="button0" value="委托待处理" name="mod_btn" onclick="view('<%=item.getId() %>')">
																		<%
																		}
																	 %>
																	 </td>
																</tr>
																<%
																}
																%>
															</table>
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0" align="right">
																<tr>
																	<td height="10"></td>
																</tr>
																<tr>
																	<td class="tabin_page">
																		<a
																			href="<%=path%>/commission.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&commission=<%=commission%>&beginTime=<%=beginTime%>&endTime=<%=endTime%>&type=2"><span
																			class="bg-zw">上一页</span>
																		</a>
																		<a
																			href="<%=path%>/commission.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&commission=<%=commission%>&beginTime=<%=beginTime%>&endTime=<%=endTime%>&type=2"><span
																			class="bg-zw">下一页</span>
																		</a>
																		<span class="bg-zw">第<%=curPage + 1%>页</span>
																		<span class="bg-zw">每页显示</span>
																		<a
																			href="<%=path%>/commission.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&commission=<%=commission%>&beginTime=<%=beginTime%>&endTime=<%=endTime%>&type=2"><span
																			class="bg-zw">10</span>
																		</a>
																		<a
																			href="<%=path%>/commission.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&commission=<%=commission%>&beginTime=<%=beginTime%>&endTime=<%=endTime%>&type=2"><span
																			class="bg-zw">20</span>
																		</a>
																		<a
																			href="<%=path%>/commission.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&commission=<%=commission%>&beginTime=<%=beginTime%>&endTime=<%=endTime%>&type=2"><span
																			class="bg-zw">30</span>
																		</a>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">共<%=count %>条</span>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="20"></td>
													</tr>
												</table>
											</td>
										</tr>
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
			<input type="hidden" name="method" />
			<input type="hidden" name="userId" />
		</form>
	</body>
</html>

<script language="javascript">
	function commissionList() {
		window.location.href="<%=path%>/commission.do?method=commissionList&type=1";
	}

	function beCommissionedList() {
		window.location.href="<%=path%>/commission.do?method=commissionList&type=2";
	}

	function searchCommission() {
		var comm_name=document.getElementById("commission").value;
		var beginTime=document.getElementById("beginTime").value;
		var endTime=document.getElementById("endTime").value;
		window.location.href="<%=path%>/commission.do?method=commissionList&type=2&comm_name="+comm_name+"&beginTime="+beginTime+"&endTime="+endTime;
	}
	function view(id) {
		window.location.href="<%=path%>/commission.do?method=viewCommission&id="+id+"&from=beCommed";
	}
	function loginTo(userId) {
		document.all.method.value='autoLoginTo';
		document.all.userId.value=userId;
		document.forms[0].submit();
		return  true;
		//parent.location.href="WebRoot/jsp/login.jsp";   
		//window.location.href="<%=path%>/commission.do?method=autoLoginTo&userId="+userId;
	}
</script>
