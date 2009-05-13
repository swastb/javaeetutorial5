<%@ page language="java"  pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String id = request.getParameter("id");
String disply=request.getParameter("disply");
String status=request.getParameter("status");
String passWay = request.getParameter("passWay");
String email=request.getParameter("email");
String docNum=request.getParameter("docNum");
String url=path+"/tbGovInfoPubMain.do?method=view&id="+id+"&disply="+disply+"&status="+status+"docNum="+docNum+"passWay="+passWay+"email="+email;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
     <link href="<%=path %>/css/govinfoform.css" rel="stylesheet" type="text/css">
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

  </head>
  
  <body onload="isOrNotEdit();">
  <html:form action="/obligeeOpinion.do">
  <div align="center">
   <table width="570" border="0">
		<tr>
			<td align="center" width="100%" ><span class="titleTop">权利人意见征询单</span>
			</td>
		</tr>
		<tr class="trHeight">
			<td align="right" class="content" width="100%">
			 沪水务征询（<html:text property="year" styleClass="lineInput1" style="width:40px;" readonly="true"></html:text>）第<html:text property="autoNo" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text>号  
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			<html:text property="consultName" styleClass="UNDERLINE150" style="width:200px;"></html:text>:
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			本机关（机构）在处理政府信息公开申请工作中，经审查发
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			现，申请公开的关于<html:text property="contentMsg" styleClass="lineInput" style="width:300px;" ></html:text>的政府信
			</td>
		</tr>
		<tr>
			<tr class="trHeight">
			<td width="100%" class="content">
			息：
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="text-indent: 30pt;">
			<input type="checkbox" name="involveMsg1" id="involveMsg1" value="1" onclick="selInvolveMsg(1);"/>&nbsp;涉及您个人的信息&nbsp;
			<input type="checkbox" name="involveMsg2" id="involveMsg2" value="2" onclick="selInvolveMsg(2);"/>&nbsp;涉及您单位的信息
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			根据《中华人民共和国政府信息公开条例》第二十三条、
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			《上海市政府信息公开规定》第十二条第二款的规定，需征求您
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			（单位）的意见。您（单位）的意见是：
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" name="opinion1" id="opinion1" value="1" onclick="selOpinion(1);"/>&nbsp;同意向申请人提供&nbsp;
			<input type="checkbox" name="opinion2" id="opinion2" value="2" onclick="selOpinion(2);"/>&nbsp;不同意向申请人提供
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			请您（单位）在<html:text property="replyYear" styleClass="lineInput" style="width:60px;" ></html:text>年  
			<html:text property="replyMonth" styleClass="lineInput" style="width:30px;"></html:text>月  
			<html:text property="replyDay" styleClass="lineInput" style="width:30px;"></html:text>日前予以答复，并将意
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			见邮寄至本机关（机构），（地址：<html:text property="address" styleClass="lineInput" style="width:230px;"></html:text>,
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			邮政编码：<html:text property="postalcode" styleClass="lineInput" style="width:60px;"></html:text>）。
			</td>
		</tr>
		<tr>
			<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			
			</td>
		</tr>
	<tr class="trHeight">
			<td width="100%" class="content">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" align="right">
			<html:text property="signYear" styleClass="lineInput1" style="width:60px;" ></html:text>年  
			<html:text property="signMonth" styleClass="lineInput1" style="width:30px;"></html:text>月  
			<html:text property="signDay" styleClass="lineInput1" style="width:30px;"></html:text>日
			</td>
		</tr>
		<tr>
			<td height="22"  valign="middle" class="BeiZhu" style="text-indent: 20pt;">
			<strong>使用指南：</strong>
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" style="text-indent: 20pt;">
			本文本适用于《上海市政府信息公开规定》第十二条第二款关于“对涉及商
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" >
			业秘密、个人隐私的政府信息需征询权利人意见”的情形。
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" align="center">
			<input type="hidden" name="method" id="method"/>
			<input type="hidden" name="unEdit" id="unEdit"/>
			<input type="hidden" id="id" name="id"  value="${id }"/>
			<input type="hidden" name="passWay" value=<%=passWay%>>
			  <input type="hidden" name="email" value=<%=email%>>
			  <input type="hidden" name="docNum" value=<%=docNum%>>
			<html:hidden property="involveMsg"/>
			<html:hidden property="opinion"/>
			<input id="btnDiv" type="button" value="确 认" onclick="subForm();"/><input type="button" value="打 印" onclick="print();"/><input type="button" value="返 回" onclick="window.location='<%=url %>'"/><input id="reply7" type="button" value="答复书七" onclick="window.location='<%=path %>/reply7.do?method=reply7List&id=<%=id %>&disply=<%=disply%>&status=<%=status%>&docNum=<%=docNum%>&passWay=<%=passWay%>&email=<%=email%>'"/>	
			</td>
		</tr>	
	</table>
	</div>
   </html:form>
  </body>
