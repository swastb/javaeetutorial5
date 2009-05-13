<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="java.text.SimpleDateFormat"/>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			String year=(String)request.getAttribute("year");

            String month=(String)request.getAttribute("month");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'weekSecheduleedit.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	</head>
	
	<body>
		<html:form action="/oaholidayaction.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">节假日安排管理</td>
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
			    		<td nowrap width="100" height="25" align="center" class="bg-zwbt">日期</td>
			    		<td colspan="2">
			    			<html:text property="holiday" styleClass="shuruk4" onclick="return showCalendar('holiday', 'y-mm-dd');" readonly="true"/><br>
			    	
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="100"height="25" align="center" class="bg-zwbt">时间段</td>
			    		<td colspan="2">
			    			<html:radio property="amPm" value="am_pm">全天</html:radio>
			    			<html:radio property="amPm" value="am">上午</html:radio>
			    			<html:radio property="amPm" value="pm">下午</html:radio>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="100" align="center" class="bg-zwbt">说明</td>
			    		<td colspan="2"><html:textarea property="description" styleClass="shuruk5" cols="70" rows="5"/><font color="red">*</font></td>
			    		
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
			<input type="hidden" name="year" value="<%=year %>"/>
			<input type="hidden" name="month" value="<%=month %>"/>
			<input type="hidden" name="path" value="<%=path %>"/>

			<html:hidden property="id" />


		
		</html:form>
	</body>
</html>
<script type="text/javascript">

			
			function CheckForm(){

			  var holiday = document.getElementById("holiday").value;
		    var description = document.getElementById("description").value;
			if(holiday == ""){alert("数据输入不完整"); return false;}
		
			if(description == ""){alert("数据输入不完整"); return false;}
			if(getLen(document.getElementById("description").value) >500){alert("字符输入过长"); return false;}
			
			
			
            
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modify'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}
				
				function returnl(){
				
				var pah=document.getElementById("path").value;

				window.location.replace(pah+"/oaholidayaction.do?method=list");

				}
			</script>


