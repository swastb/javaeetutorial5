<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String type = (String)request.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>公共通讯录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
		<frameset cols="150,*" frameborder="NO" border="0" framespacing="0">
			<frame name="left" scrolling="auto" noresize
				src="<%=path %>/commonalityCommAction.do?method=treeList&type=root"/>
			<frame name="detail"
				src="<%=path %>/commonalityCommAction.do?method=list&parentid=0a&p_name=<%="公共通讯录" %>"/>			
		</frameset>
	<noframes></noframes>
</html>
