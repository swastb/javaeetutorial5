<%@ page language="java" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/jsp/infopublic/commJs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String parentid = (String) request.getAttribute("parentid");
	String p_name = (String) request.getAttribute("p_name");
	String type = (String) request.getAttribute("type");
	String id = (String) request.getAttribute("id");
	String str = "";
	if ("dsh".equals(type))
		str = "审核";
	else if ("bs".equals(type))
		str = "报送";
	else
		str = "审批";
	//addType表示所添加信息是新闻 水务情况 重要文稿 法规 招标 照片 影片 声音 幻灯片中一种类型
	String addType = request.getParameter("addType");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>infopubcontentview.jsp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body onload="init('<%=addType%>')">
		<html:form action="/infopubContentaction.do">

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
									<%=str%>
									信息
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
											<th width="94%" height="30" align="right" valign="bottom"></th>
											<th width="6%" valign="bottom"></th>
										</tr>

										<tr>
											<td colspan="2" align="center" valign="top">
												<table width="99%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in" style="border: 0px">
													<tr>
														<td width="20%" align="left" style="noswap">
															栏目
														</td>
														<td valign="top">
															<html:text property="infoclas" styleClass="shuruk2"
																size="50" readonly="true" />
															<input type="button" class="button0" value="栏目选择"
																width="50" height="20"
																onclick="selectCla('more','infopub');" align="top">
														</td>

													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															标题
														</td>
														<td>
															<html:text property="title" size="50"
																styleClass="shuruk2" readonly="true" />
															<font color="red"> <span align="left" id="ftitle"></span>
																<span align="left" id="infocommNameCheck"></span> </font>
														</td>

													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															作者
														</td>
														<td>
															<html:text property="authorName" size="50"
																styleClass="shuruk2" readonly="true" />
														</td>
													</tr>
													<tr>
														<td width="20%" align="left" nowrap>
															创建时间
														</td>
														<td colspan="1">
															<html:text property="createTime" styleClass="shuruk2"
																size="50" readonly="true" />
														</td>
													</tr>
													<tr>
														<td width="10%" align="left" nowrap>
															关键字
														</td>
														<td width="90%">
															<table>
																<tr>
																	<td nowrap>
																		第一类
																	</td>
																	<td nowrap>
																		<html:select property="keyword1"
																			styleClass="bot_select" disabled="true">
																			<html:option value=""></html:option>
																			<html:option value="1">规划</html:option>
																			<html:option value="2">建设</html:option>
																			<html:option value="3">管理</html:option>
																			<html:option value="4">改革</html:option>
																		</html:select>
																	</td>
																	<td nowrap>
																		第二类
																	</td>
																	<td nowrap>
																		<html:select property="keyword2"
																			styleClass="bot_select" disabled="true">
																			<html:option value=""></html:option>
																			<html:option value="1">水安全</html:option>
																			<html:option value="2">水资源</html:option>
																			<html:option value="3">水环境</html:option>
																			<html:option value="4">水景观</html:option>
																		</html:select>
																	</td>
																</tr>
																<tr>
																	<td nowrap>
																		第三类（人物）
																	</td>
																	<td nowrap>
																		<html:select property="keyword3"
																			styleClass="bot_select" disabled="true">
																			<html:option value=""></html:option>
																			<html:option value="1">中央领导</html:option>
																			<html:option value="2">省（部）级领导</html:option>
																			<html:option value="3">市领导</html:option>
																			<html:option value="4">局领导</html:option>
																			<html:option value="5">专家</html:option>
																			<html:option value="6">劳模</html:option>
																			<html:option value="7">团队</html:option>
																			<html:option value="8">其他</html:option>
																		</html:select>
																	</td>
																	<td nowrap>
																		第四类（事件）
																	</td>
																	<td style="border-bottom: 0px">
																		<html:select property="keyword4"
																			styleClass="bot_select" disabled="true">
																			<html:option value=""></html:option>
																			<html:option value="1">水利设施</html:option>
																			<html:option value="2">供水设施</html:option>
																			<html:option value="3">排水设施</html:option>
																			<html:option value="4">江河湖泊</html:option>
																			<html:option value="5">其他</html:option>
																		</html:select>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
												<div id="xw" style="display:none;position:relative;">
													<table width="99%" border="0" cellpadding="0"
														cellspacing="1" class="tabin1_in" style="border:0px">
														<tr>
															<td width="20%" align="left" nowrap>
																简要标题
															</td>
															<td>
																<html:text property="summaryTitle" size="50"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																标题颜色
															</td>
															<td valign="top">
																<html:text property="titleColor" size="50"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																置顶时间
															</td>
															<td>
																<html:text property="topTime" size="50"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																信息来源
															</td>
															<td>
																<html:text property="infoSource" size="50"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																是否有版权
															</td>
															<td>
																<html:radio property="iscopyright" value="0"
																	disabled="true">否</html:radio>
																<html:radio property="iscopyright" value="1"
																	disabled="true">是</html:radio>
															</td>
														</tr>
													</table>
												</div>
												<div id="addType"
													style="display:none;position:relative; padding-top: 2px;padding-bottom: ">
													<table width="99%" border="0" cellpadding="0"
														cellspacing="1" class="tabin1_in" style="border: 0px">
														<tr>
															<td id="col0" width="20%"></td>
															<td id="col01" width="30%">
																<html:text property="col0V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
															<td id="col1" width="20%"></td>
															<td width="30%" id="col11">
																<html:text property="col1V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td id="col2"></td>
															<td id="col21">
																<html:text property="col2V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
															<td id="col3"></td>
															<td id="col31">
																<html:text property="col3V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td id="col4"></td>
															<td id="col41">
																<html:text property="col4V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
															<td id="col5"></td>
															<td id="col51">
																<html:text property="col5V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td id="col6"></td>
															<td id="col61">
																<html:text property="col6V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
															<td id="col7"></td>
															<td id="col71">
																<html:text property="col7V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td id="col8"></td>
															<td colspan="2" id="col81">
																<html:text property="col8V" size="25"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
													</table>
												</div>
												<div style="position:relative;">
													<table width="98%" border="0" cellpadding="0"
														cellspacing="1" class="tabin1_in" style="border: 0px">
														<tr>
															<td width="20%" align="left" nowrap>
																信息类型
															</td>
															<td>
																<html:select property="infoType" styleClass="bot_select"
																	disabled="true">
																	<html:option value="11">综合新闻</html:option>
																	<html:option value="12">一句话新闻</html:option>
																	<html:option value="10">水务要闻</html:option>
																	<html:option value="40">荣誉</html:option>
																	<html:option value="38">科技动态</html:option>
																	<html:option value="13">其他</html:option>
																</html:select>
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" style="noswap">
																简介
															</td>
															<td>
																<html:text property="summary" size="50"
																	styleClass="shuruk2" readonly="true" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" style="noswap">
																审批
															</td>
															<td>
																<html:select property="sendTo" styleClass="bot_select"
																	disabled="true">
																	<html:option value="1">不用审核</html:option>
																	<html:option value="2">待审核</html:option>
																	<html:option value="3">报送</html:option>
																</html:select>
															</td>
														</tr>
														<tr>
															<td width="100%" align="center" colspan="2"
																style="noswap">
																信息内容
															</td>
														</tr>
														<tr>
															<td colspan="2" align="center" align="left">
																<IFRAME ID="eWebEditor1" name="content_html"
																	src="eWebEditor/eWebEditor.jsp?id=content&style=standard&from=<%=type%>"
																	frameborder="0" scrolling="no" width="667" height="350"></IFRAME>
																<html:hidden property="content" styleClass="shuruk2" />
															</td>
														</tr>
														<%--<tr>
			    		<td nowrap width="100%" align="center" class="bg-zwbt" colspan="2" style="noswap">审核意见</td>
			    	</tr>
					<tr>
						<td width="100%" colspan="2">
						<textarea name="apparise" rows="5" cols="80" styleClass="shuruk2"></textarea>
						</td>
					</tr>
				--%>

														<%
														if ("dsh".equals(type)) {
														%>
														<tr>
															<td width="100%" align="center" colspan="2">
																<BUTTON ID="ofntColor" TITLE="审核通过" onclick="shenhe();"
																	onmouseover="this.style.cursor='hand'">
																	审核通过
																</BUTTON>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<BUTTON ID="a" TITLE="打回" onclick="rollback();"
																	onmouseover="this.style.cursor='hand'">
																	打回
																</BUTTON>
															</td>
														</tr>
														<%
														} else {
														%>
														<tr>
															<td width="100%" align="center" colspan="2">
																<BUTTON ID="ofntColor" TITLE="报送通过" onclick="shenhe();"
																	onmouseover="this.style.cursor='hand'">
																	报送通过
																</BUTTON>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<BUTTON ID="a" TITLE="打回" onclick="rollback();"
																	onmouseover="this.style.cursor='hand'">
																	打回
																</BUTTON>
															</td>
														</tr>
														<%
														}
														%>
													</table>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="10" colspan="2"></td>
							</tr>

						</table>
					</td>
				</tr>
				
			</table>
			
			<html:hidden property="clasel" />
			<!-- 多栏目 -->
			<html:hidden property="infoclas" />
			<!-- 多栏目 -->
			<input type="hidden" name="type" value="<%=type%>" />
			<input type="hidden" name="action" />
			<input type="hidden" name="method" value="shehedo" />
			<input type="hidden" name="p_name" value="<%=p_name%>" />
			<input type="hidden" name="parentid" value="<%=parentid%>" />
			<input type="hidden" name="id" value="<%=id%>" />
		</html:form>
	</body>
</html>

<script language="javascript">
function shenhe()
{
	document.forms[0].submit();
	return  true;
	//window.location.href="<%=path%>/infopubContentaction.do?method=shehedo&id=<%=id%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}
function rollback()
{
	window.location.href="<%=path%>/infopubContentaction.do?method=rollbackdo&id=<%=id%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}
function selectCla(oneormore,type){
	
			window.showModalDialog("<%=path%>/infopubclaaction.do?method=list&oneormore="+oneormore+"&type="+type+"&source=doubleClaPub",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		
	}
</script>
