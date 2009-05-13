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
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
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
		<html:form action="/docSendRelatedAction.do">
			<table width="620" border="2" cellpadding="0" cellspacing="0"
				bordercolor="black" class="tableborder" align="center">
				<thead class="bg-zw">
				<tr>
			    	<td width="15%" height="22"align="center" nowrap="nowrap" class="bg-zwbt">通知内容</td>
			    	<td colspan="1"><input type="text" name="content" Class="shuruk2" size="55" value="请尽快办理发文名称为<%=docTitle %>" readonly="readonly"/></td>
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
						<span id="hTime">
						<input type="checkbox" name="tellTime" value="2" disabled/>提前一小时&nbsp;&nbsp;
						</span>
						<span id="dTime">
						<input type="checkbox" name="tellTime" value="4" disabled/>提前一天&nbsp;&nbsp;
						</span>
						<input type="checkbox" id="setTime" name="tellTime" onclick="selTime(1);" value="8"/>定时发送
						<span id="selTime">
						<input type="text" name="selectTime" size='16' onfocus="" readonly="readonly" />
						</span>
						<span><font color="red">*</font></span>
					</td>		
			  	</tr>
			    <tr>
			    	<td width="15%"  height="22" align="center" class="bg-zwbt">通知方式</td>
			    	<td colspan="1">
			    		<input type="checkbox" name="tellway" value="1">web
			    		<input type="checkbox" name="tellway" value="2">手机短信
			    		<span><font color="red">*</font></span>
			    	</td>
			    </tr>
				</thead>

				<thead class="bg-zw">
					<tr>
						<td colspan="3" align="center">
							<a onclick="submit1();"><img src="<%=path%>/imagine/tj.gif" border='0' onmouseover="this.style.cursor='hand'" align="bottom" width="52" height="23"></a>&nbsp;&nbsp;
							<img src="<%=path%>/imagine/fh.gif" border='0' align="bottom" onclick="window.close();" onmouseover="this.style.cursor='hand'" width="52" height="23">&nbsp;&nbsp;
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
}
function selTime(value){
			if(!document.getElementById("setTime").checked){
				document.getElementById("selectTime").value="";
				document.getElementById("selTime").innerHTML="<input type='text' name='selectTime' id='selectTime'  onfocus='' readonly='true' />";
				document.getElementById("hTime").innerHTML="<input type='checkbox' name='hourTime' id='hourTime'  value='1' disabled>提前一小时&nbsp;&nbsp;&nbsp;</input>";
				document.getElementById("dTime").innerHTML="<input type='checkbox' name='dayTime' id='dayTime'  value='1' disabled>提前一天&nbsp;&nbsp;&nbsp;</input>";
			}else{
				obj=document.getElementById("selectTime");
				document.getElementById("selTime").innerHTML="<input type='text' name='selectTime' id='selectTime' onfocus='setday(this)'  />";
				document.getElementById("hTime").innerHTML="<input type='checkbox' name='hourTime' id='hourTime'  value='1' >提前一小时&nbsp;&nbsp;&nbsp;</input>";
				document.getElementById("dTime").innerHTML="<input type='checkbox' name='dayTime' id='dayTime'  value='1' >提前一天&nbsp;&nbsp;&nbsp;</input>";
			}       
		}
</script>


