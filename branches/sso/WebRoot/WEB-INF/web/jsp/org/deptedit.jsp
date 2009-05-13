<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String id = (String)request.getAttribute("id");
	//if (id == null) {
	//	id = "";
	//}
	//System.out.println("oooo==="+id);
	String parentId = (String) request.getAttribute("parentid");
	String addType = request.getParameter("addtype");
	List userdeptList = (List) request.getAttribute("userdeptList");
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
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="../../../../javascript/validate.js"></script>
		<script type='text/javascript'
			src='<%=strpath%>/dwr/interface/deptCheck.js'></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	</head>

	<body>
		<html:form action="/deptEdit.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">��֯��������</td>
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
																	<td nowrap align="left">
																		���ű��
																	</td>
																	<td>
																		<html:text property="code" maxlength="32"
																			styleClass="shuruk6" onkeydown="notNull();"
																			onblur="chk(),deptCodeCheck()"></html:text>
																		<font color="red">*</font>
																		<font color="red"> <span id="fcode"></span> <span
																			id=deptCodeCheck></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		��������
																	</td>
																	<td>
																		<html:text property="name" maxlength="50"
																			styleClass="shuruk6" onkeydown="notNull();"
																			onblur="chk(),deptNameCheck()"></html:text>
																		<font color="red">*</font>
																		<font color="red"> <span id="fname"></span> <span
																			id="deptNameCheck"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		���ż���
																	</td>
																	<td nowrap colspan="2">
																		<html:select property="lvl" onblur="chk();">
																			<html:option value="">---��ѡ��---</html:option>
																			<html:options collection="allDeptLvl" property="id"
																				labelProperty="name" />


																		</html:select>
																		<font color="red">*</font>
																		<font color="red"> <span id="flvl"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		��ϵ�绰
																	</td>
																	<td>
																		<html:text property="tel" maxlength="50"
																			styleClass="shuruk6" onblur="chk();"></html:text>
																		<font color="red"><span id="ftel"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		��ϵ��
																	</td>
																	<td>
																		<html:text property="ctc" maxlength="50"
																			styleClass="shuruk6" onblur="chk();"></html:text>
																		<font color="red"><span id="fctc"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap align="left">
																		˵��
																	</td>
																	<td>
																		<html:textarea property="rem" styleClass="shuruk6"
																			cols="75" rows="12" onblur="chk();"></html:textarea>
																		<font color="red"><span id="frem"></span> </font>
																	</td>
																</tr>
																<tr>
																	<td nowrap width="100" align="left">
																		��������
																	</td>
																	<td>
																		<html:select property="userdept">
																			<html:optionsCollection name="userdeptList"
																				value="id" label="name" />
																		</html:select>
																	</td>
																</tr>
																<tr>

																	<td colspan="3" align="center">
																		<a onclick="CheckForm();"
																			onmouseover="this.style.cursor='hand'"><img
																				src="<%=path%>/imagine/tj.gif" width="52"
																				height="23"> </a>&nbsp;&nbsp;
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
			<html:hidden property="nodeid" />
			<input type="hidden" name="parentid" value="<%=parentId%>" />
			<input type="hidden" name="addtype" value="<%=addType%>" />
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path%>" />
		</html:form>
	</body>
</html>




<script language="javascript">

