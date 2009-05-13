<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
<!--
function returnlist(){
				
				window.location.replace("<%=path%>/commonalityaction.do?method=list&action=all");

				}
//-->
</script>
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
		<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>

	</head>

	
	<body>
		<html:form action="/commonalityaction.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">公共通讯录</td>
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
			    		<td width="100" class="bg-zwbt">姓名</td>
			    		<td colspan="2"><html:text property="name" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    		
			    	</tr>
					<tr>
			    		<td width="100" class="bg-zwbt">职务</td>
			    		<td colspan="2"><html:text property="duty" styleClass="shuruk2" readonly="true"></html:text>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="100" class="bg-zwbt">联系电话</td>
			    		<td><html:text property="movePhone" styleClass="shuruk2" readonly="true"/>		
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="100" class="bg-zwbt">一级组名称</td>
			    		<td colspan="2"><html:text property="attr1" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="100" class="bg-zwbt">二级组名称</td>
			    		<td colspan="2"><html:text property="attr2" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="100" class="bg-zwbt">备注</td>
			    		<td colspan="2"><html:textarea property="remark" styleClass="shuruk2" cols="60" rows="5" readonly="true"></html:textarea>
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
      </html:form>