<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbArchives"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

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

%>
<script type="text/javascript">							
		function selectBySubject()
			{
            	var subject=document.getElementById("subject").value;
            	window.location.replace("<%=path%>/opinionSLWaitListAction.do?method=list&subject="+subject);
			}	    	    
</script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>局长信箱</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
	
  </head>
  <%
  	String subject = request.getParameter("subject");
  			if(subject==null){
			subject = "";
		}
  	List opinionslwaitList = (List)request.getAttribute("curPageList");
  %>
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
              <td width="84%" class="table2_topic">局长信箱-待答复列表</td>
            </tr>
          </table></td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
        <tr>  
          <td height="5" colspan="2">&nbsp;&nbsp;&nbsp;<span class="bg-zw">意见主题：</span>
					<input type="text" name="subject" value="<%=subject %>"/>                
            &nbsp;&nbsp;&nbsp;<button onclick="selectBySubject()"><span class="bg-zw">查 询</span></button></td>
        </tr>
       <tr>
                  <th height="15" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                   <td width="2%" height="24">&nbsp;</td>
                      <td width="16%" class="tabin_atab">待答复列表</td>
                      <td width="16%" class="tabin_atabno"><a href="<%=path%>/opinionSLProcessListAction.do?method=list"><span class="bg-zw">办理中列表</span></a></td>  
                      <td width="16%" class="tabin_atabno"><a href="<%=path%>/opinionSLOverListAction.do?method=list"><span class="bg-zw">已答复列表</span></a></td>
                      <td width="50%"></td>
                      
                   </tr>
                  </table>
                  <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                					<tr align="center" height="25">
    		<th width="5%" align="center">序号</th>
    		<th width="35%" align="center">意见人</th>
    		<th width="25%" align="center">意见主题</th>
    		<th width="20%" align="center">意见时间</th>
    		<th width="15%" align="center">操作</th>
    	</tr>
		<%
			if(opinionslwaitList!=null)
			{
				for(int i=0;i<opinionslwaitList.size();i++)
				{
					Object[] item = (Object[])opinionslwaitList.get(i);
					%>
						<tr height="20" align="center" class="bg-zw">
							<td width="5%" align="center"><%=i+1 %></td>
							<td width="35%" align="center"><%=item[1]==null?"":item[1] %></td>
							<td width="25%" align="center"><%=item[2]==null?"":item[2] %></td>
			    			<td width="20%" align="center"><%=item[3]==null?"":item[3] %></td>
			    			<td width="15%">
			    			<button onclick="window.location.replace('<%=path%>/opinionView.do?method=viewCenter&hui=1&id=<%=item[0] %>');">答复</button>
			    			<button onclick="if(confirm('是否确认删除')){window.location.replace('<%=path%>/opinionSLWaitListAction.do?method=delete&id=<%=item[0] %>&subject=<%=subject %>');}">删除</button>
<!--  <a href="<%=path %>/opinionSLWaitListAction.do?method=delete&id=<%=item[0] %>&subject=<%=subject %>" onclick="return confirm('是否确认删除')"><img src="<%=path%>/images/sc.gif" width="15" height="15" border="0" alt="删除"></a> -->
			    			</td>
			    		</tr>
					<%
				}
			}
		%>
 </table>
               <table width="99%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="10"></td>
                      </tr>
					<tr>
						<td class="tabin_page">
							<a href="<%=path%>/opinionSLWaitListAction.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">上一页</span></a>
							<a href="<%=path%>/opinionSLWaitListAction.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">下一页</span></a>
							<span class="bg-zw">第<%=curPage+1%>页</span>
							<span class="bg-zw">每页显示</span>
							<a href="<%=path%>/opinionSLWaitListAction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">10</span></a>
							<a href="<%=path%>/opinionSLWaitListAction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">20</span></a>
							<a href="<%=path%>/opinionSLWaitListAction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">30</span></a>
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
          </table></td>
        </tr>
      </table>			
			</td>
			</tr>
	</table>
</body>
</html>

