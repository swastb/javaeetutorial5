<%@ page language="java" pageEncoding="GBK"%>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vehicles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/images/style.css" rel="stylesheet" type="text/css" />
    
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/js/cal/calendar.js"></script>
	<script type="text/javascript">
		var flag = 0;
		function returnl(){
			if(document.getElementById("source").value=="shouwenuser"){
				window.location.replace("<%=path%>/messages.do?method=findMessages");
			}else if(document.getElementById("source").value=="notRead"){
				window.location.replace("<%=path%>/notReadMsgMessages.do?method=findNotReadMessages");
			}else{
				window.location.replace("<%=path%>/sendMessages.do?method=sendBoxList");
			}            
		}
		
		function selectuser(flag,argDeptOrUser,tid,tname)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText="+tid+"&nameText="+tname+"&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		function clearText(obj)	{		
			document.getElementById(obj).value="";
			document.getElementById(obj+'name').value="";
		}
		
		function selTime(value){
			if(!document.getElementById("setTime").checked){
				document.getElementById("selectTime").value="";
				document.getElementById("selTime").innerHTML="<input type='text' name='selectTime' id='selectTime'  onfocus='' readonly='true' />";
				document.getElementById("hTime").innerHTML="<input type='checkbox' name='hourTime' id='hourTime'  value='1' disabled>提前一小时&nbsp;&nbsp;&nbsp;</input>";
				document.getElementById("dTime").innerHTML="<input type='checkbox' name='dayTime' id='dayTime'  value='1' disabled>提前一天&nbsp;&nbsp;&nbsp;</input>";
			}else{
				obj=document.getElementById("selectTime");
				document.getElementById("selTime").innerHTML="<input type='text' name='selectTime' id='selectTime'  onfocus='setday(this)'  />";
				//document.getElementById("selectTime").attachEvent("onfocus",function(){setday(obj)});
				document.getElementById("hTime").innerHTML="<input type='checkbox' name='hourTime' id='hourTime'  value='1' >提前一小时&nbsp;&nbsp;&nbsp;</input>";
				document.getElementById("dTime").innerHTML="<input type='checkbox' name='dayTime' id='dayTime'  value='1' >提前一天&nbsp;&nbsp;&nbsp;</input>";
			}       
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
		
		function checkTime(selectTime){
			var time = selectTime;
			var str =  /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
			if(""!=time && !str.test(time)){
				alert("请输入正确的日期！");
				document.getElementById("dayTime").checked = false;
				document.getElementById("hourTime").checked = false;
				return false;
			}else{
				flag = 1;
			}
		}
		
		function CheckForm(){
		    var receiversName = document.getElementById("receiversName").value;
			var content = document.getElementById("content").value;
			
			var sendWay1 = document.getElementById("sendWay1").checked;
			var sendWay2 = document.getElementById("sendWay2").checked;
			var selectTime = document.getElementById("selectTime").value;
			var setTime = document.getElementById("setTime").checked;
				
			if(receiversName==""){
				alert("输入数据不完整！");
				return false;	
			}
			if(receiversName.length >= 1000){
				alert("收件人长度不能大于1000字符或文字!");
				return false;
			}
			if(!sendWay1 && !sendWay2){
				alert("输入数据不完整！");
				return false;
			}
			if(content==""){
				alert("输入数据不完整！");
				return false;
			}
			if(content.length >= 2*1024*1024){
				alert("正文内容长度不能大于2G字符或文字!");
				return false;
			}
			if(null!=selectTime && ""!=selectTime){
				checkTime(selectTime);
				if(flag == 0){
					return false;
				}
			}
			if(selectTime=="" && setTime){
				alert("请选择定时发送时间");
				return false;
			}
			
			document.all.action.value='submit';
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
    <html:form action="/messages.do?method=sendMessages">
    <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5%" align="center" valign="middle">
								&nbsp;
							</td>
							<td width="11%" height="12" align="center" valign="middle">
								<img src="images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								信息通讯
							</td>
						</tr>
					</table>
				</td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
      <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
			<tr>
          <td>
		 <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
			<tr>
          <td><table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <td align="center" valign="top">
                  <table width="98%" border="0" cellspacing="0" cellpadding="0"> 
                  <tr>
                  <td align="right">
					<img src="<%=path %>/images/fh.gif" width="46" height="25" onClick="returnl();" onMouseOver="this.style.cursor='hand'">
					&nbsp;
				</td>
			</tr>
			</table>
			
			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
	<tr>
		<td height="24" width="15%" align="center" >收件人</td>
		
		<td  width="" class="bg-zwbt" valign="middle">
		<table border="0" cellpadding="0" cellspacing="0" width="100%"><tr><td width="79%" align="left">
		<html:text styleClass="shuruk2" property="receiversname" style="width:99%;"  readonly="true"></html:text>
		<html:hidden  property="receivers" />
		</td>
		<td width="10%" align="left" valign="bottom">
		<a onClick="selectuser('participant','user','receivers','receiversname');" title="选择人员" onMouseOver="this.style.cursor='hand'">
			<img src="<%=path%>/imagine/xz.gif" width="85" height="20">
		</a>
		</td>
		<td width="1%"></td>
		<td width="10%" align="left" valign="bottom">
		<a onclick="clearText('receivers');" title="清空" onmouseover="this.style.cursor='hand'">
			<img src="<%=path%>/imagine/z3.gif" width="85" height="20">
		</a>
		</td></tr></table>
		</td>	
	</tr>
	<tr>
		<td height="24" width="15%" align="center" >主题</td>
		<td  width="" class="bg-zwbt"><html:text property="title" styleClass="shuruk2" style="width:100%;" maxlength="100"></html:text></td>		
	</tr>
	<tr>
		<td height="24" width="15%" align="center" >发送方式</td>
		<td  width="" class="bg-zwbt">
		<html:checkbox property="sendWay1" value="1">站内短信</html:checkbox>&nbsp;&nbsp;&nbsp;
		<html:checkbox property="sendWay2" value="2">手机短信</html:checkbox>
		</td>		
	</tr>
	<tr>
		<td height="24" width="15%" align="center">发送时间</td>
		<td  width="" class="bg-zwbt">
		<html:checkbox property="nowTime" value="1" >立即发送&nbsp;&nbsp;&nbsp;</html:checkbox>
		<span id="hTime">
		<html:checkbox property="hourTime" value="1" disabled="true">提前一小时</html:checkbox>&nbsp;&nbsp;
		</span>
		<span id="dTime">
		<html:checkbox property="dayTime" value="1" disabled="true">提前一天</html:checkbox>&nbsp;&nbsp;
		</span>
		<html:checkbox property="setTime" onclick="selTime(1);" value="1">定时发送</html:checkbox>
		<span id="selTime">
		<html:text styleClass="shuruk2" property="selectTime" onfocus="" readonly="true" />
		</span>
		</td>		
	</tr>
	<tr>
		<td  width="15%" align="center" >消息内容</td>
		<td  width="" class="bg-zwbt"><html:textarea  property="content" rows="5" cols="50" styleClass="shuruk7" style="width:100%;"></html:textarea>
		</td>	
	</tr>
	<tr align="center">	
		<td colspan="3" align="center">
		<a onClick="CheckForm();" onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
		</td>
	</tr>
	<html:hidden property="status" value="1"/>
	</table>
	</td></tr>
			<tr>
			    <td height="20"></td>
			 </tr>	
			</table></td></tr>
			<%--<tr>
			<td height="10"></td>
			</tr>
			--%></table>
			</td></tr><tr>
			<td height="10"></td>
			</tr>
			</table></td></tr></table>
	<input type="hidden" name="action" />
	<input type="hidden" name="method" />
	<html:hidden property="source"></html:hidden>
	<html:hidden property="id" />
	</html:form>
  </body>
</html>