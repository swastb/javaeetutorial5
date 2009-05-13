<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'resSetlist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<form
			action="<%=path%>/base/function/forwardFunction.do?method=saveResSet"
			method="post">
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="288" height="40" align="left" valign="middle"
									background="images/8-1.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="5%" align="center" valign="middle">
												&nbsp;
											</td>
											<td width="11%" height="12" align="center" valign="middle">
												<img src="images/icon5.gif" width="7" height="7" />
											</td>
											<td width="84%" class="table2_topic" align="right">
												收藏夹设置
											</td>
										</tr>
									</table>
								</td>
								<td background="images/8-2.gif">
									&nbsp;
								</td>
							</tr>
						</table>
						<table width="100%" align="center" border="1" cellpadding="0"
							cellspacing="1" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="bottom">
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<%--<tr>

																	<td height="27" colspan="3" valign="middle"
																		bgcolor="#f7f7f7" align="left">
																		<span class="bg-zw"></span>
																	</td>
																</tr>
																--%><tr align="center" class="bg-zwbt">
																	<%--<input name="allCheck" type="checkbox"></input>全选</td>--%>
																	<th align="center" height="25" width="10%">
																		<span style="font-family:黑体;color:#000000; font-size:13px">序号</span>
																	</th>
																	<th align="center" width="80%">
																		<span style="font-family:黑体;color:#000000; font-size:13px">功能模块</span>
																	</th>
																	<th align="center" width="10%">
																		<span style="font-family:黑体;color:#000000; font-size:13px">选择</span>
																	</th>
																</tr>
																<c:forEach var="content1" items="${allSetRes}"
																	varStatus="loop">
																	<tr align="center" class="bg-zw">
																		<td align="center" height="25" width="10%">
																			${loop.index+1}
																		</td>
																		<td align="center" width="80%">
																			${content1.name}
																		</td>
																		<td align="center" width="10%">
																			<input type="checkbox" value='${content1.id}'
																				name="resIds" checked></input>
																		</td>
																	</tr>
																</c:forEach>
																<c:forEach var="content2" items="${allRes}"
																	varStatus="loop">
																	<tr align="center" class="bg-zw">
																		<td align="center" height="25" width="10%">
																			${loop.index+fn:length(allSetRes)+1}
																		</td>
																		<td align="center" width="80%">
																			${content2.name}
																		</td>
																		<td align="center" width="10%">
																			<input type="checkbox" value='${content2.id}'
																				name="resIds"></input>
																		</td>
																	</tr>
																</c:forEach>
																<tr>
																	<td align="center" width="100%" colspan="3">
																		<a onclick="submit();"
																			onmouseover="this.style.cursor='hand'"> <img
																				src="<%=path%>/imagine/tj.gif" width="52"
																				height="23">
																		</a>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="10"></td>
													</tr>
												</table>
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="8"></td>
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
