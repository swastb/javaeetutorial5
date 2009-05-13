<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>新信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
		<style>
		a:link {text-decoration: none;}
		a:visited {text-decoration: none;}
		a:active {text-decoration: none;}
		a:hover {text-decoration: none;}
		</style>
		<script type="text/javascript">
		function submitForm(){
			var f = document.forms[0];
			f.submit();
		}
		</script>
	</head>
	<body style="margin: 0px">
		<html:form action="/messages.do">
		
		<%--<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5%" align="center" valign="middle">
								&nbsp;
							</td>
							<td width="11%" height="12" align="center" valign="middle">
								<img src="images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								新消息
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
              <td align="center" valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
               
                <tr>
                  <td align="center" valign="top">
		
		
		--%><table table width="100%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
		<tr><th colspan="2">新消息</th></tr>
		<tr>
		<td  width="30%">发件人：</td>
		<td align="left" width="70%">&nbsp;&nbsp;<bean:write name="messagesForm" property="senderName"/></td>
		</tr>
		<tr>
		<td>接收人：</td>
		<td align="left">&nbsp;&nbsp;<bean:write name="messagesForm" property="receiversname"/></td>
		</tr>
		<tr>
		<td>发送时间：</td>
		<td align="left">&nbsp;&nbsp;<bean:write name="messagesForm" property="sendTime"/></td>
		</tr>
		<tr>
		<td height="30">标题：</td>
		<td align="left">&nbsp;&nbsp;<bean:write name="messagesForm" property="title"/></td>
		</tr>
		<tr>
		<td height="45">内容：</td>
		<td align="left">&nbsp;&nbsp;<bean:write name="messagesForm" property="content"/></td>
		</tr>
		<%--<tr>
		<td>消息类型：</td>
		<td align="left">&nbsp;&nbsp;<bean:write name="messagesForm" property="messageType"/></td>
		</tr>
		--%><tr>
		<td>内容回复：</td>
		<td align="left"><textarea rows="5" class="tabin1_in"  cols="40" name="content"></textarea></td>
		</tr>
		<tr>
		<td colspan="2"><input type="button" class="button1" value="提交" onclick="submitForm()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="button1" value="关闭" onclick="window.close();"/></td>
		</tr>
		</table>
		</td></tr>
		
			</table>
			<%--</td></tr>
			</table>
			</td></tr><tr>
			<td height="10"></td>
			</tr>
			</table>
		</td></tr></table>
		
		
		--%><input type="hidden" name="action" value="submit"/>
		<input type="hidden" name="nowTime" value="1"/>
		<input type="hidden" name="title" value="re:<bean:write name="messagesForm" property="title"/>"/>
		<input type="hidden" name="method" value="sendMessages"/>
		<input type="hidden" name="receiversname" value='<bean:write name="messagesForm" property="senderName"/>'/>
		<input type="hidden" name="receivers" value='<bean:write name="messagesForm" property="senderId"/>'/>
		<input type="hidden" name="fromPage" value="openWindow"/>
	</html:form>
	</body>
</html>
