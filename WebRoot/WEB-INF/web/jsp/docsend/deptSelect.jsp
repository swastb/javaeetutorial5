<%@ page language="java" import="java.util.*,com.baosight.mode.TbDocsendListitems" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List deptList = (List)request.getAttribute("deptList");
String type = (String)request.getParameter("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <base href="<%=basePath%>">

    <title>所有部门列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="images/style.css" rel="stylesheet" type="text/css">
	</head>
<body>
<form method="post">
	<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
        <tr><th height="24" colspan="2">所有机关列表</th></tr>
        <tr> 
      		<td height="24" width="10%" ALIGN="LEFT" nowrap="nowrap"><b>选择结果：</b></td>
        	<td align="left">类别词:&nbsp;<input type="text" name="choose" value='' class="tab_input">
        	<input type="button" value="提交" onclick="tijiao()" class="button0">
        	<input type="button" value="返回" onclick="window.close()" class="button0"> 　
      		</td>
		</tr>
    	<% if (deptList!=null && deptList.size()>0)
    		for (int i=0;i<deptList.size();i++) {
    			TbDocsendListitems item = (TbDocsendListitems)deptList.get(i);
    	%>
    	<tr>
    		<td align="center" height="24" nowrap="nowrap">
    		<input type="checkbox" name="deptSel" value="<%=item.getTitle() %>" onclick="changeChoose()"><%=i+1 %>
    		</td>
    		<td nowrap="nowrap"><%=item.getTitle() %></td>
    		</tr>
    	<%}%>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
function tijiao() {
	window.dialogArguments.document.getElementById("${param.nameText}").value=document.getElementById("choose").value;
	window.close();
}
function changeChoose(){
	var checks = document.getElementsByName("deptSel");
	var cho = document.forms[0].choose;
	var myChoose = new Array();
	for(var i=0;i<checks.length;i++){
		if(checks[i].checked){
			myChoose.push(checks[i].value);
		}
	}
	cho.value = myChoose.join(",");
}
</script>

