<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%
String insure = (String)request.getAttribute("insure");
System.out.println(insure);

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	<base href="<%=basePath%>">
		<html:base target="_self" />
		<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">	
		<script src="../../../../javascript/checkbox.js"></script>
		<script src="../../../../javascript/validate.js"></script>
		<script type='text/javascript' src='<%=strpath%>/dwr/interface/funCheck.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<style type="text/css">
			<!--
			.STYLE1 {
				font-size: 12px;
				color: #FF0000;
			}
			.STYLE2 {
				font-size: 12px;
				color: #666666;
			}
			-->
        </style>
        <script type="text/javascript">
			function chk(){
			var name = document.getElementById("name").value;
			var fun_key = document.getElementById("fun_key").value;
			var sys_key = document.getElementById("sys_key").value;
			
			if(isNull(document.getElementById("name"))==false){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("name").focus();
				return false;
			}else{
				if(getLen(document.getElementById("name").value) > 100){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
				
					//document.getElementById("name").focus();
					return false;				
				}else{
					document.getElementById("fname").innerHTML = "";
				}
			}

			if(getLen(document.getElementById("fun_key").value) > 100){
				document.getElementById("ffun_key").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("fun_key").focus();
				return false;
			}else{
				if(maxLength(document.getElementById("fun_key"),100)==false){
					document.getElementById("ffun_key").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("fun_key").focus();
					return false;				
				}else{
					document.getElementById("ffun_key").innerHTML = "";
				}
			}
		
				if(getLen(document.getElementById("url").value) > 2000){
						document.getElementById("furl").innerHTML = "<font color='red'>"+"长度不能大于2000个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
						//document.getElementById("url").focus();
						return false;				
					}else{
						document.getElementById("furl").innerHTML = "";
					}			
			}

			function checkFun(){
				var name = document.getElementById("name").value;
				var fun_key = document.getElementById("fun_key").value;

				if(name == ""){alert("数据输入不完整"); return false;}
				if(getLen(document.getElementById("name").value) >100){alert("字符输入过长"); return false;}
				if(fun_key == ""){alert("数据输入不完整"); return false;}
				if(getLen(document.getElementById("fun_key").value) >100){alert("字符输入过长"); return false;}
				funKeyCheckU();
           
           		if(this.funKeyflag=="false"){alert("不能重复"); return false;}
				var chkLen = checkRightType();
				//if(chkLen==0){
				//	alert("权限类型不能为空，请选择！");
				//	return false;
				//}			
				var frm = document.forms[0];
				var fun = document.getElementsByName("insure");
				var insure = "";
				for(i=0;i<fun.length;i++){
					if(fun[i].checked==true){
						insure = fun[i].value;
						break;
					}
				}
				if (confirm("请确认您录入的信息是否准确，确认更新吗？")){
					frm.action=frm.action + "&sure="+insure;
					frm.submit();
				}

			}

			function checkall(id){
				var es = document.getElementsByName("right_type");
				var tocheck = id.checked;
				var totle = es.length;
				for (var i = 0; i < es.length ; i++){
					es[i].checked = tocheck; 
					setID(es[i]);
				}
			}			

			function checkRightType(){
				var es = document.getElementsByName("right_type");
				var chkLen = 0;
				for (var i = 0; i < es.length ; i++){
					if(es[i].checked){
						chkLen++;
					}
				}	
				return chkLen;
			}
 
    	function succ(){
    		var op = document.getElementById("op").value;
    		if(op!=null && op !=""){
    			if(op=="add"){
    				alert("添加资源操作成功");	    				
    			}
    			if(op=="addRoot"){
    				alert("添加根资源操作成功");
    			}
    			if(op=="update"){
    				alert("更新资源操作成功");
    			}
    			if(op=="delete"){
    				alert("删除资源操作成功");
    			}	    				    				    			
    		}    		
    		//window.parent.location.reload();
    	}
		</script>
	</head>

	<body bgcolor="#f2f9f9" onload="succ()">
       <input id="op" type="hidden" value="${op }" >
		<input id="path" type="hidden" value="<%=request.getContextPath()%>">
		<input id="sure" type="hidden" value="${tbFunction.inuse }">
		<input type="hidden" id="rTypeLen" name="couting"
			value="${fn:length(rightTypeListByFun)}" />
		<html:form action="/base/function/forwardFunction.do?method=updateFun"
			focus="name">
			<html:hidden property="id" value="${tbFunction.id }" />
			<html:hidden property="par_id" value="${tbFunction.parId }" />
			<table width="98%" border="1" align="center" cellpadding="0"
				cellspacing="0" bordercolor="black" class="tableborder">
				<thead class="bg-zwbt">
				<tr>
					<td height="30" align="left">
						&nbsp;
						<span class="STYLE1">更新资源信息</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="font_underline" onClick="checkFun();"
							onmouseover="this.style.cursor='hand'"> <img  src="<%=path %>/imagine/a3.gif"></a>&nbsp;&nbsp;
					</td>
				</tr>
				</thead>
			</table>
			<table width="98%" border="1" align="center" cellpadding="0"
				cellspacing="0" bordercolor="black" class="tableborder">

				<thead class="bg-zw">

					<tr>
						<td width="50%" height="25">
							资源名称
						</td>
						<td colspan="3">
							<html:text property="name" maxlength="100" value="${tbFunction.name }" onkeydown="notNull();" onblur="chk();"></html:text><font color="red">*</font>
							<font color="red">
							<span id="fname"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td width="50%"height="25">
							子系统唯一标识
						</td>
						<% if ("0".equals(insure)) {%>
						<td colspan="3">
							<html:text property="fun_key" maxlength="100" value="${tbFunction.funKey }" onkeydown="notNull();" onblur="chk(),funKeyCheckU()"></html:text><font color="red">*</font>
							<font color="red">
							<span id="ffun_key"></span>
							<span id="funKeyCheckU"></span>
							</font>
							
						</td>

						<%}else{ %>
						<td colspan="3">
							<html:text property="fun_key" value="${tbFunction.funKey }" onblur="chk();" readonly="true"></html:text><font color="red">*</font>
							<font color="red">
							<span id="ffun_key"></span>
							</font>
						</td>
						
						<%
  		} 
        %>
					</tr>
					<tr>
						<td width="50%" height="25">
							所属应用系统
						</td>
							<td nowrap="nowrap">
							<html:select property="sys_key" >
								
									<html:option value="${sysid}">${sysname}</html:option>
									</html:select>
								
							
						</td>
					</tr>
					<tr>
						<td width="50%">资源图标</td>
						<td>
							<html:select property="imageName" value="${tbFunction.imageName}">
								<%--<html:option value="${tbFunction.imageName}">图标${tbFunction.imageName}</html:option>
								--%>
								<html:option value="01">标准</html:option>
								<html:option value="02">通讯薄</html:option>
								<html:option value="03">地球</html:option>
								<html:option value="04">记事本</html:option>
								<html:option value="05">车辆</html:option>
								<html:option value="06">传真机</html:option>
								<html:option value="07">时钟</html:option>
								<html:option value="08">管理</html:option>
								<html:option value="09">信息</html:option>
								<html:option value="10">组夹</html:option>
								<html:option value="11">查询</html:option>
								<html:option value="12">文件</html:option>
								<html:option value="13">档案</html:option>
								<html:option value="14">信件</html:option>
								<html:option value="15">电脑</html:option>
								<html:option value="16">网上咨询意见征询</html:option>
								<html:option value="17">网上咨询转办</html:option>
								<html:option value="18">议题讨论</html:option>
								<html:option value="19">代码管理</html:option>
								<html:option value="20">功能资源管理</html:option>
								<html:option value="21">角色管理</html:option>
								<html:option value="22">权限类型管理</html:option>
								<html:option value="23">应用系统管理</html:option>
								<html:option value="24">用户所属角色</html:option>
								<html:option value="25">组织机构管理</html:option>
								<html:option value="26">抄送</html:option>
								<html:option value="27">撤销事项</html:option>
								<html:option value="28">催办</html:option>
								<html:option value="29">待办</html:option>
								<html:option value="30">电子监察</html:option>
								<html:option value="31">客户维护</html:option>
								<html:option value="32">上传</html:option>
								<html:option value="33">受理</html:option>
								<html:option value="34">外网</html:option>
								<html:option value="35">我的催办</html:option>
								<html:option value="36">已办</html:option>
								<html:option value="37">新增事项</html:option>
							</html:select>
						</td>
					</tr>
					<% if ("统一门户".equals(request.getAttribute("sysname"))) {%>
					<tr>
						<td width="50%" height="25">资源顺位</td>
						<td>
							<html:select property="newDeforder">
								<html:option value="${tbFunction.defor}">${tbFunction.defor}</html:option>
								<c:forEach var="num" begin='1' end='${newDeforder}'>
									<html:option value="${num}">${num}</html:option>
								</c:forEach>
							</html:select>
						</td>
					</tr>
					<%
  		} 
        %>
					
					<tr>
						<td width="50%" height="25">
							资源是否被启用
						</td>
						<% if ("0".equals(insure)) {%>
						<td colspan="3">
							  <html:radio property="insure" value="1">启用</html:radio>
				              <html:radio property="insure" value="0">未启用</html:radio>
						</td>
						<%}else{ %>
												<td colspan="3">
							  <html:radio property="insure" value="1" disabled="true">启用</html:radio>
				              <html:radio property="insure" value="0" disabled="true">未启用</html:radio>
						</td>
								<%
  		} 
        %>
					</tr>
					<tr>
						<td width="50%" >
						URL
						</td>
						<td width="50%">
							<html:textarea property="url" value="${tbFunction.url }"></html:textarea>
							<font color="red">
							<span id="furl"></span>
							</font>
						</td>
					</tr>
				</thead>
			</table>
			<table width="98%" border="1" align="center" cellpadding="0"
				cellspacing="0" bordercolor="black" class="tableborder">
				<thead class="bg-zw">
				<tr>
					<td height="30" align="left" width="25%" colspan="3">
						&nbsp;
						<span class="STYLE1">更新权限类型信息</span>
					</td>
				</tr>
				<% if ("0".equals(insure)) {%>
				<tr>
					<td width="50%" height="25" align="center">
						<input name="allbox" type="checkbox" id="allbox"
							onClick="checkall(this);">
					</td>
					<td align="center" height="25">
						权限名称
					</td>
				</tr>
				<c:forEach var="content" items="${rightTypeList}" varStatus="loop">
					<tr>
						<td width="50%" align="center">
							<html:checkbox property="right_type" value="${content.id}"
								onclick="setID(this)">
							</html:checkbox>
						</td>
						<td align="center">
							${content.name }
						</td>
					</tr>
				</c:forEach>
				<%}else{ %>
				
				<tr>
					<td width="50%" height="25" align="center">
						<input name="allbox" type="checkbox" id="allbox"
							onClick="checkall(this);" disabled="disabled">
					</td>
					<td align="center" height="25">
						权限名称
					</td>
				</tr>
				<c:forEach var="content" items="${rightTypeList}" varStatus="loop">
					<tr>
						<td width="50%" align="center">
							<html:checkbox property="right_type" value="${content.id}"
								onclick="setID(this)" disabled="true">
							</html:checkbox>
						<br></td>
						<td align="center">
							${content.name }
						</td>
					</tr>
				</c:forEach>
				
		<%
  		} 
        %>
				
				</thead>
			</table>
			
		</html:form>
		<form id="typeFrm">
			<c:forEach var="content1" items="${rightTypeListByFun}" varStatus="loop">
				<input type='hidden' name='rightType' value="${content1.id }" />
			</c:forEach>
		</form>		
		<script type="text/javascript">
			var temp = document.getElementById("sure").value;
			var fun = document.getElementsByName("insure");
			if(temp==1){
				//document.getElementById("insure").checked=false;
				fun[0].checked='true';
			}			
			if(temp==0){
				//document.getElementById("insure").checked=false;
				fun[1].checked='true';
			}		
			
			var right_type = document.getElementsByName("right_type");
			var rightType = document.getElementsByName("rightType");
			for(i=0;i<right_type.length;i++){
				for(j=0;j<rightType.length;j++){
					if(right_type[i].value==rightType[j].value){
						right_type[i].checked='true';
					}
				}
			}
			//document.getElementById("insure").checked='true';
		</script>
	</body>
</html>


