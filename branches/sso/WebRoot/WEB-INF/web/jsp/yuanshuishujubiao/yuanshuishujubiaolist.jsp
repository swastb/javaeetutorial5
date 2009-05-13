<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List yuanshuishujubiao=(List)request.getAttribute("yuanshuishujubiao");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>长江原水</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/index-css.css" rel="stylesheet" type="text/css">
  </head>

  <body style='overflow:scroll;overflow-x:hidden' leftmargin="0" topmargin="0">


         
              <table width="316" border="1" cellpadding="0" cellspacing="0" bordercolor="d8ecf2" class="tableborder">
                    
    				<tr align="center"  class="xb">
    					
    					<td width="20%" align="center" background="<%=path %>/imagine/sy-bg1.gif">站名</td>
    					<td width="20%" align="center" background="<%=path %>/imagine/sy-bg1.gif">时间</td>
    					<td width="20%" align="center" background="<%=path %>/imagine/sy-bg1.gif">盐度(mg/L)</td>
    				</tr>
		<%
			if(yuanshuishujubiao!=null)
			{
				for(int i=0;i<yuanshuishujubiao.size();i++)
				{
					Object[] item=(Object[])yuanshuishujubiao.get(i);
					%>
						<tr align="center" class="zw">
    			            
			    			<td width="20%" align="center" ><%=item[1]==null?"":item[1] %></td>
			    			<td width="20%" align="center" ><%=item[2]==null?"":item[2] %></td>
			    			<td width="20%" align="center" ><%=item[3]==null?"":item[3] %></td>
			    		</tr>
					<%
				}
			}
		%>
 </table>
              
  
</body>
</html>
