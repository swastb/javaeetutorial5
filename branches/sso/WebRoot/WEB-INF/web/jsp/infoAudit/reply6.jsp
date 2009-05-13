<%@ page language="java"  pageEncoding="GBK"%>
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
  <html:form action="/reply6.do">
  <div align="center" id="allBody">
   	<table width="580" border="0" align="center" >
		<tr class="trHeight">
			<td align="center" width="100%" ><span class="titleTop" style="font-size:18.0pt;font-family:SimSun;">政府信息公开申请答复书（六）</span>
			</td>
		</tr>
		<tr class="trHeight">
			<td align="right" class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			 沪水务部答（<html:text property="year" styleClass="lineInput1"  readonly="true"></html:text><span></span>）第<html:text property="applyNo" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span></span>号  
			</td>
		</tr>
		<tr class="trHeight">
			<td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="applicant" styleClass="UNDERLINE150" style="width:200px;" readonly="true"></html:text><span></span>:
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			本机关（机构）于<html:text property="applyYear" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span></span>年  
			<html:text property="applyMonth" styleClass="UNDERLINE35" style="width:30px;" readonly="true"></html:text><span></span>月  
			<html:text property="applyDay" styleClass="UNDERLINE35" style="width:30px;" readonly="true"></html:text><span></span>日收到了您（单位）
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			要求获取<html:text property="applyTitle" styleClass="UNDERLINE320" style="width:440px;" readonly="true"></html:text> <span></span>的申
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			请。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			经审查，您（单位）申请获取的政府信息中有部分内容属于
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<input type="checkbox" name="type1" id="type1" value="1" onclick="selType(1);"/><span></span>国家秘密  
			<input type="checkbox" name="type2" id="type2" value="2" onclick="selType(2);"/><span></span>商业秘密  
			<input type="checkbox" name="type3" id="type3" value="3" onclick="selType(3);"/><span></span>个人隐私 
			<input type="checkbox" name="type4" id="type4" value="4" onclick="selType(4);"/><span></span>法律法规  &nbsp;规定的不予公
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			开的其他情形。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			根据《中华人民共和国政府信息公开条例》第二十二条、
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			《上海市政府信息公开规定》第二十三条第（六）项的规定，本
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			机关（机构）对该部分信息不予公开，其余信息予以公开。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			对属于公开范围的政府信息，根据《上海市政府信息公开规
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			定》第二十六条的规定，<input type="checkbox" name="sendWay1" id="sendWay1" value="1" onclick="selSendWay(1);"/><span></span>本机关将当场提供&nbsp;&nbsp;  
			<input type="checkbox" name="sendWay2" id="sendWay2" value="2" onclick="selSendWay(2);"/><span></span>通过电子邮件
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<input type="checkbox" name="sendWay3" id="sendWay3" value="3" onclick="selSendWay(3);"/><span></span>邮寄方式 予以提供。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			如对本答复不服，可以在收到本答复之日起60日内向上海市
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			人民政府或者中华人民共和国水利部申请行政复议，或者在3个月
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			内向人民法院提起行政诉讼。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			特此告知。
			</td>
		</tr>
		
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  align="right" style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
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
			<td height="22"   valign="middle" class="BeiZhuCon" style="text-indent: 23pt;">
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
			<html:hidden property="type"/>
			<html:hidden property="sendWay"/>
			<input type="hidden" name="content" id="content">
 			<input type="hidden" name="passWay" value=<%=passWay%>>
  			<input type="hidden" name="email" value=<%=email%>>
			<input id="btnDiv" type="button" value="确 认" onclick="subForm();"/><input type="button" value="打 印" onclick="print();"/><input type="button" value="返 回" onclick="window.location='<%=url %>'"/>
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
			var type = document.getElementById("type").value;
			var	sendWay =document.getElementById("sendWay").value;
			var signYear = document.getElementById("signYear").value;
			var signMonth = document.getElementById("signMonth").value;
			var signDay = document.getElementById("signDay").value;
			
			if(type != 1 && type != 2 && type != 3 && type != 4){
				alert("未填写完整");
				return false;
			}
			if(sendWay != 1 && sendWay != 2 && sendWay != 3){
				alert("未填写完整");
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
			//发送邮件的内容
				if(<%=passWay %>=='17'){
					document.getElementById("hidBtn").style.display="none";//提交前按钮隐藏，方便发送邮件的内容
					var inputs = document.getElementsByTagName("input");
					var spans = document.getElementsByTagName("span");
					for (i=0;i<17;i++){
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
			document.all.method.value='saveReply6';
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
			var sendWay = document.getElementById("sendWay").value;
			var type = document.getElementById("type").value;
			
			if(type!=""){
				selType(type);
			}else{
				selType(0);
			}
			if(sendWay!=""){
				selSendWay(sendWay);
			}else{
				selSendWay(0);
			}
		}
		function selType(str){
			if(str == 1){	
				document.getElementById("type1").checked = true;
				document.getElementById("type2").checked = false;
				document.getElementById("type3").checked = false;
				document.getElementById("type4").checked = false;
				document.getElementById("type").value = document.getElementById("type1").value;
			}
			if(str == 2){	
				document.getElementById("type1").checked=false;
				document.getElementById("type2").checked=true;
				document.getElementById("type3").checked=false;
				document.getElementById("type4").checked=false;
				document.getElementById("type").value = document.getElementById("type2").value;
			}
			if(str == 3){	
				document.getElementById("type1").checked=false;
				document.getElementById("type2").checked=false;
				document.getElementById("type3").checked=true;
				document.getElementById("type4").checked=false;
				document.getElementById("type").value = document.getElementById("type3").value;
			}
			if(str == 4){	
				document.getElementById("type1").checked=false;
				document.getElementById("type2").checked=false;
				document.getElementById("type3").checked=false;
				document.getElementById("type4").checked=true;
				document.getElementById("type").value = document.getElementById("type4").value;
			}
		}
		function selSendWay(str){
			if(str == 1){	
				document.getElementById("sendWay1").checked=true;
				document.getElementById("sendWay2").checked=false;
				document.getElementById("sendWay3").checked=false;
				document.getElementById("sendWay").value = document.getElementById("sendWay1").value;
			}
			if(str == 2){	
				document.getElementById("sendWay1").checked=false;
				document.getElementById("sendWay2").checked=true;
				document.getElementById("sendWay3").checked=false;
				document.getElementById("sendWay").value = document.getElementById("sendWay2").value;
			}
			if(str == 3){	
				document.getElementById("sendWay1").checked=false;
				document.getElementById("sendWay2").checked=false;
				document.getElementById("sendWay3").checked=true;
				document.getElementById("sendWay").value = document.getElementById("sendWay3").value;
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
				var url = "<%=basePath%>reply6.do?method=reply6List&id="+id;
				//var url = encodeURIComponent(url1);
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>