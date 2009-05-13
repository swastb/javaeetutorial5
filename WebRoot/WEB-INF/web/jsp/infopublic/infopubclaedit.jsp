<%@ page language="java" import="java.util.*,com.baosight.mode.TbRole" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
String parentid=(String)request.getAttribute("parentid");
String p_name=(String)request.getParameter("p_name");
String type=(String)request.getParameter("type");
String id=(String)request.getParameter("id");
List roleList=(List)request.getAttribute("roleList");
List seledRolesList=(List)request.getAttribute("seledRolesList");
List unseledRolesList=(List)request.getAttribute("unseledRolesList");
String haveChildNum=(String)request.getAttribute("haveChildNum");
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
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script src="../../../../javascript/validate.js"></script>
		<script type='text/javascript' src='<%=strpath%>/dwr/interface/infocomm.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	</head>
	
	<body>
		<html:form action="/infopubclaaction.do">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic"><%=p_name %>栏目</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnList();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    		<td width="20%" height="22" align="left">栏目代码</td>
			    		<td colspan="1" width="80%"><html:text property="code" styleClass="shuruk4" size="50" onkeydown="notNull();" onblur="chk(),infoClaCodeCheck();" maxlength="32"/>
			    		<font color="red">
    		            <span align="left" id="fcode"></span>
    		            <span align="left" id="infoClaCodeCheck"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" height="22" align="left">栏目名称</td>
			    		<td colspan="1"><html:text property="name" styleClass="shuruk4" size="50" onkeydown="notNull();" onblur="chk();" maxlength="200"/>
			    		<font color="red">
    		            <span align="left" id="fname"></span>
    		            <span align="left" id="infoClacommNameCheck"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" height="22" align="left">上级栏目</td>
			    		<td colspan="1"><%=p_name %></td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="20%"  height="22" align="left">是否可以添加信息</td>
			    		<td colspan="1">
			    			<html:radio property="onlyTree" value="0">不可添加信息</html:radio>
			    			<html:radio property="onlyTree" value="1">可添加信息</html:radio>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%"  height="22" align="left">备注</td>
			    		<td colspan="1"><html:textarea  property="rem" styleClass="shuruk5" cols="74" rows="12" onkeydown="notNull();" onblur="chk();"/>
			    		<font color="red">
    		            <span align="left" id="fremark"></span>
    		            </font>
			   			</td>	
			    	</tr>
					<tr>

							<td colspan="3" align="center">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
			    		<td height="22" align="center" colspan="2"><input name="Submit2322" type="button" onclick="displayDiv();" class="button0" value="选择角色"></td>
			    	</tr>
			</table>
			<table><tr height="1"><td></td></tr></table>
			<div id="dateLayerSee" style="display:none;position:relative;">
				<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
						<tr><td colspan="3" align="left">栏目角色列表</td></tr>
						<tr><td align="center"></td>
							<td align="center">角色名</td>
							<td align="center">角色说明</td></tr>
						<% if (id==null) {
							for (int i=0;!roleList.isEmpty()&&i<roleList.size();i++){
							TbRole role = (TbRole)roleList.get(i);
							//if (!"9f90838e18f45e8c0118f45f6f8e0001".equals(role.getId())) {
							%>
								<tr>
									<td align="center"><input type="checkbox" id="roleId" name="roleId" value="<%=role.getId() %>" /></td>
									<td align="center"><%=role.getName() %></td>
									<td align="center"><%=role.getRem()==null?"":role.getRem() %></td>
									<%--<td colspan="1" align="center" title="角色权限查看"><%="角色权限查看" %></td>
								--%></tr>
							<%}//}
						} 
						else {
							for (int i=0;!seledRolesList.isEmpty()&&i<seledRolesList.size();i++){
							TbRole role = (TbRole)seledRolesList.get(i);
							%>
								<tr>
									<td align="center"><input type="checkbox" id="roleId" name="roleId" value="<%=role.getId() %>" checked onclick="alertMess(this);"/></td>
									<td align="center"><%=role.getName() %></td>
									<td align="center"><%=role.getRem()==null?"":role.getRem() %></td>
									<%--<td colspan="1" align="center" title="角色权限查看"><%="角色权限查看" %></td>
								--%></tr>
							<%}
							for (int i=0;!unseledRolesList.isEmpty()&&i<unseledRolesList.size();i++){
							TbRole role = (TbRole)unseledRolesList.get(i);
							if (!"9f90838e18f45e8c0118f45f6f8e0001".equals(role.getId())) {
							%>
								<tr>
									<td align="center"><input type="checkbox" id="roleId" name="roleId" value="<%=role.getId() %>" /></td>
									<td align="center"><%=role.getName() %></td>
									<td align="center"><%=role.getRem()==null?"":role.getRem() %></td>
									<%--<td colspan="1" align="center" title="角色权限查看"><%="角色权限查看" %></td>
								--%></tr>
							<%}}
						}
						%>
						<tr>
							<td colspan="3" align="center">
								<a onclick="roleDivClose();"
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
			<input type="hidden" name="type" value="<%=type %>"/>
			<input type="hidden" name="method" />
			<input type="hidden" name="p_name" value="<%=p_name %>"/>
            <input type="hidden" name="parentid" value="<%=parentid %>"/>
			<html:hidden property="id" />
		
		</html:form>
	</body>
