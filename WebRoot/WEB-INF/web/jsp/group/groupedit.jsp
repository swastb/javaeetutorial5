<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pstlvledit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">	

  </head>
  
  <body>
  	<html:form action="/groupaction.do">

  	    <table align="center" width="100%" border="2" cellpadding="0" cellspacing="0" bordercolor="97cdda" class="tableborder">
		<tr>
			<td height="10"></td>
		</tr>
				<thead class="bg-zw">
    	<tr>
    		<td  width="50%">组编号</td>
    		<td colspan="2"><html:text property="code"></html:text></td>
    	</tr>
    	<tr>
    		<td  width="50%">组名称</td>
    		<td colspan="2"><html:text property="name"></html:text></td>
    	</tr>
    	<tr>
    		<td  width="50%">所属部门</td>
    		<td colspan="2"><html:text property="deptcode"></html:text></td>
    	</tr>
    	<tr>
    		<td  width="50%">组级别</td>
    		<td colspan="2"><html:text property="lvl"></html:text></td>
    	</tr>
    	<tr>
    		<td  width="50%">说明</td>
    		<td colspan="2"><html:text property="rem"></html:text></td>
    	</tr>
    	</thead>
 <thead class="bg-zwbt">
    	<tr>
			
    		<td colspan="3">
    		<a onclick="if(document.all.id.value==''){document.all.method.value='add'}else{document.all.method.value='modify'};document.all.action.value='submit';document.forms[0].submit();"
    		onmouseover="this.style.cursor='hand'">提交</a>&nbsp;&nbsp;
    		<a onclick="history.go(-1)" onmouseover="this.style.cursor='hand'">返回</a></td>
    	</tr>
    	</thead>
    </table>
    <input type="hidden" name="action" />
    <input type="hidden" name="method" />
    <html:hidden property="id"/>
	</html:form>
  </body>
</html>
