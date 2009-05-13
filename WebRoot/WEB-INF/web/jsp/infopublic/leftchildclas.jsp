<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="GBK"%>
<jsp:directive.page
	import="com.baosight.mode.TbInfoPubCla" />
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
List childclas = (List)request.getAttribute("childclas");
 %>
<html>
<head>
<title>left</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
<SCRIPT language=javascript>
<!--
function mOvr(src){ if (!src.contains(event.fromElement)){src.bgColor = '#ffffff';src.children(0).style.color='#000000'}}
function mOut(src){ if (!src.contains(event.toElement)){src.bgColor = '#f7f7f7';src.children(0).style.color='#000000'}}
-->
</SCRIPT>
</head>
<body bgcolor="f7f7f7" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
  
  
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="0">
<% if (childclas!=null) { 
	int size = childclas.size(); 
	for (int i=0;i<size;i++) { 
	TbInfoPubCla item = (TbInfoPubCla)childclas.get(i); 
%>
<TR bgColor=#f7f7f7 onmouseout=mOut(this); onmouseover=mOvr(this)> 
    <td width="15%" align="center"><img src="/sso/imagine/tree/topic.gif" width="16" height="16"></td>
    <TD width="85%" style="font-size: 10pt;">
     <span onclick="hrefTo('<%=item.getId() %>','<%=item.getName() %>');" onmouseover="this.style.cursor='hand'"><%=item.getName() %></span>
    
    </TD>
  </TR>
  <tr>
	<td height="1" colspan="2" background="<%=path %>/imagine/ddddd3.gif"></td>
  </tr>
<%}}%>
</table>
<form name="form" method="post" action="" target="detail"></form>
</body>
</html>
<script language="JavaScript">
function hrefTo(id,name) {
	document.form.action="<%=path %>/infopubContentaction.do?method=slzxInfoList&parentid="+id+"&p_name="+name;
	document.form.submit();
}
</script>

