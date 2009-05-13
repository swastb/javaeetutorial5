<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbUserdept,com.baosight.mode.TbRole"/>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String parentId = (String)request.getAttribute("parentid");
String addType = request.getParameter("addtype");
String parentNodeType = request.getParameter("parentnodetype");
List allLvl = (List)request.getAttribute("allLvl");
List userdeptList = (List) request.getAttribute("userdeptList");
List userroleList = (List) request.getAttribute("userroleList");
System.out.println("-------size--=="+userroleList.size());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deptedit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">	
	<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
	<link href="images/style.css" rel="stylesheet" type="text/css" />
	<script src="../../../../javascript/validate.js"></script>
	<script type='text/javascript' src='<%=strpath%>/dwr/interface/userCheck.js'></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

  </head>
  
  <body><br>
  <html:form  action="/orgrightdetailaction.do">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">用户编辑</td>
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
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
						<td nowrap align="center" height="25">
							姓名
						</td>
						<td colspan="2" height="25">
							<html:text property="name" maxlength="15" styleClass="shuruk6" onkeydown="notNull();" onblur="chk();"></html:text>
							<font color="red">*</font>
							<font color="red">
							<span id="fname"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							性别
						</td>
						<td colspan="2">
							<html:radio property="sex" value="1" >男</html:radio>
							<html:radio property="sex" value="2" >女</html:radio>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							帐号
						</td>
						<td colspan="2">
							<html:text property="userAcc" maxlength="32" styleClass="shuruk6" onkeydown="notNull();" onblur="chk(),userAccCheck()"></html:text>
							<font color="red">*</font>
							<font color="red">
							<span id="fuserAcc"></span>
							<span id="userAccCheck"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							密码
						</td>
						<td colspan="2">
							<html:password property="pwd" maxlength="32" styleClass="shuruk6" onkeydown="notNull();" onblur="chk();"></html:password>
							<font color="red">*</font>
							<font color="red">
							<span id="fpwd"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							级别
						</td>
						<td colspan="2" height="25">
							<html:select property="lvl" onblur="chk();">
							<html:option value="">---请选择---</html:option>
								<html:options collection="allLvl" property="name"
									labelProperty="name" />
							</html:select>
							<font color="red">*</font>
							<font color="red">
							<span id="flvl"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							联系电话
						</td>
						<td colspan="2">
							<html:text property="tel" maxlength="20" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="ftel"></span>
							</font>
						</td>
					</tr>

					<tr>
						<td nowrap align="center" height="25">
							生日
						</td>
						<td colspan="2">
							<html:text property="birthday" maxlength="12" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="fbirthday"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							常用E-MAIL
						</td>
						<td colspan="2">
							<html:text property="email" maxlength="32" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="femail"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							联系地址
						</td>
						<td colspan="2">
							<html:text property="linkaddress" maxlength="50" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="flinkaddress"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							手机号码
						</td>
						<td colspan="2">
							<html:text property="handset" maxlength="15" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="fhandset"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							固定电话
						</td>
						<td colspan="2">
							<html:text property="phone" maxlength="32" styleClass="shuruk6" onblur="chk();"></html:text>
							<font color="red">
							<span id="fphone"></span>
							</font>
						</td>
					</tr>
					<tr>
						<td nowrap align="center" height="25">
							所属部门
						</td>
						<td colspan="2">
							<html:select property="userdept">
								<%--<html:options collection="userdeptList" property="name"
									labelProperty="name" />
							--%>
							<html:optionsCollection name="userdeptList" value="id" label="name"/>
							</html:select>						
						</td>
					</tr>
    	<tr>
			
    	<td colspan="3" align="center" height="25">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
						</td>
    	</tr>
    	 <tr>
                      <td height="25" colspan="3" align="center"><input name="Submit2322" type="button" onclick="userroleList();" class="button0" value="用户所属角色查看"></td>
                      </tr>
    	
    </table>
    <div id="userroleList" style="display:none;position:relative;top:0;left:0">
    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
    		  <tr>
    		  <td valign="top"><a title="关闭" href="javascript:userroleListClose();"><img src="<%=path %>/imagine/sc.gif" width="15" height="15" border="0"></a></td>
    		  </tr>
              <tr>
                <td valign="top"> 
                
                 <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
                   
			    	<tr align="center" class="bg-zwbt">
			    	　　<td align="center" height="25"width="50%">角色名称</td>
			    	   <td align="center" width="50%">角色代码</td>
			    	</tr>
			    	<c:forEach var="content" items="${userroleList}" varStatus="loop">
			    		<tr align="center" class="bg-zw">
			    			<td align="center" width="50%" height="25">${content.name}</td>
			    			<td align="center" width="50%">${content.code}</td>
			    		</tr>
			    	</c:forEach>
				</table> 
 
                </td>
              </tr>
          </table>
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
    <input type="hidden" name="parentid" value="<%=parentId %>"/>
    <input type="hidden" name="addtype" value="<%=addType %>"/>
    <input type="hidden" name="action" />
    <input type="hidden" name="method" />
    <input type="hidden" name="parentnodetype" value="<%=parentNodeType %>"/>
    <html:hidden property="id"/>
	</html:form>
  </body>
