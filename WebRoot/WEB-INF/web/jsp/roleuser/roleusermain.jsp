<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'orgmain.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
	
<link href="<%=path %>/images/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css" />
</head>
<body>
		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="<%=path %>/images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="4%" align="center" valign="middle">&nbsp;</td>
              <td width="9%" height="12" align="center" valign="middle"><img src="<%=path %>/images/icon5.gif" width="7" height="7"></td>
              <td width="87%" class="table2_topic">角色用户管理</td>
            </tr>
          </table></td>
          <td background="<%=path %>/images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin">
                   <tr>
              <th height="30" valign="bottom"></th>
           </tr>
           <tr>
         <td width="49%" align="center" valign="top">
         <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="16%" class="tabin_atabno"><a href="<%=path %>/roleaction.do?method=list">角色管理</a></td>
                      <td width="16%" class="tabin_atabno"><a href="base/roleAuth/navigation.do"><span class="bg-zw">角色权限管理</span></td>
                      <td width="16%" class="tabin_atab"><span class="bg-zw">角色用户管理</span></td>
                   <td width="1%">&nbsp;</td>
                   </table>
                <tr>
                  <td width="41%" align="center" valign="top">
                  <table width="99%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin_a">
                    
						    <tr>
						    <td height="300" align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="1"></td>
                        </tr>
                        <tr>
                          <td align="left" valign="top">
                         <iframe width="100%" height="400" frameborder="0" scrolling="auto"
							name="left" 
							src="<%=path %>/roletreeaction.do?method=listForUser">
						</iframe>
						</td>
                        </tr>
                      </table></td>
                    </tr>
                  </table>
	
 <td width="59%" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin_c">
                    
                    <tr>
                      <td height="300" align="center" valign="top">
					
					  <table width="99%" border="0" cellspacing="0" cellpadding="0">
                        
                        <tr>
                          <td align="left" valign="top">
                         <form id="list" name="list" method="post">
							<iframe width="100%" height="400" frameborder="0"
								scrolling="auto" name="detail" src="" >
							</iframe>
						</form>
						</td>
                        </tr>
                  </table></td></tr></table></td></tr></table></td></tr></table></td></tr></table>
</body>
</html>
