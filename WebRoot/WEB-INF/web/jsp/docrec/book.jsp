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
		<title>上海市水务信息中心公文处理单（登记人填写）</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="上海市水务信息中心公文处理单（登记人填写）">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/javascript/validate.js"></script>
<script type="text/javascript">
<!--
function init(){
//成文日期、来文单位、来文编号、份数、归档类别、文件名称、登记人、附件
	var needInputs = new Array("writeTime","docDept","docCode","docNum","docPage","docName");
	for(var i=0;i<needInputs.length;i++){
		var obj = document.getElementById(needInputs[i]);
		obj.readOnly=false;
		var td_obj = document.getElementById("td_"+needInputs[i]);
		td_obj.style.color = showColor();
	}
	document.getElementById("overDate").onfocus="";
	document.getElementById("td_docType").style.color=showColor();
	document.getElementById("selectDept").style.display="inline";
}
//-->
</script>
<script type="text/javascript">
function chk(){
}
function checkForm(form){
	var rs = true;
	if(!checkEmpty(form.writeTime)){
		rs = false;
	}
	if(!isDate(form.writeTime)){
		alert("日期格式不对");
		rs=false;
	}
	if(!checkEmpty(form.docDept)){
		rs = false;
	}
	if(!checkEmpty(form.docCode)){
		rs = false;
	}
	if(!checkEmpty(form.docNum)){
		rs = false;
	}
	if(!checkEmpty(form.docPage)){
		rs = false;
	}
	if(!checkEmpty(form.docType)){
		rs = false;
	}
	if(!checkEmpty(form.docName)){
		rs = false;
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
	if(methodType=="back" || methodType=="addTemp" || checkForm(form)){
		form.method.value=methodType;
		form.submit();
	}
}
</script>
	</head>

	<body onload="init()">
		<html:form action="/docrecBook" enctype="multipart/form-data" method="post">
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
              <td width="84%" class="table2_topic">上海市水务信息中心<br>公文处理单（登记人填写）</td>
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
                  <jsp:include page="base_info.jsp"></jsp:include>
                  </td>
                </tr>
                <tr>
                  <td height="10" colspan="2"></td>
                </tr>
                <tr>
                  <td height="20" colspan="2" align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td align="center">
                      	<input type="button" value="完成" class="button0" onclick="submitForm('add')"/>
						<input type="button" value="暂存" class="button0" onclick="submitForm('addTemp')"/>
						<input type="button" value="打印" class="button0" onclick="window.print()"/>
                      </td>
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
		</html:form>
	</body>
</html>
