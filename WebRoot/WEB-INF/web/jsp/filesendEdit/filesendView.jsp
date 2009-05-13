<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
<!--
		function selectuser(flag,argDeptOrUser)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=filesendedit&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		function clearText(obj)	{		
			document.getElementById(obj).value="";
			document.getElementById(obj+'name').value="";
		}
		
		function checkForm(act){
			if(filesendEditForm.forwardContent.value==""){
				alert("转发内容不能为空!");
				return false;
			}
			if(filesendEditForm.forwardContent.value.length >= 250){
				alert("回复(转发)内容长度不能大于250字符或文字!");
				return false;
			}
			if(filesendEditForm.forwardReceiver.value==""&&act=="forward"){
				alert("转发收件人不能为空!");
				return false;
			}
			document.all.method.value='view';
			document.all.action.value=act;
			document.forms[0].submit();
			return true;
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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>

	</head>

	<body>
		<html:form action="/filesendEdit.do" enctype="multipart/form-data"	method="post">
			<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
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
								文件发送
							</td>
						</tr>
					</table>
				</td>
          <td background="images/8-2.gif">
          
          &nbsp;</td>
        </tr>
      </table>
      <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
			<tr>
          <td>
		 <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
			<tr>
          <td>
          
      <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom" align="right">
            <img src="<%=path%>/imagine/fh.gif" width="46" height="25" onclick="window.location='<%=path%>/fileSendInListAction.do?method=list';" onmouseover="this.style.cursor='hand'">
						&nbsp;&nbsp;&nbsp;
            </th>
                </tr>
                <tr>
                  <td align="center" valign="top">
      
			<table align="center" width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in"  >
				
					<tr>
			    		<td  width="15%" height="25" align="center" class="bg-zwbt">主题</td>
			    		<td colspan="2" align="left">
			    			<html:text property="subject" maxlength="100" styleClass="shuruk2" readonly="true" ></html:text>
			    		</td>
			    	</tr>
				
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">收件人</td>
			    		<td colspan="2" align="left">
			    			<html:textarea property="receivername" styleClass="shuruk2" readonly="true" ></html:textarea>
			    		
			    			<html:hidden property="receiver"/>
			    		</td>	    		
			    	</tr>
				
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">发件人</td>
			    		<td colspan="2" align="left">
			    			<html:textarea property="sendName" styleClass="shuruk2" readonly="true" />
			    			<html:hidden property="sendId"/>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">发送时间</td>
			    		<td colspan="2" align="left">
			    			<html:textarea property="sendDt" styleClass="shuruk2" readonly="true"></html:textarea>
			    			<html:hidden property="st"/>
			    		</td>
			    	
			    	</tr>
			    	
			    	
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">正文内容</td>
			    		<td colspan="2" align="left">
			    			<html:textarea property="content" rows="2" styleClass="shuruk2" readonly="true" cols="55"  /><br/>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">附件列表</td>
			    		<td colspan="2" align="left">
<logic:present name="files">	
<table>	
	<logic:iterate id="Record" name="files" type="com.baosight.mode.TbFilesendAttachment" >
		<tr>
			<td>
			<html:link page="/filesendEdit.do?method=download" paramId="id" paramName="Record" paramProperty="id">
				<font color="red" size="2"><bean:write name="Record" property="originallyName" /></font>
			</html:link>
			<td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
			    		</td>
			    	</tr>

					<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">回复(转发)内容</td>
			    		<td colspan="2" align="left">
			    			<html:textarea property="forwardContent" styleClass="shuruk2" rows="4" cols="96" /><br/>
			    			<font color="red">回复(转发)内容描述长度不能大于250字符或文字 </font>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td  width="15%" align="center" class="bg-zwbt">转发收件人</td>
			    		<td align="left" >
			    			<html:textarea property="forwardReceivername" styleClass="shuruk2" rows="4" readonly="true" />
			    			<html:hidden property="forwardReceiver"/>
			    			<font color="red">*</font>
			    		</td>
			    		<td align="top">
				    		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0">
				    			<tr>
				    				<td>
				    					<a onclick="selectuser('forwardReceiver','user');" title="选择人员" onmouseover="this.style.cursor='hand'">
											<img src="<%=path%>/imagine/xz.gif" width="85" height="20">
										</a>
				    				</td>
				    			</tr>
				    			<tr>
				    				<td>
				    					<a onclick="filesendEditForm.forwardReceivername.value='';filesendEditForm.forwardReceiver.value='';" title="清空" onmouseover="this.style.cursor='hand'">
											<img src="<%=path%>/imagine/z3.gif" width="85" height="20">
										</a>
				    				</td>
				    			</tr>
				    		</table>
			    		</td>
			    	</tr>
				
				
					<tr>
						<td colspan="4" align="center">
							<button class="button0" onclick="checkForm('reversion');">回复</button>&nbsp;&nbsp;
							<button class="button0" onclick="checkForm('forward');">转发</button>
						</td>
					</tr>
				
			</table>
			</td></tr>
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

			<input type="hidden" name="action" />
			<input type="hidden" name="method" />

			<html:hidden property="id" />

		</html:form>
	</body>
</html>
