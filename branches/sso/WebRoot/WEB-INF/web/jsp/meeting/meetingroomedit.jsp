<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		 <link href="images/style.css" rel="stylesheet" type="text/css" />

		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		
		<script type='text/javascript' src='<%=strpath%>/dwr/interface/meetingRoomCheck.js'></script>

	</head>
	
	<body>
		<html:form action="/meetingroomaction.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">会议室管理</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnl()" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    		<td nowrap width="90" height="25"align="center" class="bg-zwbt">会议室名称</td>
			    		<td colspan="2"><html:text property="roomName" maxlength="32" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;width:90%" onkeydown="notNull();" onblur="chk(),meetingRoomNameCheck();"></html:text>
			    		<font color="red">*</font>
			    		<font color="red">
    		            <span id="froomName"></span>
    		            <span id="meetingRoomNameCheck"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td nowrap width="90" height="25" align="center" class="bg-zwbt">会议室位置</td>
			    		<td colspan="2"><html:text property="location" maxlength="100" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;width:90%"  onkeydown="notNull();" onblur="chk();"></html:text>
			    		<font color="red">*</font>
			    		<font color="red">
    		            <span id="flocation"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="90" height="25"align="center" class="bg-zwbt">容量</td>
			    		<td colspan="2"><html:text property="capability" maxlength="4" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;width:90%"  onkeydown="onlyNum();" onblur="chk();"></html:text>
			    		人
			    		<font color="red">*</font><font color="red">
    		            <span id="fcapability"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
				
			    	
			    	<tr>
			    		<td nowrap width="90" height="25" align="center" class="bg-zwbt">状态</td>
			    		<td nowrap colspan="2">
			    			<html:radio property="status" value="0">关闭</html:radio>
			    			<html:radio property="status" value="10">可用</html:radio>
			    			<html:radio property="status" value="20">被占用</html:radio>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="90" height="150" align="center" class="bg-zwbt">描述</td>
			    		<td colspan="2"><html:textarea property="rem" style="color: 4c6a95;ext-indent: 1pt;height: 150px;border: 1px solid #a5a5a5;width:90%" cols="70" rows="12"   onkeydown="notNull();" onblur="chk();"></html:textarea>
			    		<font color="red">
    		            <span id="frem"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>

					<tr>

							<td colspan="3" align="center">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
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
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path %>"/>


			<html:hidden property="id" />

		</html:form>
	</body>
</html>
<script  language="javascript">

function chk(){
		    var roomName = document.getElementById("roomName").value;
		    var location = document.getElementById("location").value;
		    var capability = document.getElementById("capability").value;
		    var rem = document.getElementById("rem").value;
		
			if(roomName == ""){
				document.getElementById("froomName").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("roomName").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("roomName").value) > 32){
					document.getElementById("froomName").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("roomName").focus();
					return false;	
								
				}
else{document.getElementById("froomName").innerHTML = "";}
}


				if(location == ""){
				document.getElementById("flocation").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("location").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("location").value) > 100){
					document.getElementById("flocation").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("location").focus();
					return false;	
								
				}
else{document.getElementById("flocation").innerHTML = "";}
}
		
		
				if(capability == ""){
				document.getElementById("fcapability").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("capability").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("capability").value) > 4){
					document.getElementById("fcapability").innerHTML = "<font color='red'>"+"长度不能大于4个数字"+"</font>";
					//document.getElementById("capability").focus();
					return false;	
								
				}
else{document.getElementById("fcapability").innerHTML = "";}
}
		
				

					 if(getLen(document.getElementById("rem").value) > 1000){
					document.getElementById("frem").innerHTML = "<font color='red'>"+"长度不能大于1000个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("rem").focus();
					return false;	
								
				}
else{document.getElementById("frem").innerHTML = "";}

}
		

			function CheckForm(){
			
			
			 var roomName = document.getElementById("roomName").value;
		    var location = document.getElementById("location").value;
		    var capability = document.getElementById("capability").value;
		    var rem = document.getElementById("rem").value;
		    
		    if(roomName == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("roomName").value) > 32){alert("字符输入过长"); return false;}
			
			if(location == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("location").value) > 100){alert("字符输入过长"); return false;}
			
			if(capability == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("capability").value) > 4){alert("字符输入过长"); return false;}
			
			if(getLen(document.getElementById("rem").value) > 1000){alert("字符输入过长"); return false;}
			meetingRoomNameCheck();
            if(this.meetingRoomNameflag=="false"){alert("不能重复"); return false;}
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modify'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}
				
				function onlyNum() 
				{ 
				if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 
				if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105))) 
				event.returnValue=false; 
				} 
				function returnl(){
				
				var pah=document.getElementById("path").value;

				window.location.replace(pah+"/meetingroomaction.do?method=list");

				}

</script>


