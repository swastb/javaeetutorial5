<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!-- 引入ajax验证 -->
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
		<script src="../../../../javascript/validate.js"></script>
		<script type='text/javascript'
			src='<%=strpath%>/dwr/interface/righttype.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>

		<script type="text/javascript"><!--
  
		  	var http_request;
		
		  	function createXMLHttpRequest(){
			  	if(window.XMLHttpRequest) {
					http_request = new XMLHttpRequest();
					if (http_request.overrideMimeType) {
						http_request.overrideMimeType("text/xml");
					}
				}
				else if (window.ActiveXObject) { 	
					try {
						http_request = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							http_request = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {}
					}
				}
		  	}
  	
		  	function startRequest(sysId,flag){	
				var path = document.getElementById("path").value; 		  	
				var url="";					
				if(flag=="1"){
					url = path+"/righttypeaction.do?method=getFunction&sysId="+sysId;
				}	
			  	createXMLHttpRequest();
			  	http_request.onreadystatechange = handlestatechange
			  	http_request.open("post",url,true);
			  	http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			  	http_request.send(null);					  		
		  	}
  	
		  	function handlestatechange(){
		  		if (http_request.readyState==4){
		  			if (http_request.status==200){				
		  				initOptions(http_request.responseXML);				
		  			}
		  		}
		  	}
			function initOptions(xmlDoc) {
				var initS1 = document.getElementById("funid");
				for (var j = initS1.options.length; j > 0; j--) {
					initS1.removeChild(initS1.options[j - 1]);
				}
				var currentElement = null;
				var tmp = xmlDoc.getElementsByTagName("function");
				for (var i = 0; i < tmp.length; i++) {
					currentElement = document.createElement("option");
					var value = tmp[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
					var text = tmp[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
					currentElement.setAttribute("value", value);
					var txtInfo = document.createTextNode(text);
					currentElement.appendChild(txtInfo);
					initS1.appendChild(currentElement);
				}
			}			
		</script>
	</head>

	<body>
		<input id="path" type="hidden" value="<%=request.getContextPath()%>">
		<html:form action="/righttypeaction.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">权限类型管理</td>
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
																	<td nowrap width="100" align="left">
																		权限类型名称
																	</td>
																	<td colspan="2">
																		<html:text property="name" maxlength="100"
																			styleClass="shuruk2" onkeydown="notNull();"
																			onblur="chk();"></html:text>
																		<font color="red">*</font>
																		<font color="red"> <span id="fname"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
																		权限类型代码
																	</td>
																	<td colspan="2">
																		<%
																		if (flag) {
																		%>
																		<html:text property="code" maxlength="10"
																			styleClass="shuruk2" onkeydown="onlyNum();"
																			onblur="chk(),rightTypeCodeCheck();"></html:text>
																		<font color="red">*</font>

																		<%
																		} else {
																		%>
																		<html:text property="code" styleClass="shuruk2"
																			readonly="true"></html:text>
																		<font color="red">*</font>
																		<%
																		}
																		%>

																		<font color="red"> <span id="fcode"></span> <span
																			id="rightTypeCodeCheck"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
																		所属应用系统
																	</td>
																	<td colspan="2">
																		<html:select property="appsysid"
																			onchange="startRequest(this.value,1);"
																			value="${item.appsysid}" onblur="chk();"
																			disabled="disabled">
																			<c:forEach var="appsys" items="${appSysList}"
																				varStatus="loop">
																				<html:option value="${appsys.id}">${appsys.name}</html:option>
																			</c:forEach>
																		</html:select>
																		<font color="red"> <span id="fappsysid"></span>
																			<font color="red"></font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
																		所属资源
																	</td>
																	<td colspan="2">
																		<html:select property="funid" value="${item.funid}"
																			onblur="chk();">
																			<c:forEach var="fun" items="${firFunList}"
																				varStatus="loop">
																				<html:option value="${fun.id}">${fun.name}</html:option>
																			</c:forEach>
																		</html:select>
																		<font color="red">*</font>
																		<font color="red"> <span id="ffunid"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
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
																	<td colspan="3" align="center">
																		<a onclick="CheckForm();"
																			onmouseover="this.style.cursor='hand'"><img
																				src="<%=path%>/imagine/tj.gif" width="52"
																				height="23">
																		</a>&nbsp;&nbsp;
																	</td>
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
										<tr>
											<td height="10"></td>
										</tr>
									</table>
								</td>
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

			function chk(){
		    var name = document.getElementById("name").value;
		    var code = document.getElementById("code").value;
		    var appsysid = document.getElementById("appsysid").value;
		    var funid = document.getElementById("funid").value;
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


			if(code == ""){
		
				document.getElementById("fcode").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("code").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("code").value) > 10){
					document.getElementById("fcode").innerHTML = "<font color='red'>"+"长度不能大于10个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("code").focus();
					return false;	
								
				}
				else{document.getElementById("fcode").innerHTML = "";}
				}
				

					   
			if(appsysid == ""){
		
				document.getElementById("fappsysid").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("appsysid").focus();
				return false;	
				
			}
				else{document.getElementById("fappsysid").innerHTML = "";}
					   
					   

			
			if(funid == ""){
		
				document.getElementById("ffunid").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("funid").focus();
				return false;	
				
			}
				else{document.getElementById("ffunid").innerHTML = "";}
			
			}
			
			
			
			function CheckForm(){
			var name = document.getElementById("name").value;
		    var code = document.getElementById("code").value;
		    var appsysid = document.getElementById("appsysid").value;
		    var funid = document.getElementById("funid").value;
			if(name == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("name").value) >100){alert("字符输入过长"); return false;}
			if(code == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("code").value) >10){alert("字符输入过长"); return false;}
			if(appsysid == ""){alert("下拉列表不完整"); return false;}
			if(funid == ""){alert("下拉列表不完整"); return false;}
			
			rightTypeCodeCheck();
           
            if(this.rightTypeCodeflag=="false"){alert("不能重复"); return false;}
			
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modify'};
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
		function returnl(){
		
			var appsysid = document.getElementById("appsysid").value;
		    var funid = document.getElementById("funid").value;
	
				var pah=document.getElementById("path").value;


				window.location.replace(pah+"/righttypeaction.do?method=list&action=list&strappsysID="+appsysid+"&strfunctionID="+funid);

				}
</script>

