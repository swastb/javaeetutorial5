<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbMeetingroom" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List countYear = (List) request.getAttribute("countYear");
	String year = (String) request.getAttribute("year");
%>

<script type="text/javascript">
<!--
		function selectuser(flag,argDeptOrUser)
		{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=meetingedituser&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
			//window.open("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=meetingedit&deptOrUser="+argDeptOrUser+"&flag="+flag,"_blank");
		}
		
		function selectdept(flag,argDeptOrUser)
		{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=meetingeditdept&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		
		function returnlist()
		{
				
			window.location.replace("<%=path%>/meetingaction.do?method=list&action=thismonth");

		}
		
		function deletepresider()
		{
			document.all.presidername.value="";
			document.all.presider.value="";
			document.all.presideDept.value="";
		}
		
		function deleteparticipant()
		{
			document.all.participantname.value="";
			document.all.participant.value="";
			document.all.participantDept.value="";
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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">

		<script src="<%=path%>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-zh.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-setup.js"></script>
		<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>

	</head>

	<%
	List meetingRoom = (List) request.getAttribute("meetingRoom");
	%>

	<body>
		<html:form action="/meetingaction.do">
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
									会议管理
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
											<th width="94%" height="30" align="right" valign="bottom">
												<img src="<%=path%>/images/fh.gif" width="46" height="25"
													border="0" onclick="returnlist()"
													onmouseover="this.style.cursor='hand'" />
											</th>
											<th width="6%" valign="bottom"></th>
										</tr>

										<tr>
											<td colspan="2" align="center" valign="top">
												<table width="99%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in">
													<tr>
														<td nowrap width="80" height="25">
															会议编号
														</td>
														<td colspan="2">
															<%
															if (year != null && countYear != null) {
															%>
															<input
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																type="text" maxlength="100" name="meetingSn"
																value="[<%=year%>]<%=countYear.size() + 1%>号"
																onkeydown="notNull();" onblur="chk();" readonly />
															<%
															} else {
															%>
															<html:text property="meetingSn" maxlength="100"
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																onkeydown="notNull();" onblur="chk();" readonly="true"></html:text>
															<%
															}
															%>

															<font color="red"> <span id="fmeetingSn"></span> </font>
														</td>
													</tr>
													<tr>
														<td nowrap width="80" height="25">
															会议标题
														</td>
														<td colspan="2">
															<html:text property="title" maxlength="100"
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																onkeydown="notNull();" onblur="chk();"></html:text>
															<font color="red">*</font>
															<font color="red"> <span id="ftitle"></span> </font>
														</td>

													</tr>
													<tr>
														<td nowrap width="80" height="25">
															开始时间
														</td>
														<td colspan="2">
															<html:text property="startTime"
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																onblur="chk();" onfocus="setday(this)" readonly="false" />
															<font color="red">*</font>
															<font color="red"> <span id="fstartTime"></span> </font>
														</td>
													</tr>
													<tr>
														<td nowrap width="80" height="25">
															结束时间
														</td>
														<td colspan="2">
															<html:text property="endTime"
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																onblur="chk();" onfocus="setday(this)" readonly="false" />
															<font color="red">*</font>
															<font color="red"> <span id="fendTime"></span> </font>
														</td>

													</tr>
													<tr>
														<td nowrap width="80" height="25">
															会议室
														</td>
														<td colspan="2">
															<html:select property="meetingroom" onblur="chk();">
																<%
																		if (meetingRoom != null) {
																		for (int i = 0; i < meetingRoom.size(); i++) {
																			TbMeetingroom room = (TbMeetingroom) meetingRoom.get(i);
																%>
																<html:option value="<%=room.getId()%>">
																	<%=room.getRoomName()%>
																</html:option>
																<%
																	}
																	}
																%>
															</html:select>
															<font color="red"> <span id="fmeetingroom"></span>
															</font>
														</td>

													</tr>

													<tr>
														<td nowrap width="80" height="25">
															费用预算
														</td>
														<td colspan="2">
															<html:text property="fee" maxlength="10"
																style="color: 4c6a95;text-indent: 1pt;height: 18px;width: 88.5%;border: 1px solid #a5a5a5;"
																onkeydown="onlyNum();" onblur="chk();"></html:text>
															<font color="red"> <span id="ffee"></span> </font>
														</td>

													</tr>

													<tr>
														<td nowrap width="80">
															召集人
														</td>
														<td width="500">
															<html:text property="presidername" size="50"
																styleClass="shuruk2" readonly="true"></html:text>
														</td>
														<td class="bg-zwbt">
															<html:hidden property="presider" />
															<html:hidden property="presideDept" />
															<table align="center" width="90%" border="0"
																cellpadding="0" cellspacing="0" bordercolor="97cdda"
																class="tableborder">
																<tr>
																	<td>
																		<a onclick="selectuser('presider','user');"
																			title="选择人员" onmouseover="this.style.cursor='hand'">
																			<img src="<%=path%>/imagine/xz.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
																<tr>
																	<td>
																		<a onclick="selectdept('presider','dept');"
																			title="选择部门" onmouseover="this.style.cursor='hand'">
																			<img src="<%=path%>/imagine/z1.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
																<tr>
																	<td>
																		<a onclick="deletepresider();" title="清空"
																			onmouseover="this.style.cursor='hand'"> <img
																				src="<%=path%>/imagine/z3.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
															</table>
															<font color="red"> <span id="fpresidername"></span>
															</font>
														</td>
													</tr>

													<tr>
														<td nowrap width="80">
															参加人员
														</td>
														<td width="500">
															<html:textarea property="participantname"
																styleClass="shuruk2" readonly="true" cols="60" rows="5"></html:textarea>
														</td>
														<td class="bg-zwbt">
															<html:hidden property="participant" />
															<html:hidden property="participantDept" />
															<table align="center" width="90%" border="0"
																cellpadding="0" cellspacing="0" bordercolor="97cdda"
																class="tableborder">
																<tr>
																	<td>
																		<a onclick="selectuser('participant','user');"
																			title="选择人员" onmouseover="this.style.cursor='hand'">
																			<img src="<%=path%>/imagine/xz.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
																<tr>
																	<td>
																		<a onclick="selectdept('participant','dept');"
																			title="选择部门" onmouseover="this.style.cursor='hand'">
																			<img src="<%=path%>/imagine/z1.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
																<tr>
																	<td>
																		<a onclick="deleteparticipant();" title="清空"
																			onmouseover="this.style.cursor='hand'"> <img
																				src="<%=path%>/imagine/z3.gif" width="85"
																				height="20"> </a>
																	</td>
																</tr>
															</table>
															<font color="red"> <span id="fparticipantname"></span>
															</font>
														</td>

													</tr>

													<tr>
														<td nowrap width="80" height="25">
															重要级别
														</td>
														<td colspan="2">
															<html:select property="lvl" onblur="chk();">
																<html:option value="1" />
																<html:option value="2" />
																<html:option value="3" />
																<html:option value="4" />
																<html:option value="5" />
															</html:select>
															<font color="red"> <span id="flvl"></span> </font>
														</td>

													</tr>

													<tr>
														<td nowrap width="80">
															议题
														</td>
														<td colspan="2">
															<html:textarea property="topic" styleClass="shuruk2"
																cols="60" rows="3" onkeydown="notNull();"
																onblur="chk();"></html:textarea>
															<font color="red">*</font>
															<font color="red"> <span id="ftopic"></span> </font>
														</td>

													</tr>

													<tr>
														<td nowrap width="80">
															备注
														</td>
														<td colspan="2">
															<html:textarea property="rem" styleClass="shuruk2"
																cols="60" rows="5" onkeydown="notNull();"></html:textarea>
															<font color="red"> <span id="frem"></span> </font>
														</td>

													</tr>
													<tr>
														<td colspan="4" align="center">
															<html:checkbox property="schedule" value="1" />
															添加到日程管理 &nbsp;&nbsp;
															<a onclick="CheckForm();"
																onmouseover="this.style.cursor='hand'"><img
																	src="<%=path%>/imagine/tj.gif" width="52" height="23">
															</a>&nbsp;&nbsp;
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td height="20" colspan="2"></td>
										</tr>

									</table>
								</td>
							</tr>
							<tr>
								<td height="10"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<html:hidden property="id" />

		</html:form>
	</body>
</html>

<script type="text/javascript">
		function chk()
		{
		    var meetingSn = document.getElementById("meetingSn").value;
		    var title = document.getElementById("title").value;
		    var startTime = document.getElementById("startTime").value;
		    var endTime = document.getElementById("endTime").value;
		    var meetingroom = document.getElementById("meetingroom").value;
		    var fee = document.getElementById("fee").value;
		    var presidername = document.getElementById("presidername").value;
		    var participantname = document.getElementById("participantname").value;
		    var lvl = document.getElementById("lvl").value;
		    var topic = document.getElementById("topic").value;
		    var rem = document.getElementById("rem").value;
			var validateDate =  /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2})$/;
		
			if(meetingSn == "")
			{
				document.getElementById("fmeetingSn").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("meetingSn").focus();
				return false;	
				
			}
			else
			{
				    if(getLen(document.getElementById("meetingSn").value) > 100)
				    {
					document.getElementById("fmeetingSn").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("meetingSn").focus();
					return false;	
								
					}
					else
					{
						document.getElementById("fmeetingSn").innerHTML = "";
					}
			}

			if(title == "")
			{
				document.getElementById("ftitle").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("title").focus();
				return false;	
				
			}
			else
			{
				    if(getLen(document.getElementById("title").value) > 100)
				    {
					document.getElementById("ftitle").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("title").focus();
					return false;	
								
					}
					else
					{
						document.getElementById("ftitle").innerHTML = "";
					}
			}
		
			if(startTime == "")
			{
				document.getElementById("fstartTime").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				return false;	
				
			}
			else
			{
				if(!validateDate.test(startTime)) 
				{ 
					document.getElementById("fstartTime").innerHTML = "抱歉，“开始时间”格式不正确！正确的填写格式如：1985-03-24 16:40"; 
					return false; 
				} else {
					document.getElementById("fstartTime").innerHTML = "";
				}
			}

			if(endTime == "")
			{
				document.getElementById("fendTime").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("endTime").focus();
				return false;	
				
			}
			else
			{
				if(!validateDate.test(endTime)) 
				{ 
					document.getElementById("fendTime").innerHTML = "抱歉，“结束时间”格式不正确！正确的填写格式如：1985-03-24 16:40"; 
					return false; 
				} else {
					document.getElementById("fendTime").innerHTML = "";
				}
			}


			if(meetingroom == "")
			{
				document.getElementById("fmeetingroom").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("meetingroom").focus();
				return false;	
				
			}
			else
			{
				document.getElementById("fmeetingroom").innerHTML = "";
			}


			if(lvl == "")
			{
				document.getElementById("flvl").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("lvl").focus();
				return false;	
				
			}
			else
			{
				document.getElementById("flvl").innerHTML = "";
			}

			if(getLen(document.getElementById("fee").value) > 10)
			{
				document.getElementById("ffee").innerHTML = "<font color='red'>"+"数字长度不得大于10"+"</font>";
				//document.getElementById("fee").focus();
				return false;				
			}
			else
			{
				document.getElementById("ffee").innerHTML = "";
			}

			if(presidername == "")
			{
				document.getElementById("fpresidername").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				return false;	
				
			}
			else
			{
				document.getElementById("fpresidername").innerHTML = "";
			}


			if(participantname == "")
			{
				document.getElementById("fparticipantname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				return false;	
				
			}else
			{
				document.getElementById("fparticipantname").innerHTML = "";
			}


				if(topic == ""){
				document.getElementById("ftopic").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("topic").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("topic").value) > 1000){
					document.getElementById("ftopic").innerHTML = "<font color='red'>"+"长度不能大于1000个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("topic").focus();
					return false;	
								
				}
else{document.getElementById("ftopic").innerHTML = "";}
}


					 if(getLen(document.getElementById("rem").value) > 1000){
					document.getElementById("frem").innerHTML = "<font color='red'>"+"长度不能大于1000个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("rem").focus();
					return false;	
								
				}
