<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript">
    	function succ(){
    		var op = document.getElementById("op").value;
    		if(op!=null && op !=""){
    			if(op=="add"){
    				alert("添加资源操作成功");	    				
    			}
    			if(op=="addRoot"){
    				alert("添加根资源操作成功");
    			}
    			if(op=="update"){
    				alert("更新资源操作成功");
    			}
    			if(op=="delete"){
    				alert("删除资源操作成功");
    			}	    				    				    			
    		}    		
    		window.parent.location.reload();
    	}
    </script>
    
    <title>My JSP 'dept_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body onload="succ();">
  	<input id="op" type="hidden" value="${op }">
  </body>
</html>
