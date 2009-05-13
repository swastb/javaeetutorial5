<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbMeetingroom"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
<!--
		var num = 0; 
	    function additem(id){
     		var row,cell,str; 
			row = eval("document.all["+'"'+id+'"'+"]").insertRow();
     		if(row != null ){
	        	cell = row.insertCell();
	        	strbutton="<img src="+'"'+"<%=path%>/imagine/del.JPG"+'"'+" onmouseover="+'"'+"this.style.cursor="+"'hand'"+'"'+" onclick='deleteitem(this,"+'"'+"tb"+'"'+");'>";  ;
	        	str="<input type="+'"'+"file"+'"'+" name=uploadFile["+ num +"].file onkeydown="+'"'+"event.returnValue=false;"+'"'+" onpaste="+'"'+" return false"+'"'+">"+strbutton;
	        	cell.innerHTML=str;
        	}
     		num++;
   		}
	    function deleteitem(obj,id){
		     var rowNum,curRow;
		     curRow = obj.parentNode.parentNode;
		     rowNum = eval("document.all."+id).rows.length - 1;
		     eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex); 
		}
		
		function selectuser(flag,argDeptOrUser,tid,tname)	{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=shouwenuser&idText="+tid+"&nameText="+tname+"&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
		function clearText(obj)	{		
			document.getElementById(obj).value="";
			document.getElementById(obj+'name').value="";
		}
		
		function checkForm(){
			if(filesendEditForm.receiver.value==""){
				alert("收件人不能为空!");
				return false;
			}
			if(filesendEditForm.content.value==""){
				alert("正文内容不能为空!");
				return false;
			}
			if(filesendEditForm.content.value.length >= 250){
				alert("正文内容长度不能大于250字符或文字!");
				return false;
			}
			document.all.method.value='add';
			document.all.action.value='submit';
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
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		
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
								<img src="<%=path%>/images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								文件发送
							</td>
						</tr>
					</table>
				</td>
          <td background="<%=path%>/images/8-2.gif">&nbsp;</td>
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
					<img src="<%=path%>/images/fh.gif" width="46" height="25"  onclick="window.location='<%=path%>/fileSendInListAction.do?method=list';"  onmouseover="this.style.cursor='hand'">
					&nbsp;
				</td>
			</tr>
			</table>
			
			
			
			<table align="center" width="99%" border="0" cellpadding="0" cellspacing="1" bordercolor="black" class="tabin_in">
				<thead class="bg-zw">
			    	<tr height="20">
			    		<td width="85"class="bg-zw"  align="center"  background="<%=path%>/imagine/bt-d.gif" height="20" valign="middle"><a onclick="selectuser('receiver','user','receiver','receivername');" title="选择人员" onmouseover="this.style.cursor='hand'">
								
								收件人</a></td>
			    		<td width="700" valign="top" align="left">
			    			<html:text property="receivername" readonly="true" style="border: 1px none;color: 4c6a95;text-indent: 1pt;width: 70%;border: 1px solid #a5a5a5;" ></html:text>
			    			<html:hidden  property="receiver" />

			    		</td>
			    		<td class="bg-zwbt">
				    		
				    		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="97cdda" class="tableborder">
				    		
				    		<tr>
				    			<td width="85"class="bg-zw"  align="center" height="20" valign="middle" background="<%=path%>/imagine/bt-d.gif">
				    			<a onclick="clearText('receiver');" title="清空" onmouseover="this.style.cursor='hand'">
								取消
								</a>
								</td>
				    		</tr>
				    		</table>
			    		</td>		    		
			    	</tr>
				
			    	<tr>
			    		<td nowrap width="85" align="center" class="bg-zw" background="<%=path%>/imagine/bt-d.gif" height="20" valign="middle"><a onclick="selectuser('cc','user','cc','ccname');" title="选择人员" onmouseover="this.style.cursor='hand'">抄送</a></td>
			    		<td width="700" align="left">
			    			<html:text property="ccname"   readonly="true" style="border: 1px none;color: 4c6a95;text-indent: 1pt;width: 70%;border: 1px solid #a5a5a5;"></html:text>
			    			<html:hidden  property="cc" />
			    		
			    		</td>
			    		<td class="bg-zwbt">
			    		<html:hidden  property="cc" />
			    		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
								bordercolor="97cdda" class="tableborder">
			    			
			    			<tr>
			    				<td width="85"class="bg-zw"  align="center" height="20" valign="middle" background="<%=path%>/imagine/bt-d.gif">
			    					<a onclick="clearText('cc');" title="清空" onmouseover="this.style.cursor='hand'">
										取消
									</a>
			    				</td>
			    			</tr>
			    		</table>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80" align="center" class="bg-zw" background="<%=path%>/imagine/bt-d.gif" height="20" valign="middle"><a onclick="selectuser('st','user','st','stname');" title="选择人员" onmouseover="this.style.cursor='hand'">秘密抄送</a></td>
			    		<td width="700" align="left">
			    			<html:text property="stname" style="border: 1px none;color: 4c6a95;text-indent: 1pt;width: 70%;border: 1px solid #a5a5a5;" readonly="true" />
			    			<html:hidden property="st" />
			    		
			    		</td>
			    		<td class="bg-zwbt">
			    		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0"
								bordercolor="97cdda" class="tableborder">
			    			
			    			<tr>
			    				<td width="85"class="bg-zw"  align="center" height="20" valign="middle" background="<%=path%>/imagine/bt-d.gif">
			    					<a onclick="clearText('st')" title="清空" onmouseover="this.style.cursor='hand'">
										取消
									</a>
			    				</td>
			    			</tr>
			    		</table>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap width="80" height="25" align="center" class="bg-zwbt">主题</td>
			    		<td colspan="2" align="left">
			    			<html:text  property="subject" maxlength="100" style="border: 1px none;color: 4c6a95;text-indent: 1pt;width: 65%;border: 1px solid #a5a5a5;" ></html:text>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80" align="center" class="bg-zwbt">正文内容</td>
			    		<td colspan="2" align="left">
			    			<html:textarea style="border: 1px none;color: 4c6a95;text-indent: 1pt;width: 50%;border: 1px solid #a5a5a5;"  property="content" rows="3" cols="55" /><br/>
			    			<font color="red">内容描述长度不能大于250字符或文字 </font>
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td nowrap width="80" align="center" class="bg-zwbt">附件</td>
			    		<td colspan="2" align="left">
			    			<table id="tb"></table>
							<div id="divBtnAdd">
								<table>
									<tr class="bg-zwbt" >
									<td width="66" onclick="additem('tb')" onmouseover="this.style.cursor='hand'" align="center" height="21" background="<%=path%>/imagine/bt-d.gif">添加附件</td>
									</tr>
								</table>
								<font color="red">上传附件文件不能大于10M!</font>
							</div>
			    		</td>
			    	</tr>

				</thead>

				<thead class="bg-zwbt">
					<tr>
						<td colspan="3" align="center">
						
							<img src="<%=path%>/imagine/tj.gif" onclick="checkForm();" onmouseover="this.style.cursor='hand'">
						</td>
					</tr>
				</thead>
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
