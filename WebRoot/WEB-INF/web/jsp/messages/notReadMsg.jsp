<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String currentPath = request.getServletPath();
//String insureOn=(String)request.getAttribute("insureOn");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'notReadMsg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <link href="images/style.css" rel="stylesheet" type="text/css" />
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
  </head>
  <%
		String sessionID = "";
		int curPage = 0;
		try {
			sessionID = (String) request.getAttribute("sessionID");
			curPage = (Integer) session.getAttribute(sessionID + "No");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		List commonalityCommList = (List) request
				.getAttribute("curPageList");
	%>
  <body>
    <html:form action="/notReadMsgMessages.do">
    <%--<marquee onMouseOver="this.stop()" style="width: 200px; height: 100px" onMouseOut="this.start()" align=center direction=up scrollamount=1 scrolldelay=3 valign=middle behavior="scroll"> 
	--%>
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
								未读短信
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
                  <td align="center" valign="top">
							<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
							<tr>
								<th width="5%" height="24" align="center" class="bg-zwbt">
									序号
								</th>
								<th height="24" width="20%" align="center" class="bg-zwbt">
									主题
								</th>
								<th height="24" width="17%" align="center" class="bg-zwbt">
									发件人
								</th>
								<th height="24" width="17%" align="center" class="bg-zwbt">
									发件时间
								</th>
								<th height="24" width="10%" align="center" class="bg-zwbt">
									状态
								</th>
								<th align="center" colspan="3" class="bg-zwbt">
									操作
								</th>
							</tr>
							<c:forEach items="${curPageList}" var="list" varStatus="loop">

								<tr>

									<td width="5%" align="center" height="24" class="bg-zwbt">
										${loop.index+1}
									</td>

									<td height="24" width="20%" align="center" class="bg-zwbt">
										${list.title }
									</td>
									<td height="24" width="17%" align="center" class="bg-zwbt">
										${list.senderName }
									</td>
									<td height="24" width="18%" align="center" class="bg-zwbt">
										<fmt:formatDate value="${list.sendTime }"
											pattern="yyyy-MM-dd HH:mm" />
									</td>
									<c:if test="${list.status==2 }">
										<td height="24" width="10%" align="center" class="bg-zwbt">
											<font color="red">未查看</font>
										</td>
									</c:if>
									<c:if test="${list.status==3 }">
										<td height="24" width="10%" align="center" class="bg-zwbt">
											<font color="#888888">已查看</font>
										</td>
									</c:if>
									<td width="10%" align="center" class="bg-zwbt">
										<a href="<%=path%>/notReadMsgMessages.do?method=lookupMessages&id=${list.id }&source=notRead"><span
											class="bg-zw"><img src="/sso/imagine/xg.gif" width="15" height="15" border="0" alt="查看">
										</span>
										</a>
									</td>
									<td width="10%" align="center" class="bg-zwbt">
										<a href="<%=path%>/notReadMsgMessages.do?method=delete&id=${list.id }"
											onclick="return confirm('是否确认删除')"><span class="bg-zw"><img
													src="/sso/imagine/sc.gif" width="15" height="15" border="0" alt="删除">
										</span>
										</a>
									</td>
									<td width="10%" align="center" class="bg-zwbt">
										<a
											href="<%=path%>/notReadMsgMessages.do?method=sendMessages&action=revert&id=${list.id }&source=notRead"><span
											class="bg-zw"><img src="/sso/imagine/xg.gif" width="15" height="15" border="0" alt="回复">
										</span>
										</a>
									</td>
								</tr>

							</c:forEach>
						</table>
				<table width="99%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td height="10"></td>
			  </tr>
			  <tr>
				<td class="tabin_page" align="right">
						<a
							href="<%=path%>/notReadMsgMessages.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>"><span
							class="bg-zw">上一页</span>
						</a>
						<a
							href="<%=path%>/notReadMsgMessages.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>"><span
							class="bg-zw">下一页</span>
						</a>
						<span class="bg-zw">第<%=curPage + 1%>页</span>
						<span class="bg-zw">每页显示</span>
						<a
							href="<%=path%>/notReadMsgMessages.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>"><span
							class="bg-zw">10</span>
						</a>
						<a
							href="<%=path%>/notReadMsgMessages.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>"><span
							class="bg-zw">20</span>
						</a>
						<a
							href="<%=path%>/notReadMsgMessages.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>"><span
							class="bg-zw">30</span>
						</a>
						<span class="bg-zw">条</span>
					</td>
				</tr>
				</table></td></tr>
			<tr>
			    <td height="20"></td>
			 </tr>	
			</table></td></tr>
			<%--<tr>
			<td height="10"></td>
			</tr>
			--%></table>
			</td></tr><tr>
			<td height="10"></td>
			</tr>
			</table></td></tr></table>
	</MARQUEE>
	</html:form>
  </body>
</html>
