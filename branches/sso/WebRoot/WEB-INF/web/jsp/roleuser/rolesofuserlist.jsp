<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pstlvllist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
	<link href="images/style.css" rel="stylesheet" type="text/css" />
  </head>

<body>
<form action="<%=path %>/base/function/forwardFunction.do?method=saveResSet" method="post">
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
        <tr>
	 		<td>
	 			<table width="100%" border="0" cellspacing="0" cellpadding="0">
          			<tr>
            			<td width="288" height="40" align="left" valign="middle" background="images/8-1.gif">
            				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                				<tr>
                  					<td width="5%" align="center" valign="middle">&nbsp;</td>
                  					<td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
                  					<td width="84%" class="table2_topic">用户所属角色列表</td>
                				</tr>
            				</table>
            		    </td>
            			<td background="images/8-2.gif">&nbsp;</td>
          		   </tr>
        	  </table>
        	   <table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#0e88b9">
							<tr>
								<td>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">			
  		       	  <tr>
                      <td align="center" valign="top">
		                  <table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
			           		  <tr>
			                      <th height="30" valign="bottom"></th>
			                  </tr>
			                  <tr>
			                      <td align="center" valign="top">
			         				<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
										<tr align="center">
											<th align="center" height="25" width="50%">角色名称</th>
						    				<th align="center" width="50%">角色代码</th>
						   				</tr>
						    			<c:forEach var="content" items="${userroleList}" varStatus="loop">
						    			<tr align="center">
						    				<td align="center" height="25" width="50%">${content.name}</td>
						    				<td align="center" width="50%">${content.code}</td>
						    			</tr>
						   				</c:forEach>
					   			   </table>
			        			</td>
			        		</tr>
			                <tr>
			                  <td height="20"></td>
			                </tr>
		              	</table>
		             </td>
            	</tr>
            	<tr>
              		<td height="10"></td>
           		</tr>
          	</table>
          </td>
      </tr>
    </table>
    </td>
    </tr>
    </table>
</form>
</body>
</html>
