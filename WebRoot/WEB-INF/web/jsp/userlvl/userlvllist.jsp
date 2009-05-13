<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbUserlvl"/>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List alluserlvl = (List)request.getAttribute("alluserlvl");
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
		<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style> 
  </head>
  
  <body>
<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5%" align="center" valign="middle">
								&nbsp;
							</td>
							<td width="11%" height="12" align="center" valign="middle">
								<img src="images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								代码管理
							</td>
						</tr>
					</table>
				</td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
       <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
			<tr>
          <td>
		 <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
			<tr>
          <td><table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0"> 
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="14%" class="tabin_atabno"><a href="deptlvlaction.do?method=list"><span class="bg-zw">部门级别</span></a></td>
                      <td width="14%" class="tabin_atabno"><a href="pstlvlaction.do?method=list"><span class="bg-zw">职务等级</span></a></td>
                      <td width="14%" class="tabin_atab">用户级别</td>
                      <td width="14%" class="tabin_atabno"><a href="authlvlaction.do?method=list"><span class="bg-zw">权限级别</span></a></td>
                       <td width="37%">&nbsp;</td>
                     </table> 
                   <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                   <tr>
                   <td height="25" colspan="7" valign="bottom" bgcolor="#f7f7f7" align="right">&nbsp;
			      <input name="Submit2" type="submit" class="button0" value="&nbsp;增 加&nbsp;" onclick="add();"
	    		 		 onmouseover="this.style.cursor='hand'"/>

					</td>
                   	</tr>
    	<tr align="center" class="bg-zwbt">
    		<th width="5%" height="25" align="center" style="word-break: break-all; word-wrap:break-word;">序号</th>
    		<th width="25%" align="center" style="word-break: break-all; word-wrap:break-word;">用户级别缩写名称</th>
    		<th width="25%" align="center" style="word-break: break-all; word-wrap:break-word;">用户级别代码</th>
    		<th width="35%" align="center" style="word-break: break-all; word-wrap:break-word;">用户级别中文说明</th>
    		<th width="10%" align="center"  colspan="4">操作</th>
    	</tr>
    	<%for (int i = 0; i < alluserlvl.size(); i++) {
    		TbUserlvl item = (TbUserlvl)alluserlvl.get(i);
    		%>
    		<tr align="center" class="bg-zw">
    			<td width="5%"  height="25" align="center" style="word-break: break-all; word-wrap:break-word;"><%=i+1 %></td>
    			<td width="25%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getEname() %></td>
    			<td width="25%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getCode() + "" %></td>
    			<td width="35%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getName() + "" %></td>
    			<td width="5%" align="center"><a title="修改" href="<%=path %>/userlvlaction.do?method=modify&id=<%=item.getId() %>"><img src="<%=path %>/images/icon9.gif" width="15" height="15" border="0"></a></td>
    			<td width="5%" align="center"><a title="删除" href="<%=path %>/userlvlaction.do?method=delete&id=<%=item.getId() %>" onclick="return confirm('是否确认删除')"><img src="<%=path %>/images/icon6.gif" width="15" height="15" border="0"></a></td>
    		</tr>
    		<%
    	} %>
  </table>
         <table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>


</table>
</td></tr>
<%--<tr>
<td height="10"></td>
</tr>
--%></table>
</td></tr>
</table>
  <tr>
    <td height="10"></td>
  </tr>
</table>
</td></tr></table></html:form>
</body>
</html>
<script type="text/javascript">

						
			function add()
			{
			
            window.location.replace("<%=path %>/userlvlaction.do?method=add&action=add");
			}

	
</script>