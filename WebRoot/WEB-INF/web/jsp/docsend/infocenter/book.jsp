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
		<title>发文稿纸（拟稿人填写）</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="发文稿纸（拟稿人填写）">
		<link href="images/style.css" rel="stylesheet" type="text/css">

		<script src="<%=path %>/javascript/validate.js"></script>
<script type="text/javascript">
<!--
function init(){
//文件标题、成文机关、主送、抄送、主题词、发文正文、主办单位拟稿人、份数、成文日期、附件
	var needInputs = new Array("fileTitle","fileDept","sendMain","sendSecond","topicWord","fileNum","filePages");
	for(var i=0;i<needInputs.length;i++){
		var obj = document.getElementById(needInputs[i]);
		obj.readOnly=false;
		var pe = obj.parentElement;
		pe.innerHTML += getInputTag();
		obj = document.getElementById("bt_"+needInputs[i]);
		if(obj){
			obj.style.display="inline";
		}
	}
	document.getElementById("fileSecret").style.display="";
	document.getElementById("tr_adddoc").style.display="";
	document.getElementById("secret1").style.display="";
	document.getElementById("secret2").style.display="";
	document.getElementById("sendFileType").style.display="";
	document.getElementById("sendFileTypeX").style.display="";
	document.getElementById("fileType").style.display="";
	document.getElementById("fileTypeName").style.display="none";
	document.getElementById("fileSecretName").style.display="none";
	document.getElementById("secretName").style.display="none";
	document.getElementById("sendFileTypeName").style.display="none";
	document.getElementById("sendFileTypeXName").style.display="none";
	document.getElementById("draftUser").value="${SYSTEM_USER_SESSION.name}";
	checkFileType();
	alertError();
}
//-->
</script>
<script type="text/javascript">
function chk(){
}
function checkForm(form){
	var rs = true;

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
function submitForm(methodType){
	var form = xdocSendForm;
	if(methodType=="addTemp" || checkForm(form)){
		form.method.value=methodType;
		var docId = document.getElementById('docId').value;
		if(docId==""){
			startRequest();
		}
		if(methodType=="addTemp"){
			form.submit();
		}else{
			window.showModalDialog("<%=path%>/xdocSendRelatedAction.do?method=toDeptLeader",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
	}
}
function turnback(){
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=docSendList&type=newAndDoing";
}

var http_request;
function createXMLHttpRequest(){
	if(window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
			http_request.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) { 	
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}	
function startRequest(){
	var url = "";
	url = "xdocSendBook.do?method=uploadWebOffice&fileTitle="+document.getElementById("fileTitle").value;
	createXMLHttpRequest();
	http_request.onreadystatechange = handlestatechange
	http_request.open("post",url,false);
	http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	http_request.setRequestHeader("Cache-Control","no-cache"); 
	http_request.send(null);		  					  		
}
function handlestatechange(){
	if (http_request.readyState==4){
		if (http_request.status==200){
			var result = http_request.responseText;
			var rs = result.split(",");
			document.getElementById("docId").value = rs[0];
			document.getElementById("controlId").value = rs[1];
		}
	}
}
</script>
	</head>
	<body onload="init()">
		<html:form action="/xdocSendBook" enctype="multipart/form-data" method="post">
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
              <td width="84%" class="table2_topic">发文稿纸（拟稿人填写）</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="images/fh.gif" width="46" height="25" border="0" onclick="turnback()"  onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
                <tr>
                  <td colspan="2" align="center" valign="top">
                  <jsp:include page="base_info.jsp"/>
                  </td>
                </tr>
                <tr>
                  <td height="10" colspan="2"></td>
                </tr>
                <tr>
                  <td height="20" colspan="2" align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td align="center">
                      <input type="button" onclick="submitForm('add')" class="button0" value="完成">
                      <input type="button" value="暂存" class="button0" onclick="submitForm('addTemp')"></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="20" colspan="2"></td>
                </tr>
                
              </table></td>
            </tr>
            <tr>
              <td height="10"></td>
            </tr>
          </table></td>
        </tr>
      </table>
</td>
  </tr>
</table>
		<input type="hidden" name="method" />
		<input type="hidden" name="leaderId"/>
		<input type="hidden" name="leaderName"/>
		</html:form>
	</body>
</html>
