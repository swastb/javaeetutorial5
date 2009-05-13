<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

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




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'pstlvledit.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script type='text/javascript'
			src='<%=path%>/dwr/interface/checkCode.js'></script>
		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	</head>

	<body>
		<html:form action="/allappSys.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">应用系统管理</td>
            </tr>
          </table></td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnl();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
																	<td nowrap width="100" height="25" align="left">
																		应用系统名称
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:text property="name" styleClass="shuruk2"
																			maxlength="100" onkeydown="notNull();"
																			onblur="chk();"></html:text>
																		<font color="red">*</font>
																		<%
																		} else {
																		%>
																		<html:text property="name" styleClass="shuruk2"
																			onkeydown="notNull();" onblur="chk();"
																			readonly="true"></html:text>
																		<font color="red">*</font>
																		<%
																		}
																		%>
																		<span id="fname"></span>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" height="25" align="left">
																		应用系统URL
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:text property="url" styleClass="shuruk2"
																			maxlength="100" onkeydown="notNull();"
																			onblur="chk();"></html:text>
																		<font color="red">*</font>
																		<%
																		} else {
																		%>
																		<html:text property="url" styleClass="shuruk2"
																			onkeydown="notNull();" onblur="chk();"
																			readonly="true"></html:text>
																		<font color="red">*</font>
																		<%
																		}
																		%>
																		<span id="furl"></span>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" height="25" align="left">
																		代码
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:text property="code" styleClass="shuruk2"
																			maxlength="32" onkeydown="notNull();"
																			onblur="chk(),sendMessage();"></html:text>
																		<font color="red">*</font>
																		<%
																		} else {
																		%>
																		<html:text property="code" styleClass="shuruk2"
																			onkeydown="notNull();" onblur="chk(),sendMessage();"
																			readonly="true"></html:text>
																		<font color="red">*</font>
																		<%
																		}
																		%>
																		<font color="red"> <span id="fcode"></span> <span
																			id="sendMessage"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" height="25" align="left">
																		是否为子系统
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:radio property="ischild" value="1">是</html:radio>
																		<html:radio property="ischild" value="0">否</html:radio>
																		<%
																		} else {
																		%>
																		<html:radio property="ischild" value="1"
																			disabled="true">是</html:radio>
																		<html:radio property="ischild" value="0"
																			disabled="true">否</html:radio>
																		<%
																		}
																		%>

																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" height="25" align="left">
																		是否启用
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:radio property="insure" value="1">是</html:radio>
																		<html:radio property="insure" value="0">否</html:radio>
																		<%
																		} else {
																		%>
																		<html:radio property="insure" value="1"
																			disabled="true">是</html:radio>
																		<html:radio property="insure" value="0"
																			disabled="true">否</html:radio>
																		<%
																		}
																		%>

																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
																		备注
																	</td>
																	<td colspan="2">
																		<html:textarea property="rem" styleClass="shuruk2"
																			cols="75" rows="12" onblur="chk();"></html:textarea>
																		<span id="frem"></span>
																	</td>
																</tr>
																<tr>
																	<td colspan="3" align="center">
																		<a onclick="CheckForm();"
																			onmouseover="this.style.cursor='hand'"><img
																				src="<%=path%>/imagine/tj.gif" width="52"
																				height="23">
																		</a>&nbsp;&nbsp;
																	</td>
					</tr>
				 </table></td>
                </tr>
                <tr>
                  <td height="20" colspan="2"></td>
                </tr>
                
              </table></td>
            </tr>
            <tr>
              <td height="10"></td>
            </tr>
          </table></td>
        </tr>
      </table>
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path%>" />
			<html:hidden property="id" />
		</html:form>
	</body>
</html>

<script type="text/javascript">

			function chk(){
		    var name = document.getElementById("name").value;
		    var url = document.getElementById("url").value;
		    var code = document.getElementById("code").value;
		    var rem = document.getElementById("rem").value;
			if(name == ""){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("name").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("name").value) > 100){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("name").focus();
					return false;	
								
				}
else{document.getElementById("fname").innerHTML = "";}
}
					   
			if(url == ""){
		
				document.getElementById("furl").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("url").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("url").value) > 100){
					document.getElementById("furl").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("url").focus();
					return false;	
								
				}
				else{document.getElementById("furl").innerHTML = "";}
			}		   
					   
		 
			if(code == ""){
		
				document.getElementById("fcode").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("code").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("code").value) > 32){
					document.getElementById("fcode").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("code").focus();
					return false;	
								
				}
				else{document.getElementById("fcode").innerHTML = "";}
			}	
			

			
			   			
			if(getLen(document.getElementById("rem").value) > 200){
					document.getElementById("frem").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("rem").focus();
					return false;	
								
				}
				else{document.getElementById("frem").innerHTML = "";}
			}
			
			
			
			function CheckForm(){
			//alert("insure="+DWRUtil.getValue('insure')+"\n"+"ischild="+DWRUtil.getValue('ischild'));
			var name = document.getElementById("name").value;
		    var url = document.getElementById("url").value;
		    var code = document.getElementById("code").value;
		    var rem = document.getElementById("rem").value;
			if(name == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("name").value) >100){alert("字符输入过长"); return false;}
			if(url == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("url").value) >100){alert("字符输入过长"); return false;}
			if(code == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("code").value) >32){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("rem").value) >200){alert("字符输入过长"); return false;}
			
						sendMessage();
           
            if(this.sendMessageflag=="false"){alert("不能重复"); return false;}
            
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modify'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}

				function returnl(){
				
				var pah=document.getElementById("path").value;

				window.location.replace(pah+"/allappSys.do?method=list");

				}
				
			
			</script>
