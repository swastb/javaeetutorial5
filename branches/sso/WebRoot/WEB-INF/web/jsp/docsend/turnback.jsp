<%@ page language="java" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent"/>
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
    
    <title>选择接点</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="images/style.css" rel="stylesheet" type="text/css">
    
 </head>  
 <body>

 <form>
 	
    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in" align="center">
       <tr>
        	<td width="20%" height="25" align="center"><b>文件标题</b></td>
        	<td colspan="5" align="center">${fileTitle}</td>
       </tr>
       <tr>
       		<th colspan="1" height="25" align="center"></th>
    		<th width="16%" align="center">步骤名</th>
    		<th width="16%" align="center">流入时间</th>
    		<th width="16%" align="center">签收时间</th>
    	　　 <th width="16%" align="center">流出时间</th>
    	   	<th align="center" nowrap="nowrap">处理人</th>
    	</tr>
		<logic:iterate id="item" name="sclzdList">
    	<tr align="center" class="bg-zw">
    		<td height="25" align="center"><input type="radio" name="docControlId" value="${item.id}"></td>
		    <td align="center">${item.stateName}</td>
    		<td align="center"><bean:write format="yyyy-MM-dd HH:mm" name="item" property="createTime"/></td>
    		<td align="center"><bean:write format="yyyy-MM-dd HH:mm" name="item" property="inputTime"/></td>
    		<td align="center"><bean:write format="yyyy-MM-dd HH:mm" name="item" property="closeTime"/></td>
    		<td align="center" nowrap="nowrap">${item.userName}</td>
		 </tr>
		 </logic:iterate>
		<tr>
			<td colspan="6" align="center">
				<input type="button" class="button0" value="提交" onclick="submit1()">
				<input type="button" class="button0" value="取消" onclick="window.close()">
			</td>
		</tr>
 	 </table> 
</form>
</body>
</html>

<script language="javascript">
function submit1() {
var controlId;
var objs = document.forms[0].docControlId;
for(i=0;i<objs.length;i++){
	if(objs[i].checked){
		controlId=objs[i].value;
		break;
	}
}
window.dialogArguments.document.getElementById("${param.showText}").value=controlId;
window.dialogArguments.document.docSendForm.submit();
window.close();
}
</script>
