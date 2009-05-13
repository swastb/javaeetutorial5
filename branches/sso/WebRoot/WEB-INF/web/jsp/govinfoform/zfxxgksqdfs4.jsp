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
String url=path+"/xxgkAction.do?method=getGovInfoPub&id="+id+"&disply="+disply+"&status="+status;

String passWay = request.getParameter("passWay");
String email=request.getParameter("email");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zfxxgksqdas4.jsp' starting page</title>
    
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
				
				//发送邮件的内容
				if(<%=passWay %>=='17'){
					document.getElementById("hidBtn").style.display="none";//提交前按钮隐藏，方便发送邮件的内容
					var inputs = document.getElementsByTagName("input");
					var spans = document.getElementsByTagName("span");
					for (i=0;i<9;i++){
						inputs[i].style.display="none"
						spans[i+1].innerText= inputs[i].value;
					}
					document.all.content.value =document.getElementById("allBody").innerHTML;//整个文书传到后台，方便发送邮件
				}
				
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
				var rem = document.getElementById("rem").value;
				var url = "<%=basePath%>zfxxgksqdfs4action.do?method=add&rem="+rem;
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
  </head>

<body onload="isOrNotEdit();">
<html:form action="/zfxxgksqdfs4action.do?method=addOrEditSave">
<div align="center"  id="allBody">
<table width="620" border="0" align="center">
  <tr>
    <td align="center"><span class="titleTop" style="font-size:18.0pt;font-family:SimSun;">政府信息公开申请答复书（四）</span></td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">沪水务不存答(<%=lsNo.substring(0,4) %>)第<input type="text" name="year1" value="<%=lsNo.substring(4,lsNo.length()) %>" class="UNDERLINE35"/><span ></span>号</td>
  </tr>
  <tr>
    <td class="content" width="100%" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;"><html:text property="applicant" readonly="true" styleClass="UNDERLINE150"/><span ></span>：</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;本机关（机构）于<input type="text" maxlength="4" name="year1" value="<%=sqTime.substring(0,4) %>" class="UNDERLINE35"/><span ></span>年<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(5,7) %>" class="UNDERLINE35"/><span ></span>月<input type="text" maxlength="2" name="year1" value="<%=sqTime.substring(8,10) %>" class="UNDERLINE35"/><span ></span>日收到了您（单位）要求获取</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;"><html:text property="attr1" readonly="true" styleClass="UNDERLINE320"/><span ></span>的申请。</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;经审查，您（单位）要求获取的政府信息属于本机关（机构）公</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">开职责权限范围，但本机关（机构）未制作或未获取，该政府信息不</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">存在。现依据《上海市政府信息公开规定》第二十三条第（四）项的</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">规定予以答复。</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;如对本答复不服，可以在收到本答复之日起60日内向上海市人民</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">政府 或者中华人民共和国水利部申请行政复议，或者在3个月内向</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">人民法院提起行政诉讼。</td>
  </tr>
  <tr>
    <td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;特此告知。</td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right"></td>
  </tr>
  <tr>
    <td class="content" width="100%" align="right" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;"><input type="text" size="8" maxlength="4" name="year" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(0,4)%>><span ></span>年<input type="text" size="8" maxlength="2"name="month" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(5,7)%>><span ></span>月<input type="text" size="8" maxlength="2" name="date" class="lineInput1" value=<%="".equals(dfTime) ? "" :dfTime.substring(8,10)%>><span ></span>日</td>
  </tr>
  <tr>
    <td class="content" width="100%">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhu">&nbsp;&nbsp;&nbsp;&nbsp;使用指南：</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhuCon">&nbsp;&nbsp;&nbsp;&nbsp;本文本适用于《上海市政府信息公开规定》第二十三条第（四）项关于“属于本机关予以公开权限范围，但本机关未制作或者获取的”情形的答复。</td>
  </tr>
  <html:hidden property="infoId" value="<%=infoId%>"/>
  <html:hidden property="lsNo" value="<%=lsNo%>"/>
  <html:hidden property="sqTime" value="<%=sqTime%>"/>
  <html:hidden property="dfTime"/>
   <input type="hidden" id="id" name="id"  value="${id }"/>
  <input type="hidden" id="rem" name="rem" value="${rem }"/>
  
   <input type="hidden" name="content" id="content">
   <input type="hidden" name="passWay" value=<%=passWay%>>
   <input type="hidden" name="email" value=<%=email%>>
  <tr>
    <td align="center" id="hidBtn"><button id="btnDiv" onclick="javascript:submitValue();"/>确 认</button><button onclick="window.print();">打 印</button><button onclick="window.location='<%=url %>'">返 回</button></td>
  </tr>
</table>
</div>
</html:form>
</body>
</html>
