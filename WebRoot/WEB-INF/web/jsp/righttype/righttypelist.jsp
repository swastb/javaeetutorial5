<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbPstlvl" />
<jsp:directive.page import="com.baosight.mode.TbRighttype" />
<jsp:directive.page import="com.baosight.mode.TbAppsys" />
<jsp:directive.page import="com.baosight.mode.TbFunction" />

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List allrighttype = (List) request.getAttribute("allrighttype");
	List tb_appsys = (List) request.getAttribute("tb_appsys");
	List tb_function = (List) request.getAttribute("tb_function");

	String appsysID = (String) request.getAttribute("strappsysID");
	String functionID = (String) request.getAttribute("strfunctionID");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'pstlvllist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		function select()
		{
			
            var strappsysID=document.getElementById("appsysID").value;
            var strfunctionID=document.getElementById("functionID").value;
            var path=document.getElementById("path").value;
            window.location.replace(path+"/righttypeaction.do?method=list&strappsysID="+strappsysID+"&strfunctionID="+strfunctionID);
            
		}
		function CheckForm(){
				var funid=document.getElementById("functionID").value;
				var appid=document.getElementById("appsysID").value;
				var pah=document.getElementById("path").value;
				if(funid == ""){
				window.location.replace("#");

				}
				else{
				window.location.replace(pah+"/righttypeaction.do?method=add&action=add&appsysID="+appid+"&functionID="+funid);

				}
				}
	</script>
	</head>
	<body>
		<table width="100%" align="center" cellpadding="0" cellspacing="0">
			<input type="hidden" value="<%=path%>" name="path" />
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
										<td width="84%" class="table2_topic">
											权限类型管理
										</td>
									</tr>
								</table>
							</td>
							<td background="images/8-2.gif">
								&nbsp;
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#0e88b9">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="table2bg">
									<tr>
										<td align="center" valign="top">
											<table width="98%" border="0" cellpadding="0" cellspacing="0"
												class="table2bgin">
												<tr>
													<th height="30" valign="bottom"></th>
												</tr>
												<tr>
													<td align="center" valign="top">
														<table width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in">
															<tr>
																<td height="25" width="100%" colspan="3"
																	bgcolor="#e8f0f1" align="left">所属应用系统:
																	<select name="appsysID" onpropertychange="select()">
																		<%
																				for (int i = 0; i < tb_appsys.size(); i++) {
																				TbAppsys tbappsys = (TbAppsys) tb_appsys.get(i);
																				if (appsysID.equals(tbappsys.getId())) {
																		%>
																		<option value="<%=tbappsys.getId()%>"
																			selected="selected" onpropertychange="select()">
																			<%=tbappsys.getName()%>
																		</option>
																		<%
																		} else {
																		%>
																		<option value="<%=tbappsys.getId()%>"
																			onpropertychange="select()">
																			<%=tbappsys.getName()%>
																		</option>
																		<%
																			}
																			}
																		%>
																	</select>
																	所属资源:
																	<select name="functionID" onpropertychange="select()">
																		<%
																				for (int i = 0; i < tb_function.size(); i++) {
																				TbFunction tbfunction = (TbFunction) tb_function.get(i);
																				if (functionID.equals(tbfunction.getId())) {
																		%>
																		<option value="<%=tbfunction.getId()%>"
																			selected="selected" onpropertychange="select()">
																			<%=tbfunction.getName()%>
																		</option>
																		<%
																		} else {
																		%>
																		<option value="<%=tbfunction.getId()%>"
																			onpropertychange="select()">
																			<%=tbfunction.getName()%>
																		</option>
																		<%
																			}
																			}
																		%>
																	</select>
																</td>
															
																<td height="25" colspan="2" valign="bottom" bgcolor="#e8f0f1" align="right">&nbsp;
			   												    <input name="Submit2" type="submit" class="button0" value="&nbsp;增 加&nbsp;" onclick="CheckForm();"
	    		 												 onmouseover="this.style.cursor='hand'"/>
																</td>
															</tr>
															<tr align="center" class="bg-zwbt">
																<th width="5%" height="25" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	序号
																</th>
																<th width="45%" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	权限类型名称
																</th>
																<th width="40%" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	权限类型代码
																</th>
																<th width="10%" align="center" colspan="2">
																	操作
																</th>
															</tr>
															<%
																	for (int i = 0; i < allrighttype.size(); i++) {
																	TbRighttype item = (TbRighttype) allrighttype.get(i);
															%>
															<tr align="center">
																<td width="5%" height="25" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	<%=i + 1%>
																</td>
																<td width="45%" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	<%=item.getName()%>
																</td>
																<td width="40%" align="center"
																	style="word-break: break-all; word-wrap:break-word;">
																	<%=item.getCode() + ""%>
																</td>
																<td width="5%" align="center">
																	<a title="修改"
																		href="<%=path%>/righttypeaction.do?method=modify&id=<%=item.getId()%>&appsysID=<%=appsysID%>&functionID=<%=functionID%>"><img
																			src="<%=path%>/images/icon9.gif" width="15"
																			height="15" border="0">
																	</a>
																</td>
																<td width="5%" align="center">
																	<%
																	if (item.getInsure() == 0) {
																	%>
																	<a title="删除"
																		href="<%=path%>/righttypeaction.do?method=delete&id=<%=item.getId()%>"
																		onclick="return confirm('是否确认删除')"><img
																			src="<%=path%>/images/icon6.gif" width="15"
																			height="15" border="0">
																	</a>
																	<%
																	} else {
																	%>
																	&nbsp;
																	<%
																	}
																	%>

																</td>
															</tr>
															<%
															}
															%>
															
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
					</td>
					</tr>
					</table>
	</body>
</html>
