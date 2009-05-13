<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
String method=request.getParameter("method");
String view=request.getParameter("view");
String type=request.getParameter("type");
String hui=request.getParameter("hui");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
<!--
		var view='<%=view%>';
		function selectuser(flag,argDeptOrUser,tid,tname)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText="+tid+"&nameText="+tname+"&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		
		function checkForm(){
			var act=window.event.srcElement.id;
			if(consultationviewForm.response.value==""&&(act=="save"||act=="reply")){
				alert("答复内容不能为空!");
				return false;
			}
			if(consultationviewForm.ZBname.value==""&&act=="zb"){
				alert("专办人员不能为空!");
				return false;
			}
			if(consultationviewForm.IDEAname.value==""&&act=="idea"){
				alert("征询意见人员不能为空!");
				return false;
			}
			document.all.method.value="submit"+"<%=method%>";
			document.all.action.value=act;
			document.forms[0].submit();
			return true;
		}
		function init(){
			var objInput=document.forms[0].getElementsByTagName("input"); 
			for (i=0;i<objInput.length;i++){ 
				if (objInput[i].type=="text") 
					objInput[i].setAttribute('readOnly',true);
			}
			if(view=='1'){
				//t1.style.display='none';
				d1.style.display='none';
				t2.style.display='none';
			}
		}
		function hui(){
			var hui = "<%=hui%>";
			var type = "<%=type%>";
			var action = 'opinion';
			if(hui=='1'){
				window.location.replace('<%=path%>/'+action+'SLWaitListAction.do?method=list');
			}else if(hui=='2'){
				window.location.replace('<%=path%>/'+action+'SLProcessListAction.do?method=list');
			}else if(hui=='3'){
				window.location.replace('<%=path%>/'+action+'SLOverListAction.do?method=list');
			}else if(hui=='4'){
				window.location.replace('<%=path%>/'+action+'WaitListAction.do?method=list&type='+type);
			}else if(hui=='5'){
				window.location.replace('<%=path%>/'+action+'OverListAction.do?method=list&type='+type);
			}
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
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />

	</head>

	<body onload="init();">
		<html:form action="/opinionView.do" method="post">
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
								局长信箱
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
          <td><table width="99%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <td align="center" valign="top">
                  <table width="99%" border="0" cellspacing="0" cellpadding="0"> 
                  <tr>
                  <td align="right">
					<img src="<%=path %>/images/fh.gif" width="46" height="25" onClick="hui();" onMouseOver="this.style.cursor='hand'">
					&nbsp;
				</td>
			</tr>
			</table>
			
			<table align="center" width="99%" border="0" cellpadding="0" cellspacing="1"  class="tabin1_in">
				<thead class="bg-zw">
					<tr>
			    		<td nowrap  height="25" width="12%" align="center" class="bg-zwbt">投诉人</td>
			    		<td colspan="2" align="center" >
			    			<html:text property="asker" maxlength="25" style="width:98%" styleClass="input-noborder" readonly="true" ></html:text>
			    		</td>
			    	</tr>
					
					<tr>
			    		<td nowrap  height="25" align="center" class="bg-zwbt">意见人邮箱</td>
			    		<td colspan="2" align="center" >
			    			<html:text property="askerEmail" maxlength="25" style="width:98%" styleClass="input-noborder" readonly="true" ></html:text>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap height="25" align="center" class="bg-zwbt">意见人联系电话</td>
			    		<td colspan="2" align="center" >
			    			<html:text property="askerPhone" maxlength="25" style="width:98%" styleClass="input-noborder" readonly="true" ></html:text>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap  height="25" align="center" class="bg-zwbt">意见主题</td>
			    		<td colspan="2" align="center" >
			    			<html:text property="Subject" maxlength="50" style="width:98%" styleClass="input-noborder" readonly="true" ></html:text>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap height="25"  align="center" class="bg-zwbt">意见内容</td>
			    		<td colspan="2"  align="center">
			    			<html:textarea styleClass="tabin_textarea3" property="content" style="width:98%" cols="90" rows="3" readonly="true"/>
			    		</td>
			    	</tr>
				</thead>
			</table>
			<br>
			<table id="t1" align="center" width="99%" border="0" cellpadding="0" cellspacing="1"  class="tabin1_in">
				<thead class="bg-zw">
				
				<tr>
			    	<td nowrap width="12%" height="25" align="center" class="bg-zwbt">答复内容</td>
			    	<td colspan="2" align="center">
			    	<%if(null!=view && view.equals("1")){ %>
			    		<html:textarea styleClass="tabin_textarea3" property="response" style="width:98%" cols="90" rows="3" readonly="true"/>
			    	<%}else{ %>
			    		<html:textarea styleClass="tabin_textarea1" property="response" style="width:98%" cols="90" rows="3" />
			    	<%} %>
			    	</td>
			    </tr>
				</thead>	
			</table>
			<div id="d1" width="90%"  align="center">
				<input class="button0" type="button" onclick="checkForm()" value="保存" id="save"/>&nbsp;&nbsp;
				<input class="button0" type="button" onclick="checkForm()" value="答复" id="reply"/>
			</div> 
			<br>
			<table align="center" width="99%" border="0" cellpadding="0" cellspacing="0"  class="tabin1_in">
				<thead class="bg-zw">
<logic:notEmpty name="publicAffairTransacts">
					<tr>
			    		<td height="25" width="12%" align="center" class="bg-zwbt">办理人</td>
			    		<td align="center" width="10%" class="bg-zwbt">办理时间</td>
			    		<td  align="center" class="bg-zwbt">意见</td>
			    	</tr>
<%
List publicAffairTransacts=(List)request.getAttribute("publicAffairTransacts");
Iterator iter = publicAffairTransacts.iterator();
while(iter.hasNext()){
	Object[] item=(Object[])iter.next();
 %>

			    	<tr>
			    		<td height="25"  align="center">
			    	<%=item[0] %>
			    				
						</td>
			    		<td  align="center">
			    	<%=((Date)item[1]).toString().substring(0,10) %>		
						</td>
			    		<td align="center" >
			    	<%=item[2] %>	
						</td>
			    	</tr>
	
<%} %>
</logic:notEmpty>
				</thead>
				</table>
<br>						
				<table id="t2" align="center" width="99%" border="0" cellpadding="0" cellspacing="1"  class="tabin1_in">
				<thead class="bg-zwbt">
			    	
			    	<tr>
						<td width="12%" height="25"align="center" class="bg-zwbt">
							<input class="button0" type="button" onclick="selectuser('participant','user','ZB','ZBname')"  value="转办" />
						</td>
						<td colspan="3">
							<table width="100%" >
								<tr>
				    				<td>
				    						<html:text property="ZBname" size="75"  readonly="true" />
			    							<html:hidden property="ZB" />
				    				</td>
				    				
				    				<td>
				    					<input class="button0" type="button" onclick="checkForm()" value="提交" id="zb"/>
										<input class="button0" type="button" onclick="consultationviewForm.ZB.value='';consultationviewForm.ZBname.value=''" value="重新选择" />
									</td>	
				    			</tr>
			    			</table>
						</td>
					</tr>
			   
			   		<tr>
						<td nowrap width="12%" height="25" align="center" class="bg-zwbt">
							<input class="button0" type="button" onclick="selectuser('participant','user','IDEA','IDEAname')"  value="征询意见" />
						</td>
						<td colspan="3">
							<table width="100%" >
								<tr>
				    				<td>
				    					<html:text property="IDEAname" size="75"  readonly="true" />
				    					<html:hidden property="IDEA"  />
				    				</td>
				    				<td>
				    					<input class="button0" type="button" onclick="checkForm()" value="提交" id="idea"/>
										<input class="button0" type="button" onclick="consultationviewForm.IDEA.value='';consultationviewForm.IDEAname.value=''" value="重新选择" />
									</td>	
				    			</tr>
			    			</table>
						</td>
					</tr>
				<tr>
			    <td height="0"></td>
			 </tr>	
			</table></td></tr>
			<tr>
			<td height="20"></td>
			</tr>
			</table>
			</td>
			</tr>
			</table><tr><td height="6"></td></td></tr></table></tr>
			</td></tr></table>	
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="type" value='<%=type%>' />
			<html:hidden property="id" />

		</html:form>
	</body>
</html>
