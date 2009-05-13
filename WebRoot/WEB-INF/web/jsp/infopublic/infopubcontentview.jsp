<%@ page language="java" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	TbInfoPubContent item = (TbInfoPubContent) request
			.getAttribute("item");
	String content = (String) request.getAttribute("content");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><%=item.getTitle()%>
		</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css;<%=path%>/css/style1.css"
			rel="stylesheet" type="text/css">

	</head>
	<jsp:include flush="true" page="top.jsp" />
	<body topmargin="0" leftmargin="0" style="margin: 0px">

		<table width="1000" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<html:form action="/infopubContentaction.do">
				<tr>
					<td height="10" align="center" bgcolor="#e3eaf1"></td>
				</tr>
				<tr>
					<td height="130" align="center" bgcolor="#e3eaf1">
						<table width="90%" height="581" border="0" align="center"
							cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tabp_yy">
							<tr>
								<td valign="top" bgcolor="#f1f8fc">
									<table width="100%" border="0" cellspacing="1" cellpadding="0">
										<tr>
											<td height="50" align="center" valign="bottom"
												background="imagine/tab_bg1.gif">
												<table width="94%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="1%" align="left" valign="top"
															background="imagine/tab_bg_a.gif">
															<img src="imagine/tab_bg_b.gif" width="5" height="34" />
														</td>
														<td width="8%" align="center"
															background="imagine/tab_bg_a.gif">
															<img src="imagine/icon19.gif" width="29" height="30" />
														</td>
														<td width="90%" background="imagine/tab_bg_a.gif"
															class="tabp_tit">
															<%=item.getTitle()%>
														</td>
														<td width="1%" align="right" valign="top"
															background="imagine/tab_bg_a.gif">
															<img src="imagine/tab_bg_c.gif" width="5" height="34" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table width="82%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td width="92%" height="40"></td>
										</tr>
										<tr>
											<td height="15" align="left" class="zw">
												<p>
													&nbsp;&nbsp;&nbsp;&nbsp;
													<%=content%>
												</p>
											</td>

										</tr>
										<tr>
											<td height="50" align="right" class="zw-time">
												<%=item.getRecordTime() == null ? "" : item
					.getRecordTime().toString().substring(0, 10)%>
											</td>
										</tr>
									</table>

									<table width="90%" align="center" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td height="35" align="center">
												<input class="bg-zw" name="Submit" type="button"
													onClick="window.close()" value="¹Ø±Õ´°¿Ú">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</html:form>
		</table>

	</body>
</html>
