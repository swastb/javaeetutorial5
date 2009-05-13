<%@ page language="java" import="java.util.*" 
 import="org.hibernate.lob.SerializableClob" import="java.sql.Clob"
 import="oracle.sql.CLOB"  import="java.io.BufferedReader" import="java.io.Reader" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbFilesend"/>
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
    
    <title>文件传送</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
  </head>
  <%
  	List fileSendOutList = (List)request.getAttribute("curPageList");
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
              <td width="84%" class="table2_topic">发送文件列表</td>
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
                  <td align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="2%" height="24">&nbsp;</td>
                      <td width="16%" class="tabin_atabno"><a href="<%=path %>/fileSendInListAction.do?method=list"><span class="bg-zw">接收的文件</span></a></td>
                      <td width="16%" class="tabin_atab">已发送的文件</td>
                      <td width="66%"></td>
                    </tr>
                  </table>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                					<tr align="center" height="25">
										<th width="5%" align="center">
											序号
										</th>
										<th width="35%" align="center">
											主题
										</th>
										<th width="35%" align="center">
											发送人
										</th>
										<th width="25%" align="center">
											发送时间
										</th>
									</tr>
									<%
										if(fileSendOutList!=null)
											{
												for(int i=0;i<fileSendOutList.size();i++)
												{
					
													TbFilesend item = (TbFilesend)fileSendOutList.get(i);
									%>
									<tr align="center" height="25">
										<td width="5%" align="center">
											<%=i + 1%>
										</td>
										<td width="35%" align="center">
											<a href="<%=path%>/filesendEdit.do?method=view&id=<%=item.getId()%>"><%=item.getSubject()==null?"":item.getSubject() %></a>
										</td>
										<td width="35%" align="center">
											<%=item.getContent()%>
										</td>
										<td width="25%" align="center">
											<%=item.getSendDt()==null?"":item.getSendDt().toString().substring(0,19) %>
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
								<a
									href="<%=path%>/fileSendOutListAction.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>"><span
									class="bg-zw">上一页</span> </a>
								<a
									href="<%=path%>/fileSendOutListAction.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>"><span
									class="bg-zw">下一页</span> </a>
								<span class="bg-zw">第<%=curPage + 1%>页</span>
								<span class="bg-zw">每页显示</span>
								<a
									href="<%=path%>/fileSendOutListAction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>"><span
									class="bg-zw">10</span> </a>
								<a
									href="<%=path%>/fileSendOutListAction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>"><span
									class="bg-zw">20</span> </a>
								<a
									href="<%=path%>/fileSendOutListAction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>"><span
									class="bg-zw">30</span> </a>
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

