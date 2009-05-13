<%@ page language="java" import="java.util.*,com.baosight.mode.TbUser" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
List userList=(List)request.getAttribute("userList");
String docTitle = request.getParameter("docTitle");
String docId = request.getParameter("docId");
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
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path %>/js/cal/calendar.js"></script>
		<script type="text/javascript">
		<%
		if("true".equals(request.getAttribute("closed"))){
			out.println("alert('催办成功！');window.close();");
		}
		%>
		</script>
	</head>
	
	<body>
		<html:form action="/docRecRelateAction.do">
			<table width="620" border="0" cellpadding="0" cellspacing="1" class="tabin1_in" align="center">
				<thead>
				<tr>
			    	<td width="15%" height="22"align="center" nowrap="nowrap" class="bg-zwbt">通知内容</td>
			    	<td colspan="1"><input type="text" name="content" class="tab_input" value="请尽快办理发文名称为<%=docTitle %>" readonly="readonly"/></td>
			    </tr>
			    <tr>
			    	<td width="15%" height="22" align="center" class="bg-zwbt">通知对象</td>
			    	<td colspan="1">
			    		<select name="person" id="person">
			    		<% 
			    		if (userList!=null && !userList.isEmpty() && userList.size()>0)
			    		for (int i=0;i<userList.size();i++ ){
			    		TbUser user = (TbUser)userList.get(i);
			    		%>
			    			<option value="<%=user.getId() %>"><%=user.getName() %></option>
			    			<%} %>
			    		</select>
			    		<span><font color="red">*</font></span>
			    	</td>
			    </tr>
			    <tr>
			    	<td width="15%" height="22" align="center" class="bg-zwbt"/>通知时间</td>
			    	<td width="75%">
						<input type="checkbox" name="tellTime" value="1" />立即发送&nbsp;&nbsp;
						<input type="checkbox" name="hourTime" value="2" disabled/>提前一小时&nbsp;&nbsp;
						<input type="checkbox" name="dayTime" value="4" disabled/>提前一天&nbsp;&nbsp;
						<input type="checkbox" id="setTime" name="setTime" onclick="selTime();" value="8"/>定时发送
						<input type="text" name="selectTime" size='16' onfocus="" class="top_input" readonly />
						<span><font color="red">*</font></span>
					</td>		
			  	</tr>
			    <tr>
			    	<td width="15%"  height="22" align="center">通知方式</td>
			    	<td colspan="1">
			    		<input type="checkbox" name="tellway" value="1">web
			    		<input type="checkbox" name="tellway" value="2">手机短信
			    		<span><font color="red">*</font></span>
			    	</td>
			    </tr>
				</thead>

				<thead>
					<tr>
						<td colspan="3" align="center">
							<input type="button" value="提交" onclick="submit1()" class="button0">
							<input type="button" value="返回" onclick="window.close()" class="button0">
						</td>
					</tr>
				</thead>
			</table>
			<input type="hidden" name="method" />
			<input type="hidden" name="docId"  value="<%=docId %>"/>
		</html:form>
	</body>
</html>
<script language="javascript">
function submit1(){

    var arry1=document.getElementsByName("tellTime");
    var arry2=document.getElementsByName("tellway");
    var lenTemp1=0;
    var lenTemp2=0;
    if (document.getElementById("person").value=="") {
		alert("请选择通知对象！");
		return false;
		}
    for (var i=0;i<arry1.length;i++){
    	if (!arry1[i].checked)
    		lenTemp1++;
    }
    if (arry1.length==lenTemp1) {
		alert("请选择通知时间！");
		return false;
		}
	if(document.getElementById("setTime").checked)
		if (document.getElementById("setTime").value=="")
			alert("请选择时间！");
	for (var i=0;i<arry2.length;i++){
    	if (!arry2[i].checked)
    		lenTemp2++;
    }
	if (arry2.length==lenTemp2) {
		alert("请选择通知方式！");
		return false;
		}
	document.all.method.value='argueNoticeDo';
	document.forms[0].submit();
	window.close();
	return true;
				
}
function selTime(){
	var obj = event.srcElement;
	if(!obj.checked){
		document.getElementById("selectTime").value="";
		document.getElementById("selectTime").readOnly = true;
		document.getElementById("hourTime").disabled = true;
		document.getElementById("hourTime").checked = false;
		document.getElementById("dayTime").disabled = true;
		document.getElementById("dayTime").checked = false;
	}else{
		document.getElementById("selectTime").readOnly = false;
		document.getElementById("hourTime").disabled = false;
		document.getElementById("dayTime").disabled = false;
	}       
}
</script>


