<%@ page language="java" pageEncoding="GBK"%>
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
		<title>My JSP 'orgmain.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
		<frameset cols="160,*" frameborder="NO" border="0" framespacing="0">
			<frame name="left" scrolling="auto" noresize="noresize"
				src="<%=path %>/orglefttreeaction.do?method=list">
			<frame name="detail"
				src="<%=path %>/orgrightdetailaction.do?method=list&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83">
		</frameset>
		<noframes></noframes>
</html>
