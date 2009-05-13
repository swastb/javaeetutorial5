<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbSwrx;"/>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String method = request.getParameter("method");
	String view = request.getParameter("view");
	String type = request.getParameter("type");
	String hui = request.getParameter("hui");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
<!--
		var view='<%=view%>';
		function selectuser(flag,argDeptOrUser,tid,tname)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText="+tid+"&nameText="+tname+"&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		
		function checkForm(){
			var act=window.event.srcElement.id;
			if(document.getElementById('response').value==""&&(act=="save"||act=="reply")){
				alert("答复内容不能为空!");
				return false;
			}
			if(document.getElementById('ZBname').value==""&&act=="zb"){
				alert("专办人员不能为空!");
				return false;
			}
			if(document.getElementById('IDEAname').value==""&&act=="idea"){
				alert("征询意见人员不能为空!");
				return false;
			}
			document.all.method.value="submit"+"<%=method%>";
			document.all.action.value=act;
			document.forms[0].submit();
			return true;
		}

		function hui(){
			var hui = "<%=hui%>";
			var type = "<%=type%>";
			if(hui=='0'){
				window.location.replace('<%=path%>/swrx.do?method=waitslList');
			}else if(hui=='1'){
				window.location.replace('<%=path%>/swrx.do?method=overslList');
			}
		}
