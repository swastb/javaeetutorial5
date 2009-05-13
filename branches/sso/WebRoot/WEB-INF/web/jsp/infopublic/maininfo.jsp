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
		<title>My JSP 'orgmain.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
		<frameset cols="150,*" frameborder="NO" border="0" framespacing="0">
			<frame name="left" scrolling="auto" noresize
				src="<%=path %>/infopubclaaction.do?method=list&type=root"/>
			<frame name="detail"
				src="<%=path %>/infopubclaaction.do?method=clalist&parentid=0&p_name=<%="信息管理" %>&type=root"/>
			<%--<% 
				if ("infopub".equals(type)){%>
				<frame name="detail"
				src="<%=path %>/infopubContentaction.do?method=list&parentid=1&p_name=<%="信息发布" %>">
				<%}
				else{
				%>
				<frame name="detail"
				src="<%=path %>/govinfopubContentaction.do?method=list&parentid=2&p_name=<%="政府信息公开信息发布" %>">
				<%}
			%>
		--%>
		</frameset>
	<noframes></noframes>
</html>
