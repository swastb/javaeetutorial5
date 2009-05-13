<%@ page language="java" import="org.apache.struts.validator.DynaValidatorForm;" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addVehicles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<link href="images/style.css" rel="stylesheet" type="text/css" />
	 <script type="text/javascript">
		function returnl(){
            window.location.replace("<%=path%>/vehicles.do?method=findVehiclesList");
		}
		
		function subForm(){	
			var license2=document.getElementById("license2").value;
			if(getLen(license2)==0 || !(license2.match(/^[0-9]+$/))){
				alert("车牌必须非空且为数字！");
				return;
			}
			var capacity=document.getElementById("capacity").value;
			if(!(capacity.match(/^[0-9]+$/))){
				alert("容量必须为数字！");
				return;
			}
		
			var id=document.getElementById("id").value;
			if(document.all.id.value==''){
				document.all.method.value='add';
			}else{
				document.all.method.value='modify';
			}  
			document.all.action.value='submit';
			document.forms[0].submit();   
		}
		
		function checkForm(name,checkName){
		    var name = document.getElementById(name).value;
		
			if(name == "" || !(name.match(/^[0-9]+$/))){
				document.getElementById(checkName).innerHTML = "<font color='red'>"+"*不能为空且必须为数字"+"</font>";
				return false;	
			}else{
				document.getElementById(checkName).innerHTML ="";
			}
		}				
	</script>

  </head>
  
  <body>
    <html:form action="/vehicles.do">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic"><span class="bg-zw"><strong>
						<%
						String id=request.getParameter("id");
						if(null!=id && !("".equals(id))){
						 %>
						 修改
						 <%
						 }else{
						  %>
						  新增
						<%}%>
						车辆信息:</strong></span></td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnl();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    		<td width="100" height="25" align="center" class="bg-zwbt">车牌</td>
			    		<td colspan="2" width="90%">
			    		&nbsp;沪 - 
			    			<html:select property="license1" style="height:20px">
								<html:option value="A">A</html:option>
								<html:option value="B">B</html:option>
								<html:option value="C">C</html:option>
								<html:option value="D">D</html:option>
								<html:option value="E">E</html:option>
								<html:option value="F">F</html:option>
								<html:option value="G">G</html:option>
								<html:option value="H">H</html:option>
							</html:select> -
			    			<html:text property="license2" styleClass="shuruk1" onblur="checkForm('license2','checkLicense2')"></html:text>
			    			<span id="checkLicense2"></span>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td width="100" height="25"align="center" class="bg-zwbt">车型</td>
			    		<td  width="90%">
				    		<html:select property="model" style="width:100px">
								<html:option value="大">大型</html:option>
								<html:option value="中">中型</html:option>
								<html:option value="小">小型</html:option>
							</html:select>	
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="100" height="25"align="center" class="bg-zwbt">容量(人)</td>
			    		<td width="90%">
			    			<html:text property="capacity" styleClass="shuruk1" onblur="checkForm('capacity','checkCapacity')"></html:text>
			    			<span id="checkCapacity"></span>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="100" height="25" align="center" class="bg-zwbt">状态</td>
			    		<td width="90%">
			    			<html:select property="status" style="width:100px">
								<html:option value="1">正常</html:option>
								<html:option value="0">维修中</html:option>
								<html:option value="-1">报废</html:option>
							</html:select>	
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="100" align="center" class="bg-zwbt">备注</td>
			    		<td width="90%"><html:textarea property="rem" cols="70" rows="5" styleClass="shuruk5"></html:textarea></td>
			    		
			    	</tr>
					<tr>
						<td colspan="2" valign="bottom"  align="center">
							<a onclick="subForm();" onmouseover="this.style.cursor='hand'">
								<img src="/sso/imagine/tj.gif" width="52" height="22"></a>
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
			
			<input type="hidden" name="action" id="action" />
			<input type="hidden" name="method" id="method" />
			<html:hidden property="id"/>
</html:form>
  </body>
</html>
