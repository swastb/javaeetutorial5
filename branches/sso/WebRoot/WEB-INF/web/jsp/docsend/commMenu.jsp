<%@ page language="java" import="java.text.SimpleDateFormat" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> New Document </TITLE>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
  <link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
 </HEAD>

 <BODY>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#000000" class="tableborder">
		<tr align="right"class="bg-zwbt">
			<td height="25" width="19%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw" onclick="javascript:docSendBook();" onmouseover="this.style.cursor='hand'">发文起草</span>&nbsp;&nbsp;
			</td>
			<td height="25" width="19%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw" onclick="javascript:docSendList('1');" onmouseover="this.style.cursor='hand'"> 新收到的发文 </span>&nbsp;&nbsp;  
			</td>
			<td height="25" width="19%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw" onclick="javascript:docSendList('2');" onmouseover="this.style.cursor='hand'">正在办理的发文 </span>&nbsp;&nbsp;
			</td>
			<td height="25" width="19%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw"  onclick="javascript:docSendList('0');" onmouseover="this.style.cursor='hand'">已办理的发文</span>&nbsp;&nbsp; 
			</td>
			<td height="25" width="19%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw" onclick="javascript:docSendList('3');" onmouseover="this.style.cursor='hand'">新起草的发文 </span>&nbsp;&nbsp;
            </td>
            <td height="25" width="5%" align="center" background="<%=path %>/imagine/bg-bt.gif">
                <span class="bg-zw" onclick="javascript:back();" onmouseover="this.style.cursor='hand'"> 返回 </span>
            </td>
         </tr>
	</table>
 </BODY>
</HTML>
<script language="javascript">
function docSendList(type)
{
	window.location.href="<%=path%>/docSendRelatedAction.do?method=docSendList&type="+type;
}
function docSendBook()
{
	window.location.href="<%=path%>/docSendBook.do?method=input";
}
function back()
{
	window.location.href="<%=path%>/docSendRelatedAction.do?method=docSendList&type=newAndDoing";
}
</script>