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
            	window.location.replace("<%=path%>/consultationSLOverListAction.do?method=list&subject="+subject);
			}	    	    
</script>
<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上咨询</title>
    
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
  	List consultationsloverList = (List)request.getAttribute("curPageList");
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
              <td width="84%" class="table2_topic">网上咨询-已答复列表</td>
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
          <td height="5" colspan="2" class="bg-zw" valign="bottom">&nbsp;&nbsp;&nbsp;咨询主题：
					<input style="vertical-align:middle" class="tab_input2" type="text" name="subject" value="<%=subject %>"/>                
            &nbsp;&nbsp;&nbsp;<input type="button" class="button0" value="查 询" onclick="selectBySubject();"/></td>
        </tr>
                <tr>
                  <th height="15" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                      <td width="2%" height="24">&nbsp;</td>
                      <td width="16%" class="tabin_atabno"><a href="<%=path%>/consultationSLWaitListAction.do?method=list"><span class="bg-zw">待答复列表</span></a></td>                        
                      <td width="16%" class="tabin_atabno"><a href="<%=path%>/consultationSLProcessListAction.do?method=list"><span class="bg-zw">办理中列表</span></a></td>
                      <td width="16%" class="tabin_atab">已答复列表</td>
                      <td width="66%"></td>
                    
                   </tr>
                  </table>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                					<tr align="center" height="25">
										<th width="5%" align="center">
											序号
										</th>
										<th width="35%" align="center">
											咨询人
										</th>
										<th width="25%" align="center">
											咨询主题
										</th>
										<th width="19%" align="center">
											咨询时间
										</th>
										<th width="16%" align="center" colspan="2">
											操作
										</th>
									</tr>
									<%
										if(consultationsloverList!=null)
										{
											for(int i=0;i<consultationsloverList.size();i++)
											{
												Object[] item = (Object[])consultationsloverList.get(i);
									%>
									<tr align="center" height="25">
										<td width="5%" align="center">
											<%=i + 1%>
										</td>
										<td width="35%" align="center">
											<%=item[1]==null?"":item[1] %>
										</td>
										<td width="25%" align="center">
											<%=item[2]==null?"":item[2] %>
										</td>
										<td width="19%" align="center">
											<%=item[3]==null?"":item[3] %>
										</td>
										<td width="16%" align="center">
											<button class="button0" onclick="window.location.replace('<%=path%>/consultaionView.do?method=viewCenter&hui=3&id=<%=item[0] %>&view=1');">查看</button>
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
							<a href="<%=path%>/consultationSLOverListAction.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">上一页</span></a>
							<a href="<%=path%>/consultationSLOverListAction.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">下一页</span></a>
							<span class="bg-zw">第<%=curPage+1%>页</span>
							<span class="bg-zw">每页显示</span>
							<a href="<%=path%>/consultationSLOverListAction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">10</span></a>
							<a href="<%=path%>/consultationSLOverListAction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">20</span></a>
							<a href="<%=path%>/consultationSLOverListAction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>&subject=<%=subject %>"><span class="bg-zw">30</span></a>
							<span class="bg-zw">条</span>
							<span class="bg-zw">第<%=count %>条</span>                       
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

