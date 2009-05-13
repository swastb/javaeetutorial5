<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String id = request.getParameter("id");
String disply=request.getParameter("disply");
String status=request.getParameter("status");

String url=path+"/tbGovInfoPubMain.do?method=view&id="+id+"&disply="+disply+"&status="+status;

String passWay = request.getParameter("passWay");
String email=request.getParameter("email");
String flag=request.getParameter("flag");
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
  <html:form action="/obligeeMsg.do">
   <div align="center"  id="allBody">
   	 <table width="570" border="0" align="center">
		<tr class="trHeight">
			<td align="center" width="100%" ><span class="titleTop" style="font-size:18.0pt;font-family:SimSun;">公开权利人信息告知单</span>
			</td>
		</tr>
		<tr class="trHeight">
			<td align="right" class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			 沪水务权告（<html:text property="year" styleClass="lineInput1" style="width:40px;" readonly="true"></html:text><span></span>）第<html:text property="autoNo" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span></span>号  
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="obligeeName" styleClass="UNDERLINE150" style="width:200px;"></html:text><span></span>:
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			本机关（机构）在政府信息公开工作中，经审查发现，关于
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="contentMsg" styleClass="lineInput" style="width:350px;" ></html:text> <span></span>的政府信息：
			</td>
		</tr>
		<tr class="trHeight" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<input type="checkbox" name="involveMsg1" id="involveMsg1" value="1" onclick="selInvolveMsg(1);"/><span></span>&nbsp;涉及您个人的信息&nbsp;
			<input type="checkbox" name="involveMsg2" id="involveMsg2" value="2" onclick="selInvolveMsg(2);"/><span></span>&nbsp;涉及您单位的信息
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			经审查，本机关（机构）认为，该信息不公开可能对公共利
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			益造成重大影响，根据《上海市政府信息公开规定》第十二条第
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			二款的规定，决定予以公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			如对本答复不服，可以在收到本答复之日起60日内向上海市
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			人民政府或者中华人民共和国水利部申请行政复议，或者在3个
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			月内向人民法院提起行政诉讼。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			特此告知。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			附：本机关向申请人公开该信息的具体情况
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" align="right" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="signYear" styleClass="lineInput1" style="width:60px;" ></html:text><span></span>年  
			<html:text property="signMonth" styleClass="lineInput1" style="width:30px;"></html:text><span></span>月  
			<html:text property="signDay" styleClass="lineInput1" style="width:30px;"></html:text><span></span>日
			</td>
		</tr>
		<tr>
			<td height="22"  valign="middle" class="BeiZhu" style="text-indent: 20pt;">
			<strong>使用指南：</strong>
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" style="text-indent: 20pt;">
			本文本适用于行政机关主动公开涉及商业秘密、个人隐私的政府信息，以及根据《上海市政府信息公开规定》第二十三条第（七）项的规定，因公共利益需要而决定公开涉及商业秘密、个人隐私的政府信息，告知权利人公开的内容和理由的情形。
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" align="center" id="hidBtn">
			<input type="hidden" name="method" id="method"/>
			<input type="hidden" name="unEdit" id="unEdit"/>
			<input type="hidden" id="id" name="id"  value="${id }"/>
			<html:hidden property="involveMsg"/>
			<input type="hidden" name="content" id="content">
  			<input type="hidden" name="passWay" value=<%=passWay%>>
  			<input type="hidden" name="email" value=<%=email%>>
  			<input type="hidden" name="flag" value=<%=flag%>>
			<input id="btnDiv" type="button" value="确 认" onclick="subForm();"/><input type="button" value="打 印" onclick="print();"/><input type="button" value="返 回" onclick="window.location='<%=url %>'"/>	
			</td>
		</tr>	
	</table>
	</div>
   </html:form>
  </body>
<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height=0
		id=wb name=wb width=0></OBJECT>
</html>
<script type="text/javascript">
		//提交页面
		function subForm(){
			//验证
			var obligeeName = document.getElementById("obligeeName").value;
			var	contentMsg = document.getElementById("contentMsg").value;
			var	involveMsg = document.getElementById("involveMsg").value;
			var signYear = document.getElementById("signYear").value;
			var signMonth = document.getElementById("signMonth").value;
			var signDay = document.getElementById("signDay").value;
			
			if(""==obligeeName){
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
			
			//提交
			document.all.method.value='saveObligeeMsg';
			
			//发送邮件的内容
				if(<%=flag %>=='1'){
					document.getElementById("hidBtn").style.display="none";//提交前按钮隐藏，方便发送邮件的内容
					var inputs = document.getElementsByTagName("input");
					var spans = document.getElementsByTagName("span");
					for (i=0;i<9;i++){
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
			var involveMsg = document.getElementById("involveMsg").value;
			if(involveMsg != ""){
				selInvolveMsg(involveMsg);
			}else{
				selInvolveMsg(0);
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
				document.getElementById("involveMsg").value = document.getElementById("involveMsg2").value;
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
				var url = "<%=basePath%>obligeeMsg.do?method=obligeeMsgList";
				var isOrNotPrint = "print";
				//window.location="<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>