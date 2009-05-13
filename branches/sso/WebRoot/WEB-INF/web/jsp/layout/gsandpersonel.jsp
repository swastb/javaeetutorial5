<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<jsp:directive.page import="java.text.SimpleDateFormat" />
<jsp:directive.page import="com.baosight.mode.TbZwWeekSechedule" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List resultList = (List) request.getAttribute("resultList");
	String claId = (String) request.getAttribute("claId");
	List personLastList = (List) request.getAttribute("personLastList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>contentresult</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
	</head>

	<body topmargin="0" leftmargin="0">

		<table width="270" height="1" align="center" border="0"
			cellpadding="0" cellspacing="0">

			<%
					if (resultList != null && !resultList.isEmpty()) {
					for (int i = 0; i < resultList.size(); i++) {
						TbInfoPubContent item = (TbInfoPubContent) resultList
						.get(i);
						String title = "";
						title = item.getTitle();
						if (title.trim().length() > 15) {
					title = title.substring(0, 15) + "...";
						}
			%>
			<tr>
				<td width="10" height="22" class="zw">
					<img src="<%=path%>/imagine/ddddd2.gif" width="4" height="4">
				</td>
				<td height="22" width="205" class="zw">
					<a
						href="<%=path%>/layoutContent.do?method=view&id=<%=item.getId()%>&state=1&claId=<%=claId %>"
						target="rightFrame"><%=title%> </a>
				</td>
				<td width="54" height="18" align="left" class="zw-time">
					[
					<%=item.getRecordTime() == null ? "" : item
							.getRecordTime().toString().substring(5, 10)%>
					]
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" background="<%=path%>/imagine/ddddd3.gif">
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<table width="270" height="5" valign="top" align="center" border="0"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="215"></td>
				<td height="22" vaign="top" align="center">
					<c:if test="${claId!='' }">
						<a href="<%=path%>/layoutContent.do?method=more&claId=<%=claId%>"
							target="_blank"><img src="<%=path%>/imagine/more.gif"
								width="41" height="11" border="0">&nbsp;</a>
					</c:if>
				</td>
			</tr>
		</table>
		<table width="270" height="1" align="center" border="0"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="22" class="zw">
					<span class="xb">个人日程</span>
				</td>
			</tr>
		</table>

		<table width="270" height="1" align="center" border="0"
			cellpadding="0" cellspacing="0">
			<%
					if (personLastList != null && personLastList.size() > 0) {
					Iterator it = personLastList.iterator();
					SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:dd");

					SimpleDateFormat nsdf = new SimpleDateFormat("yyyy-MM-dd");
					String now = nsdf.format(new Date());
					while (it.hasNext()) {
						TbZwWeekSechedule entity = (TbZwWeekSechedule) it.next();
			%>

			<%--<tr align="left">
				<td width="20%" height="18" class="xb">
					[时间]:
				</td>
				<td width="80%" height="18" class="zw">
					<%
								if (now.equals(sdf.format(entity.getStartTime()).substring(
								0, 10))) {
					%>
					今天&nbsp;
					<%=sdf.format(entity.getStartTime()).substring(
										10, 16)%>
					<%
					} else {
					%>
					明天&nbsp;
					<%=sdf.format(entity.getStartTime()).substring(
										10, 16)%>
					<%
					}
					%>
				</td>
			</tr>
			<tr align="left">
				<td width="20%" height="18" class="xb">
					[内容]:
				</td>
				<td width="80%" height="18" class="zw">
					<%=entity.getContent()%>
				</td>
			</tr>
			<tr align="left">
				<td width="20%" height="18" class="xb">
					[地点]:
				</td>
				<td width="80%" height="18" class="zw">
					<%=entity.getRem()%>
				</td>
			</tr>
			--%>
			<tr align="left">
				<td width="20%" height="18" class="xb">
					[内容]:
				</td>
				<td width="80%" height="18" class="zw">
					<%
						if (now.equals(sdf.format(entity.getStartTime()).substring(
								0, 10))) 
						{
							%>
							今天
							<%=sdf.format(entity.getStartTime()).substring(
												10, 16)%>
							<%
						} else {
							%>
							明天
							<%=sdf.format(entity.getStartTime()).substring(
												10, 16)%>
							<%
						}
					%>
					&nbsp;
					<%
						String context = entity.getItemTitle();
					%>
					<%
						if (context != null) 
						{
							if (context.length() > 10) 
							{
							%>
								<%=context.substring(0, 10)%>...
							<%
							} else 
							{
							%>
								<%=context%>
							<%
							}

						} 
						else 
						{
							%>
							&nbsp;
							<%
						}
					%>
				</td>
			</tr>
			<tr>
				<td height="1" colspan="2" background="<%=path%>/imagine/ddddd3.gif">
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<table width="270" height="5" valign="top" align="center" border="0"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="215"></td>
				<td height="22" vaign="top" align="center">
					<a
						href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=personAll"
						target="rightFrame"><img src="<%=path%>/imagine/more.gif"
							width="41" height="11" border="0">&nbsp;</a>
				</td>
			</tr>
		</table>
	</body>
</html>

