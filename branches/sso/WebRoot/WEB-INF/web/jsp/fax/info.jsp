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
		<title>传真发送</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="传真发送">
		<link href="images/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function submitForm(){
	document.getElementById("method").value="add";
	if(faxScheduleForm.fileUpload.value==""){
		alert("选择上传文件！");
		return;
	}
	if(faxScheduleForm.faxNum.value==""){
		alert("输入传真号码!");
		return;
	}
	faxScheduleForm.submit();
}
function clearForm(){
	faxScheduleForm.reset();
}
function addbookList(flag,tid,tname,tmb){
	//window.showModalDialog("<%=path%>/commonalityTree.do?method=input&idText="+tid+"&nameText="+tname+"&mobileText="+tmb+"&type=fax&flag="+flag,window,'dialogwidth:450px;dialogheight:500px;help:0;center:yes;resizable:0;status:0;scroll:yes');
	oo = window.open("<%=path%>/commonalityTree.do?method=input&idText="+tid+"&nameText="+tname+"&mobileText="+tmb+"&type=fax&flag="+flag,"",'width=450px;height=500px;top=100, left=300, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
	window.setTimeout(function(){replaceTmb(tmb);},1000);
}
function replaceTmb(tmb){
	if(oo.closed){
		var obj = document.getElementById(tmb);
		obj.value = obj.value.replace(/\,/g,";");
		return;
	}
	window.setTimeout(function(){replaceTmb(tmb);},1000);
}
var num = 1;
function additem(id){
	var row,cell,str; 
	row = eval("document.all["+'"'+id+'"'+"]").insertRow();
	if(row != null ){
		cell = row.insertCell();
		str="<input type="+'"'+"file"+'"'+" name=uploadFile["+ num +"].file onkeydown="+'"'+"event.returnValue=false;"+'"'+" onpaste="+'"'+" return false"+'"'+"><input type="+'"'+"button"+'"'+" value="+'"'+"删除"+'"'+" onclick='deleteitem(this,"+'"'+id+'"'+");' class='button0'>";
		cell.innerHTML=str;
	}
	num++;
}
function deleteitem(obj,id){
	var rowNum,curRow;
	curRow = obj.parentNode.parentNode;
	rowNum = eval("document.all."+id).rows.length - 1;
	eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex); 
}
</script>

	</head>

	<body>
		<html:form action="/faxSchedule" enctype="multipart/form-data" method="post">
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
              <td width="84%" class="table2_topic">传真发送</td>
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
                  <td colspan="2" align="center" valign="top">
			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
				<thead>
					<tr>
						<th height="23" width="10%">文件上传</th>
						<td><input type="file" name="fileUpload" onkeydown="event.returnValue=false;"></td>
					</tr>
					<tr>
						<th height="23">附件</th>
						<td><table id="tb" cellpadding="0" cellspacing="0"></table>
							<div id="divBtnAdd">
								<input type="button" name="btnAddFile" value="添加附件" onclick="additem('tb')" class="button0"/>
								<font color="red">上传附件文件不能大于10M!</font>
							</div>
						</td>
					</tr>
					<tr>
						<th height="23">正文内容</th>
						<td><textarea name="bodyContent" class="tabin_textarea2" cols="60" rows="5"></textarea></td>
					</tr>
					<tr>
						<th height="23">发送对象</th>
						<td><textarea name="senderNames" class="tabin_textarea2" cols="60" rows="5" readonly></textarea><br>
							<input type="button" class="button0" value="公共通讯录" onclick="addbookList('','senderIds','senderNames','faxNum')"/>
							<input type="button" class="button0" value="清除对象" onclick="clearSenders()"/>
							<input type="hidden" name="senderIds"/>
						</td>
					</tr>
					<tr>
						<th height="23">传真号码</th>
						<td><input type="text" name="faxNum" class="tab_input" /></td>
					</tr>
					<tr>
						<th height="23">&nbsp;</th>
						<td>(如不通过通讯录选人可直接填写传真号码，多个号码之间以分号(;)分隔！不能发送外地传真，外线请在传真号码前加"0"，分机号请以"-"连接.例如：输入"052397000-6639;6654"。相当发送两封传真，谢谢!)</td>
					</tr>
					<tr>
						<th height="23">&nbsp;</th>
						<td><input type="checkbox" name="sendContext" value="1"/>发送传真正文&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="sendSM" value="1"/>短信通知</td>
					</tr>
					<tr>
						<td colspan="10" height="23" align="center">
						<input type="button" class="button0" value="提交" onclick="submitForm()">
						<input type="button" class="button0" value="取消" onclick="clearForm()">
						</td>
					</tr>
				</thead>
			</table>
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
