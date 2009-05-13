<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String currentPath = request.getServletPath();
//String insureOn=(String)request.getAttribute("insureOn");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vehicles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

  </head>
  
  <body>
  <html:form action="/messages.do">
  <table width="97%" align="center" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td height="10"></td>
		</tr>
			<tr>
				<td>
					<img src="/sso/imagine/r-bt.gif" width="11.5" height="14">
					<span class="bg-zw">&nbsp; </span><span class="bg-zw">待办事宜</span>
				</td>
				<td align="right">
					&nbsp;
				</td>
			</tr>
		<tr>
			<td height="10"></td>
		</tr>
		</table>
    <table width="97%" align="center" border="2" cellpadding="0" cellspacing="0"
				bordercolor="97cdda" class="tableborder">
		<tr>
			<td height="24" width="20%" align="center" class="bg-zwbt">待办事宜类型</td>
			<td height="24" width="20%" align="center" class="bg-zwbt">待办事宜链接</td>
			<td height="24" width="20%" align="center" class="bg-zwbt">通知人</td>
			<td height="24" width="10%" align="center" class="bg-zwbt">通知时间</td>
			<td  align="center"  class="bg-zwbt">通知等级</td>
			<td height="24" width="10%" align="center" class="bg-zwbt">备注</td>
		</tr>
		<c:forEach items="${notiesList}" var="list" varStatus="loop">
		<tr>
		<c:if test="${list.id.noticesUrl ==1 }">
			<td height="24" width="20%" align="center" class="bg-zwbt">短信</td>
		</c:if>
		<c:if test="${list.id.noticesUrl !=1 }">
			<td height="24" width="20%" align="center" class="bg-zwbt">其它</td>
		</c:if>
			<td height="24" width="20%" align="center" class="bg-zwbt">${list.id.noticesUrl }</td>
			<td height="24" width="20%" align="center" class="bg-zwbt">${list.id.noticesTo }</td>
			<td height="24" width="20%" align="center" class="bg-zwbt"><fmt:formatDate value="${list.id.noticesTime }" pattern="yyyy-MM-dd hh:ss"/></td>
			<td height="24" width="10%" align="center" class="bg-zwbt"><font color="blue">${list.id.noticesLevel }</font></td>
			<td height="24" width="10%" align="center" class="bg-zwbt"><font color="blue">${list.id.rem }</font></td>
		</tr>
		</c:forEach>
		
	</table>
  </html:form>
  </body>
</html>
