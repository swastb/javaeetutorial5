<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
String pername=(String)request.getAttribute("pername");
String perphone=(String)request.getAttribute("perphone");

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
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		
	</head>
	
	<body>
		<html:form action="/individualaction.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">个人通讯录</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnlist();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
				<td nowrap width="100" height="25" align="center" class="bg-zwbt">组名称</td>
			    <td colspan="2">
                <html:select property="individualId" value="${individualId}"   onblur="chk();" disabled="disabled">
				<html:option value="">---请选择组名---</html:option>
				<c:forEach var="indcoom" items="${allIndividualCoom}" varStatus="loop">
				<html:option value="${indcoom.id}">${indcoom.name}</html:option>
				</c:forEach>
				</html:select><font color="red">*</font>
			    <font color="red">
    		    <span id="findividualId"></span>
    		    </font>
			    </td>	
			    </tr>
			    
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">姓名</td>
			    <td colspan="2"><html:text property="name" maxlength="200"  styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/><font color="red">*</font>
			    <font color="red">
    		    <span id="fname"></span>
    		    </font>
			    </td>
                </tr>
			    
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">职务</td>
			    <td colspan="2"><html:text property="duty" maxlength="200" styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fduty"></span>
    		    </font>
			   　</td>
			    </tr>
			    		
			    <tr>
			    <td nowrap width="100"height="25" align="center" class="bg-zwbt">部门</td>
			    <td colspan="2"><html:text property="department" maxlength="200" styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fdepartment"></span>
    		    </font>
			    </td>	
			   　</tr>
			    		
			    <tr>
			    <td nowrap width="100" height="25" align="center" class="bg-zwbt">传真</td>
			    <td colspan="2"><html:text property="fax" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/>
			    <font color="red">
    		    <span id="ffax"></span>
    		    </font>
			    </td>
			    </tr>
			    		
			    <tr>
			    <td nowrap width="100" height="25" align="center" class="bg-zwbt">邮编</td>
			    <td colspan="2"><html:text property="post" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fpost"></span>
    		    </font>
			    </td>
			    </tr>
			    		
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">地址</td>
			    <td colspan="2"><html:text property="address" maxlength="200" styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="faddress"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100"height="25" align="center" class="bg-zwbt">部门电话</td>
			    <td colspan="2"><html:text property="partmentPhone" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fpartmentPhone"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100"height="25" align="center" class="bg-zwbt">移动电话</td>
			    <td colspan="2"><html:text property="movePhone" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/><font color="red">*</font>
			    <font color="red">
    		    <span id="fmovePhone"></span>
    		    </font>
			    </td>
			    </tr>
			    		
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">住宅电话</td>
			    <td colspan="2"><html:text property="homePhone" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fhomePhone"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100"height="25" align="center" class="bg-zwbt">Email</td>
			    <td colspan="2"><html:text property="email" maxlength="200" styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="femail"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">QQ</td>
			    <td colspan="2"><html:text property="qq" maxlength="20" styleClass="shuruk4" onkeydown="onlyNum();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fqq"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100" height="25"align="center" class="bg-zwbt">MSN</td>
			    <td colspan="2"><html:text property="msn" maxlength="200" styleClass="shuruk4" onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fmsn"></span>
    		    </font>
			    </td>
			    </tr>
			    
			    <tr>
			    <td nowrap width="100" align="center" class="bg-zwbt">备注</td>
			    <td colspan="2"><html:textarea  property="remark" styleClass="shuruk5" cols="70" rows="12"  onkeydown="notNull();" onblur="chk();"/>
			    <font color="red">
    		    <span id="fremark"></span>
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
            <input type="hidden" name="pername" value="<%=pername %>"/>
            <input type="hidden" name="perphone" value="<%=perphone %>"/>
      
			<html:hidden property="id" />


		
		</html:form>
	</body>
</html>
<script  language="javascript">

