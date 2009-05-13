<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="commons.jsp"%>
<%
			String loginFlag = (request.getAttribute("loginFlag") != null) ? ((String) request
			.getAttribute("loginFlag"))
			: ("");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>上海市水务局单点登录系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="windows-Target" contect="_top">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<meta http-equiv="Content-Language" content="zh-cn" />
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<base target="_self" />
		<title>XX系统</title>
		<link href="<%=basePath%>/css/style_01.css" rel="stylesheet"
			type="text/css" />
		<script language="JavaScript" src='<%=basePath%>/javascript/tools.js'
			type="text/javascript"></script>
		<script language="JavaScript" src='<%=basePath%>/javascript/cookie.js'
			type="text/javascript"></script>

		<SCRIPT LANGUAGE="JavaScript">   
		  		if   (top.frames.length!=0)   top.location=self.document.location;   
		  </SCRIPT>
		<script language="JavaScript" type="text/JavaScript">
<!--



function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
		<script language="javascript" type="text/javascript">
<!--记住用户名和密码的功能
//登录
function setCookies()
{
	var today = new Date();
	var expireday = new Date();
	expireday.setTime( today.getTime() + 24*60*60*1000 );

	oForm = document.forms.form1;
	if ( oForm.loginUser.value!="" ){
		// set cookie
		var oName = document.forms.form1.restoreName;
		var oPassword = document.forms.form1.restorePassword;

		if ( oName.checked )
		{
			new Cookie( document, "toRestoreName" ).set( true, expireday );
			new Cookie( document, "loginUser" ).set( document.forms.form1.loginUser.value, expireday );
		} else {
			new Cookie( document, "toRestoreName" ).set( false, expireday );
			new Cookie( document, "loginUser" ).set( "", expireday );
		}
		if ( oPassword.checked )
		{
			new Cookie( document, "toRestorePassword" ).set( true, expireday );
			new Cookie( document, "password" ).set( document.forms.form1.password.value, expireday );
		} else {
			new Cookie( document, "toRestorePassword" ).set( false, expireday );
			new Cookie( document, "password" ).set( "", expireday );
		}
	}
}

//先选择记住用户名时，记住密码框才显示可选
function setCheckbox()
{
	document.forms.form1.restorePassword.disabled = document.forms.form1.restoreName.checked ? false : true;
}

// 恢复cookie
function restoreCookie()
{
	var toRestoreName = new Cookie( document, "toRestoreName" ).get();
	var loginName = new Cookie( document, "loginUser" ).get();
	var toRestorePassword = new Cookie( document, "toRestorePassword" ).get();
	var loginPassword = new Cookie( document, "password" ).get();
	var focusObj = "loginUser";
	var oForm = document.forms.form1;

	if ( toRestoreName=="true" )
	{
		oForm.restoreName.checked = true;
		if ( loginName!=null )
		{
			oForm.loginUser.value = loginName;
			focusObj = "password";
		}
		if ( toRestorePassword=="true" )
		{
			oForm.restorePassword.checked = true;
			if ( loginPassword!=null ) oForm.password.value = loginPassword;
		}
	}
	document.forms.form1[ focusObj ].focus();
	setCheckbox();
}

//初始化
function init()
{
	// take cookies
	//restoreCookie();
}
function submit1(){
	var frm = document.forms[0];
	var goto = document.getElementById("goto").value;
	frm.action = frm.action+"?goto="+goto;
	//alert(frm.action);
	frm.submit();
}
//-->
</script>

		<style type="text/css">
