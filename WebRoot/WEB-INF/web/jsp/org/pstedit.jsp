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
	//String id = (String)request.getAttribute("id");
	//if (id == null) {
	///	id = "";
	//}

	String parentId = (String) request.getAttribute("parentid");
	String addType = request.getParameter("addtype");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'deptedit.jsp' starting page</title>

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
			src='<%=strpath%>/dwr/interface/postCheck.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript">
		
	</script>
	</head>

	<body>
		<html:form action="/postEdit.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">组织机构管理</td>
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
																	<td nowrap align="left">
																		职务编号
																	</td>
																	<td>
																		<html:text property="code" maxlength="32"
																			styleClass="shuruk6" onkeydown="notNull();"
																			onblur="chk(),postCodeCheck()"></html:text>
																		<font color="red">*</font>
																		<font color="red"> <span id="fcode"> </span> <span
																			id="postCodeCheck"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		职务名称
																	</td>
																	<td>
																		<html:text property="name" maxlength="100"
																			styleClass="shuruk6" onkeydown="notNull();"
																			onblur="chk(),postNameCheck()"></html:text>
																		<font color="red">*</font>
																		<font color="red"> <span id="fname"> </span> <span
																			id="postNameCheck"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		职务级别
																	</td>
																	<td colspan="2">
																		<html:select property="lvl" onblur="chk();">
																			<html:option value="">---请选择---</html:option>
																			<html:options collection="allPstLvl" property="name"
																				labelProperty="name" />

																		</html:select>
																		<font color="red">*</font>
																		<font color="red"> <span id="flvl"></span> </font>
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
			<html:hidden property="nodeid" />
			<input type="hidden" name="parentid" value="<%=parentId%>" />
			<input type="hidden" name="addtype" value="<%=addType%>" />
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path%>" />


		</html:form>

	</body>
</html>

<script type="text/javascript">

			function chk(){
			var code = document.getElementById("code").value;
		    var name = document.getElementById("name").value;
		    var lvl = document.getElementById("lvl").value;
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
					   
			if(lvl == ""){
		
				document.getElementById("flvl").innerHTML = "<font color='red'>"+"请选择等级"+"</font>";
				//document.getElementById("lvl").focus();
				return false;	
				
			}
				else{document.getElementById("flvl").innerHTML = "";}
	   

			}
			
			
			
			function CheckForm(){
			var code = document.getElementById("code").value;
		    var name = document.getElementById("name").value;
		    var lvl = document.getElementById("lvl").value;
		    if(code == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("code").value) >32){alert("字符输入过长"); return false;}
			if(name == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("name").value) >100){alert("字符输入过长"); return false;}
			if(lvl == ""){alert("数据输入不完整"); return false;}
			
			postCodeCheck();
           
            if(this.postCodeflag=="false"){alert("不能重复"); return false;}
            
            postNameCheck();
            if(this.postNameflag=="false"){alert("不能重复"); return false;}

			if(document.all.nodeid.value==''){document.all.method.value='add'}
				else{document.all.method.value='postEdit'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}

		function returnl(){
				var parentid = document.getElementById("parentid").value;
				var pah=document.getElementById("path").value;

				window.location.replace(pah+"/orgrightdetailaction.do?method=list&nodetype=deptnode&nodeid=" + parentid);
					
				}
			
				
				
				</script>
