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
		<title>短信转发：人员管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="短信转发：人员管理">
		<link href="images/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function submitForm(){
	document.getElementById("method").value="add";
	smsTransferForm.submit();
}
function clearForm(){
	document.getElementById("id").value="";
	document.getElementById("receiveName").value="";
	document.getElementById("receiveDept").value="";
	document.getElementById("receiveMobile").value="";
	document.getElementById("receiveType").value="";
	document.getElementById("fee").value="";
}
function modify(infoId){
	document.getElementById("method").value="input";
	document.getElementById("id").value=infoId;
	smsTransferForm.submit();
}
function deleteInfo(infoId){
	document.getElementById("method").value="delete";
	document.getElementById("id").value=infoId;
	smsTransferForm.submit();
}
function query(){
	document.getElementById("method").value="input";
	document.getElementById("id").value="";
	smsTransferForm.submit();
}
</script>

	</head>

	<body>
		<html:form action="/smsTransferInfo" method="post">
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
              <td width="84%" class="table2_topic">短信转发：人员管理</td>
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
			<html:hidden property="id"/>
			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
				<thead>
					<tr>
						<th height="23">姓名</th>
						<td><html:text property="receiveName" styleClass="tab_input" style="width:100"/></td>
						<th>部门</th>
						<td><html:text property="receiveDept" styleClass="tab_input" style="width:100"/></td>
						<th>移动电话</th>
						<td><html:text property="receiveMobile" styleClass="tab_input" style="width:100"/></td>
						<th>信息类型</th>
						<td><html:text property="receiveType" styleClass="tab_input" style="width:100"/></td>
						<th>已收费用</th>
						<td><html:text property="fee" styleClass="tab_input" style="width:100"/></td>
					</tr>
					<tr>
						<td colspan="10" height="23">
						<input type="button" class="button0" value="提交" onclick="submitForm()">
						<input type="button" class="button0" value="取消" onclick="clearForm()">
						</td>
					</tr>
				</thead>
			</table>
<br><br>
			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
				<thead>
				<tr>
				<td colspan="6" height="23">
			姓名：<input type="text" name="queryName" value="${param.queryName}" class="tab_input" style="width:100">
			电话：<input type="text" name="queryMobile" value="${param.queryMobile}" class="tab_input" style="width:100">
			<input type="button" class="button0" value="查询" onclick="query()">
				</td>
				</tr>
					<tr>
						<th>姓名</th>
						<th>部门</th>
						<th>移动电话</th>
						<th>信息类型</th>
						<th>已收费用</th>
						<th>操作</th>
					</tr>
<logic:present name="list">
<logic:iterate id="item" indexId="i" name="list" type="com.baosight.sms.mode.SmsTransferInfo" >
					<tr>
						<td>${item.receiveName}</td>
						<td>${item.receiveDept}</td>
						<td>${item.receiveMobile}</td>
						<td>${item.receiveType}</td>
						<td>${item.bz}</td>
						<td align="center">
						<input type="button" class="button0" value="修改" onclick="modify('${item.id}')">
						<input type="button" class="button0" value="删除" onclick="deleteInfo('${item.id}')">
						</td>
					</tr>
</logic:iterate>
</logic:present>
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
