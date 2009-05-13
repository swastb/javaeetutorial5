<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String name = "";

	name = (String) request.getAttribute("name");
	if (name == null || name.equals("")) {
		name = (String) request.getParameter("name");
	}

	String sessionID = "";
	int curPage = 0;
	try {
		sessionID = (String) request.getAttribute("sessionID");
		curPage = (Integer) session.getAttribute(sessionID + "No");

	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%
		List infoConList = (List) request.getAttribute("resultList");
		%>
		<base href="<%=basePath%>">

		<title><%=name%>
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/index-css.css;<%=path%>/css/style1.css" rel="stylesheet"
			type="text/css">
	</head>

	<body leftmargin="0" topmargin="0">
		<table width="1000"  align="center" border="0"
			cellpadding="0" cellspacing="0"  class="tableborder">
			<tr>
    <td height="10" align="center" bgcolor="#e3eaf1"></td>
  </tr>
  <tr>
    <td height="130" align="center" bgcolor="#e3eaf1"><table width="90%" height="581" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tabp_yy">
      <tr>
        <td valign="top" bgcolor="#f1f8fc"><table width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr>
              <td height="50" align="center" valign="bottom" background="imagine/tab_bg1.gif"><table width="94%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="1%" align="left" valign="top" background="imagine/tab_bg_a.gif"><img src="imagine/tab_bg_b.gif" width="5" height="34" /></td>
                    <td width="8%" align="center" background="imagine/tab_bg_a.gif"><img src="imagine/icon19.gif" width="29" height="30" /></td>
                    <td width="90%" background="imagine/tab_bg_a.gif" class="tabp_tit"><%=name %></td>
                    <td width="1%" align="right" valign="top" background="imagine/tab_bg_a.gif"><img src="imagine/tab_bg_c.gif" width="5" height="34" /></td>
                  </tr>
              </table></td>
            </tr>
          </table>
			<table width="82%" border="0" align="center" cellpadding="0" cellspacing="0">
			<br>
			<%
					if (infoConList != null && !infoConList.isEmpty()) {
					for (int i = 0; i < infoConList.size(); i++) {
						TbInfoPubContent item = (TbInfoPubContent) infoConList
						.get(i);
						String title = "";
						title = item.getTitle();
			%>
			<tr>

				<td height="22" width="91%" class="zw" onmouseover="bgColor='#76c5eb'" onmousedown="bgColor='#76c5eb'"  onmouseout="bgColor='#f1f8fc'">
					■
					&nbsp;
					<a
						href="<%=path%>/infopubContentaction.do?method=view&id=<%=item.getId()%>"
						target="_blank"><%=title%>
					</a>
				</td>
				<td width="72" height="18" align="center" class="zw-time">
					[
					<%=item.getRecordTime() == null ? "" : item
							.getRecordTime().toString().substring(5, 10)%>
					]
				</td>
			</tr>
			<tr>
				<td height="1" colspan="2"
					background="<%=path%>/imagine/ddddd3.gif">
				</td>
			</tr>
			<%
				}
				}
			%></table>
			<br>
		<table width="818">
		
					<tr align="right">
						<td>
							<a
								href="<%=path%>/infopubContentaction.do?method=movePageMore&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">上一页</span>
							</a>
							<a
								href="<%=path%>/infopubContentaction.do?method=movePageMore&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">下一页</span>
							</a>
							<span class="zw">第<%=curPage + 1%>页</span>
							<span class="zw">每页显示</span>
							<a
								href="<%=path%>/infopubContentaction.do?method=resetPageSizeMore&pageSize=10&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">10</span>
							</a>
							<a
								href="<%=path%>/infopubContentaction.do?method=resetPageSizeMore&pageSize=20&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">20</span>
							</a>
							<a
								href="<%=path%>/infopubContentaction.do?method=resetPageSizeMore&pageSize=30&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">30</span>
							</a>
							<span class="zw">条</span>
						</td>
					</tr>
			</table></td></tr>
		</table></td></tr></table>
	</body>
</html>