function chk(){
		    var individualId = document.getElementById("individualId").value;
		    var name = document.getElementById("name").value;
		    var duty = document.getElementById("duty").value;
		    var department = document.getElementById("department").value;
		    var fax = document.getElementById("fax").value;
		    var post = document.getElementById("post").value;
		    var address = document.getElementById("address").value;
		    var partmentPhone = document.getElementById("partmentPhone").value;
		    var movePhone = document.getElementById("movePhone").value;
		    var homePhone = document.getElementById("homePhone").value;
		    var email = document.getElementById("email").value;
		    var qq = document.getElementById("qq").value;
		    var msn = document.getElementById("msn").value;
		    var remark = document.getElementById("remark").value;
		 
			if(individualId == ""){
				document.getElementById("findividualId").innerHTML = "<font color='red'>"+"请选择组名"+"</font>";
				//document.getElementById("individualId").focus();
				return false;	
			}
else{document.getElementById("findividualId").innerHTML = "";}


				if(name == ""){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("name").focus();
				return false;	
			}else{
			        if(getLen(document.getElementById("name").value) > 200){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("name").focus();
					return false;				
				}
else{document.getElementById("fname").innerHTML = "";}
}


				
				    if(getLen(document.getElementById("duty").value) > 200){
					document.getElementById("fduty").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("duty").focus();
					return false;				
				}
else{document.getElementById("fduty").innerHTML = "";}


				
				    if(getLen(document.getElementById("department").value) > 200){
					document.getElementById("fdepartment").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("department").focus();
					return false;				
				}
else{document.getElementById("fdepartment").innerHTML = "";}


				
				    if(getLen(document.getElementById("fax").value) > 20){
					document.getElementById("ffax").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("fax").focus();
					return false;				
				}
else{document.getElementById("ffax").innerHTML = "";}


				
				    if(getLen(document.getElementById("post").value) > 20){
					document.getElementById("fpost").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("post").focus();
					return false;				
				}
else{document.getElementById("fpost").innerHTML = "";}


				
				    if(getLen(document.getElementById("address").value) > 200){
					document.getElementById("faddress").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("address").focus();
					return false;				
				}
else{document.getElementById("faddress").innerHTML = "";}


				
				    if(getLen(document.getElementById("partmentPhone").value) > 20){
					document.getElementById("fpartmentPhone").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("partmentPhone").focus();
					return false;				
				}
else{document.getElementById("fpartmentPhone").innerHTML = "";}



 					if(movePhone == ""){
				document.getElementById("fmovePhone").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("movePhone").focus();
				return false;	
			}else{
			        if(getLen(document.getElementById("movePhone").value) > 20){
					document.getElementById("fmovePhone").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("movePhone").focus();
					return false;				
				}
else{document.getElementById("fmovePhone").innerHTML = "";}
}



 					if(getLen(document.getElementById("homePhone").value) > 20){
					document.getElementById("fhomePhone").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("homePhone").focus();
					return false;				
				}
else{document.getElementById("fhomePhone").innerHTML = "";}



 					if(getLen(document.getElementById("email").value) > 200){
					document.getElementById("femail").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("email").focus();
					return false;				
				}
else{document.getElementById("femail").innerHTML = "";}



 					if(getLen(document.getElementById("qq").value) > 20){
					document.getElementById("fqq").innerHTML = "<font color='red'>"+"长度不能大于20个字符,输入值必须为数字"+"</font>";
					//document.getElementById("qq").focus();
					return false;				
				}
else{document.getElementById("fqq").innerHTML = "";}



 					if(getLen(document.getElementById("msn").value) > 200){
					document.getElementById("fmsn").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("msn").focus();
					return false;				
				}
else{document.getElementById("fmsn").innerHTML = "";}




 					if(getLen(document.getElementById("remark").value) > 200){
					document.getElementById("fremark").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("remark").focus();
					return false;				
				}
else{document.getElementById("fremark").innerHTML = "";}
		
}
		

			function CheckForm(){
			
			
			var individualId = document.getElementById("individualId").value;
		    var name = document.getElementById("name").value;
		    var duty = document.getElementById("duty").value;
		    var department = document.getElementById("department").value;
		    var fax = document.getElementById("fax").value;
		    var post = document.getElementById("post").value;
		    var address = document.getElementById("address").value;
		    var partmentPhone = document.getElementById("partmentPhone").value;
		    var movePhone = document.getElementById("movePhone").value;
		    var homePhone = document.getElementById("homePhone").value;
		    var email = document.getElementById("email").value;
		    var qq = document.getElementById("qq").value;
		    var msn = document.getElementById("msn").value;
		    var remark = document.getElementById("remark").value;
		    
		    if(individualId == ""){alert("数据输入不完整"); return false;}
		    if(name == ""){alert("数据输入不完整"); return false;}
		    if(movePhone == ""){alert("数据输入不完整"); return false;}
			
			if(getLen(document.getElementById("name").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("duty").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("department").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("fax").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("post").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("address").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("partmentPhone").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("movePhone").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("homePhone").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("email").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("qq").value) > 20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("msn").value) > 200){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("remark").value) > 200){alert("字符输入过长"); return false;}
			
		
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

			function returnlist(){

            window.location.replace("<%=path%>/individualaction.do?method=listSelect&pername=<%=pername%>&perphone=<%=perphone%>");
            
			}

</script>