function chk(){
		    var code = document.getElementById("code").value;
		    var name = document.getElementById("name").value;
		    var lvl = document.getElementById("lvl").value;
		    var tel = document.getElementById("tel").value;
		    var ctc = document.getElementById("ctc").value;
		    var rem = document.getElementById("rem").value;
		    
			if(code == ""){
				document.getElementById("fcode").innerHTML = "<font color='red'>"+"����Ϊ��"+"</font>";
				//document.getElementById("code").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("code").value) > 32){
					document.getElementById("fcode").innerHTML = "<font color='red'>"+"���Ȳ��ܴ���32���ַ�,����ռ2���ַ�,����&��ĸռ1���ַ�"+"</font>";
					//document.getElementById("code").focus();
					return false;	
								
				}
else{document.getElementById("fcode").innerHTML = "";}
}


			if(name == ""){
				document.getElementById("fname").innerHTML = "<font color='red'>"+"����Ϊ��"+"</font>";
				//document.getElementById("name").focus();
				return false;	
				
			}else{
				    if(getLen(document.getElementById("name").value) > 50){
					document.getElementById("fname").innerHTML = "<font color='red'>"+"���Ȳ��ܴ���50���ַ�,����ռ2���ַ�,����&��ĸռ1���ַ�"+"</font>";
					//document.getElementById("name").focus();
					return false;	
								
				}
else{document.getElementById("fname").innerHTML = "";}
}
		
		
					if(lvl == ""){
				document.getElementById("flvl").innerHTML = "<font color='red'>"+"��ѡ��ȼ�"+"</font>";
				//document.getElementById("lvl").focus();
				return false;	
				
			}
else{document.getElementById("flvl").innerHTML = "";}

		
		
					 if(getLen(document.getElementById("tel").value) > 50){
					document.getElementById("ftel").innerHTML = "<font color='red'>"+"���Ȳ��ܴ���50���ַ�,����ռ2���ַ�,����&��ĸռ1���ַ�"+"</font>";
					//document.getElementById("tel").focus();
					return false;	
								
				}
else{document.getElementById("ftel").innerHTML = "";}

					 if(getLen(document.getElementById("ctc").value) > 50){
					document.getElementById("fctc").innerHTML = "<font color='red'>"+"���Ȳ��ܴ���50���ַ�,����ռ2���ַ�,����&��ĸռ1���ַ�"+"</font>";
					//document.getElementById("ctc").focus();
					return false;	
								
				}
else{document.getElementById("fctc").innerHTML = "";}

					 if(getLen(document.getElementById("rem").value) > 200){
					document.getElementById("frem").innerHTML = "<font color='red'>"+"���Ȳ��ܴ���200���ַ�,����ռ2���ַ�,����&��ĸռ1���ַ�"+"</font>";
					//document.getElementById("rem").focus();
					return false;	
								
				}
else{document.getElementById("frem").innerHTML = "";}

}
		
					   
 
					   

			






			function CheckForm(){
			
			
			var code = document.getElementById("code").value;
		    var name = document.getElementById("name").value;
		    var lvl = document.getElementById("lvl").value;
		    var tel = document.getElementById("tel").value;
		    var ctc = document.getElementById("ctc").value;
		    var rem = document.getElementById("rem").value;
		    if(code == ""){alert("�������벻����"); return false;}
			if(getLen(document.getElementById("code").value) >32){alert("�ַ��������"); return false;}
			if(name == ""){alert("�������벻����"); return false;}
			if(getLen(document.getElementById("name").value) >50){alert("�ַ��������"); return false;}
			if(lvl == ""){alert("�������벻����"); return false;}
			if(getLen(document.getElementById("tel").value) >50){alert("�ַ��������"); return false;}
			if(getLen(document.getElementById("ctc").value) >50){alert("�ַ��������"); return false;}
			if(getLen(document.getElementById("rem").value) >200){alert("�ַ��������"); return false;}
			
			
            
            deptCodeCheck();
           
            if(this.deptCodeflag=="false"){alert("�����ظ�"); return false;}
            
            deptNameCheck();
            if(this.deptNameflag=="false"){alert("�����ظ�"); return false;}
			
			
			if(document.all.nodeid.value==''){document.all.method.value='add'}
				else{document.all.method.value='deptEdit'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}

					function returnl(){
				var parentid = document.getElementById("parentid").value;
				var pah=document.getElementById("path").value;

				window.location.replace(pah+"/orgrightdetailaction.do?method=list&nodetype=deptnode&nodeid=" + parentid);
					
				}

</script>