</html>
<script language="javascript">
function userroleList()
{
	var userroleList=document.getElementById("userroleList");
	userroleList.style.top="0px";
	userroleList.style.position="relative";
	userroleList.style.display="";
}
function userroleListClose()
{
	var userroleList=document.getElementById("userroleList");
	userroleList.style.display="none";
}

function chk(){
		    var name = document.getElementById("name").value;
		    var userAcc = document.getElementById("userAcc").value;
		    var pwd = document.getElementById("pwd").value;
		    var lvl = document.getElementById("lvl").value;
		    var tel = document.getElementById("tel").value;
		    var birthday = document.getElementById("birthday").value;
		    var email = document.getElementById("email").value;
		    var linkaddress = document.getElementById("linkaddress").value;
		    var handset = document.getElementById("handset").value;
		    var phone = document.getElementById("phone").value;
		    
			if(name == ""){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("name").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("name").value) > 15){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于15个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("name").focus();
					return false;	
								
				}
							
else{document.getElementById("fname").innerHTML = "";}
}



			if(userAcc == ""){
				document.getElementById("fuserAcc").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("userAcc").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("userAcc").value) > 32){
					document.getElementById("fuserAcc").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("userAcc").focus();
					return false;	
								
				}
else{document.getElementById("fuserAcc").innerHTML = "";}
}


	if(pwd == ""){
				document.getElementById("fpwd").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
				//document.getElementById("pwd").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("pwd").value) > 32){
					document.getElementById("fpwd").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("pwd").focus();
					return false;	
								
				}
else{document.getElementById("fpwd").innerHTML = "";}
}
		
		
			if(lvl == ""){
				document.getElementById("flvl").innerHTML = "<font color='red'>"+"请选择等级"+"</font>";
				//document.getElementById("lvl").focus();
				return false;	
				
			}
else{document.getElementById("flvl").innerHTML = "";}

		
		
					 if(getLen(document.getElementById("tel").value) > 20){
					document.getElementById("ftel").innerHTML = "<font color='red'>"+"长度不能大于20个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("tel").focus();
					return false;	
								
				}
else{document.getElementById("ftel").innerHTML = "";}

					 if(getLen(document.getElementById("birthday").value) > 12){
					document.getElementById("fbirthday").innerHTML = "<font color='red'>"+"长度不能大于12个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("birthday").focus();
					return false;	
								
				}
else{document.getElementById("fbirthday").innerHTML = "";}

					 if(getLen(document.getElementById("email").value) > 32){
					document.getElementById("femail").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("email").focus();
					return false;	
								
				}
else{document.getElementById("femail").innerHTML = "";}

					 if(getLen(document.getElementById("linkaddress").value) > 50){
					document.getElementById("flinkaddress").innerHTML = "<font color='red'>"+"长度不能大于50个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("linkaddress").focus();
					return false;	
								
				}
else{document.getElementById("flinkaddress").innerHTML = "";}

					 if(getLen(document.getElementById("handset").value) > 15){
					document.getElementById("fhandset").innerHTML = "<font color='red'>"+"长度不能大于15个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("handset").focus();
					return false;	
								
				}
else{document.getElementById("fhandset").innerHTML = "";}

					 if(getLen(document.getElementById("phone").value) > 32){
					document.getElementById("fphone").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					//document.getElementById("phone").focus();
					return false;	
								
				}
else{document.getElementById("fphone").innerHTML = "";}

}
		
					   

			function CheckForm(){
			var name = document.getElementById("name").value;
		    var userAcc = document.getElementById("userAcc").value;
		    var pwd = document.getElementById("pwd").value;
		    var lvl = document.getElementById("lvl").value;
		    var tel = document.getElementById("tel").value;
		    var birthday = document.getElementById("birthday").value;
		    var email = document.getElementById("email").value;
		    var linkaddress = document.getElementById("linkaddress").value;
		    var handset = document.getElementById("handset").value;
		    var phone = document.getElementById("phone").value;
		    
		    if(name == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("name").value) >15){alert("字符输入过长"); return false;}
		    
		    if(userAcc == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("userAcc").value) >32){alert("字符输入过长"); return false;}
			
			if(pwd == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("pwd").value) >32){alert("字符输入过长"); return false;}
			
			if(lvl == ""){alert("数据输入不完整"); return false;}
			
			if(getLen(document.getElementById("tel").value) >20){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("birthday").value) >12){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("email").value) >32){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("linkaddress").value) >50){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("handset").value) >15){alert("字符输入过长"); return false;}
			if(getLen(document.getElementById("phone").value) >32){alert("字符输入过长"); return false;}
			
			
			userAccCheck();
           
            if(this.userAccflag=="false"){alert("不能重复"); return false;}
			
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modifyUser'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}

</script>

