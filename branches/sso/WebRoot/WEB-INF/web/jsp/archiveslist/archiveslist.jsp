<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbArchives" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String sessionID = "";
	int curPage = 0;
	long count=0;
	try {
		sessionID = (String) request.getAttribute("sessionID");
		curPage = (Integer) session.getAttribute(sessionID + "No");
		count=(Long)session.getAttribute(sessionID+"Count");

	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
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

		<title>档案管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
	</head>
	<%
	List archivesList = (List) request.getAttribute("curPageList");
	String shenHeRole = (String)request.getAttribute("shenHeRole");
	if(shenHeRole==null)
		shenHeRole=request.getParameter("shenHeRole");
	%>
	<body>

		<table width="100%" align="center" cellpadding="0" cellspacing="0" style="margin:0px">
			<tr>
			<td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">档案列表</td>
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
                      <td width="16%" class="tabin_atab">档案列表</td>
                      <td width="16%" class="tabin_atabno"><a href="<%=path%>/pigeonholedArchivesListAction.do?method=pigeonholedArchivesList"><span class="bg-zw">已归档档案列表</span></a></td>
                      <td width="16%" <%if(shenHeRole.equals("1")) {%>class="tabin_atabno"<%} %>><%if(shenHeRole.equals("1")) {%>
								<a href="<%=path%>/auditListAction.do?method=auditList"><span class="bg-zw">档案审批列表</span></a><%} %></td>
                      <td width="50%" align="right">
                      		<input name="Submit2" type="button" class="button0" value="增 加" onclick="location.href='<%=path%>/archivesEdit.do?method=add&action=add';"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>&nbsp;&nbsp;</td>
                    </tr>
                  </table>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                					<tr align="center" height="25">
										<th width="5%" align="center">
											序号
										</th>
										<th width="35%" align="center">
											标题
										</th>
										<th width="25%" align="center">
											文号
										</th>
										<th width="19%" align="center">
											成文时间
										</th>
										<th width="16%" align="center" colspan="2">
											操作
										</th>
									</tr>
									<%
											if (archivesList != null) {
											for (int i = 0; i < archivesList.size(); i++) {
												TbArchives item = (TbArchives) archivesList.get(i);
									%>
									<tr align="center" height="25">
										<td width="5%" align="center">
											<%=i + 1%>
										</td>
										<td width="35%" align="center">
											<%=item.getTitle() == null ? "" : item
							.getTitle()%>
										</td>
										<td width="25%" align="center">
											<%=item.getFileId() == null ? "" : item
							.getFileId()%>
										</td>
										<td width="19%" align="center">
											<%=item.getCreateTime() == null ? "" : item
							.getCreateTime().toString().substring(0, 11)%>
										</td>
										<td width="8%" align="center">
											<a
												href="<%=path%>/archivesEdit.do?method=modify&id=<%=item.getId()%>"><img
													src="<%=path%>/imagine/xg.gif" width="15" height="15"
													border="0" alt="修改"> </a>
										</td>
										<td width="8%" align="center">
											<a
												href="<%=path%>/archivesListAction.do?method=delete&id=<%=item.getId()%>"
												onclick="return confirm('是否确认删除')"><img
													src="<%=path%>/imagine/sc.gif" width="15" height="15"
													border="0" alt="删除"> </a>
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
									href="<%=path%>/archivesListAction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&shenHeRole=<%=shenHeRole %>"><span
									class="bg-zw">上一页</span> </a>
								<a
									href="<%=path%>/archivesListAction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&shenHeRole=<%=shenHeRole %>"><span
									class="bg-zw">下一页</span> </a>
								<span class="bg-zw">第<%=curPage + 1%>页</span>
								<span class="bg-zw">每页显示</span>
								<a
									href="<%=path%>/archivesListAction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&shenHeRole=<%=shenHeRole %>"><span
									class="bg-zw">10</span> </a>
								<a
									href="<%=path%>/archivesListAction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&shenHeRole=<%=shenHeRole %>"><span
									class="bg-zw">20</span> </a>
								<a
									href="<%=path%>/archivesListAction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&shenHeRole=<%=shenHeRole %>"><span
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

