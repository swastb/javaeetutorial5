<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbApply;"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
List apply = (List) request.getAttribute("curPageList");
	String name = "";

	name = (String) request.getAttribute("name");
	if (name == null || name.equals("")) {
		name = (String) request.getParameter("name");
	}

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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%
		List infoConList = (List) request.getAttribute("curPageList");
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
				<tr align="center" height="30" class="xb">
				<td width="20%" align="center" class="zw">
					受理号
				</td>
				<td width="20%" align="center" class="zw">
					项目名称
				</td>
				<td width="20%" align="center" class="zw">
					审批时间
				</td>
				<td width="20%" align="center" class="zw">
					办理结果
				</td>
				<td width="20%" align="center" class="zw">
					许可决定
				</td>
			</tr>
		<%
					if (apply != null) {
					for (int i = 0; i < apply.size(); i++) {
						//TbApply item=(TbApply)apply.get(i);
						Object[] item1 = (Object[]) apply.get(i);

						String over = "";
			%>
					<tr align="center" class="zw">
				<td width="20%" height="25" align="center">
					<%=item1[2] == null ? "" : item1[2].toString()
							.substring(5, item1[2].toString().length())%>
				</td>
				<td width="20%" align="center">
					<%
					String temp1 = item1[3].toString();
					if(temp1==null){
					%>""<%
					}else{
						if(temp1.length()>3){
						%><%=temp1.substring(0,3)%><%
							
						}else{
						%><%=temp1.substring(0,temp1.length())%><%
							
						}
					}
				 %>
				</td>
				<td width="20%" align="center">
					<%=item1[1] == null ? "" : item1[1].toString()
							%>
				</td>
				<td width="20%" align="center">
					<%=item1[4] == null ? "" : item1[4].toString()
							%>
				</td>
				<td width="20%" align="center">
					<a
						href="../oademo/xzxk.do?method=xzxkFindbyiddayin&action=before&id=<%=item1[0]%>"
						target="_blank">查看
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
								href="<%=path%>/applyaction.do?method=movePageMore&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">上一页</span>
							</a>
							<a
								href="<%=path%>/applyaction.do?method=movePageMore&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">下一页</span>
							</a>
							<span class="zw">第<%=curPage + 1%>页</span>
							<span class="zw">每页显示</span>
							<a
								href="<%=path%>/applyaction.do?method=resetPageSizeMore&pageSize=10&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">10</span>
							</a>
							<a
								href="<%=path%>/applyaction.do?method=resetPageSizeMore&pageSize=20&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">20</span>
							</a>
							<a
								href="<%=path%>/applyaction.do?method=resetPageSizeMore&pageSize=30&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">30</span>
							</a>
							<span class="zw">条</span>
							<span class="zw">共<%=count %>条</span>
						</td>
					</tr>
			</table></td></tr>
		</table></td></tr></table>
	</body>
</html>

