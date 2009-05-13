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
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="../../../../javascript/validate.js"></script>
		
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnlist()" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    <td width="150" align="center" class="bg-zwbt"><font color="red"></font>组名</td>
			    <td colspan="2"><html:text property="individualId" styleClass="shuruk2" value="${individualId}" readonly="true"/>
			    </td>
                </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt"><font color="red"></font>姓名</td>
			    <td colspan="2"><html:text property="name" styleClass="shuruk2" readonly="true"/>
			    </td>
                </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">职务</td>
			    <td colspan="2"><html:text property="duty" styleClass="shuruk2" readonly="true"/>
			   　</td>
			    </tr>
			    		
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">部门</td>
			    <td colspan="2"><html:text property="department" styleClass="shuruk2" readonly="true"/>
			    </td>	
			   　</tr>
			    		
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">传真</td>
			    <td colspan="2"><html:text property="fax" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    		
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">邮编</td>
			    <td colspan="2"><html:text property="post" styleClass="shuruk2" readonly="true"/>
                </td>
			    </tr>
			    		
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">地址</td>
			    <td colspan="2"><html:text property="address" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">部门电话</td>
			    <td colspan="2"><html:text property="partmentPhone" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt"><font color="red"></font>移动电话</td>
			    <td colspan="2"><html:text property="movePhone" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    		
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">住宅电话</td>
			    <td colspan="2"><html:text property="homePhone" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">Email</td>
			    <td colspan="2"><html:text property="email" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">QQ</td>
			    <td colspan="2"><html:text property="qq" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">MSN</td>
			    <td colspan="2"><html:text property="msn" styleClass="shuruk2" readonly="true"/>
			    </td>
			    </tr>
			    
			    <tr>
			    <td width="150" align="center" class="bg-zwbt">备注</td>
			    <td colspan="2"><html:textarea  property="remark" styleClass="shuruk2" cols="70" rows="12" readonly="true"/>
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

			function returnlist(){

            window.location.replace("<%=path%>/individualaction.do?method=listSelect&pername=<%=pername%>&perphone=<%=perphone%>");
            
			}




</script>


