<%@ page language="java"  pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
<script type="text/javascript">
		//提交页面
		function subForm(){
			//验证
			var department = document.getElementById("department").value;
			var	contactAddr = document.getElementById("contactAddr").value;
			
			var signYear = document.getElementById("signYear").value;
			var signMonth = document.getElementById("signMonth").value;
			var signDay = document.getElementById("signDay").value;
			
			if(""==department){
				alert("未填写完整");
				return false;
			}
			if(""==contactAddr){
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
			document.all.method.value='saveReply5';
			
				//发送邮件的内容
				if(<%=passWay %>=='17'){
					document.getElementById("hidBtn").style.display="none";//提交前按钮隐藏，方便发送邮件的内容
					var inputs = document.getElementsByTagName("input");
					var spans = document.getElementsByTagName("span");
					for (i=0;i<12;i++){
						inputs[i].style.display="none"
						spans[i+1].innerText= inputs[i].value;
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
				var url = "<%=basePath%>reply5.do?method=reply5List";
				var isOrNotPrint = "print";
				wholeURL = "<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				//window.location="<%=basePath%>print.do?method=add&id="+id+"&needPrintURL="+url+"&isOrNotPrint="+isOrNotPrint;
				window.open(wholeURL,'');
			}
		}
	</script>
  </head>
  
  <body onload="isOrNotEdit();">
  <html:form action="/reply5.do">
  <div align="center" id="allBody">
   	<table width="570" border="0" align="center">
		<tr>
			<td align="center" width="100%" ><span class="titleTop" style="font-size:18.0pt;font-family:SimSun;">政府信息公开申请答复书（五）</span>
			</td>
		</tr>
		<tr class="trHeight">
			<td align="right" class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			 沪水务部答（<html:text property="year" styleClass="lineInput1" readonly="true"></html:text><span ></span>）第<html:text property="applyNo" styleClass="UNDERLINE35" style="width:60px;" readonly="true"></html:text><span ></span>号  
			</td>
		</tr>
		<tr class="trHeight">
			<td class="content" width="100%" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="applicant" styleClass="UNDERLINE150" style="width:200px;" readonly="true"></html:text><span ></span>:
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 30pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			本机关（机构）于<html:text property="applyYear" styleClass="lineInput" style="width:60px;"  readonly="true"></html:text><span ></span>年  
			<html:text property="applyMonth" styleClass="lineInput" style="width:30px;"  readonly="true"></html:text><span ></span>月  
			<html:text property="applyDay" styleClass="lineInput" style="width:30px;"  readonly="true"></html:text><span ></span>日收到了您（单位）
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			要求获取<html:text property="applyTitle" styleClass="lineInput" style="width:434px;"  readonly="true"></html:text> <span ></span>的申
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			请。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			现依据《上海市政府信息公开规定》第二十三条第（五）项
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			的规定，答复如下：
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			您（单位）要求获取的政府信息不属于本机关（机构）公开
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			职责权限范围。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			建议您（单位）向<html:text property="department" styleClass="lineInput" style="width:355px;" ></html:text><span ></span>
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			咨询，联系方式为<html:text property="contactAddr" styleClass="lineInput" style="width:200px;" ></html:text><span ></span>。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			如对本答复不服，可以在收到本答复之日起60日内向上海
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			市人民政府或者中华人民共和国水利部申请行政复议，或者在3
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			个月内向人民法院提起行政诉讼。
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content"  style="text-indent: 32pt;font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			特此告知。
			</td>
		</tr>
		
		<tr class="trHeight">
			<td width="100%" class="content">
			&nbsp;
			</td>
		</tr>
		<tr class="trHeight">
			<td width="100%" class="content" align="right" style="font-size:15.0pt;mso-char-indent-count:2.0;mso-bidi-font-size:12.0pt;">
			<html:text property="signYear" styleClass="lineInput1" size="4" ></html:text><span ></span>年  
			<html:text property="signMonth" styleClass="lineInput1" size="2"></html:text><span ></span>月  
			<html:text property="signDay" styleClass="lineInput1" size="2"></html:text><span ></span>日
			</td>
		</tr>
		<tr>
			<td height="22"  valign="middle" class="BeiZhu" style="text-indent: 20pt;">
			<strong>使用指南：</strong>
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" style="text-indent: 20pt;">
			本文本适用于《上海市政府信息公开规定》第二十三条第（五）项关于“不
			</td>
		</tr>
		<tr>
			<td height="22"   valign="middle" class="BeiZhuCon" >
			属于本机关公开职责权限范围”情形的答复。
			</td>
		</tr>
		
		<tr>
			<td height="28"  valign="middle" align="center" id="hidBtn">
			<input type="hidden" name="method" id="method"/>
			<input type="hidden" name="unEdit" id="unEdit"/>
			
			<input type="hidden" id="id" name="id"  value="${id }"/>
			<input type="hidden" id="rem" name="rem"  value="${rem }"/>
			  <input type="hidden" name="content" id="content">
   			<input type="hidden" name="passWay" value=<%=passWay%>>
   			<input type="hidden" name="email" value=<%=email%>>
			<input id="btnDiv"  type="button" value="确 认" onclick="subForm();"/><input type="button" value="打 印" onclick="print();"/><input type="button" value="返 回" onclick="window.location='<%=url %>'"/>
				
			
			</td>
		</tr>	
	</table>
	</div>
   </html:form>
  </body>
</html>