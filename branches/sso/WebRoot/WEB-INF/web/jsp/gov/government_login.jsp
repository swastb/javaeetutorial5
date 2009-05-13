<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<jsp:directive.page import="com.baosight.mode.TbAppsys"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>上海水务</title>
</head>
<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
<body style='overflow:scroll;overflow-x:hidden' leftmargin="0" topmargin="0">
<table  width="285" height="30%" align="center" border="0" cellpadding="0" cellspacing="0">
                                       
                                            
                                                 <c:forEach var="content" items="${list}" varStatus="loop">
                                                 
                                                  <tr class="zw">
                                                  <td align="center"width="10" >&nbsp;</td>
                                                    <td class="zw" align="left"><img src="<%=path%>/imagine/ddddd2.gif" width="4" height="4">&nbsp;</td>
                                                    <td  width="235" height="22" align="left"  class="zw"><a href="http://www.shanghaiwater.gov.cn/web/sqgkxx_dlemail.jsp?fileId=10033618" target="_blank">${content[0]}...</a></td>
                                                    <td  width="50"  align="left" class="zw-time">[${content[1]}]</td>
                                                    
                                                  </tr>
                                                  <tr ><td  align="center" height="1" colspan="4" background="<%=path%>/imagine/ddddd3.gif"></tr>
                                                  </c:forEach>
                                            
                                        
                                          <table  width="285" height="5" vaign="top" align="center" border="0" cellpadding="0" cellspacing="0"> 
                                          <td width="200" ></td>
                                              <td height="20" vaign="top" align="center"><a href="http://www.shanghaiwater.gov.cn/web/gkml.jsp" target="_blank"><img src="<%=path%>/imagine/more.gif" width="41" height="11" border="0"></a></td>
                                            </table>
                                            
                                            </table>
 
</body>
</html>