//-->
</script>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet"
			type="text/css" />

		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>

	</head>

	<body >
		<form action="<%=path%>/swrxZBWaitAction.do?method=swrxZBHF" method="post">
			<input type="hidden" name="ids" value="${idt }"/>
			<input type="hidden" name="type" value="${type }"/>
			<table width="100%" align="center" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="288" height="40" valign="middle"
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
									水务热线
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
						<table width="100%" align="center" border="0" cellpadding="0"
							cellspacing="0" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="99%" align="center" border="0" cellpadding="0"
										cellspacing="0" class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="100%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<td align="center" valign="top">
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td align="right">
																		<img src="<%=path%>/images/fh.gif" width="46"
																			height="25" onClick="hui();"
																			onMouseOver="this.style.cursor='hand'">
																		&nbsp;
																	</td>
																</tr>
															</table>

															<table align="center" width="99%" border="0"
																cellpadding="0" cellspacing="1" class="tabin1_in">
																<thead class="bg-zw">
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			编号：<input type="hidden" name="swid" value="${tbSwrx.swrxid }"/>
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="swrxno" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.swrxno  }" readonly="readonly"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			受理单位：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="acceptedunits" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.acceptedunits }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			跟踪次数：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="tracknum" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.tracknum }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			回访次数：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="returnvisitnum" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.returnvisitnum }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			报表标记：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="statementsmark" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.statementsmark }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			跟踪标记：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="trackingtags" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.trackingtags }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			超期重复报修：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="cqcfbx" style="width:100%"
																				Class="input-noborder"  value="${tbSwrx.cqcfbx }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			信息到站时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="informationreliability" style="width:100%"
																				 Class="input-noborder" maxlength="16"   value="${tbSwrx.informationreliability }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			自动打印时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="autoprinttime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.autoprinttime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			首次自动打印时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="firstautoprinttime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.firstautoprinttime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			转站标记：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="stationtomark" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.stationtomark }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			下单时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="underordertime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.underordertime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			接报时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="recevicereporttime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.recevicereporttime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			登录站点：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="logonstation" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.logonstation }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映人：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectpeople" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectpeople }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			客户号：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="customerno" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.customerno }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映单位：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectunit" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectunit }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			联系电话：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectphone" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectphone }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映区名：
																			
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectdistrict" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectdistrict }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			发生地址：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="addresshappen" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.addresshappen }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			发生日期：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="datehappen" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.datehappen }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映类别：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflecttype" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflecttype }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映内容：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectcontent" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectcontent }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理级别：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="cljb" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.cljb }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映形式：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectforms" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectforms }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映来源：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectsour" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectsour }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			受理备注：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="acceptedremarks" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.acceptedremarks }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			受理登录员：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="remarklogonuser" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.remarklogonuser }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			完成时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="completiontime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.completiontime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理人：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealpople" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealpople}"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理类别：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealtype" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealtype }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理内容：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealcontent" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealcontent }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			发生原因：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="cause" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.cause }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			解决措施：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="solutions" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.solutions }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理结果：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealresult" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealresult }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理及时：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealistimely" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealistimely }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理备注：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="dealremarks" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.dealremarks }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			重复标志：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="repeatsigns" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.repeatsigns }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			重复记录：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="repeatrecords" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.repeatrecords }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			处理登录员：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="deallogonuser" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.deallogonuser }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			跟踪计划：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="trackingprogram" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.trackingprogram }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			手机/BP：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="mobilephone" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.mobilephone }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			Email:
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="email" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.email }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			反映行业：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="reflectindustry" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.reflectindustry }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			预约时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="appointmenttime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.appointmenttime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			输入日期：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="inputdate" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.inputdate }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			销件及时：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="sellitemsistimely" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.sellitemsistimely }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifytime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifytime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			任务号：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="taskno" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.taskno }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			是否回复：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="replyornot" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.replyornot }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实登录员：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifylogonuser" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifylogonuser }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实人：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifypeople" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifypeople }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实备注：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifyremarks" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifyremarks }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实及时率：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifytimelyrate" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifytimelyrate }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			是否审核：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="isreview" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.isreview }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			受理状态：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="acceptedstatus" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.acceptedstatus }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			受理时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="acceptedtime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.acceptedtime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			回复登录员：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="replylogonuser" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.replylogonuser }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			回复时间：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="replytime" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.replytime }" Class="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			回复形式：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="replyforms" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.replyforms }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			回复备注：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="replyremarks" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.replyremarks }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			核实结果：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="verifyresult" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.verifyresult }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			12319编号：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="no12319" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.no12319 }"/>
																		</td>
																	</tr>
																	<tr>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			老系统编号：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="oldsystemno" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.oldsystemno }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt">
																			12319状态：
																		</td>
																		<td colspan="2" align="center">
																			<input type="text" name="status12319" style="width:100%"
																				Class="input-noborder" value="${tbSwrx.status12319 }"/>
																		</td>
																		<td height="25" width="12%" align="left"
																			class="bg-zwbt"></td>
																		<td colspan="2" align="center">

																		</td>
																	</tr>






																</thead>
															</table>
															<br>
															<table id="t1" align="center" width="99%" border="0"
																cellpadding="0" cellspacing="1" class="tabin1_in">
																<thead class="bg-zw">

																	<tr>
																		<td width="12%" height="25" align="center"
																			class="bg-zwbt">
																			答复内容
																		</td>
																		<td colspan="2">
																			<input type="textarea" Class="tabin_textarea1"
																				name="response" cols="90" rows="3" value="${tbSwrx.attr1 }"/>
																		</td>
																	</tr>
																</thead>
															</table>
															<div id="d1" width="90%" align="center">
																<input class="button0" type="button"
																	onclick="checkForm()" value="保存" id="save" />
																&nbsp;&nbsp;
																<input class="button0" type="button"
																	onclick="checkForm()" value="答复" id="reply" />
															</div>
															<br>
															<table align="center" width="99%" border="0"
																cellpadding="0" cellspacing="0" class="tabin1_in">
																<thead class="bg-zw">
																	<logic:notEmpty name="publicAffairTransacts">
																		<tr>
																			<td height="25" width="12%" align="center"
																				class="bg-zwbt">
																				办理人
																			</td>
																			<td align="center" width="10%" class="bg-zwbt">
																				办理时间
																			</td>
																			<td align="center" class="bg-zwbt">
																				意见
																			</td>
																		</tr>
																		<%
																					List publicAffairTransacts = (List) request
																					.getAttribute("publicAffairTransacts");
																			Iterator iter = publicAffairTransacts.iterator();
																			while (iter.hasNext()) {
																				Object[] item = (Object[]) iter.next();
																		%>

																		<tr>
																			<td height="25" align="center">
																				<%=item[0]%>

																			</td>
																			<td align="center">
																				<%=((Date) item[1]).toString().substring(0, 10)%>
																			</td>
																			<td align="center">
																				<%=item[2]%>
																			</td>
																		</tr>

																		<%
																		}
																		%>

																	</logic:notEmpty>
																</thead>
															</table>
															<br>
															<table id="t2" align="center" width="99%" border="0"
																cellpadding="0" cellspacing="1" class="tabin1_in">
																<thead class="bg-zwbt">

																	<tr>
																		<td width="12%" height="25" align="center"
																			class="bg-zwbt">
																			<input class="button0" type="button"
																				onclick="selectuser('participant','user','ZB','ZBname')"
																				value="转办" />
																		</td>
																		<td colspan="3">
																			<table width="100%">
																				<tr>
																					<td>
																						<input type="text" Class="tab_input4"
																							name="ZBname" size="85" readonly="readonly" />
																						<input type="hidden" name="ZB" />
																					</td>

																					<td>
																						<input class="button0" type="button"
																							onclick="checkForm()" value="提交" id="zb" />
																						<input class="button0" type="button"
																							onclick="document.getElementById('ZB').value='';document.getElementById('ZBname').value=''"
																							value="重新选择" />
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>

																	<tr>
																		<td width="12%" height="25" align="center"
																			class="bg-zwbt">
																			<input class="button0" type="button"
																				onclick="selectuser('participant','user','IDEA','IDEAname')"
																				value="征询意见" />
																		</td>
																		<td colspan="3">
																			<table width="100%">
																				<tr>
																					<td>
																						<input type="text" Class="tab_input4"
																							name="IDEAname" size="85" readonly="readonly" />
																						<input type="hidden" name="IDEA" />
																					</td>
																					<td>
																						<input class="button0" type="button"
																							onclick="checkForm()" value="提交" id="idea" />
																						<input class="button0" type="button"
																							onclick="document.getElementById('IDEA').value='';document.getElementById('IDEAname').value=''"
																							value="重新选择" />
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	<tr>
																		<td height="0"></td>
																	</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td height="20"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
							<tr>
								<td height="6"></td>
							</tr>
						</table>
				</tr>
				
			</table>
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="type" value='<%=type%>' />
			<input type="hidden" name="id" />

		<form>
	</body>
</html>
