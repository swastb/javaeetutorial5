<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="../../inc/taglibs.jsp" %>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
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
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">	
	<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">	
	<link href="<%=path %>/css/govinfoform.css" rel="stylesheet" type="text/css">	
	<script src="../../../../javascript/validate.js"></script>
	<script type='text/javascript' src='<%=strpath%>/dwr/interface/pstlvl.js'></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>

  </head>

  <body>
  		<html:form action="/bzsqgzsaction.do?method=addOrEditSave" >
<div align="center">
<table width="500" border="0">
  <tr>
    <td align="center"><span class="style1">补正申请告知书</span></td>
  </tr>
  <tr>
    <td align="right"><html:text property="attr1" styleClass="UNDERLINE100"/>(<html:text property="attr2" styleClass="S_35"/>)第<html:text property="attr3" styleClass="UNDERLINE35"/>号-补告</td>
  </tr>
  <tr>
    <td align="left"><html:text property="attr4" styleClass="UNDERLINE150" value="（申请人姓名或者名称）"/>：</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;本机关于<html:text property="attr5" styleClass="UNDERLINE80"/>年<html:text property="attr6" styleClass="UNDERLINE35"/>月<html:text property="attr7" styleClass="UNDERLINE35"/>日收到了您（单位）申请获</td>
  </tr>
  <tr>
    <td>取<html:text property="attr8" styleClass="UNDERLINE420"/>的</td>
  </tr>
  <tr>
    <td>申请，具体见《收件证明》<html:text property="attr9" styleClass="UNDERLINE100"/>(<html:text property="attr10" styleClass="S_35"/>)第<html:text property="attr11" styleClass="UNDERLINE35"/>号-收。</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;经查，本机关无法按照您（单位）对申请获取信息的内容描</td>
  </tr>
  <tr>
    <td>述确定相应的政府信息。本机关根据《上海市政府信息公开规定》</td>
  </tr>
  <tr>
    <td>第十二条第（五）项的规定，请您（单位）在<html:text property="attr12" styleClass="UNDERLINE35"/>年<html:text property="attr13" styleClass="UNDERLINE35"/>月<html:text property="attr14" styleClass="UNDERLINE35"/>日</td>
  </tr>
  <tr>
    <td>前<html:radio property="attr15" value="1">更改</html:radio><html:radio property="attr15" value="2">补充申请</html:radio>。</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;自本机关作出本告知书之日起至收到您（单位）<html:radio property="attr16" value="1">更改</html:radio><html:radio property="attr16" value="2">补</html:radio></td>
  </tr>
  <tr>
    <td>充申请之日止的期间，不计入本机关作出答复的期限。逾期不补</td>
  </tr>
  <tr>
    <td>正的，本机关将按照您（单位）于<html:text property="attr17" styleClass="UNDERLINE35"/>年<html:text property="attr18" styleClass="UNDERLINE35"/>月<html:text property="attr19" styleClass="UNDERLINE35"/>日提出的申请进</td>
  </tr>
  <tr>
    <td>行处理。</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;特此告知。</td>
  </tr>
  <tr>
    <td align="right">（机关印章）</td>
  </tr>
  <tr>
    <td align="right"><html:text property="attr20" styleClass="S_35"/>年<html:text property="attr21" styleClass="S_35"/>月<html:text property="attr22" styleClass="S_35"/>日</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
 <html:hidden property="infoId" value="<%=infoId%>"/>
  <tr>
    <td align="center"><button onclick="CheckForm()">确 认</button><button onclick="window.print();">打 印</button><button onclick="history.back()">返 回</button></td>
  </tr>
</table>
</div>
		
		</html:form>
  </body>
</html>

<script type="text/javascript">

			function chk(){
		    var code = document.getElementById("code").value;
		    var name = document.getElementById("name").value;
		    
		    if(name == ""){
		
				document.getElementById("fname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("name").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("name").value) > 32){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
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
				    if(getLen(document.getElementById("code").value) > 32){
					document.getElementById("fcode").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("code").focus();
					return false;	
								
				}
				else{document.getElementById("fcode").innerHTML = "";}
			}	
			

			
			
	}
			function CheckForm(){
/*		   var code = document.getElementById("code").value;
		   var name = document.getElementById("name").value;
		    if(name == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("name").value) >32){alert("字符输入过长"); return false;}
			if(code == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("code").value) >32){alert("字符输入过长"); return false;}
						pstlvlNameCheck();
           
            if(this.pstlvlNameflag=="false"){alert("不能重复"); return false;}
            			pstlvlCodeCheck();
           
            if(this.pstlvlCodeflag=="false"){alert("不能重复"); return false;}
	*/		
				document.forms[0].submit();
				}

	function returnl()
	{	
		var path=document.getElementById("path").value;
		window.location.replace(path+"/vehiclesapplyaction.do?method=list");
	}
</script>
