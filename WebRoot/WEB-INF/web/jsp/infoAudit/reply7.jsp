<%@ page language="java" pageEncoding="GBK"%>
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
String url=path+"/obligeeOpinion.do?method=obligeeOpinionList&id="+id+"&disply="+disply+"&status="+status+"&docNum="+docNum+"&passWay="+passWay+"&email="+email;
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
  <div align="center" id="allBody">
  <html:form action="/reply7.do">
   	<div align="center">
   	<table width="570" border="0">
		<tr class="trHeight">
			<td align="center" width="100%" ><span class="titleTop">政府信息公开申请答复书（七）</span>
			</td>
		</tr>
		<tr class="trHeight">
			<td align="right" class="content" width="100%">
			 沪水务部答（<html:text property="year" styleClass="lineInput1"  readonly="true"></html:text><span ></span>）第<html:text property="applyNo" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span ></span>号  
			</td>
		</tr>
		<tr class="trHeight">
			<td class="content" width="100%">
			<html:text property="applicant" styleClass="UNDERLINE150" style="width:200px;" readonly="true"></html:text><span ></span>:
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			本机关（机构）于<html:text property="applyYear" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span ></span>年  
			<html:text property="applyMonth" styleClass="UNDERLINE35" style="width:30px;" readonly="true"></html:text><span ></span>月  
			<html:text property="applyDay" styleClass="UNDERLINE35" style="width:30px;" readonly="true"></html:text><span ></span>日收到了您（单位）
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			要求获取<html:text property="applyTitle" styleClass="UNDERLINE320" style="width:434px;" readonly="true"></html:text><span ></span> 的申
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			请。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			经审查，您（单位）要求获取的政府信息涉及 <input type="checkbox" name="attr31" id="attr31" value="1" onclick="selAttr3(1);"/><span></span>&nbsp;国家秘密 
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			<input type="checkbox" name="attr32" id="attr32" value="2" onclick="selAttr3(2);"/><span></span>&nbsp;个人隐私 
			</td>
		</tr>
		
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			根据《中华人民共和国政府信息公开条例》第二十三条、
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			《上海市政府信息公开规定》第十二条第二款的规定，现答复如
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			下：
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" name="replyType1" id="replyType1" value="1" onclick="selReplyType(1);"/><span></span>&nbsp;经征求权利人意见，其同意公开，本机关（机构）因此
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			予以公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" name="replyType2" id="replyType2" value="2" onclick="selReplyType(2);"/><span></span>&nbsp;权利人不同意公开，本机关（机构）因此不予公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" name="replyType3" id="replyType3" value="3" onclick="selReplyType(3);"/><span></span>&nbsp;权利人未在规定期限内作出答复，本机关（机构）因此
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			不予公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" name="replyType4" id="replyType4" value="4" onclick="selReplyType(4);"/><span></span>&nbsp;本机关（机构）认为不公开可能对公共利益造成重大影
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			响，决定予以公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			<input type="checkbox" disabled>根据《上海市政府信息公开规定》第二十六条的规定本机
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			关将通过<input type="checkbox" name="offerWay1" id="offerWay1" value="1" onclick="selOfferWay(1);"/><span></span>当场提供  
			<input type="checkbox" name="offerWay2" id="offerWay2" value="2" onclick="selOfferWay(2);"/><span></span>电子邮件
			<input type="checkbox" name="offerWay3" id="offerWay3" value="3" onclick="selOfferWay(3);"/><span></span>邮寄 方式予以提供。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			如对本答复不服，可以在收到本答复之日起60日内向上海市
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			人民政府或者中华人民共和国水利部申请行政复议，或者在3个
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			月内向人民法院提起行政诉讼。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;">
			特此告知。
			</td>
		</tr>
		
		<tr class="trHeight">
			<td width="100%" class="content">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  align="right">
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
			本文本适用于《上海市政府信息公开规定》第二十三条第（六）项关于“含
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" >
			有不应当公开的内容，但能够区分处理，应当部分告知申请人；对不予公开的，
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" >
			应当说明理由的”情形的答复。
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" align="center" id="hidBtn">
			<input type="hidden" name="method" id="method"/>
			<input type="hidden" name="unEdit" id="unEdit"/>
			<input type="hidden" id="id" name="id"  value="${id }"/>
			<input type="hidden" name="content" id="content">
			  <input type="hidden" name="passWay" value=<%=passWay%>>
			  <input type="hidden" name="email" value=<%=email%>>
			  <input type="hidden" name="docNum" value=<%=docNum%>>
			<html:hidden property="offerWay"/>
			<html:hidden property="attr3"/>
			<html:hidden property="replyType"/>
			<input id="btnDiv" type="button" value="确 认" onclick="subForm();"/><input type="button" value="打 印" onclick="print();"/><input type="button" value="返 回" onclick="window.location='<%=url %>'"/>
			</td>
		</tr>	
	</table>
   </html:form>
   </div>
  </body>
