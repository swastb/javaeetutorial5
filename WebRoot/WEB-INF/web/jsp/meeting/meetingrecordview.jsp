<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<jsp:directive.page import="com.baosight.mode.TbMessages"/>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
String title=(String)request.getAttribute("title");
String ftime=(String)request.getAttribute("ftime");
String ttime=(String)request.getAttribute("ttime");
List message = (List) request.getAttribute("message");
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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	

	</head>
	
	<body>
		<html:form action="/meetingrecordaction.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">添加会议纪要信息</td>
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
			    		<td nowrap width="96" height="25">会议纪要标题</td>
			    		<td colspan="2"><html:text property="meetingrecordTitle"  styleClass="shuruk2" readonly="true"></html:text>
			    		
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	
			    	<tr>
			    		<td nowrap width="80" height="25">会议召开时间</td>
			    		<td colspan="2"><html:text property="meetingrecordTime" styleClass="shuruk2"readonly="false" />
			    		
			    	    
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap width="80">议题</td>
			    		<td colspan="2"><html:textarea property="meetingrecordName" styleClass="shuruk2" cols="60" rows="5" disabled="true"></html:textarea>
			    		
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80">决议</td>
			    		<td colspan="2"><html:textarea property="meetingrecordAdv" styleClass="shuruk2" cols="60" rows="5"   disabled="true"></html:textarea>
			    		
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80">备注</td>
			    		<td colspan="2"><html:textarea property="meetingrecordRem" styleClass="shuruk2" cols="60" rows="5"   disabled="true"></html:textarea>
			     		
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td nowrap width="80">参加人员</td>
			    		<td colspan="2"><html:textarea property="meetingrecordJoiner" styleClass="shuruk2" cols="60" rows="5" disabled="true"></html:textarea>
			        </tr>
			    	
			    	<tr  align="left">
											<th width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<font color="red">序号</font>
											</th>
											<th width="20%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<font color="red">通知人员</font>
											</th>
											<th width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<font color="red">状态</font>
											</th>
											
										</tr>
										<%
												for (int i = 0; i < message.size(); i++) {
												TbMessages messages=(TbMessages)message.get(i);
										%>
										<tr align="center" class="bg-zw">
											<td width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=i + 1%>
											</td>
											
											<td width="20%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=messages.getReceiversName().toString()%>
											</td>
											<%if("2".equals(messages.getStatus().toString())){
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
											未查看	
											</td>
											<%}else if("3".equals(messages.getStatus().toString())){
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
											已查看	
											</td>
											<%}else{
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
											草稿	
											</td>
											<%} %>
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
              <td height="10"></td>
            </tr>
          </table></td>
        </tr>
      </table>
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path %>"/>
			<input type="hidden" name="title" value="<%=title %>"/>
            <input type="hidden" name="ftime" value="<%=ftime %>"/>
            <input type="hidden" name="ttime" value="<%=ttime %>"/>
			<html:hidden property="id" />

		</html:form>
	</body>
</html>
<script  language="javascript">
     		
				function returnl(){
				
				var pah=document.getElementById("path").value;

				window.location.replace("<%=path%>/meetingrecordaction.do?method=listSelect&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>");

				}
				

</script>


