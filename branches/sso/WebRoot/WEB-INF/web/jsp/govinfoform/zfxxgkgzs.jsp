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
  		<html:form action="/zfxxgkgzsaction.do?method=addOrEditSave" >
<div align="center">
<table width="500" border="0">
  <tr>
    <td align="center"><span class="style1">政府信息公开告知书</span></td>
  </tr>
  <tr>
    <td align="right"><html:text property="attr1" styleClass="UNDERLINE100"/>(<html:text property="attr2" styleClass="S_35"/>)第<html:text property="attr3" styleClass="UNDERLINE35"/>号-部公告</td>
  </tr>
  <tr>
    <td align="left"><html:text property="attr4" styleClass="UNDERLINE150" value="（申请人姓名或者名称）"/>：</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;本机关于<html:text property="attr5" styleClass="UNDERLINE80"/>年<html:text property="attr6" styleClass="UNDERLINE35"/>月<html:text property="attr7" styleClass="UNDERLINE35"/>日收到了您（单位）获</td>
  </tr>
  <tr>
    <td>得<html:text property="attr8" styleClass="UNDERLINE320"/>的申请，见《收</td>
  </tr>
  <tr>
    <td>件证明》<html:text property="attr9" styleClass="UNDERLINE100"/>(<html:text property="attr10" styleClass="S_35"/>)第<html:text property="attr11" styleClass="UNDERLINE35"/>号-收。</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;经查，您（单位）申请获取的政府信息属于可公开的政府信</td>
  </tr>
  <tr>
    <td>息范畴，根据《上海市政府信息公开规定》第十二条第（一）项</td>
  </tr>
  <tr>
    <td>的规定，本机关将通过以下形式提供该政府信息：</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="attr12" value="1">&nbsp;&nbsp;纸质</html:radio></td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="attr12" value="2">&nbsp;&nbsp;电子邮件</html:radio></td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="attr12" value="3">&nbsp;&nbsp;光盘</html:radio></td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="attr12" value="4">&nbsp;&nbsp;磁盘</html:radio></td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;<html:radio property="attr12" value="5">&nbsp;&nbsp;其他方式</html:radio>，具体为<html:text property="attr13" styleClass="UNDERLINE150"/></input></td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;根据《上海市政府信息公开规定》第二十七条的规定，本机</td>
  </tr>
  <tr>
    <td>关将向您（单位）收取实际发生的检索/复制/邮寄/递送费用。请</td>
  </tr>
  <tr>
    <td>在收到本告知书后，到<html:text property="attr14" styleClass="UNDERLINE170"/>办理缴费等具体手</td>
  </tr>
  <tr>
    <td>续。本机关将根据《上海市政府信息公开规定》第十八条第二款</td>
  </tr>
  <tr>
    <td>的规定，在您（单位）办妥手续后10个工作日内向您（单位）</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;特此告知。</td>
  </tr>
  <tr>
    <td align="right">（机关印章）</td>
  </tr>
  <tr>
    <td align="right"><html:text property="attr15" styleClass="S_35"/>年<html:text property="attr16" styleClass="S_35"/>月<html:text property="attr17" styleClass="S_35"/>日</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <html:hidden property="infoId" value="<%=infoId%>"/>
  <tr>
    <td align="center"><button onclick="CheckForm()"/>确 认</button><button onclick="window.print();">打 印</button><button onclick="history.back()">返 回</button></td>
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
