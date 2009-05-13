<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="../../inc/taglibs.jsp" %>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
String sqTime = (String)request.getAttribute("sqTime");
String dfTime = (String)request.getAttribute("dfTime");
String lsNo = (String)request.getAttribute("lsNo");

String id = request.getParameter("id");
String disply=request.getParameter("disply");
String status=request.getParameter("status");

String url=path+"/tbGovInfoPubMain.do?method=view&id="+id+"&disply="+disply+"&status="+status;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zfxxgkbzsqgzs.jsp' starting page</title>
    
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

	<script type="text/javascript">
		function checkForm()
		{
			var error="";
			if (document.all.year.value=="")
			{
				error=error+"\n年未填写！";
				alert(error);
				document.getElementById("year").focus();
				return false;
			}
			if (document.all.month.value=="")
			{
				error=error+"\n月未填写！";
				alert(error);
				document.getElementById("month").focus();
				return false;
			}
			if (document.all.date.value=="")
			{
				error=error+"\n日未填写！";
				alert(error);
				document.getElementById("date").focus();
				return false;
			}
			return true;
		}

		function isOrNotEdit()
		{
			if(<%= request.getAttribute("editYesOrNo")%>=='0'){
			  document.getElementById("btnDiv").style.display="none";
			
			  var inputs=document.getElementsByTagName("input");
				for (i=0;i<inputs.length-2;i++){
					inputs[i].setAttribute('disabled',true);
				}
			}
		}

		function submitValue()
		{
			if(checkForm())
			{
				document.all.dfTime.value = document.all.year.value+'-'+document.all.month.value+'-'+document.all.date.value;
				document.forms[0].submit();
				return true;
			}
		}
		function print(){
			var flag=false; //flag 表示表单是否正确提交
			if(<%= request.getAttribute("editYesOrNo")%>!='0'){
				if(submitValue()){
					flag=true;
				}
			}
			if(flag || <%=request.getAttribute("editYesOrNo")%>=='0'){
				var id = document.getElementById("id").value;
				var url = "<%=basePath%>zfxxgkbzsqgzsaction.do?method=add";
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
  </head>

<body onload="isOrNotEdit();">
<html:form action="/zfxxgkbzsqgzsaction.do?method=addOrEditSave" >
<div align="center">
<table width="70%" border="0">
  <tr>
    <td align="center"><span class="titleTop">政府信息公开补正申请告知书</span></td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right">沪水务信补(<%=lsNo.substring(0,4) %>)第<input type="text" name="year1" value="<%=lsNo.substring(4,lsNo.length()) %>" class="UNDERLINE35"/>号</td>
  </tr>
  <tr>
    <td class="content" width="100%" align="left"><html:text property="applicant" readonly="true" styleClass="UNDERLINE150" />：</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;本机关（机构）于<input type="text" maxlength="4" name="year1" value="<%=sqTime.substring(0,4) %>" class="UNDERLINE35"/>年<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(5,7) %>" class="UNDERLINE35"/>月<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(8,10) %>" class="UNDERLINE35"/>日收到了您（单位）要求获取</td>
  </tr>
  <tr>
    <td class="content" width="100%"><html:text property="attr1" readonly="true" styleClass="UNDERLINE320"/>的申请。</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;经审查，您（单位）填写的政府信息公开申请未明确特定政府信</td>
  </tr>
  <tr>
    <td class="content" width="100%">息的文件名称、文号或者其他特征描述。根据《中华人民共和国政府</td>
  </tr>
  <tr>
    <td class="content" width="100%">信息公开条例》第二十一条第（四）项、《上海市政府信息公开规定</td>
  </tr>
  <tr>
    <td class="content" width="100%">》第二十三条第（八）项的规定，请您（单位）在10个工作日内补正</td>
  </tr>
  <tr>
    <td class="content" width="100%">相关申请内容。逾期未补正的，视为放弃申请。</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;自本机关（机构）发出本告知书之日起至收到您（单位）补正申</td>
  </tr>
  <tr>
    <td class="content" width="100%">请之日止的期间，不计入本机关（机构）作出答复的期限。</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;特此告知。</td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right"></td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right"><input type="text" size="8" maxlength="4" name="year" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(0,4)%>>年<input type="text" size="8" maxlength="2"name="month" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(5,7)%>>月<input type="text" size="8" maxlength="2" name="date" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(8,10)%>>日</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhu">&nbsp;&nbsp;&nbsp;&nbsp;使用指南：</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhuCon">&nbsp;&nbsp;&nbsp;&nbsp;本文本适用于《上海市政府信息公开规定》第二十三条第（八）项关于“政府信息公开申请内容不明确”情形的答复。</td>
  </tr>
  <html:hidden property="infoId" value="<%=infoId%>"/>
  <html:hidden property="lsNo" value="<%=lsNo %>"/>
  <html:hidden property="sqTime" value="<%=sqTime%>"/>
  <html:hidden property="dfTime"/>
  <input type="hidden" id="id" name="id"  value="${id }"/>
  <tr>
    <td align="center"><button id="btnDiv" onclick="javascript:submitValue()"/>确 认</button><button onclick="print();">打 印</button><button onclick="window.location='<%=url %>'">返 回</button></td>
  </tr>
</table>
</div>
</html:form>
</body>
</html>
