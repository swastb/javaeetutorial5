<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
List list = (List)request.getAttribute("sclzdList");
%>
<br>
    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
       <tr>
        	<td width="20%" height="24" align="center">文件标题</td>
        	<td width="80%" colspan="5" align="center"><%=list!=null&&!list.isEmpty()?((Object[])list.get(0))[0]:"&nbsp;" %></td>
       </tr>
       <tr>
    		<th width="16%" rowspan="<%=list!=null&&list.size()>0?list.size()+1:1 %>" align="center">步骤</td>
    		<th width="16%" height="24" align="center">步骤名</td>
    		<th width="16%" align="center">流入时间</td>
    		<th width="16%" align="center">签收时间</td>
    	　　 <th width="16%" align="center">流出时间</td>
    	   	<th width="20%" align="center">处理人</td>
    	</tr>
    	<%for (int i = 0; list!=null&&list.size()>0&&i < list.size(); i++) {
    		Object[] item = (Object[])list.get(i);
    	%>
    	<tr align="center" class="bg-zw">
		    <td width="16%" height="24" align="center"><%=item[1]==null?"":item[1] %></td>
    		<td width="16%" align="center"><%=item[2]==null?"":item[2] %></td>
    		<td width="16%" align="center"><%=item[3]==null?"":item[3] %></td>
    		<td width="16%" align="center"><%=item[4]==null?"":item[4] %></td>
    		<td align="center" ><%=item[5]==null?"":item[5] %></td>
		 </tr><%}%>

 	 </table> 
