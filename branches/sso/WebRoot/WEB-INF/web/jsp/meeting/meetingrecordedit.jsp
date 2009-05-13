<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

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
			    		<td colspan="2"><html:text property="meetingrecordTitle"  style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;width:90%" onkeydown="notNull();"></html:text>
			    		<font color="red">*</font>
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	
			    	<tr>
			    		<td nowrap width="80" height="25">会议召开时间</td>
			    		<td colspan="2"><html:text property="meetingrecordTime" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;width:90%" onfocus="setday(this)" readonly="false" />
			    		<font color="red">*</font>
			    	    
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap width="80">议题</td>
			    		<td colspan="2"><html:textarea property="meetingrecordName" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;height:80px;width:90%" cols="60" rows="5"   onkeydown="notNull();"></html:textarea>
			    		<font color="red">*</font>
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80">决议</td>
			    		<td colspan="2"><html:textarea property="meetingrecordAdv" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;height:80px;width:90%" cols="60" rows="5"   onkeydown="notNull();"></html:textarea>
			    		<font color="red">*</font>
			    		
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80">备注</td>
			    		<td colspan="2"><html:textarea property="meetingrecordRem" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;height:80px;width:90%" cols="60" rows="5"   onkeydown="notNull();"></html:textarea>
			     		
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td nowrap width="80">参加人员</td>
			    		<td colspan="2"><html:textarea property="meetingrecordJoiner" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;height:80px;width:90%" cols="60" rows="5"   onkeydown="notNull();" disabled="true"></html:textarea>
			    		<font color="red">*</font>
			    	
    		            <html:hidden  property="joiner" />
						<a onClick="selectuser('joiner','user');" title="选择人员" onMouseOver="this.style.cursor='hand'">
						<img src="<%=path%>/imagine/xz.gif" width="85" height="20">
						</a>
						<a onclick="clearText('joiner');" title="清空" onmouseover="this.style.cursor='hand'">
						<img src="<%=path%>/imagine/z3.gif" width="85" height="20">
						</a>
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80">通知人员</td>
			    		<td colspan="2"><html:textarea property="attr1" style="color: 4c6a95;ext-indent: 1pt;height: 18px;border: 1px solid #a5a5a5;height:80px;width:90%" cols="60" rows="5"   onkeydown="notNull();" disabled="true"></html:textarea>
			    		<font color="red">*</font>
			    		
    		            <html:hidden  property="attr1S" />
						<a onClick="selectuserS('attr1S','user');" title="选择人员" onMouseOver="this.style.cursor='hand'">
						<img src="<%=path%>/imagine/xz.gif" width="85" height="20">
						</a>
						<a onclick="clearTextS('attr1S');" title="清空" onmouseover="this.style.cursor='hand'">
						<img src="<%=path%>/imagine/z3.gif" width="85" height="20">
						</a>
			    		</td>
			    		
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
			<input type="hidden" name="path" value="<%=path %>"/>
			<input type="hidden" name="title" value="<%=title %>"/>
            <input type="hidden" name="ftime" value="<%=ftime %>"/>
            <input type="hidden" name="ttime" value="<%=ttime %>"/>
			<html:hidden property="id" />

		</html:form>
	</body>
</html>
<script  language="javascript">
     		function CheckForm(){
			
			
		    var meetingrecordTitle = document.getElementById("meetingrecordTitle").value;
		    var meetingrecordTime = document.getElementById("meetingrecordTime").value;
		    var meetingrecordName = document.getElementById("meetingrecordName").value;
		    var meetingrecordAdv = document.getElementById("meetingrecordAdv").value;
		    var meetingrecordRem = document.getElementById("meetingrecordRem").value;
		    var meetingrecordJoiner = document.getElementById("meetingrecordJoiner").value;
		    var attr1 = document.getElementById("attr1").value;
		    
		    if(meetingrecordTitle == ""){alert("'会议纪要名称'不能为空，请重新输入"); return false;}
			if(getLen(document.getElementById("meetingrecordTitle").value) > 100){alert("'会议纪要名称'不能大于100字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(meetingrecordTime == ""){alert("'会议召开时间'不能为空，请重新输入"); return false;}
		
			if(meetingrecordName == ""){alert("'议题'不能为空，请重新输入"); return false;}
			if(getLen(document.getElementById("meetingrecordName").value) > 2000){alert("'议题'不能大于2000字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(meetingrecordAdv == ""){alert("'决议'不能为空，请重新输入"); return false;}
			if(getLen(document.getElementById("meetingrecordAdv").value) > 2000){alert("'决议'不能大于2000字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(getLen(document.getElementById("meetingrecordRem").value) > 1000){alert("'备注'不能大于1000字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(meetingrecordJoiner == ""){alert("'参加人员'不能为空，请重新选择"); return false;}
			if(getLen(document.getElementById("meetingrecordJoiner").value) > 500){alert("'参加人员'不能大于500字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(attr1 == ""){alert("'通知人员'不能为空，请重新选择"); return false;}
			if(getLen(document.getElementById("attr1").value) > 500){alert("'通知人员'不能大于500字符，中文占2个字符，英文占1个字符"); return false;}
			
			if(document.all.id.value==''){document.all.method.value='add'}
				else{document.all.method.value='modify'};
				document.all.action.value='submit';
				document.forms[0].submit();
				return  true;
				
				}
				
				function onlyNum() 
				{ 
				if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 
				if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105))) 
				event.returnValue=false; 
				} 
				function returnl(){
				
				var pah=document.getElementById("path").value;

				window.location.replace("<%=path%>/meetingrecordaction.do?method=listSelect&title=<%=title%>&ftime=<%=ftime%>&ttime=<%=ttime%>");

				}
				
				var flag = 0;
		function selectuser(flag,argDeptOrUser)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText=joiner&nameText=meetingrecordJoiner&deptOrUser=user&flag=participant",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');		
			//window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=filesendedit&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		
		function selectuserS(flag,argDeptOrUser)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText=attr1S&nameText=attr1&deptOrUser=user&flag=participant",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');		
			//window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=filesendedit&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		
		function clearText(obj)	{		
			document.getElementById(obj).value="";
			document.getElementById('meetingrecordJoiner').value="";
		}
		function clearTextS(obj)	{		
			document.getElementById(obj).value="";
			document.getElementById('attr1').value="";
		}

</script>