else{document.getElementById("frem").innerHTML = "";}

}
		
			function CheckForm()
			{
			 var meetingSn = document.getElementById("meetingSn").value;
		    var title = document.getElementById("title").value;
		    var startTime = document.getElementById("startTime").value;
		    var endTime = document.getElementById("endTime").value;
		    var meetingroom = document.getElementById("meetingroom").value;
		    //var fee = document.getElementById("fee").value;
		    var presidername = document.getElementById("presidername").value;
		    var participantname = document.getElementById("participantname").value;
		    var lvl = document.getElementById("lvl").value;
		    var topic = document.getElementById("topic").value;
		    var rem = document.getElementById("rem").value;
		    
		    if(meetingSn == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("meetingSn").value) > 100){alert("字符输入过长"); return false;}
			
			if(title == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("title").value) > 100){alert("字符输入过长"); return false;}
			
			if(startTime == ""){alert("数据输入不完整"); return false;}
			if(endTime == ""){alert("数据输入不完整"); return false;}
			if(meetingroom == ""){alert("数据输入不完整"); return false;}
			//if(fee == ""){alert("数据输入不完整"); return false;}
            if(lvl == ""){alert("数据输入不完整"); return false;}
            
			if(presidername == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("presider").value) > 32){alert("只能选择一个主持人"); return false;}
			
			if(participantname == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("participant").value) > 4000){alert("字符输入过长"); return false;}
			
			if(topic == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("topic").value) > 1000){alert("字符输入过长"); return false;}
			
			if(getLen(document.getElementById("rem").value) > 1000){alert("字符输入过长"); return false;}
		
			
				if(document.all.id.value=='')
				{
					document.all.method.value='add';
				}
				else
				{
					document.all.method.value='modify';
				}
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
			}	
			
			function onlyNum() 
				{ 
				if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 
				if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105))) 
				event.returnValue=false; 
				} 

		</script>