</html>
<script type="text/javascript">
		//提交页面
		function subForm(){
			//验证
			var consultName = document.getElementById("consultName").value;
			var	contentMsg = document.getElementById("contentMsg").value;
			var	involveMsg = document.getElementById("involveMsg").value;
			var opinion = document.getElementById("opinion").value;
			var	address = document.getElementById("address").value;
			var	postalcode = document.getElementById("postalcode").value;
			
			var replyYear = document.getElementById("replyYear").value;
			var replyMonth = document.getElementById("replyMonth").value;
			var replyDay = document.getElementById("replyDay").value;
			
			var signYear = document.getElementById("signYear").value;
			var signMonth = document.getElementById("signMonth").value;
			var signDay = document.getElementById("signDay").value;
			
			if(""==consultName){
				alert("未填写完整");
				return false;
			}
			if(""==contentMsg){
				alert("未填写完整");
				return false;
			}
			if(involveMsg != 1 && involveMsg != 2){
				alert("未填写完整");
				return false;
			}
			if(opinion != 1 && opinion != 2){
				alert("未填写完整");
				return false;
			}
			if(""==address){
				alert("未填写完整");
				return false;
			}
			
			if(""==replyYear || getLen(replyYear)!= 4 || !(replyYear.match(/^[0-9]+$/))){
				document.getElementById("replyYear").value="";
				document.getElementById("replyYear").focus();
				alert("年份必须为非空4位数字");return false;
			}
			if(""==replyMonth || getLen(replyMonth) > 2 || !(replyMonth.match(/^[0-9]+$/))){
				document.getElementById("signMonth").value="";
				document.getElementById("signMonth").focus();
				alert("月份必须为非空不大于2位的数字");return false;
			}
			if(""==replyDay || getLen(replyDay) > 2 || !(replyDay.match(/^[0-9]+$/))){
				document.getElementById("signDay").value="";
				document.getElementById("signDay").focus();
				alert("日必须为非空不大于2位的数字");
				return false;
			}
			if(""==postalcode ||getLen(postalcode)!= 6 || !(postalcode.match(/^[0-9]+$/))){
				alert("邮政编码必须为非空6位数字");
				return false;
			}
			if(""==signYear || getLen(signYear)!= 4 || !(signYear.match(/^[0-9]+$/))){
				document.getElementById("signYear").value="";
				document.getElementById("signYear").focus();
				alert("年份必须为非空4位数字");return false;
			}
			if(""==signMonth || getLen(signMonth) > 2 || !(signMonth.match(/^[0-9]+$/))){
				document.getElementById("signMonth").value="";
				document.getElementById("signMonth").focus();
				alert("月份必须为非空不大于2位的数字");return false;
			}
			if(""==signDay || getLen(signDay) > 2 || !(signDay.match(/^[0-9]+$/))){
				document.getElementById("signDay").value="";
				document.getElementById("signDay").focus();
				alert("日必须为非空不大于2位的数字");
				return false;
			}
			
			//提交
			document.all.method.value='saveObligeeOpinion';
			document.forms[0].submit(); 
			return true;  
		}
		function isOrNotEdit(){
			if(<%= request.getAttribute("unEdit")%>=='1'){
			  document.getElementById("btnDiv").style.display="none";
			  
			  var inputs=document.getElementsByTagName("input");
				for (i=0;i<inputs.length-3;i++){
					inputs[i].setAttribute('disabled',true);
				}
			}else{
			  	document.getElementById("reply7").style.display="none";
			}
			
			var involveMsg = document.getElementById("involveMsg").value;
			var opinion = document.getElementById("opinion").value;
			if(involveMsg != ""){
				selInvolveMsg(involveMsg);
			}else{
				selInvolveMsg(0);
			}
			
			if(opinion != ""){
				selOpinion(opinion);
			}else{
				selOpinion(0);
			}
		}
		
		function selInvolveMsg(str){
			if(str == 1){	
				document.getElementById("involveMsg1").checked=true;
				document.getElementById("involveMsg2").checked=false;
				document.getElementById("involveMsg").value = document.getElementById("involveMsg1").value;
			}
			if(str == 2){	
				document.getElementById("involveMsg1").checked=false;
				document.getElementById("involveMsg2").checked=true;
				document.getElementById("involveMsg").value = document.getElementById("involveMsg2").value;;
			}
		}
		
		function selOpinion(str){
			if(str == 1){	
				document.getElementById("opinion1").checked=true;
				document.getElementById("opinion2").checked=false;
				document.getElementById("opinion").value = document.getElementById("opinion1").value;
			}
			if(str == 2){	
				document.getElementById("opinion1").checked=false;
				document.getElementById("opinion2").checked=true;
				document.getElementById("opinion").value = document.getElementById("opinion2").value;
			}
		}
		function print(){
			var flag=false;//flag 表示表单是否正确提交
			if(<%= request.getAttribute("unEdit")%>!='1'){
				if(subForm()){
					flag=true;
				}
			}
			if(flag || <%= request.getAttribute("unEdit")%>=='1'){
				var id = document.getElementById("id").value;
				var url = "<%=basePath%>obligeeOpinion.do?method=obligeeOpinionList";
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
