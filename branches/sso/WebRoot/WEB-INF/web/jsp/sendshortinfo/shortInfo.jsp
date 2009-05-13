<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<html>
	<head>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			//是否启用
			String insureflag = (String) request.getAttribute("insureflag");
			boolean flag = true;
			if (insureflag != null) {
				if ("true".equals(insureflag)) {
					flag = false;
				} else {
					flag = true;
				}
			}
		%>
		<base href="<%=basePath%>">
		<title>短信平台</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<script src="<%=path%>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-zh.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-setup.js"></script>
		<script type="text/javascript" src="<%=path%>/js/calendarS.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript">
			function inputTree(flag){
				var url = "";
				if(flag=="comm"){
					url = "<%=basePath%>shortInfo.do?method=inputCommonGroup";
				}
				if(flag=="indu"){
					url = "<%=basePath%>shortInfo.do?method=inputIndualGroup";
				}				
				openWin(url,"600px","600px","");
			}
			function openWin(url,width,height,other){
				var win = window.showModalDialog(url,window,"dialogWidth:"+width+";dialogHeight:"+height+";center:yes;resizable:no;status:no;scroll:auto;help:no;edge:raised"+other);
			}
			function checkin(){
					if(document.smsScheduleForm.messageContent.value==""){
						alert("发送内容不能为空！");
						return false;
					}
					if(document.smsScheduleForm.messageContent.value.length>140){
						alert("发送内容超过指定长度！");
						return false;
					}
					var smscount=989065;
					var currentcount=0;
				    if(document.smsScheduleForm.destNumberPhone.value!=""){
						var pattern=/[^0-9; ]/;
						if(pattern.test(document.smsScheduleForm.destNumberPhone.value)==true){
							alert("手机号码输入格式错误，请重新输入！");
							return false;
						}
					}
					if(document.smsScheduleForm.destNumberObject.value=="" && document.smsScheduleForm.destNumberPhone.value==""){
						alert("发送对象不能为空！");
						return false;
					}
				    return true;
				//	var frm = document.forms[0];
				//	frm.submit();
		}	
		function clean_click(){
		  document.smsScheduleForm.messageContent.value ="";
		   document.smsScheduleForm.destNumberObject.value ="";
		    document.smsScheduleForm.destNumberPhone.value ="";
		}	
		// 公共通讯录
		function addbookList(idText,nameText,mobileText,groupsText){
		    window.open("<%=path%>/commonalityTree.do?method=input&idText="+idText+"&nameText="+nameText+"&mobileText="+mobileText+"&flag="+groupsText,"",'width=450,height=500,top=100, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
		//	window.showModalDialog("<%=path%>/commonalityTree.do?method=input&idText="+idText+"&nameText="+nameText+"&mobileText="+mobileText+"&groupsText="+groupsText,window,'dialogwidth:450px;dialogheight:500px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		// 个人通讯录
		function addbooIndividualkList(idText,nameText,mobileText,groupsText){
		  window.open("<%=path%>/individualTree.do?method=input&idText="+idText+"&nameText="+nameText+"&mobileText="+mobileText+"&groupsText="+groupsText,"",'width=450,height=500,top=100, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
			//window.showModalDialog("<%=path%>/individualTree.do?method=input&idText="+idText+"&nameText="+nameText+"&mobileText="+mobileText+"&groupsText="+groupsText,window,'dialogwidth:450px;dialogheight:500px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}	
		function systemTime(){
		   	today = new Date();
			sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
			//stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
			shours = fmtl(today.getHours(),2);
			sminutes = fmtl(today.getMinutes(),2);
			//ses = fmtl(today.getSeconds(),2);
			document.getElementById("scheduletime").value = sday;
			document.getElementById("sendTime_hour").value = shours;
			document.getElementById("sendTime_minute").value = ":"+sminutes+":00";
			//obj.value+="---${SYSTEM_USER_SESSION.name}同志  "+sday+" "+stime;
		}
		function fmtl(s,l){
			ss = ""+s;
			if(ss.length<l){
				for(i=0;i<l-ss.length;i++){
					ss = "0"+ss;
				}
			}
			return ss;
		}
		function displaylist(divname) {
			var adv=document.getElementById(divname);
		           if(adv.style.display=="none") {
		                         adv.style.display="";
		                         //advtext.innerText="关闭列表";
		              } else {
		                         adv.style.display="none";
		                        //advtext.innerText="显示列表";
		               }
		}
		
		</script>
		<style>
	a:link {text-decoration: none;}
	a:visited {text-decoration: none;}
	a:active {text-decoration: none;}
	a:hover {text-decoration: none;}
	</style>
	</head>
	<body onload="systemTime();">
		<html:form action="/shortInfo?method=executeSave">
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="288" height="40" align="left" valign="middle"
									background="<%=path%>/images/8-1.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="5%" align="center" valign="middle">
												&nbsp;
											</td>
											<td width="11%" height="12" align="center" valign="middle">
												<img src="<%=path%>/images/icon5.gif" width="7" height="7" />
											</td>
											<td width="84%" class="table2_topic" align="right">
												短息发送
											</td>
										</tr>
									</table>
								</td>
								<td background="<%=path%>/images/8-2.gif">
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
														<th height="15" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="bottom">

															<table width="98%" class="tabin_in" border="0"
																cellpadding="0" cellspacing="1">
																<tr>
																	<td bgcolor="deeef8" width="20%" align="center">
																		短信内容
																	</td>
																	<td bgcolor="f7f7f7" align="left">
																		<html:textarea styleClass="shuruk2"
																			property="messageContent" rows="7" cols="60"></html:textarea>
																		<br>
																		<strong>(<font color="#FF0000">注意:</font>发送内容不能超过70个中文字或140个英文字符！)</strong>
																	</td>
																</tr>
																<tr>
																	<td bgcolor="deeef8">
																		发送对象
																	</td>
																	<td bgcolor="f7f7f7" align="left">
																		<html:text styleClass="shuruk2"
																			property="destNumberObject" size="60" maxlength="200"></html:text>
																		<br>
																		<input type="hidden" name="commId"/>
																		<input type="hidden" name="commNumber"/>
																		<input type="hidden" name="commDepart"/>
																		<input type="button" class="button0" value="公共通讯录"
																			onclick="addbookList('commId','destNumberObject','commNumber','commDepart');"
																			onmouseover="this.style.cursor='hand'">
																		<input type="hidden" name="IndivId"/>
																		<input type="hidden" name="IndivNumber"/>
																		<input type="hidden" name="IndivDepart"/>	
																		<input type="button" class="button0" value="个人通讯录"
																			onclick="addbooIndividualkList('IndivId','destNumberObject','IndivNumber','IndivDepart');"
																			onmouseover="this.style.cursor='hand'">
																	</td>
																</tr>
																<tr>
																	<td bgcolor="deeef8">
																		手机号码
																	</td>
																	<td bgcolor="f7f7f7" align="left">
																		<html:text styleClass="shuruk2"
																			property="destNumberPhone" size="60" maxlength="200" />
																	</td>
																</tr>
																<tr>
																	<td bgcolor="deeef8">
																		&nbsp;
																	</td>
																	<td bgcolor="f7f7f7" align="left">
																		<strong>(<font color="#FF0000">如</font> </strong>不通过通讯录选人可直接填写手机号码，多个号码之间以分号(
																		<strong><font color="ff0000">;</font> </strong>)分隔！谢谢!
																		<strong>)</strong>
																	</td>
																</tr>
																<tr>
																	<td bgcolor="deeef8">
																		发送时间
																	</td>
																	<td bgcolor="f7f7f7" align="left">
																		<input type="radio" name="informRightNow" value="true"
																			checked>
																		立即发送
																		<input type="radio" name="informRightNow"
																			value="false">
																		定时发送
																		<html:text styleClass="shuruk2"
																			property="scheduletime" onfocus="setday(this)"
																			readonly="true" style="cursor:hand" size="10"></html:text>
																		<html:select styleClass="shuruk2"
																			property="sendTime_hour">
																			<html:options collection="hhList" property="value"
																				labelProperty="label" />
																		</html:select>
																		<html:select styleClass="shuruk2" property="sendTime_minute">
																			<html:options collection="mmList" property="value"
																				labelProperty="label" />
																		</html:select>

																	</td>
																</tr>
																<TR bgcolor="f7f7f7">
																	<TD colspan=2>
																		<input type="checkbox" name="sdjb" value="checked"
																			onClick="displaylist('jb')">
																		手动发送预警信号(防汛信息服务网图标)
																	</td>
																</tr>
																<TR bgcolor="f7f7f7">
																	<TD colspan=2>
																		<div id="jb" style="display:none">
																			<table width="100%" border=0 cellpadding="0"
																				cellspacing="0">
																				<tr>
																					<td>
																				<tr>
																					<td>
																						<input type='checkbox' name='jbname' id='jbname1'
																							value='防汛防台蓝色图标'>
																						防汛防台蓝色图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname2'
																							value='防汛防台橙色图标'>
																						防汛防台橙色图标
																						<br>
																						<input type='checkbox' name='jbname' id='jbname3'
																							value='防汛防台黄色图标'>
																						防汛防台黄色图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname4'
																							value='防汛防台红色图标'>
																						防汛防台红色图标
																						<br>


																						<input type='hidden' name='url2' id='url2'
																							value='' size=20>

																						<input type='hidden' name='text2' id='text2'
																							value='受较强降水云团影响,未来6小时本市累计降雨量将达50mm。市防汛指挥部决定于15:45发布防汛防台黄色预警信号,请及时启动3级响应。'
																							size=20>

																					</td>
																					<td>
																						<input type='checkbox' name='jbname' id='jbname11'
																							value='水位蓝色图标'>
																						水位蓝色图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname12'
																							value='水位橙色图标'>
																						水位橙色图标
																						<br>
																						<input type='checkbox' name='jbname' id='jbname13'
																							value='水位黄色图标'>
																						水位黄色图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname14'
																							value='水位红色图标'>
																						水位红色图标
																						<br>

																						<input type='hidden' name='url3' id='url3'
																							value='' size=20>

																						<input type='hidden' name='text3' id='text3'
																							value='上海市防汛信息中心2007年10月8日15:00发布高潮位蓝色预警信号：受16号台风“罗莎”影响，预计10月9日00：05黄浦江苏州河口子潮潮位将达到4.75米，请各防汛有关部门、沿江相关单位做好应急准备。'
																							size=20>

																					</td>
																					<td>
																						<input type='checkbox' name='jbname' id='jbname21'
																							value='防汛防台蓝色解除图标'>
																						防汛防台蓝色解除图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname22'
																							value='防汛防台橙色解除图标'>
																						防汛防台橙色解除图标
																						<br>
																						<input type='checkbox' name='jbname' id='jbname23'
																							value='防汛防台黄色解除图标'>
																						防汛防台黄色解除图标
																						<br>

																						<input type='checkbox' name='jbname' id='jbname24'
																							value='防汛防台红色解除图标'>
																						防汛防台红色解除图标
																						<br>


																						<input type='hidden' name='url4' id='url4'
																							value='' size=20>

																						<input type='hidden' name='text4' id='text4'
																							value='本市降雨和雷暴已明显减弱,市防汛指挥部决定于17:35解除防汛防台黄色预警信号,请转入常态值班。'
																							size=20>
																					</td>
																				</tr>
																			</table>
																		</div>
																	</td>
																</tr>



																<tr>
																	<td colspan=2 align=center bgcolor="f7f7f7">
																		<p>
																			<html:submit styleClass="button0" value="提交"
																				onclick="return checkin();"></html:submit>
																			&nbsp; &nbsp;&nbsp;
																			<input class="button0" type="button" value="取消"
																				name="sss" onclick="clean_click()" />
																			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

																		</p>
																	</td>
																</tr>
																<TR bgcolor="f7f7f7">
																	<TD colspan=2>
																		<table width="100%" border=0 cellpadding="0"
																			cellspacing="0">
																			<tr>
																				<td>
																					<strong>使用短信接收服务和短信发送平台服务，将表示您对以下条款的承认和接受：</strong>
																					<br>
																					&nbsp;&nbsp;&nbsp;1、遵守中国有关法律法规的规定。
																					<br>
																					&nbsp;&nbsp;&nbsp;2、不利用服务作非法用途。
																					<br>
																					&nbsp;&nbsp;&nbsp;3、不干扰服务的正常进行。
																					<br>
																					&nbsp;&nbsp;&nbsp;4、遵守所有与使用服务有关的网络协议、规定、程序和惯例。
																					<br>
																					&nbsp;&nbsp;&nbsp;5、用户需对自己在上海市防汛信息中心短信平台上的行为承担法律责任。恪守保密纪律，不泄露内部信息。
																					<br>
																					&nbsp;&nbsp;&nbsp;6、用户承诺不散布和传播反动、色情或违法信息。不传输任何非法的、骚扰性的、中伤他人的、辱骂性
																					<br>
																					&nbsp;&nbsp;&nbsp;的、恐吓性的、伤害性的、庸俗的，淫秽等信息资料。
																					<br>
																				</td>

																			</tr>
																		</table>
																	</TD>
																</TR>
															</table>
														</td>
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
						<html:hidden property="chkCommId"></html:hidden>
						<html:hidden property="chkInduId"></html:hidden>
</td></tr></table>
						</html:form>
	</body>
</html>

