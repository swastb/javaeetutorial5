<%@ page language="java" import="java.util.*,com.baosight.mode.TbUser" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	TbUser user = (TbUser)session.getAttribute("SYSTEM_USER_SESSION");
	String success = (String)request.getAttribute("success");
			
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改密码</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script src="../../../../javascript/validate.js"></script>
		<script type='text/javascript' src='<%=strpath%>/dwr/interface/infocomm.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	</head>
	
	<body>
		<html:form action="/userpwdaction.do?method=passwdModDo">
			<%--<table width="100%" border="0" cellpadding="0" cellspacing="0"
				bordercolor="97cdda" class="tableborder" align="center">
				<tr>
					<td align="center" colspans="2">
        				<span><font><b>密码修改</b></font></span>
					</td>
				</tr>
			</table>
			--%>
			<%if ("true".equals(success)) {%>
			<table width="100%" cellpadding="0" cellspacing="0"
				class="tableborder" align="center">
				<tr><td align="center">密码修改成功！</td></tr>
			</table>
			<%}else {%>
			<table width="100%" border="2" cellpadding="0" cellspacing="0"
				class="tableborder" align="center">
				<tr>
			    		<td width="20%" height="22"align="center" class="bg-zwbt">旧密码</td>
			    		<td colspan="1"><input type="password" id="oldpwd" class="shuruk2" onkeydown="notNull();" onblur="chk();" maxlength="10"/>
			    		<font color="red">
    		            <span id="foldpwd"></span>
    		            </font>
			    		</td>
			    </tr>
			    <tr>
			    		<td width="20%" height="22" align="center" class="bg-zwbt">新密码</td>
			    		<td colspan="1"><input type="password" name="newpwd1" id="newpwd1" class="shuruk2" onkeydown="notNull();" onblur="chk();" maxlength="10"/>
			    		<font color="red">
    		            <span id="fnewpwd1"></span>
    		            </font>
			    		</td>
			    		
			    </tr>
			    <tr>
			    		<td width="20%" height="22" align="center" class="bg-zwbt">新密码确认</td>
			    		<td colspan="1"><input type="password" name="newpwd2" id="newpwd2" class="shuruk2" onkeydown="notNull();" onblur="chk();" maxlength="10"/>
			    		<font color="red">
    		            <span id="fnewpwd2"></span>
    		            </font>
			    		</td>
			    		
			    </tr>
					<tr>
							<td colspan="3" align="center">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
						</td>
					</tr>
			</table>
			<%}%>
			<input type="hidden" name="newpwd" />
		</html:form>
	</body>
</html>
<script  language="javascript">
function chk(){
		var oldpwd = document.getElementById("oldpwd").value;
		var newpwd1 = document.getElementById("newpwd1").value;
		var newpwd2 = document.getElementById("newpwd2").value;
		var notNull = "*不能为空";
		var tooLenMsg = "长度不能大于10个字符,中文占2个字符,数字&字母占1个字符";
		var oldPWIsFalse = "旧密码输入不对";
		var twiceIsDiffer = "新密码确认错误";
		 //disabled="disabled"
		if(oldpwd == ""){
			document.getElementById("foldpwd").innerHTML = "<font color='red' size='2pt'>"+notNull+"</font>";
			return false;
		}else if(getLen(oldpwd) > 10){
			document.getElementById("foldpwd").innerHTML = "<font color='red' size='2pt'>"+tooLenMsg+"</font>";	
			return false;	
		}
		 else if ("<%=user.getPwd()%>"!=oldpwd){
			document.getElementById("foldpwd").innerHTML = "<font color='red' size='2pt'>"+oldPWIsFalse+"</font>";
			return false;
		}else if ("<%=user.getPwd()%>"==oldpwd) {
			document.getElementById("foldpwd").innerHTML = "";
		if(newpwd1 == ""){
			document.getElementById("fnewpwd1").innerHTML = "<font color='red' size='2pt'>"+notNull+"</font>";
			return false;	
				
		}else if(getLen(newpwd1) > 10){
			document.getElementById("fnewpwd1").innerHTML = "<font color='red' size='2pt'>"+tooLenMsg+"</font>";
			return false;	
		}else if (newpwd1!="" && getLen(newpwd1) <= 10) {
			document.getElementById("fnewpwd1").innerHTML = "";
		if(newpwd2 == ""){
			document.getElementById("fnewpwd2").innerHTML = "<font color='red' size='2pt'>"+notNull+"</font>";
			return false;	
				
		}else if(getLen(newpwd2) > 10){
			document.getElementById("fnewpwd2").innerHTML = "<font color='red' size='2pt'>"+tooLenMsg+"</font>";		
			return false;
		}else if (newpwd2!="" && getLen(newpwd2) <= 10) {
			document.getElementById("fnewpwd2").innerHTML = "";
		if (newpwd1!=newpwd2) {
			document.getElementById("fnewpwd2").innerHTML = "";
			document.getElementById("fnewpwd2").innerHTML = "<font color='red' size='2pt'>"+twiceIsDiffer+"</font>";		
			return false;
		}
		else {
			document.getElementById("foldpwd").innerHTML = "";
			document.getElementById("fnewpwd1").innerHTML = "";
			document.getElementById("fnewpwd2").innerHTML = "";
			return true;
		}
		}
		}
		}
}

function CheckForm(){
	if(chk()) {
		document.getElementById("newpwd").value=document.getElementById("newpwd2").value;
		document.forms[0].submit();
		return  true;
	} else return false;
				
}		

</script>


