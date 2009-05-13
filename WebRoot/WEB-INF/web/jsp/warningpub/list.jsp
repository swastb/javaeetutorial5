<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib prefix="logic" uri="/WEB-INF/tld/struts-logic.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int curPage = 0;
	long count=0;
	String sessionID = "";
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
		<title>上海市防汛防台预警信号统计</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=path%>/js/calendar-dong.js"></script>
		<script type="text/javascript">
		function movePage(p){
			document.getElementById("method").value = "movePage";
			document.getElementById("moveTo").value = p;
			document.forms[0].submit();
		}
		function resetPageSize(s){
			document.getElementById("method").value = "resetPageSize";
			document.getElementById("pageSize").value = s;
			document.forms[0].submit();
		}
		function viewItem(id){
			location.href="<%=path%>/warningPub.do?method=input&readonly=true&id="+id;
		}
		function modifyItem(id){
			location.href="<%=path%>/warningPub.do?method=input&id="+id;
		}
		function deleteItem(id){
			if(confirm("你确定要删除这条记录吗？")){
				location.href="<%=path%>/warningPub.do?method=delete&id="+id;
			}
		}
		</script>
		
	</head>
	<body>
		<form action="<%=path%>/warningPub.do">
		<input type="hidden" name="method" value="list"/>
		<input type="hidden" name="sessionID" value="<%=sessionID%>"/>
		<input type="hidden" name="moveTo" value="<%=curPage%>"/>
		<input type="hidden" name="pageSize" value="10"/>		
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
											<td width="84%" class="table2_topic" align="left">
												上海市防汛防台预警信号统计
											</td>
										</tr>
									</table>
								</td>
								<td background="images/8-2.gif">
									&nbsp;
								</td>
							</tr>
						</table>
						<table width="100%" align="center" border="0" cellpadding="0"
							cellspacing="1" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="bottom">	
															<table width="99%" border="0" cellpadding="0"
																cellspacing="0" >
																<tr>
																	<td height="27" width="93%" colspan="4" valign="middle"
																		bgcolor="#f7f7f7" align="left">
																		预警信号级别:
																		<select name="signal">
																			<option value="0">------全部------</option>
																			<option value="1">防汛防台蓝色预警警报</option>
																			<option value="2">防汛防台黄色预警警报</option>
																			<option value="3">防汛防台橙色预警警报</option>
																			<option value="4">防汛防台红色预警警报</option>
																		</select>
																		应急响应级别:
																		<select name="resp">
																			<option value="0">------全部------</option>
																			<option value="1">防汛防台Ⅳ响应</option>
																			<option value="2">防汛防台Ⅲ响应</option>
																			<option value="3">防汛防台Ⅱ响应</option>
																			<option value="4">防汛防台Ⅰ响应</option>
																		</select>
																		时间从:
																		<input type="text" name="pubstart"
																			 maxlength="100" size="10"
																			class="shuruk1" onfocus="setday(this)"/>
																		至:
																		<input type="text" name="pubend"
																			 maxlength="100" size="10"
																			class="shuruk1" onfocus="setday(this)"/>
																		<input type="button" class="button0" value="查 询" onclick="document.forms[0].submit();"/>
																	</td>
																	<td align="right">
																	<input type="button" class="button0" value="增 加" onclick="location.href='<%=path%>/warningPub.do?method=input'"/>
																	</td>
																</tr>
																</table>
																<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr align="center" class="bg-zwbt">
																	<th width="10%" height="25" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		序号
																	</th>
																	<th align="center" width="18%">
																		预警发布时间
																	</th>
																	<th align="center" width="18%">
																		预警解除时间
																	</th>
																	<th align="center" width="18%">
																		预警信号级别
																	</th>
																	<th align="center" width="18%">
																		应急响应级别
																	</th>
																	<th align="center" width="18%">
																		操作
																	</th>
																</tr>
																<logic:iterate id="item" indexId="i" name="curPageList" type="com.baosight.mode.TbWarningPub">
																<tr>
																<td class="bg-zw">${i+1}</td>
																<td align="center" class="bg-zw"><bean:write name="item" property="pubstart" format="yyyy-MM-dd"/></td>
																<td align="center" class="bg-zw"><bean:write name="item" property="pubend" format="yyyy-MM-dd"/></td>
																<td align="center" class="bg-zw">
																	<c:if test="${item.signal==1}">
																		防汛防台蓝色预警信号
																	</c:if>
																	<c:if test="${item.signal==2}">
																		防汛防台黄色预警信
																	</c:if>
																	<c:if test="${item.signal==3}">
																		防汛防台橙色预警信号
																	</c:if>
																	<c:if test="${item.signal==4}">
																		防汛防台红色预警信号
																	</c:if>																																																			
																</td>
																<td align="center" class="bg-zw">
																	<c:if test="${item.resp==1}">
																		防汛防台Ⅰ级响应
																	</c:if>
																	<c:if test="${item.resp==2}">
																		防汛防台Ⅱ级响应
																	</c:if>
																	<c:if test="${item.resp==3}">
																		防汛防台Ⅲ级响应
																	</c:if>
																	<c:if test="${item.resp==4}">
																		防汛防台Ⅳ级响应
																	</c:if>																																																			
																
																</td>
																<td align="center" class="bg-zw">
																<img src="<%=path%>/images/icon10.gif" alt="查看" onmouseover="this.style.cursor='hand'" onclick="viewItem('${item.id}')"/>&nbsp;&nbsp;
																<img src="<%=path %>/images/icon9.gif" alt="修改" onmouseover="this.style.cursor='hand'" onclick="modifyItem('${item.id}')"/>&nbsp;&nbsp;
																<img src="<%=path %>/images/icon6.gif" alt="删除" onmouseover="this.style.cursor='hand'" onclick="deleteItem('${item.id}')"/></td>
																</tr>
																</logic:iterate>
															</table>
															<table width="99%" border="0" cellspacing="0" cellpadding="0" align="right">
																<tr>
																	<td height="10"></td>
																</tr>
																<tr>
																	<td class="tabin_page">
																		<a href="#" onclick="movePage('<%=curPage - 1%>');return false;"><span class="bg-zw">上一页</span></a>
																		<a href="#" onclick="movePage('<%=curPage + 1%>');return false;"><span class="bg-zw">下一页</span></a>
																		<span class="bg-zw">第<%=curPage + 1%>页</span>
																		&nbsp;&nbsp;&nbsp;&nbsp;
																		<span class="bg-zw">每页显示</span>
																		<a href="#" onclick="resetPageSize('10');return false;"><span class="bg-zw">10</span></a>
																		<a href="#" onclick="resetPageSize('20');return false;"><span class="bg-zw">20</span></a>
																		<a href="#" onclick="resetPageSize('30');return false;"><span class="bg-zw">30</span></a>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">共<%=count %>条</span>																		
															</table></td>
													</tr>
													<tr>
														<td height="10"></td>
													</tr>
												</table>
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
		</form>
	</body>
</html>