</html>
<script type="text/javascript">
		//提交页面
		function subForm(){
			//验证
			var replyType = document.getElementById("replyType").value;
			var	offerWay = document.getElementById("offerWay").value;
			var	attr3 = document.getElementById("attr3").value;
			
			var signYear = document.getElementById("signYear").value;
			var signMonth = document.getElementById("signMonth").value;
			var signDay = document.getElementById("signDay").value;
			if(attr3 != 1 && attr3 != 2){
				alert("未填写完整");
				return false;
			}
			if(replyType!=1 && replyType!=2 && replyType!=3 && replyType!=4){
			 	alert("未填写完整");
				return false;
			}
			
			if(offerWay!=1 && offerWay!=2 && offerWay!=3){
				alert("未填写完整");
				return false;
			}
		
			if(""==signYear || getLen(signYear)!= 4 || !(signYear.match(/^[0-9]+$/))){
				document.getElementById("signYear").value="";
				document.getElementById("signYear").focus();
				alert("申请盖章年份必须为非空4位数字");return false;
			}
			if(""==signMonth || getLen(signMonth) > 2 || !(signMonth.match(/^[0-9]+$/))){
				document.getElementById("signMonth").value="";
				document.getElementById("signMonth").focus();
				alert("申请盖章月份必须为非空不大于2位的数字");return false;
			}
			if(""==signDay || getLen(signDay) > 2 || !(signDay.match(/^[0-9]+$/))){
				document.getElementById("signDay").value="";
				document.getElementById("signDay").focus();
				alert("申请盖章日必须为非空不大于2位的数字");
				return false;
			}
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
			//提交
			document.all.method.value='saveReply7';
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
			//设置复选框被选择的情况
			var offerWay = document.getElementById("offerWay").value;
			var attr3 = document.getElementById("attr3").value;
			var replyType = document.getElementById("replyType").value;
			if(attr3!=""){
				selAttr3(attr3);
			}else{
				selAttr3(0);
			}
			if(replyType!=""){
				selReplyType(replyType);
			}else{
				selReplyType(0);
			}
			if(offerWay!=""){
				selOfferWay(offerWay);
			}else{
				selOfferWay(0);
			}
		}
		
		//设置checkbox的选项
		function selOfferWay(str){
			// 政府信息的的提供方式
			var offerWay=str;
			if(str == 1){	
				document.getElementById("offerWay1").checked=true;
				document.getElementById("offerWay2").checked=false;
				document.getElementById("offerWay3").checked=false;
				document.getElementById("offerWay").value = document.getElementById("offerWay1").value;
			}
			if(str == 2){	
				document.getElementById("offerWay1").checked=false;
				document.getElementById("offerWay2").checked=true;
				document.getElementById("offerWay3").checked=false;
				document.getElementById("offerWay").value = document.getElementById("offerWay2").value;
			}
			if(str == 3){	
				document.getElementById("offerWay1").checked=false;
				document.getElementById("offerWay2").checked=false;
				document.getElementById("offerWay3").checked=true;
				document.getElementById("offerWay").value = document.getElementById("offerWay3").value;
			}
		}
		
		function selAttr3(str){
			var attr3=str;
			if(str == 1){	
				document.getElementById("attr31").checked=true;
				document.getElementById("attr32").checked=false;
				document.getElementById("attr3").value = document.getElementById("attr31").value;
			}
			if(str == 2){	
				document.getElementById("attr31").checked=false;
				document.getElementById("attr32").checked=true;
				document.getElementById("attr3").value = document.getElementById("attr32").value;
			}
		}
		
		function selReplyType(str){
			var replyType=str;
			if(str == 1){	
				document.getElementById("replyType1").checked = true;
				document.getElementById("replyType2").checked = false;
				document.getElementById("replyType3").checked = false;
				document.getElementById("replyType4").checked = false;
				document.getElementById("replyType").value = document.getElementById("replyType1").value;
			}
			if(str == 2){	
				document.getElementById("replyType1").checked=false;
				document.getElementById("replyType2").checked=true;
				document.getElementById("replyType3").checked=false;
				document.getElementById("replyType4").checked=false;
				document.getElementById("replyType").value = document.getElementById("replyType2").value;
			}
			if(str == 3){	
				document.getElementById("replyType1").checked=false;
				document.getElementById("replyType2").checked=false;
				document.getElementById("replyType3").checked=true;
				document.getElementById("replyType4").checked=false;
				document.getElementById("replyType").value = document.getElementById("replyType3").value;
			}
			if(str == 4){	
				document.getElementById("replyType1").checked=false;
				document.getElementById("replyType2").checked=false;
				document.getElementById("replyType3").checked=false;
				document.getElementById("replyType4").checked=true;
				document.getElementById("replyType").value = document.getElementById("replyType4").value;
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
				var url = "<%=basePath%>reply7.do?method=reply7List";
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>