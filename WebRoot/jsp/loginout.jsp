<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="commons.jsp"%>
<%@ page import="com.baosight.tools.ChangeUtil"%>
<%
    String strpath=request.getContextPath();
    String destorySession=ChangeUtil.xzxkurl+"/byid.do?method=destorySession";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>上海市水务局单点登录系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<meta http-equiv="Content-Language" content="zh-cn" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<base target="_self" />
		<title>XX系统</title>
		<link href="<%=basePath%>/css/style_01.css" rel="stylesheet"
			type="text/css" />
		<script language="JavaScript" src='<%=basePath%>/javascript/tools.js'
			type="text/javascript"></script>
		<script language="JavaScript" src='<%=basePath%>/javascript/cookie.js'
			type="text/javascript"></script>
		<script language="JavaScript" type="text/JavaScript">
		<!--
		
		function out()
		{
			//alert("loginout");
			this.httpGet('<%=destorySession%>');
			var url="<%=strpath%>/jsp/login.jsp";
			window.open (url, 'newwindow');
			window.parent.opener=null;
			window.parent.close();
		}
		out();
		//-->
		</script>

	</head>
	<body >

	</body>
</html>
