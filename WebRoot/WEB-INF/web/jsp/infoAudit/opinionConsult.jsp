<%@ page language="java"  pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<script type="text/javascript">
		//提交页面
		function subForm(){
			//验证
			var year = document.getElementById("year").value;
			var month = document.getElementById("month").value;
			var day = document.getElementById("day").value;
			var year1 = document.getElementById("year1").value;
			var month1 = document.getElementById("month1").value;
			var day1 = document.getElementById("day1").value;
			
			var attr1 = document.getElementById("attr1").value;
			var	attr2 = document.getElementById("attr2").value;
			var	numb = document.getElementById("numb").value;
			var	consultedName = document.getElementById("consultedName").value;
			var	applicant = document.getElementById("applicant").value;
			var	cause = document.getElementById("cause").value;
			var	address = document.getElementById("address").value;
			var	postalcode = document.getElementById("postalcode").value;
			
			if(""==attr1){
				alert("不能为空");return false;
			}
			if(""==attr2){
				alert("不能为空");return false;
			}
			if(""==numb || !numb.match(/^[0-9]+$/)){
				alert("申请号不能为空且必须是数字");return false;
			}
			if(""==consultedName){
				alert("被征询人姓名不能为空");return false;
			}
			if(""==year || getLen(year)!= 4 || !(year.match(/^[0-9]+$/))){
				document.getElementById("year")="";
				document.getElementById("year").focus();
				alert("收到申请年份必须为非空4位数字");return false;
			}
			if(""==month || getLen(month) > 2 || !(month.match(/^[0-9]+$/))){
				document.getElementById("month").value="";
				document.getElementById("month").focus();
				alert("收到申请月份必须为非空不大于2位的数字");return false;
			}
			if(""==day || getLen(day) > 2 || !(day.match(/^[0-9]+$/))){
				document.getElementById("day").value="";
				document.getElementById("day").focus();
				alert("收到申请日必须为非空不大于2位的数字");return false;
			}
			if(""==applicant){
				alert("申请人不能为空");return false;
			}
			if(""==cause){
				alert("原因不能为空");return false;
			}
			if(""==address ){
				alert("地址不能为空！");return false;
			}
			if(""==postalcode || getLen(postalcode)!= 6 || !(postalcode.match(/^[0-9]+$/))){
				alert("邮政编码必须为非空6位数字！");return false;
			}
			if(""==year1 || getLen(year1)!= 4 || !(year1.match(/^[0-9]+$/))){
				document.getElementById("year1")="";
				document.getElementById("year1").focus();
				alert("申请盖章年份必须为非空4位数字");return false;
			}
			if(""==month1 || getLen(month1) > 2 || !(month1.match(/^[0-9]+$/))){
				document.getElementById("month1").value="";
				document.getElementById("month1").focus();
				alert("申请盖章月份必须为非空不大于2位的数字");return false;
			}
			if(""==day1 || getLen(day1) > 2 || !(day1.match(/^[0-9]+$/))){
				document.getElementById("day1").value="";
				document.getElementById("day1").focus();
				alert("申请盖章日必须为非空不大于2位的数字");return false;
			}
			
			//提交
			document.all.method.value='saveOpinion';
				//document.all.id.value=1;
			document.forms[0].submit();   
		}
		
		//设置页面按钮不显示
		function hidBtn(){	
			btnDiv.style.display="none";   
		}
	
	</script>	
  </head>
  
  <body>
   <html:form action="/opinionConsult.do">
   	<table width="590" align="center" border="0" cellpadding="0" cellspacing="0"
				bordercolor="97cdda" class="tableborder">
		<tr>
			<td height="28"   align="center" valign="middle" >
				<strong>第三方意见征询单</strong>
			</td>
		</tr>
		<tr>
			<td height="28" align="right" valign="middle" style="letter-spacing:0.3em;">
			<html:text property="attr1" styleClass="lineInput" style="width:150px;"></html:text>（
			<html:text property="attr2" styleClass="lineInput" style="width:50px;"></html:text>）第<html:text property="numb" styleClass="lineInput" style="width:50px;"></html:text>号-意征单
			</td>
		</tr>
		<tr>
			<td height="28" valign="middle" >
			<html:text property="consultedName" styleClass="lineInput" style="width:200px;"></html:text>
			</td>
		</tr>
		<tr>
			<td height="28" valign="middle" style="text-indent: 32pt;letter-spacing:0.3em;">
			本机关于
			<html:text property="year" styleClass="lineInput" style="width:60px;" ></html:text>年  
			<html:text property="month" styleClass="lineInput" style="width:30px;"></html:text>月  
			<html:text property="day" styleClass="lineInput" style="width:30px;"></html:text>日收到<html:text property="applicant" styleClass="lineInput" style="width:200px;"></html:text> 
			</td>
		</tr>
		<tr >
			<td height="28"  valign="middle"  style="letter-spacing:0.3em;">
			根据《上海市政府信息公开规定》提出的政府信息公开申请（详
			</td>
		</tr>
		<tr>
			<td height="28" valign="middle" style="letter-spacing:0.3em;">
			情参见《政府信息公开申请书》）。由于其申请的政府信息
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="text-indent: 32pt;letter-spacing:0.3em;">
			<html:radio property="cause" value="0"></html:radio>属于您单位商业秘密或者公开可能导致您单位商业秘密被
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			泄露
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="text-indent: 32pt;letter-spacing:0.3em;">
			<html:radio property="cause" value="1"></html:radio>属于您的个人隐私或者公开可能导致您的个人隐私权遭受
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			不当侵害
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="text-indent: 32pt;letter-spacing:0.3em;">
			根据《上海市政府信息公开规定》第十四条规定，特向您（
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			单位）征询是否同意提供该政府信息的意见，并将意见邮寄至：
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			<html:text property="address" styleClass="lineInput" style="width:300px;"></html:text>
			（邮政编码：<html:text property="postalcode" styleClass="lineInput" style="width:100px;"></html:text>）
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="text-indent: 32pt;letter-spacing:0.3em;">
			如果您（单位）在收到本征询单之后10个工作日内未作出
			</td>
		</tr>
		<tr>
			<td height="28" valign="middle" style="letter-spacing:0.3em;" >
			答复，则视为您（单位）不同意提供上述信息。
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" align="right" style="letter-spacing:0.3em;">
			（机关盖章）
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" align="right" style="letter-spacing:0.3em;">
			 <html:text property="year1" styleClass="lineInput" style="width:60px;"></html:text>年  
			<html:text property="month1" styleClass="lineInput" style="width:30px;"></html:text>月  
			<html:text property="day1" styleClass="lineInput" style="width:30px;"></html:text>日
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			附件：
			</td>
		</tr>
		<tr>
			<td height="28"   valign="middle" style="letter-spacing:0.3em;">
			1．政府信息公开申请书或申请内容摘要
			</td>
		</tr>
		<tr>
			<td height="28"  valign="middle" style="letter-spacing:0.3em;">
			2．第三方意见征询回执
			</td>
		</tr>
		
		<tr>
			<td height="28"  valign="middle" align="center">
			<div id="btnDiv">
			<input type="button" value="确 认" onclick="subForm();"/>
			<input type="button" value="返 回" onclick="window.location='tbGovInfoPubMain.do?method=view&id=<%=request.getParameter("id")%>'"/>
			<input type="button" value="打 印" onclick="hidBtn();"/>
			</div>
			<input type="hidden" name="method" id="method"/>
			<input type="hidden" name="action1" id="action1"/>
			<input type="hidden" name="id" id="id"/>
			<html:hidden property="action"/>
			<html:hidden property="govInfoId"/>
			<html:hidden property="id"/>
			</td>
		</tr>	
	</table>
   </html:form>
  </body>
</html>
