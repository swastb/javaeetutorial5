<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List resultList = (List) request.getAttribute("resultList");
	String claId = (String) request.getAttribute("claId");
%>

<script type="text/javascript">
<!--
	function temp(){
		alert("alert");
	}
//-->
</script>
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

	<body topmargin="0" leftmargin="0" background="<%=path %>\images\djyd1.jpg">
		<table width="270" height="1"  border="0"
			cellpadding="0" cellspacing="0" >
			<tr>
				<td height="30"></td>
			</tr>
			<tr>
				<td class="zw" align="center" width="100">
					&nbsp;
				</td>
				<td class="zw" align="center" width="170">
				<a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=djyd&code=zhibujianshe&flag=false&state=1&claId=<%=request.getAttribute("zbjs") %>"
						target="rightFrame"">支部建设</a><br/>
					<a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=dqgz&code=specialfordqgz&flag=false&state=1&claId=<%=request.getAttribute("dqgz") %>"
						target="rightFrame"">党群工作</a>
						
				</td>
			</tr>
			<tr>
				<td class="zw" align="center" width="135">
					
				</td>
				<td class="zw" align="center">
					<a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=djyd&code=WarningEdu&flag=false&state=1&claId=<%=request.getAttribute("jzcm") %>"
						target="rightFrame"">警钟常鸣</a>
						<br/><a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=djyd&code=xuexizhuanlan&flag=false&state=1&claId=<%=request.getAttribute("xxzl") %>"
						target="rightFrame"">学习专栏</a>
				</td>
			</tr>
			<tr>
				<td class="zw" align="center" width="135">
					
				</td>
				<td class="zw" align="center">
				<a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=djyd&code=jihuazongjie&flag=false&state=1&claId=<%=request.getAttribute("jhzj") %>"
						target="rightFrame"">计划总结</a><br/>
					<a onmouseover="this.style.cursor='hand'"
						href="<%=path%>/layoutContent.do?method=djyd&code=huodongjianbao&flag=false&state=1&claId=<%=request.getAttribute("xxsjkxfz") %>"
						target="rightFrame"">学习实践科学发展观专题</a>
						
				</td>
			
			<td>
			
			
			
			
			</td>
			
			
			</tr>
		</table>
		
	</body>
</html>


