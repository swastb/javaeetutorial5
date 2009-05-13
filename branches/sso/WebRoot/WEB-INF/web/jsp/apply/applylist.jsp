<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbApply;" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List apply = (List) request.getAttribute("apply");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>行政许可</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
	</head>
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style1 {color: #11B1FF}
.zw {
          font-size: 12px;
		  color: #333333; 
		  font-family: "宋体";
		   }
a:link {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
}
a:visited {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
}
a:hover {
	font-family: "宋体";
	font-size: 12px;
	color: #326CA0;
	text-decoration: none;
}
a:active {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
}	
-->
</style>
	<body style='overflow:scroll;overflow-x:hidden' leftmargin="0"
		topmargin="0" bgcolor="e6e2f5">
		<table width="100%" border="1" align="center" cellpadding="0"
			cellspacing="0" bordercolor="eeecfb" bgcolor="e6e2f5">
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
				<td width="20%" height="22" align="center">
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
			%>
			<table width="305" height="5" vaign="top" align="center" border="0"
				cellpadding="0" cellspacing="0">
				<td width="225"></td>
				<td height="20" vaign="top" align="center">
					&nbsp;&nbsp;
					<a href="<%=path%>/applyaction.do?method=wsbs_login&name=网上办事"
						target="_blank"><img src="<%=path%>/imagine/more.gif"
							width="41" height="11" border="0">
					</a>
				</td>
			</table>

		</table>

	</body>
</html>
