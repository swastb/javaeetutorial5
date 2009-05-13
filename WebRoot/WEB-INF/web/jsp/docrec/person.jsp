<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib prefix="logic" uri="/WEB-INF/tld/struts-logic.tld"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>上海市水务信息中心公文处理单（相关人员处理）</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="上海市水务信息中心公文处理单（相关人员处理）">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/javascript/validate.js"></script>
<script type="text/javascript">
<!--
function init(){
//领导批示、附件
	var needInputs = new Array("assUserRemark");
	for(var i=0;i<needInputs.length;i++){
		var obj = document.getElementById(needInputs[i]);
		obj.readOnly=false;
		var td_obj = document.getElementById("td_"+needInputs[i]);
		td_obj.style.color = showColor();
	}
	document.getElementById("writeTime").onfocus="";
	document.getElementById("overDate").onfocus="";
	document.getElementById("docType").style.display="none";
	document.getElementById("docTypeName").style.display="block";
	document.getElementById("docTypeName").value=document.getElementById("docType").value;
	document.getElementById("personSelect").style.display="block";
}
//-->
</script>
<script type="text/javascript">
function chk(){
}
function checkForm(form){
	var rs = true;
	if(form.leaderAudit.value==""){
		alert("请做出批示！");
		return false;
	}
	var objInput=document.forms[0].getElementsByTagName("input"); 
	for (i=0;i<objInput.length;i++){ 
		if (objInput[i].type=="file"){
			var len=objInput[i].value.length;
			var filename=objInput[i].value.substr(len-4,len).toLowerCase();
			if(filename=='.exe'){
				alert("不能上传可执行文件");
				return false;
			}
		} 
	}
	if(!docRecBookForm.personRadio.checked){
		alert("如果您已看完，请选择已阅！");
		return false;
	}
	return rs;
}
function checkEmpty(obj){
	mySpan = document.getElementById("f"+obj.name);
	if(obj.value == ""){
		mySpan.innerHTML="请输入";
		return false;
	}else{
		mySpan.innerHTML="";
		return true;
	}
}
function onlyNum(){ 
	if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 
	if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105))) 
		event.returnValue=false; 
}
function submitForm(methodType){
	var form = docRecBookForm;
	if(methodType=="back" || methodType=="urgent" || checkForm(form)){
		form.method.value=methodType;
		form.submit();
	}
}
</script>
<script language="javascript">
function changeDiv(showDiv,hideDiv){
	var showObj = document.getElementById(showDiv);
	var hideObj = document.getElementById(hideDiv);
	var cc = event.srcElement.style.color;
	document.getElementById("dispage").style.color=cc;
	document.getElementById("chapage").style.color=cc;
	event.srcElement.style.color="red";
	showObj.style.display="block";
	hideObj.style.display="none";
}
</script>
	</head>

	<body onload="init()">
		<html:form action="/docRecPerson" enctype="multipart/form-data" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#e3eaf1">
  <tr>
    <td width="2" background="images/yy.gif"></td>
    <td align="center" valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">上海市水务信息中心公文处理单（相关人员处理）</td>
            </tr>
          </table></td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th width="94%" height="30" align="right" valign="bottom"><img src="images/fh.gif" width="46" height="25" border="0" onclick="submitForm('back')" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
                <tr>
                  <td colspan="2" align="center" valign="top">
<span id="dispage" onclick="changeDiv('dispose','checkChange');" onmouseover="this.style.cursor='hand'" style="color:red";>公文处理单</span> |
<span id="chapage" onclick="changeDiv('checkChange','dispose');" onmouseover="this.style.cursor='hand'">审查流转单</span>
			<div id="dispose">
		<jsp:include page="base_info.jsp"></jsp:include>
			<table width="99%" border="0" cellpadding="0" cellspacing="0">
				<thead>
				<tr>
                  <td height="10"></td>
                </tr>
					<tr>
						<td align="center">
						<input type="button" value="完成" onclick="submitForm('add')" class="button0" />
						<logic:notEqual name="isUrgent" value="1">
						<input type="button" value="加急" onclick="submitForm('urgent')" class="button0" />
						</logic:notEqual>
						<input type="button" value="打印" onclick="window.print()" class="button0" />
						</td>
					</tr>
				</thead>
			</table>
		</div>
		<div id="checkChange" style="display:none">
		<jsp:include page="sclzd.jsp"></jsp:include>
		</div>
                  </td>
                </tr>
                <tr>
                  <td height="20" colspan="2"></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table>
</td>
  </tr>
</table>
		<input type="hidden" name="method" />

		</html:form>
	</body>
</html>
