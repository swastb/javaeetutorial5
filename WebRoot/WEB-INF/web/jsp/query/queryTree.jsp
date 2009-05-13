<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbCommonalityComm"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script src="<%=path %>/javascript/validate.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/cs.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

	</head>
			
<script type="text/javascript">
<!--
		var aryPType = new Array();
			<%
				ArrayList list=(ArrayList)request.getAttribute("menuList");
				for(int i=0;i<list.size();i++)
				{
					TbCommonalityComm  tbCommonalityComm=(TbCommonalityComm)list.get(i);
					String parentId=null;
					if(tbCommonalityComm.getParentId()==null)
					{
						parentId="0";
					}
					else
					{
						parentId=tbCommonalityComm.getParentId();
					}
						out.println("aryPType["+(i+1)+"]=new TreeNode('"+parentId+"','"+tbCommonalityComm.getName()+"','"+tbCommonalityComm.getId()+"');");
					
				}
				out.println("var countPType ="+list.size()+";");
			%>
//-->
</script>
	<body>
		
	</body>
</html>