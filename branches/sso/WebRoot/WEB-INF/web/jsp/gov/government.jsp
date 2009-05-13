<%@ page language="java" import="java.util.*,java.sql.SQLException,java.io.IOException"
	import="org.hibernate.lob.SerializableClob" import="java.sql.Clob"
	import="oracle.sql.CLOB" import="java.io.BufferedReader"
	import="java.io.Reader" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbGovInfoPubContent"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List gov=(List)request.getAttribute("list");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>上海水务</title>
</head>
<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
<body style='overflow:scroll;overflow-x:hidden' leftmargin="0" topmargin="0" bgcolor="e6e2f5">
<table  width="305" height="30%" align="center" border="0" cellpadding="0" cellspacing="0" >
                                       
  <%
			if(gov!=null)
			{
				for(int i=0;i<gov.size();i++)
				{
					TbGovInfoPubContent item=(TbGovInfoPubContent)gov.get(i);
					 %>
					
					                            <tr>
                                                  
                                                    <td width="10" height="18"><img src="<%=path%>/imagine/ddddd2.gif" width="4" height="4"></td>
                                                    <td height="22" class="zw"><a href="<%=path%>/govern.do?method=view&id=<%=item.getFileId()%>" target="_blank"><%=item.getTitle() == null ? "" : (item.getTitle().length() > 15 ? item.getTitle().substring(0, 15)+"...": item.getTitle())%></a></td>
                                                    
                                                    <td width="72" height="18" align="right" class="zw-time">[<%=item==null ? "":item.getCreateTime().toString().substring(5,10)%>]</td>
                                                    
                                                  </tr>
                                                  <tr><td  align="center" height="1" colspan="3" background="<%=path%>/imagine/ddddd3.gif"></td></tr>
                                                  <%}} %>
                                             
                                        
                                          <table  width="305" height="5" vaign="top" align="center" border="0" cellpadding="0" cellspacing="0"> 
                                          <td width="225" ></td>
                                              <td height="20" vaign="top" align="center">&nbsp;&nbsp;<a href="<%=path%>/govern.do?method=zfxxgk_more&name=政府信息公开" target="_blank"><img src="<%=path%>/imagine/more.gif" width="41" height="11" border="0"></a></td>
                                            </table>
                                            
                                            </table>
 
</body>
</html>