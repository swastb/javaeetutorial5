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
		<title>发文稿纸（负责人填写）</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="发文稿纸（负责人填写）">
		<link href="images/style.css" rel="stylesheet" type="text/css">
		<script src="<%=path %>/javascript/validate.js"></script>

<script type="text/javascript">
<!--
function init(){
//负责人、会稿单位、附件
	var needInputs = new Array("mainChargeUser","mainSignDept");
	for(var i=0;i<needInputs.length;i++){
		var obj = document.getElementById(needInputs[i]);
		obj.readOnly=false;
		var pe = obj.parentElement;
		pe.innerHTML += getInputTag();
	}
	document.getElementById("fileDate").onfocus="";
	document.getElementById("mainChargeUser").value="${SYSTEM_USER_SESSION.name}";
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
	var form = docSendForm;
	if(checkForm(form)){
		form.method.value=methodType;
		form.submit();
	}
}
function turnback(){
	window.location.href="<%=path%>/docSendRelatedAction.do?method=docSendList&type=newAndDoing";
}
function openChooseSigner(){
	window.showModalDialog("<%=path%>/userTree.do?method=input&idText=signUserId&nameText=signUserName&rootId=${treeRootId==null?"":treeRootId}&flag=participant",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
function shwoChargerDiv(){
	document.getElementById("chargerDiv").style.display="";
}
</script>
<script language="javascript">
function changeDiv(showDiv,hideDiv){
	var showObj = document.getElementById(showDiv);
	var hideObj = document.getElementById(hideDiv);
	showObj.style.display="block";
	hideObj.style.display="none";
}
</script>
	</head>

	<body onload="init()">
		<html:form action="/docSendCharger" enctype="multipart/form-data" method="post">
		<div id="chargerDiv" style="position:absolute;display:none;border=1px;padding5px;background:#e3eaf1;width=200;z-index:auto;left:350;top:350;">
		<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
		<tr><td colspan="2" align="center" height="20">
		<b>报领导</b>
		</td></tr>
		<tr><td height="25">
		<input type="radio" name="chargerRidio" value="1"/>会签</td>
		<td><input type="button" name="chooseSigner" value="选择会签对象" onclick="openChooseSigner()" class="button0"></td>
		</tr>
		<tr><td colspan="2" height="25">
		<input type="radio" name="chargerRidio" value="2"/>直接转局办公室负责人接收</td>
		</tr>
		<tr><td colspan="2" align="center" height="25">
		<input type="button" name="submit1" value="提交" onclick="submitForm('update')" class="button0">
		<input type="button" name="cancel1" value="取消" onclick="document.getElementById('chargerDiv').style.display='none';" class="button0">
		<input type="hidden" name="signUserId">
		<input type="hidden" name="signUserName">
		</td></tr>
		</table>
		</div>
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
              <td width="84%" class="table2_topic">发文稿纸（负责人填写）</td>
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
<a href="#" class="bg-zw" onclick="changeDiv('dispose','checkChange');return false;">公文处理单</a> <span class="bg-zw">|</span>
<a href="#" class="bg-zw" onclick="changeDiv('checkChange','dispose');return false;">审查流转单</a>
			<div id="dispose">
			<jsp:include page="base_info.jsp"/>
			<table align="center" width="99%" border="0" cellpadding="0" cellspacing="0">
				<thead>
				<tr>
                  <td height="10"></td>
                </tr>
					<tr>
						<td align="center">
						<input type="button" onclick="shwoChargerDiv();" class="button0" value="完成">
						</td>
					</tr>
				</thead>
			</table>
		</div>
		<div id="checkChange" style="display:none">
		<jsp:include page="lcljd.jsp"/>
		</div>
                  </td>
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