<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@include file="commons.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>上海市水务局统一用户权限及单点登录系统</TITLE>
		<META NAME="Generator" CONTENT="EditPlus">
		<META NAME="Author" CONTENT="">
		<META NAME="Keywords" CONTENT="">
		<META NAME="Description" CONTENT="">
	</HEAD>
    <LINK REL="STYLESHEET" HREF="<%=request.getContextPath()%>/css/style_01.css" TYPE="text/css">
	<BODY>
	 
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bgimage1">
  <tr>
    <td align="left" valign="top">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0" background="<%=path %>/imagine/maintop_bg.jpg">
	      <tr>
	        <td align="left" valign="top" width="100%" height="69"></td>
	        <td>&nbsp;</td>
	      </tr>
	      <tr>
	        <td height="26" colspan="2" align="left">
		        <table width="100%" border="0" cellspacing="0" cellpadding="0" background="<%=path %>/imagine/maintop_bg.jpg"">
		          <tr>
		            <td  align="right"><img src="<%=path %>/imagine/loginout.gif">&nbsp;<a href="<%=path %>/loginoutAction.do" target="_parent">退出</a>&nbsp;</td>
		          </tr>
		        </table>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
	</BODY>
</HTML>