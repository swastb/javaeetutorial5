<%@ page language="java" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String parentId = request.getParameter("parentId");
	String childIdOne = request.getParameter("childIdOne");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>infopublicframeset</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
		<frameset cols="120,*" frameborder="NO" border="0" framespacing="0">
			<frame name="left" scrolling="auto" noresize
				src="<%=path %>/infopubclaaction.do?method=childclas&parentid=<%=parentId %>"/>
			<frame name="detail"
				src="<%=path %>/infopubContentaction.do?method=slzxInfoList&parentid=<%=childIdOne %>&p_name=<%="中心主任" %>"/>
		</frameset>
	<noframes></noframes>
</html>
