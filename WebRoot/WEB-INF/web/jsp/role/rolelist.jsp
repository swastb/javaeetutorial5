<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbRole"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String sessionID = "";
int curPage = 0;
long count=0;
try{
  sessionID = (String)request.getAttribute("sessionID");
  curPage = (Integer)session.getAttribute(sessionID+"No");
  count=(Long)session.getAttribute(sessionID+"Count");
  
}catch(Exception ex){
  ex.printStackTrace();
}

List allrole = (List)request.getAttribute("curPageList");
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
	 <script type="text/javascript">
		
		function selectByName()
			{

				var name=document.getElementById("name").value;
            	var code=document.getElementById("code").value;
            	window.location.replace("<%=path%>/roleaction.do?method=list&action=selectByName&name="+name+"&code="+code);
			}
			
			function add()
			{
	
            	window.location.replace("<%=path %>/roleaction.do?method=add&action=add");
			}
			
	</script>
	 
  </head>
  
<body>
<table width="100%" align="center" cellpadding="0" cellspacing="0">
	 <tr>
	 	<td>
	 		<table width="100%" border="0" cellspacing="0" cellpadding="0">
          		<tr>
            	<td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="5%" align="center" valign="middle">&nbsp;</td>
                  <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
                  <td width="84%" class="table2_topic">角色管理</td>
                </tr>
            	</table></td>
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
         <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="16%" class="tabin_atab">角色管理</td>
                      <td width="16%" class="tabin_atabno"><a href="base/roleAuth/navigation.do"><span class="bg-zw">角色权限管理</span></a></td>
                      <td width="16%" class="tabin_atabno"><a href="roleusermainaction.do"><span class="bg-zw">角色用户管理</span></a></td>
                   <td width="90%">&nbsp;</td>
                   </table>
         <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
         <tr>
        	<td height="25" width="100%" colspan="4" bgcolor="#e8f0f1" align="left">角色名称:
				<input type="text" name="name" value="${name}"  class="tab_input"/>角色代码:
			 <input type="text" name="code" value="${code}"  class="tab_input"/>
			 <input name="Submit2" type="submit" class="button0" value="&nbsp;查 询&nbsp;" onclick="selectByName();"
	    		 		 onmouseover="this.style.cursor='hand'"/>
			
         </td>
     
      	<td height="25" colspan="2" valign="middle" bgcolor="#e8f0f1" align="right">&nbsp;
      	 <input name="Submit2" type="submit" class="button0" value="&nbsp;增 加&nbsp;" onclick="add();"
	    		 		 onmouseover="this.style.cursor='hand'"/>
	     		  	</td>
      </tr>
    							<tr align="center">
    								<th width="5%" height="25" align="center" style="word-break: break-all; word-wrap:break-word;">序号</th>
    								<th width="30%" align="center" style="word-break: break-all; word-wrap:break-word;">角色名称</th>
    								<th width="20%" align="center" style="word-break: break-all; word-wrap:break-word;">角色代码</th>
    								<th width="35%" align="center" style="word-break: break-all; word-wrap:break-word;">角色描述</th>
    								<th width="10%" align="center"  colspan="2">操作</th>
    							</tr>
							<%
								for (int i = 0; i < allrole.size(); i++)
								{
									TbRole item = (TbRole)allrole.get(i);
							%>
    							<tr align="center">
    								<td width="5%"  height="25" align="center" style="word-break: break-all; word-wrap:break-word;"><%=i+1 %></td>
    								<td width="30%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getName() %></td>
    								<td width="20%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getCode()==null?"":item.getCode()%></td>
    								<td width="35%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getRem()==null?"":item.getRem() %></td>
    								<td width="5%" align="center"><a title="修改" href="<%=path %>/roleaction.do?method=modify&id=<%=item.getId() %>"><img src="<%=path %>/images/icon9.gif" width="15" height="15" border="0"></a></td>
    								<td width="5%" align="center">
								<%
									if (item.getInsure()==1)
									{
									}
									else
									{
								%>
    									<a title="删除" href="<%=path %>/roleaction.do?method=delete&id=<%=item.getId() %>" onclick="return confirm('是否确认删除')"><img src="<%=path %>/images/icon6.gif" width="15" height="15" border="0"></a>
								<%
									}
								%>
    								</td>
    							</tr>
							<%
								}
							%>
    						</table>
				<table width="99%" border="0" cellspacing="0" cellpadding="0" align="right">
		  		<tr><td height="10"></td></tr>
				<tr>
				<td class="tabin_page">
							<a href="<%=path%>/roleaction.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>"><span class="bg-zw">上一页</span></a>
							<a href="<%=path%>/roleaction.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>"><span class="bg-zw">下一页</span></a>
							<span class="bg-zw">第<%=curPage+1%>页</span>
							<span class="bg-zw">每页显示</span>
							<a href="<%=path%>/roleaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>"><span class="bg-zw">10</span></a>
							<a href="<%=path%>/roleaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>"><span class="bg-zw">20</span></a>
							<a href="<%=path%>/roleaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>"><span class="bg-zw">30</span></a>
							<span class="bg-zw">条</span>
							<span class="bg-zw">共<%=count %>条</span>
						</td>
             		 </tr>
    	 	</table>
    	 </td>
        </tr>
                <tr>
                  <td height="20"></td>
                </tr>
       </table></td>
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
</body>
</html>