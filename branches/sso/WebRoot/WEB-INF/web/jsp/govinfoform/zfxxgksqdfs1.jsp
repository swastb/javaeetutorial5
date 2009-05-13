<%@ page language="java" import="java.util.*,com.baosight.mode.TbGovInfoPub" pageEncoding="GBK"%>
<%@ include file="../../inc/taglibs.jsp" %>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
String sqTime = (String)request.getAttribute("sqTime");
String year = (String)request.getAttribute("year");
String no = (String)request.getAttribute("no");
String applyManner = (String)request.getAttribute("applyManner");
String attr1 = (String)request.getAttribute("attr1");
String dfTime = (String)request.getAttribute("dfTime");
//List statusList = (List)request.getAttribute("statusList");
//TbGovInfoPub tbGovInfoPub = (TbGovInfoPub)request.getAttribute("tbGovInfoPub");

String id = request.getParameter("id");
String disply=request.getParameter("disply");
String status=request.getParameter("status");

String url=path+"/tbGovInfoPubMain.do?method=view&id="+id+"&disply="+disply+"&status="+status;

String passWay = request.getParameter("passWay");
String email=request.getParameter("email");
String docNum=request.getParameter("docNum");
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

	<script type="text/javascript">
		function checkForm()
		{
			var error="";
			var offer1 = document.getElementById("offer1").value;
			var offer2 = document.getElementById("offer2").value;
			
			if(offer1 !=1 && offer1 !=2 ){
				error=error+"数据不完整！";
				alert(error);
				return false;
			}
			if(offer1 == 2 && offer2 !=1 && offer2 !=2 && offer2 !=3 && offer2 !=4){
				error=error+"数据不完整！";
				alert(error);
				return false;
			}
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

		function submitValue()
		{
			var error="";
			var offer1 = document.getElementById("offer1").value;
			var offer2 = document.getElementById("offer2").value;
			
			if(offer1 !=1 && offer1 !=2 ){
				error=error+"数据不完整！";
				alert(error);
				return false;
			}
			if(offer1 == 2 && offer2 !=1 && offer2 !=2 && offer2 !=3 && offer2 !=4){
				error=error+"数据不完整！";
				alert(error);
				return false;
			}
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
			document.all.dfTime.value = document.all.year.value+'-'+document.all.month.value+'-'+document.all.date.value;
			
			//发送邮件的内容
				if(<%=passWay %>=='17'){
					document.getElementById("hidBtn").style.display="none";//提交前按钮隐藏，方便发送邮件的内容
					var inputs = document.getElementsByTagName("input");
					var spans = document.getElementsByTagName("span");
					for (i=0;i<14;i++){
						if(inputs[i].type == 'checkbox'){
							inputs[i].setAttribute('disabled',true);
						}else{
							inputs[i].style.display="none";
							spans[i+1].innerText= inputs[i].value;
						}
					}
					document.all.content.value =document.getElementById("allBody").innerHTML;//整个文书传到后台，方便发送邮件
				}
				
			document.forms[0].submit();
			return true;
		}
		
		function isOrNotEdit(){
			if(<%= request.getAttribute("unEdit")%>=='1'){
			  document.getElementById("btnDiv").style.display="none";
			  
			  var inputs=document.getElementsByTagName("input");
				for (i=0;i<inputs.length-2;i++){
					inputs[i].setAttribute('disabled',true);
				}
			}
			
			var offer1 = document.getElementById("offer1").value;
			if(offer1 != ""){
				selOffer1(offer1);
			}else{
				selOffer1(0);
			}
			
			var offer2 = document.getElementById("offer2").value;
			if(offer2 != ""){
				selOffer2(offer2);
			}else{
				selOffer2(0);
			}
		}
		
		function selOffer1(str){
			if(str == 1){	
				document.getElementById("offer11").checked=true;
				document.getElementById("offer12").checked=false;
				document.getElementById("offer21").checked=false;
				document.getElementById("offer22").checked=false;
				document.getElementById("offer23").checked=false;
				document.getElementById("offer1").value = '1';
				document.getElementById("offer2").value = '0';
			}
			if(str == 2){	
				document.getElementById("offer11").checked=false;
				document.getElementById("offer12").checked=true;
				document.getElementById("offer1").value = '2';
			}
		}
		
		function selOffer2(str){
			if(str == 1){	
				document.getElementById("offer21").checked=true;
				document.getElementById("offer22").checked=false;
				document.getElementById("offer23").checked=false;
				document.getElementById("offer11").checked=false;
				document.getElementById("offer12").checked=true;
				document.getElementById("offer1").value ='2';
				document.getElementById("offer2").value = document.getElementById("offer21").value;
			}
			if(str == 2){	
				document.getElementById("offer21").checked=false;
				document.getElementById("offer22").checked=true;
				document.getElementById("offer23").checked=false;
				document.getElementById("offer11").checked=false;
				document.getElementById("offer12").checked=true;
				document.getElementById("offer1").value ='2';
				document.getElementById("offer2").value = document.getElementById("offer22").value;
			}
			if(str == 3){	
				document.getElementById("offer21").checked=false;
				document.getElementById("offer22").checked=false;
				document.getElementById("offer23").checked=true;
				document.getElementById("offer11").checked=false;
				document.getElementById("offer12").checked=true;
				document.getElementById("offer1").value ='2';
				document.getElementById("offer2").value = document.getElementById("offer23").value;
			}
		}
		function print(){
			var flag=false;//flag 表示表单是否正确提交
			if(<%= request.getAttribute("unEdit")%>!='1'){
				if(submitValue()){
					flag=true;
				}
			}
			var flag=true;
			if(flag || <%= request.getAttribute("unEdit")%>=='1'){
				var id = document.getElementById("id").value;
				var url = "<%=basePath%>zfxxgkDealaction.do?method=addOne";
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
  </head>

<body onload="isOrNotEdit();">
<html:form action="/zfxxgkDealaction.do?method=addOrEditSaveOne">
<div align="center" id="allBody">
<table width="590" border="0" align="center">
  <tr class="trHeight">
    <td align="center" width="100%"><span class="titleTop" style="font-size:18.0pt;font-family:SimSun;">政府信息公开申请答复书（一）</span></td>
  </tr>
  <tr class="trHeight">
    <td align="right" class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">沪水务信答(${year })第<input type="text" name="year1" value="${no }" class="UNDERLINE35"/><span></span>号</td>
  </tr>
  <tr class="trHeight">
    <td align="left" class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;"><input type="text" name="applicant" value="${applicant }" readonly="true" class="UNDERLINE150"/><span></span>：</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;本机关（机构）于<input type="text" name="year1" value="<%=sqTime.substring(0,4) %>" class="UNDERLINE35"/>&nbsp;<span></span>年<input type="text" name="year1" value="<%=sqTime.substring(5,7) %>" class="UNDERLINE35"/>&nbsp;<span></span>月<input type="text" name="year1" value="<%=sqTime.substring(8,10) %>" class="UNDERLINE35"/>&nbsp;<span></span>日收到了您（单位）</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">要求获取<input type="text" name="applyManner" value="${applyManner }" readonly="true" class="UNDERLINE320"/><span></span>的申请。</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;经审查，现答复如下：</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="offer11" id="offer11" value="1" onclick="selOffer1(1);"/><span></span>&nbsp;您（单位）要求获取的信息属于《中华人民共和国政府信</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">息公开条例》第九条、《上海市政府信息公开规定》第十一条规</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">定的主动公开的政府信息。您（单位）可以通过上海水务网</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">（www.shanghaiwater.gov.cn)获取。</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="offer12" id="offer12" value="2" onclick="selOffer1(2);"/><span></span>&nbsp;&nbsp;您（单位）要求获取的信息属于本机关（机构）依申请公</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">开的政府信息。根据《上海市政府信息公开规定》第二十六条的</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">规定，<input type="checkbox" name="offer21" id="offer21" value="1" onclick="selOffer2(1);"/><span></span>本机关将当场提供  <input type="checkbox" name="offer22" id="offer22" value="2" onclick="selOffer2(2);"/><span></span>本机关将通过电子邮件 <input type="checkbox" name="offer23" id="offer23" value="3" onclick="selOffer2(3);"/><span></span>邮寄 &nbsp;方</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">式予以提供。</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content" align="left" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">&nbsp;&nbsp;&nbsp;&nbsp;特此告知。</td>
  </tr>
 <tr class="trHeight">
    <td width="100%" class="content">&nbsp;</td>
  </tr>
  <tr class="trHeight">
    <td align="right" width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;"><input type="text" size="8" name="year" value="<%=dfTime.equals("")?"":dfTime.substring(0,4) %>" class="lineInput1"/><span></span>年<input type="text" size="8" name="month" value="<%=dfTime.equals("")?"":dfTime.substring(5,7) %>" class="lineInput1"/><span></span>月<input type="text" size="8" name="date" value="<%=dfTime.equals("")?"":dfTime.substring(8,10) %>" class="lineInput1"/><span></span>日</td>
  </tr>
  <tr class="trHeight">
    <td width="100%" class="content">&nbsp;</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhu" align="left">&nbsp;&nbsp;&nbsp;&nbsp;使用指南：</td>
  </tr>
  <tr>
    <td width="100%" class="BeiZhuCon" align="left">&nbsp;&nbsp;&nbsp;&nbsp;本文本适用于《上海市政府信息公开规定》第二十三条第（三）项关于对“不属于政府信息范围”的答复。</td>
  </tr>
  <input type="hidden" name="infoId" value="<%=infoId%>" />
  <input type="hidden" name="lsNo" value="<%=year+""+no %>" />
  <input type="hidden" name="sqTime" value="<%=sqTime%>" />
  <input type="hidden" name="dfTime" />
  <input type="hidden" id="id" name="id"  value="${id }"/>
  <input type="hidden" name="offer1" value="${offer1 }"/>
  <input type="hidden" name="offer2" value="${offer2 }"/>
  <input type="hidden" name="attr1" value="${attr1}"/>
  <input type="hidden" name="unEdit" value="${unEdit}"/>
    <input type="hidden" name="content" id="content">
  <input type="hidden" name="passWay" value=<%=passWay%>>
  <input type="hidden" name="email" value=<%=email%>>
  <input type="hidden" name="docNum" value=<%=docNum%>>
  <tr>
    <td align="center" id="hidBtn"><button id="btnDiv" onclick="javascript:submitValue()"/>确 认</button><button onclick="print();">打 印</button><button onclick="window.location='<%=url%>'">返 回</button></td>
  </tr>
</table>
</div>
</html:form>
</body>
</html>
