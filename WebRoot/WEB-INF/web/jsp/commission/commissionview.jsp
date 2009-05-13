<%@ page language="java" import="java.util.*,java.text.*,com.baosight.mode.TbUser" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
String from = request.getParameter("from");
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
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	</head>
	<body>
		<html:form action="/commission.do">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">委托办理查看</td>
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
			    		<td width="20%" align="left" style="noswap">委托名</td>
			    		<td valign="top"><html:text property="commTitle" size="50" styleClass="shuruk2" readonly="true"/>　　　
			   			</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">委托人</td>
			    		<td><html:text property="commName" size="50" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">被委托人</td>
			    		<td><html:text property="becommedName" size="50" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">开始时间</td>
			    		<td colspan="1"><html:text property="begintime" size="50" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">结束时间</td>
			    		<td><html:text property="endtime" size="50" styleClass="shuruk2" readonly="true"/>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left"style="noswap">委托事项</td>
			    		<td>
			    		<html:textarea  property="commMatters" styleClass="shuruk5" cols="74" rows="12" readonly="true"/>
			    		</td>
			    		
			    	</tr>
					<% if ("beCommed".equals(from)) {
						%>
						<tr>
							<td colspan="2" align="center">
								<input type="button" class="button0" value="同意" onclick="doIt('0')">&nbsp;&nbsp;
								<input type="button" class="button0" value="不同意" onclick="doIt('3')">
							</td>
						</tr>
						<%}
					%>
					
				 </table></td>
                </tr>
                <tr>
                  <td height="20" colspan="2"></td>
                </tr>
                
              </table></td>
            </tr>
            <tr>
              <td height="10" ></td>
            </tr>
          </table></td>
        </tr>
      </table>
			<html:hidden property="commId"/><!-- 委托人ID -->
			<html:hidden property="becommedId" /><!-- b委托人ID -->
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<html:hidden property="id" />
		</html:form>      
	</body>
</html>
<script  language="javascript">

	function doIt(yesorno){
		window.location.href="<%=path%>/commission.do?method=dealCommission&yesorno="+yesorno+"&id="+document.all.id.value;
	}	
	function returnList(){
		if ("<%=from%>"=="comm") {
			window.location.replace("<%=path%>/commission.do?method=commissionList&type=1");
		}
		else {
			window.location.replace("<%=path%>/commission.do?method=commissionList&type=2");
		}
	}
</script>


