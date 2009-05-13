<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbZwWeekSechedule" />
<jsp:directive.page import="com.baosight.tools.WeekManager" />
<jsp:directive.page import="java.text.SimpleDateFormat"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List personLastList = (List) request.getAttribute("personLastList");
%>
<html>
<head>
<link href="<%=path %>/css/index-css.css" rel="stylesheet" type="text/css">
</head>
<body>
		<table width="97%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td align="right">
					<a href="<%=path%>/tbZwWeekSecheduleAction.do?method=list&action=personAll" target="rightFrame">
								<span class="xb">>>更多...</span></a>
				</td>
				<td align="right">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td height="1" background="<%=path %>/imagine/ddddd3.gif">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="219" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<table width="219" border="0" cellpadding="0" cellspacing="0">		
									<%
										if(personLastList!=null && personLastList.size()>0)
										{
											Iterator it=personLastList.iterator();
											SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
											
											SimpleDateFormat nsdf=new SimpleDateFormat("yyyy-MM-dd");
											String now=nsdf.format(new Date());
											while(it.hasNext())
											{
												TbZwWeekSechedule entity=(TbZwWeekSechedule)it.next();
												%>
													
													<%--<tr align="left">
														<td width="20%" height="18" class="xb">
															[时间]:
														</td>
														<td width="80%" height="18" class="zw">
															<%
																if(now.equals(sdf.format(entity.getStartTime()).substring(0,10)))
																{
																	%>
																		今天&nbsp;<%=sdf.format(entity.getStartTime()).substring(10,16) %>
																	<%
																}else
																{
																	%>
																		明天&nbsp;<%=sdf.format(entity.getStartTime()).substring(10,16) %>
																	<%
																}
															 %>
														</td>
													</tr>
													--%>
													<tr align="left" >
														<td width="20%" height="18" class="xb">
															[内容]:
														</td>
														<td width="80%" height="18" class="zw">
															<%
																if(now.equals(sdf.format(entity.getStartTime()).substring(0,10)))
																{
																	%>
																		今天&nbsp;<%=sdf.format(entity.getStartTime()).substring(10,16) %>
																	<%
																}else
																{
																	%>
																		明天&nbsp;<%=sdf.format(entity.getStartTime()).substring(10,16) %>
																	<%
																}
															 %>
															 &nbsp;
															<%String context=entity.getContent(); %>
															<%if(context!=null)
															{
																if(context.length()>10)
																{
																	%>
																		<%=context.substring(0,10) %>
																	<%
																}else
																{
																	%>
																		<%=context %>
																	<%
																}
																
															}else
															{
																%>
																	&nbsp;
																<%
															}
															 %>
														</td>
													</tr>
													<%--
													<tr align="left" >
														<td width="20%" height="18" class="xb">
															[地点]:
														</td>
														<td width="80%" height="18" class="zw">
															<%=entity.getRem() %>
														</td>
													</tr>
													--%>
													<tr>
														<td height="1" colspan="2" background="<%=path %>/imagine/ddddd3.gif">
														</td>
													</tr>
												<%
											}
										}
									 %>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
