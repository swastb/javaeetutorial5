<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name = (String)request.getAttribute("name");
List resultList=(List)request.getAttribute("resultList");

%>

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
    <link href="<%=path %>/css/index-css.css" rel="stylesheet" type="text/css">
	</head>

	<body topmargin="0" bgcolor="eefaff">
		<table width="305"  height="1" align="center" border="0" cellpadding="0" cellspacing="0">
			
<%
			if (resultList != null && !resultList.isEmpty())
			{
				for(int i=0;i<resultList.size();i++)
				{
    				TbInfoPubContent item = (TbInfoPubContent)resultList.get(i);
    				String title ="";
    				String title2="";
    				title=item.getTitle();
    			
    				
    				if(title.trim().length() > 16)
    				{
    					title=title.substring(0,16)+"...";
    				}
%>
			<tr> 
				<td width="10" height="18" class="zw"><img src="<%=path %>/imagine/ddddd2.gif" width="4" height="4"></td>
				<td height="22" class="zw"><a href="<%=path %>/infopubContentaction.do?method=view&id=<%=item.getId() %>" target="_blank"><%=title %></a></td>
				<td width="72" height="18" align="right" class="zw-time">[<%=item.getPublishTime()==null?"":item.getPublishTime().toString().substring(5,10) %>]</td>
			</tr>
			<tr> 
				<td height="1" colspan="3" background="<%=path %>/imagine/ddddd3.gif"> 
  				</td>
			</tr>
<%
				}
			}
%>
  <table  width="305" height="5" vaign="top" align="center" border="0" cellpadding="0" cellspacing="0"> 
                                          <td width="225" ></td>
                                              <td height="20" vaign="top" align="center">&nbsp;&nbsp;&nbsp;<a href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=ÍøÕ¾¶¯Ì¬&code=wzdt" target="_blank"><img src="<%=path %>/imagine/more.gif" width="41" height="11" border="0">&nbsp;</a></td>                                         </table>
                     
		</table>
	</body>
</html>

