<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String parentid = request.getParameter("parentid");
	String p_name = (String) request.getParameter("p_name");
	String name = (String) request.getAttribute("name");
	String id = (String) request.getAttribute("id");
	String type = (String) request.getParameter("type");
	String infoname = (String) request.getParameter("infoname");//chaxunbaoliu
	if (infoname == null)
		infoname = "";
	String str = "";
	if ("dsh".equals(type))
		str = "审核";
	else if ("bs".equals(type))
		str = "报送";
	else if ("spxx".equals(type))
		str = "审批";

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
	
	List infoConList = (List) request.getAttribute("curPageList");
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
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">

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
											<td width="84%" class="table2_topic" align="right">
												<%=p_name%>
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
														<td align="center" valign="bottom">
														<% if ("dsh".equals(type)||"spxx".equals(type)){%>
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="2%" height="25">
																		&nbsp;
																	</td>
																	<td width="18%" height="25" class="tabin_atab">
																		<span onclick="javascript:infodshList();"
																			onmouseover="this.style.cursor='hand'">信息中心</span>
																	</td>
																	<td width="18%" height="25" class="tabin_atabno" align="center">
																		<span onclick="javascript:gocinfodshList();"
																			onmouseover="this.style.cursor='hand'">政府信息公开</span>&nbsp;&nbsp;
																	</td>
																	<td colspan="5"></td>
																</tr>
															</table>
															<%} %>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>

																	<td height="27" colspan="5" valign="middle"
																		bgcolor="#f7f7f7" align="left">
																		标题&nbsp;
																		<input type="text" name="infoname"
																			value="<%=infoname == null ? "" : infoname%>" maxlength="100"
																			class="shuruk1" />
																		<input name="Submit2" type="submit" class="button0"
																			value="&nbsp;查 询&nbsp;" onclick="selectByName();"
																			onmouseover="this.style.cursor='hand'" />
																	</td>
																</tr>
																<tr align="center" class="bg-zwbt">
																	<td width="10%" height="25" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		序号
																	</td>
																	<td align="center" width="35%">
																		标题
																	</td>
																	<td align="center" width="35%">
																		发布日期
																	</td>
																	<% if ("spxx".equals(type)) { %>
																	
																	<%}else {%><td align="center" width="20%" colspan="2">
																		操作
																	</td><%}%>
																</tr>
																<%
																		for (int i = 0; i < infoConList.size(); i++) {
																		TbInfoPubContent item = (TbInfoPubContent) infoConList.get(i);
																%>
																<tr align="center" class="bg-zw">
																	<td width="10%" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="35%">
																		<%=item.getTitle()%>
																	</td>
																	<td align="center" width="35%">
																		<%=sdf.format(item.getPublishTime())%>
																	</td>
																	
																	<% if ("spxx".equals(type)) { %>
																	
																	<%}else {%>
																	<td align="center" width="10%">
																		<a
																			href="<%=path%>/infopubContentaction.do?method=bsdshview&type=<%=type%>&p_name=<%=item.getAttr2()%>&parentid=<%=item.getInfoSubject()%>&id=<%=item.getId()%>&addType=<%=item.getAddType() %>"><%=str%>
																		</a>
																	</td>
																	<td align="center" width="10%">
																		<a
																			href="<%=path%>/infopubContentaction.do?method=delete&p_name=<%=item.getAttr2()%>&parentid=<%=item.getInfoSubject()%>&id=<%=item.getId()%>"
																			onclick="return confirm('是否确认删除')"><img
																				src="<%=path%>/imagine/sc.gif" width="15"
																				height="15" border="0"> </a>
																	</td>
																	<%}%>
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
																			href="<%=path%>/infopubContentaction.do?method=movePageInfo&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>&pageName=bsdshlist"><span
																			class="bg-zw">上一页</span> </a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=movePageInfo&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>&pageName=bsdshlist"><span
																			class="bg-zw">下一页</span> </a>
																		<span class="bg-zw">第<%=curPage + 1%>页</span>
																		&nbsp;&nbsp;&nbsp;&nbsp;
																		<span class="bg-zw">每页显示</span>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSizeInfo&pageSize=10&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>&pageName=bsdshlist"><span
																			class="bg-zw">10</span> </a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSizeInfo&pageSize=20&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>&pageName=bsdshlist"><span
																			class="bg-zw">20</span> </a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSizeInfo&pageSize=30&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>&pageName=bsdshlist"><span
																			class="bg-zw">30</span> </a>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">共<%=count %>条</span>
															</table>
														</td>
													</tr>
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
	</body>
</html>
<script language="javascript">
function infodshList()
{
	window.location.href="<%=path%>/infopubContentaction.do?method=list&parentid<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}

function gocinfodshList()
{
	window.location.href="<%=path%>/govinfopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}
function selectByName()
{
	var infoname=document.getElementById("infoname").value;
    window.location.href="<%=path%>/infopubContentaction.do?method=list&type=<%=type%>&infoname="+infoname+"&parentid=<%=parentid%>&p_name=<%=p_name%>";
}
</script>