</html>
<script  language="javascript">
function alertMess(aa) {
 if (aa.checked==false) {
 	if ("<%=haveChildNum%>"!="0")
 		if (confirm("此栏目下有子栏目,你确定要取消该栏目和所有子栏目所拥有的该操作吗?")) 
 			aa.checked=false;
 		else
 			aa.checked=true;
 }
}
function displayDiv() {
	document.getElementById("dateLayerSee").style.display="";
}
function roleDivClose() {
	document.getElementById("dateLayerSee").style.display="none";
}
function chk(){
		var name = document.getElementById("name").value;
		var code = document.getElementById("code").value;
		var remark = document.getElementById("rem").value;
		 
		if(code == ""){
			document.getElementById("fcode").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			
			return false;	
				
		}else{
			if(getLen(document.getElementById("code").value) > 32){
				document.getElementById("fcode").innerHTML = "<font color='red'>"+"长度不能大于32个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
				
				return false;	
			}
			else{document.getElementById("fcode").innerHTML = "";}
		}
		 
		if(name == ""){
			document.getElementById("fname").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			
			return false;	
				
		}else{
			if(getLen(document.getElementById("name").value) > 200){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"长度不能大于200个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
				
				return false;	
			}
			else{document.getElementById("fname").innerHTML = "";}
		}
		
		if(remark == ""){
				document.getElementById("fremark").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
				
				return false;	
				
			}else{
				if(getLen(document.getElementById("rem").value) > 1000){
					document.getElementById("fremark").innerHTML = "<font color='red'>"+"长度不能大于1000个字符,中文占2个字符,数字&字母占1个字符"+"</font>";
					
					return false;
				}
				else{document.getElementById("fremark").innerHTML = "";}
			}
			
}

function CheckForm(){

	var name = document.getElementById("name").value;
	var code = document.getElementById("code").value;
	var remark = document.getElementById("rem").value;
	var roleIdArry = document.getElementsByName("roleId");
	var lenTemp=0;
	for (var i=0;i<roleIdArry.length;i++){
    	if (!roleIdArry[i].checked)
    		lenTemp++;
    }
	if(name == ""){alert("数据输入不完整"); return false;}
	if(getLen(document.getElementById("name").value) > 200){alert("字符输入过长"); return false;}
	
	if(code == ""){alert("数据输入不完整"); return false;}
	if(getLen(document.getElementById("code").value) > 40){alert("字符输入过长"); return false;}
			
	if(remark == ""){alert("数据输入不完整"); return false;}
	if(getLen(document.getElementById("rem").value) > 1000){alert("字符输入过长"); return false;}
	
	if (roleIdArry.length==lenTemp){alert("请为栏目分配角色！"); return false;}
		
	infoClaCodeCheck();
	if(this.infoClacommCodeflag=="false"){alert("栏目代码不能重复！"); return false;}
	
	if(document.all.id.value=='')
		{document.all.method.value='add';}
	else
		{document.all.method.value='modify';}
	document.all.action.value='submit';
	document.forms[0].submit();
		return  true;
				
}
			
				
function returnList(){

     window.location.replace("<%=path%>/infopubclaaction.do?method=clalist&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>");
            
}
			


</script>


