<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="commons.jsp"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<%
			Date date = (Date) application.getAttribute("BootDate");
			if (date == null) {
				date = new Date();
				application.setAttribute("BootDate", date);
			}
			String version = "";
		%>
		<script language="JavaScript" src='../javascript/tools.js'
			type="text/JavaScript"></script>
		<link rel='stylesheet' href='../css/menu.css' type='text/css' />
		<link rel="stylesheet" href="../css/fdgh.css" type="text/css" />
		<link rel="stylesheet" href="../css/d-gridtable.css" type="text/css" />
		<title>上海市水务局<%=version%>
		</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
		<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
		<meta name="ProgId" content="FrontPage.Editor.Document">
		<title>index</title>
	</head>

	<frameset framespacing="0" border="0" rows="91,*" frameborder="0">
		<noframes>

			<body>
				<p>
					此网页使用了框架，但您的浏览器不支持框架。
				</p>

			</body>
		</noframes>
		<frame name="banner" scrolling="no" noresize target="contents"
			src="<%=path%>/jsp/maintop.jsp">
		<frameset cols="255,*">
			<frame name="contents" target="main"
				src="<%=path%>/jsp/mainlefttree.jsp" scrolling="auto">
			<frame name="right" src="<%=path%>/roleaction.do?method=list"
				scrolling="auto" target="_self" scrolling="auto">
		</frameset>
	</frameset>

</html>
