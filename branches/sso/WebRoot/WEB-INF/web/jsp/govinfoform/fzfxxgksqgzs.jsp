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
    
    <title>My JSP 'fzfxxgksqgzs.jsp' starting page</title>
    
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
			if (<%= request.getAttribute("editYesOrNo")%>=='0') {
				document.getElementById("btnDiv").style.display="none";
			
				var inputs=document.getElementsByTagName("input");
				for (i=0;i<inputs.length-2;i++){
					inputs[i].setAttribute('disabled',true);
				}
			}

			var attr2 = document.getElementById("attr2").value;
			if (attr2 != "") {
				selAttr2(attr2);
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
			var flag=false;//flag 表示表单是否正确提交
			if(<%= request.getAttribute("editYesOrNo")%>!='0'){
				if(submitValue()){
					flag=true;
				}
			}
			if(flag || <%=request.getAttribute("editYesOrNo")%>=='0'){
				var id = document.getElementById("id").value;
				var rem = document.getElementById("rem").value;
				var url = "<%=basePath%>fzfxxgksqgzsaction.do?method=add&rem="+rem;
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
  </head>

<body onload="isOrNotEdit();">
<html:form action="/fzfxxgksqgzsaction.do?method=addOrEditSave" >
<div align="center">
<table width="70%" border="0">
  <tr>
    <td align="center"><span class="titleTop">非政府信息公开申请告知书</span></td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right">沪水务非申告(<%=lsNo.substring(0,4) %>)第<input type="text" name="year1" value="<%=lsNo.substring(4,lsNo.length()) %>" class="UNDERLINE35"/>号</td>
  </tr>
  <tr>
    <td class="content" width="100%" align="left"><html:text property="applicant" readonly="true" styleClass="UNDERLINE150" />：</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;本机关（机构）于<input type="text" maxlength="4" name="year1" value="<%=sqTime.substring(0,4) %>" class="UNDERLINE35"/>年<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(5,7) %>" class="UNDERLINE35"/>月<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(8,10) %>" class="UNDERLINE35"/>日收到了您（单位）通过</td>
  </tr>
  <tr>
    <td class="content" width="100%">
    <html:checkbox property="attr2" value="17" disabled="true">电子邮件</html:checkbox>
    <html:checkbox property="attr2" value="20" disabled="true">邮寄</html:checkbox>
    <html:checkbox property="attr2" value="19" disabled="true">传真</html:checkbox>
    <html:checkbox property="attr2" value="21" disabled="true">当面领取</html:checkbox>
    <html:checkbox property="attr2" value="18" disabled="true">现场查阅</html:checkbox>
  </tr>
  <tr>
    <td class="content" width="100%">要求获取<html:text property="attr1" readonly="true" styleClass="UNDERLINE320"/>的材料。</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;&nbsp;&nbsp;&nbsp;经审查，您提交的材料不符合《上海市政府信息公开规定》第二</td>
  </tr>
  <tr>
    <td class="content" width="100%">十一条规定的政府信息公开的申请要求，不适用于《上海市政府信息</td>
  </tr>
  <tr>
    <td class="content" width="100%">公开规定》，本机关不再按照《上海市政府信息公开规定》作出答复。</td>
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
    <td width="100%" class="BeiZhuCon">&nbsp;&nbsp;&nbsp;&nbsp;本文本适用于公民、法人或其他组织提交的书面材料中，未按照《中华人民共和国政府信息公开条例》和《上海市政府信息规定》的规定，提出任何政府信息公开申请事项。</td>
  </tr>
  <html:hidden property="infoId" value="<%=infoId%>"/>
  <html:hidden property="lsNo" value="<%=lsNo%>"/>
  <html:hidden property="sqTime" value="<%=sqTime%>"/>
  <html:hidden property="dfTime"/>
  <html:hidden property="attr2"/>
  <input type="hidden" id="id" name="id"  value="${id }"/>
  <input type="hidden" id="rem" name="rem" value="${rem }"/>
  <tr>
    <td align="center"><button id="btnDiv" onclick="javascript:submitValue()"/>确 认</button><button onclick="print();">打 印</button><button onclick="window.location='<%=url %>'">返 回</button></td>
  </tr>
</table>
</div>
</html:form>
</body>
</html>
