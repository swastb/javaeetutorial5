<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String currentPath = request.getServletPath();
//String insureOn=(String)request.getAttribute("insureOn");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vehicles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
     <link href="<%=path %>/images/style.css" rel="stylesheet" type="text/css" />
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
	<script type="text/javascript">
		function returnl(){
			if(document.getElementById("source").value=="receivers"){
				window.location.replace("<%=path%>/messages.do?method=findMessages");
			}else if(document.getElementById("source").value=="notRead"){
				window.location.replace("<%=path%>/notReadMsgMessages.do?method=findNotReadMessages");
			}else{
				window.location.replace("<%=path%>/messages.do?method=sendBoxList");
			}            
		}
	</script>
  </head>
  
  <body>
    <html:form action="/messages.do">
    <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="5%" align="center" valign="middle">&nbsp;</td>
					<td width="11%" height="12" align="center" valign="middle">
						<img src="images/icon5.gif" width="7" height="7" />
					</td>
					<td width="84%" class="table2_topic">
						信息通讯
					</td>
				</tr>
			</table>
		 </td>
         <td background="images/8-2.gif">&nbsp;</td>
        </tr>
    </table>
    <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
		<tr>
          <td>
		 	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
				<tr>
          			<td><table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
           			 <tr>
              			<td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
               			 <tr>
                  			<td align="center" valign="top">
                  			<table width="98%" border="0" cellspacing="0" cellpadding="0"> 
                 		 		<tr>
                 					<td align="right">
										<img src="<%=path %>/images/fh.gif" width="46" height="25" onclick="returnl();" onmouseover="this.style.cursor='hand'">
										&nbsp;
									</td>
								</tr>
							</table>
							<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
								<tr>
									<td height="24" width="20%" align="center" >发件人</td>
									<td  width="" class="bg-zwbt">
										<html:text property="senderName" readonly="true" styleClass="shuruk2" style="width:100%;"></html:text>
									</td>		
								</tr>
								<tr>
									<td height="24" width="20%" align="center" >收件人</td>
									<td  width="" class="bg-zwbt"><html:text property="receiversname" readonly="true" styleClass="shuruk2" style="width:100%;"></html:text></td>		
								</tr>
								<tr>
									<td height="24" width="20%" align="center" >主题</td>
									<td  width="" class="bg-zwbt"><html:text property="title" readonly="true" styleClass="shuruk2" style="width:100%;"></html:text></td>		
								</tr>
								<tr>
									<td height="24" width="20%" align="center">发送时间</td>
									<td  width="" class="bg-zwbt"><html:text property="sendTime"  readonly="true" styleClass="shuruk2" style="width:100%;"></html:text></td>		
								</tr>
								<tr>
									<td height="24" width="20%" align="center" >发送方式</td>
									<td  width="" class="bg-zwbt">
									<%
									if(request.getAttribute("sendWay").toString().equals("1")){%>
									<input type="text" value="站内短信"  readonly class="shuruk2" style="width:100%;"></input>	
									<%}else if(request.getAttribute("sendWay").toString().equals ("2")){%>
									<input type="text" value="手机短信"  readonly class="shuruk2" style="width:100%;"></input>
									<%}else if(request.getAttribute("sendWay").toString().equals ("12")){%>
									<input type="text" value="站内短信"  readonly class="shuruk2" style="width:100%;"></input>
									<input type="text" value="手机短信"  readonly class="shuruk2" style="width:100%;"></input>
									<% }%>
									</td>		
								</tr>
								<tr>
									<td  width="30%" align="center" >消息内容</td>
									<td  width="" class="bg-zwbt"><html:textarea  property="content" rows="5" readonly="true" styleClass="TEXTAREA2" style="width:100%;"></html:textarea></td>		
								</tr>
	<html:hidden property="source"></html:hidden>
							</table>
							</td>
						</tr>
						<tr>
			    			<td height="20"></td>
						 </tr>	
					</table></td></tr>
					<%--<tr>
					<td height="10"></td>
					</tr>
					--%></table>
					</td></tr><tr>
					<td height="10"></td>
					</tr>
					</table></td></tr></table>
	</html:form>
  </body>
</html>