<!--
body {
	text-align:center;
}
.style1 {color: #000000}
input {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	line-height: normal;
	font-weight: normal;
	font-variant: normal;

	text-decoration: none;
	background-attachment: fixed;
	
	background-repeat: no-repeat;
	height: 16px;
	
}
-->
</style>
	</head>
	<body onload="init();form1.loginUser.focus();" scroll="auto">
		<input type="hidden" name="goto" id="goto"
			value="<%=request.getParameter("goto")%>">
		<form name="form1" action="login.do" method="post"
			component="com.browsesoft.htmlcomponent.HTMLFormComponent"
			model="com.browsesoft.LoginModel">
			<div id="Layer1"
				style="position:absolute; left:103px; top:419px; width:392px; height:128px; z-index:0; overflow: visible;">
				<table width="100%" border="0">
					<tr>
						<td width="33%" height="55" nowrap="nowrap">
							<table width="111" border="0" align="center">
								<tr>
									<td colspan="2">
										<%
												if (loginFlag != null) {
												if ("nameOrcodeError".equals(loginFlag)) {
										%>
										<font color="red" size="-1">提示：您输入的用户名或密码错误！</font>
										<%
												}
												if ("NoRight".equals(loginFlag)) {
										%>
										<font color="red" size="-1">提示：您不是管理员，无权限登录！</font>
										<%
												}
												if ("timeout".equals(loginFlag)) {
										%>
										<font color="red" size="-1">提示：session超时或者访问无效请重新登陆！</font>
										<%
											}

											}
										%>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<img src="<%=basePath%>/imagine/login_name.gif" width="70"
											height="13" />
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<%--
										<input name="loginUser" type="text"
											style="border:1 groove #3366cc"
											onkeydown="setCookies();thisPageSubmit(document.form1)"
											size="20" notnull="notnull" autocomplete="on" />
									--%>
										<input name="loginUser" type="text" value=""
											style="border:1 groove #3366cc" size="20"
											onkeypress="javascript:if(event.keyCode==13){submit1();}" />
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<img src="<%=basePath%>/imagine/login_passworld.gif" width="94"
											height="13" />
									</td>
								</tr>
								<tr>
									<td height="20" colspan="2">
										<%--
										<input name="password" type="password" 
											style="border:1 groove #3366cc"
											onkeydown="setCookies();thisPageSubmit(document.form1)"
											size="20" notnull="notnull" />
									--%>
										<input name="password" type="password" value="admin"
											style="border:1 groove #3366cc" size="20"
											onkeypress="javascript:if(event.keyCode==13){submit1();}" />
									</td>
								</tr>

								<tr>
									<td height="24" colspan="2">
										<div align="center">
											<img src="<%=basePath%>/imagine/loginsubmita.gif"
												name="imageField" border="0" align="middle" class="hand"
												id="imageField" onclick='submit1();'
												onmouseover="this.src='<%=basePath%>/imagine/loginsubmitb.gif'"
												onmouseout="this.src='<%=basePath%>/imagine/loginsubmita.gif'"
												type="image" />
										</div>
									</td>
								</tr>

							</table>
						</td>

						<td width="67%" valign="top" nowrap="nowrap">
							<%--
							<table border="0" cellpadding="0" cellspacing="0"
								class="normal_text">
								<tr>
									<td height="20">
										&nbsp;
									</td>
								</tr>
								<tr>
									<td height="21">
										<input type="checkbox" name="restoreName" id="ID_restoreName"
											onclick="setCheckbox();"
											onkeydown="setCookies();thisPageSubmit(document.form1)" />
										<label for="ID_restoreName" class="e2_type">
											记住用户名
										</label>
									</td>
								</tr>
								<tr>
									<td height="5"></td>
								</tr>
								<tr>
									<td height="22">
										<input type="checkbox" name="restorePassword"
											id="ID_restorePassword"
											onkeydown="setCookies();thisPageSubmit(document.form1);" />
										<label for="ID_restorePassword" class="e2_type">
											记住密码
										</label>
									</td>
								</tr>
							</table>
						--%>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<!--object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="1024" height="720"-->
		<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			codebase="../swflash.cab#version=9,0,28,0" width="100%" height="100%">
			<param name="movie" value="<%=basePath%>/imagine/login.swf" />
			<param name="quality" value="high" />
			<param name="wmode" value="transparent" />
			<param name="wmode" value="opaque" />
			<embed src="<%=basePath%>/imagine/login.swf" width="1024" height="720"
				quality="high"
				pluginspage="http://www.macromedia.com/go/getflashplayer"
				type="application/x-shockwave-flash" scale="noborder"></embed>
		</object>
	</body>
</html>
